import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main extends Application {

    // access GameManager
    private GameManager gameManager = new GameManager();

    // set main stage
    @Override
    public void start(Stage primaryStage) {

        // Add games for testing UPDATE LATER!
        gameManager.addGame(new Game("Halo", "Action", 59.99, 2021, "343 Industries", "Xbox", true, 5, 40.0));
        gameManager.addGame(new Game("Stardew Valley", "RPG", 14.99, 2016, "ConcernedApe", "PC", false, 1, 60.5));
        gameManager.addGame(new Game("Fallout 4", "RPG", 19.99, 2015, "Bethesda", "PlayStation", false, 5, 120.7));
        gameManager.addGame(new Game("Among Us", "Party", 4.99, 2018, "Innersloth", "PC", true, 3, 10.0));

        // enter username and click to open
        Label namelb = new Label("Enter Username: ");
        TextField nametf = new TextField();

        Button getStartedBt = new Button("Get Started");

        // set button action to open new window/stage
        getStartedBt.setOnAction(e -> openNewWindow());

        // layout and show
        VBox rootPane = new VBox(10, namelb, nametf, getStartedBt);
        Scene scene = new Scene(rootPane, 300, 200);
        primaryStage.setTitle("Login Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // method for opening new stage
    public void openNewWindow() {

        // new stage
        Stage secondStage = new Stage();

        // add game list
        Label gamelb = new Label("List of Games: ");
        ListView<String> gameListView = new ListView<>();
        ObservableList<String> gameTitles = FXCollections.observableArrayList();

        // load games from manager. ****may update later for DB
        // Load game titles from manager
        for (Game g : gameManager.getGameList()) {
            gameTitles.add(g.getTitle());
        }
        // show in new list
        gameListView.setItems(gameTitles);

        // add buttons and text fields
        Button rankBt = new Button("Rank Game");
        Button hoursPlayedBt = new Button("Enter Hours Played");
        Button recommendGameBt = new Button("Get Recommendation");

        TextField rankTf = new TextField();
        TextField hoursPlayedTf = new TextField();
        TextField recommendGameTf = new TextField();

        // button logic for rank

        // button logic for hours played

        // button logic for recommend
        recommendGameBt.setOnAction(e -> {
            for (Game g : gameManager.recommendGames()) {
                recommendGameTf.setText(g.getTitle());
            }
        });

        // set scene and show
        VBox secondPane = new VBox(10, gamelb, gameListView, rankBt, rankTf, hoursPlayedBt, hoursPlayedTf,
                recommendGameBt,
                recommendGameTf);
        Scene secondScene = new Scene(secondPane, 300, 300);

        secondStage.setTitle("Second Window");
        secondStage.setScene(secondScene);
        secondStage.show();

    }

    // main method
    public static void main(String[] args) {
        launch(args);
    }
}
