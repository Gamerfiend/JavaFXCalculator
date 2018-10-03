package src.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public static final int CALCULATOR_HEIGHT = 500;
    public static final int CALCULATOR_WIDTH = 500;
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

    private Button assembleButton()
    {
        return new Button();
    }

    private Scene assembleScene()
    {
        GridPane gridPane = new GridPane();
        gridPane.setId("main-grid-pane");



        return new Scene(gridPane, CALCULATOR_WIDTH, CALCULATOR_HEIGHT);
    }
}
