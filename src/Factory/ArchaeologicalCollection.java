package Factory;

import Factory.Interfaces.Collection;

public class ArchaeologicalCollection implements Collection {
    @Override
    public void send() {
        System.out.println("Preparing for sending Archaeological item...");
    }
}
