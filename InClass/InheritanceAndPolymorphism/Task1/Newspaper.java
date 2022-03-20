package Repo;

public class Newspaper extends Document {

    private int period;
    private int numberOfArticles;

    public Newspaper() {
        super();
    }

    public Newspaper(double fileSize, String format, String title, int period, int numberOfArticles) {
        super(fileSize, format, title);
        this.period = period;
        this.numberOfArticles = numberOfArticles;
    }

    public int getPeriod() {
        return period;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "period=" + period +
                ", numberOfArticles=" + numberOfArticles +
                "} " + super.toString();
    }
}
