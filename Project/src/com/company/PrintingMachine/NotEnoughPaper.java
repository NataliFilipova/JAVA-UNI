package com.company.PrintingMachine;

import java.math.BigDecimal;

public class NotEnoughPaper extends Exception{
    private int maxNumberOfpages;

    public NotEnoughPaper(String message, int maxNumberOfpages) {
        super(message);
        this.maxNumberOfpages = maxNumberOfpages;
    }

    public NotEnoughPaper(String message) {
    }
}

