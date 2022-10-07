package Entities.Books.SubBookDecorator;

import Decorator.BookDecorator;
import Entities.Book;

public class LimitedCollectionBook extends BookDecorator {
    public LimitedCollectionBook(Book book){
        super(book);
//        this.book = book;
        setPrice();
    }

    @Override
    public int getPrice() {
        return book.getPrice() + 120;
    }

    @Override
    public String getVoucher() {
        return this.GetPrice()+", limited collection cost (120)";
    }

    @Override
    public void setPrice() {
        this.Price += 25;
    }
}
