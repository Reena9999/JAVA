import java.util.*;
import java.io.*;

public class lab5 {

    //Creating arrays to store student regist numbers, name,email ids, phone number, class and the department
    lab5[] arr=new lab5[100] ;
    String RegisterNumber,StudentName,StudentEmail,StudentMobile,StudentClass,StudentDepartment;
    //counter to maintain the number of students in the array
    int count = 0;

    //main function
    public static void main(String[] args) {
        lab5 obj=new lab5();
        //welcome message
        System.out.println("=========================================================");
        System.out.println("                          WELCOME");
        System.out.println("=========================================================");
        System.out.println("                   Enter Exit to execution");
        System.out.println("---------------------------------------------------------");

        //creting the scanner object
        Scanner sc = new Scanner(System.in);

        //infinte loop that stops executing when the user enters exit when prompted to enter a choice
        while (true) {
            //displaying available functions the user can perform
            System.out.println("Enter\n1. To Add a student\n2. To search of a student\n3. Display all students");
            String choice = sc.nextLine();
            System.out.println("---------------------------------------------------------");

            //checking if the input was exit to leave the loop
            if (choice.equalsIgnoreCase("exit")) {
                System.out.println( "                         BYE");
                System.out.println("---------------------------------------------------------");
                break;
            } else {
                //convert the choice to integer
                int ch = Integer.parseInt(choice);

                //switch case
                switch (ch) {
                    case 1:
                        //add new students to the array
                        obj.addStudent();
                        break;

                    case 2:
                        // search for a register number in the array
                        System.out.print("Enter the the register number you wish to search in the database: ");
                        String reg = sc.nextLine();
                        //checking if the register number is valid or not
                        if (obj.checkReg(reg)) {
                            boolean m = obj.searchStudent(reg);
                        }
                        else{
                            System.out.println("Please enter a valid register number to search");
                        }
                        break;

                    case 3:
                        //display all the students in the array
                        obj.displayStudent();
                        break;

                    default:
                        //if the user were to enter any other value other than the options provided displa an appropriate error message
                        System.out.println("Invalid input");
                }
            }
        }
    }

    //constructor to initialize the arrays that will be used throughout the program
    lab5(String reg,String name,String email,String phone,String clss, String dep) {
        RegisterNumber = reg;
        StudentName = name;
        StudentEmail = email;
        StudentMobile = phone;
        StudentClass = clss;
        StudentDepartment = dep;
    }

    lab5(){

    }

    //function that reads student details, validates the input and then adds it to the array
    void addStudent() {
        String name, reg, email, phone, clss, department;
        Scanner sc = new Scanner(System.in);
        //this loop will execute until the user enter a valid input
        while (true) {
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            //validating if the input is empty or contains digits
            if (!(name.isEmpty()) && (isDigit(name))) {
                break;
            }
        }
        //this loop will execute until the user enter a valid input
        while (true) {
            System.out.print("Enter your register number: ");
            reg = sc.nextLine();
            //validating if the register number is valid
            if (checkReg(reg)) {
                break;
            }
        }  
        //this loop will execute until the user enter a valid input
        while (true) {
            System.out.print("Enter your email id: ");
            email = sc.nextLine();
            //validating if the email is a christ id and if it is valid
            if (checkEmail(email)) {
                break;
            }
        }
        //this loop will execute until the user enter a valid input
        while (true) {
            System.out.print("Enter your phone number: ");
            phone = sc.nextLine();
            //validating phone nuber
            if (checkPhone(phone)) {
                break;
            }
        }
        //this loop will execute until the user enter a valid input
        while (true) {
            System.out.print("Enter your class: ");
            clss = sc.nextLine();
            //validating if the semester is with the range of 1 to 4.
            if (checkClass(clss)) {
                break;
            }
        }
        System.out.print("Enter your department: ");
        department = sc.nextLine();

        //validating if there are less than 100 element to avoid IndexOutOfBound error
        if (count < 100) {
            arr[count]=new lab5(reg,name,email,phone,clss,department);
           
            //incrementing the count to indicate a new student has been added to the database
            count += 1;

            //asking the user if they would like to store that students details in a file
            System.out.println("---------------------------------------------------------");
            System.out.println("Enter 1 if you wish to store details in a file: ");
            int m = sc.nextInt();
            System.out.println("---------------------------------------------------------");
            //1 indicates the user would like to create the file with the students data is stored
            if (m == 1) {
                try {
                    //creating the file name with the register number
                    String filename = reg + ".txt";
                    //creating a file
                    File file = new File(filename);
                    //creating the file and checking if it has been created
                    if (file.createNewFile()) {
                        //creating a file writer object to write data into a file
                        FileWriter wr = new FileWriter(file, true);
                        wr.write(name + "\n");
                        wr.write(reg + "\n");
                        wr.write(email + "\n");
                        wr.write(phone + "\n");
                        wr.write(clss + "\n");
                        wr.write(department + "\n");
                        wr.close();
                        //message acknowleging the creation of the file
                        System.out.println("              FILE SUCCESSFULLY CREATED");
                        System.out.println("---------------------------------------------------------");
                    }
                } 
                //handling errors that occur when creating files
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } else {
            //message to indicate the MemoryOutOfBoundException
            System.out.println("no more memory space available");
        }
    }

    //function to display all the names of students in the database
    void displayStudent() {
        System.out.println("=========================================================");
        System.out.println("          All students in our database: ");
        System.out.println("=========================================================");
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i].StudentName);
        }
        System.out.println("=========================================================\n");

    }

    //function to search for a register number and display the student's name
    boolean searchStudent(String regNumber) {
        for (int i = 0; i < count; i++) {
            //condition to satisfy
            if (arr[i].RegisterNumber.equalsIgnoreCase(regNumber)) {
                System.out.println(arr[i].StudentName + " is the student you are looking for");
                System.out.println("---------------------------------------------------------");
                return true;
            }
        }
        //message to display when the register number is not found
        System.out.println("\n"+regNumber + " is not found in the database");
        System.out.println("---------------------------------------------------------");
        return false;
    }

    //function to check if there are digits in the name
    public boolean isDigit(String name) {
        //loop to check if every character is only an alphabet
        for (int i = 0; i < name.length(); i++) {
            char a = name.charAt(i);
            //checking for digits
            if (Character.isDigit(a)) {
                System.out.println("\nName cannot include digits\n");
                return false;
            } 
            //checking for special characters
            else if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                System.out.println("\nName cannot include special characters\n");
                return false;
            }
        }
        return true;
    }

    //function to validate the register number
    public boolean checkReg(String reg) {
        //the register number has only eight digits
        if (reg.length() > 8 || reg.length() < 8) {
            System.out.println("\nInvalid Register number\n");
            return false;
        } else if (reg.length() == 8) {

            for (int i = 0; i < reg.length(); i++) {
                char a = reg.charAt(i);
                //checking for special characters, alphabets and spaces in the register number
                if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                    return false;
                }
            }
        }
        return true;
    }

    //function to validate the email
    public boolean checkEmail(String email) {
        int at = 0;
        //ensuring that the email id contains 'christuniversity.in'
        if (email.substring(email.length() - 19).equalsIgnoreCase("christuniversity.in")) {
            for (int i = 0; i < email.length() - 19; i++) {
                char a = email.charAt(i);
                //ensuring the email does not contain any numbers
                if (Character.isDigit(a)) {
                    System.out.println("\nUniversity Email ID does not contain any numbers. Please enter a valid input.\n");
                    return false;
                } 
                //ensuring the email does not have any special characters other than '@' and '.'
                else if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                    String ab = String.valueOf(a);
                    if (ab.equals("@")) {
                        at = i;
                    } else if (!ab.equals(".")) {
                        System.out.println("\nUniversity email ID does not include special characters other than @ and .\n");
                        return false;
                    }
                }
            }
            //this condition is only to check for the data science department
            //it can be modified to include other departments
            if (!email.substring(at+1, email.length() - 20).equalsIgnoreCase("msds")) {
                System.out.println("\nCannot find the department specified.\n");
                return false;
    
            } 
        }
        //display an appropriate message when the email does not contain 'christuniversity.in'
        else if (!email.substring(email.length() - 19).equalsIgnoreCase("christuniversity.in")) {
            System.out.println("\nInvalid domain in email\n");
            return false;
        }
        return true;
    }

    //function to validate the phone number 
    public boolean checkPhone(String phone) {
        //ensuring the length of the phone number is ten
        if (phone.length() == 10) {
            for (int i = 0; i < phone.length(); i++) {
                char a = phone.charAt(i);
                //ensuring the phone number does not contain alphbets
                if (!Character.isDigit(a)) {
                    System.out.println("\nPhone number can include only digts\n");
                    return false;
                } 
                //ensuring the phone number does not contain special characters
                else if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                    System.out.println("\nPhone number cannot include special characters\n");
                    return false;
                }
            }
        } 
        //display an appropriate message if the number of digit is not 10
        else if (phone.length() != 10) {
            System.out.println("\nRequired 10 digits in the phone number\n");
            return false;
        }
        return true;
    }

    //function to validate the class
    public boolean checkClass(String clss) {
        //retreiving the semester 
        //class is written as semester-course-section
        String a=clss.substring(0, 1);
        if (Integer.parseInt(a) <= 4 && Integer.parseInt(a) >=1) {
            return true;
        }
        //displaying an appropriate error message
        System.out.println("\nInvalid Semester\n");
        return false;
    }
}
