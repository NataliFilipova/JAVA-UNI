
import java.util.ArrayList;

public class Car {
    private ArrayList<Driver> drivers;

    public Car(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public Car() {
        this.drivers = new ArrayList<>();
    }

    public void addDriver(Driver driver) throws CapacityIsFull, MaxDrivingTimeException {

        if(drivers.size() >= 3){
            throw new CapacityIsFull(this.drivers.size());
        }
        else if(driver.getRaceHours() > 14){
            throw new MaxDrivingTimeException(14);
        }
        else {
            drivers.add(driver);
        }
    }

    public void startRace() {
        //TODO: Start the race and change the drivers when one meets their limit
    }
}
