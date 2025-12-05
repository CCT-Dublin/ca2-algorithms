/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 * Represents a single employee in the system.
 * 
 * Each employee contains a name, a manager type, and a department.
 * The class is immutable: once created, the employee's details cannot change.
 *
 * @author mariana
 */

import enums.ManagerType;
import enums.Department;

public class Employee {
    
    //Basic employee attributes
    private final String name;
    private final ManagerType managerType;
    private final Department department;
    
    //Constructs a new Employee with the provided attributes
    public Employee(String name, ManagerType managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }
    //Returns the employee's full name
    public String getName() {
        return name;
    }
    //Returns the employee's manager type
    public ManagerType getManagerType() {
        return managerType;
    }
    //Returns the employee's department
    public Department getDepartment() {
        return department;
    }
    //Displays the employee in a readable format
    @Override
    public String toString() {
        return name + " - " + managerType.name() + " - " + department.name();
    }
}