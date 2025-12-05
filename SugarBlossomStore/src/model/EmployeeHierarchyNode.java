/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mariana
 */

public class EmployeeHierarchyNode {

    public Employee data;
    public EmployeeHierarchyNode left;
    public EmployeeHierarchyNode right;

    public EmployeeHierarchyNode(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
