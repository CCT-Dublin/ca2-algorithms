/*
 * Main menu and user interaction handler.
 * This class is responsible for displaying the system menu, validating input,
 * and coordinating all features such as sorting, searching, and tree creation.
 */
package view;

// Imports
import enums.MenuOption;
import enums.ManagerType;
import enums.Department;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import model.BinaryTree;
import model.Employee;
import model.ApplicantTree;
import model.EmployeeHierarchyTree;

import utils.FileReaderUtils;
import utils.MergeSortUtils;
import utils.BinarySearchUtils;

/**
 * Handles all user interaction for the Sugar Blossom Department Store system.
 *
 * This class:
 * - Displays the main menu
 * - Validates and processes all user input
 * - Manages employee records created during runtime
 * - Triggers sorting, searching, and binary tree operations
 *
 * It acts as the central controller that connects the view layer to the logic
 * implemented in the model and utils packages.
 *
 * @author mariana
 */
public class MenuView {

    // Stores all employee records added by the user
    private final List<Employee> employeeList = new ArrayList<>();

    // Single Scanner instance shared across the class
    private final Scanner sc = new Scanner(System.in);


    // =====================================================================
    //                           INPUT UTILITIES
    // =====================================================================

    /**
     * Reads a numeric input and ensures it falls inside a valid range.
     */
    private int readIntInRange(int min, int max) {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.print("Invalid number! Choose between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }

    /**
     * Reads an employee name and validates it (letters and spaces only).
     */
    private String readEmployeeName() {
        while (true) {
            System.out.print("\nEnter employee name: ");
            String name = sc.nextLine().trim();

            if (name.matches("^[A-Za-z ]{2,}$")) {
                return capitalize(name);
            }
            System.out.println("Invalid name! Only letters and spaces allowed.");
        }
    }

    /**
     * Converts each word of a name into capitalized form.
     */
    private String capitalize(String x) {
        String[] parts = x.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        for (String p : parts) {
            if (!p.isBlank()) {
                sb.append(Character.toUpperCase(p.charAt(0)))
                  .append(p.substring(1))
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * Reads a ManagerType enum from the user by number or text.
     */
    private ManagerType readManagerType() {
        System.out.println("\nChoose Manager Type:");
        ManagerType[] types = ManagerType.values();

        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + " - " + types[i]);
        }

        System.out.print("Type NUMBER or NAME: ");

        while (true) {
            String input = sc.nextLine().trim();

            // Option entered as number
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= types.length) {
                    return types[num - 1];
                }
            } catch (NumberFormatException ignored) {}

            // Option entered as text
            String normalized = input.toUpperCase().replace(" ", "_");

            try {
                return ManagerType.valueOf(normalized);
            } catch (IllegalArgumentException ignored) {}

            System.out.print("Invalid option! Type NUMBER or NAME: ");
        }
    }

    /**
     * Reads a Department enum from the user by number or text.
     */
    private Department readDepartment() {
        System.out.println("\nChoose Department:");
        Department[] depts = Department.values();

        for (int i = 0; i < depts.length; i++) {
            System.out.println((i + 1) + " - " + depts[i]);
        }

        System.out.print("Type NUMBER or NAME: ");

        while (true) {
            String input = sc.nextLine().trim();

            // Option entered as number
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= depts.length) {
                    return depts[num - 1];
                }
            } catch (NumberFormatException ignored) {}

            // Option entered as text
            String normalized = input.toUpperCase().replace(" ", "_");

            try {
                return Department.valueOf(normalized);
            } catch (IllegalArgumentException ignored) {}

            System.out.print("Invalid option! Type NUMBER or NAME: ");
        }
    }


    // =====================================================================
    //                           MAIN MENU LOOP
    // =====================================================================

    /**
     * Starts the main menu loop until the user chooses EXIT.
     */
    public void start() {

        MenuOption option = null;

        do {
            System.out.println("\n===== Sugar Blossom Department Store =====");
            System.out.println("1. SORT");
            System.out.println("2. SEARCH");
            System.out.println("3. ADD RECORDS");
            System.out.println("4. CREATE BINARY TREE");
            System.out.println("5. CREATE APPLICANT BINARY TREE (from file)");
            System.out.println("6. EMPLOYEE HIERARCHY TREE");
            System.out.println("7. EXIT");
            System.out.print("Choose an option: ");

            int choice = readIntInRange(1, 7);

            switch (choice) {
                case 1 -> option = MenuOption.SORT;
                case 2 -> option = MenuOption.SEARCH;
                case 3 -> option = MenuOption.ADD_RECORDS;
                case 4 -> option = MenuOption.CREATE_BINARY_TREE;
                case 5 -> option = MenuOption.APPLICANT_TREE;
                case 6 -> option = MenuOption.EMPLOYEE_HIERARCHY;
                case 7 -> option = MenuOption.EXIT;
            }

            handleChoice(option);

        } while (option != MenuOption.EXIT);
    }


    // =====================================================================
    //                        MENU OPTION HANDLERS
    // =====================================================================

    /**
     * Partial case-insensitive search through employee names.
     */
    private List<Employee> searchByPartialName(String input) {
        List<Employee> results = new ArrayList<>();
        String normalized = input.toLowerCase();

        for (Employee e : employeeList) {
            if (e.getName().toLowerCase().contains(normalized)) {
                results.add(e);
            }
        }
        return results;
    }

    /**
     * Executes one of the menu options selected by the user.
     */
    private void handleChoice(MenuOption option) {
        System.out.println("\nSelected: " + option);

        switch (option) {

            // SORT — reads from file and applies Merge Sort
            case SORT -> {
                List<String> names = FileReaderUtils.readNamesFromCSV("data/Applicants_Form.txt");
                List<String> sorted = MergeSortUtils.mergeSort(names);

                System.out.println("\n=== FIRST 20 SORTED NAMES ===");
                for (int i = 0; i < Math.min(20, sorted.size()); i++) {
                    System.out.println((i + 1) + ". " + sorted.get(i));
                }
            }

            // SEARCH — partial search for employees
            case SEARCH -> {

                if (employeeList.isEmpty()) {
                    System.out.println("\nNo employees added yet.");
                    return;
                }

                System.out.print("\nEnter employee name (full or partial): ");
                String target = sc.nextLine().trim();

                List<Employee> matches = searchByPartialName(target);

                if (matches.isEmpty()) {
                    System.out.println("\nNo matches found.");
                    return;
                }

                // Single match
                if (matches.size() == 1) {
                    Employee e = matches.get(0);
                    System.out.println("\nFOUND:");
                    System.out.println("- Name: " + e.getName());
                    System.out.println("- Manager Type: " + e.getManagerType());
                    System.out.println("- Department: " + e.getDepartment());
                    return;
                }

                // Multiple matches
                System.out.println("\nMultiple results found:\n");
                for (int i = 0; i < matches.size(); i++) {
                    System.out.println((i + 1) + " - " + matches.get(i).getName());
                }

                System.out.print("\nChoose the number: ");
                int choice = readIntInRange(1, matches.size());
                Employee chosen = matches.get(choice - 1);

                System.out.println("\nFOUND:");
                System.out.println("- Name: " + chosen.getName());
                System.out.println("- Manager Type: " + chosen.getManagerType());
                System.out.println("- Department: " + chosen.getDepartment());
            }

            // ADD RECORDS — includes duplicate name validation
            case ADD_RECORDS -> {

                String name = readEmployeeName();
                ManagerType managerType = readManagerType();
                Department department = readDepartment();

                // Duplicate name check
                for (Employee e : employeeList) {
                    if (e.getName().equalsIgnoreCase(name)) {
                        System.out.println("\nError: This employee name already exists.");
                        System.out.println("Existing record: " + e);
                        return;
                    }
                }

                Employee emp = new Employee(name, managerType, department);
                employeeList.add(emp);

                // Keep alphabetical order
                employeeList.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));

                System.out.println("\nEmployee added successfully!");
            }

            // BST of employees
            case CREATE_BINARY_TREE -> {

                if (employeeList.size() < 2) {
                    System.out.println("Add at least 2 employees first.");
                    return;
                }

                BinaryTree tree = new BinaryTree();

                for (Employee emp : employeeList) {
                    tree.insert(emp);
                }

                tree.preOrder();
                tree.inOrder();
                tree.postOrder();
            }

            // BST of applicants from file
            case APPLICANT_TREE -> {

                List<String> applicants = FileReaderUtils.readNamesFromCSV("data/Applicants_Form.txt");

                if (applicants.isEmpty()) {
                    System.out.println("\nApplicant file is empty or unreadable.");
                    return;
                }

                ApplicantTree tree = new ApplicantTree();
                for (String name : applicants) {
                    tree.insert(name);
                }

                tree.preOrder();
                tree.inOrder();
                tree.postOrder();
            }

            // Level-order hierarchy tree for employees
            case EMPLOYEE_HIERARCHY -> {

                EmployeeHierarchyTree tree = new EmployeeHierarchyTree();

                for (Employee emp : employeeList) {
                    tree.insert(emp);
                }

                tree.preorder();
                tree.inorder();
                tree.postorder();
            }

            // EXIT
            case EXIT -> System.out.println("Exiting...");
        }
    }
}
