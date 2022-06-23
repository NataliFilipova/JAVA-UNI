package com.company;

public class Food extends Goods{
    private boolean vegetarian;

    public Food(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Food(String name, double price, double weight, boolean vegetarian) {
        super(name, price, weight);
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return "Food{" +
                "vegetarian=" + vegetarian +
                '}';
    }
}
