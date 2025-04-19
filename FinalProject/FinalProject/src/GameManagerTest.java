import java.util.ArrayList;

public class GameManagerTest {
    public static void main(String[] args) {
        // create game list
        GameManager manager = new GameManager();

        manager.addGame(new Game("Halo", "Action", 59.99, 2021, "343 Industries", "Xbox", true, 5, 40.0));
        manager.addGame(new Game("Stardew Valley", "RPG", 14.99, 2016, "ConcernedApe", "PC", false, 1, 60.5));
        manager.addGame(new Game("Fallout 4", "RPG", 19.99, 2015, "Bethesda", "PlayStation", false, 5, 120.7));
        manager.addGame(new Game("Among Us", "Party", 4.99, 2018, "Innersloth", "PC", true, 3, 10.0));

        // Test sorting
        manager.sortGenre();
        System.out.println("\nGames sorted by genre:");
        for (Game g : manager.getGameList()) {
            System.out.println(g.getTitle() + " - " + g.getGenre());
        }

        // Test recommendation
        ArrayList<Game> recs = manager.recommendGames();
        System.out.println("\nRecommended Games:");
        for (Game g : recs) {
            System.out.println(g.getTitle() + " (" + g.getGenre() + ")");
        }
    }
}
