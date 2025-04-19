import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {

    // create text
    Text message = new Text(20, 20, "Show Color");

    @Override
    public void start(Stage primaryStage) {

        // set default text color and size
        message.setFill(Color.BLACK);
        message.setFont(Font.font("Courier", FontWeight.BOLD, 30));

        // create sliders
        ScrollBar redScrollbar = new ScrollBar();
        redScrollbar.setMax(255);

        ScrollBar greenScrollbar = new ScrollBar();
        greenScrollbar.setMax(255);

        ScrollBar blueScrollbar = new ScrollBar();
        blueScrollbar.setMax(255);

        ScrollBar opacityScrollbar = new ScrollBar();
        opacityScrollbar.setMax(1);
        opacityScrollbar.setValue(1);

        // VBox to hold scrollbars
        VBox scrollBarBox = new VBox(10, redScrollbar, greenScrollbar, blueScrollbar, opacityScrollbar);

        // listeners for scroll bars
        redScrollbar.valueProperty().addListener(ov -> {
            updateColor(message, redScrollbar, greenScrollbar, blueScrollbar, opacityScrollbar);
        });

        greenScrollbar.valueProperty().addListener(ov -> {
            updateColor(message, redScrollbar, greenScrollbar, blueScrollbar, opacityScrollbar);
        });

        blueScrollbar.valueProperty().addListener(ov -> {
            updateColor(message, redScrollbar, greenScrollbar, blueScrollbar, opacityScrollbar);
        });

        opacityScrollbar.valueProperty().addListener(ov -> {
            updateColor(message, redScrollbar, greenScrollbar, blueScrollbar, opacityScrollbar);
        });

        // layout
        BorderPane pane = new BorderPane();
        pane.setTop(message);
        pane.setBottom(scrollBarBox);

        // set scene
        Scene scene = new Scene(pane, 450, 300);
        primaryStage.setTitle("Color Scroll");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // method for changing color
    public void updateColor(Text message, ScrollBar redScrollbar, ScrollBar greenScrollbar, ScrollBar blueScrollbar,
            ScrollBar opacityScrollbar) {
        Color color = new Color(
                redScrollbar.getValue() / 255,
                greenScrollbar.getValue() / 255,
                blueScrollbar.getValue() / 255,
                opacityScrollbar.getValue());
        // change text color
        message.setFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
