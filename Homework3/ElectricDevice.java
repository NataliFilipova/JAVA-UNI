package Nbu.java;

public class ElectricDevice {

        private Manufacturer manufacturer;
        private int minWarranty;

    public ElectricDevice(Manufacturer manufacturer, int minWarranty) {
        this.manufacturer = manufacturer;
        setMinWarranty(minWarranty);
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setMinWarranty(int minWarranty) {
       if(minWarranty <6 ){
           this.minWarranty = 6;
       }
       else {
           this.minWarranty = minWarranty;
       }
    }

    public int getMinWarranty() {
        return minWarranty;
    }

    public int warranty(){

        if(manufacturer.isLongTermWarranty()){
            return this.minWarranty+12;
        }
        else{
           return this.minWarranty;
        }

    }
}
