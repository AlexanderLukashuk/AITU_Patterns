import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Item warcraft = new Item();
        warcraft.SetPrice(500);

        Item dota = new Item();
        dota.SetPrice(2000);

        Item lol = new Item();
        lol.SetPrice(1800);

        MyCollection games_collection = new MyCollection();
        games_collection.collection.add(warcraft);
        games_collection.collection.add(dota);
        games_collection.collection.add(lol);

        ArrayList<MyCollection> collections = new ArrayList<>();
        collections.add(games_collection);

        int menu = 0;
        System.out.println("Choose collection:");
        for (int i = 0; i < collections.size(); i++)
        {
            System.out.println((i + 1) +  ") " + collections.get(i));

        }

        Scanner input = new Scanner(System.in);
        menu = input.nextInt();

        for (int i = 0; i < collections.size(); i++) {
            if (i + 1 == menu) {
//                ArrayList<Item> temp = new ArrayList<>();
//                MyCollection temp = collections.get(i);
//                for (int j = 0; j < temp.GetSize(); i++) {
//                    System.out.println(temp.collection.get(j).Name);
//                }
                MyCollection temp = collections.get(i);
                System.out.println(temp.decay());
            }
        }
    }
}
