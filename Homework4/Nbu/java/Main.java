package Nbu.java;

import Classes.DeliverableItem;
import Classes.Document;
import Classes.Material;
import Classes.WeightedItem;
import Interfaces.Deliverable;

public class Main {

    public static void main(String[] args) {
        String materialName = "Glass";

        boolean isFragile = true;

        boolean toClientsAddress = true;

        double minPrice =0;

        double weight = 0;
        double pricePerKg = -1;

        double additionalPrice = -2;

        Material material = new Material(materialName, isFragile);
        Deliverable deliverable;
        deliverable = new Document(toClientsAddress, minPrice);
        DeliverableItem.setAdditionalPrice(additionalPrice);
        System.out.println(deliverable.deliveryPrice());

        deliverable = new WeightedItem(toClientsAddress, pricePerKg, weight, material);

        System.out.println(deliverable.deliveryPrice());
    }
}
