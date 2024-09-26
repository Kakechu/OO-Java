public class Game {
    private String kotijoukkue;
    private String vierasjoukkue;
    private int kotipisteet;
    private int vieraspisteet;

    public Game(String kotijoukkue, String vierasjoukkue, int kotipisteet, int vieraspisteet) {
        this.kotijoukkue = kotijoukkue;
        this.vierasjoukkue = vierasjoukkue;
        this.kotipisteet = kotipisteet;
        this.vieraspisteet = vieraspisteet;
    }

    public String getKotijoukkue() {
        return kotijoukkue;
    }

    public void setKotijoukkue(String kotijoukkue) {
        this.kotijoukkue = kotijoukkue;
    }

    public String getVierasjoukkue() {
        return vierasjoukkue;
    }

    public void setVierasjoukkue(String vierasjoukkue) {
        this.vierasjoukkue = vierasjoukkue;
    }

    public int getKotipisteet() {
        return kotipisteet;
    }

    public void setKotipisteet(int kotipisteet) {
        this.kotipisteet = kotipisteet;
    }

    public int getVieraspisteet() {
        return vieraspisteet;
    }

    public void setVieraspisteet(int vieraspisteet) {
        this.vieraspisteet = vieraspisteet;
    }

    @Override
    public String toString() {
        return "Game{" +
                "kotijoukkue='" + kotijoukkue + '\'' +
                ", vierasjoukkue='" + vierasjoukkue + '\'' +
                ", kotipisteet=" + kotipisteet +
                ", vieraspisteet=" + vieraspisteet +
                '}';
    }
}
