package com.company.PrintingMachine;

import com.company.Edition.Edition;

import java.math.BigDecimal;

public class PrintingMachine {

    private int maxNumberOfPaper;
    private int currentPaper;
    private TypeOfColor typeOfColor;
    private int pagesPerMinute;
    private Edition edition;
    private BigDecimal capital;

    public PrintingMachine(int maxNumberOfPaper, int pagesPerMinute) {

        this.maxNumberOfPaper = maxNumberOfPaper;
        this.pagesPerMinute = pagesPerMinute;
        this.currentPaper = maxNumberOfPaper;
    }

    public void chargeMachine(){
        currentPaper = maxNumberOfPaper;
    }

    public void print(Edition edition) throws NotEnoughPaper {

        if (this.currentPaper <edition.getCountOfPages()){
            chargeMachine();
            throw new NotEnoughPaper("Not enough in machine " + maxNumberOfPaper);
        }
        else{
            currentPaper = currentPaper-edition.getCountOfPages();
           // System.out.println("Успешно принтиране на : " + edition.getTitle());
        }
    }


  /*  @Override
    public void run() {
        if(this.currentPaper < edition.getCountOfPages()){
           throw new NotEnoughPaper(maxNumberOfPaper);
        }
    }
*/
}
