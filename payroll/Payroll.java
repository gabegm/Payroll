/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import employees.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabegm
 */
public class Payroll {
    private ArrayList<Employee> employeeList = new ArrayList();
    private Scanner scanner;
    private int choice;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        
        do {  
            payroll.choice = payroll.promptUser("1. Add an employee\n2. List all employees\n3. Search for an employee by name\n4. Delete an employee\n5. Edit employee details\n6. Save to file\n7. Load from file\n8. Exit").nextInt();
            switch(payroll.choice) {
                case 1:
                    payroll.addEmployee(payroll.choice);
                    break;
                case 2:
                    payroll.getAllEmployees();
                    break;
                case 3:
                    payroll.getEmployee();
                    break;
                case 4:
                    payroll.deleteEmployee();
                    break;
                case 5:
                    payroll.editEmployee();
                    break;
                case 6:
                    payroll.saveAllEmployeesToDisk();
                    break;
                case 7:
                    payroll.loadAllEmployeesFromDisk();
                    break;
                case 8:
                    payroll.exitApplication();
                    break;
                default:
                    System.out.println("Input not recognised");
                    break;
            }
        }while(payroll.choice != 8);
    }
    
    public void addEmployee(int choice) {
        String name, surname, dob;
        int ssn, hours;
        double sales, commission, baseSalary, salary, hourlyRate;
        
        choice = promptUser("1. Commission Employee\n2. BasePlusCommission Employee\n3. Salaried Employee\n4. Hourly Employee\n5. Exit").nextInt();
        
        name = promptUser("Enter employee first name").next();
        surname = promptUser("Enter employee last name").next();
        ssn = promptUser("Enter employee ssn").nextInt();
        dob = promptUser("Enter employee date of birth").next();
        
        switch(choice) {
            case 1:
                sales = promptUser("Enter employee sales").nextDouble();
                commission = promptUser("Enter employee commission").nextDouble();

                CommissionEmployee commissionEmployee = new CommissionEmployee(name, surname, ssn, convertStringToDate(dob), sales, commission);

                employeeList.add(commissionEmployee);

                break;
            case 2:
                sales = promptUser("Enter employee sales").nextDouble();
                commission = promptUser("Enter employee commission").nextDouble();
                baseSalary = promptUser("Enter employee base salary").nextDouble();

                BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(name, surname, ssn, convertStringToDate(dob), sales, commission, baseSalary);

                employeeList.add(basePlusCommissionEmployee);

                break;
            case 3:
                salary = promptUser("Enter employee salary").nextDouble();

                SalariedEmployee salariedEmployee = new SalariedEmployee(name, surname, ssn, convertStringToDate(dob), salary);

                employeeList.add(salariedEmployee);

                break;
            case 4:
                hours = promptUser("Enter employee hours").nextInt();
                hourlyRate = promptUser("Enter employee hourly rate").nextDouble();

                HourlyEmployee hourlyEmployee = new HourlyEmployee(name, surname, ssn, convertStringToDate(dob), hours, hourlyRate);

                employeeList.add(hourlyEmployee);

                break;
            default:
                break;
        }
    }
    
    public Scanner promptUser(String question) {
        System.out.println(question);
        scanner = new Scanner(System.in);
        return scanner;
    }
    
    public Employee searchEmployee() {
        int ssn = promptUser("Enter employee ssn").nextInt();
        
        for(Employee e: employeeList) {
            if(e.getSsn() == ssn) {
                return e;
            }
        }
        
        return null;
    }
    
    public void getAllEmployees() {
        for(Employee e: employeeList) {
            System.out.println(e);
        }
    }
    
    public void getEmployee() {
        searchEmployee().toString();
    }
    
    public void deleteEmployee() {
        employeeList.remove(searchEmployee());
    }
    
    public void editEmployee() {
        Employee e = searchEmployee();
        employeeList.remove(e);
        
        e.setName(promptUser("Enter employee name").next());
        e.setSurname(promptUser("Enter employee surname").next());
        e.setSsn(promptUser("Enter employee ssn").nextInt());
        e.setDob(convertStringToDate(promptUser("Enter employee date of birth").next()));
        
        if(e instanceof CommissionEmployee) {
            CommissionEmployee ce = (CommissionEmployee)e;
            ce.setCommission(promptUser("Enter employee commission").nextDouble());
            ce.setSales(promptUser("Enter employee sales").nextDouble());
            employeeList.add(ce);
        }else if(e instanceof BasePlusCommissionEmployee) {
            BasePlusCommissionEmployee bpc = (BasePlusCommissionEmployee)e;
            bpc.setCommission(promptUser("Enter employee commission").nextDouble());
            bpc.setBaseSalary(promptUser("Enter employee base salary").nextDouble());
            employeeList.add(bpc);
        }else if(e instanceof SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee)e;
            se.setSalary(promptUser("Enter employee salary").nextDouble());
            employeeList.add(se);
        }else if(e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee)e;
            he.setHourlyRate(promptUser("Enter employee hourly rate").nextDouble());
            he.setHours(promptUser("Enter employee hours").nextInt());
            employeeList.add(he);
        }else{
            System.out.println("Could not edit employee");
        }
    }
    
    public void saveAllEmployeesToDisk() {
        try {
            ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("items.itm"));
            objectOutput.writeObject(employeeList);
            objectOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadAllEmployeesFromDisk() {
        try {
            File file = new File("employees.itm");
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            employeeList = (ArrayList<Employee>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exitApplication() {
        System.exit(0);
    }
    
    public Date convertStringToDate(String dob) {
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            date = dateFormat.parse(dob);
        } catch (ParseException ex) {
            Logger.getLogger(Payroll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
}
