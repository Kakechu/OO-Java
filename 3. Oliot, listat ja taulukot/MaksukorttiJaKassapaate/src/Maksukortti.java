public class Maksukortti {
    private double saldo;


    public Maksukortti(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Kortilla on saldoa: " + saldo + " euroa.";
    }


    public void lataaRahaa(double lataus) {
        if (lataus > 0) {
            this.saldo += lataus;
        } else {
            System.out.println("Virhe. Lataa yli 0 euroa.");
        }
    }



    public double getSaldo() {
        return saldo;
    }

    public void maksa(double maksu) {
        if (this.saldo >= maksu) {
            this.saldo -= maksu;
        } else {
            System.out.println("Kortilla ei ole tarpeeksi rahaa.");
        }
    }

}
