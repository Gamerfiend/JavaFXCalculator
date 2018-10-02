package src.launch;

import javafx.application.Application;
import src.calculator.Calculator;
import src.ui.CalculatorUI;

public class Launcher
{
    public static void main(String[] args)
    {
        Application.launch(CalculatorUI.class, args);
    }
}
