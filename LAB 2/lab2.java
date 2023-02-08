import java.util.*;

public class lab2 {
    static String[] name = new String[50];
    static int length = 0;

    public static void main(String args[]) {
        String yes = "y";
        int n = 0;
        int choice=0;

        // creating the scanner object to read data from the user
        Scanner sc = new Scanner(System.in);

        //creating an inital array
        for (int i = 0; i < 10; i++) {
            readName();
        }

        do {
            // DISPLAYING CHOICE FOR THE USER
            System.out.println(
                    "Enter: \n 1 for Entering a name in the list.\n 2 to search for a name in the list.\n 3 to remove a name from the list.\n 4 to display all the names in the list.");

            // READING INPUT FROM USER
            // reading user's name
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    readName();
                    n += 1;
                    break;

                case 2:
                    searchName();
                    break;

                case 3:
                    removeName();
                    n -= 1;
                    break;

                case 4:
                    displayName();
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.println("Enter y to continue process");
            yes = sc.nextLine();
        } while (yes.equalsIgnoreCase("y") && (n < 50));

    }

    // function to read Names and create an array
    public static void readName() {
        System.out.println("Enter the name you wish to add: ");
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String an = sc.nextLine();

        if (name.length == 0) {
            name[0] = an;
        } else {
            for (int i = 0; i < 50; i++) {
                if (name[i] == null) {
                    if (count == 0) {
                        name[i] = an;
                        count = 0;
                    }
                    break;
                } else if (name[i].equalsIgnoreCase(an)) {
                    System.out.println("The name already exists. Cannot add name to the list.");
                    count += 1;
                }
            }
        }
    }

    // function to search for a name in the array
    public static void searchName() {
        System.out.println("Enter the name you wish to search: ");
        Scanner sc = new Scanner(System.in);
        String sn = sc.nextLine();

        for (String searchString : name) {
            if (searchString.equalsIgnoreCase(sn)) {
                System.out.println(sn + " is present in the list of names.");
                break;
            }
        }

    }

    // function to remove a name from the array
    public static void removeName() {
        System.out.println("Enter the name you wish to remove: ");
        Scanner sc = new Scanner(System.in);
        String rn = sc.nextLine();

        for (int i = 0; i < 50; i++) {
            System.out.println(i);
             if(name[i]==null){
                if(i==0){
                    System.out.println("Cannot remove the name. The list is empty");
                }
                else{
                    System.out.println("Cannot remove the name. The name does not exist in the list.");
                }
                break;
            }
            else if (name[i].equalsIgnoreCase(rn)) {
                for (int j = i ; j < 50; j++) {
                    if (name[j + 1] == null) {
                        break;
                    } else {
                        name[j] = name[j + 1];
                    }
                }
                break;
            }
            
        }
    }

    // function to display all the Names in the array
    public static void displayName() {
        for (int i = 0; i < 50; i++) {
            if (name[i] == null) {
                break;
            } else {
                System.out.println(name[i]);
            }
        }
    }
}