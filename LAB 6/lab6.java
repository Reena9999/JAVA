import java.util.*;
import java.io.*;

public class lab6 {
    public static void main(String args[]) {

        try {
            File file = new File("text.txt");
            if (!file.exists()) {
                System.out.println("Cannot find the file");
            } else {
                int[][] vowelCount = countVowels(file);

                System.out.println("\n---------------------------------------------");
                System.out.println("\t\tVowel Count");
                System.out.println("---------------------------------------------");

                display(vowelCount, 0);
                System.out.println("---------------------------------------------");

                int[][] digitCount = countDigits(file);

                System.out.println("\n---------------------------------------------");
                System.out.println("\t\tDigit Count");
                System.out.println("---------------------------------------------");
                display(digitCount, 1);
                System.out.println("---------------------------------------------");

                int[][] topRepeatingCharacters = RepeatingCharacters(file);

                System.out.println("\n---------------------------------------------");
                System.out.println("\tMost occuring characters");
                System.out.println("---------------------------------------------");
                for (int i = 0; i < 5; i++) {
                System.out.println("\t\t"+(char) topRepeatingCharacters[0][i] + "\t:\t" +
                topRepeatingCharacters[1][i]);
                }
                System.out.println("---------------------------------------------\n");

                System.out.println("\n---------------------------------------------");
                System.out.println("\tLeast occuring characters");
                System.out.println("---------------------------------------------");
                for (int i = 25; i >=20; i--) {
                System.out.println("\t\t"+(char) topRepeatingCharacters[0][i] + "\t:\t" +
                topRepeatingCharacters[1][i]);
                }
                System.out.println("---------------------------------------------\n");

                RepeatingWords(file);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int[][] countVowels(File file) {
        int[][] vowel = { { 97, 101, 105, 111, 117 }, { 0, 0, 0, 0, 0 } };
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String a = sc.nextLine();
                a = a.toLowerCase();
                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < a.length(); i++) {
                        if ((int) a.charAt(i) == vowel[0][j]) {
                            vowel[1][j] += 1;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return vowel;
    }

    public static int[][] countDigits(File file) {
        int[][] digits = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String a = sc.nextLine();
                for (int j = 0; j < 10; j++) {
                    for (int i = 0; i < a.length(); i++) {
                        if (Character.isDigit(a.charAt(i))) {
                            if (Integer.parseInt(String.valueOf(a.charAt(i))) == digits[0][j]) {
                                digits[1][j] += 1;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return digits;
    }

    public static int[][] RepeatingCharacters(File file) {
        int[][] character = new int[2][26];
        int c = 97;
        for (int i = 0; i < 26; i++) {
            character[0][i] = c;
            c += 1;
        }

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String a = sc.nextLine();
                a = a.toLowerCase();
                int count = 97;
                for (int j = 0; j < 26; j++) {
                    for (int i = 0; i < a.length(); i++) {
                        if ((int) a.charAt(i) == count) {
                            character[1][j] += 1;
                        }
                    }
                    count += 1;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < character[0].length; i++) {
            int index = i;
            for (int j = (i + 1); j < character[0].length; j++) {
                if (character[1][j] > character[1][index]) {
                    index = j;
                }
            }
            int ascii = character[0][index];
            int count = character[1][index];
            character[0][index] = character[0][i];
            character[1][index] = character[1][i];
            character[0][i] = ascii;
            character[1][i] = count;
        }
        return character;
    }

    public static void RepeatingWords(File file) {
        String[] wordsArray = uniqueWords(file);
        int[] wordCount = new int[wordsArray.length];
        String s = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String a = sc.nextLine();
                a = a.toLowerCase();
                for (int i = 0; i < a.length(); i++) {
                    if ((int) (a.charAt(i)) == 32 || (int) (a.charAt(i)) == 44 || (int) (a.charAt(i)) == 46) {
                        if (!s.isEmpty()) {
                            int x = findIndex(s, wordsArray);
                            wordCount[x] += 1;
                            s = "";
                        }

                    } else {
                        s += String.valueOf(a.charAt(i));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < wordCount.length; i++) {
            int index = i;
            for (int j = (i + 1); j < wordCount.length; j++) {
                if (wordCount[j] > wordCount[index]) {
                    index = j;
                }
            }
            String word = wordsArray[index];
            int count = wordCount[index];
            wordsArray[index] = wordsArray[i];
            wordCount[index] = wordCount[i];
            wordsArray[i] = word;
            wordCount[i] = count;
        }

        System.out.println("\n---------------------------------------------\n");
        System.out.println("\n\tFive most occurring Words");
        System.out.println("\n---------------------------------------------\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("\t"+wordsArray[i] + "\t:\t" + wordCount[i]);
        }
        System.out.println("\n---------------------------------------------\n");

        System.out.println("\n---------------------------------------------\n");
        System.out.println("\n\tLeast five occurring Words");
        System.out.println("\n---------------------------------------------\n");
        for (int i = wordsArray.length-2; i> (wordsArray.length-7); i--) {
            System.out.println("\t"+wordsArray[i] + "\t:\t" + wordCount[i]);
        }
        System.out.println("\n---------------------------------------------\n");
    }

    public static String[] uniqueWords(File file) {
        String[] words = new String[10000];
        int count = 0;
        String s = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String a = sc.nextLine();
                a = a.toLowerCase();
                for (int i = 0; i < a.length(); i++) {
                    if ((int) (a.charAt(i)) == 32 || (int) a.charAt(i) == 44 || (int) (a.charAt(i)) == 46) {
                        if (!s.isEmpty()) {
                            if (IsUnique(s, count, words)) {
                                words[count] = s;
                                s = "";
                                count += 1;
                            } else {
                                s = "";
                            }
                        }
                    } else {
                        s += String.valueOf(a.charAt(i));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        String[] words2 = new String[count + 1];
        for (int i = 0; i <= count; i++) {
            words2[i] = words[i];
        }
        return words2;
    }

    public static boolean IsUnique(String a, int count, String[] words) {
        int m = 0;
        for (int i = 0; i <= count; i++) {
            if (a.equalsIgnoreCase(words[i])) {
                m = m + 1;
            }
        }
        if (m == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int findIndex(String s, String[] words) {
        int x = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.equalsIgnoreCase(words[i])) {
                x = i;
            }
        }
        return x;
    }

    public static void display(int[][] a, int m) {
        for (int i = 0; i < a[0].length; i++) {
            if (m == 0) {
                System.out.println("\t\t"+(char) a[0][i] +  "\t:\t" + a[1][i]);
            } else {
                System.out.println("\t\t"+a[0][i] +  "\t:\t" + a[1][i]);
            }
        }
    }
}
