import java.util.Scanner;

public class Legesystem{

  public SortertLenkeliste <Lege> leger = new SortertLenkeliste <Lege>();
  public Lenkeliste <Pasient> pasienter = new Lenkeliste <Pasient>();
  public Lenkeliste <Legemiddel> legemidler = new Lenkeliste <Legemiddel>();
  public Lenkeliste <Resept> resepter = new Lenkeliste <Resept>();

    public static void main(String[] args) {

      int valg = 0;
      int menyvalg = 0;

      Legesystem legesystem = new Legesystem();

      Scanner tastatur = new Scanner (System.in);
      while (valg != 5) {

      System.out.println("\n" + "***** LEGESYSTEM *****" + "\n" + "\n" + "Tast 1: Skriv ut fullstendig oversikt over personer, leger, legemidler og resepter" + "\n" + "Tast 2: Opprett og legg til nye elementer i systemet" + "\n" + "Tast 3: Bruk en gitt resept fra listen til en pasient" + "\n" + "Tast 4: Skriv ut statistikk" + "\n" + "Tast 5: Avslutt programmet" + "\n" + "\nVennligst tast inn ønsket alternativ:");

      valg = tastatur.nextInt();

      if (valg == 1){
        System.out.println("Du valgte alternativ 1");
        legesystem.skrivAllInfo();
      }
      //meny for å legge til nye objekter i systemet
      else if (valg == 2){
        menyvalg = 0;
        while (menyvalg != 5){
        System.out.println("\nTast 1: Legg til ny pasient" + "\nTast 2: Legg til ny lege" + "\nTast 3: Legg til nytt legemiddel" + "\nTast 4: Legg til ny resept" + "\nTast 5: Gå tilbake til hovedmeny");

        menyvalg = tastatur.nextInt();
          if (menyvalg == 1){
            legesystem.leggTilPasient();
          }
          else if (menyvalg == 2){
            legesystem.leggTilLege();
          }
          else if (menyvalg == 3){
            legesystem.leggTilLegemiddel();
          }
          else if (menyvalg == 4){
            legesystem.leggTilResept();
          }
          else if (menyvalg == 5){
            System.out.println("Returnerer til hovedmeny");
          }
          else {
            System.out.println("Ugyldig input");
          }
        }
      }

      else if (valg == 3){
        legesystem.brukResept();
      }
      else if (valg == 4){
        legesystem.skrivVanedannende();
        legesystem.skrivNarkoInfo();
      }
      else if (valg == 5){
        System.out.println("Programmet avsluttes");
      }
      else{
        System.out.println("Ugyldig input. Tast et tall mellom 1 og 6");
      }
    }
  }

  //skriver all info om narkotiske resepter
  public void skrivNarkoInfo(){
    System.out.println("\n- INFORMASJON OM NARKOTISKE RESEPTER -");
    skrivNarkotikaLeger();
    skrivNarkotikaPasienter();
  }

  public void skrivNarkotikaLeger(){
    System.out.println("\n- LEGER SOM HAR SKREVET UT RESEPT PÅ NARKOTISKE LEGEMIDLER -");
    int narkoTeller = 0;
    for (Lege l : leger){
      for (Resept r : l.hentResepter()){
        if (r.hentLegemiddel() instanceof LegemiddelA){
          narkoTeller++;
        System.out.println("\n" + l.hentLegeNavn() + " - Antall utskrevne narkoresepter: " + narkoTeller);
        }
      }
    }
  }

  //skriver info om pasienter med resepter på narkotiske legemidler
  public void skrivNarkotikaPasienter(){
    System.out.println("\n- PASIENTER SOM HAR MOTTATT RESEPT PÅ NARKOTISKE LEGEMIDLER -");
    int pasientNarko = 0;
    for (Pasient p : pasienter){
      for (Resept r : p.hentUtResepter()){
        if (r.hentLegemiddel() instanceof LegemiddelA){
          pasientNarko++;
          System.out.println("\n" + p.hentPasientNavn() + " - Antall resepter: " + pasientNarko);
        }
      }
    }
  }

  //metode for å skrive informasjon om vanedannende legemidler
  public void skrivVanedannende(){
    int antallVanedannende = 0;
    int antallMilitaer = 0;

    for (Resept r : resepter){
      if (r.hentLegemiddel() instanceof LegemiddelB){
        antallVanedannende++;
        if (r instanceof MilitaerResept){
          antallMilitaer++;
        }
      }
    }

    System.out.println("\n- INFORMASJON OM RESEPTER PÅ VANEDANNENDE MIDLER -" + "\n" + "\nAntall utskrevne resepter på vanedannende midler: " + antallVanedannende + "\n" + "\nAntall vanedannende resepter utskrevet til militære: " + antallMilitaer);
  }

  //metode for å skrive ut all informasjon i systemet
  public void skrivAllInfo(){
    System.out.println("\nLEGER:\n");
    for (Lege l : leger){
      System.out.println(l + "\n");
    }
    System.out.println("\nRESEPTER:\n");
    for (Resept r : resepter){
      System.out.println(r + "\n");
    }
    System.out.println("\nLEGEMIDLER:\n");
    for (Legemiddel lm : legemidler){
      System.out.println(lm + "\n");
    }
    System.out.println("\nPASIENTER:\n");
    for (Pasient p : pasienter){
      System.out.println(p + "\n");
    }
  }

  //legg lege inn i leger
  public void leggTil(Lege lege){
    leger.leggTil(lege);
  }
  //legg legemiddel inn i legemidler
  public void leggTil(Legemiddel legemiddel){
    legemidler.leggTil(legemiddel);
  }
  //legg inn pasient i pasienter
  public void leggTil(Pasient pasient){
    pasienter.leggTil(pasient);
  }
  //legg til resept i resepter
  public void leggTil(Resept resept){
    resepter.leggTil(resept);
  }

  //metode for å legge til ny pasient i systemet
  public void leggTilPasient(){
    String navn;
    String fdato;

    Scanner tastatur = new Scanner(System.in);
    System.out.println("Tast inn pasientnavn: ");
    navn = tastatur.nextLine();
    System.out.println("Tast inn fodselsnummer, 11 siffer: ");
    fdato = tastatur.nextLine();

    //sjekker at fødselsnummeret består av akkurat 11 siffer
    if ((fdato.length() > 11) || (fdato.length() < 11)){
      System.out.println("Ugyldig format. Fødselsnummer skal bestå av 11 siffer");
      return;
    }

    //sjekker om pasienten allerede finnes i systemet
    for (Pasient p : pasienter){
      if (fdato.equals(p.hentFnr())){
        System.err.println("Pasient finnes allerede i systemet");
        return;
      }
    }

    Pasient pasient = new Pasient(navn, fdato);
    pasienter.leggTil(pasient);

  }


  //lager metode for å sjekke om det finnes minst en lege, en resept og et legemiddel i systemet før resept opprettes
  public boolean reseptSjekk(){
    if ((pasienter.stoerrelse() == 0) && (leger.stoerrelse() == 0) && (legemidler.stoerrelse() == 0)){
      System.out.println("\nSystemet er tomt. Kan ikke opprette resept.");
      return false;
    }
    else if ((leger.stoerrelse() == 0) && (legemidler.stoerrelse() == 0)){
      System.out.println(("\nIngen leger eller legemidler i systemet. Kan ikke opprette resept."));
      return false;
    }
    else if ((leger.stoerrelse() == 0) && (pasienter.stoerrelse() == 0)){
      System.out.println(("\nIngen leger eller pasienter i systemet. Kan ikke opprette resept."));
      return false;
    }
    else if ((legemidler.stoerrelse() == 0) && (pasienter.stoerrelse() == 0)){
      System.out.println(("\nIngen legemidler eller pasienter i systemet. Kan ikke opprette resept."));
      return false;
    }
    else if (pasienter.stoerrelse() == 0){
      System.out.println(("\nIngen pasienter i systemet. Kan ikke opprette resept."));
      return false;
    }
    else if (leger.stoerrelse() == 0){
      System.out.println("\nIngen leger i systemet. Kan ikke opprette resept.");
      return false;
    }
    else if (legemidler.stoerrelse() == 0){
      System.out.println("\nIngen legemidler i systemet. Kan ikke opprette resept.");
      return false;
    }
    else{
      return true;
    }
  }

  //metode for å lage ny resept
  public void leggTilResept(){
    String legemiddelNavn;
    String legeNavn;
    String pasientNavn;
    int reit;
    int reseptfarge;
    int reseptType;

    //sjekker at det finnes nødvendige objekter for å opprette ny resept
    if (reseptSjekk() != false){

      Scanner tastatur = new Scanner(System.in);
      System.out.println("Tast inn legemiddel: ");
      legemiddelNavn = tastatur.nextLine();
      Legemiddel legemiddel = null;
      for (Legemiddel l : legemidler){
        if (legemiddelNavn.equals(l.hentNavn())){
          legemiddel = l;
          break;
          }
        }
      if (legemiddel == null){
      System.out.println("Legemiddel finnes ikke");
      return;
      }

      System.out.println("Tast inn lege: ");
      legeNavn = tastatur.nextLine();
      Lege lege = null;
      for (Lege l : leger){
        if (legeNavn.equals(l.hentLegeNavn())){
          lege = l;
          break;
        }
      }
      if (lege == null){
        System.out.println("Lege finnes ikke");
        return;
      }

      System.out.println("Tast inn pasientnavn: ");
      pasientNavn = tastatur.nextLine();
      Pasient pasient = null;
      for (Pasient p : pasienter){
        if (pasientNavn.equals(p.hentPasientNavn())){
          pasient = p;
          break;
        }
      }
      if (pasient == null){
        System.out.println("Pasient finnes ikke");
        return;
      }

      System.out.println("Tast inn antall reit: ");
      reit = tastatur.nextInt();

      System.out.println("Hvit resept - tast 1. Blå resept - tast 2");
      reseptfarge = tastatur.nextInt();
      if (reseptfarge == 1){
        System.out.println("Militærresept - tast 1. P-Resept - tast 2");
        reseptType = tastatur.nextInt();
        if (reseptType == 1){
          Resept resept = new MilitaerResept(legemiddel, lege, pasient, reit);
          resepter.leggTil(resept);
          pasient.leggTilResept(resept);
          lege.leggTil(resept);
        }
        else if (reseptType == 2){
          Resept resept = new PResept(legemiddel, lege, pasient, reit);
          resepter.leggTil(resept);
          pasient.leggTilResept(resept);
          lege.leggTil(resept);
        }
        else{
          System.out.println("Ugyldig input. Tast 1 for militærrresept eller 2 for P-Resept");
        }
      }
      else if (reseptfarge == 2){
        Resept resept = new BlaaResept(legemiddel, lege, pasient, reit);
        resepter.leggTil(resept);
        pasient.leggTilResept(resept);
        lege.leggTil(resept);
      }
      else{
        System.out.println("Ugyldig input. Tast 1 for hvit resept eller 2 for blå resept");
      }
    }
  }

  //metoden oppretter ny lege/fastlege og legger denne i listen over leger
  public void leggTilLege(){
    String navn;
    String avtale;
    int avtaleNummer;

    Scanner tastatur = new Scanner(System.in);
    System.out.println("Tast inn navn på lege: ");
    navn = tastatur.nextLine();

    //sjekker om lege allerede finnes
    for (Lege l : leger){
      if (navn.equals(l.hentLegeNavn())){
        System.err.println("Lege finnes allerede i systemet");
        return;
      }
    }

    System.out.println("Har legen fastlegeavtale? Skriv Ja eller Nei");
    avtale = tastatur.nextLine();
    if (avtale.equals("Ja") || (avtale.equals("ja"))){
      System.out.println("Tast inn avtalenummer");
      avtaleNummer = tastatur.nextInt();
      Lege lege = new Fastlege(navn, avtaleNummer);
      leger.leggTil(lege);
    }
    else if (avtale.equals("Nei") || (avtale.equals("nei"))){
      Lege lege = new Lege(navn);
      leger.leggTil(lege);
    }
    else{
      System.out.println("Ugyldig input. Tast Ja eller Nei");
    }
  }

  //metoden oppretter nytt legemiddel og legger dette i listen over legemidler
  public void leggTilLegemiddel(){
    String navn;
    double pris;
    double virkestoff;
    int styrke;

    String klasseValg;

    Scanner tastatur = new Scanner(System.in);
    System.out.println("Tast inn navn på legemiddel:");
    navn = tastatur.nextLine();

    //sjekker om legemiddelet allerede finnes i systemet
    for (Legemiddel l : legemidler){
      if (navn.equals(l.hentNavn())){
        System.err.println("Legemiddel finnes allerede i systemet");
        return;
      }
    }

    System.out.println("Tast inn pris: ");
    pris = tastatur.nextDouble();
    System.out.println("Tast inn virkestoff:");
    virkestoff = tastatur.nextDouble();
    tastatur.nextLine();
    System.out.println("Velg legemiddelklasse: A, B eller C");
    klasseValg = tastatur.nextLine();

    if (klasseValg.equals("C") || (klasseValg.equals("c")) ){
      Legemiddel legemiddel = new LegemiddelC(navn, pris, virkestoff);
      legemidler.leggTil(legemiddel);
    }
    else if (klasseValg.equals("B") || (klasseValg.equals("b"))){
      System.out.println("Legg inn vanedannende styrke:");
      styrke = tastatur.nextInt();
      Legemiddel legemiddel = new LegemiddelB(navn, pris, virkestoff, styrke);
      legemidler.leggTil(legemiddel);
    }
    else if (klasseValg.equals("A") || (klasseValg.equals("a"))){
      System.out.println("Legg inn narkotisk styrke:");
      styrke = tastatur.nextInt();
      Legemiddel legemiddel = new LegemiddelA(navn, pris, virkestoff, styrke);
      legemidler.leggTil(legemiddel);
    }
    else{
      System.out.println("Ugyldig legemiddelklasse");
    }
  }

  class PasientIkkeFunnetException extends RuntimeException{}

  class ReseptIkkeFunnetException extends RuntimeException{}

  class IngenReitException extends RuntimeException{}


  private Pasient finnPasient(int pasientId){
    for (Pasient p : pasienter){
      if (pasientId == p.hentPasientID()){
        return p;
      }
    }
    throw new PasientIkkeFunnetException();
  }

  private Resept finnResept(int reseptnr, Pasient p){
    for (Resept r : p.hentUtResepter()){
      if (reseptnr == r.hentId()){
        return r;
      }
    }

    throw new ReseptIkkeFunnetException();
  }

  //metode for å bruke en resept. Henter ut pasient og ønsket resept og nedjusterer reit
  public void brukResept(){
    int pasientnr;
    int reseptnr;

    Scanner tastatur = new Scanner(System.in);

    if (resepter.stoerrelse() == 0){
      System.out.println("\nFinnes ingen resepter i systemet");
      return;
    }

    System.out.println("Hvilken pasient vil du se resepter for? Tast inn pasient ID: ");
    for (Pasient p : pasienter)
      System.out.println(p + "\n");
    pasientnr = tastatur.nextInt();

    try {
      Pasient p = finnPasient(pasientnr);

      if (p.hentUtResepter().stoerrelse() == 0){
        System.out.println("Pasienten har ingen resepter");
        return;
      }

      for (Resept r : p.hentUtResepter()){
        System.out.println("\nValgt pasient: " + p.hentPasientNavn() + ", " + r);
      }

      System.out.println("\nHvilken resept vil du bruke? Tast resept ID: ");
      reseptnr = tastatur.nextInt();

      Resept r = finnResept(reseptnr, p);

      if (r.bruk() == true){
          System.out.println("Brukte resept på " + r.hentLegemiddel().hentNavn() + ". Antall gjenværende reit: " + r.hentReit());
      }
      else{
        throw new IngenReitException();
      }

    }
    catch (PasientIkkeFunnetException p) {
      System.out.println("Pasient ikke funnet");
    }
    catch (ReseptIkkeFunnetException r) {
      System.out.println("Resept ikke funnet");
    }
    catch (IngenReitException e) {
      System.out.println("Kunne ikke bruke resept. Ingen reit igjen.");
    }
  }
}
