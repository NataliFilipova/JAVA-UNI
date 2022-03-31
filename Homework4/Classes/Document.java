package Classes;

public class Document extends DeliverableItem {
    double minPrice;

    public Document(boolean isDelivered, double minPrice) {
        super(isDelivered);
        setMinPrice(minPrice);
    }


    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        if(minPrice <= 0){
            this.minPrice = 1;
        }
        else{
            this.minPrice = minPrice;
        }
    }

    @Override
    public double deliveryPrice() {
        if(isDelivered){
            return minPrice+additionalPrice;
        }
        else{
            return minPrice;
        }
    }


}
