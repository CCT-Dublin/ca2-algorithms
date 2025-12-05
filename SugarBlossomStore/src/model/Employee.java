/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.ManagerType;
import enums.Department;

/**
 * Represents a single employee in the system.
 * 
 * Each employee stores three key attributes:
 * - Full name
 * - Manager type (role within the organisation)
 * - Department
 * 
 * This class is immutable: once an employee is created, its attributes
 * cannot be modified. This design choice ensures data consistency
 * throughout the system.
 *
 * @author mariana
 */
public class Employee {

    /** Employee full name */
    private final String name;

    /** Type of managerial role assigned to the employee */
    private final ManagerType managerType;

    /** Department where the employee works */
    private final Department department;

    /**
     * Constructs a new Employee object with the provided attributes.
     *
     * @param name the employee's full name
     * @param managerType the assigned managerial role
     * @param department the department where the employee works
     */
    public Employee(String name, ManagerType managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    /**
     * Returns the employee's name.
     *
     * @return the full name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the employee's manager type.
     *
     * @return the managerial role assigned to the employee
     */
    public ManagerType getManagerType() {
        return managerType;
    }

    /**
     * Returns the employee's department.
     *
     * @return the department where the employee works
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Returns a readable string representation of the employee,
     * used when printing lists, search results, and traversals.
     *
     * @return formatted employee data
     */
    @Override
    public String toString() {
        return name + " - " + managerType.name() + " - " + department.name();
    }
}
