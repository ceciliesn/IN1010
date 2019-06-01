public class Melding implements Comparable <Melding> {

  private String tekst;
  private int sekvensnummer;
  private int kanalId;

  public Melding(String tekst, int sekvensnummer, int kanalId) {
    this.tekst = tekst;
    this.sekvensnummer = sekvensnummer;
    this.kanalId = kanalId;
  }

  public String hentTekst() {
    return this.tekst;
  }

  public int hentKanalId() {
    return this.kanalId;
  }

  public int hentSekvensnummer() {
    return this.sekvensnummer;
  }

  public void dekrypter() {
      tekst = Kryptografi.dekrypter(tekst);
  }

  //lager metode for å sortere meldingene
  @Override
  public int compareTo(Melding annen) {
    return this.hentSekvensnummer() - annen.hentSekvensnummer();
  }

}
