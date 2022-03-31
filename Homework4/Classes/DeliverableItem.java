package Classes;

import Interfaces.Deliverable;

public abstract class DeliverableItem implements Deliverable{

    public boolean isDelivered;

    public static void setAdditionalPrice(double additionalPrice) {
        if(additionalPrice <= 0){
            DeliverableItem.additionalPrice = 1;
        }
        else{
            DeliverableItem.additionalPrice = additionalPrice;
        }
    }

    static double additionalPrice = 0;


    public boolean isDelivered() {
        return isDelivered;
    }


    public DeliverableItem(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }



}
