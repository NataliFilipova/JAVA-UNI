package Repo;

public class PoetryCollection extends Book{
    private int poemsNumber;

    public PoetryCollection() {
    }

    public PoetryCollection(double fileSize, String format, String title, Author author, String isbnCode, int poemsNumber) {
        super(fileSize, format, title, author, isbnCode);
        this.poemsNumber = poemsNumber;
    }

    public int getPoemsNumber() {
        return poemsNumber;
    }

    @Override
    public String toString() {
        return "PoetryCollection{" +
                "poemsNumber=" + poemsNumber +
                "} " + super.toString();
    }
}
