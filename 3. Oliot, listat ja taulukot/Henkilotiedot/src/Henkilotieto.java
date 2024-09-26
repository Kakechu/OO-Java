public class Henkilotieto {
    private String etunimi;
    private String sukunimi;
    private int ika;
    private String ammatti;

    public Henkilotieto(String etunimi, String sukunimi, int ika, String ammatti) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
        this.ammatti = ammatti;
    }


    public String getEtunimi() {
        return this.etunimi;
    }

    public void setEtunimi() {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }

    public String getAmmatti() {
        return this.ammatti;
    }

    public void setAmmatti(String ammatti) {
        this.ammatti = ammatti;
    }

    @Override
    public String toString() {
        return "Etu- ja sukunimi: " + this.etunimi + " " + this.sukunimi  + "\n" +
                "Ikä: " + this.ika + "\n" +
                "Ammatti: " + this.ammatti + "\n";



    }
}
