/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.MenuView;

/**
 * Entry point of the Sugar Blossom Department Store application.
 *
 * This class launches the main user interface by creating an instance of
 * MenuView and starting the program flow. It follows the MVC architecture,
 * keeping the system's startup logic separated from the rest of the application.
 *
 * Responsibilities:
 * - Initialize the main menu interface.
 * - Start the interactive loop handled by MenuView.
 * - Maintain separation between application startup and business logic.
 *
 * This class contains only the main method. All data handling, sorting,
 * searching, and tree operations are performed in other layers of the system.
 *
 * @author mariana
 */
public class MainController {

    /**
     * Launches the program by initializing the main menu.
     *
     * @param args Program arguments (not used)
     */
    public static void main(String[] args) {
        MenuView menu = new MenuView();
        menu.start();
    }
}


