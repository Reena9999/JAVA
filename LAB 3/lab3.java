//package for input output functions
import java.util.*;
//package to print only two decimal points
import java.text.DecimalFormat;

public class lab3 {
    /*creating a single variable that can be accessible to all fucntions that stores the number of non-zero
    elements in the array*/
    static int length = 0;

    //creating variables to beautify the output
    static String black = "\u001B[0m";
    static String red ="\u001b[31m";
    static String blue="\u001b[34m";
    static String green="\u001b[32m";

    //main function
    public static void main(String args[]) {
        //intializing array ans assigning the values entered by the user by calling the function readArray()
        int[] arr = readArray();
        
        Scanner sc = new Scanner(System.in);
        //letting the user know to type exit to leave the loop
        System.out.print(green+"\n\nENTER EXIT TO STOP EXECUTING THIS PROGRAM\n\n"+black);

        //creating an infite loop to continuously allow the user to redo the any of the actions listed below
        while (true) {
            System.out.println("Enter\n 1 to find the mean.\n 2 to find the median.\n 3 to find the mode.");

            //reading user's choice
            String choice = sc.nextLine();

            //checking if the user wants to stop execution of the program
            if (choice.equalsIgnoreCase("exit")) {
                System.out.print(green+"----------------------------\n            BYE!\n----------------------------\n"+black+"\n");
                break;
            } else {
                try {
                    //converting the string to integer
                    int c = Integer.parseInt(choice);
                    switch (c) {
                        case 1:
                            //call the mean function to generate the mean of the array
                            double mean = Mean(arr);
                            DecimalFormat df = new DecimalFormat("#.##");
                            System.out.println(blue+"----------------------------\n         Mean: " + df.format(mean)+"\n----------------------------\n"+black);
                            break;

                        case 2:
                            //call the Median function to generate the median of the array
                            int median = Median(arr);
                            System.out.println(blue+"----------------------------\n         Median: " + median+"\n----------------------------\n"+black);
                            break;

                        case 3:
                            //call the Mode function to generate the mode of the array
                            int mode = Mode(arr);
                            System.out.println(blue+"----------------------------\n         Mode: " + mode+"\n----------------------------\n"+black);
                            break;

                        default:
                            //display an error message for entering an invalid number
                            System.out.println("\n"+red+"----------------------------\n        Invalid Input!\n----------------------------\n"+black+"\n\n");
                    }
                } catch (NumberFormatException e) {
                    /**if the conversion from string to int throws an error, it implies that the entered value was not an
                    integer. Therefore, we used try catch to catch these errors and display an appropriate message **/
                    System.out.print(red+"----------------------------\n     Enter only numbers\n----------------------------\n"+black+"\n");
                }
            }

        }
    }

    //function to read elements of an array
    public static int[] readArray() {
        int[] arr = new int[1024];
        int c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(green+"\nEnter exit when cued to enter values to stop entering values in the array."+black);
        for (int i = 0;; i++) {
            System.out.print("\nEnter a value: ");
            String a = sc.nextLine();
            //checking if the user wants to exit or stop entering values
            if (a.equalsIgnoreCase("exit")) {
                length = i;
                break;
            } else {
                try {
                    /*converting the user input to interger. If this conversion throws and error, it implies the user entered
                     * a value that is not an integer. To handle the situation we use the try catch.*/
                    c = Integer.parseInt(a);
                    arr[i] = c;
                } catch (NumberFormatException e) {
                    /**displaying an appropriate error message when the user does not enter an integer */
                    System.out.print(red+"----------------------------\n     Enter only numbers\n----------------------------\n"+black+"\n");
                    i-=1;
                }
            }
        }

        //returning the newly created array
        return arr;
    }

    //function that generates the mean of the array passed as parrameters
    public static double Mean(int arr[]) {
        double avg = 0.0;
        for (int i = 0; i < length; i++) {
            avg += arr[i];
        }
        //returning the average of the array as a double value
        return (avg / length);
    }

    //function that generates the median
    public static int Median(int arr[]) {
        //sorting the array recieved through parameters
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        /*The middle element of the sorted array is the median. Therefore, we sorted the array
         * and return the middle value*/
        return (arr[(int) (length / 2)]);
    }


    //function that generates the last most occuring element
    public static int Mode(int arr[]) {
        /*creating an array the size of the total number of non-zero elements and storing the 
         * count of each element based corresponding to their indexes*/
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

        //finding the max count value from countArray
        for (int a = 0; a < length; a++) {
            for (int b = a + 1; b < length; b++) {
                if (countArray[a] < countArray[b]) {
                    count = b;
                }
            }
        }
        //returning the value in the array received through the parameters based on the index of the maximum
        //value of count
        return arr[count];
    }
}