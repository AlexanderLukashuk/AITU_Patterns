import Entities.Item;
import Interfaces.MyCollectionInterfaces.Buy;
import Observer.Interfaces.IObserver;
import Observer.Interfaces.ISubject;

import java.util.ArrayList;
import java.util.List;

//public class MyCollection implements ISubject {
public class MyCollection extends Buy implements ISubject {

    public String Name;

    public void SetName(String name) {
        Name = name;
    }

    public String GetName() {
        return Name;
    }

    public ArrayList<Item> collection;
//    private List<IObserver> observers;
//    private String message;
//    private boolean changed;
//    private final Object MUTEX = new Object();
    private List<IObserver> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    private int changedSize;

    public MyCollection() {
        collection = new ArrayList<Item>();
        observers = new ArrayList<>();
        changedSize = collection.size();
    }

    public MyCollection(String name) {
        collection = new ArrayList<Item>();
        observers = new ArrayList<>();
        Name = name;
        changedSize = collection.size();
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

//    @Override
//    public void RegisterObserver(IObserver obj) {
//        if (obj == null) throw new NullPointerException("Null Observer");
//        synchronized (MUTEX) {
//            if (!observers.contains(obj)) {
//                observers.add(obj);
//            }
//        }
//    }
//
//    @Override
//    public void RemoveObserver(IObserver o) {
//        observers.remove(o);
//    }


    @Override
    public void Register(IObserver obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj)) {
                observers.add( obj);
            }
        }
    }

    @Override
    public void Unregister(Observer.Interfaces.IObserver obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void NotifyObservers() {
        List<IObserver> observersLocal = null;
        synchronized (MUTEX) {
            if (changedSize == collection.size()) {
                return;
            }
            observersLocal = new ArrayList<>(this.observers);
            this.changedSize = collection.size();
        }
        for (IObserver obj : observersLocal) {
            obj.Update();
        }
    }

    @Override
    public Object GetUpdate(Observer.Interfaces.IObserver obj) {
        return this.message;
    }

    public void PostMessage(String msg) {
        System.out.println(msg);
        System.out.println("The collection has changed");
        this.message = msg;
        this.changed = true;
        NotifyObservers();
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
