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
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double BaseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.BaseSalary = 0;
    }

    public BasePlusCommissionEmployee(String name, String surname, int ssn, Date dob, double sales, double commission, double BaseSalary) {
        super(name, surname, ssn, dob, sales, commission);
        this.BaseSalary = BaseSalary;
    }

    @Override
    public double getWage() {
        return getBaseSalary() + getSales() * getCommission()/100;
    }

    @Override
    public String toString() {
        return super.toString() + "BaseSaalry=" + BaseSalary + "wage=" + getWage();
    }

    /**
     * @return the BaseSalary
     */
    public double getBaseSalary() {
        return BaseSalary;
    }

    /**
     * @param BaseSalary the BaseSalary to set
     */
    public void setBaseSalary(double BaseSalary) {
        this.BaseSalary = BaseSalary;
    }

}
