package Entities.Books;

import Entities.Book;

public class RomanceBook extends Book {
    @Override
    public String getVoucher() {
        return "The cost of romance book: 80";
    }

    @Override
    public double getPrice() {
        return 80;
    }
}
