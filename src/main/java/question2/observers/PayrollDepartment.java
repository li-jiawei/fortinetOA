package question2.observers;


import question2.domain.Employee;

/**
 * Created by Jiawei on 8/15/17.
 */

public class PayrollDepartment implements IObserver {
    @Override
    public void callMe(String msg, Employee e) {
        System.out.println("PayrollDepartment is notified...");
        System.out.println(msg + ": " + e.getName());
    }
}
