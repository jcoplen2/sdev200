public class GameTest {
    public static void main(String[] args) {
        // create game to test
        Game testGame = new Game("Fallout 4", "RPG", 19.99, 2015, "Bethesda", "PlayStation", false, 5, 120.7);

        // ensure all variables were updated using get
        System.out.println("Title: " + testGame.getTitle());
        System.out.println("Genre: " + testGame.getGenre());
        System.out.println("Price: " + testGame.getPrice());
        System.out.println("Platform: " + testGame.getPlatform());
        System.out.println("Multiplayer: " + testGame.isMultiplayer());
        System.out.println("Ranking: " + testGame.getRanking());
        System.out.println("Hours Played: " + testGame.getHoursPlayed());

        // test set methods
        testGame.setRanking(4);
        testGame.setHoursPlayed(80.5);

        // ensure set methods worked
        System.out.println("Updated Ranking: " + testGame.getRanking());
        System.out.println("Updated Hours: " + testGame.getHoursPlayed());

    }
}
