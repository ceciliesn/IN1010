public abstract class Legemiddel {
  private String navn;
  private double pris;
  private double virkestoff;
  private static int idTeller;
  private int id;

  public Legemiddel (String navn, double pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    id = idTeller ++;
  }

  public int hentId() {
    return id;
  }

  public String hentNavn() {
    return navn;
  }

  public double hentPris() {
    return pris;
  }

  public double hentVirkestoff() {
    return virkestoff;
  }

  public void settNyPris(double nyPris){
    pris = nyPris;
  }

  //laget en felles metode for aa hente styrke
  abstract public int hentStyrke();

}
