package com.company;

public class Drink extends Goods{
    private boolean sparkling;

    public Drink(boolean sparkling) {
        this.sparkling = sparkling;
    }

    public Drink(String name, double price, double weight, boolean sparkling) {
        super(name, price, weight);
        this.sparkling = sparkling;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "sparkling=" + sparkling +
                '}';
    }
}
