package me.maurithiol.sudoku;

import me.maurithiol.sudoku.handle.Controller;

/**
 * The main entry point class of the sudoku application
 */
public class App {

    /**
     * The entry point of the sudoku application
     *
     * @param args command line arguments passed to the program, which are not used in this application
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }

}