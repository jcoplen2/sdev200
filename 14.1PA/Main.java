import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create pane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        // add nodes to pane
        pane.add(new ImageView(new Image("file:/C:/Users/jessi/sdev200/14.1PA/flag1.gif")), 0, 0);
        pane.add(new ImageView(new Image("file:/C:/Users/jessi/sdev200/14.1PA/flag2.gif")), 1, 0);
        pane.add(new ImageView(new Image("file:/C:/Users/jessi/sdev200/14.1PA/flag6.gif")), 0, 1);
        pane.add(new ImageView(new Image("file:/C:/Users/jessi/sdev200/14.1PA/flag7.gif")), 1, 1);

        // create scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Flag Grid");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // main method to run
    public static void main(String[] args) {
        launch(args);
    }
}
