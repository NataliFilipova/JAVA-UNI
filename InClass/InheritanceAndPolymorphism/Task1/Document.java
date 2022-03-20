package Repo;

public class Document {

    private double fileSize;
    private String format;
    private String title;

    public Document() {
    }

    public Document(double fileSize, String format, String title) {
        this.fileSize = fileSize;
        this.format = format;
        this.title = title;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Document{" +
                "fileSize=" + fileSize +
                ", format='" + format + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
