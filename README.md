# DataStructureMix

Problem  #1: (25 points)
(a) Implement a recursive search function in Java
int terSearch(int arr[], int l, int r, int x)
that returns location of x in a given sorted array arr[l…r] is present, otherwise -1.
The terSearch search function, unlike the binary search, must consider two dividing points 
int d1 = l + (r - l)/3
int d2 = d1 + (r - l)/3 

(b) What is the running time complexity of your function? Justify.

Problem #2: (25 points)
2. Given two sorted lists, L1 and L2, complete a following procedure in Java to compute:

(a)  L1 \ L2 = { x | x  L1 and x  L2 } using only the basic list operators (next(), hasNext(), and compareTo()) and one loop. 

public static <AnyType extends Comparable<? super AnyType>>
      void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference)
  {  
    ListIterator<AnyType> iterL1 = L1.listIterator();
    ListIterator<AnyType> iterL2 = L2.listIterator();    
    if ( iterL1.hasNext() && iterL2.hasNext() )
    {
      itemL1 = iterL1.next();
      itemL2 = iterL2.next();
    }

    // YOUR CODE GOES HERE
    
                


(b)  L1  L2 = { x | x  L1 and x  L2 } using only the basic list operators (next(), hasNext(), and compareTo()) and one loop. 


public static <AnyType extends Comparable<? super AnyType>>
  void intersection(List<AnyType> L1, List<AnyType> L2, List<AnyType> Intersect)
  {  
    ListIterator<AnyType> iterL1 = L1.listIterator();
    ListIterator<AnyType> iterL2 = L2.listIterator();    
    if ( iterL1.hasNext() && iterL2.hasNext() )
    {
      itemL1 = iterL1.next();
      itemL2 = iterL2.next();
    }

    // YOUR CODE GOES HERE
 
Problem #3: (30 points)
In this problem, you will write some Java code for simple operations on binary search trees where keys are integers. Assume you already have the following code and assume that the method bodies, even though not shown, are correct and implement the operations as we defined them in class.

public class BinarySearchTreeNode
{
public int key;
public BinarySearchTreeNode left;
public BinarySearchTreeNode right;
}

public class BinarySearchTree
{
private BinarySearchTreeNode root;
public void insert(int key) { ... }
public void delete(int key) { ... }
public boolean find(int key) { ... }
}

(a) Add a method public int keySum() to the BinarySearchTree class that returns the sum of all the keys in the tree. You will need an assistant/helper method.


(b) Add method public void deleteMin() to the BinarySearchTree class that deletes the minimum element in the tree (or does nothing if the tree has no elements).

(c) Add method public void printTree() to the BinarySearchTree class that iterates over the nodes to print then in increasing order. So the tree...
       4 
      / \ 
     2   5 
    / \ 
   1   3
Produces the output "1 2 3 4 5".

Note: You will need an assistant/helper method.

(d) Add method public void printPostorder() to the BinarySearchTree class that prints out the nodes of the tree according to a "postorder" traversal. So the tree...
       4 
      / \ 
     2   5 
    / \ 
   1   3
Produces the output "1 3 2 5 4". 
Note: You will need an assistant/helper method. 
Problem  #4: (20 points)
(a) Write a method in Java to sort a stack of n integer numbers, s, in descending order. 
static Stack<Integer> sort(Stack<Integer> s)
To implement this method you must use one more auxiliary stack and you should not make any assumptions about how the stack is implemented. The following are the only functions that should be used to write this program: push, pop, peek, and isEmpty. 
(b) What is the running time complexity of your method? Justify.
