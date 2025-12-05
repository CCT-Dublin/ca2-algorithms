/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Represents a node inside the Employee Hierarchy Binary Tree.
 * 
 * Each node stores:
 * - An Employee object
 * - A reference to the left child (alphabetically smaller)
 * - A reference to the right child (alphabetically larger)
 *
 * This structure is used exclusively for the organisational hierarchy
 * generated during the "Employee Hierarchy Tree" feature in the system.
 *
 * @author mariana
 */
public class EmployeeHierarchyNode {

    /** Employee stored at this node */
    public Employee data;

    /** Left child node (names that come alphabetically before this one) */
    public EmployeeHierarchyNode left;

    /** Right child node (names that come alphabetically after this one) */
    public EmployeeHierarchyNode right;

    /**
     * Constructs a new EmployeeHierarchyNode containing the given employee.
     *
     * @param data the Employee object stored at this node
     */
    public EmployeeHierarchyNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
