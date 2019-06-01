import java.util.ArrayList;

public class Pasient {
  private static int pasId = 0;
  private String pasientNavn;
  private String fnr;
  private int pasientID;
  private Stabel<Resept> pasientResepter;


  public Pasient(String pasientNavn, String fnr) {
    this.pasientNavn = pasientNavn;
    this.fnr = fnr;
    pasId++;
    this.pasientID = pasId;
    pasientResepter = new Stabel<>();
  }

  //metoden legger til nye resepter
  public void leggTilResept(Resept resept) {
    pasientResepter.leggTil(resept);
  }

  //henter ut hele reseptlisten
  public Stabel<Resept> hentUtResepter() {
    return pasientResepter;
  }

  public String hentPasientNavn(){
    return pasientNavn;
  }

  public String hentFnr(){
    return fnr;
  }

  public int hentPasientID(){
    return pasientID;
  }

  public String toString(){
    return pasientNavn + "\n" + "Fødselsnummer: " + fnr + "\n" + "Pasient ID: " + pasientID;
  }

}
