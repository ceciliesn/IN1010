public class LegemiddelC extends Legemiddel {
  public int styrke;

  public LegemiddelC (String navn, double pris, double virkestoff){
    super(navn, pris, virkestoff);
  }

  public int hentStyrke(){
    return styrke;
  }
}
