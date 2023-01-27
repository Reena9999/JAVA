import java.util.*;

public class LAB_1 {
    public static void main(String args[]) {
        // creating the scanner object to read data from the user
        Scanner sc = new Scanner(System.in);

        // READING INPUT FROM USER
        // reading user's name
        System.out.print("Enter your name: ");
        String Name = sc.nextLine();

        // reading student's register number
        System.out.print("Enter your register Number: ");
        long RegisterNumber = Long.parseLong(sc.nextLine());

        // reading the age from the user
        System.out.print("Enter your age: ");
        int Age = sc.nextInt();

        // validating age values enter by the user
        while (true) {
            if ((Age > 0) && (Age < 100)) {
                break;
            } else {
                System.out.print("Invaild age input.\nEnter the right age: ");
                Age = sc.nextInt();
            }
        }

        // reading gender value
        System.out.print("Enter your prefferd gender identification as m of f: ");
        char gender = sc.next().charAt(0);

        // validating user input for the gender choosen
        while (true) {
            if ((Character.toLowerCase(gender) == 'f') || (Character.toLowerCase(gender) == 'm')) {
                break;
            } else {
                System.out.print("Unavailable gender association.\nEnter your gender: ");
                gender = sc.next().charAt(0);
            }
        }

        // reading state of residence
        String state = sc.nextLine();
        System.out.print("Enter your state of residency: ");
        state = sc.nextLine();
        String s=state.toLowerCase();

        // validating the user's input
        while (true) {
            if (s.equals("andhra pradesh") 
                    || s.equals("karnataka")
                    || s.equals("kerala")
                    || s.equals("tamil nadu")
                    || s.equals("goa")
                    || s.equals("telangana")
                    || s.equals("uttar pradesh")
                    || s.equals("rajastan")
                    || s.equals("sikkim")
                    || s.equals("haryana")
                    || s.equals("delhi")
                    || s.equals("odisha")
                    || s.equals("himachal pradesh")
                    || s.equals("arunachal pradesh")
                    || s.equals("bihar")
                    || s.equals("uttarakhand")
                    || s.equals("nagaland")
                    || s.equals("gujarat")
                    || s.equals("manipur")
                    || s.equals("meghalaya")
                    || s.equals("west bengal")) {
                break;
            } else {
                System.out.print("Invalid state.\nEnter your state of residency: ");
                state= sc.nextLine();
                s=state.toLowerCase();
            }
        }

        System.out.println("===================================================================");
        System.out.println("                         PERSONAL DETAILS                          ");
        System.out.println("===================================================================");

        System.out.print("Name: " + Name + "\nRegister Number: " + RegisterNumber + "\nAge: " + Age);
        if (Character.toLowerCase(gender) == 'f') {
            System.out.println("\nGender: FEMALE");
        } else {
            System.out.println("\nGender: MALE");
        }

        switch (state.toLowerCase()) {
            case "andhra pradesh":
            case "karnataka":
            case "kerala":
            case "tamil nadu":
            case "goa":
            case "telangana":
                System.out.println("The Student is from the southern states of India");
                break;

            case "uttar pradesh":
            case "haryana":
            case "himachal pradesh":
            case "uttarakhand":
            case "manipur":
            case "rajastan":
            case "delhi":
                System.out.println("The Student is from the northern states of India");
                break;

            case "arunachal pradesh":
            case "nagaland":
            case "meghalaya":
            case "sikkim":
            case "odisha":
            case "bihar":
                System.out.println("The Student is from the eastern states of India");
                break;

            case "gujarat":
            case "west bengal":
                System.out.println("The Student is from the eastern states of India");
                break;
        }
        System.out.println("===================================================================");


    }

}