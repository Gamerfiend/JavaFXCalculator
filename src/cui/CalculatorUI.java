package src.cui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * CalculatorUI inherits from JavaFX application, and it handles all the visual functionality of the
 * application. For this specific purpose, it creates a grid pane, and adds to it the buttons and boxes
 * responsible for the calculator to function.
 *
 * @author Tyler Bezera
 * @version 1.0
 */
public class CalculatorUI extends Application
{
    public static final int CALCULATOR_HEIGHT = 200;
    public static final int CALCULATOR_WIDTH = 200;

    public static final int NUM_COLS = 3;
    public static final int NUM_BOXES = 3;

    public static final int COLUMN_CONSTRAINTS_WIDTH = 40;
    public static final String[] CalculatorButtonFaces = {"7", "8", "9", "+", "4", "5", "6",
            "-", "1", "2", "3", "*", "0", "Enter", "/"};

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = assembleScene();
        scene.getStylesheets().add("styles/styles.css");

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button assembleButton(String displayText, EventHandler<ActionEvent> onPressed)
    {
        Button newButton = new Button();
        newButton.setText(displayText);
        newButton.setOnAction(onPressed);
        newButton.setMaxWidth(Double.MAX_VALUE);
        newButton.getStyleClass().add("calculator-buttons");
        return newButton;
    }

    private GridPane assembleGridPane()
    {
        GridPane gridPane = new GridPane();

        gridPane.setId("main-grid-pane");

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setPadding(new Insets(10));

        ObservableList<ColumnConstraints> columnConstraints = gridPane.getColumnConstraints();

        for (int i = 1; i <= NUM_COLS; i++)
        {
            columnConstraints.add(new ColumnConstraints(COLUMN_CONSTRAINTS_WIDTH));
        }

        return gridPane;
    }

    private GridPane addToGridPane(GridPane gridPane, Node itemToAdd, int columnIndex, int rowIndex, int colSpan)
    {
        gridPane.add(itemToAdd, columnIndex, rowIndex, colSpan, 1);
        return gridPane;
    }

    private Scene assembleScene()
    {
        GridPane gridPane = assembleGridPane();

        Label calculatorScreen = new Label();
        calculatorScreen.setText("0");
        calculatorScreen.setId("calculator-screen");
        calculatorScreen.setAlignment(Pos.CENTER_RIGHT);
        calculatorScreen.setMaxWidth(Double.MAX_VALUE);

        addToGridPane(gridPane, calculatorScreen, 0, 0, 4);

        int rowIndex = 1;
        int columnIndex = 1;
        for(String element : CalculatorButtonFaces)
        {
            if(columnIndex % 4 == 1)
            {
                rowIndex++;
                columnIndex = 1;
            }

            if (element.equals("Enter"))
            {
                gridPane = addToGridPane(gridPane,
                        assembleButton(element, null),
                        columnIndex - 1, rowIndex - 1, 2);
                columnIndex++;
            }
            else
            {
                gridPane = addToGridPane(gridPane,
                        assembleButton(element, event -> System.out.println(element)),
                        columnIndex - 1, rowIndex - 1, 1);
            }

            columnIndex += 1;

        }
        return new Scene(gridPane, CALCULATOR_WIDTH, CALCULATOR_HEIGHT);
    }
}
