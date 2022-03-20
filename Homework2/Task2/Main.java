package Nbu.java;

public class Main {

    public static void main(String[] args) {

        long id = 1;

        int maxWorkingHours = 24;

        double minPricePerHour = 100;

        double currencyEuro = 0.51;

        double pricePerHour = 120;

        int workedHours = 15;

        Studio studio1 = new Studio(id, maxWorkingHours);

        studio1.setCurrencyEuro(currencyEuro);
        studio1.setMaxWorkingHours(maxWorkingHours);
        studio1.setWorkedHours(workedHours);
        studio1.setMinPricePerHour(minPricePerHour);
        studio1.setPricePerHour((pricePerHour));




        //
        long id2 = 2;

        int maxWorkingHours2 = 20;

        double pricePerHour2 = 120;


       Studio studio2  = new Studio(id2, maxWorkingHours2);

        int workedHours2 = 15;

       studio2.setWorkedHours(workedHours2);
       studio2.setPricePerHour(pricePerHour2);


        System.out.println(studio2.wonMoneyPerDayInLev());
        System.out.println(studio1.wonMoneyPerDayInEuro());
        System.out.println(studio1.studioWithLargerPrice(studio2));
       System.out.println(studio1.sFirstStudioWithGreaterTurnover(studio2));





    }
}
