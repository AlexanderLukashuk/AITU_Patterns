package Factory;

import Factory.Interfaces.Collection;

public abstract class CollectionFactory2 {
    public void orderCollection() {
        System.out.println("Ordering Collection...");
        Collection collection = findCollection();
        collection.send();
    }

    public abstract Collection findCollection();
}
