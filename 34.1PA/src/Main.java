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
    // database connection
    private Connection connection;

    // inputs
    private TextField tfID = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMI = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();

    @Override
    public void start(Stage primaryStage) {
        initializeDB();

        // create UI
        // add buttons
        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");
        Button btClear = new Button("Clear");

        // button logic

        btView.setOnAction((ActionEvent e) -> {
            try {
                PreparedStatement stmt = connection.prepareStatement(
                        "SELECT * FROM staff WHERE id = ?");
                stmt.setInt(1, Integer.parseInt(tfID.getText()));
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    tfLastName.setText(rs.getString("lastName"));
                    tfFirstName.setText(rs.getString("firstName"));
                    tfMI.setText(rs.getString("mi"));
                    tfAddress.setText(rs.getString("address"));
                    tfCity.setText(rs.getString("city"));
                    tfState.setText(rs.getString("state"));
                    tfTelephone.setText(rs.getString("telephone"));
                    tfEmail.setText(rs.getString("email"));
                } else {
                    System.out.println("No record found for ID " + tfID.getText());
                }
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        });

        btInsert.setOnAction((ActionEvent e) -> {
            try {
                // prepared statement for insert
                PreparedStatement stmt = connection.prepareStatement(
                        "INSERT INTO staff (id, lastName, firstName, mi, address, city, state, telephone, email) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?)");

                stmt.setInt(1, Integer.parseInt(tfID.getText()));
                stmt.setString(2, tfLastName.getText());
                stmt.setString(3, tfFirstName.getText());
                stmt.setString(4, tfMI.getText());
                stmt.setString(5, tfAddress.getText());
                stmt.setString(6, tfCity.getText());
                stmt.setString(7, tfState.getText());
                stmt.setString(8, tfTelephone.getText());
                stmt.setString(9, tfEmail.getText());

                int rowsInserted = stmt.executeUpdate();

                System.out.println(rowsInserted + " row(s) inserted.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });

        btUpdate.setOnAction(e -> {
            try {
                PreparedStatement stmt = connection.prepareStatement(
                        "UPDATE staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id=?");

                stmt.setString(1, tfLastName.getText());
                stmt.setString(2, tfFirstName.getText());
                stmt.setString(3, tfMI.getText());
                stmt.setString(4, tfAddress.getText());
                stmt.setString(5, tfCity.getText());
                stmt.setString(6, tfState.getText());
                stmt.setString(7, tfTelephone.getText());
                stmt.setString(8, tfEmail.getText());
                stmt.setInt(9, Integer.parseInt(tfID.getText()));

                int rowsUpdated = stmt.executeUpdate();
                System.out.println(rowsUpdated + " row(s) updated.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        btClear.setOnAction(e -> {
            tfID.clear();
            tfLastName.clear();
            tfFirstName.clear();
            tfMI.clear();
            tfAddress.clear();
            tfCity.clear();
            tfState.clear();
            tfTelephone.clear();
            tfEmail.clear();
        });

        // layout with labels
        VBox pane = new VBox(10,
                new HBox(10, new Label("ID:"), tfID),
                new HBox(10, new Label("First Name:"), tfFirstName, new Label("Last Name:"), tfLastName),
                new HBox(10, new Label("MI:"), tfMI, new Label("Address:"), tfAddress),
                new HBox(10, new Label("City:"), tfCity, new Label("State:"), tfState),
                new HBox(10, new Label("Email:"), tfEmail, new Label("Telephone:"), tfTelephone),
                new HBox(10, btView, btInsert, btUpdate, btClear));

        // set scene and show
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("SQL Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeDB() {
        try {
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded.");

            // connect to db
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pa341",
                    "root", "testpassword");
            System.out.println("Database connected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
