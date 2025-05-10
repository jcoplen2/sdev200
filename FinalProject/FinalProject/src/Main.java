import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {

    // access GameManager
    private GameManager gameManager = new GameManager();
    // main list
    private ObservableList<String> gameTitles = FXCollections.observableArrayList();

    // set main stage
    @Override
    public void start(Stage primaryStage) {

        // Add games
        gameManager.addGame(new Game("Halo", "Action", 59.99, 2021, "343 Industries", "Xbox", true, 0, 0));
        gameManager.addGame(new Game("Stardew Valley", "RPG", 14.99, 2016, "ConcernedApe", "PC", false, 0, 0));
        gameManager.addGame(new Game("Fallout 4", "RPG", 19.99, 2015, "Bethesda", "PlayStation", false, 0, 0));
        gameManager.addGame(new Game("Among Us", "Party", 4.99, 2018, "Innersloth", "PC", true, 0, 0));
        gameManager.addGame(new Game("The Witcher 3", "RPG", 29.99, 2015, "CD Projekt", "PC", false, 0, 0));
        gameManager.addGame(
                new Game("God of War", "Action", 39.99, 2018, "Santa Monica Studio", "PlayStation", false, 0, 0));
        gameManager.addGame(
                new Game("Animal Crossing: New Horizons", "RPG", 59.99, 2020, "Nintendo", "PC", true, 0, 0));
        gameManager.addGame(new Game("Minecraft", "RPG", 26.95, 2011, "Mojang", "PC", true, 0, 0));
        gameManager.addGame(new Game("Overwatch 2", "Party", 0.00, 2022, "Blizzard", "PC", true, 0, 0));
        gameManager.addGame(new Game("The Legend of Zelda: Breath of the Wild", "RPG", 59.99, 2017, "Nintendo", "PC",
                false, 0, 0));
        gameManager.addGame(new Game("Red Dead Redemption 2", "Action", 59.99, 2018, "Rockstar Games", "PlayStation",
                false, 0, 0));
        gameManager.addGame(new Game("Fortnite", "Party", 0.00, 2017, "Epic Games", "PC", true, 0, 0));

        // enter username and click to open
        Label namelb = new Label("Enter Username: ");
        TextField nametf = new TextField();

        Button getStartedBt = new Button("Get Started");

        // set button action to open new window/stage
        getStartedBt.setOnAction(e -> openNewWindow());

        // layout and show
        VBox rootPane = new VBox(10, namelb, nametf, getStartedBt);
        rootPane.setStyle("-fx-padding: 20; -fx-alignment: center;");
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
        gameListView.setItems(gameTitles);
        gameListView.setPrefHeight(200);
        gameListView.setPrefWidth(350);
        updateGameListDisplay();

        // add buttons and text fields
        Button rankBt = new Button("Rank Games");
        Button hoursPlayedBt = new Button("Enter Hours Played");
        Button recommendGameBt = new Button("Get Recommendation");

        TextField recommendGameTf = new TextField();

        // button logic for rank
        rankBt.setOnAction(e -> {
            // create small window for ranking
            Stage rankStage = new Stage();

            // add drop down to select game
            ComboBox<Game> gameComboBox = new ComboBox<>();
            gameComboBox.getItems().addAll(gameManager.getGameList());
            gameComboBox.setPromptText("Select a game");

            // box for user input
            TextField rankInput = new TextField();
            rankInput.setPromptText("Enter ranking (1-5)");

            // submit button
            Button submitRank = new Button("Submit");

            // save ranking
            submitRank.setOnAction(ev -> {
                // game user selected
                Game selected = gameComboBox.getValue();
                try {
                    int rank = Integer.parseInt(rankInput.getText());
                    // catch exceptions
                    if (rank < 1 || rank > 5)
                        throw new NumberFormatException();
                    if (selected != null) {
                        selected.setRanking(rank);
                        Alert alert = new Alert(AlertType.INFORMATION, "Ranking updated");
                        alert.show();
                        // update main list
                        updateGameListDisplay();
                    }
                    // output exception text
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(AlertType.ERROR, "Please enter a valid number between 1 and 5.");
                    alert.show();
                }
            });

            // rank pop out window scene and show
            VBox layout = new VBox(10, gameComboBox, rankInput, submitRank);
            Scene rankScene = new Scene(layout, 300, 200);
            rankStage.setTitle("Rank a Game");
            rankStage.setScene(rankScene);
            rankStage.show();
        });

        // button logic for hours played
        hoursPlayedBt.setOnAction(e -> {
            // window for hours played
            Stage hoursStage = new Stage();

            // drop down to select game
            ComboBox<Game> gameComboBox = new ComboBox<>();
            gameComboBox.getItems().addAll(gameManager.getGameList());
            gameComboBox.setPromptText("Select a game");

            // user input
            TextField hoursInput = new TextField();
            hoursInput.setPromptText("Enter hours played");

            // submit button
            Button submitHours = new Button("Submit");

            // save hours played
            submitHours.setOnAction(ev -> {
                Game selected = gameComboBox.getValue();
                try {
                    double hours = Double.parseDouble(hoursInput.getText());
                    // catch exceptions
                    if (hours < 0)
                        throw new NumberFormatException();
                    if (selected != null) {
                        selected.setHoursPlayed(hours);
                        Alert alert = new Alert(AlertType.INFORMATION, "Hours updated!");
                        alert.show();
                        // update main list
                        updateGameListDisplay();
                    }
                    // output for exceptions
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(AlertType.ERROR, "Please enter a valid number (0 or higher).");
                    alert.show();
                }
            });

            // set scene and show hours played
            VBox layout = new VBox(10, gameComboBox, hoursInput, submitHours);
            Scene hoursScene = new Scene(layout, 300, 200);
            hoursStage.setTitle("Enter Hours Played");
            hoursStage.setScene(hoursScene);
            hoursStage.show();
        });

        // button logic for recommend
        recommendGameBt.setOnAction(e -> {
            for (Game g : gameManager.recommendGames()) {
                recommendGameTf.setText(g.getTitle());
            }
        });

        // set scene and show
        VBox secondPane = new VBox(10, gamelb, gameListView, rankBt, hoursPlayedBt, recommendGameBt, recommendGameTf);
        secondPane.setStyle("-fx-padding: 20; -fx-alignment: center-left;");
        Scene secondScene = new Scene(secondPane, 300, 300);

        secondStage.setTitle("Main Menu");
        secondStage.setScene(secondScene);
        secondStage.show();

    }

    // refresh main list
    private void updateGameListDisplay() {
        gameTitles.clear();
        for (Game g : gameManager.getGameList()) {
            String display = g.getTitle() + " | Rank: " + g.getRanking() + " | Hours: " + g.getHoursPlayed();
            gameTitles.add(display);
        }
    }

    // main method
    public static void main(String[] args) {
        launch(args);
    }
}
