package lecture5;

public class BasicEncapsulationExample {
    public static void main(String[] args) {
        Adult john = new Adult("John", 20);
        System.out.println(john.getName() + " " + john.getAge());
        john.setAge(-99);
        System.out.println(john.getName() + " " + john.getAge());
    }

}
