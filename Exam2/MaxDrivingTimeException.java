public class MaxDrivingTimeException extends Exception {
   private int maxTime;

    public MaxDrivingTimeException(int maxTime) {
        this.maxTime = maxTime;
    }

    @Override
    public String toString() {
        return "MaxDrivingTimeException{" +
                "maxTime=" + maxTime +
                '}';
    }
}
