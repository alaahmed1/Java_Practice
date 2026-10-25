package ATMProject;
import java.util.Scanner;
public class ATMProject {
    static Scanner scn = new Scanner(System.in);
    static double balance = 1000.00; // initial balance at 1000.00
    static int pin = 1234;
    // counters for deposist and withdrawal
    static int depositCount = 0;
    static int withdrawalCount = 0;
    static boolean loggedIn = false; // variable to track if the user is logged in
    static double depositTotal = 0.00; // total amount deposited
    static double withdrawalTotal = 0.00; // total amount withdrawn

    //saving interest rates for each account tier
    static double interestRate = 0.00; //default interest rate

    static void login (){ // method to handle user login
        int U_PIN = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter your PIN: ");
            System.out.println("You have " + (3 - i) + " attempts left."); 
            U_PIN = scn.nextInt();
            if (U_PIN == pin) {
                System.out.println("Welcome!");
                loggedIn = true;
                return;
            }
        }
        System.out.println("Card Locked.");
    }

    static void menue(){// method to display the ATM menu and handle user choices
        boolean exit = false;
        while (!exit && loggedIn==true) { //show only if the user is logged in
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account tier");
            System.out.println("5. Saving projection");
            System.out.println("6. Reciept summery");
            System.out.println("7. Change PIN");
            System.out.println("0. Exit");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    accountTier();
                    break;
                case 5:
                    savingProjection();
                    break;
                case 6:
                    receiptSummary();
                    break;
                case 7:
                    changePin();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static void checkBalance() {// method to display the current balance
        System.out.println("Your current balance is: $" + balance);
    }

    static void deposit() { // method to handle deposits
        System.out.print("Enter amount to deposit: ");
        double amount = scn.nextDouble();
        if (amount > 0 && amount <= balance) { // Check if the deposit amount is valid
            balance += amount;
            depositCount++;
            depositTotal += amount; // Update total deposited amount
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    static void withdraw() { // method to handle withdrawals
        System.out.print("Enter amount to withdraw: ");
        double amount = scn.nextDouble();
        if (amount > 0 && amount%10==0 && amount <= balance) { // Check if the withdrawal amount is valid
            if (amount <=500){
                balance -= 2.00; // Add a $2 fee for withdrawals of $500 or less
            }
            else if (amount > 500){
                balance -= 5.00; // Add a $5 fee for withdrawals of $500 or more
            }

            balance -= amount;
            withdrawalCount++;
            withdrawalTotal += amount; // Update total withdrawn amount
            System.out.println("Withdrew: $" + amount);
        } 
         
        else {
            System.out.println("Invalid withdrawal amount.");
        }   
    }

    static void accountTier() { // method to display the account tier based on the current balance
       if (balance < 1000) {
            System.out.println("Account Tier: Bronze, Yearly interest rate: 1%");
            interestRate = 0.01; // Set interest rate for Bronze tier
        } else if (balance >= 1000 && balance < 5000) {
            System.out.println("Account Tier: Silver, Yearly interest rate: 2%");
            interestRate = 0.2; // Set interest rate for Silver tier
        } else if (balance >= 5000 && balance < 20000) {
            System.out.println("Account Tier: Gold, Yearly interest rate: 3%");
            interestRate = 0.03; // Set interest rate for Gold tier
        } else {
            System.out.println("Account Tier: Platinum, Yearly interest rate: 4%");
            interestRate = 0.04; // Set interest rate for Platinum tier
        }
    }

    static void savingProjection() {// method to read number of years 1- 10 and display the projected savings based on the current balance and account tier using a for loop
      System.out.println(" Enter number of years for saving projection (1-10): ");
      int savingYears = scn.nextInt();
        if (savingYears < 1 || savingYears > 10) {
                System.out.println("Invalid number of years. Please enter a value between 1 and 10.");
            }
        else{
            accountTier();
            for (int i = 1; i <= savingYears; i++) {
                System.out.println(interestRate);
                double projectedBalance;
                projectedBalance = balance * Math.pow(1 + interestRate, i); // Calculate projected balance using compound interest formula
                System.out.printf("Projected balance after year %d: $%.2f%n", i, projectedBalance);
            }
        }

    }

    static void receiptSummary() {
        System.out.println("Receipt Summary:");
        System.out.println("- Balance: $" + balance);
        System.out.println("- Deposits: " + depositCount);
        System.out.println("- Total Deposited: $" + depositTotal);
        System.out.println("- Withdrawals: " + withdrawalCount);
    }

    static void changePin() {
        System.out.print("Enter your current PIN: ");
        int currentPin = scn.nextInt();
        if (currentPin == pin) {
            System.out.print("Enter your new PIN: ");
            int newPin = scn.nextInt();
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect current PIN.");
        }
    }

    public static void main(String[] args) {
        login();
        menue();
    }
}