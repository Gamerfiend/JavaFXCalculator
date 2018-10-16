package src.launch;

import javafx.application.Application;
import src.views.CalculatorUI;

/**
 * Launcher class is very simply a wrapper that launches the calculator application
 *
 * @author Tyler Bezera
 * @version 1.0
 */
public class Launcher
{
    /**
     * Main method that runs the program, uses static application from JavaFX to launch, taking a reference to our
     * Calculator Class
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Application.launch(CalculatorUI.class, args);
    }
}
