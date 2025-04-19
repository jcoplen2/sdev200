import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create circle
        Circle circle = new Circle(125, 150, 50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Pane pane = new Pane();
        pane.getChildren().add(circle);

        // turn black on mouse press using Lambda
        circle.setOnMousePressed((MouseEvent e) -> {
            circle.setFill(Color.BLACK);
        });

        // turn white when released using Lambda
        circle.setOnMouseReleased((MouseEvent e) -> {
            circle.setFill(Color.WHITE);
        });

        // create scene
        Scene scene = new Scene(pane, 250, 300);
        primaryStage.setTitle("Colored Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // launch method
    public static void main(String[] args) {
        launch(args);
    }
}
