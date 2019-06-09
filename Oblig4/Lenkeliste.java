import java.util.Iterator;
import java.util.NoSuchElementException;


class Lenkeliste<T> implements Liste<T>{
  protected int antallNoder = 0;

  Node startNode;

  //henter antall noder i lenkelisten
  @Override
  public int stoerrelse() {
    return antallNoder;
  }

  //legger inn et nytt element i listen og skyver neste element ett hakk lenger bak
  @Override
  public void leggTil(int pos, T x){
    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos > antallNoder){
      throw new UgyldigListeIndeks(pos);
    }

    if (pos == 0){
      Node nyNode = new Node(x);
      nyNode.neste = startNode;
      startNode = nyNode;
    }
    else {
      int aktivPosisjon = 0;
      Node aktivNode = startNode;

      while (aktivPosisjon < (pos-1)){
        aktivNode = aktivNode.neste;
        aktivPosisjon++;
      }

      Node nyNode = new Node(x);
      nyNode.neste = aktivNode.neste;
      aktivNode.neste = nyNode;
    }

    antallNoder++;
  }

  //setter inn elementet på en gitt posisjon og overskriver det som var der fra før av.
  @Override
  public void sett(int pos, T x){
    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos >= antallNoder){
      throw new UgyldigListeIndeks(pos);
    }

    int aktivPosisjon = 0;
    Node aktivNode = startNode;
    while (aktivPosisjon < pos){
      aktivNode = aktivNode.neste;
      aktivPosisjon++;
    }
    aktivNode.x = x;
  }

  //legger til element på slutten av listen
  @Override
  public void leggTil(T x) {
    Node nyNode = new Node(x);
    if (startNode == null){
      startNode = nyNode;
    }
    else {
      Node aktivNode = startNode;
      while (aktivNode.neste != null){
        aktivNode = aktivNode.neste;
      }
      aktivNode.neste = nyNode;
    }
    antallNoder++;
  }

  //henter ut et element (uten å fjerne det fra listen) på oppgitt indeks
  @Override
  public T hent(int pos){
   if (pos < 0){
     throw new UgyldigListeIndeks(pos);
   }
   if (pos >= antallNoder){
     throw new UgyldigListeIndeks(pos);
   }
   int aktivPosisjon = 0;
   Node aktivNode = startNode;
   while (aktivPosisjon < pos){
     aktivNode = aktivNode.neste;
     aktivPosisjon++;
   }
   return aktivNode.x;
  }

  //fjerner på gitt indeks i listen
  @Override
  public T fjern (int pos) {
    if (pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos >= antallNoder){
      throw new UgyldigListeIndeks(pos);
    }

    if (antallNoder == 1){
      T x = startNode.x;
      startNode = null;
      antallNoder = 0;
      return x;
  }

    int aktivPosisjon = 0;
    Node aktivNode = startNode;

    while (aktivPosisjon < (pos-1)){
      aktivNode = aktivNode.neste;
      aktivPosisjon++;
    }

    Node fjernNode = aktivNode.neste;
    aktivNode.neste = fjernNode.neste;
    antallNoder--;
    return fjernNode.x;
  }


  //fjerner og returnerer elementet på starten av listen
  @Override
  public T fjern(){
    if (antallNoder == 0){
      throw new UgyldigListeIndeks(-1);
    }
    T x = startNode.x;
    startNode = startNode.neste;
    antallNoder--;
    return x;
  }

  //lager selve iterator-objektet
  public Iterator<T> iterator(){
    return new LenkelisteIterator();
  }

  //node-klasse
  protected class Node {
   T x;
   Node neste;

   Node(T x){
     this.x = x;
   }
  }

  //Lager klasse som implementerer Iterator-grensesnittet. Dette beskriver selve iterator-objektet som brukes for å gjennom listen.
  public class LenkelisteIterator implements Iterator<T>{
    //private Lenkeliste<T> lenkeliste;

    Node aktivNode = startNode;

    public boolean hasNext(){
      return aktivNode != null;
    }

    public T next(){
      if (hasNext()){
        T t = aktivNode.x;
        aktivNode = aktivNode.neste;
        return t;
      }

      throw new NoSuchElementException();
    }

  }
}
