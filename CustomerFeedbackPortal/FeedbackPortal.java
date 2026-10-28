import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
            System.out.println("5. Search by Name");
            System.out.println("6. Delete Feedback");
            System.out.println("7. Save Feedback to File");
            System.out.println("8. Save and Exit");
            System.out.println("9. Show Highest and Lowest Rating");
            try {
                System.out.print("Choose: ");
                 choice = sc.nextInt();  // Read the user's choice as an integer
                 sc.nextLine(); // Consume the newline character left by nextInt()
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                return; // Exit the method to show the menu again
            }
            switch (choice) {
                case 1:
                    addFeedback();
                    break;
                case 2:
                    showAllFeedback();
                    break;
                case 3:
                    showAverageRating();
                    break;
                case 4:
                    searchByRating();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    deleteFeedback();
                    break;
                case 7:
                    SaveFeedbackToFile();
                    break;
                case 8:
                    exitFlag = true;
                    SaveFeedbackToFile();
                    break;
                case 9:
                    showHighestandLowestRating();
                    break;
                    
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
                sc.nextLine(); // Consume the newline character left by nextInt()
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
   
    static void showAllFeedback(){
        if (feedbackCount == 0) {
            System.out.println("No feedback available.");
            return;
        }
        System.out.println("=====ALL FEEDBACK=====");
        for (int i = 0; i < feedbackCount; i++) { // Loop through only the number of feedbacks that have been added
            System.out.println("Customer Name: " + names[i]);
            System.out.println("Rating: " + ratings[i]);
            System.out.println("Comment: " + comments[i]);
            System.out.println("-----------------------");
        }
    }

   static void showAverageRating(){
        if (feedbackCount == 0) {
            System.out.println("No feedback available to calculate average rating.");
            return;
        }
        int sum = 0;
        for (int i = 0; i < feedbackCount; i++) {
            sum += ratings[i]; // Add the rating to the sum
        }
        double average = (double) sum / feedbackCount;
        System.out.printf("Average Rating: %.2f\n", average); // Print the average rating with 2 decimal places
    }

    static void searchByRating(){
        if (feedbackCount == 0) {
            System.out.println("No feedback available to search.");
            return;
        }
        int searchRating;
         
        while (true) {
            System.out.println("Enter the rating to search for (1-5): ");
            try {
                searchRating = sc.nextInt();
                if (searchRating >= 1 && searchRating <= 5) {
                    break;   // Valid rating
                } else {
                    System.out.println("Rating must be between 1 and 5. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a whole number from 1 to 5.");
                sc.nextLine(); // Clear the invalid input
            }
        }

        boolean found = false; // incase no feedback is found with the given rating
        System.out.println("=====FEEDBACK WITH RATING " + searchRating + "=====");
        for (int i = 0; i < feedbackCount; i++) {
            if (ratings[i] == searchRating) {
                System.out.println("Customer Name: " + names[i]);
                System.out.println("Comment: " + comments[i]);
                System.out.println("-----------------------");
                found = true; 
            }
        }
        if (found == false) {
            System.out.println("No feedback found with rating " + searchRating + ".");
        }
    }   

    static void searchByName() {
        if (feedbackCount == 0) {
            System.out.println("No feedback available to search.");
            return;
        }
        System.out.println("Enter the name to search for: ");
        String searchName = sc.nextLine().trim(); // Remove leading and trailing spaces

        boolean found = false; // In case no feedback is found with the given name
        System.out.println("=====FEEDBACK FROM " + searchName + "=====");
        for (int i = 0; i < feedbackCount; i++) {
            if (names[i].equalsIgnoreCase(searchName)) { // Case-insensitive comparison so that e.g., "John" and "john" are treated the same
                System.out.println("Rating: " + ratings[i]);
                System.out.println("Comment: " + comments[i]);
                System.out.println("-----------------------");
                found = true; 
            }
        }
        if (!found) {
            System.out.println("No feedback found from " + searchName + ".");
        }
    }

    static void deleteFeedback(){
        if (feedbackCount == 0) {
            System.out.println("No feedback available to delete.");
            return;
        }
        int deleteIndex;
        while (true) {
            System.out.println("Enter the index of the feedback to delete (0 to " + (feedbackCount - 1) + "): ");
            try {
                deleteIndex = sc.nextInt();
                if (deleteIndex >= 0 && deleteIndex < feedbackCount) { //range check
                    break; // Valid index
                } else {
                    System.out.println("Index must be between 0 and " + (feedbackCount - 1) + ". Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.nextLine(); // Clear the invalid input
            }
        }

        /* since we can't actually delete an element from an array,
         we will shift all feedbacks after the deleted one to the left by one position */
        for (int i = deleteIndex; i < feedbackCount - 1; i++) {
            names[i] = names[i + 1];  // the data will be overwritten by the next feedback 
            ratings[i] = ratings[i + 1];
            comments[i] = comments[i + 1];
        }
        feedbackCount--; // Decrease the count of feedbacks 
        System.out.println("Feedback deleted successfully!");
    }

    static void SaveFeedbackToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"));
            for (int i = 0; i < feedbackCount; i++) {
                writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine(); // Move to the next line for the next feedback
            }
            writer.close();
            System.out.println("Feedback saved to file successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving feedback to file.");
        }
    }

    static void showHighestandLowestRating() {
        if (feedbackCount == 0) {
            System.out.println("No feedback available to analyze.");
            return;
        }
        int highestRating = ratings[0]; // assuming the first rating is the highest initially
        int lowestRating = ratings[0];
        
        
        for (int i = 1; i < feedbackCount; i++) {
            if (ratings[i] > highestRating) {
                highestRating = ratings[i];
               
            }
            if (ratings[i] < lowestRating) {
                lowestRating = ratings[i];
                
            }
        }
        System.out.println("Highest Rating: " + highestRating );
        System.out.println("Lowest Rating: " + lowestRating );
    }
    static void LoadFeedbackFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
            String line;
            while ((line = reader.readLine()) != null) { // read each line until the end of the file
                String[] parts = line.split("\\|"); /* Split the line into parts using the '|' delimiter and escape it with double backslashes 
                                                     then store it in an array*/
                if (parts.length == 3) { // Ensure the line has all three parts
                    names[feedbackCount] = parts[0]; // Store the name in the names array at the current feedbackCount index
                    ratings[feedbackCount] = Integer.parseInt(parts[1]); 
                    comments[feedbackCount] = parts[2];
                    feedbackCount++; // Increment the count of feedbacks
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while loading feedback from file.");
        }
    }




    public static void main (String [] args){
        LoadFeedbackFromFile(); // Load saved feedback first
        while(exitFlag == false){
            showMenue();
        }
    }
}