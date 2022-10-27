import Database.DB;
import Entities.*;
import Entities.Books.PsychologicalBook;
import Entities.Books.RomanceBook;
import Entities.Books.SciFiBook;
import Entities.Books.SubBookDecorator.AdditionalEditionBook;
import Entities.Books.SubBookDecorator.LimitedCollectionBook;
import Entities.Books.SubBookDecorator.SignatureBook;
import Entities.Cars.BasicCar;
import Entities.Cars.CarsFeatures.CarMotor;
import Entities.Cars.CarsFeatures.EngineCapacity;
import Entities.Cars.LuxuryCar;
import Entities.Cars.SportCar;
import Factory.CollectionFactory;
import Observer.Interfaces.IObserver;
import Observer.MyCollectionSubsciber;
import TamplatePattern.Google;
import TamplatePattern.Log;
import TamplatePattern.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {

        DB db = DB.getInstance();
        db.GetStatement();

        Scanner input = new Scanner(System.in);
        int menu = -1;
        String collection_name = null;
        ArrayList<MyCollection> all_collections = new ArrayList<>();
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
            System.out.println("6) Show collection list");
            System.out.println("7) Login");
            System.out.println("0) Exit");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    while (true) {
                        System.out.println("Choose your collection type: ");
                        for (int i = 0; i < collection_type.MyCollectionTypes.size(); i++) {
                            System.out.println((i + 1) + ")" + collection_type.MyCollectionTypes.get(i));
                        }
                        System.out.print("Your choice: ");
                        typeChoice = input.nextInt();
//                        System.out.println(collection_type.CollectionTypes.size());

                        if (typeChoice < 0 || typeChoice > collection_type.MyCollectionTypes.size()) {
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
                    System.out.println(all_collections.get(0).Name);

//                    all_collections.add(new MyCollection(collection_name));

                    System.out.print("Enter how many items would you add: ");
                    int temp_collection_length = 0;
                    temp_collection_length = input.nextInt();
                    String temp_item_name = null;
                    int temp_item_price = 0;

                    for (int i = 0; i <= temp_collection_length - 1; i++) {
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
//                                all_collections.get(all_collections.size() + 1).collection.add(new Item(temp_item_name, temp_item_price));
                                break;
                            case 2:
                                all_collections.get(all_collections.size() - 1).collection.add(CollectionFactory.GetItem(collection_type.MyCollectionTypes.get(typeChoice - 1), temp_item_name, temp_item_price));
//                                int bookType = 0;
//
//                                while (true) {
//                                    System.out.println("Choose book type: ");
//                                    System.out.println("1) Psychological book");
//                                    System.out.println("2) Romance book");
//                                    System.out.println("3) SciFi book");
//
//                                    bookType = input.nextInt();
//
//                                    if (bookType > 0 && bookType < 4) {
//                                        break;
//                                    } else {
//                                        System.out.println("Error, something went wrong");
//                                        System.out.println("Try again");
//                                    }
//                                }
//
//                                int bookFeatures;
//                                switch (bookType) {
//                                    case 1:
//                                        bookFeatures = 0;
//
//                                        while (true) {
//                                            System.out.println("Choose features of book: ");
//                                            System.out.println("1) No features");
//                                            System.out.println("2) Additional edition");
//                                            System.out.println("3) Limited edition");
//                                            System.out.println("4) Signature author");
//                                            System.out.print("Your choice: ");
//
//                                            bookFeatures = input.nextInt();
//
//                                            if (bookFeatures > 0 && bookFeatures < 5) {
//                                                break;
//                                            } else {
//                                                System.out.println("Error, something went wrong");
//                                                System.out.println("Try again");
//                                            }
//                                        }
//                                         PsychologicalBook psychologicalBook = new PsychologicalBook(temp_item_name, temp_item_price);
//
////                                        LuxuryCar car = new LuxuryCar(new BasicCar(temp_item_name, temp_item_price));
//
//                                        int moreBookFeatures = 0;
//
//                                        switch (bookFeatures) {
//                                            case 1:
//                                                all_collections.get(all_collections.size() - 1).collection.add(psychologicalBook);
////                                                all_collections.get(all_collections.size() - 1).collection.add(CollectionFactory.GetItem(collection_type.MyCollectionTypes.get(typeChoice), temp_item_name, temp_item_price));
//                                                break;
//                                            case 2:
//                                                AdditionalEditionBook additionalEditionBook = new AdditionalEditionBook(psychologicalBook);
//                                                System.out.println("Add 1) Limited edition or 2) Signature author?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        LimitedCollectionBook tempLimitedCollectionBookd = new LimitedCollectionBook(additionalEditionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBookd);
//                                                        break;
//                                                    case 2:
//                                                        SignatureBook tempSignatureBook = new SignatureBook(additionalEditionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
//                                                        break;
//                                                    case 3:
//                                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(additionalEditionBook);
//                                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempLimitedCollectionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
//                                                break;
//                                            case 3:
//                                                LimitedCollectionBook limitedCollectionBook = new LimitedCollectionBook(psychologicalBook);
//
//                                                System.out.println("Add 1) Additional Edition or 2) Signature author?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(limitedCollectionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
//                                                        break;
//                                                    case 2:
//                                                        SignatureBook tempSignatureBook = new SignatureBook(limitedCollectionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
//                                                        break;
//                                                    case 3:
//                                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(limitedCollectionBook);
//                                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempAdditionalEditionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
//                                                break;
//                                            case 4:
//                                                SignatureBook signatureBook = new SignatureBook(psychologicalBook);
//
//                                                System.out.println("Add 1) Additional Edition or 2) Limited Collection?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(signatureBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
//                                                        break;
//                                                    case 2:
//                                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(signatureBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
//                                                        break;
//                                                    case 3:
//                                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(signatureBook);
//                                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(tempAdditionalEditionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
//                                                break;
//                                        }
//
////                                        all_collections.get(all_collections.size() - 1).collection.add(new PsychologicalBook(temp_item_name, temp_item_price));
//                                        break;
//                                    case 2:
//                                        bookFeatures = 0;
//
//                                        while (true) {
//                                            System.out.println("Choose features of book: ");
//                                            System.out.println("1) No features");
//                                            System.out.println("2) Additional edition");
//                                            System.out.println("3) Limited edition");
//                                            System.out.println("4) Signature author");
//                                            System.out.print("Your choice: ");
//
//                                            bookFeatures = input.nextInt();
//
//                                            if (bookFeatures > 0 && bookFeatures < 5) {
//                                                break;
//                                            } else {
//                                                System.out.println("Error, something went wrong");
//                                                System.out.println("Try again");
//                                            }
//                                        }
//                                        RomanceBook romanceBook = new RomanceBook(temp_item_name, temp_item_price);
//
////                                        LuxuryCar car = new LuxuryCar(new BasicCar(temp_item_name, temp_item_price));
//
//                                        switch (bookFeatures) {
//                                            case 1:
//                                                all_collections.get(all_collections.size() - 1).collection.add(romanceBook);
//                                                break;
//                                            case 2:
//                                                AdditionalEditionBook additionalEditionBook = new AdditionalEditionBook(romanceBook);
//                                                System.out.println("Add 1) Limited edition or 2) Signature author?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(additionalEditionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
//                                                        break;
//                                                    case 2:
//                                                        SignatureBook tempSignatureBook = new SignatureBook(additionalEditionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
//                                                        break;
//                                                    case 3:
//                                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(additionalEditionBook);
//                                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempLimitedCollectionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
//                                                break;
//                                            case 3:
//                                                LimitedCollectionBook limitedCollectionBook = new LimitedCollectionBook(romanceBook);
//                                                System.out.println("Add 1) Additional Edition or 2) Signature author?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(limitedCollectionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
//                                                        break;
//                                                    case 2:
//                                                        SignatureBook tempSignatureBook = new SignatureBook(limitedCollectionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
//                                                        break;
//                                                    case 3:
//                                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(limitedCollectionBook);
//                                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempAdditionalEditionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
//                                                break;
//                                            case 4:
//                                                SignatureBook signatureBook = new SignatureBook(romanceBook);
//                                                System.out.println("Add 1) Additional Edition or 2) Limited Collection?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(signatureBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
//                                                        break;
//                                                    case 2:
//                                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(signatureBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
//                                                        break;
//                                                    case 3:
//                                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(signatureBook);
//                                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(tempAdditionalEditionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
//                                                break;
//                                        }
//
////                                        all_collections.get(all_collections.size() - 1).collection.add(new RomanceBook(temp_item_name, temp_item_price));
//                                        break;
//                                    case 3:
//                                        bookFeatures = 0;
//
//                                        while (true) {
//                                            System.out.println("Choose features of book: ");
//                                            System.out.println("1) No features");
//                                            System.out.println("2) Additional edition");
//                                            System.out.println("3) Limited edition");
//                                            System.out.println("4) Signature author");
//                                            System.out.print("Your choice: ");
//
//                                            bookFeatures = input.nextInt();
//
//                                            if (bookFeatures > 0 && bookFeatures < 5) {
//                                                break;
//                                            } else {
//                                                System.out.println("Error, something went wrong");
//                                                System.out.println("Try again");
//                                            }
//                                        }
//                                        SciFiBook sciFiBook = new SciFiBook(temp_item_name, temp_item_price);
//
//                                        switch (bookFeatures) {
//                                            case 1:
//                                                all_collections.get(all_collections.size() - 1).collection.add(sciFiBook);
//                                                break;
//                                            case 2:
//                                                AdditionalEditionBook additionalEditionBook = new AdditionalEditionBook(sciFiBook);
//                                                System.out.println("Add 1) Limited edition or 2) Signature author?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(additionalEditionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
//                                                        break;
//                                                    case 2:
//                                                        SignatureBook tempSignatureBook = new SignatureBook(additionalEditionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
//                                                        break;
//                                                    case 3:
//                                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(additionalEditionBook);
//                                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempLimitedCollectionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
//                                                break;
//                                            case 3:
//                                                LimitedCollectionBook limitedCollectionBook = new LimitedCollectionBook(sciFiBook);
//                                                System.out.println("Add 1) Additional Edition or 2) Signature author?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(limitedCollectionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
//                                                        break;
//                                                    case 2:
//                                                        SignatureBook tempSignatureBook = new SignatureBook(limitedCollectionBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
//                                                        break;
//                                                    case 3:
//                                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(limitedCollectionBook);
//                                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempAdditionalEditionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
//                                                break;
//                                            case 4:
//                                                SignatureBook signatureBook = new SignatureBook(sciFiBook);
//                                                System.out.println("Add 1) Additional Edition or 2) Limited Collection?");
//                                                System.out.println("Or 3) both?");
//                                                System.out.println("4) Or don't add anything yet?");
//                                                System.out.print("Enter your choice(1-4): ");
//
//                                                moreBookFeatures = input.nextInt();
//
//                                                switch (moreBookFeatures) {
//                                                    case 1:
//                                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(signatureBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
//                                                        break;
//                                                    case 2:
//                                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(signatureBook);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
//                                                        break;
//                                                    case 3:
//                                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(signatureBook);
//                                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(tempAdditionalEditionBook2);
//                                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook2);
//                                                        break;
//                                                    case 4:
//                                                        all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
//                                                        break;
//                                                }
//
////                                                all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
//                                                break;
//                                        }
//                                        break;
//
//                                }
//                                all_collections.get(all_collections.size() + 1).collection.add(new Book(temp_item_name, temp_item_price));
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
                                        all_collections.get(all_collections.size() + 1).collection.add(new PcGame(temp_item_name, temp_item_price));
                                        break;
                                    case 2:
//                                        IGame dlcGame = new GameDLC(new Game(temp_item_name, temp_item_price));
                                        all_collections.get(all_collections.size() + 1).collection.add(new GameDLC(temp_item_name, temp_item_price));
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
                                    System.out.print("Your choice: ");
                                    carType = input.nextInt();

                                    if (carType > 0 && carType < 4) {
                                        break;
                                    } else {
                                        System.out.println("Error, something went wrong");
                                        System.out.println("Please try again");
                                    }
                                }

                                int carFeatures = 0;

                                switch (carType) {
                                    case 1:
                                        while (true) {
                                            System.out.println("Want to add features to car?");
                                            System.out.println("1) No features");
                                            System.out.println("2) Motor");
                                            System.out.println("3) Engine capacity");
                                            System.out.println("4) Both");
                                            System.out.print("Your choice: ");

                                            carFeatures = input.nextInt();

                                            if (carFeatures > 0 && carFeatures < 5) {
                                                break;
                                            } else {
                                                System.out.println("Error, something went wrong");
                                                System.out.println("Try again");
                                            }
                                        }

                                        switch (carFeatures) {
                                            case 1:
                                                all_collections.get(all_collections.size() - 1).collection.add(new BasicCar(temp_item_name, temp_item_price));
                                                break;
                                            case 2:
                                                CarMotor carMotor = new CarMotor(new BasicCar(temp_item_name, temp_item_price));
                                                all_collections.get(all_collections.size() - 1).collection.add(carMotor);
                                                break;
                                            case 3:
                                                EngineCapacity engineCapacity = new EngineCapacity(new BasicCar(temp_item_name, temp_item_price));
                                                all_collections.get(all_collections.size() - 1).collection.add(engineCapacity);
                                                break;
                                            case 4:
                                                CarMotor carMotor1 = new CarMotor(new BasicCar(temp_item_name, temp_item_price));
                                                EngineCapacity engineCapacity1 = new EngineCapacity(carMotor1);
                                                all_collections.get(all_collections.size() - 1).collection.add(engineCapacity1);
                                                break;
                                        }

//                                        all_collections.get(all_collections.size() - 1).collection.add(new BasicCar(temp_item_name, temp_item_price));
                                        break;
                                    case 2:
                                        while (true) {
                                            System.out.println("Want to add features to car?");
                                            System.out.println("1) No features");
                                            System.out.println("2) Motor");
                                            System.out.println("3) Engine capacity");
                                            System.out.println("4) Both");
                                            System.out.print("Your choice: ");

                                            carFeatures = input.nextInt();

                                            if (carFeatures > 0 && carFeatures < 5) {
                                                break;
                                            } else {
                                                System.out.println("Error, something went wrong");
                                                System.out.println("Try again");
                                            }
                                        }

                                        switch (carFeatures) {
                                            case 1:
                                                all_collections.get(all_collections.size() - 1).collection.add(new LuxuryCar(temp_item_name, temp_item_price));
                                                break;
                                            case 2:
                                                CarMotor carMotor = new CarMotor(new LuxuryCar(temp_item_name, temp_item_price));
                                                all_collections.get(all_collections.size() - 1).collection.add(carMotor);
                                                break;
                                            case 3:
                                                EngineCapacity engineCapacity = new EngineCapacity(new LuxuryCar(temp_item_name, temp_item_price));
                                                all_collections.get(all_collections.size() - 1).collection.add(engineCapacity);
                                                break;
                                            case 4:
                                                CarMotor carMotor1 = new CarMotor(new LuxuryCar(temp_item_name, temp_item_price));
                                                EngineCapacity engineCapacity1 = new EngineCapacity(carMotor1);
                                                all_collections.get(all_collections.size() - 1).collection.add(engineCapacity1);
                                                break;
                                        }
                                        break;
                                    case 3:
                                        while (true) {
                                            System.out.println("Want to add features to car?");
                                            System.out.println("1) No features");
                                            System.out.println("2) Motor");
                                            System.out.println("3) Engine capacity");
                                            System.out.println("4) Both");
                                            System.out.print("Your choice: ");

                                            carFeatures = input.nextInt();

                                            if (carFeatures > 0 && carFeatures < 5) {
                                                break;
                                            } else {
                                                System.out.println("Error, something went wrong");
                                                System.out.println("Try again");
                                            }
                                        }

                                        switch (carFeatures) {
                                            case 1:
                                                all_collections.get(all_collections.size() - 1).collection.add(new SportCar(temp_item_name, temp_item_price));
                                                break;
                                            case 2:
                                                CarMotor carMotor = new CarMotor(new SportCar(temp_item_name, temp_item_price));
                                                all_collections.get(all_collections.size() - 1).collection.add(carMotor);
                                                break;
                                            case 3:
                                                EngineCapacity engineCapacity = new EngineCapacity(new SportCar(temp_item_name, temp_item_price));
                                                all_collections.get(all_collections.size() - 1).collection.add(engineCapacity);
                                                break;
                                            case 4:
                                                CarMotor carMotor1 = new CarMotor(new SportCar(temp_item_name, temp_item_price));
                                                EngineCapacity engineCapacity1 = new EngineCapacity(carMotor1);
                                                all_collections.get(all_collections.size() - 1).collection.add(engineCapacity1);
                                                break;
                                        }
//                                        Car sportCar = new SportCar(new Car(temp_item_name, temp_item_price));
//                                        all_collections.get(all_collections.size() - 1).collection.add(new SportCar(new BasicCar(temp_item_name, temp_item_price)));
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
//                            all_collections.get(collection_number - 1).collection.add(new Item(temp_item_name, temp_item_price));
                            break;
                        case "Book":
//                            all_collections.get(collection_number - 1).collection.add(new Book(temp_item_name, temp_item_price));
                            break;
                        case "Game":
                            all_collections.get(collection_number - 1).collection.add(new PcGame(temp_item_name, temp_item_price));
                            break;
                        case "Car":
                            all_collections.get(collection_number - 1).collection.add(new BasicCar(temp_item_name, temp_item_price));
                            break;
                        case "Painting":
                            all_collections.get(collection_number - 1).collection.add(new Painting(temp_item_name, temp_item_price));
                            break;
                    }
                case 5:
                    int collectionNumber = 0;
                    System.out.println("Choose collection");
                    for (int i = 0; i < all_collections.size(); i++) {
                        System.out.println((i + 1) + ") " + all_collections.get(i).collection.get(i).getClass().getSimpleName() + "s collection" + all_collections.get(i).GetName());
                    }
                    collectionNumber = input.nextInt();
                    collectionNumber--;

                    for (int i = 0; i < all_collections.size(); i++) {
                        System.out.println((i + 1) + ") " + all_collections.get(i).collection.get(i).getClass().getSimpleName() + "s collection " + all_collections.get(i).GetName());
                        if (i == collectionNumber) {
                            for (int j = 0; j < all_collections.get(i).collection.size(); j++) {
                                System.out.println("Name: " + all_collections.get(i).collection.get(j).Name + " Price: " + all_collections.get(i).collection.get(j).GetPrice());
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println(all_collections.size());
                    System.out.println(all_collections.get(0).collection.size());
                    break;
                case 7:
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    Log log = null;
                    System.out.print("Input user name: ");
                    String User = reader.readLine();
                    System.out.print("Input password: ");
                    String password = reader.readLine();
                    System.out.print("Which collection to post: ");
                    String message = reader.readLine();
                    while (true) {
                        System.out.println("Log in using: ");
                        System.out.println("1) Google");
                        System.out.println("2) Twitter");
                        System.out.println("3) Exit");
                        System.out.print("Your choice: ");
//
                        int choice = Integer.parseInt(reader.readLine());
                        if (choice == 1) {
                            log = new Google(User, password);

                            db.InsertIntoUsersTable(log.User, log.password);
                        } else if (choice == 2) {
                            log = new Twitter(User, password);

                            db.InsertIntoUsersTable(log.User, log.password);
                        } else if (choice == 3) {
                            System.out.println("Bye");
                            break;
                        }
                        log.post(message);
                    }
                case 8:
                    System.out.print("Enter Login: ");
                    String login = input.nextLine();
                    System.out.print("Enter password: ");
                    String pass = input.nextLine();
                case 9:
//                    Delivery delivery = new Delivery();
//                    UI ui = new UI(delivery);
//                    ui.init();
                    break;
                case 0:
                    System.out.println("Bye");
                    db.close();
                    break;


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

        System.out.println(all_collections.get(0).collection.get(0).getClass().getSimpleName());

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

//        Item warcraft = new Item();
//        warcraft.SetPrice(500);

//        collecction.collection.add(warcraft);

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

//        Animal a = Cat();
//        Animal a = AnimalFactory.getAnimal("Кошка");


    }
}
