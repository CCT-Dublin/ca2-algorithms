/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Represents a Binary Search Tree (BST) used to store {@link Employee} objects.
 *
 * Employees are inserted based on alphabetical order of their names, ensuring
 * the tree maintains proper BST structure. This class supports all three
 * standard traversal methods (pre-order, in-order, and post-order) which can be
 * used to visualize the hierarchical organization of the stored employees.
 *
 * This structure is required in the assignment to demonstrate understanding of
 * BST insertion logic and traversal algorithms.
 *
 * @author mariana
 */
public class BinaryTree {

    private TreeNode root;

    /**
     * Creates an empty Binary Search Tree.
     */
    public BinaryTree() {
        this.root = null;
    }

    /**
     * Inserts a new employee into the tree.
     * Delegates the actual insertion to the recursive helper method.
     *
     * @param emp the employee to be added to the BST
     */
    public void insert(Employee emp) {
        root = insertRec(root, emp);
    }

    /**
     * Recursively inserts a new employee following BST ordering rules.
     * Employees are positioned alphabetically based on their name.
     *
     * @param current current node being evaluated
     * @param emp     employee being inserted
     * @return the updated subtree root after insertion
     */
    private TreeNode insertRec(TreeNode current, Employee emp) {

        // Base case: found empty spot → create a new node
        if (current == null) {
            return new TreeNode(emp);
        }

        // Navigate left or right depending on alphabetical ordering
        if (emp.getName().compareToIgnoreCase(current.data.getName()) < 0) {
            current.left = insertRec(current.left, emp);
        } else {
            current.right = insertRec(current.right, emp);
        }

        return current;
    }

    /**
     * Initiates a pre-order traversal of the tree.
     * Order: Node → Left → Right
     */
    public void preOrder() {
        System.out.println("\n--- PRE-ORDER TRAVERSAL ---");
        preOrderRec(root);
    }

    /** Recursive helper for pre-order traversal. */
    private void preOrderRec(TreeNode node) {
        if (node != null) {
            System.out.println(node.data); // process current employee
            preOrderRec(node.left);        // left subtree
            preOrderRec(node.right);       // right subtree
        }
    }

    /**
     * Initiates an in-order traversal of the tree.
     * Output is alphabetical because of BST ordering.
     */
    public void inOrder() {
        System.out.println("\n--- IN-ORDER TRAVERSAL ---");
        inOrderRec(root);
    }

    /** Recursive helper for in-order traversal. */
    private void inOrderRec(TreeNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }

    /**
     * Initiates a post-order traversal of the tree.
     * Order: Left → Right → Node
     */
    public void postOrder() {
        System.out.println("\n--- POST-ORDER TRAVERSAL ---");
        postOrderRec(root);
    }

    /** Recursive helper for post-order traversal. */
    private void postOrderRec(TreeNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.data);
        }
    }
}
