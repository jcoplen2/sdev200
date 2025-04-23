import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.sql.*;
import javafx.event.ActionEvent;

public class Main extends Application {

    Connection connection;

    // create text fields and labels
    TextField num1tf = new TextField();
    TextField num2tf = new TextField();
    TextField num3tf = new TextField();
    Label batchTimeLabel = new Label("0 ms");
    Label nonBatchTimeLabel = new Label("0 ms");

    @Override
    public void start(Stage primaryStage) {
        // create buttons
        Button batchbt = new Button("Batch Update");
        Button nonbatchbt = new Button("Non Batch Update");
        Button DBbt = new Button("Connect to Database");

        // button logic
        batchbt.setOnAction(e -> {
            // start time
            long start = System.currentTimeMillis();
            try {
                PreparedStatement stmt = connection
                        .prepareStatement("INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)");
                // batch random numbers
                for (int i = 0; i < 1000; i++) {
                    stmt.setDouble(1, Math.random());
                    stmt.setDouble(2, Math.random());
                    stmt.setDouble(3, Math.random());
                    stmt.addBatch();
                }
                stmt.executeBatch();
                // end time and elapsed
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                batchTimeLabel.setText(elapsed + " ms");
                ;

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        nonbatchbt.setOnAction(e -> {
            // start time
            long start = System.currentTimeMillis();
            try {
                PreparedStatement stmt = connection
                        .prepareStatement("INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)");
                // random number loop
                for (int i = 0; i < 1000; i++) {
                    stmt.setDouble(1, Math.random());
                    stmt.setDouble(2, Math.random());
                    stmt.setDouble(3, Math.random());
                    stmt.executeUpdate();
                }
                // end time and elapsed
                long end = System.currentTimeMillis();
                long elapsed = end - start;
                nonBatchTimeLabel.setText(elapsed + "ms");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        DBbt.setOnAction(e -> {
            try {
                // load driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded.");

                // connect to db
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Temp",
                        "root", "testpassword");
                System.out.println("Database connected.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // create pane
        VBox pane = new VBox(10,
                new HBox(10, new Label("Batch Elapsed Time"), batchTimeLabel),
                new HBox(10, new Label("Non Batch Elapsed Time"), nonBatchTimeLabel),
                new HBox(10, batchbt, nonbatchbt, DBbt));

        // set scene and show
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("35.1 Practice");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
