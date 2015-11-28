/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gabegm
 */
public abstract class Employee implements Serializable {
    private String name;
    private String surname;
    private int ssn;
    private Date dob;

    public Employee() {
        this.name = null;
        this.surname = null;
        this.ssn = 0;
        this.dob = null;
    }

    public Employee(String name, String surname, int ssn, Date dob) {
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.dob = dob;
    }
    
    /**
     *
     * @return wage
     */
    public abstract double getWage();

    @Override
    public String toString() {
        return "name=" + name + ", surname=" + surname + ", ssn=" + ssn + ", dob=" + dob;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the ssn
     */
    public int getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
}
