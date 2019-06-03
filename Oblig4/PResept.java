public class PResept extends HvitResept{
  private int reit;
  private double pris;

  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, 3);
  }

  public double prisAaBetale(){
    pris = hentLegemiddel().hentPris();
    if (pris >= 116){
      return pris - 116;
    }
    return pris;
  }
}
