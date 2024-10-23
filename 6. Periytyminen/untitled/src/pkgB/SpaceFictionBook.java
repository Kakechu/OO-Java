package pkgB;

public class SpaceFictionBook extends FictionBook {

    @Override
    public void doThings() {
        read(); // different package, via inheritance - ok;
//        new Book().read();
//        new FictionBook().read();
        new SpaceFictionBook().read(); //ok
    }
}
