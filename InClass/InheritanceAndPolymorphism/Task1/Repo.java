package Repo;

public class Repo {

    private double maxSize;
    private int numberOfDocuments;
    private double currentUsedSpace;

    public Repo(double maxSize, int numberOfDocuments, double currentUsedSpace) {
        this.maxSize = maxSize;
        this.numberOfDocuments = numberOfDocuments;
        this.currentUsedSpace = currentUsedSpace;
    }

    public double getMaxSize() {
        return maxSize;
    }

    public int getNumberOfDocuments() {
        return numberOfDocuments;
    }

    public double getCurrentUsedSpace() {
        return currentUsedSpace;
    }

    public void storeDocument(Document document)
    {
        if(maxSize - currentUsedSpace >= document.getFileSize())
        {
            this.numberOfDocuments++;
            this.currentUsedSpace = document.getFileSize();
            System.out.println((document + "is stored in the repository!"));

        }
        else{
            System.out.println("Not enough space!");
        }

    }


    @Override
    public String toString() {
        return "Repo{" +
                "maxSize=" + maxSize +
                ", numberOfDocuments=" + numberOfDocuments +
                ", currentUsedSpace=" + currentUsedSpace +
                '}';
    }
}
