import java.util.ArrayList;

public class ConcreteObservable : IObservable
{
        private ArrayList<IObserver> observers;
        public ConcreteObservable()
        {
            observers = new ArrayList<IObserver>();
        }

        public void AddObserver(IObserver o)
        {
            observers.Add(o);
        }

        public void RemoveObserver(IObserver)
        {
                observers.Remove(o);
        }

        public void NotifyObservers()
        {
                for (int i = 0; i < observers.Length; i++)
                {
                        obser
                }
        }
}
