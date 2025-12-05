/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 * Binary Search Tree implementation used for storing applicant names 
 * loaded from the provided form file. 
 * 
 * The tree supports standard BST insertion based on alphabetical order 
 * and provides three traversal outputs (Pre-order, In-order and Post-order)
 * as required by the assignment.
 *
 * @author mariana
 */

public class ApplicantTree {

    private ApplicantNode root;
    
    //Inserts a new applicant name into the tree
    //Delegates the operation to the recursive insertion method

    public void insert(String name) {
        root = insertRec(root, name);
    }
    
    //Recursively inserts a new name into the tree.
     //Names are positioned based on alphabetical order (BST rule).

    private ApplicantNode insertRec(ApplicantNode current, String name) {
        
        //Base case: empty position found > create new node
        if (current == null) {
            return new ApplicantNode(name);
        }
        //Navigate left or right subtree depending on alphabetical comparison
        if (name.compareToIgnoreCase(current.name) < 0) {
            current.left = insertRec(current.left, name);
        } else {
        //Names equal or greater go to the right subtree
            current.right = insertRec(current.right, name);
        }
        return current;
    }
    
    //Public method to initiate pre-order traversal
    
    public void preOrder() {
        System.out.println("\n--- PRE-ORDER (Applicants) ---");
        preOrderRec(root);
    }

     //Visits: node>left>right
     //Prints the tree in pre-order format
  
    private void preOrderRec(ApplicantNode node) {
        if (node != null) {                   
            System.out.println(node.name); //Process current node
            preOrderRec(node.left);     //Visit left subtree
            preOrderRec(node.right);   //Visit right subtree

        }
    }

    //Public method to initiate in-order traversal
    //In-order traversal outputs the names in alphabetical order
  
    public void inOrder() {
        System.out.println("\n--- IN-ORDER (Applicants) ---");
        inOrderRec(root);
    }
    
     //Visits: left>node>right
    //This traversal results in sorted output

    private void inOrderRec(ApplicantNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.name);
            inOrderRec(node.right);
        }
    }
    
     //Public method to initiate post-order traversal.

    public void postOrder() {
        System.out.println("\n--- POST-ORDER (Applicants) ---");
        postOrderRec(root);
    }
    
     //Visits: left>right>node
     //Useful for operations requiring children to be processed before the parent
 
    private void postOrderRec(ApplicantNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.name);
        }
    }
}

