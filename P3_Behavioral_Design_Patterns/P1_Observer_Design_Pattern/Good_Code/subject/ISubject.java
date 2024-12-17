package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.subject;

import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.observers.IObserver;

public interface ISubject {
    public void attach(IObserver observer);

    public void detach(IObserver observer);

    public void notifyObservers();
}
