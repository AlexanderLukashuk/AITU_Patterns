package Entities.Books;

import Entities.Book;

public class SciFiBook extends Book {
    @Override
    public String getVoucher() {
        return "The cost of sci-fi book: 100";
    }

    @Override
    public double getPrice() {
        return 100;
    }
}
