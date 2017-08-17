package question2;

import org.junit.Test;
import question2.domain.Employee;
import question2.observers.HRDepartment;
import question2.observers.IObserver;
import question2.observers.PayrollDepartment;
import question2.subjects.EmployeeManagementSystem;

import java.util.Date;

/**
 * Created by Jiawei on 8/16/17.
 */
public class ObserverPatternTest {
    @Test
    public void test() {
        IObserver payroll = new PayrollDepartment();
        IObserver hrSystem = new HRDepartment();

        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.registerObserver(payroll);

        Employee bob = new Employee("Bob", new Date(), 35000, true);

        // first event occurs
        ems.hireNewEmployee(bob);
        // second event occurs
        ems.modifyEmployeeName(2, "Imtiaz");
    }
}
