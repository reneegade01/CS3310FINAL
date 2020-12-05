package cs3310finalproblem2;
/*
    S. Renee Eller
    CS 3310 Section 2 
    Final Problem 2 
    Time Complexity: O(m*n)
    Memory Complexity: O(log(m) + log(n))
 */
public class CS3310FinalProblem2
{

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        
        tree.r1 = new Node(34); 
        tree.r1.right = new Node(3); 
        tree.r1.right.right = new Node(5); 
        tree.r1.left = new Node(21); 
        tree.r1.left.left = new Node(4); 
        tree.r1.left.left.right = new Node(50); 
        tree.r1.left.right = new Node(8);
        
        tree.r2 = new Node(11); 
        tree.r2.right = new Node(7); 
        tree.r2.left = new Node(2); 
        tree.r2.left.right = new Node(30); 
   
        if (tree.subtree(tree.r1, tree.r2))
        {
            System.out.println("Tree 2 is subtree of Tree 1 ");             
        }
        else
        {
            System.out.println("Tree 2 is not a subtree of Tree 1");             
        }
    }
    
    static class Node  
    { 
        int data; 
        Node left, right, nextRight; 
   
        Node(int item)  
        { 
            data = item; 
            left = right = nextRight = null; 
        } 
    } 
   
    static class BinaryTree  
    { 
        Node r1,r2; 

        boolean areIdentical(Node r1, Node r2)  
        { 
            if (r1 == null && r2 == null) 
                return true; 
   
            if (r1 == null || r2 == null) 
                return false; 
   
            return (r1.data == r2.data 
                    && areIdentical(r1.left, r2.left) 
                    && areIdentical(r1.right, r2.right)); 
        } 
   
        boolean subtree(Node tree, Node subtree)  
        { 
            if (subtree == null)  
            return true; 
            
            if (tree == null) 
                return false; 

            if (areIdentical(tree, subtree))  
                return true; 

            return subtree(tree.left, subtree) || subtree(tree.right, subtree); 
        } 
    }
        
}
  
    
    