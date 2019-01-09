/*********************************************************************
Purpose/Description: This program sorts a stack of integers in descending order.
* 
Author’s Panther ID: 1735870
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

package problem4;

import java.util.Stack;

/**
 *
 * @author 1735870
 */
public class Problem4 {
    
    /**
     * It sorts a stack of integers in descending order.
     * 
     * B) The running time complexity is O(n^2)
     * Because there is a nested while loop inside another while loop it
     * the time complexity will be: n * n = O(n^2)
     * 
     * @param s the stack to be sorted
     * @return a sorted stack
     */
    static Stack<Integer> sort(Stack<Integer> s) {
        
        // Temporary stack to help sort 
        Stack<Integer> tempStack = new Stack<>();

        // To iterate through the entire stack until empty
        while (!s.isEmpty()) {
            int temp = s.pop();                     // Temp variable
            
            /* Iterates through the temporary stack until the temporary value
             * is greater than the top of the temp stack. It moves the top
             * of the temp stack back to the original stack.
            */
            while(!tempStack.isEmpty() && tempStack.peek() > temp) {
                s.push(tempStack.pop());
            }
            
            // Pushes the temp value to the temp stack if it is greater than
            // the top of the temp stack.
            tempStack.push(temp);
        }
        
        // Return the sorted temporary stack.
        return tempStack;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Stack of integer for testing
        Stack<Integer> s = new Stack<>();

        // Fill the stack with test values
        s.push(1);
        s.push(5);
        s.push(25);
        s.push(2);
        s.push(6);
        s.push(15);
        s.push(20);
        s.push(4);

        // Point the stack to the sorted stack by calling the sort function
        s = sort(s);

        // Display the sorted stack
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        
        System.exit(0);
    }
}
