import java.util.ArrayList;

public abstract class Legemiddel {
  private String navn;
  private double pris;
  private double virkestoff;
  private static int legemiddelId = -1; //settes til -1 da første obj. skal ha id 0
  private int id;


  public Legemiddel (String navn, double pris, double virkestoff) {
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    legemiddelId++;
    this.id = legemiddelId;
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

  public String toString(){
    String
    s1 = this.navn + ", Legemiddel ID: " + this.id,
    s2 = "Pris: " + this.pris,
    s3 = "Virkestoff: " + this.virkestoff;

    return s1 + "\n" + s2 + "\n" + s3;
  }

}
