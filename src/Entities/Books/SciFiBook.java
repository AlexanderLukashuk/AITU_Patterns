package Entities.Books;

import Entities.Book;

public class SciFiBook extends Book {

    public SciFiBook(String name, int price) {
        super(name, price);
    }

    @Override
    public String getVoucher() {
        return "The cost of sci-fi book: 100";
    }

    @Override
    public int getPrice() {
        return Price;
    }
}
