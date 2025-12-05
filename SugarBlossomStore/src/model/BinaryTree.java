/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 * Binary Search Tree used for storing Employee objects.
 * 
 * Each employee is positioned in the tree based on alphabetical order 
 * of their name. The structure supports the standard BST traversals 
 * (pre-order, in-order, and post-order) which are used to visualize 
 * different hierarchical perspectives of the stored data.
 *
 * @author mariana
 */

public class BinaryTree {

    private TreeNode root;
    
   //Initializes an empty Binary Search Tree.

    public BinaryTree() {
        this.root = null;
    }
 
      //Inserts a new Employee object into the tree.
     //This operation is delegated to the recursive insert method.

    public void insert(Employee emp) {
        root = insertRec(root, emp);
    }
   
    //Recursively inserts a new employee into the tree using BST ordering rules.
   //Employees are ordered alphabetically by their name.

    private TreeNode insertRec(TreeNode current, Employee emp) {
        
         //Empty spot found > create new node
        if (current == null) {
            return new TreeNode(emp);
        }

        //Choose left or right subtree based on alphabetical comparison of names
        if (emp.getName().compareToIgnoreCase(current.data.getName()) < 0) {
            current.left = insertRec(current.left, emp);
        } else {
            current.right = insertRec(current.right, emp);
        }

        return current;
    }
 
     //Starts a pre-order traversal.
    //Order: node>left>right

    public void preOrder() {
        System.out.println("\n--- PRE-ORDER TRAVERSAL ---");
        preOrderRec(root);
    }

    private void preOrderRec(TreeNode node) {
        if (node != null) {
            System.out.println(node.data); //Process current employee
            preOrderRec(node.left);     //Visit left subtree
            preOrderRec(node.right);   //Visit right subtree
        }
    }
   
     //Starts an in-order traversal.
    //This traversal outputs employees in alphabetical order.
   
    public void inOrder() {
        System.out.println("\n--- IN-ORDER TRAVERSAL ---");
        inOrderRec(root);
    }

    private void inOrderRec(TreeNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }
    
     //Starts a post-order traversal
    //Order: left>right>node

    public void postOrder() {
        System.out.println("\n--- POST-ORDER TRAVERSAL ---");
        postOrderRec(root);
    }

    private void postOrderRec(TreeNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.data);
        }
    }
}

