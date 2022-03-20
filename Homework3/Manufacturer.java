package Nbu.java;

public class Manufacturer {

    private String name;
    private boolean isLongTermWarranty;

    public Manufacturer(String name, boolean isLongTermWarranty) {
        this.name = name;
        this.isLongTermWarranty = isLongTermWarranty;
    }

    public String getName() {
        return name;
    }

    public boolean isLongTermWarranty() {
        return isLongTermWarranty;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", isLongTermWarranty=" + isLongTermWarranty +
                '}';
    }


}
