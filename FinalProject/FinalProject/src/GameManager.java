import java.util.ArrayList;
import java.io.*;

public class GameManager {

    // create list
    private ArrayList<Game> gameList;

    // constructor
    public GameManager() {
        gameList = new ArrayList<>();
    }

    // create methods
    // set game list
    public void setGameList(ArrayList<Game> games) {
        this.gameList = games;
    }

    // sort using lambda
    public void sortGenre() {
        gameList.sort((g1, g2) -> g1.getGenre().compareTo(g2.getGenre()));
    }

    // get game list
    public ArrayList<Game> getGameList() {
        return gameList;
    }

    // add game to list
    public void addGame(Game game) {
        gameList.add(game);
    }

    // recommend game method
    public ArrayList<Game> recommendGames() {
        ArrayList<Game> recommendations = new ArrayList<>();
        ArrayList<String> likedGenres = new ArrayList<>();

        // find high ranked genre (4 or 5)
        for (Game g : gameList) {
            if (g.getRanking() != null && (g.getRanking() == 4 || g.getRanking() == 5)) {
                if (!likedGenres.contains(g.getGenre())) {
                    likedGenres.add(g.getGenre());
                }
            }
        }

        // recommend games from high ranked genre
        for (Game g : gameList) {
            if (likedGenres.contains(g.getGenre()) && (g.getRanking() == null || g.getRanking() < 4)) {
                recommendations.add(g);
            }

        }
        return recommendations;
    }
}
