package question2.subjects;


import question2.observers.IObserver;

/**
 * Created by Jiawei on 8/15/17.
 */

public interface ISubject {
    public void registerObserver(IObserver o);
    public void removeObserver(IObserver o);
    public void notifyObservers();
}
