public class Fastlege extends Lege implements Kommuneavtale{
  private int avtaleNummer;

  public Fastlege (String navn, int avtaleNummer){
    super(navn);
    this.avtaleNummer = avtaleNummer;
  }

  public int hentAvtaleNummer(){
    return avtaleNummer;
  }
}
