/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author gabegm
 */
public class NoOvertimeForHourlyEmployeesException extends Exception {

    public NoOvertimeForHourlyEmployeesException() {
        super("Hourly employee cannot exceed 30 hours");
    }

    public NoOvertimeForHourlyEmployeesException(String message) {
        super(message);
    }
    
}
