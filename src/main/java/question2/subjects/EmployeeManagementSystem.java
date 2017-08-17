package question2.subjects;



import question2.domain.Employee;
import question2.domain.EmployeeDAO;
import question2.observers.IObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiawei on 8/15/17.
 */

public class EmployeeManagementSystem implements ISubject{
    private List<IObserver> observers;
    private List<Employee> employees;

    private EmployeeDAO employeeDAO;

    private Employee employee;
    private String message;

    public EmployeeManagementSystem () {
        observers = new ArrayList<>();
        employeeDAO = new EmployeeDAO();
        employees = employeeDAO.generateEmployees();
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (IObserver department: observers) {
            department.callMe(message, employee);
        }
    }

    public void hireNewEmployee(Employee emp) {
        employee = emp;
        message = "New Employee get hired";
        notifyObservers();
    }

    public void modifyEmployeeName(int id, String newName) {
        boolean notify = false;

        for (Employee e: employees) {
            if (id == e.employeeID) {
                e.setName(newName);
                this.employee = e;
                this.message = "Employee name has been modified";
                notify = true;
            }
        }
        if (notify) {
            notifyObservers();
        }
    }
}
