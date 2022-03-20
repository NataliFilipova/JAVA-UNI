package Nbu.java;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

 class Manager {

    String name;
    LocalDate dayOfHiring;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfHiring() {
        return dayOfHiring;
    }

    public void setDayOfHiring(int yearHiring, int monthHiring, int dayHiring) {
        LocalDate localDate = LocalDate.of(yearHiring,monthHiring, dayHiring);
        if(localDate.isAfter(LocalDate.now(ZoneId.of("Europe/Sofia")))){
            this.dayOfHiring = LocalDate.of(2020,1,1);
        } else {
            this.dayOfHiring = localDate;
        }

    }

    public int numberOfYearsInCompanyTill(LocalDate dateNow){
        Period period = Period.between(dayOfHiring, dateNow);
        return period.getYears();
    }
}
