import java.util.*;

// abstract class media to generalize book, video and newspaper
public abstract class Media {

    private String title;
    private String author;
    private String genre;
    private int publicationDate;
    private boolean isAvailable = true;
    List<Media> availableMedia = new ArrayList<Media>();

    public Media(String title, String author, String genre, int publicationDate) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
        this.publicationDate = publicationDate;
        availableMedia.add(this);
    }

    public abstract void searchItem(); // abstract method to search for media
    public abstract void displayItems(); // abstract method to display media
    public abstract void retrieveItem(); // abstract method to borrow media
    public abstract void storeItem(); // abstract method to return media

    

    
    
}
