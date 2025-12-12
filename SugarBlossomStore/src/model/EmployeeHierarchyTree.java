/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a binary tree structure used to model the employee hierarchy.
 *
 * Unlike the Binary Search Tree used for alphabetical employee ordering,
 * this hierarchy tree uses level-order (breadth-first) insertion. This means
 * each new employee is added to the first available position from left to right,
 * ensuring the tree grows in a balanced, complete manner.
 *
 * This design is useful for visualising an organisational chart and
 * demonstrates understanding of queue-based tree construction, as required
 * in the assignment.
 *
 * The class also provides the three standard tree traversal methods:
 * - Pre-order  (node > left > right)
 * - In-order   (left > node > right)
 * - Post-order (left > right > node)
 *
 * These views allow the hierarchy to be interpreted from different structural
 * perspectives.
 *
 * @author mariana
 */
public class EmployeeHierarchyTree {

    /** Root node of the hierarchy tree */
    private EmployeeHierarchyNode root;

    /**
     * Inserts an employee into the hierarchy using level-order insertion.
     *
     * A queue is used to perform a breadth-first search (BFS) to locate the
     * first available position. This approach ensures the tree is kept as
     * balanced as possible and preserves a complete-tree structure.
     *
     * @param employee the employee to be inserted into the hierarchy
     */
    public void insert(Employee employee) {

        EmployeeHierarchyNode newNode = new EmployeeHierarchyNode(employee);

        // If tree is empty → new node becomes root
        if (root == null) {
            root = newNode;
            return;
        }

        // Queue used to explore the tree level by level
        Queue<EmployeeHierarchyNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            EmployeeHierarchyNode current = q.poll();

            // Insert into left child if available
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                q.add(current.left);
            }

            // Insert into right child if available
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
            System.out.println(node.data);
            preorderRec(node.left);
            preorderRec(node.right);
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
    // ====================== NODE COUNT ======================
public int countNodes() {
    return countNodesRec(root);
}

private int countNodesRec(EmployeeHierarchyNode node) {
    if (node == null) return 0;
    return 1 + countNodesRec(node.left) + countNodesRec(node.right);
}

// ====================== TREE HEIGHT ======================
public int height() {
    return heightRec(root);
}

private int heightRec(EmployeeHierarchyNode node) {
    if (node == null) return -1;
    return 1 + Math.max(heightRec(node.left), heightRec(node.right));
}

}
