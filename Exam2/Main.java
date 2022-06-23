import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CapacityIsFull, MaxDrivingTimeException {
        Driver driver1 = new Driver("Tom Kristensen", 20, 10);
        Driver driver2 = new Driver("Jacky Ickx", 25, 10);
        Driver driver3 = new Driver("Hot dogx", 25, 2);
        // TODO: Continue adding drivers and cars

        Driver driver4 = new Driver("Seb", 25, 10);
        Driver driver5 = new Driver("Kiro", 25, 5);
        Driver driver6 = new Driver("Ivan", 25, 9);

        ArrayList<Driver> driverscarone =new ArrayList<Driver>();
        driverscarone.add(driver1);
        driverscarone.add(driver2);
        driverscarone.add(driver3);

        ArrayList<Driver> driverscarone2 =new ArrayList<Driver>();
        driverscarone.add(driver4);
        driverscarone.add(driver5);


        Car car1 = new Car(driverscarone);
        Car car2 = new Car(driverscarone2);


        try {
            car2.addDriver(driver6);
        }catch (CapacityIsFull e){
            System.out.println(e);
            e.printStackTrace();
        }catch (MaxDrivingTimeException ex){
            System.out.println(ex);
            ex.printStackTrace();
        }



        // TODO: Start the race
    }
}
