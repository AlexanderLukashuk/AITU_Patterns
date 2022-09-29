package Entities;

import java.util.ArrayList;
import java.util.List;

public class CollectionTypes {

    public ArrayList<String> CollectionTypes = new ArrayList<>() {{
        add("No type");
        add("Books");
        add("Games");
        add("Cars");
        add("Paintings");
        add("Photo");
    }};

    public int GetSize() {
        return CollectionTypes.size();
    }
}
