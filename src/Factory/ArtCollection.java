package Factory;

import Factory.Interfaces.Collection;

public class ArtCollection implements Collection {
    @Override
    public void send() {
        System.out.println("Preparing for sending new Art...");
    }
}
