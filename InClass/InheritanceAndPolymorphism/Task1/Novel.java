package Repo;

public class Novel extends  Book{

    private String novelAbstract;

    public Novel() {
    }

    public Novel(double fileSize, String format, String title, Author author, String isbnCode, String novelAbstract) {
        super(fileSize, format, title, author, isbnCode);
        this.novelAbstract = novelAbstract;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "novelAbstract='" + novelAbstract + '\'' +
                "} " + super.toString();
    }
}
