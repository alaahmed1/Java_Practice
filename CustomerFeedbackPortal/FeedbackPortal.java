import java.util.Scanner;
// import java.io.FileNotFoundException;
// import java.util.InputMismatchException;
// import java.util.BufferedReader;
// import java.io.FileReader;

public class FeedbackPortal{
    static Scanner sc = new Scanner(System.in);
    /*Arrays of size 100 to store feedback data, 
    same index should represent same customer */
    static String names[] = new String[100];
    static int ratings[] = new int[100];
    static String comments[] = new String[100];

    //track how many feedbacks have been added
    static int feedbackCount = 0;

    //exit flag to control the menu loop
    static boolean exitFlag = false;
    

    static void showMenue (){
            int choice = 0;
            System.out.println("=====CUSTOMER FEEDBACK PORTAL=====");
            System.out.println("1. Add Feedback");
            System.out.println("2. Show All Feedback");
            System.out.println("3. Show Average Rating");
            System.out.println("4. Search by Rating");
            System.out.println("5. Delete Feedback");
            System.out.println("6. Save Feedback to File");
            System.out.println("7. Save and Exit");
            try {
                System.out.print("Choose: ");
                 choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                sc.nextLine(); // Clear the invalid input
                return; // Exit the method to show the menu again
            }
            switch (choice) {
                case 1:
                    addFeedback();
                    break;
                // case 2:
                //     showAllFeedback();
                //     break;

                // case 3:
                //     showAverageRating();
                //     break;
                // case 4:
                //     searchByRating();
                //     break;
                // case 5:
                //     deleteFeedback();
                //     break;
                // case 6:
                //     SaveFeedbackToFile();
                //     break;
                //case 7:
                    //exitFlag = true;
                //     SaveFeedbackToFile();
                    //break;
            
        }

    }

    static void addFeedback(){
        String name;
        int rating;
        String comment;

        // STEP 1: Check whether the feedback array is full
        // Arrays have indexes from 0 to 99, so we can store 100 entries.
        if (feedbackCount >= 100) {
            System.out.println("Feedback limit reached. Cannot add more feedback.");
            return; // Stop this method if there is no space left
        }
        // STEP 2: Ask for the customer's name and validate it
        while (true) {
            System.out.println("Enter your name: ");
            name = sc.nextLine();
            // trim() removes spaces at the beginning and end.
            // isEmpty() checks whether anything remains.
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            } else {
                break; // The name is valid, so leave the loop
            }
        }
        // STEP 3: Ask for the rating and validate it
        while (true) {
            System.out.println("Enter your rating (1-5): ");
            try {
                rating = sc.nextInt();
                if (rating >= 1 && rating <= 5) { // Check that the rating is between 1 and 5
                    break; // The rating is valid
                } else {
                    System.out.println("Rating must be between 1 and 5. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a whole number from 1 to 5.");
            }
        }
        // STEP 4: Ask for the comment and validate it
        while (true) {
            System.out.println("Enter your comment: ");
            comment = sc.nextLine();
            if (comment.trim().isEmpty()) { // A comment containing only spaces is also considered empty.
                System.out.println("Comment cannot be empty. Please try again.");
            } else {
                break; // The comment is valid
            }
        }

        // Store the validated information in the arrays.
        names[feedbackCount] = name;
        ratings[feedbackCount] = rating;
        comments[feedbackCount] = comment;

        feedbackCount++; //Increase the counter AFTER storing the feedback.
        System.out.println("Feedback added successfully!"); 
    }
   
    public static void main (String [] args){
        while(exitFlag == false){
            showMenue();
        }
    }
}