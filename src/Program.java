import Entities.*;
import Observer.Interfaces.IObserver;
import Observer.MyCollectionSubsciber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menu = 0;
        String collection_name = null;
        List<MyCollection> all_collections = new ArrayList<>();
        CollectionTypes collection_type = new CollectionTypes();
        int typeChoice = 0;
        MyCollection temp_collection = new MyCollection();

        while (menu != 5) {
            System.out.println("Choose option: ");
            System.out.println("1) Make collection");
            System.out.println("2) Buy collection");
            System.out.println("3) Remove collection");
            System.out.println("4) Add item to collection");
            System.out.println("5) Exit");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    while (true) {
                        System.out.println("Choose your collection type: ");
                        for (int i = 0; i < collection_type.CollectionTypes.size(); i++) {
                            System.out.println((i + 1) + ")" + collection_type.CollectionTypes.get(i));
                        }
                        System.out.print("Your choice: ");
                        typeChoice = input.nextInt();
                        System.out.println(collection_type.CollectionTypes.size());

                        if (typeChoice < 0 || typeChoice > collection_type.CollectionTypes.size()) {
                            System.out.println("Sorry, you chose the wrong type. Please try again");
                        } else {
                            break;
                        }
                    }


                    System.out.print("Enter collection name: ");
                    collection_name = input.nextLine();

                    if (collection_name == null) {
                        collection_name = "No name";
                    }

                    all_collections.add(new MyCollection(collection_name));

                    all_collections.add(new MyCollection(collection_name));

                    System.out.print("Enter how many items would you add: ");
                    int temp_collection_length = 0;
                    temp_collection_length = input.nextInt();
                    String temp_item_name = null;
                    int temp_item_price = 0;

                    for (int i = 0; i < temp_collection_length; i++) {
                        System.out.print("Enter item's name: ");
                        temp_item_name = input.nextLine();

                        if (temp_item_name == null) {
                            temp_item_name = "No name";
                        }

                        System.out.print("Enter item's price: ");
                        temp_item_price = input.nextInt();

                        switch (typeChoice) {
                            case 1:
                                all_collections.get(all_collections.size() + 1).collection.add(new Item(temp_item_name, temp_item_price));
                                break;
                            case 2:
                                all_collections.get(all_collections.size() + 1).collection.add(new Book(temp_item_name, temp_item_price));
                                break;
                            case 3:
                                all_collections.get(all_collections.size() + 1).collection.add(new Game(temp_item_name, temp_item_price));
                                break;
                            case 4:
                                all_collections.get(all_collections.size() + 1).collection.add(new Car(temp_item_name, temp_item_price));
                                break;
                            case 5:
                                all_collections.get(all_collections.size() + 1).collection.add(new Painting(temp_item_name, temp_item_price));
                                break;

                        }
                    }
                    System.out.println("Collection successfully created");
                    break;
                case 3:
                    System.out.print("Enter collection name which want to remove: ");
                    collection_name = input.nextLine();

                    for (int i = 0; i < all_collections.size(); i++) {
                        if (all_collections.get(i).Name == collection_name) {
                            all_collections.remove(i);
                        }
                    }

                    System.out.println("Processing...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Collection successfully removed");
            }
        }
//
//
//        Item warcraft = new Item();
//        warcraft.SetPrice(500);
//
//        Item dota = new Item();
//        dota.SetPrice(2000);
//
//        Item lol = new Item();
//        lol.SetPrice(1800);
//
//        MyCollection games_collection = new MyCollection();
//        games_collection.collection.add(warcraft);
//        games_collection.collection.add(dota);
//        games_collection.collection.add(lol);
//
//        ArrayList<MyCollection> collections = new ArrayList<>();
//        collections.add(games_collection);
//
//        int collection_menu = 0;
//        System.out.println("Choose collection:");
//        for (int i = 0; i < collections.size(); i++)
//        {
//            System.out.println((i + 1) +  ") " + collections.get(i));
//
//        }
//
//
//        collection_menu = input.nextInt();
//
//        for (int i = 0; i < collections.size(); i++) {
//            if (i + 1 == collection_menu) {
////                ArrayList<Entities.Item> temp = new ArrayList<>();
////                MyCollection temp = collections.get(i);
////                for (int j = 0; j < temp.GetSize(); i++) {
////                    System.out.println(temp.collection.get(j).Name);
////                }
//                MyCollection temp = collections.get(i);
//                System.out.println(temp.decay());
//            }
//        }

        MyCollection collecction = new MyCollection();

        IObserver obj1 = (IObserver) new MyCollectionSubsciber("Obj1");
        IObserver obj2 = (IObserver) new MyCollectionSubsciber("Obj2");
        IObserver obj3 = (IObserver) new MyCollectionSubsciber("Obj3");

        collecction.Register((IObserver) obj1);
        collecction.Register((IObserver) obj2);
        collecction.Register((IObserver) obj3);

        obj1.SetSubject((collecction));
        obj2.SetSubject((collecction));
        obj3.SetSubject((collecction));

        obj1.Update();

        Item warcraft = new Item();
        warcraft.SetPrice(500);

        collecction.collection.add(warcraft);

        collecction.PostMessage("New message");


    }
}
