import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Task 1
    public static double readGoodsPrice() {
        System.out.println("Enter the price of the goods: ");
        double price = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            while ((price = scanner.nextDouble()) <= 0) {
                System.out.println("Enter positive number!");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return price;
    }

    //Task 2
    public static void writeGoods(String outputFilename, Goods goods) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(new File(outputFilename), true);
            if (goods != null) {
                fout.append(goods.toString() + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    // Task 2
    public static List<String> readGoodsFromFile(String inputFilename) {
        List<String> listOfGoods = new ArrayList<>();
        try (FileReader fis = new FileReader(new File(inputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listOfGoods.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfGoods;
    }

    // Task 2
    public static List<Double> findPriceInGoodsString(List<String> listOfGoods) {
        List<Double> listOfPrices = new ArrayList<>();
        for (String goodsData : listOfGoods) {
            listOfPrices.add(Double.parseDouble(goodsData.
                    substring(goodsData.indexOf("=", goodsData.indexOf("price=")) + 1,
                            goodsData.lastIndexOf("}"))));
        }
        return listOfPrices;
    }

    // Task 2
    public static double sumPrices(List<Double> listOfPrices) {
        double sum = 0;
        for (Double goodsPrice : listOfPrices) {
            sum += goodsPrice;
        }
        return sum;
    }

    // Task 3
    public static void serializeMovieTheatre(String filePath, MovieTheatre movieTheatre) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos);) {
            outputStream.writeObject(movieTheatre);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 3
    public static MovieTheatre deserializeMovieTheatre(String filePath) {
        MovieTheatre movieTheatre = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream inputStream = new ObjectInputStream(fis);) {

            movieTheatre = (MovieTheatre) inputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieTheatre;
    }

    // Serialize Car Example
    public static void serializeCar(String filePath, Car car) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos);) {
            outputStream.writeObject(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize Car Example
    public static Car deserializeCar(String filePath) {
        Car car = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream inputStream = new ObjectInputStream(fis);) {

            car = (Car) inputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return car;
    }

    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        // Creating folder named "files" in the project folder
        File filesDirectory = new File("files");
        System.out.println("Folder named files is created: " + filesDirectory.mkdir());


        // Task 1
        {
            readGoodsPrice();
        }

        // Task 2
        {
            // Task 2.1
            Goods goods1 = new Goods("meat", 15);
            Goods goods2 = new Goods("butter", 6);
            Goods goods3 = new Goods("milk", 2);

            String filename = "files/GoodsData.txt";
            writeGoods(filename, goods1);
            writeGoods(filename, goods2);
            writeGoods(filename, goods3);

            // Task 2.2
            List<String> goodFromFile = new ArrayList<>(readGoodsFromFile(filename));
            List<Double> goodsPrices = new ArrayList<>(findPriceInGoodsString(goodFromFile));
            System.out.println("The sum of the prices of the goods is: " +
                    sumPrices(goodsPrices));
        }

        //Task 3
        {
            String filePath = "files/MovieTheatre.ser";
            int numberOfTicketsSold = 50;
            double pricePerTicket = 10;
            String name = "Arena";
            String address = "Sofia";

            MovieTheatre movieTheatre = new MovieTheatre(numberOfTicketsSold, pricePerTicket, name, address);

            serializeMovieTheatre(filePath, movieTheatre);

            System.out.println(deserializeMovieTheatre(filePath));
        }

        // Working with File example
        {
            File f1 = new File("/java/COPYRIGHT");
            p("File Name: " + f1.getName());
            p("Path: " + f1.getPath());
            p("Abs Path: " + f1.getAbsolutePath());
            p("Parent: " + f1.getParent());
            p(f1.exists() ? "exists" : "does not exist");
            p(f1.canWrite() ? "is writeable" : "is not writeable");
            p(f1.canRead() ? "is readable" : "is not readable");
            p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
            p(f1.isFile() ? "is normal file" : "might be a named pipe");
            p(f1.isAbsolute() ? "is absolute" : "is not absolute");
            p("File last modified: " + f1.lastModified());
            p("File size: " + f1.length() + " Bytes");
        }

        // Serialization Example Vehicles and Cars
        {
            String filePath = "files/car.ser";
            {
                Car car = new Car(true, 5, 12000, "black");
                serializeCar(filePath, car);
                System.out.println(deserializeCar(filePath));
            }
        }
    }
}
