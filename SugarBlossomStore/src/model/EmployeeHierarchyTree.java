/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a Binary Tree structure used to model an employee hierarchy.
 * 
 * Employees are inserted using a level-order (breadth-first) strategy.
 * This ensures the tree grows in a balanced manner, creating a structured
 * organisational chart — as required in the assignment specification.
 * 
 * The class also provides standard tree traversal methods:
 * Pre-order, In-order, and Post-order.
 *
 * These traversals allow the hierarchy to be viewed from different
 * organisational perspectives.
 *
 * @author mariana
 */
public class EmployeeHierarchyTree {

    /** Root node of the hierarchy tree */
    private EmployeeHierarchyNode root;

    /**
     * Inserts an employee into the hierarchy using level-order insertion.
     * 
     * This guarantees that each level is filled from left to right before
     * moving to the next, resulting in a balanced organisational structure.
     *
     * @param employee the employee to be inserted into the hierarchy
     */
    public void insert(Employee employee) {

        EmployeeHierarchyNode newNode = new EmployeeHierarchyNode(employee);

        // If tree is empty > new node becomes root
        if (root == null) {
            root = newNode;
            return;
        }

        // BFS queue used to find the next available child position
        Queue<EmployeeHierarchyNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            EmployeeHierarchyNode current = q.poll();

            // Insert into first available left position
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                q.add(current.left);
            }

            // Insert into first available right position
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                q.add(current.right);
            }
        }
    }

    /**
     * Displays the hierarchy using Pre-order traversal.
     * Order: node > left > right
     */
    public void preorder() {
        System.out.println("\n--- EMPLOYEE HIERARCHY (Pre-Order) ---");
        preorderRec(root);
    }

    private void preorderRec(EmployeeHierarchyNode node) {
        if (node != null) {
            System.out.println(node.data);  // Process current employee
            preorderRec(node.left);         // Visit left subtree
            preorderRec(node.right);        // Visit right subtree
        }
    }

    /**
     * Displays the hierarchy using In-order traversal.
     * Order: left > node > right
     */
    public void inorder() {
        System.out.println("\n--- EMPLOYEE HIERARCHY (In-Order) ---");
        inorderRec(root);
    }

    private void inorderRec(EmployeeHierarchyNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println(node.data);
            inorderRec(node.right);
        }
    }

    /**
     * Displays the hierarchy using Post-order traversal.
     * Order: left > right > node
     */
    public void postorder() {
        System.out.println("\n--- EMPLOYEE HIERARCHY (Post-Order) ---");
        postorderRec(root);
    }

    private void postorderRec(EmployeeHierarchyNode node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.println(node.data);
        }
    }
}
