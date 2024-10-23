package esim_2;

public class Kolmio extends Kuvio {
    private double kanta, korkeus;

    public Kolmio(double x, double y, String teksti, double kanta, double korkeus) {
        super(x, y, teksti);
        this.kanta = kanta;
        this.korkeus = korkeus;
    }

    @Override
    public String toString() {
        return "Kolmio{" +
                "kanta=" + kanta +
                ", korkeus=" + korkeus +
                '}';
    }

    @Override
    public double ala() {
        return (this.kanta * this.korkeus) / 2;
    }
}
