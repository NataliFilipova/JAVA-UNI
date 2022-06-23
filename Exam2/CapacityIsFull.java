public class CapacityIsFull extends Exception{
    private int driversLimit;
    public CapacityIsFull(int driversLimit){
        this.driversLimit =driversLimit;
    }

    @Override
    public String toString() {
        return "CapacityIsFull{" +
                "driversLimit=" + driversLimit +
                '}';
    }
}
