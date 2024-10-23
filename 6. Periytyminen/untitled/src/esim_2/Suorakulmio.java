package esim_2;

public class Suorakulmio extends Kuvio {

    private double korkeus, leveys;

    public Suorakulmio(double x, double y, String teksti, double korkeus, double leveys) {
        super(x, y, teksti);
        this.korkeus = korkeus;
        this.leveys = leveys;
    }

    @Override
    public String toString() {
        return "Suorakulmio{" +
                "korkeus=" + korkeus +
                ", leveys=" + leveys +
                '}';
    }


    @Override
    public double ala() {
        return korkeus * leveys;
    }
}
