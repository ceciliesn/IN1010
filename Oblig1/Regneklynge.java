import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Regneklynge{
  ArrayList<Rack> rackliste = new ArrayList<>();
  int antallNoderPerRack;
  boolean settInn;

  public Regneklynge(int antallNoderPerRack){
    this.antallNoderPerRack = antallNoderPerRack;
  }

  public Regneklynge(String filnavn) throws Exception { //konstruktør for innlesing fra fil
    lesFil(filnavn);
  }

  public void lesFil(String filnavn) throws Exception { //metode for å opprette regneklynge og noder ved innlesing fra fil

    File fil = new File(filnavn);
    Scanner innFil = new Scanner(fil);

    antallNoderPerRack = innFil.nextInt();

    while (innFil.hasNextLine()) {
      int antNoder = innFil.nextInt();
      int minneStr = innFil.nextInt();
      int pros = innFil.nextInt();

      for (int i = 0; i < antNoder; i++){
        Node n = new Node (minneStr, pros);
        settInnNodeiRack(n);
      }
    }
  }

    public void settInnNodeiRack(Node node){ //metoden sjekker om det er rack i regneklyngen eller om racket er fullt. I begge tilfeller lages et nytt rack, og en node settes inn i racket
      if (rackliste.isEmpty()){
        rackliste.add(new Rack(antallNoderPerRack));
      }

      Rack sisteRack = rackliste.get(rackliste.size() - 1 ); //setter inn node på siste ledige plass i racket
      settInn = sisteRack.settInnNode(node);

      if (settInn == false){ // racket er fullt
        Rack nyttRack = new Rack(antallNoderPerRack);
        rackliste.add(nyttRack);
        nyttRack.settInnNode(node);
      }
    }

  public int getAntProsKlynge(){ //metoden henter ut antall prosessorer i regneklyngen
    int inKlynge = 0;
    for (int i = 0; i < rackliste.size(); i++){
      inKlynge += rackliste.get(i).getProsRack();
    }
    return inKlynge;
  }

  public int antRacks(){ //returnerer antall racks i regneklyngen
    return rackliste.size();
  }

  public int noderMedNokMinne (int paakrevdMinne){ //metoden sjekker om nodene har minne over en gitt minnestørrelse
    int antNoderMedNokMinne = 0;
    for (int iRack = 0; iRack < rackliste.size(); iRack++){
      for (int iNode = 0; iNode < antallNoderPerRack; iNode++){
        if (rackliste.get(iRack).getNode(iNode) == null){
          return antNoderMedNokMinne;
        }
        else {
          if (rackliste.get(iRack).getNode(iNode).getMinne() >= paakrevdMinne){
            antNoderMedNokMinne++;
          }
        }
      }
    }
    return antNoderMedNokMinne;
  }
}
