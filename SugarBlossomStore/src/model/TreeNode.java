/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 * Represents a single node inside the binary search tree.
 *
 * Each node stores an Employee object and references to its
 * left and right child nodes. This structure allows ordered
 * insertion and traversal operations in the BinaryTree class.
 *
 * @author mariana
 */

public class TreeNode {
    
    //Employee stored in this node
    public Employee data;
    
    //Child references (left:smaller names  right:larger names)
    public TreeNode left;
    public TreeNode right;
    
    //Creates a new TreeNode containing the given employee.
    // Both child references are initialized to null.
    public TreeNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}