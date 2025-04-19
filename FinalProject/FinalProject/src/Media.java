public abstract class Media {

    // variables
    String title;
    String genre;
    Double price;
    Integer releaseYear;
    String developer;

    // create methods
    // contructor for media
    public Media(String title, String genre, double price, int releaseYear, String developer) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.releaseYear = releaseYear;
        this.developer = developer;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getDeveloper() {
        return developer;
    }
}
