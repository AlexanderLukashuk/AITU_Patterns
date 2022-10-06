package Entities.Books.SubBookDecorator;

import Decorator.BookDecorator;
import Entities.Book;

public class AdditionalEditionBook extends BookDecorator {
    public AdditionalEditionBook(Book book) {
//        this.iBook = iBook;
        super(book);
    }

    @Override
    public String getVoucher() {
        return book.getVoucher()+", Additional edition for this book (30.56)";
    }

    @Override
    public double getPrice() {
        return book.getPrice() + 30.56;
    }
}
