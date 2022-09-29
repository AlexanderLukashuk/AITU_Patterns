package Observer;

import Observer.Interfaces.IObserver;
import Observer.Interfaces.ISubject;

public class MyCollectionSubsciber implements IObserver {

    private String Name;
    private ISubject Subject;

    public MyCollectionSubsciber(String name) {
        this.Name = name;
    }

    @Override
    public void Update() {
        String msg = (String) Subject.GetUpdate(this);
        if (msg == null) {
            System.out.println(Name + " hasn't new message");
        } else {
            System.out.println(Name + "Consuming message: " + msg);
        }
    }

    @Override
    public void SetSubject(ISubject sub) {
        Subject = sub;
    }
}
