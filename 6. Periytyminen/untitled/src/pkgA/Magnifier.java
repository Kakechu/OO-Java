package pkgA;

public class Magnifier {
    void magnify() {
        Book book = new Book();
        book.read(); // same package - ok
    }

}
