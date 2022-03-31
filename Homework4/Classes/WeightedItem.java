package Classes;

public class WeightedItem extends DeliverableItem{
    double pricePerKg;
    double weight;
    Material martial;

    public WeightedItem(boolean isDelivered, double pricePerKg, double weight, Material martial) {
        super(isDelivered);
        setPricePerKg(pricePerKg);
        setWeight(weight);
        this.martial = martial;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        if(pricePerKg <= 0){
            this.pricePerKg = 1;
        }
        else{
            this.pricePerKg = pricePerKg;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight <= 0){
            this.weight = 1;
        }
        else{
            this.weight = weight;
        }
    }

    public Material getMartial() {
        return martial;
    }

    public void setMartial(Material martial) {
        this.martial = martial;
    }

    @Override
    public double deliveryPrice() {
        double sum = pricePerKg*weight;
        if(isDelivered){
            sum += additionalPrice;
        }
        if(martial.isFragile){
            sum +=  sum /100;
        }
        return sum;
    }
}
