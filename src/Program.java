import Entities.*;
import Interfaces.ICar;
import Interfaces.IGame;
import Observer.Interfaces.IObserver;
import Observer.MyCollectionSubsciber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int menu = -1;
        String collection_name = null;
        List<MyCollection> all_collections = new ArrayList<>();
        CollectionTypes collection_type = new CollectionTypes();
        int typeChoice = 0;
        MyCollection temp_collection = new MyCollection();

        while (menu != 0) {
            System.out.println("Choose option: ");
            System.out.println("1) Make collection");
            System.out.println("2) Buy collection");
            System.out.println("3) Remove collection");
            System.out.println("4) Add item to collection");
            System.out.println("5) Show Collection");
            System.out.println("0) Exit");
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
//                    collection_name = input.nextLine();
                    collection_name = input.next();

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

                    for (int i = 0; i < temp_collection_length - 1; i++) {
                        System.out.print("Enter item's name: ");
//                        temp_item_name = input.nextLine();
                        temp_item_name = input.next();

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
                                int gameType = 0;

                                while (true) {
                                    System.out.println("Choose game type: ");
                                    System.out.println("1) Basic Game");
                                    System.out.println("2) Game DLC");
                                    System.out.print("Your choice: ");
                                    gameType = input.nextInt();

                                    if (gameType > 0 && gameType < 3) {
                                        break;
                                    } else {
                                        System.out.println("Error, something went wrong");
                                        System.out.println("Please try again");
                                    }
                                }

                                switch (gameType) {
                                    case 1:
                                        all_collections.get(all_collections.size() + 1).collection.add(new Game(temp_item_name, temp_item_price));
                                        break;
                                    case 2:
                                        IGame dlcGame = new GameDLC(new Game(temp_item_name, temp_item_price));
                                        all_collections.get(all_collections.size() + 1).collection.add((Item) dlcGame);
                                        break;
                                }

//                                all_collections.get(all_collections.size() + 1).collection.add(new Game(temp_item_name, temp_item_price));
                                break;
                            case 4:
                                int carType = 0;

                                while (true) {
                                    System.out.println("Choose car type:");
                                    System.out.println("1) Basic car");
                                    System.out.println("2) Luxury car");
                                    System.out.println("3) Sport car");
                                    System.out.println("4) Luxury Sport car");
                                    System.out.print("Your choice: ");
                                    carType = input.nextInt();

                                    if (carType > 0 && carType < 4) {
                                        break;
                                    } else {
                                        System.out.println("Error, something went wrong");
                                        System.out.println("Please try again");
                                    }
                                }

                                switch (carType) {
                                    case 1:
                                        all_collections.get(all_collections.size() - 1).collection.add(new BasicCar(temp_item_name, temp_item_price));
                                        break;
                                    case 2:
                                        Car car = new BasicCar(temp_item_name, temp_item_price);
                                        Car luxuryCar = new LuxuryCar(car);
                                        all_collections.get(all_collections.size() - 1).collection.add(luxuryCar);
                                        break;
                                    case 3:
//                                        Car sportCar = new SportCar(new Car(temp_item_name, temp_item_price));
                                        all_collections.get(all_collections.size() - 1).collection.add(new SportCar(new BasicCar(temp_item_name, temp_item_price)));
                                        break;
                                    case 4:
//                                        ICar sportLuxuryCar = new SportCar(new LuxuryCar(new Car(temp_item_name, temp_item_price)));
                                        all_collections.get(all_collections.size() + 1).collection.add(new LuxuryCar(new SportCar(new BasicCar(temp_item_name, temp_item_price))));
                                        break;
                                }

//                                all_collections.get(all_collections.size() + 1).collection.add(new Car(temp_item_name, temp_item_price));
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
                    break;
                case 4:
                    int collection_number = 0;
                    while (collection_number == 0) {
                        System.out.println("Choose collection: ");
                        for (int i = 0; i < all_collections.size(); i++) {
                            System.out.println((i + 1) + ") " + all_collections.get(i));
                        }
                        collection_number = input.nextInt();

                        if (collection_number == 0 || collection_number > all_collections.size()) {
                            System.out.println("Error. Please, try again");
                        }
                    }

                    temp_item_name = null;

                    System.out.print("Enter item's name: ");
                    temp_item_name = input.nextLine();

                    if (temp_item_name == null) {
                        temp_item_name = "No Name";
                    }

                    System.out.print("Enter item's price: ");
                    temp_item_price = input.nextInt();

                    String className = all_collections.get(collection_number - 1).getClass().getSimpleName();

                    switch (className) {
                        case "Item":
                            all_collections.get(collection_number - 1).collection.add(new Item(temp_item_name, temp_item_price));
                            break;
                        case "Book":
                            all_collections.get(collection_number - 1).collection.add(new Book(temp_item_name, temp_item_price));
                            break;
                        case "Game":
                            all_collections.get(collection_number - 1).collection.add(new Game(temp_item_name, temp_item_price));
                            break;
                        case "Car":
                            all_collections.get(collection_number - 1).collection.add(new BasicCar(temp_item_name, temp_item_price));
                            break;
                        case "Painting":
                            all_collections.get(collection_number - 1).collection.add(new Painting(temp_item_name, temp_item_price));
                            break;
                    }


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
//        collecction.Register((IObserver) obj2);
        collecction.Register((IObserver) obj3);

        obj1.SetSubject((collecction));
//        obj2.SetSubject((collecction));
        obj3.SetSubject((collecction));

        obj1.Update();
//        obj2.Update();
        obj3.Update();

        Item warcraft = new Item();
        warcraft.SetPrice(500);

        collecction.collection.add(warcraft);

        collecction.PostMessage("New message");

//        ICar sportCar = new SportCar(new Car("Sport", 200));
//        sportCar.Assemble();

//        ICar sportsLuxuryCar = new SportCar(new LuxuryCar(new Car()));
//        sportsLuxuryCar.Assemble();
//        Car car = new Car("Aboba", 100);
//        System.out.println(sportCar.GetCarName());
//        System.out.println(sportCar.getClass());
//        System.out.println(sportCar.toString());

//        String fullClassName = String.valueOf(sportCar.getClass());
//        String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.'));
//        System.out.println(simpleClassName);
//        System.out.println(fullClassName);


//        System.out.println(sportCar.getClass().getSimpleName());


    }
}
