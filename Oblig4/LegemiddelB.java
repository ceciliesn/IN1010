public class LegemiddelB extends Legemiddel {
  private int styrke;

  public LegemiddelB (String navn, double pris, double virkestoff, int styrke){
    super(navn, pris, virkestoff);
    this.styrke = styrke;
  }

  public int hentStyrke(){
    return styrke;
  }

  public String toString(){
    String
    s1 = super.toString(),
    s2 = "Vanedannende styrke: " + this.styrke;

    return s1 + "\n" + s2;
  }
}
