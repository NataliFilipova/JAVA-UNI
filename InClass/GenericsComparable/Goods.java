package com.company;

public class Goods implements Weighted, Comparable<Goods> {
    private String name;
    private double price;
    private double weight;

    public Goods() {
    }

    public Goods(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }


    @Override
    public int compareTo(Goods o) {
        if (this.price > o.price) {
            return 1;
        } else
        if (this.price < o.price) {
            return -1;
        }
        return 0;
    }
}

