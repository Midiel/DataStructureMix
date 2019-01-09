/*********************************************************************
Purpose/Description: This program compares two lists for items in common and
                     items that are found in only one list.
Author’s Panther ID: xxxxxxx
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

package problem2;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author 1735870
 */
public class Problem2 {
    
    /**
     * It finds the items that are in "List 1" and are not in "List 2".
     * 
     * It accepts three lists of AnyType and saves the items that are ONLY
     * present in "list 1" to the "Difference" list. Both "list 1" and "list 1"
     * MUST be sorted in ascending order.
     * 
     * @param <AnyType> the type of list
     * @param L1    list to compare 
     * @param L2    list to compare
     * @param Difference list to save the items that are only in "list 1"
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference) {
        
        // To iterate through both lists
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        
        // Temporary variables to hold value of items while itereting
        AnyType itemL1 = null;
        AnyType itemL2 = null;
        
        // Test lists are not empty
        if ( iterL1.hasNext() && iterL2.hasNext() ) {
            
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        
        // Loop to iterate through the lists
        while(itemL1 != null) {
            
            // Add current item1 if L2 does not a next value
            if(itemL2 == null) {
                Difference.add(itemL1);
                
                // Assign next value if list still allows
                if (iterL1.hasNext()) {
                        itemL1 = iterL1.next();
                    } else {
                        itemL1 = null;
                    }
            
            // If L2 still has next value, then compare and continue iterating 
            } else {
                
                // Compare the values
                int difference = itemL1.compareTo(itemL2);
                
                // If both items have the same value, then skip them both and
                // assign then next values if allowed.
                if(difference == 0) {
                    if (iterL1.hasNext()) {
                        itemL1 = iterL1.next();
                    } else {
                        itemL1 = null;
                    }

                    if (iterL2.hasNext()) {
                        itemL2 = iterL2.next();
                    } else {
                        itemL2 = null;
                    }

                // If item on L1 is smaller than item in L2, add item L1 to the
                // difference list and move to next list1 value if possible
                } else if (difference < 0) {
                    Difference.add(itemL1);
                    if (iterL1.hasNext()) {
                        itemL1 = iterL1.next();
                    } else {
                        itemL1 = null;
                    }
                
                // If item on L1 is greater than item on L2, then move to
                // next item on L2 if possible.
                } else {
                    if (iterL2.hasNext()) {
                        itemL2 = iterL2.next();
                    } else {
                        itemL2 = null;
                    }  
                }        
            }  
        }
    }
    
    /**
     * It find the items that common for L1 and L2.
     * 
     * It accepts three lists of AnyType and iterates through L1 and L2, and
     * saves the items in common to the Intersection list.
     * 
     * @param <AnyType> the type of list
     * @param L1    list to compare 
     * @param L2    list to compare
     * @param Intersect list to save the items that are in common in both lists
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void intersection(List<AnyType> L1, List<AnyType> L2, List<AnyType> Intersect) {
        
        // To iterate through both lists
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        
        // Temporary variables to hold value of items while itereting
        AnyType itemL1 = null;
        AnyType itemL2 = null;
        
        // Test lists are not empty
        if ( iterL1.hasNext() && iterL2.hasNext() ) {
            
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        
        // Loop to iterate through the lists
        while(itemL1 != null && itemL2 != null) {
            
            // Compare the values
            int difference = itemL1.compareTo(itemL2);
            
            // If values are the same, then add that value to the Intersect list
            // and move to the next values if possible
            if(difference == 0) {
                Intersect.add(itemL1);
                if (iterL1.hasNext()) {
                        itemL1 = iterL1.next();
                    } else {
                        itemL1 = null;
                    }
                if (iterL2.hasNext()) {
                        itemL2 = iterL2.next();
                    } else {
                        itemL2 = null;
                    }
                
            // If value on L1 is smaller than L2's, then move to the next L1
            // item if possible.
            } else if(difference < 0) {
                if (iterL1.hasNext()) {
                        itemL1 = iterL1.next();
                    } else {
                        itemL1 = null;
                    }
                
            // If value on L1 is greater than L2's, then move to the next L2
            // item if possible.
            } else { 
                if (iterL2.hasNext()) {
                    itemL2 = iterL2.next();
                } else {
                    itemL2 = null;
                }  
            }  
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        // Lists to test the functions
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        LinkedList<Integer> Difference = new LinkedList<>();
        LinkedList<Integer> Intersect = new LinkedList<>();
        
        // Fill list 1 for testing
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(6);
        L1.add(9);
        L1.add(12);
        L1.add(13);
        L1.add(18);
        
        // Fill list 2 for testing
        L2.add(2);
        L2.add(3);
        L2.add(7);
        L2.add(9);
        L2.add(13);
        L2.add(15);
        
        // Displays the values that are in "list 1" AND are not in "list2"
        difference(L1, L2, Difference);
        System.out.println("Difference: " + Difference);
        
        // Displays the intercects in both lists
        intersection(L1, L2, Intersect);
        System.out.println("Intersect: " + Intersect);
        
        System.exit(0);
    }  
}
