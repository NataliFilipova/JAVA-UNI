package Nbu.java;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        String name = "Ivan";

        int hiringYear = 2018;

        int hiringMonth = 12;

        int hiringDay = 1;

        int currentYear = 2021;

        int currentMonth = 3;

        int currentDay = 1;

        Manager manager = new Manager((name));
        manager.setDayOfHiring(hiringYear,hiringMonth,hiringDay);
        System.out.println(manager.getDayOfHiring());
        System.out.println(manager.numberOfYearsInCompanyTill(LocalDate.of(currentYear,currentMonth,currentDay)));
    }
}
