package Entities.Books.SubBookDecorator;

import Decorator.BookDecorator;
import Entities.Book;

public class AdditionalEditionBook extends BookDecorator {
    public AdditionalEditionBook(Book iBook) {
//        this.iBook = iBook;
        super(iBook);
    }

    @Override
    public String getVoucher() {
        return iBook.getVoucher()+", Additional edition for this book (30.56)";
    }

    @Override
    public double getPrice() {
        return iBook.getPrice() + 30.56;
    }
}
