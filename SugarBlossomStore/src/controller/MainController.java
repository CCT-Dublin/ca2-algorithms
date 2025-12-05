/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
/**
 * MainController is the entry point of the application.
 *
 *This class is responsible for launching the main user interface
 * of the Sugar Blossom Department Store system. It initializes the 
 * {@link view.MenuView} and delegates control to it so that 
 * the program follows a MVC-based structure as required for the assingment.
 *
 * Responsibilities of this class:
 * 
 *Instantiate the main menu interface
 *Start the interactive loop handled by {@code MenuView}
 *Maintain a clear separation between the application launcher
 *and the rest of the logic
 * 
 *
 * This class contains only the {@code main} method and should not 
 * hold any business logic. All user interactions and data processing 
 * happens in the view, model, and utils packages.
 *
 *
 * @author mariana
 */

import view.MenuView;

public class MainController {
    public static void main(String[] args) {
        MenuView menu = new MenuView();
        menu.start();
    }
}

