package com.company.PrintingHouse;

import com.company.Edition.Edition;
import com.company.Employee.Employee;
import com.company.Employee.TypeOfEmployee;
import com.company.PrintingMachine.NotEditionsToPrint;
import com.company.PrintingMachine.NotEnoughPaper;
import com.company.PrintingMachine.PrintingMachine;
import com.company.PrintingMachine.TypeOfColor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;




public class PrintingHouse {
    private PrintingMachine printingMachine;
    private ArrayList<Employee> employees;
    private ArrayList<Edition> editionsToPrint;
    private Prices prices; // Цените на всичко.
    private FileWriter fileWriter;
    private BigDecimal expenses = BigDecimal.valueOf(0); //Разходи.
    private Storehouse storehouse; // Склада за хартия, не съм го използвала.

    private int countForDiscount;   //Брой за печатане, който, ако се надвиши се получава discount.
    private int discount; //Намаление, ако бройката на печетаното издание стигне числото за намаление.

    private BigDecimal markup; //Надценка.
    private BigDecimal wantedIncome; // Сума, която ако стигнем чрез приходите, служителите печелят бонус.

    private BigDecimal income; // Приходи.
    private BigDecimal capital; // Налични пари.

    public PrintingHouse(
            Storehouse storehouse,
            int countForDiscount, int discount, BigDecimal markup,
            BigDecimal wantedIncome, BigDecimal capital, Prices prices, PrintingMachine printingMachine) throws IOException {

        // this.printingMachines = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.editionsToPrint = new ArrayList<>();
        this.storehouse = storehouse;
        this.countForDiscount = countForDiscount;
        this.discount = discount;
        this.markup = markup;
        this.wantedIncome = wantedIncome;
        this.capital = capital;
        this.prices = prices;
        this.printingMachine = printingMachine;
        File file = new File("Izhod.txt");
        file.createNewFile();
        this.fileWriter = new FileWriter(file);
    }

    public ArrayList<Edition> getEditionsToPrint() {
        return editionsToPrint;
    }

    public BigDecimal getWantedIncome() {
        return wantedIncome;
    }

    public Prices getPrices() {
        return prices;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void ChangeSalary (BigDecimal bigDecimal){
        employees.get(0).setSalary(bigDecimal);
    }

    public void ChangeIncrease(BigDecimal bigDecimal) {employees.get(0).setManagerIncrease(bigDecimal);}

    public void addEditionToPrint(Edition edition) {
        this.editionsToPrint.add(edition);
    }

    public void hireEmployee(Employee employee) {
        this.employees.add(employee);
    }



    //Функциите ги използваме за изчисляване на прихода.

    //putMarkUp слага надценката.
    public BigDecimal putMarkup(BigDecimal bigDecimal) {
        return bigDecimal.add(bigDecimal.multiply(markup));

    }

    //putDiscount прави намалението.
    public BigDecimal putDiscount(BigDecimal bigDecimal) {
        return bigDecimal.subtract(bigDecimal.multiply(BigDecimal.valueOf(discount)).divide(BigDecimal.valueOf(100)));
    }


    //Намира приходите.
    public BigDecimal calculateIncome() {


        BigDecimal fullIncome = BigDecimal.valueOf(0);

        for (Edition edition : editionsToPrint) {
            if (edition.getCountOfCopies() < countForDiscount) {
                fullIncome = fullIncome.add(putMarkup(edition.getPriceForAFullEdition(prices.getPricesOfPaper(), prices.getPricesOfSize(), prices.getPricesOfColor())));
            } else {


                fullIncome = fullIncome.add(putDiscount(putMarkup(edition.getPriceForAFullEdition(prices.getPricesOfPaper(), prices.getPricesOfSize(), prices.getPricesOfColor()))));
                System.out.println(fullIncome);
            }
            fullIncome = fullIncome.multiply(BigDecimal.valueOf(edition.getCountOfCopies()));
        }
        this.income = fullIncome;
        return fullIncome;
    }


    public void startPrinting() throws NotEnoughPaper, IOException {
        this.fileWriter.write("Начални пари:" + capital+ "\n");
        if(editionsToPrint.equals(0)){
            System.out.println("Няма издания за принтиране");
            return;
        }

            try {
                for (int i = 0; i < editionsToPrint.size(); i++) {
                    for (int j = 0; j < editionsToPrint.get(i).getCountOfCopies(); j++) {
                        this.fileWriter.write("Машината принтира " + editionsToPrint.get(i).getTitle() + "\n");
                        printingMachine.print(editionsToPrint.get(i));


                    }
                }


            } catch (NotEnoughPaper e) {
                System.out.println(e);

            }


        this.fileWriter.write(("Спечелени пари: " + income + "\n"));
        this.fileWriter.write(("Разход: " + calculateЕxpenses() + "\n"));
        this.fileWriter.close();
        capital = calculateЕxpenses().subtract(income);
        income = BigDecimal.valueOf(0);
        expenses = BigDecimal.valueOf(0);
        editionsToPrint.removeAll(editionsToPrint);
    }

    public BigDecimal calculateEditionsCountPrice(Edition edition){
        BigDecimal moneyToPayForPaper = BigDecimal.valueOf(0);
        moneyToPayForPaper = moneyToPayForPaper.add(edition.getPriceForAFullEdition
                (prices.getPricesOfPaper(), prices.getPricesOfSize(), prices.getPricesOfColor()))
                .multiply(BigDecimal.valueOf(edition.getCountOfCopies()));

        return  moneyToPayForPaper;

    }

    public BigDecimal getExpensesForPaper() throws NotEnoughPaper, IOException {

        BigDecimal pricess = BigDecimal.valueOf(0);
        for(int i= 0; i < editionsToPrint.size(); i++){
            pricess = pricess.add(calculateEditionsCountPrice(editionsToPrint.get(i)));

        }
        expenses = expenses.add(pricess);
        return pricess;

    }
    public BigDecimal getExpensesForSalary() {
        BigDecimal expensesForSalary = BigDecimal.valueOf(0);
        int res = calculateIncome().compareTo(getWantedIncome());
        for (Employee emploeyee : employees) {
            if (emploeyee.getTypeOfEmployee().equals(TypeOfEmployee.MANAGER) ) {
                if(res == 1) {
                    expensesForSalary = expensesForSalary.add(emploeyee.getSalary().add((emploeyee.getSalary().multiply(emploeyee.getManagerIncrease())).divide(BigDecimal.valueOf(100))));
                }
                else{
                    expensesForSalary = expensesForSalary.add(emploeyee.getSalary());
                }
            } else {

                expensesForSalary = expensesForSalary.add(emploeyee.getSalary());

            }

        }

        expenses = expenses.add(expensesForSalary);
        return expensesForSalary;
    }
   public BigDecimal calculateЕxpenses() throws NotEnoughPaper, IOException {

       return  getExpensesForSalary().add(getExpensesForPaper());

    }



    @Override
    public String toString() {
        return "PrintingHouse{" +
                "printingMachine=" + printingMachine +
                ", employees=" + employees +
                ", editionsToPrint=" + editionsToPrint +
                ", prices=" + prices +
                ", storehouse=" + storehouse +
                ", countForDiscount=" + countForDiscount +
                ", discount=" + discount +
                ", markup=" + markup +
                ", wantedIncome=" + wantedIncome +
                ", income=" + income +
                ", capital=" + capital +
                '}';
    }

      /* public void startPrinting () throws IOException {
        for(int i = 0; i <= this.editionsToPrint.size()-1; i++){
            try{
                PrintingMachine machine1 = new PrintingMachine(5000, TypeOfColor.BLACK, 20, this.editionsToPrint.get(i) );
                Thread m1 = new Thread(machine1, "Mашина 1");
                m1.start();
                System.out.println("Машината 1 печати");
                PrintingMachine machine2 = new PrintingMachine(10000, TypeOfColor.COLORED, 50, this.editionsToPrint.get(i));
                Thread m2 = new Thread(machine2, "Машина 2");
                System.out.println("Машината 2 печати");
                m2.start();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println(223);
    }*/
}