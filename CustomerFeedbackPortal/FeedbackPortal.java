import java.util.Scanner;
public class FeedbackPortal{
    static Scanner sc = new Scanner(System.in);

    /*Arrays of size 100 to store feedback data, 
    same index should represent same customer */
    String names[] = new String[100];
    int ratings[] = new int[100];
    String comments[] = new String[100];

    //track how many feedbacks have been added
    int feedbackCount = 0;
    

    static void showMenue (){
        boolean exit = false;
        while (exit == false){
            System.out.println("=====CUSTOMER FEEDBACK PORTAL=====");
            System.out.println("1. Add Feedback");
            System.out.println("2. Show All Feedback");
            System.out.println("3. Show Average Rating");
            System.out.println("4. Search by Rating");
            System.out.println("5. Delete Feedback");
            System.out.println("6. Save Feedback to File");
            System.out.println("7. Save and Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
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
                    deleteFeedback();
                    break;
                case 6:
                    SaveFeedbackToFile();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    static void addFeedback(){

    }
    static void showAllFeedback(){

    }
    static void showAverageRating(){

    }
    static void searchByRating(){

    }
    static void deleteFeedback(){ //remove entry and shift the arrays to fill the gap

    }
    static void SaveFeedbackToFile(){

    }
    
    public static void main (String [] args){
        showMenue();
        

    }
}