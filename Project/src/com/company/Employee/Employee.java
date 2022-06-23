package com.company.Employee;

import java.math.BigDecimal;
import java.util.HashMap;

public class Employee {
    private static BigDecimal salary = BigDecimal.valueOf(1200); //STATIC, за да е общо за всички.
    private static BigDecimal managerIncrease = BigDecimal.valueOf(5); //STATIC, за да е общо за всички.
    private TypeOfEmployee typeOfEmployee; //MANAGER, OPERATOR


    //Конструктор
    public Employee(TypeOfEmployee typeOfEmployee) {

        this.typeOfEmployee = typeOfEmployee;
    }

    //Гетъри
    public BigDecimal getSalary() {
        return salary;
    }
    public BigDecimal getManagerIncrease() {
        return managerIncrease;
    }
    public TypeOfEmployee getTypeOfEmployee() {
        return typeOfEmployee;
    }

    //Сетъри, ако искаме да сменим данните.
    public static void setManagerIncrease(BigDecimal managerIncrease) {
        Employee.managerIncrease = managerIncrease;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }



}
