package question2.domain;

import java.util.Date;

/**
 * Created by Jiawei on 8/15/17.
 */

public class Employee {
    private String name;
    private Date hireDate;
    private int salary;
    private boolean active;
    public int employeeID;

    private static int COUNTER;

    public Employee(String name, Date hireDate, int salary, boolean active) {
        this.name = name;
        this.hireDate = hireDate;
        this.salary = salary;
        this.active = active;

        employeeID = ++COUNTER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
