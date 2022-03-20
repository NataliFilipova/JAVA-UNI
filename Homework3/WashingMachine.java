package Nbu.java;

public class WashingMachine extends ElectricDevice{

    private boolean isDryer;

    public WashingMachine(Manufacturer manufacturer, int minWarranty, boolean isDryer) {
        super(manufacturer, minWarranty);
        this.isDryer = isDryer;
    }

    @Override
    public int warranty() {
        if(isDryer)
        {
            return super.warranty() + this.getMinWarranty() / 2;
        }
        else {
            return super.warranty();
        }
    }
}
