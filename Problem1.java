/*********************************************************************
Purpose/Description: This program finds a number "x" inside a sorted array
                     of integers.
Author’s Panther ID: 1735870
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

package problem1;

import java.util.Random;            // Needed to generate a random number

/**
 *
 * @author 1735870
 */
public class Problem1 {

    /**
     * Recursive search method that searches for an integer in an array of
     * integers/elements. If the element it found, it return the position in
     * the array. If the element is not found, it return -1.
     * It accepts an a SORTED in ASCENDING order array of integers, 
     * a starting position, a final position, and the integer to find.
     * 
     * B) The running time complexity is: O(log3 n)
     * Because the function divides the problem in three equal parts:
     * t(n) = t(n/3) + 1  -->  O(log3 n)
     * 
     * 
     * @param arr represents the array to search
     * @param l the starting position
     * @param r the final position
     * @param x the value to search for
     * @return the position if the element is found, -1 otherwise
     */
    public static int terSearch(int arr[], int l, int r, int x) {
        
        // Base case if the entire array has being search for
        if(l > r) {
            return -1;
        }
        
        // Splits the array in three parts
        int d1 = l + (r - l)/3;
        int d2 = d1 + (r - l)/3;
        
        /*
         * Tests for two base cases, if "x" it found at "d1" or "d2" and return
         * that position. If not, then it uses recursion to narrow down the search.
        */
        if(arr[d1] == x) {                      // Check if "x" is at "d1"
            return d1;
        } else if (arr[d2] == x) {              // Check if "x" is at "d2"
            return d2;
        } else if (arr[d1] > x) {               // Recusives the lower 3rd
            return terSearch(arr, l, d1 - 1, x);
        } else if(arr[d2] < x) {                // Recursives the upper 3rd
            return terSearch(arr, d2 + 1, r, x); 
        } else {                                // Recursives the middle 3rd
            return terSearch(arr, d1 + 1, d2 - 1, x);   
        }   
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // Sorted in ASCENDING order array of integer to test the search function
        int arr[] = {1, 3, 6, 8, 10, 11, 13, 15, 17, 18, 19, 21, 24, 26, 27, 30};
        
        // Random variable variable to test the function
        Random rand = new Random();
        
        // Seed the random variable
        rand.setSeed(System.currentTimeMillis());
        
        // Initiates the variable "x" with a random number between 1 and 30
        int x = rand.nextInt(31);
        
        // Print if "x" was found or not.
        if(terSearch(arr, 0, arr.length - 1, x) == -1) {
            System.out.println("The number " + x + " is not in the list.");
        } else {
            System.out.println("The number " + x + " is in the index " + 
                                terSearch(arr, 0, arr.length - 1, x) + ".");
        }  
    }  
}
