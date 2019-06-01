public class Aapning extends HvitRute {

  public Aapning(int kolonnePlass, int radPlass, Labyrint labyrint) {
       super(kolonnePlass, radPlass, labyrint);
  }

  @Override
  public void gaa(Rute forrigeRute, String utvei) {
    String utvei2 = utvei + " --> (" + kolonnePlass + "," + radPlass + ")";
    if (labyrint.detaljertUtskrift() == true){
      System.out.println ("Åpning - Kolonne: " + kolonnePlass + " Rad: " + radPlass);
      System.out.println(utvei2);
    }
    this.labyrint.utveier.leggTil(utvei2);
    return;
  }

}
