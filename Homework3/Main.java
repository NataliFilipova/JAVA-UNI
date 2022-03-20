package Nbu.java;

public class Main {

    public static void main(String[] args) {

        Manufacturer manufacturer = new Manufacturer("ElvDevMan", true);

        System.out.println(manufacturer);

        ElectricDevice electricDevice = new ElectricDevice(manufacturer, 12);
        System.out.println(electricDevice.warranty());

        electricDevice = new Cooker(manufacturer,12, true);

        System.out.println(electricDevice.warranty());

        electricDevice = new WashingMachine(manufacturer, 12, true);
        System.out.println(electricDevice.warranty());
    }
}
