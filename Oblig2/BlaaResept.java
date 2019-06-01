public class BlaaResept extends Resept{

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }

  public double prisAaBetale(){
    double pris;
    pris = 0.25*(hentLegemiddel().hentPris());
    return pris;
  }

  public String farge(){
    String reseptfarge = "Blaa";
    return reseptfarge;
  }
}
