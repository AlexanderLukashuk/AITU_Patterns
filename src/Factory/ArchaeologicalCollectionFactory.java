package Factory;

import Factory.Interfaces.Collection;

public class ArchaeologicalCollectionFactory extends CollectionFactory {
    @Override
    public Collection findCollection() {
        System.out.println("Sending Archaeological collection item...");
        return new ArchaeologicalCollection();

    }
}
