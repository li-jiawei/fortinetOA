package question2.observers;

import question2.domain.Employee;

/**
 * Created by Jiawei on 8/15/17.
 */

public interface IObserver {
    public void callMe(String msg, Employee e);
}
