package Entities.Books.SubBookDecorator;

import Decorator.BookDecorator;
import Entities.Book;

public class LimitedCollectionBook extends BookDecorator {
    public LimitedCollectionBook(Book iBook){
        this.iBook = iBook;
    }

    @Override
    public double getPrice() {
        return iBook.getPrice() + 120;
    }

    @Override
    public String getVoucher() {
        return iBook.getVoucher()+", limited collection cost (120)";
    }
}
