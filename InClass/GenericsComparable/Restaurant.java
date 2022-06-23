package com.company;

public class Restaurant {

    public <F extends Food, D extends Drink> String servingLunch(F f, D d) {
        return "You ordered " + f + " food and " + d + " drink. Bon Apeti!";
    }

    public static <F extends Food, D extends Drink> String servingLunch2(F f, D d) {
        return "You ordered " + f + " food and " + d + " drink. Bon Apeti!";
    }

    public String prepareForDelivery(Box<? extends Food > box) {
        return "Your food is in " + box + "!";
    }

    public String prepareForDelivery2(Box<? extends Food> box) {
        return "Your food is in " + box + "!";
    }

    public String prepareForDelivery3(Box<? super Drink> box) {
        return "Your food is in " + box + "!";
    }

}
