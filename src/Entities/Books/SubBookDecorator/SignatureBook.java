package Entities.Books.SubBookDecorator;

import Decorator.BookDecorator;
import Entities.Book;

public class SignatureBook extends BookDecorator {

    public SignatureBook(Book iBook){
        super(iBook);
    }

    @Override
    public String getVoucher() {
        return iBook.getVoucher()+", signature of author (20.8)";
    }


    @Override
    public double getPrice() {
        return iBook.getPrice() + 20.8;
    }
}
