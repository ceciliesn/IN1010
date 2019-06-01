public class Fastlege extends Lege implements Kommuneavtale{
  private String navn;
  private int avtaleNummer;

  public Fastlege (String navn, int avtaleNummer){
    super(navn);
    this.avtaleNummer = avtaleNummer;
    }

  public int hentAvtaleNummer(){
    return avtaleNummer;
  }

  public String toString(){
    String
    s1 = super.toString(),
    s2 = " - Avtalenummer: " + this.avtaleNummer;

    return s1 + s2;
  }

}
