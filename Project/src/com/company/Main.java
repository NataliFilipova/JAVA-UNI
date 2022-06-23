package com.company;

import com.company.PrintingMachine.NotEnoughPaper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NotEnoughPaper, IOException {
        Menu menu = new Menu();

        while (true) {
            menu.readFromFileOrConsole();
        }



    }
}
