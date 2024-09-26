public class Kassapaate {
    private double rahaa; //käteisen määrä kassassa
    private int edulliset; //myytyjen edullisten lounaiden määrä
    private int maukkaat; //myytyjen maukkaiden lounaiden määrä
    private double edullisenHinta;
    private double maukkaanHinta;

    public Kassapaate() {
        this.rahaa = 100;
        this.edulliset = 0;
        this.maukkaat = 0;
        this.edullisenHinta = 2.95;
        this.maukkaanHinta = 6.9;

    }

    public double syoEdullisesti(double maksu) {

        if (maksu >= edullisenHinta) {
            this.rahaa += edullisenHinta;
            this.edulliset++;
            return maksu - edullisenHinta;
        } else {
            System.out.println("Maksu ei ole riittävän suuri.");
            return maksu;
        }
    }

    public boolean syoEdullisesti(Maksukortti m) {

        if (m.getSaldo() >= this.edullisenHinta) {
            m.maksa(this.edullisenHinta);
            this.edulliset++;
            return true;
        } else {
            return false;
        }
    }

    public double syoMaukkaasti(double maksu) {

        if (maksu >= maukkaanHinta) {
            this.rahaa += maukkaanHinta;
            this.maukkaat++;
            return maksu - maukkaanHinta;
        } else {
            System.out.println("Maksu ei ole riittävän suuri.");
            return maksu;
        }
    }

    public boolean syoMaukkaasti(Maksukortti m) {

        if (m.getSaldo() >= this.maukkaanHinta) {
            m.maksa(this.maukkaanHinta);
            this.maukkaat++;
            return true;
        } else {
            return false;
        }
    }

    public void lataaRahaaKortille(Maksukortti m, double summa) {
        m.lataaRahaa(summa);
    }


    @Override
    public String toString() {
        return "Kassan saldo: " + rahaa + "\n" +
                "Edullisia lounaita myyty: " + edulliset + "\n" +
                "Maukkaita lounaita myyty: " + maukkaat;
    }
}
