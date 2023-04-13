import java.io.*;
import java.util.*;

public class lab7 {
    public static void main(String args[]) {
        int count = 0;
        // variable to store the number of rows and columns in the csv file
        int rows = 0, columns = 0;

        try {
            // reading the contents of the file
            File file = new File("Iris.csv");
            Scanner sc = new Scanner(file);

            // while there is content in the file
            while (sc.hasNext()) {

                // iterating through each line in the csv file
                String a = sc.nextLine();
                if (count == 0) {
                    // finding the column count by splitting the current line into an array of words
                    // and finding the length of the newly created array
                    columns = a.split(",").length;
                }
                // counting the number of times the loop run to identify the row count
                count += 1;
            }
            rows = count;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // creating a 2D array of strings with the content of the csv file by using
        // createColumns function
        String fileContent[][] = createColumns(rows, columns);

        // GENERATING GENERAL STATISTICS FOR THE ENTIRE CSV FILE CONTENT
        printHeading("GENERAL DESC");

        // iterate from 1 to (number of columns-1) because the first column is the
        // indexes and the last column is the types,
        // both of which can have no statistical inferences from
        for (int j = 1; j < (fileContent[0].length) - 1; j++) {

            // creating an array with row count being one less than the actual number of
            // rows to account for the first row
            // which is the column names
            float[] temporaryArray = new float[fileContent.length - 1];
            count = 0;

            // iterate from 1 to row count because the first row contains names of the
            // columns
            for (int i = 1; i < fileContent.length; i++) {

                // converting the string values to float and storing it in the temporaryArray
                temporaryArray[count] = Float.parseFloat(fileContent[i][j]);
                count += 1;
            }

            // calling general function to generate the general statistics by passing the
            // entire columns are the parameters
            WriteContentToFile(temporaryArray, fileContent[0][j]);
        }

        // IDENTIFYING THE INDEXES OF THE LAST OCCURANCE OF EACH FLOWER TYPE
        // create an array to store the indexes
        int[] indexes = new int[3];

        // iterate through the elements of the last column in the 2D array
        for (int i = 1; i < fileContent.length; i++) {
            // check if the string contains "setosa" or "versicolor" or "virginica" and
            // update the 0th, 1st, or 2nd element of 'indexes' respectively
            // to store the index of the current value if the condition is satisfied.
            if (fileContent[i][5].contains("setosa")) {
                indexes[0] = i;
            } else if (fileContent[i][5].contains("versicolor")) {
                indexes[1] = i;
            } else if (fileContent[i][5].contains("virginica")) {
                indexes[2] = i;
            }
        }

        // GENERATE CLASS WISE STATISTICS
        count = 0;
        int indexCount = 0, max = 0;

        // creating four arrays for each attribute of the dataset
        float[] SepalLengthCm = new float[(indexes[indexCount])];
        float[] SepalWidthCm = new float[(indexes[indexCount])];
        float[] PetalLengthCm = new float[(indexes[indexCount])];
        float[] PetalWidthCm = new float[(indexes[indexCount])];

        // iterating only through SepalLengthCm,SepalWidthCm, PetalLengthCm,PetalWidthCm row values
        for (int i = 1; i < fileContent.length; i++) {
            if (count == indexes[indexCount] - 1) {
                if (indexCount < indexes.length) {
                    //Sending the flower type to print as the heading
                    printHeading(fileContent[indexes[indexCount]][5]);

                    //generating and writing the statistics into the file
                    SepalLengthCm[(count - max)] = Float.parseFloat(fileContent[i][1]);
                    WriteContentToFile(SepalLengthCm, fileContent[0][1]);

                    SepalWidthCm[(count - max)] = Float.parseFloat(fileContent[i][2]);
                    WriteContentToFile(SepalWidthCm, fileContent[0][2]);

                    PetalLengthCm[(count - max)] = Float.parseFloat(fileContent[i][3]);
                    WriteContentToFile(PetalLengthCm, fileContent[0][3]);

                    PetalWidthCm[(count - max)] = Float.parseFloat(fileContent[i][4]);
                    WriteContentToFile(PetalWidthCm, fileContent[0][4]);

                    count += 1;
                    indexCount++;
                    max = indexes[indexCount - 1];
                    try {
                        SepalLengthCm = new float[(indexes[indexCount] - indexes[indexCount - 1])];
                        SepalWidthCm = new float[(indexes[indexCount] - indexes[indexCount - 1])];
                        PetalLengthCm = new float[(indexes[indexCount] - indexes[indexCount - 1])];
                        PetalWidthCm = new float[(indexes[indexCount] - indexes[indexCount - 1])];
                    } catch (Exception e) {
                        break;
                    }

                }
            } else {
                //extracting only the elements belonging to one class 
                SepalLengthCm[(count - max)] = Float.parseFloat(fileContent[i][1]);
                SepalWidthCm[(count - max)] = Float.parseFloat(fileContent[i][2]);
                PetalLengthCm[(count - max)] = Float.parseFloat(fileContent[i][3]);
                PetalWidthCm[(count - max)] = Float.parseFloat(fileContent[i][4]);
                count += 1;
            }
        }

        displayOutput();
    }

    /**
     * FUNCTION TO CREATE A 2 DIMENSIONAL ARRAY OF STRINGS TO STORE THE VALUES IN
     * THE CSV FILE
     * 
     * Function iterates through every line in the file. Each line is split with the
     * delimitter as "," because we are working with a csv file.
     * The string values that are obtained from splitting the current line are
     * stored in an array 'temporyArray'.
     * The values of the 'temporyArray' are then copied to a 2 dimensional array
     * 'fileContent', row wise.
     * 
     * @param rows:    number of rows that are there in the csv file
     * @param columns: number of columns in the csv file
     * @return return a 2 dimensional array of strings that contains the contents of
     *         the file
     */
    public static String[][] createColumns(int rows, int columns) {
        int count = 0;
        String currentLine = "";

        String fileContents[][] = new String[rows][columns];

        try {
            File file = new File("Iris.csv");
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                currentLine = sc.nextLine();
                String temporyArray[] = currentLine.split(",");
                for (int i = 0; i < temporyArray.length; i++) {
                    if (count < rows) {
                        fileContents[count][i] = temporyArray[i];
                    }
                }
                count += 1;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return fileContents;
    }

    /**
     * FUNCTION TO FIND THE MEAN OF AN ARRAY OF FLOAT VALUES
     * 
     * Function iterates through the elements of the array and cumulates the value
     * of each element in the variable sum.
     * The total sum divided by the length of the array i.e., the number of
     * variables in the array will produce the average.
     * 
     * @param array of float values
     * @return float value i.e., the mean
     */
    public static float mean(float array[]) {
        float sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (sum / array.length);
    }

    /**
     * FUNCTION TO FIND THE MEDIAN FROM AN ARRAY
     * 
     * In an array sorted in ascending order the middle value is the median.
     * Therefore, this function uses the SORT function to first sort the array and
     * then return the middle value.
     * 
     * @param array of float values
     * @return float value i.e., the median
     */
    public static float median(float array[]) {
        return (sort(array)[(array.length / 2)]);
    }

    /**
     * FUNCTION TO FIND THE MODE FROM THE VALUES IN AN ARRAY
     * 
     * The function begins with initializing mode and maxCount as zero.
     * Starting from the first value in the array we count the number of occurances
     * of that variable. If the count of the current variable is greater than
     * maxCount then maxCount becomes the count
     * of the current variable and mode is initialized as the current variable that
     * is being compared.
     * 
     * @param array of float values
     * @return float value i.e., mode
     */
    public static float mode(float array[]) {
        int maxCount = 0;
        float mode = 0;
        for (int i = 0; i < array.length; i++) {
            int c = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    c++;
                }
            }
            if (c > maxCount) {
                maxCount = c;
                mode = array[i];
            }
        }

        return mode;
    }

    /**
     * FUNCTION TO FIND THE MIMIMUM AND MAXIMUM VALUE IN AN ARRAY
     * 
     * The function uses the SORT function to first sort the array.
     * In an array sorted in ascending array the first element is the least value in
     * the entire array and the last element is the maximum value.
     * 
     * @param array of float values
     * @return array of dimensions 1x2 where the first element is the minimum value
     *         and the second element is the maximum value in the array
     */
    public static float[] minMax(float array[]) {
        float minMax[] = new float[2];
        array = sort(array);
        minMax[0] = array[0];
        minMax[1] = array[array.length - 1];
        return minMax;
    }

    /**
     * FUNCTION TO SORT AN ARRAY
     * 
     * The function implements Bubble_Sort to sort a float array.
     * 
     * @param array of float values to sort
     * @return the sorted array
     */
    public static float[] sort(float array[]) {
        float temp = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * FUNCTION TO WRITE THE STATISTICAL OUTPUTS TO A FILE
     * 
     * Function recieves an array, calls the functions to calculate
     * mean,median,mode, minimium value and maximum value,
     * then writes it into the file 'output'.
     * 
     * @param array      of float values
     * @param columnName
     */
    public static void WriteContentToFile(float[] array, String columnName) {
        float[] MINMAX = minMax(array);
        try {
            File file = new File("output.txt");
            FileWriter writer = new FileWriter(file, true);

            writer.write(columnName + "\t\t" + mean(array) + "\t" + median(array) + "\t\t\t" + mode(array) + "\t\t\t"
                    + MINMAX[0] + "\t\t\t" + MINMAX[1] + "\n");
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * FUNCTION TO WRITE HEADINGS WITH FORMATTING
     * 
     * Function writes the heading into the file 'output'
     * 
     * @param heading: a string containing contents of the heading
     */
    public static void printHeading(String heading) {
        try {
            File file = new File("output.txt");
            FileWriter writer = new FileWriter(file, true);

            writer.write(
                    "\n\n--------------------------------------------------------------------------------------\n");
            writer.write("                                 " + heading + "\n");
            writer.write("--------------------------------------------------------------------------------------\n");
            writer.write("\t\t\t\t\tMean\t\tMedian\t\tMode\t\tMin\t\tMax\n");
            writer.write("--------------------------------------------------------------------------------------\n");

            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * FUNCTION TO READ THE CONTENTS OF THE FILE 'OUTPUT' AND DISPLAY IT.
     * 
     * Function reads the fully created file 'output' and displays its contents.
     */
    public static void displayOutput() {
        try {
            File file = new File("output.txt");
            Scanner object = new Scanner(file);

            while (object.hasNext()) {
                System.out.println(object.nextLine());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}