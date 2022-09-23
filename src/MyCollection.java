import Interfaces.IObservable;
import Interfaces.IObserver;
import Interfaces.ISubject;

import java.util.ArrayList;
import java.util.List;

//public class MyCollection implements ISubject {
public class MyCollection implements IObservable {
    public ArrayList<Item> collection;
//    private List<IObserver> observers;
//    private String message;
//    private boolean changed;
//    private final Object MUTEX = new Object();
    public List<IObserver> observers;

    public MyCollection() {
        collection = new ArrayList<Item>();
//        this.observers = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void Sale() {

    }

    public void Present() {

    }

    public int GetSize() {
        return collection.size();
    }

    public int calculateTotal(){
        int sum = 0;
        for(Item item : collection){
            sum += item.GetPrice();
        }
        return sum;
    }

    public String decay() {
        int sum = 0;
        for (Item item : collection) {
            sum += item.GetPrice();
        }
//        System.out.println((sum * 0.7) + " 30% sale because it might destroy");
        return ((sum * 0.7) + " 30% sale because it might destroy");
    }

    @Override
    public void RegisterObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveObserver(IObserver o) {
        observers.remove(o);
    }

    @Override
    public void NotifyObservers() {
        for (IObserver o : observers) {
            o.Update(collection);
        }
    }

//    @Override
//    public void unregister(IObserver obj) {
//
//    }
//
//    @Override
//    public void register(IObserver obj) {
//        if (obj == null) throw new NullPointerException("Null Observer");
//        synchronized (MUTEX) {
//            if (!observers.contains(obj))
//        }
//
//    }
//
//    @Override
//    public void notifyObservers() {
//
//    }
//
//    @Override
//    public Object getUpdate(IObserver obj) {
//        return null;
//    }
}
