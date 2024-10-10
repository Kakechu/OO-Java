public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void talletus(double summa) {
        if (summa > 0) { //tarkistetaan, että talletetaan positiivinen summa
            this.balance += summa;
        } else {
            System.out.println("Virhe: talleta yli 0 euroa.");
        }
    }

    public void nosto(double summa) {
        if (this.balance >= summa && summa > 0) {
            this.balance -= summa;
            System.out.println("Nostit onnistuneesti " + summa + " euroa, saldo on nyt " + this.balance + " euroa.");
        } else if (summa > this.balance) {
            System.out.println("Ei voi nostaa summaa " + summa + ", tilillä " + this.balance + " euroa.");
        }
        if (summa <0 ){
            System.out.println("Et voi nostaa negatiivista summaa.");
        }

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
