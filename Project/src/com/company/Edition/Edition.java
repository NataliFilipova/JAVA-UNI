package com.company.Edition;

import com.company.PrintingMachine.TypeOfColor;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Edition {

    private String title;  // Заглавие
    private int countOfPages; // Колко страници има изданието.
    private int countOfCopies; // Колко пъти ще бъде принтирано изданието.
    private TypeOfColor typeOfColor; // Дали ще бъде цветно.
    private EditionType editionType; // BOOK, POSTER, NEWSPAPER;
    private SizeOfPages sizeOfPages; //  A1, A2, A3, A4, A5;
    private PaperType paperType; // NORMAL, GLOSSY, PRINTNEWSPAPER;


    public Edition(String title, int countOfPages, int countOfCopies, EditionType editionType, SizeOfPages sizeOfPages, PaperType paperType, TypeOfColor typeOfColor) {
        this.title = title;
        this.countOfPages = countOfPages;
        this.countOfCopies = countOfCopies;
        this.editionType = editionType;
        this.sizeOfPages = sizeOfPages;
        this.paperType = paperType;
        this.typeOfColor = typeOfColor;
    }

    //Гетъри

    public int getCountOfPages() {
        return countOfPages;
    }
    public int getCountOfCopies() {
        return countOfCopies;
    }
    public SizeOfPages getSizeOfPages() {
        return sizeOfPages;
    }
    public PaperType getPaperType() {
        return paperType;
    }
    public TypeOfColor getTypeOfColor() {
        return typeOfColor;
    }
    public String getTitle() {
        return title;
    }


    // Връща цената на притиране на една страница от изданието.

    public BigDecimal getPriceForOnePage(BigDecimal[] pricesOfPaper, BigDecimal[] pricesOfSize, BigDecimal[] pricesOfColor){
        BigDecimal priceOfPaper = BigDecimal.valueOf(0);
        BigDecimal priceOfSize = BigDecimal.valueOf(0);
        BigDecimal priceOfColor = BigDecimal.valueOf(0);

        if(this.getPaperType().toString().equals("GLOSSY")){
            priceOfPaper = pricesOfPaper[0];
        }
        else if(this.getPaperType().toString().equals("NORMAL")) {
            priceOfPaper = pricesOfPaper[1];
        }
        else if(this.getPaperType().toString().equals("PRINTNEWSPAPER")){
            priceOfPaper = pricesOfPaper[2];
        }

        if(this.getSizeOfPages().toString().equals("A1")){
            priceOfSize = pricesOfSize[0];
        }
        else if(this.getSizeOfPages().toString().equals("A2")){
            priceOfSize = pricesOfSize[1];
        }
        else if(this.getSizeOfPages().toString().equals("A3")){
            priceOfSize = pricesOfSize[2];
        } else if(this.getSizeOfPages().toString().equals("A4")){
            priceOfSize = pricesOfSize[3];
        } else if (this.getSizeOfPages().toString().equals("A5")){
            priceOfSize = pricesOfSize[4];
        }
        if(typeOfColor.equals(TypeOfColor.COLORED)){
            priceOfColor = pricesOfColor[0];
        }
        else {
            priceOfColor = pricesOfColor[1];
        }

        return priceOfColor.add(priceOfSize).add(priceOfPaper);
    }

    // Връща цената на принтиране на цялото издание без надценка.

    public BigDecimal getPriceForAFullEdition(BigDecimal[] pricesOfPaper, BigDecimal[] pricesOfSize, BigDecimal[] pricesOfColor){

        return getPriceForOnePage(pricesOfPaper, pricesOfSize,pricesOfColor).multiply(BigDecimal.valueOf(countOfPages));
    }

    @Override
    public String toString() {
        return "Edition{" +
                "title='" + title + '\'' +
                ", countOfPages=" + countOfPages +
                ", countOfCopies=" + countOfCopies +
                ", editionType=" + editionType +
                ", sizeOfPages=" + sizeOfPages +
                ", paperType=" + paperType +
                '}';
    }
}
