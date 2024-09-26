public class Maksukortti {
    private String omistaja;
    private double saldo;
    double edullinenLounas = 2.95;
    double maukasLounas = 6.90;

    public Maksukortti(String omistaja, double saldo) {
        this.omistaja = omistaja;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Kortin omistaja: " + omistaja + ", kortilla on saldoa: " + saldo + " euroa.";
    }

    public void syoEdullisesti() {
        if (saldo >= edullinenLounas) {
            saldo -= edullinenLounas;
        } else {
            System.out.println("Edullista lounasta ei voi myydä, kortilla ei ole riittävästi saldoa.");
        }
    }

    public void syoMaukkaasti() {
        if (saldo >= maukasLounas) {
            saldo -= maukasLounas;
        } else {
            System.out.println("Maukasta lounasta ei voi myydä, kortilla ei ole riittävästi saldoa.");
        }
    }

    public void lataaRahaa(int lataus) {
        if (lataus > 0) {
            saldo += lataus;
        } else {
            System.out.println("Virhe. Lataa yli 0 euroa.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

}
