public class Luokkahuone {
    private String luokanKoodi;
    private int istumapaikat;
    private int varatutPaikat;

    //konstruktori
    public Luokkahuone(int istumapaikat) {
        this.istumapaikat = istumapaikat;
    }

    public void tulostaLuokkahuone() {
        System.out.println("Luokkahuoneen tiedot:");
        System.out.println("Tunnus: " + luokanKoodi + ", istumapaikkoja yhteensä: " + istumapaikat + ", vapaita paikkoja: " + (istumapaikat - varatutPaikat));
    }

    public void varaaPaikka() {
        if (istumapaikat > varatutPaikat) {
            varatutPaikat++;
        } else {
            System.out.println("Täynnä");
        }
    }

    public void poistuuPaikalta() {
        if (varatutPaikat > 0)  {
            varatutPaikat--;
        }
    }

    public boolean taynna() {
        if (varatutPaikat == istumapaikat) {
            return true;
        } else {
            return false;
        }
    }

    public void tulostaTilanne() {
        int paikkojaJaljella = istumapaikat - varatutPaikat;
        System.out.println("Paikkoja varattu: " + varatutPaikat + ". Luokassa on " + paikkojaJaljella + " paikkaa jäljellä.");
    }

    public void setLuokanKoodi(String luokanKoodi) {
        this.luokanKoodi = luokanKoodi;
    }

    public String getLuokanKoodi() {
        return luokanKoodi;
    }

    public void setIstumapaikat(int istumapaikat) {
        this.istumapaikat = istumapaikat;
    }
    public int getIstumapaikat() {
        return istumapaikat;
    }

    public int getVaratutPaikat() {
        return varatutPaikat;
    }
}
