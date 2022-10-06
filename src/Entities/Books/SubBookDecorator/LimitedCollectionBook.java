package Entities.Books.SubBookDecorator;

import Decorator.BookDecorator;
import Entities.Book;

public class LimitedCollectionBook extends BookDecorator {
    public LimitedCollectionBook(Book book){
        super(book);
//        this.book = book;
    }

    @Override
    public double getPrice() {
        return book.getPrice() + 120;
    }

    @Override
    public String getVoucher() {
        return book.getVoucher()+", limited collection cost (120)";
    }
}
