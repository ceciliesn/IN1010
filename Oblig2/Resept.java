public abstract class Resept {
  private int pasientId;
  private int reit;
  private static int idTeller;
  private int reseptId;
  private Legemiddel legemiddel;
  private Lege utskrivendeLege;

  public Resept (Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasientId = pasientId;
    this.reit = reit;
    reseptId = idTeller ++;
  }

  public int hentId() {
    return reseptId;
  }

  public Legemiddel hentLegemiddel(){
    return legemiddel;
  }

  public Lege hentLege(){
    return utskrivendeLege;
  }

  public int hentPasientId(){
    return pasientId;
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

}
