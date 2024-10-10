package lecture5.recordperson;

import org.w3c.dom.ls.LSOutput;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("Joe Bloggs", 20);
        System.out.println(p1);
        System.out.println(p1.name());
        System.out.println(p1.age());

        Person p2 = new Person("Vincent Bloggs", 15);
        System.out.println(p2);
        System.out.println(p2.name());
        System.out.println(p2.age());

    }


}
