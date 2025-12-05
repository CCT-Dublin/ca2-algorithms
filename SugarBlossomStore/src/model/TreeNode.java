/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Represents a single node inside the binary search tree.
 *
 * Each node stores an Employee object and references to its
 * left and right child nodes. This structure supports ordered
 * insertion and traversal within the BinaryTree class.
 *
 * The tree uses alphabetical ordering based on the employee name.
 *
 * @author mariana
 */
public class TreeNode {

    /** Employee stored in this node */
    public Employee data;

    /** Reference to the left child (stores employees with smaller names) */
    public TreeNode left;

    /** Reference to the right child (stores employees with larger names) */
    public TreeNode right;

    /**
     * Creates a new TreeNode containing the given employee.
     * Both child references are initialised to null.
     *
     * @param data the employee object stored in this node
     */
    public TreeNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
