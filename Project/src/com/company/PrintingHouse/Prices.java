package com.company.PrintingHouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class Prices {


    private BigDecimal[] pricesOfPaper = new BigDecimal[4];
    private BigDecimal[] pricesOfSize = new BigDecimal[4];
    private BigDecimal[] pricesOfColor = new BigDecimal[1];

    public Prices(BigDecimal[] pricesOfPaper, BigDecimal[] pricesOfSize, BigDecimal[] pricesOfColor) {
        this.pricesOfPaper = pricesOfPaper;
        this.pricesOfSize = pricesOfSize;
        this.pricesOfColor = pricesOfColor;
    }

    public BigDecimal[] getPricesOfPaper() {
        return pricesOfPaper;
    }

    public BigDecimal[] getPricesOfColor() {
        return pricesOfColor;
    }

    public BigDecimal[] getPricesOfSize() {
        return pricesOfSize;
    }

    public void setPricesOfPaper(BigDecimal[] pricesOfPaper) {
        this.pricesOfPaper = pricesOfPaper;
    }
    public void setPricesOfSize(BigDecimal[] pricesOfSize) {
        this.pricesOfSize = pricesOfSize;
    }

    @Override
    public String toString() {
        return
                "Цени за хартия: \n" +
                "Glossy: " + pricesOfPaper[0] + "\n" +
                        " Normal " + pricesOfPaper[1] + "\n" +
                        " Nespaper: " + pricesOfPaper[2] + "\n"
                + "Цена за размери: \n" +
                "A1 - " + pricesOfSize[0] + "\n" +
                "A2 - " + pricesOfSize[1] + "\n" +
                "A3 - " + pricesOfSize[2] + "\n" +
                "A4 - " + pricesOfSize[3] + "\n" +
                "A5 - " + pricesOfSize[4] + "\n" +
                "Цена на цветно принтиране: " + pricesOfColor[0] + "\n" +
                "Цена на черно-бяла: " + pricesOfColor[1];

    }
}
