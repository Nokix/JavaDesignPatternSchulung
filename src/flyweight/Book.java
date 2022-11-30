package flyweight;

import flyweight.verlag.Verlag;
import flyweight.verlag.VerlagFactory;

import java.util.Date;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private Verlag verlag;

    public Book(int isbn, String title, String author, String verlag, Date verlagBeginningYear, String verlagLocation) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.verlag = VerlagFactory.getVerlag(verlag, verlagBeginningYear, verlagLocation);
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getVerlag() {
        return verlag.getVerlag();
    }

    public Date getVerlagBeginningYear() {
        return verlag.getVerlagBeginningYear();
    }

    public String getVerlagLocation() {
        return verlag.getVerlagLocation();
    }
}
