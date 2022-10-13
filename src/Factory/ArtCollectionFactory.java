package Factory;

import Factory.Interfaces.Collection;

public class ArtCollectionFactory extends CollectionFactory2 {
    @Override
    public Collection findCollection() {
        System.out.println("Sending Art collection...");
        return new ArtCollection();
    }
}
