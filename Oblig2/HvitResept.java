public class HvitResept extends Resept{

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }

  public double prisAaBetale(){
    double pris = hentLegemiddel().hentPris();
    return pris;
  }

  public String farge(){
    String reseptfarge = "Hvit";
    return reseptfarge;
  }
}
