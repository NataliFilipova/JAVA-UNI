/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {

    public static final long serialVersionUID = 1234L;
    private boolean isWagon;
    private transient int numberOfSeats;

    public Car(double price, String color, boolean isWagon) {
        super();
    }

    public Car(boolean isWagon, int numberOfSeats, double price, String color) {
        super(price, color);
        this.isWagon = isWagon;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return super.toString() + "Car{" +
                "isWagon=" + isWagon +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
