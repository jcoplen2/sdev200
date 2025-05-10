public class Game extends Media {

    // variables
    String platform;
    Boolean multiplayer;
    Integer userRanking;
    Double hoursPlayed;

    // create methods
    // constructor for game
    public Game(String title, String genre, double price, int releaseYear, String developer,
            String platform, boolean multiplayer, int userRanking, double hoursPlayed) {
        super(title, genre, price, releaseYear, developer);
        this.platform = platform;
        this.multiplayer = multiplayer;
        this.userRanking = userRanking;
        this.hoursPlayed = hoursPlayed;
    }

    public String getPlatform() {
        return platform;
    }

    public Boolean isMultiplayer() {
        return multiplayer;
    }

    public Integer getRanking() {
        return userRanking;
    }

    public void setRanking(int ranking) {
        this.userRanking = ranking;
    }

    public Double getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(Double Hours) {
        this.hoursPlayed = Hours;
    }

    @Override // for combo box
    public String toString() {
        return getTitle();
    }

}
