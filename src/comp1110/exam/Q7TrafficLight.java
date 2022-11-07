package comp1110.exam;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.*;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Q7TrafficLight extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    private final Group root = new Group();
    private final VBox controls = new VBox();
    private final VBox signals = new VBox();

    private final Paint GREEN = Color.GREEN;
    private final Paint RED = Color.RED;
    private final Paint GRAY = Color.GRAY;
    
    /**
     * Helper method to set the colour of a shape object. (This is
     * provided just so that you don't need to search the javafx
     * documentation for the right method.)
     */
    private void setColor(Shape object, Paint color) {
	object.setFill(color);
    }

    /**
     * FIXME: Complete the event handlers for the three Buttons created
     * in this method to make the application have the behaviour specified
     * in the question:
     * - when the "Go" button is pressed, set the lower circle to GREEN
     *   and the upper circle to GRAY;
     * - when the "Stop" button is pressed, set the upper circle to RED
     *   and the lower circle to GRAY;
     * - when the "Reset" button is pressed, set both circles to GRAY.
     */
    private void makeControls() {
        Button goButton = new Button("Go");
	goButton.setMinWidth(75);
	goButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    // FIXME: complete this event handler
		}
	    });
        Button stopButton = new Button("Stop");
	stopButton.setMinWidth(75);
	// dev: solution
	stopButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    // FIXME: complete this event handler
		}
	    });
        Button resetButton = new Button("Reset");
	resetButton.setMinWidth(75);
	// dev: solution
	resetButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent e) {
		    // FIXME: complete this event handler
		}
	    });
        controls.getChildren().addAll(goButton, stopButton, resetButton);
    }

    private void makeSignals() {
        Circle upperCircle = new Circle(150, 150, 145);
        Circle lowerCircle = new Circle(150, 450, 145);
        signals.getChildren().addAll(upperCircle, lowerCircle);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Traffic Light Controller");
        Scene scene = new Scene(root, WIDTH, HEIGHT);

	makeControls();
        controls.setSpacing(10);
	makeSignals();
        signals.setSpacing(10);
	
	HBox b = new HBox();
	b.getChildren().addAll(controls, signals);
        b.setSpacing(20);
        root.getChildren().add(b);

	// Initially set both lights to gray
	setColor((Shape)(signals.getChildren().get(0)), GRAY);
	setColor((Shape)(signals.getChildren().get(1)), GRAY);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
