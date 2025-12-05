/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *Main menu controller responsible for handling all user interactions,
 *input validation, and coordination between sorting, searching,
 *and binary tree operations.
 * 
 * @author mariana
 */

//imports
import enums.MenuOption;
import enums.ManagerType;
import enums.Department;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import model.ApplicantTree;

import model.BinaryTree;
import model.Employee;

import utils.FileReaderUtils;
import utils.MergeSortUtils;
import utils.BinarySearchUtils;


public class MenuView {
    
    //Stores all employee records created by the user during runtime
    private final List<Employee> employeeList = new ArrayList<>();
    
    //Single scanner instance used for reading all console inputs
    private final Scanner sc = new Scanner(System.in);

    // ------------------------------ UTILITIES ------------------------------
    
     //Reads a numeric input from the user and ensures it falls within
    //the inclusive range defined by 'min' and 'max'. Used for menu options
   //and numeric selections.
    private int readIntInRange(int min, int max) {
        while (true) {
            String input = sc.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.print("Invalid number! Please Choose between " + min + " and " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }
     //Reads and validates an employee name. Only letters and spaces are allowed.
    //Names are normalized using the capitalize() method.
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
   //Helper method that capitalizes each word in a name (e.g., "ana costa" > "Ana Costa")
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
     //Reads a manager type from the user. Accepts both numbers (menu index)
    //and full enum names (case-insensitive)
    private ManagerType readManagerType() {
        System.out.println("\nChoose Manager Type:");

        ManagerType[] types = ManagerType.values();

        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + " - " + types[i]);
        }

        System.out.print("Type NUMBER or NAME: ");

        while (true) {
            String input = sc.nextLine().trim();

            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= types.length) {
                    return types[num - 1];
                }
            } catch (NumberFormatException ignored) {}

            String normalized = input.toUpperCase().replace(" ", "_");

            try {
                return ManagerType.valueOf(normalized);
            } catch (IllegalArgumentException ignored) {}

            System.out.print("Invalid option! Type NUMBER or NAME: ");
        }
    }
     //Reads a department from the user. Accepts both numbers and textual input.
    private Department readDepartment() {
        System.out.println("\nChoose Department:");

        Department[] depts = Department.values();

        for (int i = 0; i < depts.length; i++) {
            System.out.println((i + 1) + " - " + depts[i]);
        }

        System.out.print("Type NUMBER or NAME: ");

        while (true) {
            String input = sc.nextLine().trim();

            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= depts.length) {
                    return depts[num - 1];
                }
            } catch (NumberFormatException ignored) {}

            String normalized = input.toUpperCase().replace(" ", "_");

            try {
                return Department.valueOf(normalized);
            } catch (IllegalArgumentException ignored) {}

            System.out.print("Invalid option! Type NUMBER or NAME: ");
        }
    }

    // ------------------------------ START MENU ------------------------------
    
    //Displays the main application menu and loops until the user chooses EXIT.
    public void start() {

        MenuOption option = null;

        do {
            System.out.println("\n===== Sugar Blossom Department Store =====");
            System.out.println("1. SORT");
            System.out.println("2. SEARCH");
            System.out.println("3. ADD RECORDS");
            System.out.println("4. CREATE BINARY TREE");
            System.out.println("5. CREATE APPLICANT BINARY TREE (from file)");
            System.out.println("6. EXIT");
            System.out.print("Choose an option: ");

            int choice = readIntInRange(1, 6);

            switch (choice) {
                case 1 -> option = MenuOption.SORT;
                case 2 -> option = MenuOption.SEARCH;
                case 3 -> option = MenuOption.ADD_RECORDS;
                case 4 -> option = MenuOption.CREATE_BINARY_TREE;
                case 5 -> option = MenuOption.APPLICANT_TREE;  
                case 6 -> option = MenuOption.EXIT;         
            }

            handleChoice(option);

        } while (option != MenuOption.EXIT);
    }

    // ------------------------------ OPTIONS HANDLER ------------------------------
    
    //Performs a case-insensitive partial search through the employee list
   //Returns all employees whose names contain the given substring
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
    //Handles the main menu logic based on the selected MenuOption
   //Each case triggers a different subsystem (sorting, searching, tree creation, etc.)
    private void handleChoice(MenuOption option) {
        System.out.println("\nSelected: " + option);

        switch (option) {

            case SORT -> {
                
                //Reads applicant names from file and sorts them alphabetically using Merge Sort
                List<String> names = FileReaderUtils.readNamesFromCSV("data/Applicants_Form.txt");
                List<String> sorted = MergeSortUtils.mergeSort(names);

                System.out.println("\n=== FIRST 20 SORTED NAMES ===");
                for (int i = 0; i < Math.min(20, sorted.size()); i++) {
                    System.out.println((i + 1) + ". " + sorted.get(i));
                }
            }

            case SEARCH -> {
    if (employeeList.isEmpty()) {
        //Prevents searching when no employees have been added yet

        System.out.println("\nNo employees added yet.");
        return;
    }

 System.out.print("\nEnter employee name (full or partial): ");
String target = sc.nextLine().trim();



    //Perform partial matching (supports searching by first name, last name, or fragments)
    List<Employee> matches = searchByPartialName(target);

    if (matches.isEmpty()) {
        System.out.println("\nNo matches found.");
        return;
    }

    if (matches.size() == 1) {
        Employee e = matches.get(0);
        System.out.println("\nFOUND:");
        System.out.println("- Name: " + e.getName());
        System.out.println("- Manager Type: " + e.getManagerType());
        System.out.println("- Department: " + e.getDepartment());
        return;
    }

    //Display all matches when more than one result is found.
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

            // Prevent insertion of employees with duplicate names (case-insensitive)
            case ADD_RECORDS -> {

                String name = readEmployeeName();
                ManagerType managerType = readManagerType();
                Department department = readDepartment();
                
                // --- DUPLICATE NAME VALIDATION ---
                for (Employee e : employeeList) {
                if (e.getName().equalsIgnoreCase(name)) {
                System.out.println("\n❌ Error: This employee name already exists.");
                System.out.println("Existing record → " + e);
                return;
    }
}

                Employee emp = new Employee(name, managerType, department);
                employeeList.add(emp);

                employeeList.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));

                System.out.println("\nEmployee added successfully!");
            }
            
            //Builds a Binary Search Tree using the current employee list.
           //The tree is ordered alphabetically by employee name.
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
            
            //Creates a Binary Search Tree using all names read from the Applicants_Form file
            case APPLICANT_TREE -> {
            List<String> applicants = FileReaderUtils.readNamesFromCSV("data/Applicants_Form.txt");

            if (applicants.isEmpty()) {
            System.out.println("\nApplicant file is empty or unreadable.");
            return;
        }
           
         //Creates a Binary Search Tree using all names read from the Applicants_Form file
         ApplicantTree tree = new ApplicantTree();
        for (String name : applicants) {
        tree.insert(name);
        }

        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
}
            // Terminates the program
            case EXIT -> System.out.println("Exiting...");
        }
    }
}
