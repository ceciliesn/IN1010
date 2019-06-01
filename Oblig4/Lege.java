import java.util.Iterator;

public class Lege implements Comparable<Lege> {
  private String legeNavn;
  private Lenkeliste<Resept> legeResepter;

  public Lege(String legeNavn){
    this.legeNavn = legeNavn;
    legeResepter = new Lenkeliste<Resept>();
  }

  public String hentLegeNavn(){
    return legeNavn;
  }

  public int compareTo(Lege lege){
    return this.legeNavn.compareTo(lege.legeNavn);
  }

  public void leggTil(Resept resept){
    legeResepter.leggTil(resept);
  }

  public Lenkeliste<Resept> hentResepter(){
    return legeResepter;
  }

public String toString(){
    return this.legeNavn;
  }

}
