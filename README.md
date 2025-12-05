CA2 – Algorithms & Architecture
Sugar Blossom Department Store – Employee & Applicant Data Processing System

This project was developed for CA2 – Algorithms and Architecture, focusing on algorithm design, data processing, file handling, and tree-based data structures.
The application simulates a management system for a fictional retail store, Sugar Blossom Department Store, allowing sorting, searching, and organizing both employees and applicants using different algorithmic strategies.

 Main Features
 Merge Sort

Reads applicant names from a file (Applicants_Form.txt) and sorts them alphabetically.
Only the first 20 sorted names are displayed, as required.

Partial Search + Binary Search (for validation)

Users can search employees by:

full name

partial name

fragments (e.g., “ana”, “olive”, “john”, etc.)

If multiple matches exist, the system displays numbered options.

Add Employee Records

Each employee has:

Name

Manager Type

Department

Names are validated and automatically stored in alphabetical order.

 Binary Search Tree (Employees)

Creates a BST using all employees added during runtime.
Shows three mandatory traversals:

Pre-order

In-order

Post-order

 Binary Search Tree (Applicants from file)

Loads all applicants from Applicants_Form.txt
Builds a BST based on alphabetical ordering and outputs the same three traversals.

 Employee Hierarchy Tree (Level-Order Insertion)

Simulates a hierarchy chart by inserting nodes using level-order logic rather than alphabetical sorting.
Displays:

Pre-order

In-order

Post-order

This tree demonstrates structural differences compared to the BST.

 Project Structure
SugarBlossomStore/
│
├── data/
│   └── Applicants_Form.txt
│
├── src/
│   ├── controller/
│   │   └── MainController.java
│   │
│   ├── enums/
│   │   ├── Department.java
│   │   ├── ManagerType.java
│   │   └── MenuOption.java
│   │
│   ├── model/
│   │   ├── ApplicantNode.java
│   │   ├── ApplicantTree.java
│   │   ├── Employee.java
│   │   ├── TreeNode.java
│   │   ├── EmployeeHierarchyNode.java
│   │   └── EmployeeHierarchyTree.java
│   │
│   ├── utils/
│   │   ├── FileReaderUtils.java
│   │   ├── MergeSortUtils.java
│   │   └── BinarySearchUtils.java
│   │
│   └── view/
│       └── MenuView.java
│
└── README.md   (this file)

 How to Run the Project

Open NetBeans

Clone the repository or import the folder

Run MainController.java

Use the menu to navigate through system features

 Algorithms Used
Feature	Algorithm	Complexity
Sorting applicants	Merge Sort	O(n log n)
Searching employees	Partial Search (linear)	O(n)
Applicant BST	Binary Search Tree insertion	O(log n) average
Employee BST	Binary Search Tree insertion	O(log n) average
Hierarchy Tree	Level-order insertion	O(n)
Requirements Completed

This project includes all mandatory components:

 Merge Sort implemented manually

 Partial + binary search mechanisms

 Read data from a text file

 Create employee records manually

 Binary Search Tree with 3 traversals

 Applicant Binary Tree (from file)

 Employee Hierarchy Tree

 Fully documented with JavaDoc-style comments

 Clean, professional structure (MVC + Utils + Model)

 Developed by=

Mariana Dias, Student number: 2023167
CCT College Dublin
Computing Science – Year 3
