public abstract class Resept {
  private int reit;
  private int id;
  private static int reseptId = -1;
  private Legemiddel legemiddel;
  private Lege lege;
  private Pasient pasient;

  public Resept (Legemiddel legemiddel, Lege lege, Pasient pasient, int reit){
    this.legemiddel = legemiddel;
    this.lege = lege;
    reseptId++;
    this.id = reseptId;
    this.pasient = pasient;
    this.reit = reit;
  }

  public int hentId() {
    return id;
  }

  public Legemiddel hentLegemiddel(){
    return legemiddel;
  }

  public Lege hentLege(){
    return lege;
  }

  public Pasient hentPasient(){
    return pasient;
  }

  public int hentReit(){
    return reit;
  }

  public boolean bruk(){
    if (reit >= 1){
      reit--;
      return true;
      }
    return false;
    }

  abstract public String farge();

  abstract public double prisAaBetale();

  public String toString(){
    String
      s0 = "Resept ID: " + this.id,
      s1 = "Kunde: " + this.pasient,
      s2 = this.legemiddel.toString(),
      s3 = " Utskrivende lege: " + this.lege,
      s4 = "Reit: " + this.reit;

    return s0 + "\n" + s1 + "\n" + s2 + s3 + "\n" + s4;
  }

}
