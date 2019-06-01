public class PResept extends HvitResept{

  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, 3);
  }

  public double prisAaBetale(){
    double pris = hentLegemiddel().hentPris();
    if (pris >= 116){
      return pris - 116;
      }
    return pris;
  }
}
