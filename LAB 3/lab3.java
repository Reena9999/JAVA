import java.util.*;
import java.io.*;

public class lab3 {
    static int length = 0;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND= "\u001B[33m";
    public static void main(String args[]) {
        int[] arr = readArray();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nENTER EXIT TO STOP EXECUTING THIS PROGRAM\n\n");
        while (true) {
            System.out.println("Enter\n 1 to find the mean.\n 2 to find the median.\n 3 to find the mode.");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                break;
            } else {
                try {
                    int c = Integer.parseInt(choice);
                    switch (c) {
                        case 1:
                            double mean = Mean(arr);
                            System.out.println("\nMean: " + mean+"\n");
                            break;

                        case 2:
                            int median = Median(arr);
                            System.out.println("\nMedian: " + median+"\n");
                            break;

                        case 3:
                            int mode = Mode(arr);
                            System.out.println("\nMode: " + mode+"\n");
                            break;

                        default:
                            System.out.println("\n"+ANSI_RED_BACKGROUND+"Invalid Input!"+ANSI_RESET+"\n\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("\n"+ANSI_RED_BACKGROUND+"Enter only numbers"+ANSI_RESET+"\n\n");
                }
            }

        }
    }

    public static int[] readArray() {
        int[] arr = new int[1024];
        int c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter exit when cued to enter values to stop entering values in the array.");
        for (int i = 0;; i++) {
            System.out.print("\nEnter a value: ");
            String a = sc.nextLine();
            if (a.equalsIgnoreCase("exit")) {
                length = i;
                break;
            } else {
                try {
                    c = Integer.parseInt(a);
                    arr[i] = c;
                } catch (NumberFormatException e) {
                    System.out.println("Enter only numbers");
                }
            }
        }

        return arr;
    }

    public static double Mean(int arr[]) {
        double avg = 0.0;
        for (int i = 0; i < length; i++) {
            avg += arr[i];
        }
        return (avg / length);
    }

    public static int Median(int arr[]) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return (arr[(int) (length / 2)]);
    }

    public static int Mode(int arr[]) {
        int[] countArray = new int[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            countArray[i] = count;
            count = 0;
        }

        for (int a = 0; a < length; a++) {
            for (int b = a + 1; b < length; b++) {
                if (countArray[a] < countArray[b]) {
                    count = b;
                }
            }
        }

        return arr[count];
    }
}