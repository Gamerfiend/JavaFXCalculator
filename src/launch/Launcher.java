package src.launch;

import javafx.application.Application;
import src.ui.CalculatorUI;

/**
 * Launcher class is very simply a wrapper that launches the calculator application
 *
 * @author Tyler Bezera
 * @version 1.0
 */
public class Launcher
{
    public static void main(String[] args)
    {
        Application.launch(CalculatorUI.class, args);
    }
}
