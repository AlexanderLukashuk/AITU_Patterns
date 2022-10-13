package Factory;

import Factory.Interfaces.Collection;

public abstract class CollectionFactory {
    public void orderCollection() {
        System.out.println("Ordering Collection...");
        Collection collection = findCollection();
        collection.send();
    }

    public abstract Collection findCollection();
}
