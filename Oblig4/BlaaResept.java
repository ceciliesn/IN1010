public class BlaaResept extends Resept{
  private String reseptfarge = "Blaa";
  private double pris;

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  public double prisAaBetale(){
    pris = 0.25*(hentLegemiddel().hentPris());
    return pris;
  }

  public String farge(){
    return this.reseptfarge;
  }

  public String toString(){
    String
    s1 = super.toString(),
    s2 = "Reseptfarge: " + this.reseptfarge;

    return s1 + "\n" + s2;
  }
}
