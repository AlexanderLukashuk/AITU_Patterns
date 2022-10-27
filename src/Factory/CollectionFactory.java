package Factory;

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

import java.util.ArrayList;
import java.util.Scanner;

public class CollectionFactory {

    public static Item GetItem(String type, String name, int price) {

        DB db = DB.getInstance();
        db.GetStatement();

        Scanner input = new Scanner(System.in);
        switch (type) {
            case "Books":
                int bookType = 0;
                System.out.println("Factory ready to send your books");

                while (true) {
                    System.out.println("Choose book type: ");
                    System.out.println("1) Psychological book");
                    System.out.println("2) Romance book");
                    System.out.println("3) SciFi book");

                    bookType = input.nextInt();

                    if (bookType > 0 && bookType < 4) {
                        break;
                    } else {
                        System.out.println("Error, something went wrong");
                        System.out.println("Try again");
                    }
                }

                int bookFeatures = 0;
                switch (bookType) {
                    case 1:
                        bookFeatures = 0;

                        while (true) {
                            System.out.println("Choose features of book: ");
                            System.out.println("1) No features");
                            System.out.println("2) Additional edition");
                            System.out.println("3) Limited edition");
                            System.out.println("4) Signature author");
                            System.out.print("Your choice: ");

                            bookFeatures = input.nextInt();

                            if (bookFeatures > 0 && bookFeatures < 5) {
                                break;
                            } else {
                                System.out.println("Error, something went wrong");
                                System.out.println("Try again");
                            }
                        }
//                        PsychologicalBook psychologicalBook = new PsychologicalBook(temp_item_name, temp_item_price);

//                                        LuxuryCar car = new LuxuryCar(new BasicCar(temp_item_name, temp_item_price));

                        int moreBookFeatures = 0;
                        ArrayList<String> features = new ArrayList<>();

                        switch (bookFeatures) {
                            case 1:
                                System.out.println("Psychological book sent");

                                features.removeAll(features);
                                features.add(" ");
                                features.add(" ");
                                features.add(" ");
                                db.InsertIntoBooksTable(name, price, features);
                                return new PsychologicalBook(name, price);
//                                all_collections.get(all_collections.size() - 1).collection.add(psychologicalBook);
//                                break;
                            case 2:
//                                AdditionalEditionBook additionalEditionBook = new AdditionalEditionBook(psychologicalBook);
                                System.out.println("Add 1) Limited edition or 2) Signature author?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        LimitedCollectionBook tempLimitedCollectionBookd = new LimitedCollectionBook(additionalEditionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBookd);
                                        System.out.println("Limited collection, additional edition psychological book sent");

                                        LimitedCollectionBook l1 = new LimitedCollectionBook(new AdditionalEditionBook(new PsychologicalBook(name, price)));
                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("Additional Edition");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, l1.Price, features);
                                        return new LimitedCollectionBook(new AdditionalEditionBook(new PsychologicalBook(name, price)));
//                                        break;
                                    case 2:
//                                        SignatureBook tempSignatureBook = new SignatureBook(additionalEditionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
                                        System.out.println("Author signature additional edition psychological book sent");

                                        features.removeAll(features);
                                        features.add("Signature Author");
                                        features.add("Additional Edition");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new SignatureBook(new AdditionalEditionBook(new PsychologicalBook(name, price)));
//                                        break;
                                    case 3:
//                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(additionalEditionBook);
//                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempLimitedCollectionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
                                        System.out.println("Author signature limited collection additional edition psychological book sent");

                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("Signature Author");
                                        features.add("Additional Edition");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new SignatureBook(new LimitedCollectionBook(new AdditionalEditionBook(new PsychologicalBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);

                                        features.removeAll(features);
                                        features.add("Additional Edition");
                                        features.add("");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new AdditionalEditionBook(new PsychologicalBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
                                break;
                            case 3:
//                                LimitedCollectionBook limitedCollectionBook = new LimitedCollectionBook(psychologicalBook);

                                System.out.println("Add 1) Additional Edition or 2) Signature author?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(limitedCollectionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
                                        System.out.println("Limited collection, additional edition psychological book sent");

                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("Additional Edition");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new AdditionalEditionBook(new LimitedCollectionBook(new PsychologicalBook(name, price)));
//                                        break;
                                    case 2:
//                                        SignatureBook tempSignatureBook = new SignatureBook(limitedCollectionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
                                        System.out.println("Author signature limited collection psychological book sent");

                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("Signature Author");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new SignatureBook(new LimitedCollectionBook(new PsychologicalBook(name, price)));
//                                        break;
                                    case 3:
//                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(limitedCollectionBook);
//                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempAdditionalEditionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
                                        System.out.println("Author signature limited collection additional edition psychological book sent");

                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("Additional Edition");
                                        features.add("Signature Author");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new SignatureBook(new AdditionalEditionBook(new LimitedCollectionBook(new PsychologicalBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
                                        System.out.println("Limited collection psychological book sent");
                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new LimitedCollectionBook(new PsychologicalBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
                                break;
                            case 4:
//                                SignatureBook signatureBook = new SignatureBook(psychologicalBook);

                                System.out.println("Add 1) Additional Edition or 2) Limited Collection?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(signatureBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
                                        System.out.println("Author signature addition edition psychological book sent");

                                        features.removeAll(features);
                                        features.add("Additional Edition");
                                        features.add("Signature Author");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new AdditionalEditionBook(new SignatureBook(new PsychologicalBook(name, price)));
//                                        break;
                                    case 2:
//                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(signatureBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
                                        System.out.println("Author signature limited collection psychological book sent");

                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("Signature Author");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new LimitedCollectionBook(new SignatureBook(new PsychologicalBook(name, price)));
//                                        break;
                                    case 3:
//                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(signatureBook);
//                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(tempAdditionalEditionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook2);
                                        System.out.println("Author signature addition edition limited collection psychological book sent");

                                        features.removeAll(features);
                                        features.add("Limited Collection");
                                        features.add("Additional Edition");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new LimitedCollectionBook(new AdditionalEditionBook(new SignatureBook(new PsychologicalBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
                                        System.out.println("Author signature psychological book sent");

                                        features.removeAll(features);
                                        features.add("Signature Author");
                                        features.add("");
                                        features.add("");
                                        db.InsertIntoBooksTable(name, price, features);
                                        return new SignatureBook(new PsychologicalBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
                                break;
                        }

//                                        all_collections.get(all_collections.size() - 1).collection.add(new PsychologicalBook(temp_item_name, temp_item_price));
                        break;
                    case 2:
                        bookFeatures = 0;

                        while (true) {
                            System.out.println("Choose features of book: ");
                            System.out.println("1) No features");
                            System.out.println("2) Additional edition");
                            System.out.println("3) Limited edition");
                            System.out.println("4) Signature author");
                            System.out.print("Your choice: ");

                            bookFeatures = input.nextInt();

                            if (bookFeatures > 0 && bookFeatures < 5) {
                                break;
                            } else {
                                System.out.println("Error, something went wrong");
                                System.out.println("Try again");
                            }
                        }
//                        RomanceBook romanceBook = new RomanceBook(temp_item_name, temp_item_price);

//                                        LuxuryCar car = new LuxuryCar(new BasicCar(temp_item_name, temp_item_price));

                        switch (bookFeatures) {
                            case 1:
//                                all_collections.get(all_collections.size() - 1).collection.add(romanceBook);
                                System.out.println("Romance book sent");
                                return new RomanceBook(name, price);
//                                break;
                            case 2:
//                                AdditionalEditionBook additionalEditionBook = new AdditionalEditionBook(romanceBook);
                                System.out.println("Add 1) Limited edition or 2) Signature author?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(additionalEditionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
                                        System.out.println("Limited collection additional edition romance book sent");
                                        return new LimitedCollectionBook(new AdditionalEditionBook(new RomanceBook(name, price)));
//                                        break;
                                    case 2:
//                                        SignatureBook tempSignatureBook = new SignatureBook(additionalEditionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
                                        System.out.println("Author signature additional edition romance book sent");
                                        return new SignatureBook(new AdditionalEditionBook(new RomanceBook(name, price)));
//                                        break;
                                    case 3:
//                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(additionalEditionBook);
//                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempLimitedCollectionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
                                        System.out.println("Author signature limited collection additional edition romance book sent");
                                        return new SignatureBook(new LimitedCollectionBook(new AdditionalEditionBook(new RomanceBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
                                        System.out.println("Additional edition romance book sent");
                                        return new AdditionalEditionBook(new RomanceBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
                                break;
                            case 3:
//                                LimitedCollectionBook limitedCollectionBook = new LimitedCollectionBook(romanceBook);
                                System.out.println("Add 1) Additional Edition or 2) Signature author?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(limitedCollectionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
                                        System.out.println("Additional edition limited collection romance book sent");
                                        return new AdditionalEditionBook(new LimitedCollectionBook(new RomanceBook(name, price)));
//                                        break;
                                    case 2:
//                                        SignatureBook tempSignatureBook = new SignatureBook(limitedCollectionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
                                        System.out.println("Author signature limited collection romance book sent");
                                        return new SignatureBook(new LimitedCollectionBook(new RomanceBook(name, price)));
//                                        break;
                                    case 3:
//                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(limitedCollectionBook);
//                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempAdditionalEditionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
                                        System.out.println("Author signature additional edition limited collection romance book sent");
                                        return new SignatureBook(new AdditionalEditionBook(new LimitedCollectionBook(new RomanceBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
                                        System.out.println("Limited collection romance book sent");
                                        return new LimitedCollectionBook(new RomanceBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
                                break;
                            case 4:
//                                SignatureBook signatureBook = new SignatureBook(romanceBook);
                                System.out.println("Add 1) Additional Edition or 2) Limited Collection?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(signatureBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
                                        System.out.println("Additional edition author signature romance book sent");
                                        return new AdditionalEditionBook(new SignatureBook(new RomanceBook(name, price)));
//                                        break;
                                    case 2:
//                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(signatureBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
                                        System.out.println("Limited collection author signature romance book sent");
                                        return new LimitedCollectionBook(new SignatureBook(new RomanceBook(name, price)));
//                                        break;
                                    case 3:
//                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(signatureBook);
//                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(tempAdditionalEditionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook2);
                                        System.out.println("Limited collection additional edition author signature romance book sent");
                                        return new LimitedCollectionBook(new AdditionalEditionBook(new SignatureBook(new RomanceBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
                                        System.out.println("Author signature romance book sent");
                                        return new SignatureBook(new RomanceBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
                                break;
                        }

//                                        all_collections.get(all_collections.size() - 1).collection.add(new RomanceBook(temp_item_name, temp_item_price));
                        break;
                    case 3:
                        bookFeatures = 0;

                        while (true) {
                            System.out.println("Choose features of book: ");
                            System.out.println("1) No features");
                            System.out.println("2) Additional edition");
                            System.out.println("3) Limited edition");
                            System.out.println("4) Signature author");
                            System.out.print("Your choice: ");

                            bookFeatures = input.nextInt();

                            if (bookFeatures > 0 && bookFeatures < 5) {
                                break;
                            } else {
                                System.out.println("Error, something went wrong");
                                System.out.println("Try again");
                            }
                        }
//                        SciFiBook sciFiBook = new SciFiBook(temp_item_name, temp_item_price);

                        switch (bookFeatures) {
                            case 1:
//                                all_collections.get(all_collections.size() - 1).collection.add(sciFiBook);
                                System.out.println("Scientific book sent");
                                return new SciFiBook(name, price);
//                                break;
                            case 2:
//                                AdditionalEditionBook additionalEditionBook = new AdditionalEditionBook(sciFiBook);
                                System.out.println("Add 1) Limited edition or 2) Signature author?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(additionalEditionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
                                        System.out.println("Limited collection additional edition Scientific book sent");
                                        return new LimitedCollectionBook(new AdditionalEditionBook(new SciFiBook(name, price)));
//                                        break;
                                    case 2:
//                                        SignatureBook tempSignatureBook = new SignatureBook(additionalEditionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
                                        System.out.println("Author signature additional edition Scientific book sent");
                                        return new SignatureBook(new AdditionalEditionBook(new SciFiBook(name, price)));
//                                        break;
                                    case 3:
//                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(additionalEditionBook);
//                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempLimitedCollectionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
                                        System.out.println("Author signature limited collection additional edition Scientific book sent");
                                        return new SignatureBook(new LimitedCollectionBook(new AdditionalEditionBook(new SciFiBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
                                        System.out.println("Additional edition Scientific book sent");
                                        return new AdditionalEditionBook(new SciFiBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(additionalEditionBook);
                                break;
                            case 3:
//                                LimitedCollectionBook limitedCollectionBook = new LimitedCollectionBook(sciFiBook);
                                System.out.println("Add 1) Additional Edition or 2) Signature author?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(limitedCollectionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
                                        System.out.println("Additional edition limited collection Scientific book sent");
                                        return new AdditionalEditionBook(new LimitedCollectionBook(new SciFiBook(name, price)));
//                                        break;
                                    case 2:
//                                        SignatureBook tempSignatureBook = new SignatureBook(limitedCollectionBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook);
                                        System.out.println("Author signature limited collection Scientific book sent");
                                        return new SignatureBook(new LimitedCollectionBook(new SciFiBook(name, price)));
//                                        break;
                                    case 3:
//                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(limitedCollectionBook);
//                                        SignatureBook tempSignatureBook2 = new SignatureBook(tempAdditionalEditionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempSignatureBook2);
                                        System.out.println("Author signature additional edition limited collection Scientific book sent");
                                        return new SignatureBook(new AdditionalEditionBook(new LimitedCollectionBook(new SciFiBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
                                        System.out.println("Limited collection Scientific book sent");
                                        return new LimitedCollectionBook(new SciFiBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(limitedCollectionBook);
                                break;
                            case 4:
//                                SignatureBook signatureBook = new SignatureBook(sciFiBook);
                                System.out.println("Add 1) Additional Edition or 2) Limited Collection?");
                                System.out.println("Or 3) both?");
                                System.out.println("4) Or don't add anything yet?");
                                System.out.print("Enter your choice(1-4): ");

                                moreBookFeatures = input.nextInt();

                                switch (moreBookFeatures) {
                                    case 1:
//                                        AdditionalEditionBook tempAdditionalEditionBook = new AdditionalEditionBook(signatureBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempAdditionalEditionBook);
                                        System.out.println("Additional edition author signature Scientific book sent");
                                        return new AdditionalEditionBook(new SignatureBook(new SciFiBook(name, price)));
//                                        break;
                                    case 2:
//                                        LimitedCollectionBook tempLimitedCollectionBook = new LimitedCollectionBook(signatureBook);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook);
                                        System.out.println("Limited collection author signature Scientific book sent");
                                        return new LimitedCollectionBook(new SignatureBook(new SciFiBook(name, price)));
//                                        break;
                                    case 3:
//                                        AdditionalEditionBook tempAdditionalEditionBook2 = new AdditionalEditionBook(signatureBook);
//                                        LimitedCollectionBook tempLimitedCollectionBook2 = new LimitedCollectionBook(tempAdditionalEditionBook2);
//                                        all_collections.get(all_collections.size() - 1).collection.add(tempLimitedCollectionBook2);
                                        System.out.println("Limited collection additional edition author signature Scientific book sent");
                                        return new LimitedCollectionBook(new AdditionalEditionBook(new SignatureBook(new SciFiBook(name, price))));
//                                        break;
                                    case 4:
//                                        all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
                                        System.out.println("Author signature Scientific book sent");
                                        return new SignatureBook(new SciFiBook(name, price));
//                                        break;
                                }

//                                                all_collections.get(all_collections.size() - 1).collection.add(signatureBook);
                                break;
                        }
                        break;

                }
//                                all_collections.get(all_collections.size() + 1).collection.add(new Book(temp_item_name, temp_item_price));
                break;


//                switch (bookType) {
//                    case 1:
//                        return new PsychologicalBook(name, price);
//                        break;
//                    case 2:
//                        System.out.println("Add 1) Limited edition or 2) Signature author?");
//                        System.out.println("Or 3) both?");
//                        System.out.println("4) Or don't add anything yet?");
//                        System.out.print("Enter your choice(1-4): ");
//
//                        moreBookFeatures = input.nextInt();
//
//                        switch (moreBookFeatures) {
//                            case 1:
//                                return new LimitedCollectionBook(new AdditionalEditionBook(new PsychologicalBook(name, price)));
//                                break;
//                            case 2:
//                                return new SignatureBook(new AdditionalEditionBook(new PsychologicalBook(name, price)));
//                                break;
//                            case 3:
//
//                        }
//
//                }

        }
        db.close();
        return null;
    }
}
