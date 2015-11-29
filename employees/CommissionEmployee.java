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
public class CommissionEmployee extends Employee {
    private double sales;
    private double commission;

    public CommissionEmployee() {
        super();
        this.sales = 0;
        this.commission = 0;
    }

    public CommissionEmployee(String name, String surname, int ssn, Date dob, double sales, double commission) {
        super(name, surname, ssn, dob);
        this.sales = sales;
        this.commission = commission;
    }
    
    @Override
    public double getWage() {
        return getSales() * getCommission()/100;
    }

    @Override
    public String toString() {
        return super.toString() + "sales=" + sales + ", commission=" + commission;
    }

    /**
     * @return the sales
     */
    public double getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(double sales) {
        this.sales = sales;
    }

    /**
     * @return the commission
     */
    public double getCommission() {
        return commission;
    }

    /**
     * @param commission the commission to set
     */
    public void setCommission(double commission) {
        this.commission = commission;
    }
    
}
