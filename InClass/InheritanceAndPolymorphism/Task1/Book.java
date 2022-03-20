package Repo;

public class Book extends Document{

    private Author author;
    private String isbnCode;

    public Book(){

    }

    public Book(double fileSize, String format, String title, Author author, String isbnCode){
        super(fileSize, format, title);
        this.author = author;
        this.isbnCode = isbnCode;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", isbnCode='" + isbnCode + '\'' +
                "} " + super.toString();
    }
}

