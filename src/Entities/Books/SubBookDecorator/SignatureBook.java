package Entities.Books.SubBookDecorator;

import Decorator.BookDecorator;
import Entities.Book;

public class SignatureBook extends BookDecorator {

    public SignatureBook(Book book){
        super(book);
    }

    @Override
    public String getVoucher() {
        return book.getVoucher()+", signature of author (20.8)";
    }


    @Override
    public double getPrice() {
        return book.getPrice() + 20.8;
    }
}
