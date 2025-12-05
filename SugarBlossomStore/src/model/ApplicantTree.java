/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Represents a Binary Search Tree (BST) structure used to store applicant names
 * loaded from the provided form file. Names are inserted based on alphabetical
 * order using standard BST rules.
 *
 * This tree supports three types of traversal:
 * - Pre-order  (Node → Left → Right)
 * - In-order   (Left → Node → Right) — produces alphabetical output
 * - Post-order (Left → Right → Node)
 *
 * All traversal outputs are printed directly to the console, as required
 * by the assignment specification.
 *
 * The class works together with {@link ApplicantNode}, which represents
 * each node in the tree.
 *
 * @author mariana
 */
public class ApplicantTree {

    private ApplicantNode root;

    /**
     * Inserts a new applicant name into the tree.
     * This method delegates the actual insertion to the recursive helper.
     *
     * @param name applicant name to be added to the BST
     */
    public void insert(String name) {
        root = insertRec(root, name);
    }

    /**
     * Recursively inserts a name into the tree following BST alphabetical rules.
     * - If the current position is null, a new node is created.
     * - If the name is alphabetically smaller, go to the left subtree.
     * - Otherwise, insert into the right subtree.
     *
     * @param current current tree node
     * @param name    name being inserted
     * @return the updated subtree root
     */
    private ApplicantNode insertRec(ApplicantNode current, String name) {

        if (current == null) {
            return new ApplicantNode(name); // base case
        }

        // Navigate left or right depending on alphabetical comparison
        if (name.compareToIgnoreCase(current.name) < 0) {
            current.left = insertRec(current.left, name);
        } else {
            current.right = insertRec(current.right, name);
        }

        return current;
    }

    /**
     * Displays a pre-order traversal of the applicant tree.
     * Format: Node → Left → Right
     */
    public void preOrder() {
        System.out.println("\n--- PRE-ORDER (Applicants) ---");
        preOrderRec(root);
    }

    /** Helper method for pre-order traversal. */
    private void preOrderRec(ApplicantNode node) {
        if (node != null) {
            System.out.println(node.name);
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    /**
     * Displays an in-order traversal of the tree.
     * Produces output in alphabetical order.
     */
    public void inOrder() {
        System.out.println("\n--- IN-ORDER (Applicants) ---");
        inOrderRec(root);
    }

    /** Helper method for in-order traversal. */
    private void inOrderRec(ApplicantNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.name);
            inOrderRec(node.right);
        }
    }

    /**
     * Displays a post-order traversal of the tree.
     * Format: Left → Right → Node
     */
    public void postOrder() {
        System.out.println("\n--- POST-ORDER (Applicants) ---");
        postOrderRec(root);
    }

    /** Helper method for post-order traversal. */
    private void postOrderRec(ApplicantNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.name);
        }
    }
}
