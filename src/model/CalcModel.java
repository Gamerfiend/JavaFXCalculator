package src.model;

/**
 * Model class for Calculator, for storing data
 * @author Tyler Bezera
 * @version 1.0
 */
public class CalcModel
{
    private int leftNumber = -1;
    private int rightNumber = -1;
    private String operator = "";
    private double result = 0;

    /**
     * Constructor for model
     */
    public CalcModel()
    {
        //empty
    }

    /**
     * Getter for left side of equation
     *
     * @return The left operand
     */
    public int getLeftNumber()
    {
        return leftNumber;
    }

    /**
     * Setter for left side of equation
     * @param leftNumber number to be set
     */
    public void setLeftNumber(int leftNumber)
    {
        this.leftNumber = leftNumber;
    }


    /**
     * Getter for right side of equation
     * @return The right side of equation
     */
    public int getRightNumber()
    {
        return rightNumber;
    }

    /**
     * Setter for right side of equation
     * @param rightNumber number to be set on the right side of equation
     */
    public void setRightNumber(int rightNumber)
    {
        this.rightNumber = rightNumber;
    }

    /**
     * Getter for the operator
     * @return Current operator
     */
    public String getOperator()
    {
        return operator;
    }

    /**
     * Setter for the operator
     * @param operator Operator to be set
     */
    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    /**
     * Getter for the result of a calculation
     * @return result of a calculation
     */
    public double getResult()
    {
        return result;
    }

    /**
     * Setter for the result of a calculation
     * @param result result of calculation
     */
    public void setResult(double result)
    {
        this.result = result;
    }

    @Override
    public String toString()
    {
        return "CalcModel{" +
                "leftNumber=" + leftNumber +
                ", rightNumber=" + rightNumber +
                ", operator='" + operator + '\'' +
                ", result=" + result +
                '}';
    }
}
