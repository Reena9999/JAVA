import java.util.*;

public class lab2 {
    static String[] name = new String[1024];

    public static void main(String args[]) {
        String yes = "y";
        int n = 0;
        int choice=0;

        // creating the scanner object to read data from the user
        Scanner sc = new Scanner(System.in);

        do {
            // DISPLAYING CHOICE FOR THE USER
            System.out.println(
                    "\nEnter: \n 1 for Entering a name in the list.\n 2 to search for a name in the list.\n 3 to remove a name from the list.\n 4 to display all the names in the list.");

            // READING INPUT FROM USER
            // reading user's name
            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    //calling the function that reads and add a new Name to the array
                    readName();
                    n += 1;
                    break;

                case 2:
                    //calling the function that searches for the name in the existing array
                    searchName();
                    break;

                case 3:
                    //calling the function to that removes a name from the existing array
                    removeName();
                    n -= 1;
                    break;

                case 4:
                    //calling the function to that display the names in the array
                    displayName();
                    break;

                default:
                    //incase the user enter's a wron input
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.print("Enter y to continue process: ");
            yes = sc.nextLine();
        } while (yes.equalsIgnoreCase("y") && (n < 1024));

    }

    // function to read Names and create an array
    public static void readName() {
        System.out.print("Enter the name you wish to add: ");
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String an = sc.nextLine();

        //if the array is empty add the new name without any check constraints
        if (name.length == 0) {
            name[0] = an;
        } else {
            for (int i = 0; i < 1024; i++) {
                //if the name is null it indicates there are no more values that were entered by the user
                if (name[i] == null) {
                    //if count is zero it means there is no repeating name in the array
                    if (count == 0) {
                        name[i] = an;
                        count = 0;
                    }
                    break;
                }
                //checking if the name exists in the array without considering the case 
                else if (name[i].equalsIgnoreCase(an)) {
                    System.out.println("\nThe name already exists. Cannot add name to the list.\n");
                    count += 1;
                }
            }
        }
    }

    // function to search for a name in the array
    public static void searchName() {
        int count=0;
        System.out.print("Enter the name you wish to search: ");
        Scanner sc = new Scanner(System.in);
        String sn = sc.nextLine();

        for (String searchString : name) {
            //checking if the element is null. If it is null it imply that is the end of the array
            if(searchString==null){
                break;
            }
            //checking if the two strings are equal without considering the case
            else if (searchString.equalsIgnoreCase(sn)) {
                System.out.println("\n--------------------------------------------------\n"+sn + " is present in the list of names.\n--------------------------------------------------\n");
                count+=1;
                break;
            }
        }

        //This if condition is to check if the search name was not found
        if(count==0){
            System.out.println("\n--------------------------------------------------\n"+sn + " is not present in the list of names.\n--------------------------------------------------\n");
        }

    }

    // function to remove a name from the array
    public static void removeName() {
        System.out.print("Enter the name you wish to remove: ");
        Scanner sc = new Scanner(System.in);
        String rn = sc.nextLine();

        for (int i = 0; i < 1024; i++) {
            //checking if we have reached the end of the array 
             if(name[i]==null){
                //if i==0 it mean that the array is empty
                if(i==0){
                    System.out.println("\nCannot remove the name. The list is empty");
                }
                //otherwise it implies we have reached the end of the array
                else{
                    System.out.println("\nCannot remove the name. The name does not exist in the list.");
                }
                break;
            }
            //checking if the name is found in the array without considering the case
            else if (name[i].equalsIgnoreCase(rn)) {
                //if the name is in the array we move all the values succeeding the name down one step and make the last value null
                for (int j = i ; j < 50; j++) {
                    if (name[j + 1] == null) {
                        name[j]=null;
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
        System.out.println("\n====================================================");
        System.out.println("                Current List of Names                 ");
        System.out.println("====================================================");
        for (int i = 0; i < 50; i++) {
            //checking if the array is empty
            if (name[i] == null) {
                if(i==0){
                    System.out.println("The list is empty");
                }
                break;
            } else {
                System.out.println(name[i]);
            }
        }
        System.out.println("");
    }
}