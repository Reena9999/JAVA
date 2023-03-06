import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

class lab4 {

    String Name;
    String AccountNumber;
    Map<String, double[]> Balance;

    //constructor to initialize the required variables for the program
    lab4(String name, String accountNumber) {
        //stores the name of the customer
        Name = name;
        //store the account number of the customer
        AccountNumber = accountNumber;
        //creating a hashmap to store multiple transactions
        Balance = new Hashtable<String, double[]>();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //Reading Customer's details
        System.out.print("Enter your full Name: ");
        String name = sc.nextLine();
        
        //account opening requires an initial deposit. We read that value here.
        //If that value is invalid then we just set the initial value as zero.
        System.out.print("\nEnter your intial amount you'd like to open your account with: ");
        double Initialamount = Double.parseDouble(sc.nextLine());
        if (Initialamount < 0) {
            Initialamount = 0;
        }
        double amount=Initialamount;
        String accountNumber = "AX00943948502";

        //creating the object of the class to call functions
        lab4 obj = new lab4(name, accountNumber);

        String choice;
        System.out.println("\n\t\tENTER EXIT IF YOU WISH TO STOP");
        //an infinite loop that will stop when the user enters 'exit'
        do {
            //displaying the choice of function the bank can perform to the customer
            System.out.println("\n\nEnter:\n1. To deposit money\n2. To withdraw money\n3. To print the transactions\n4. To print account summary");

            //reading the customer's choice
            choice = sc.nextLine();

            //checking if the input is 'exit'
            if (choice.equalsIgnoreCase("exit")) {
                break;
            } else {
                switch (Integer.parseInt(choice)) {
                    case 1:
                        //depositing money
                        amount=obj.deposit(amount);
                        break;

                    case 2:
                        //withdrawing money
                        amount =obj.withdraw(amount);
                        break;

                    case 3:
                        //print all the transaction of the current day
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        LocalDateTime now = LocalDateTime.now();
                        obj.printTransactions(dtf.format(now));
                        break;

                    case 4:
                        //generate an account summary
                        obj.printAccountSummary(Initialamount);
                        break;

                    default:
                        //if the customer enters a wrong value, display an appropriate message
                        System.out.println("Invalid Input!");
                        break;
                }
            }
        } while (true);

    }

    //function to withdraw money
    public double withdraw(double bankBalance) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter amount to withdraw: ");
        //reading customer's requirements
        double amount = Double.parseDouble(sc.nextLine());

        //checking if the amount entered is not negative 
        if (amount < 0) {
            System.out.println("Invalid!");
        } 
        //checking if the customer has enough money in their account to withdraw
        else if (amount > bankBalance) {
            System.out.println("Insuffiecient Funds!");
        } 
        //if both the previous conditions are not satisified, then perform the below
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            bankBalance -= amount;
            //record the time of the transaction as the key
            //1.0 represents the withdrawal
            //record the amount being withdrawn
            //record the current balance
            this.Balance.put(dtf.format(now), new double[] { 1.0, amount, bankBalance });

            System.out.println("\n\t\t!!!TRANSACTION SUCCESSFUL!!!!");

            //print the transaction details
            printTransaction(dtf.format(now));
        }
        //return the current bank balance
        return bankBalance;

    }

    //function to deposit money
    public double deposit(double bankBalance) {
        Scanner sc = new Scanner(System.in);

        //reading the customer's requirements
        System.out.print("\nEnter amount to deposit: ");
        double amount = Double.parseDouble(sc.nextLine());

        //checking if the amount entered is not negative
        if (amount < 0) {
            System.out.println("Invalid!");
        } 
        //there are not other conditions that need to checked
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            bankBalance += amount;
            //recording the time of the transactions
            //0.0 represents deposit
            //record the amount and the bank balance after depositing the money
            this.Balance.put(dtf.format(now), new double[] { 0.0, amount, bankBalance });

            System.out.println("\n\t\t!!!TRANSACTION SUCCESSFUL!!!!");

            //print the transaction details
            printTransaction(dtf.format(now));
        }
        //return the current bank balance
        return bankBalance;
    }

    //function that prints the current transaction    
    public void printTransaction(String date) {
        //if there are no transactions that were done on the specific day, display an appropriate message
        if (Balance.size() == 0) {
            System.out.println("No transactions available!");
        } 
        else {
            int count = 0;
            String str = "";
            //get the transaction with the timestamp that was passed as parameters
            //iterate through the value in the array of that particular transaction
            for (double i : this.Balance.get(date)) {

                //the first element of the array describes if the transaction was a deposit or a withdrawal
                if (count == 0) {
                    System.out.println("\n" + AccountNumber + "\n" + Name);
                    System.out.println("-------------------------------------------------------");
                    if (i == 1.0) {
                        System.out.println("\t\t Withdrawal Summary");
                        str = "Dr.";
                    } 
                    else if (i == 0.0) {
                        System.out.println("\t\t Deposit Summary");
                        str = "Cr.";
                    }
                    System.out.println("-------------------------------------------------------");
                } 

                //the second element of the array is the amount that was involved in the transaction
                else if (count == 1) {
                    System.out.print("Amount\t\t|\t\t\t");
                    System.out.println(i + " " + str);
                    System.out.println("-------------------------------------------------------");
                } 

                //the last element is the balance after the transaction
                else if (count == 2) {
                    System.out.print("Bank Balance\t|\t\t\t");
                    System.out.println(i);
                    System.out.println("-------------------------------------------------------");

                }
                //increament the counter to print the appropriate values of the array
                count += 1;
            }
        }
    }

    //function to print all the transactions of a particular day
    public void printTransactions(String date) {
        //checking if there are transactions in the customer's name
        if (Balance.size() == 0) {
            System.out.println("No transactions available!");
        } 
        else {
            System.out.println("\n" + AccountNumber + "\n" + Name);
            System.out.println("-------------------------------------------------------");
            System.out.println("\t\t Transactions for " + date);
            System.out.println("-------------------------------------------------------");
            double bb = 0.0;
            //iterating through all the transactions
            for (String i : Balance.keySet()) {
                //checking if the transaction was in the current day
                if (i.contains(date)) {
                    int count = 0;
                    String str = "";

                    //iterating through the value in the array of the keys that are in the current month
                    for (double a : this.Balance.get(i)) {
                        //the first element of the array describes if the transaction was a deposit or a withdrawal
                        if (count == 0) {
                            if (a == 1.0) {
                                str = "Dr.";
                            } else if (a == 0.0) {
                                str = "Cr.";
                            }
                        } 
                        //the second element of the array is the amount that was involved in the transaction
                        else if (count == 1) {
                            System.out.print("Amount\t\t|\t\t\t");
                            System.out.println(a + " " + str);
                            System.out.println("-------------------------------------------------------");
                        }

                        //the last element is the balance after the transaction
                        else if (count == 2) {
                            bb = a;
                        }
                        //increament the counter to print the appropriate values of the array
                        count += 1;
                    }
                }

            }
            //Displaying the last current balance
            System.out.print("Bank Balance\t|\t\t\t");
            System.out.println(bb);
            System.out.println("-------------------------------------------------------");
        }

    }

    //function to generate the account summary for the current month
    public void printAccountSummary(double amount) {
        //getting the current month value
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        double r=returnLastMonthBankBalance(amount,date);

        try {
            // Creating a file to store the account summary
            FileWriter output = new FileWriter("Account_Statement.txt");

            // writing the transactions into the file

            //checking if the customer has made any transactions
            if (Balance.size() == 0) {
                output.write("No transactions available!");
            } 
            else {
                output.write("\n" + AccountNumber + "\n" + Name);
                output.write("\n=======================================================");
                output.write("\n\t Account Summary for " + date);
                output.write("\n-------------------------------------------------------");
                output.write("\n\t\t\t\t Debit \t  Credit");
                output.write("\n=======================================================");
                output.write("\n\t\t\t\t"+r);
                output.write("\n-------------------------------------------------------");
                double bb = 0.0;  

                //Exctracting the keys and then sorting the values in ascending order to display the transactions in order
                List<String> list = new ArrayList<String>(Balance.keySet());
                Collections.sort(list);
                
                //iterating through all the transactions
                for (String i : list) {
                    //checking if the transaction was in the current day
                    if (i.contains(date)) {
                        int count = 0;
                        String str = "";
                        for (double a : this.Balance.get(i)) {
                            //the first element of the array describes if the transaction was a deposit or a withdrawal
                            if (count == 0) {
                                if (a == 1.0) {
                                    str = "Dr.";
                                } else if (a == 0.0) {
                                    str = "Cr.";
                                }
                            } 
                            //the second element of the array is the amount that was involved in the transaction
                            else if (count == 1) {
                                output.write("\n"+i);
                                if(str.equals("Dr.")){
                                    output.write("\t"+a + " " + str);
                                }
                                else if(str.equals("Cr.")){
                                    output.write("\t\t\t"+a + " " + str);
                                }
                                
                                output.write("\n-------------------------------------------------------");
                            } 
                            //the last element is the balance after the transaction
                            else if (count == 2) {
                                bb = a;
                            }
                            //increament the counter to print the appropriate values of the array
                            count += 1;
                        }
                    }
                }
                //writing the last current balance
                output.write("\n=======================================================");
                output.write("\n\nBank Balance\t\t\t\t\t\t");
                output.write(String.valueOf(bb));
                output.write("\n=======================================================");
                output.close();

                System.out.println("Please find the Account_Summary in current directry");
            }

            // Closes the writer
            output.close();
        }
        //catch any errors that coudlw happen while creating the file
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public double returnLastMonthBankBalance(double amount,String date){
        //
        String month1=date.substring(5,7);
        int month=Integer.parseInt(month1);
        if(month==12){
            month=1;
        }
        else{
            month-=1;
        }

        if(month<10){
            month1="0"+String.valueOf(month);
        }
        else{
            month1=String.valueOf(month);
        }

        date=date.substring(0,5)+month1;

        //Exctracting the keys and then sorting the values in ascending order to get the last balance
        List<String> list = new ArrayList<String>(Balance.keySet());
        Collections.sort(list);

        //iterating through all the transactions
        for (String i : list) {
            //checking if the transaction was in the current day
            if (i.contains(date)) {
                amount= this.Balance.get(i)[2];
            }
        }
        return amount;
    }

}