package Observer.Interfaces;

public interface ISubject {

    public void Register(IObserver obj);
    public void Unregister(IObserver obj);

    public void NotifyObservers();

    public Object GetUpdate(IObserver obj);
}
