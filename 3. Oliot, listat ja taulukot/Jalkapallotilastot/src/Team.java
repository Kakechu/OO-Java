public class Team {
    private String nimi;
    private int voitot;
    private int tappiot;
    private int tasapelit;

    public Team(String nimi) {
        this.nimi = nimi;
        this.voitot = 0;
        this.tappiot = 0;
        this.tasapelit = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public int getVoitot() {
        return voitot;
    }

    public void setVoitot(int voitot) {
        this.voitot = voitot;
    }

    public int getTappiot() {
        return tappiot;
    }

    public void setTappiot(int tappiot) {
        this.tappiot = tappiot;
    }

    public int getTasapelit() {
        return tasapelit;
    }

    public void setTasapelit(int tasapelit) {
        this.tasapelit = tasapelit;
    }

    @Override
    public String toString() {
        return "Joukkueen nimi: " + nimi + "\n" +
                "voitot: " + voitot + "\n" +
                "tappiot: " + tappiot + "\n" +
                "tasapelit: " + tasapelit;
    }
}
