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
public class HourlyEmployee extends Employee {
    private int hours;
    private double hourlyRate;

    public HourlyEmployee() {
        super();
        this.hours = 0;
        this.hourlyRate = 0;
    }

    public HourlyEmployee(String name, String surname, int ssn, Date dob, int hours, double hourlyRate) {
        super(name, surname, ssn, dob);
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double getWage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + "hours=" + hours + ", hourlyRate=" + hourlyRate;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @return the hourlyRate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * @param hourlyRate the hourlyRate to set
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
}
