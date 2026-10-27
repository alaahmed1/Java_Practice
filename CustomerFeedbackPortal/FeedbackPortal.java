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


    

    static void showMenue (int choice){
        boolean exit = false;
        while (exit == false){
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
        System.out.println("=====CUSTOMER FEEDBACK PORTAL=====");
        int choice = sc.nextInt();
        showMenue(choice);

    }
}