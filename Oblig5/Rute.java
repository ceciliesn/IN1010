public abstract class Rute {
  protected int kolonnePlass;
  protected int radPlass;

  protected Labyrint labyrint;
  protected Rute naboNord;
  protected Rute naboSoer;
  protected Rute naboVest;
  protected Rute naboOest;

  public Rute(int kolonnePlass, int radPlass, Labyrint rutesLabyrint) {
    this.kolonnePlass = kolonnePlass;
    this.radPlass = radPlass;
    this.labyrint = rutesLabyrint;
  }

  public void settRutesNaboer(Rute naboNord, Rute naboSoer, Rute naboOest, Rute naboVest) {
    this.naboNord = naboNord;
    this.naboSoer = naboSoer;
    this.naboOest = naboOest;
    this.naboVest = naboVest;
  }

  public void gaa(Rute forrigeRute, String utvei) {
    // Utskrift brukt til debugging. Kan skrus av.
    if (this.labyrint.detaljertUtskrift()){
      System.out.println("Rad: " + radPlass + " Kolonne: " + kolonnePlass);
    }
    sjekkNabo(this.naboNord, forrigeRute, utvei);
    sjekkNabo(this.naboOest, forrigeRute, utvei);
    sjekkNabo(this.naboVest, forrigeRute, utvei);
    sjekkNabo(this.naboSoer, forrigeRute, utvei);
  }

  // Sjekker om naborute finnes og ikke er samme som ruten den kom fra og kaller gaa.
  private void sjekkNabo(Rute naboRute, Rute forrigeRute, String utvei) {
    if (naboRute == null) {
      return;
    }
    if (naboRute == forrigeRute) {
      return;
    }
    String utvei2 = "(" + kolonnePlass + "," + radPlass + ")";
    if (utvei.length() > 0) {
      utvei2 = utvei + " --> " + utvei2;
    }
    naboRute.gaa(this, utvei2);
  }


  //finner alle utveier fra ruten ved hjelp av kall på gaa
  public void finnUtvei() {
    this.gaa(this, "");
  }

  //returnerer rutens tegnrepresentasjon
  abstract public char tilTegn();

}
