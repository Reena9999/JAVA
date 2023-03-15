import java.util.*;
import java.io.*;

public class lab5 {
    String[] RegisterNumber, StudentName, StudentEmail, StudentMobile, StudentClass, StudentDepartment;
    int count = 0;

    public static void main(String[] args) {
        lab5 obj = new lab5();
        System.out.println("Enter Exit to execution");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter\n1. To Add a student\n2. To search of a student\n3.Display all students");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                break;
            } else {
                int ch = Integer.parseInt(choice);
                switch (ch) {
                    case 1:
                        obj.addStudent();
                        break;

                    case 2:
                        obj.searchStudent();
                        break;

                    case 3:
                        obj.displayStudent();
                        break;

                    default:
                        System.out.println("Invalid input");
                }
            }
        }
    }

    lab5() {
        RegisterNumber = new String[100];
        StudentName = new String[100];
        StudentEmail = new String[100];
        StudentMobile = new String[100];
        StudentClass = new String[100];
        StudentDepartment = new String[100];
    }

    void addStudent() {
        String name, reg, email, phone, clss, department;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your name: ");
            name = sc.nextLine();
            if (!(name.isEmpty()) && (isDigit(name))) {
                break;
            }
        }
        while (true) {
            System.out.print("Enter your register number: ");
            reg = sc.nextLine();
            if (checkReg(reg)) {
                break;
            }
        }
        while (true) {
            System.out.print("Enter your email id: ");
            email = sc.nextLine();
            if (checkEmail(email)) {
                break;
            }
        }
        while (true) {
            System.out.print("Enter your phone number: ");
            phone = sc.nextLine();
            if (checkPhone(phone)) {
                break;
            }
        }
        while (true) {
            System.out.print("Enter your class: ");
            clss = sc.nextLine();
            if (checkClass(clss)) {
                break;
            }
        }
        System.out.print("Enter your department: ");
        department = sc.nextLine();

        if (count < 100) {
            RegisterNumber[count] = reg;
            StudentName[count] = name;
            StudentEmail[count] = email;
            StudentMobile[count] = phone;
            StudentClass[count] = clss;
            StudentDepartment[count] = department;

            count += 1;

            System.out.println("Enter 1 if you wish to store details in a file: ");
            int m=sc.nextInt();
            if(m==1){
                try{
                    String filename=name+".txt";
                    File file=new File(filename);
                    if(file.createNewFile()){
                        FileWriter wr=new FileWriter(file,true);
                        wr.write(name+"\n");
                        wr.write(reg+"\n");
                        wr.write(email+"\n");
                        wr.write(phone+"\n");
                        wr.write(clss+"\n");
                        wr.write(department+"\n");
                        wr.close();
                    }

                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
        else{
            System.out.println("no more memory space available");
        }
    }

    void displayStudent() {
        System.out.println("All students in our database: ");
        for (int i = 0; i < count; i++) {
            System.out.println(StudentName[i]);
        }
    }

    void searchStudent() {

    }

    public boolean isDigit(String name) {
        for (int i = 0; i < name.length(); i++) {
            char a = name.charAt(i);
            if (Character.isDigit(a)) {
                return false;
            } else if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkReg(String reg) {
        if (reg.length() > 8 || reg.length() < 8) {
            System.out.println("Invalid Register number");
            return false;
        } else if (reg.length() == 8) {
            for (int i = 0; i < reg.length(); i++) {
                char a = reg.charAt(i);
                if (!Character.isDigit(a)) {
                    return false;
                } else if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkEmail(String email) {
        int at = 0;
        if (email.substring(email.length() - 19).equalsIgnoreCase("christuniversity.in")) {
            for (int i = 0; i < email.length() - 19; i++) {
                char a = email.charAt(i);
                if (Character.isDigit(a)) {
                    return false;
                } else if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                    String ab = String.valueOf(a);
                    if (!ab.equals("@")) {
                        at = i;
                        return false;
                    }
                }
            }
        } else if (!email.substring(at, email.length() - 20).equalsIgnoreCase("msds")) {
            return false;
        } else if (!email.substring(email.length() - 19).equalsIgnoreCase("christuniversity.in")) {
            return false;
        }
        return true;
    }

    public boolean checkPhone(String phone) {
        if (phone.length() == 10) {
            for (int i = 0; i < phone.length(); i++) {
                char a = phone.charAt(i);
                if (!Character.isDigit(a)) {
                    return false;
                } else if (!Character.isDigit(a) && !Character.isLetter(a) && !Character.isWhitespace(a)) {
                    return false;
                }
            }
        } else if (phone.length() != 10) {
            return false;
        }
        return true;
    }

    public boolean checkClass(String clss) {
        if (!clss.substring(0, 1).equalsIgnoreCase("1") || !clss.substring(0, 1).equalsIgnoreCase("2")
                || !clss.substring(0, 1).equalsIgnoreCase("3") || !clss.substring(0, 1).equalsIgnoreCase("4")) {
            return false;
        }
        return true;
    }
}
