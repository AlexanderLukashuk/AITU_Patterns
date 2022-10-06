package Decorator;

import Entities.Book;

public abstract class BookDecorator extends Book {

    protected Book iBook;

    public BookDecorator(Book iBook) {
        super(iBook);
    }

    @Override
    public String getVoucher() {
        return "Features:";
    }
}
