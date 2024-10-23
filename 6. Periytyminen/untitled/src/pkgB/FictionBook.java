package pkgB;

import pkgA.Book;

public class FictionBook extends Book {

    public void doThings() {
        read(); // different package, via inheritance - ok
        this.read(); // different package, via inheritance - ok

        FictionBook fictionBook = new FictionBook(); // default constructor created
        fictionBook.read(); // ok

        Book book = new Book();
//        book.read(); // not public

    }
}
