package src.ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public static final int CALCULATOR_HEIGHT = 300;
    public static final int CALCULATOR_WIDTH = 350;

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
        return newButton;
    }

    private GridPane assembleGridPane(String styleID, int hGap, int vGap, int insetAmount, int numberColumns, int columnConstraintsWidth)
    {
        GridPane gridPane = new GridPane();

        gridPane.setId(styleID);

        gridPane.setHgap(hGap);
        gridPane.setVgap(vGap);

        gridPane.setPadding(new Insets(insetAmount));

        ObservableList<ColumnConstraints> columnConstraints = gridPane.getColumnConstraints();

        for (int i = 1; i <= numberColumns; i++)
        {
            columnConstraints.add(new ColumnConstraints(columnConstraintsWidth));
        }

        return gridPane;
    }

    private GridPane addToGridPane(GridPane gridPane, Node itemToAdd, int columnIndex, int rowIndex, int colSpan, int rowSpan)
    {
        gridPane.add(itemToAdd, columnIndex, rowIndex, colSpan, rowSpan);
        return gridPane;
    }

    private Scene assembleScene()
    {
        GridPane gridPane = assembleGridPane("main-grid-pane", 10, 10, 10, NUM_COLS, COLUMN_CONSTRAINTS_WIDTH);
        int counter = 0;
        for(String element : CalculatorButtonFaces)
        {
            gridPane = addToGridPane(gridPane, assembleButton(element, null), counter, counter, 1, 1);
            counter += 1;
        }
        return new Scene(gridPane, CALCULATOR_WIDTH, CALCULATOR_HEIGHT);
    }
}
