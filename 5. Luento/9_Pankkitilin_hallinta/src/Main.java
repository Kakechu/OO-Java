public class Main {
    public static void main(String[] args) {

        BankAccount tili = new BankAccount("123-345");

        /*
        System.out.println(tili);
        tili.talletus(50.0);
        tili.talletus(1245.3);
        tili.nosto(450);
        System.out.println(tili.getBalance());
        tili.nosto(1000);
        System.out.println(tili);

        BankAccount tili2 = new BankAccount(tili.getAccountNumber());
        System.out.println(tili2);


         */

        tili.talletus(500);
        tili.nosto(200);
        tili.nosto(400);
        tili.nosto(-100);
        tili.talletus(-400);


    }
}