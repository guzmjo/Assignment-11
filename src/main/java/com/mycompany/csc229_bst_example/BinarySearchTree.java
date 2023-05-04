package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }
    
    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {
        
        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }   
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root == null) {
            return;
        }
        
        doInOrder(root.getLeft());
        System.out.println(root.getData() + " ");
        doInOrder(root.getRight());
    }
    
    public void preOrderTraversal() {
        doPreOrder(this.root); 
    }
    
    private void doPreOrder(BstNode root) {
        if (root == null) {
            return;
        }
        
        System.out.println(root.getData());
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }
    
    /**
     * @return Height of the tree
     */
    public Integer findHeight() {
        // ToDo 3: Find the height of a tree
        if (isEmpty() || (root.getRight() == null && root.getLeft() == null )) {
            return 0;
        }
        
        else {
            //creates a Queue that will be implemented with the data from the linked list
            Queue<BstNode> bstQ = new LinkedList<>();
            
            //head of the Queue will be the root
            bstQ.add(root);
            //height is initialized with -1 because after one iteration of the while loop below
            //the height being returned (the height of the root) would be 0
            Integer height = -1;
            
            //loop iterates until the Queue is empty since we will be adding values to the queue
            //in order of depth and popping them
            while (!bstQ.isEmpty()) {             
                height++;
                
                //for loop will iterate for every node at that current depth
                for (int i = 0; i < bstQ.size(); i++) {
                    BstNode tempNode = bstQ.poll();
                    
                    //adds left child if there is one to the Queue
                    if (tempNode.getLeft() != null) {
                        bstQ.add(tempNode.getLeft());
                    }
                    
                    //adds the right child if there is one to the Queue
                    if (tempNode.getRight() != null) {
                        bstQ.add(tempNode.getRight());
                    }
                }
                
            }
            return height;
            
            
        }
        
    }
    
    /**Finds the current depth of a specified node
     * 
     * @param node 
     * @return depth of node
     */
    public int getDepth(BstNode node) {
        if (isEmpty() || (root.getRight() == null && root.getLeft() == null )) {
            return 0;
        }
        
        else {
            Queue<BstNode> bstQ = new LinkedList<>();
            bstQ.add(root);           
            Integer height = -1;
            
            while (!bstQ.isEmpty()) {  
                height++;
                for (int i = 0; i < bstQ.size(); i++) {
                    BstNode tempNode = bstQ.poll();
                    
                    //similar algorithm to findHeight()
                    //addition of if-statement below
                    //once the specified node is found the height will be returned + 1 because the height doesnt't
                    //get incremented since the while loop doesnt iterate
                    if (node.getData().equals(tempNode.getData())) {
                        return height + 1;
                    }
                    
                    if (tempNode.getLeft() != null) {
                        bstQ.add(tempNode.getLeft());
                    }
                    
                    if (tempNode.getRight() != null) {
                        bstQ.add(tempNode.getRight());
                    }
                }
                
            }
            
            return -1;
        }
        
    }
    
    //I didn't know how to implement the print() function
     public void print() {
       System.out.println("\n==== BST Print ===== \n");
        //print("", root, false);
        // ToDo 5: complete the print of the BST
        
    }
 

}
