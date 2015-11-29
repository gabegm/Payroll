/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.util.Date;

/**
 *
 * @author gabegm
 */
public class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee() {
        super();
        this.salary = 0;
    }

    public SalariedEmployee(String name, String surname, int ssn, Date dob, double salary) {
        super(name, surname, ssn, dob);
        this.salary = salary;
    }
    
    @Override
    public double getWage() {
        return getSalary();
    }

    @Override
    public String toString() {
        return super.toString() + "salary=" + salary + "wage=" + getWage();
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
