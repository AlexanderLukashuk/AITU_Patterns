package Entities.Books;

import Entities.Book;

public class PsychologicalBook extends Book {

    @Override
    public String getVoucher() {
        return "The cost of psychological book: 70";
    }

    @Override
    public double getPrice() {
        return 70;
    }
}
