public class MilitaerResept extends HvitResept{
  private int pris = 0;

  public MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  public double prisAaBetale(){
    return pris;
  }

}
