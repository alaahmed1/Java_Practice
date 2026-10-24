package ArraysTask;
import java.util.Scanner; 
public class ArraysTask{
    static Scanner scn = new Scanner (System.in);

    static int sumArray (int [] arr){
        int sum = 0;
        for (int i = 0; i<arr.length ; i++){
            sum+=arr[i];
        }
     return sum;
     
    }

    static double averageArray (int [] arr){
        double sum = 0; // Initialize sum as double to avoid integer division
        for (int i = 0; i<arr.length ; i++){
            sum+=arr[i];
        }
     return sum/arr.length; // Return the average as a double
    }

    static int findMax (int [] arr){
        int max = arr[0]; // assume the first element is the maximum
        for (int i = 1; i<arr.length ; i++){
            if (arr[i]>max){// compare each element with the current maximum
                max=arr[i];// update max if a larger element is found
            }
        }
     return max;
    }

    static int findMin(int [] arr){
        int min = arr[0]; 
        for (int i = 1; i<arr.length ; i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
     return min;
    }

    static int countEven(int [] arr){
        int count = 0;
        for (int i = 0; i<arr.length ; i++){
            if (arr[i]%2==0){
                count++;// increment count for each even number found
            }
        }
     return count;
    }

    static int indexOf(int[]arr, int target){
        int err = -1; // Initialize err to -1 to indicate not found
        for (int i = 0; i<arr.length ; i++){
            if (arr[i]==target){
                return i; // return the index of the target if found
            }
        }
        return err; // return -1 if the target is not found in the array
    }
     
    static int [] reverseArray(int[] arr){
        int [] reversed = new int[arr.length];
        for (int i = arr.length-1; i>=0 ; i--){
            for (int j = 0; j < arr.length; j++) {
                    reversed[j] = arr[i]; // Fill the reversed array with elements from the original array in reverse order
            }
        }
        return reversed;
    }

    

    





    public static void main(String [] args){
        int [] numbers = {12, 7, 25, 3, 18, 9, 30, 14};
        System.out.println("Sum: "+sumArray(numbers));
        System.out.println("Average: "+averageArray(numbers));
        System.out.println("Max: "+findMax(numbers));
        System.out.println("Min: "+findMin(numbers));
        System.out.println("Difference: "+(findMax(numbers)-findMin(numbers)));
        System.out.println("Even numbers: "+countEven(numbers));
        System.out.println("Enter a number to search for");
        int target = scn.nextInt(); // Read the target number from user input
        int index = indexOf(numbers, target); // Call the indexOf method to find the index of the target number
        
        // Check the returned index to print the appropriate message
        if (index != -1) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found");
        }

        System.out.print("Original : ");
        for (int i =0 ; i<numbers.length ; i++){
            System.out.print(numbers[i]+" ");
        }
        // Print the reversed array
        //System.out.print("Reversed: "+ reverseArray(numbers)); 


    }
}