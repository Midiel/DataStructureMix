/*********************************************************************
Purpose/Description: This program does simple opration in a binary tree.
* 
Author’s Panther ID: 1735870
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

package problem3;


/**
 *
 * @author 1735870
 */
public class Problem3 {
    
    public static class BinarySearchTreeNode
    {
        public int key;
        public BinarySearchTreeNode left;
        public BinarySearchTreeNode right;
        
        // Constructor
        BinarySearchTreeNode(int key) {
            this.key = key;
            left = null;
            right = null;
        }
        
        
    }

    public class BinarySearchTree
    {
        private BinarySearchTreeNode root;
        
        public void insert(int key) {
            BinarySearchTreeNode tempNode = new BinarySearchTreeNode(key);
            
            if(root == null) {
                root = tempNode;
            }
            
            BinarySearchTreeNode temp1 = root;
            
            BinarySearchTreeNode temp2;
            boolean keepInserting = true;
            
            while(keepInserting) {
                temp2 = temp1;
                
                if (temp1.key > key) {
                    temp1 = temp1.left;
                    if(temp1 == null) {
                        temp2.left = tempNode;
                        keepInserting = false;
                    }
                } else {
                    temp1 = temp1.right;
                    if(temp1 == null) {
                        temp2.right = tempNode;
                        keepInserting = false;
                    }
                }
            }
        }
        
        // Calls the deletemode method to remove a key
        public void delete(int key) {
          root = deleteNode(root, key);
        }
        
        
        public BinarySearchTreeNode deleteNode(BinarySearchTreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (root.key > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.key < key) {
                root.right = deleteNode(root.right, key);
            } else {
                if (root.left == null) {
                    return root.right;
                }

                if (root.right == null) {
                    return root.left;
                }

                BinarySearchTreeNode temp = root;
                root.right = deleteNode(temp.right, root.key);
                root.left = temp.left;
            }
            return root;
        }
        
        
        
        public boolean find(int key) {
            BinarySearchTreeNode current = root;
            
            // Loop to search the entire node
            while (current != null) {
                if (current.key == key) {
                    return true;
                } else if (current.key > key) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return false;
        }
        
   
        // To check if a tree or not
        boolean validLeaf(BinarySearchTreeNode root) {
            if(root == null) {
                return false;
            } else if(root.left == null && root.right == null) {
                return true;
            } else {
                return false;
            }
        }
        
        
        // A) Sums all the keys
        int keySum(BinarySearchTreeNode root) {
            
            // Temporary variable to hold sum
            int temp = 0;
            
            // If the node is not null, then it excecutes
            if (root != null) {
                
                // If left leaf is null, then add key
                if(validLeaf(root.left)) {
                    temp += root.left.key;
                    
                // If not null, then adds the left child recursively and
                // add it to the temporary cariable
                } else {
                    temp += keySum(root.left);
                }
                
                // Adds the right side and adds it to the temp
                temp += keySum(root.right);
            }
            
            // Returns the temporary variable
            return temp;
        }   
    }

    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    
}
