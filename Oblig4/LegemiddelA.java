public class LegemiddelA extends Legemiddel {
  private int styrke;

  public LegemiddelA (String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentStyrke(){
    return styrke;
  }

  public String toString(){
    String
    s1 = super.toString(),
    s2 = "Narkotisk styrke: " + this.styrke;

    return s1 + "\n" + s2;
}
}
