/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author Kostadinova
 */
public class Vehicle implements Serializable{

    protected double price;
    protected String color;

    public Vehicle() {
    }

    public Vehicle(double price, String color) {
        this.price = price;
        this.color = color;

    }

    @Override
    public String toString() {
        return "Vehicle{" + "price=" + price + ", color=" + color + '}';
    }

}
