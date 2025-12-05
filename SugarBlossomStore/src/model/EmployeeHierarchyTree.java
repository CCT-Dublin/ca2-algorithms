/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mariana
 */

import java.util.LinkedList;
import java.util.Queue;

public class EmployeeHierarchyTree {

    private EmployeeHierarchyNode root;

    // Inserção por nível (Level-Order)
    public void insert(Employee employee) {
        EmployeeHierarchyNode newNode = new EmployeeHierarchyNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<EmployeeHierarchyNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            EmployeeHierarchyNode current = q.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                q.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                q.add(current.right);
            }
        }
    }

    // Traversals
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
