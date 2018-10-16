package src.controller;

import src.model.CalcModel;
import src.views.CalculatorUI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for Calculator, communicates between model and view. Process data for model
 *
 * @author Tyler Bezera
 * @version 1.0
 */
public class CalcController
{

    private static final String[] Operators = {"-", "*", "+", "/", "CE"};
    public static final int OPERAND_NOT_SET = -1;
    private final Map<String, Integer> stringNumberToInt;
    private CalcModel model;
    private CalculatorUI viewReference;

    /**
     * Constructor for Controller, creates a new model and creates a hashmap of numbers
     * @param viewReference reference to the view for the calculator
     */
    public CalcController(CalculatorUI viewReference)
    {
        this.viewReference =viewReference;
        model = new CalcModel();
        stringNumberToInt = new HashMap<>();
        stringNumberToInt.put("0", 0);
        stringNumberToInt.put("1", 1);
        stringNumberToInt.put("2", 2);
        stringNumberToInt.put("3", 3);
        stringNumberToInt.put("4", 4);
        stringNumberToInt.put("5", 5);
        stringNumberToInt.put("6", 6);
        stringNumberToInt.put("7", 7);
        stringNumberToInt.put("8", 8);
        stringNumberToInt.put("9", 9);
    }

    private int getIntFromString(String number)
    {
        return stringNumberToInt.get(number);
    }

    private void calculate()
    {
        switch (model.getOperator())
        {
            case "+":
                 model.setResult(model.getLeftNumber() + model.getRightNumber());
                 break;
            case "-":
                 model.setResult(model.getLeftNumber() - model.getRightNumber());
                 break;
            case "*":
                 model.setResult(model.getLeftNumber() * model.getRightNumber());
                 break;
            case "/":
                if(model.getRightNumber() == 0)
                {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                else
                {
                    model.setResult(model.getLeftNumber() / model.getRightNumber());
                }
                break;
        }

        viewReference.updateLabel(String.valueOf(model.getResult()));
        model = new CalcModel();

    }

    private boolean isOperator(String element)
    {
        return Arrays.asList(Operators).contains(element);
    }

    private void processOperator(String element)
    {
        System.out.println("Operator: " + element + " was pressed.");
        if(model.getLeftNumber() != OPERAND_NOT_SET)
        {
            model.setOperator(element);
            viewReference.updateLabel(element);
        }
        if(element.equals("CE"))
        {
            viewReference.updateLabel("0");
            model = new CalcModel();
        }
    }

    private void processNumber(int number)
    {
        if(model.getLeftNumber() == OPERAND_NOT_SET)
        {
            model.setLeftNumber(number);
            viewReference.updateLabel(String.valueOf(number));
        }
        else if(model.getLeftNumber() != OPERAND_NOT_SET && model.getOperator().equals(""))
        {
            model.setLeftNumber(Integer.parseInt(String.valueOf(model.getLeftNumber()) + String.valueOf(number)));
            viewReference.updateLabel(String.valueOf(model.getLeftNumber()));
        }
        else if(!model.getOperator().equals("") && model.getRightNumber() == OPERAND_NOT_SET)
        {
            model.setRightNumber(number);
            viewReference.updateLabel(String.valueOf(number));
        }
        else if(!model.getOperator().equals("") && model.getRightNumber() != OPERAND_NOT_SET)
        {
            model.setRightNumber(Integer.parseInt(String.valueOf(model.getRightNumber()) + String.valueOf(number)));
            viewReference.updateLabel(String.valueOf(model.getRightNumber()));
        }
    }

    private boolean isEnter(String element)
    {
        return element.equals("Enter");
    }

    private boolean calculatorCanCalulate()
    {
        return (model.getLeftNumber() != OPERAND_NOT_SET &&
                model.getRightNumber() != OPERAND_NOT_SET &&
                !model.getOperator().equals(""));
    }

    /**
     * Process an action on calculator
     * @param element element that was pressed
     */
    public void processEvent(String element)
    {
        System.out.println(element + " was pressed");
        if(isOperator(element))
        {
            processOperator(element);
        }
        else if(isEnter(element))
        {
            if(calculatorCanCalulate())
            {
                calculate();
            }
        }
        else
        {
            processNumber(getIntFromString(element));
        }
    }

    @Override
    public String toString()
    {
        return "";
    }
}
