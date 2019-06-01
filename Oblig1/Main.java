import java.util.Scanner;
import java.io.*;

class Main{

  public static void main(String[] args) {

    Regneklynge abel = new Regneklynge(12); //oppretter ny regneklynge med plass til 12 noder i hvert rack


    for (int i = 0; i < 650; i++){
      Node n1 = new Node (64, 1);
      abel.settInnNodeiRack(n1);
    }

    for (int i = 0; i < 16; i++){
      Node n2 = new Node(1024, 2);
      abel.settInnNodeiRack(n2);
    }

    System.out.println("Regneklynge Abel: ");
    System.out.println("Noder med minst 32 GB: " + abel.noderMedNokMinne(32));
    System.out.println("Noder med minst 64 GB: " + abel.noderMedNokMinne(64));
    System.out.println("Noder med minst 128 GB: " + abel.noderMedNokMinne(128));
    System.out.println();
    System.out.println("Antall prosessorer: " + abel.getAntProsKlynge());
    System.out.println("Antall rack: " + abel.antRacks());
    System.out.println();

    try{

      Regneklynge lie = new Regneklynge("regneklynge2.txt"); //oppretter en regneklynge ved innlesning fra fil

      System.out.println("Regneklynge Lie: ");
      System.out.println("Noder med minst 32 GB: " + lie.noderMedNokMinne(32));
      System.out.println("Noder med minst 64 GB: " + lie.noderMedNokMinne(64));
      System.out.println("Noder med minst 128 GB: " + lie.noderMedNokMinne(128));
      System.out.println();
      System.out.println("Antall prosessorer: " + lie.getAntProsKlynge());
      System.out.println("Antall rack: " + lie.antRacks());
  }

    catch(Exception e) {
      System.err.println("Kunne ikke lese fil");
    }
  }
}
