package Nbu.java;

public class Belonging {
    private final String name;
    private double price;
    private double tax;
    private Type type;

    //Constructor

    public Belonging(String name, double price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
        setTax();
    }


    public Belonging(String name) {
        this.name = name; //Can't make one without a name here because it's final.
    }


    //Sets the tax.
    public void setTax() {
        if(this.getType().toString() == "MOVABLE"){
            this.tax = this.price * 0.01;
        }
        else{
            this.tax = this.price * 0.005;
        }
    }

    //Return the type.
    public Type getType() {
        return type;
    }

    //Return the price.
    public double getPrice() {
        return price;
    }

    //Return the tax.
    public double getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return "Belonging{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                ", type=" + type +
                '}';
    }
}
