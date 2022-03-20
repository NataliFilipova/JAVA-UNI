package Nbu.java;

import java.math.BigDecimal;

 class Studio {

    private final long id;
    private BigDecimal pricePerHour;
    private int maxWorkingHours;
    private int workedHours;
    private static BigDecimal minPricePerHour;
    private static BigDecimal currencyEuro;

     public Studio(long id, int maxWorkingHours) {
         this.id = id;
         setMaxWorkingHours(maxWorkingHours);
     }

     public void setMaxWorkingHours(int maxWorkingHours) {
        if(maxWorkingHours <0 || maxWorkingHours > 24){
            this.maxWorkingHours = 24;
        }
        else{
            this.maxWorkingHours = maxWorkingHours;
        }
    }

    public static void setMinPricePerHour(double minPricePerHour) {
        if(minPricePerHour > 0){
            Studio.minPricePerHour = BigDecimal.valueOf(minPricePerHour);
        }
        else{
            Studio.minPricePerHour = BigDecimal.valueOf(0);
        }


    }

    public void setPricePerHour(double pricePerHour) {
        int i = BigDecimal.valueOf(pricePerHour).compareTo(this.minPricePerHour);
        if(i == -1)
        {
            this.pricePerHour = this.minPricePerHour;
        }
        else{
            this.pricePerHour = BigDecimal.valueOf(pricePerHour);
        }
    }


    public void setWorkedHours(int workedHours) {
        if(workedHours > maxWorkingHours) {
            this.workedHours = this.maxWorkingHours;
        }
        else{
            this.workedHours = workedHours;
        }
    }

    public void setCurrencyEuro(double currencyEuro) {
        this.currencyEuro = BigDecimal.valueOf(currencyEuro);
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public static BigDecimal  getCurrencyEuro() {
        return currencyEuro;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }
    public BigDecimal  getMinPricePerHour() {
        return  this.minPricePerHour;
    }

    public BigDecimal wonMoneyPerDayInLev(){

        return pricePerHour.multiply(BigDecimal.valueOf(workedHours));


    }

    public BigDecimal wonMoneyPerDayInEuro(){

        return currencyEuro.multiply(wonMoneyPerDayInLev());

    }

    public long studioWithLargerPrice(Studio studio){
       int i = this.pricePerHour.compareTo(studio.pricePerHour);
       if(i == 1)
        {
            return this.id;
        }
        else{
            return studio.id;
        }
    }

    public boolean sFirstStudioWithGreaterTurnover(Studio studio){
        int i = this.wonMoneyPerDayInLev().compareTo(studio.wonMoneyPerDayInLev());
        if(i == 1)
           {
                return true;
            }
            else{
                return false;
            }
    }
}
