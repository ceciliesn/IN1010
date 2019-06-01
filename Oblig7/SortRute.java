public class SortRute extends Rute {

  public SortRute(int kolonnePlass, int radPlass, Labyrint labyrint) {
    super(kolonnePlass, radPlass, labyrint);
  }

  @Override
  public char tilTegn() {
    return '#';
  }

  @Override
  public void gaa(Rute forrige, String utvei) {
    if (labyrint.detaljertUtskrift() == true) {
      System.out.println("Svar rute - Rad: " + radPlass + " Kolonne: " + kolonnePlass);
    }
    return;
  }

}
