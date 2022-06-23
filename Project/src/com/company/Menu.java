package com.company;

import com.company.Edition.Edition;
import com.company.Edition.EditionType;
import com.company.Edition.PaperType;
import com.company.Edition.SizeOfPages;
import com.company.Employee.Employee;
import com.company.Employee.TypeOfEmployee;
import com.company.PrintingHouse.Prices;
import com.company.PrintingHouse.PrintingHouse;
import com.company.PrintingHouse.Storehouse;
import com.company.PrintingMachine.NotEnoughPaper;
import com.company.PrintingMachine.PrintingMachine;
import com.company.PrintingMachine.TypeOfColor;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    Scanner myObj = new Scanner(System.in);

    public void readFromFileOrConsole() throws IOException, NotEnoughPaper {

        System.out.println("Изберете опция от менюто: ");
        System.out.println("1. Въвеждане на данни от файл.");
        System.out.println("2. Изключи програмата.");

        String option = myObj.nextLine();
        if(option.equals("1")){
            PrintingHouse printingHouse = readFromAFilePrintingHouse();

                menuOptions(printingHouse);

        }
        else if(option.equals("2")){
            System.out.println(2);
        }
        else if(option.equals("3")){
                System.exit(0);
        }
        else{
            System.out.println("Въведете число от менюто.");
        }
    }

    public void menuOptions(PrintingHouse printingHouse) throws IOException, NotEnoughPaper {
        System.out.println("Изберете опция от менюто: ");
        System.out.println("1. Изчисляване на приходите.");
        System.out.println("2. Изчисляване на разходите. ");
        System.out.println("3. Смяна на заплатата на служителите. ");
        System.out.println("4. Промяна на процента за увеличение.");
        System.out.println("5. Принтиране на цените.");
        System.out.println("6. Наеми служител.");
        System.out.println("7. Добави издание.");
        System.out.println("8. Върни се назад. ");


        String option = myObj.nextLine();

        if(option.equals("1")) {
           System.out.println(printingHouse.calculateIncome());
            menuOptions(printingHouse);
        }
        else if(option.equals("2")){
            System.out.println(printingHouse.calculateЕxpenses());
            printingHouse.startPrinting();
            menuOptions(printingHouse);
        }
        else if(option.equals("3")) {
            System.out.println("Въведете сумата, с която искате да смените основната заплата на служителите.");
            option = myObj.nextLine();
            printingHouse.ChangeSalary(new BigDecimal(option));
            /* За тестване!
           for(Employee employee: printingHouse.getEmployees()){
               System.out.println(employee.getSalary());
            }*/
            menuOptions(printingHouse);
        }
        else if(option.equals("4")) {
            System.out.println("Въведете сумата, с която искате да смените процента за увеличение  на служителите.");
            option = myObj.nextLine();
           printingHouse.ChangeIncrease(new BigDecimal(option));
            menuOptions(printingHouse);
        }
        else if(option.equals("5")) {
          System.out.println(  printingHouse.getPrices().toString());
            menuOptions(printingHouse);
        }
        else if(option.equals("6")) {
           System.out.println("Въвед тип служител: ");
           option = myObj.nextLine();
           Employee employee = new Employee(TypeOfEmployee.valueOf(option));
           printingHouse.hireEmployee(employee);

            menuOptions(printingHouse);
        }
        else if(option.equals("7")) {
            System.out.println("Въведeте заглавие: ");
            String title = myObj.nextLine();

            System.out.println("Въведете брой на страници: ");
            int countofpages = Integer.parseInt(myObj.nextLine());

            System.out.println("Въведете брой копия: ");
            int countofCopies = Integer.parseInt(myObj.nextLine());

            System.out.println("Въведете вид на изданието: ");
            EditionType еditiontype = EditionType.valueOf(myObj.nextLine());

            System.out.println("Въведете размер: ");
            SizeOfPages sizeOfPages = SizeOfPages.valueOf(myObj.nextLine());

            System.out.println("Въведете вид на хартията: ");
            PaperType paperType = PaperType.valueOf(myObj.nextLine());

            System.out.println("Въведете цвят: ");
            TypeOfColor typeOfColor = TypeOfColor.valueOf(myObj.nextLine());

            Edition edition = new Edition(title,countofpages,countofCopies, еditiontype,sizeOfPages,paperType,typeOfColor );
            printingHouse.addEditionToPrint(edition);
            menuOptions(printingHouse);
        }
        else if(option.equals("8")){
            return;
        }


    }
    
    public PrintingHouse readFromAFilePrintingHouse(){
        
        PrintingHouse house = null;

        try (FileReader fis = new FileReader(new File("fileWithInformation.txt"))) {

            BufferedReader bufferedReader = new BufferedReader(fis);

            //Прочита наличността на обикновена хартия.

            String line = bufferedReader.readLine();

               String[] normalStorageString = line.split(" ");
               int[] normalStorageInt = new int[5];
                for (int i = 0; i< normalStorageString.length; i++){
                    normalStorageInt[i] = Integer.parseInt(normalStorageString[i]);
                }


            //Прочита наличността на glossy хартията.
             line = bufferedReader.readLine();

            String[] glossyStorageString = line.split(" ");
            int[] glossyStorageInt = new int[5];
            for (int i = 0; i< glossyStorageString.length; i++){
                glossyStorageInt[i] = Integer.parseInt(glossyStorageString[i]);
            }

            //Прочита наличността на  printsNewPaper хартията.
            line = bufferedReader.readLine();

            String[] printsNewPaperStorageString = line.split(" ");
            int[] printsNewPaperStorageInt = new int[5];
            for (int i = 0; i< glossyStorageString.length; i++){
                printsNewPaperStorageInt[i] = Integer.parseInt(printsNewPaperStorageString[i]);
            }

            Storehouse storehouse = new Storehouse(normalStorageInt,glossyStorageInt,printsNewPaperStorageInt);


            //Прочита бройката на изданията за получаване на намаления.
            line = bufferedReader.readLine();
            int countOfCopiesForDiscount = Integer.parseInt(line);

            line = bufferedReader.readLine();
            int discountFromAfile = Integer.parseInt(line);

            //Прочита надценката.
            line = bufferedReader.readLine();
            BigDecimal markupFromAFile = new BigDecimal(line);


            //Нужни приходи.
            line = bufferedReader.readLine();
            BigDecimal wantedIncomeFromAFile = BigDecimal.valueOf(Long.parseLong(line));


            //Налични пари.
            line = bufferedReader.readLine();
            BigDecimal moneyFromAFile = BigDecimal.valueOf(Long.parseLong(line));


            //Чете цените за хартията.
            line = bufferedReader.readLine();

            String[] pricesOfPaperString = line.split(" ");
            BigDecimal[] pricesOfPaperBigDecimal = new BigDecimal[3];
            for (int i = 0; i< pricesOfPaperString.length; i++){

                pricesOfPaperBigDecimal[i] = new BigDecimal(pricesOfPaperString[i]);
            }


            //Чете цените за размер на хартията.
            line = bufferedReader.readLine();

            String[] sizeOfPaperString = line.split(" ");
            BigDecimal[] sizeOfPaperBigDecimal = new BigDecimal[5];
            for (int i = 0; i<sizeOfPaperString.length; i++){

                sizeOfPaperBigDecimal[i] = new BigDecimal(sizeOfPaperString[i]);
            }

            line = bufferedReader.readLine();

            String[] colorOfPaperString = line.split(" ");
            BigDecimal[] colorOfPaperBigDecimal = new BigDecimal[2];
            for (int i = 0; i<colorOfPaperString.length; i++){

               colorOfPaperBigDecimal[i] = new BigDecimal(colorOfPaperString[i]);

            }

            Prices prices = new Prices(pricesOfPaperBigDecimal, sizeOfPaperBigDecimal,colorOfPaperBigDecimal);

            //Заглавие.
            line = bufferedReader.readLine();
            String title = line;

            //Брой на страници.
            line = bufferedReader.readLine();
            int countOfPages = Integer.parseInt(line);

            //Колко копия да се направят.
            line = bufferedReader.readLine();
            int countOfCopies = Integer.parseInt(line);

            //Вид на изданието.
            line = bufferedReader.readLine();
            EditionType editionType = EditionType.valueOf(line);

            //Размер на страниците.
            line = bufferedReader.readLine();
            SizeOfPages sizeOfPages = SizeOfPages.valueOf(line);

            //Вид на хартията.
            line = bufferedReader.readLine();
           PaperType paperType = PaperType.valueOf(line);

            //Вид на хартията.
            line = bufferedReader.readLine();
            TypeOfColor isColorod = TypeOfColor.valueOf(line);


            line = bufferedReader.readLine();
            TypeOfEmployee typeOfEmployee = TypeOfEmployee.valueOf(line);
            Employee employee = new Employee(typeOfEmployee);

            line = bufferedReader.readLine();
            TypeOfEmployee typeOfEmployee1 = TypeOfEmployee.valueOf(line);
            Employee employee1 = new Employee(typeOfEmployee1);



            line = bufferedReader.readLine();
            int maxPages = Integer.parseInt(line);

            line = bufferedReader.readLine();
            int pagesPerMinute = Integer.parseInt(line);

            PrintingMachine printingMachine = new PrintingMachine(maxPages, pagesPerMinute);

            Edition edition = new Edition(title, countOfPages,countOfCopies,editionType,sizeOfPages,paperType,isColorod);
            house = new PrintingHouse(storehouse, countOfCopiesForDiscount, discountFromAfile, markupFromAFile, wantedIncomeFromAFile, moneyFromAFile,prices, printingMachine);
            house.addEditionToPrint(edition);
            house.hireEmployee(employee);
            house.hireEmployee(employee1);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return house;
    }
}
