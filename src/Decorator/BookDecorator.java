package Decorator;

import Entities.Book;

public abstract class BookDecorator extends Book {

    protected Book book;

    public BookDecorator(Book book) {
        super(book);
    }

    @Override
    public String getVoucher() {
        return "Features:";
    }
}
