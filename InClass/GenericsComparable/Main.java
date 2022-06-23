package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        {
            Goods goods = new Goods("Computer", 2000, 1.4);

            // Generic Class Box with one generic type
            Box<Goods> box = new Box(goods, .1);
            System.out.println("Is " + box + " empty? " + box.isBoxEmpty());
            System.out.println("In " + box + " there is " + box.getItem());


            // Generic Method servingLunch() with two generic parameters
            Food food = new Food("Soup", 5, .3, false);
            Drink drink = new Drink("Fanta", 3, .25, true);
            Restaurant restaurant = new Restaurant();
            System.out.println(restaurant.servingLunch(food, drink));
            Restaurant.servingLunch2(food, drink);

            // Bounded type parameters
            System.out.println(box + " total weight is " + box.totalWeight());
            box.setItem(food); // Food is Goods
            System.out.println(box + " total weight is " + box.totalWeight());
            box.setItem(drink); // Drink is Goods
            System.out.println(box + " total weight is " + box.totalWeight());
            //box.setItem(restaurant); // Restaurant is not Goods

            // Wildcard ? - any type
            Box<Food> box2 = new Box(food, .4);
            System.out.println("Is " + box + " heavier than " + box2 + "? " + box.compareBoxesItemsWeight(box2));

            // restaurant.prepareForDelivery(box);
            Box boxWithFood = new Box(food, .2);
           // System.out.println(restaurant.prepareForDelivery(boxWithFood));

            // Wild card upper bounded

            // Wild card lower bounded

        }

        {
            // Interface Comparable<T>
            Goods goods1 = new Goods("Jacket", 2000.6, .900);
            Goods goods2 = new Goods("Computer", 2000, 1.200);
            System.out.println(goods1.compareTo(goods2));
            List<Goods> box3 = new ArrayList<>();
            Box<Goods> goodsBox = new Box()
        }

    }
}
