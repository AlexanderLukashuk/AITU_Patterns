package Interfaces;


public interface ISubject {
    public void register(IObserver obj);
    public void unregister(IObserver obj);

    public void notifyObservers();

    public Object getUpdate(IObserver obj);
}
