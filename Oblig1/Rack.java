public class Rack{
  Node[]nodeliste;
  int antallNoderINodeliste = 0;
  int antallNoderPerRack;

  public Rack(int antNoder){
    this.antallNoderPerRack = antNoder;
    this.nodeliste = new Node[antallNoderPerRack]; 
  }

  public boolean settInnNode(Node node){ //metoden plasserer en node inn i et rack, hvis det er ledig plass i racket
    if (antallNoderINodeliste >= antallNoderPerRack){
      return false; //metoden returnerer false om racket er fullt
    }
    nodeliste[antallNoderINodeliste] = node;
    antallNoderINodeliste++;
    return true; //node legges til, teller øker, og true returneres om det er plass i racket
  }

  public int getProsRack(){ //metoden returnerer antall prosesserer i et rack
    int inRack = 0;
    for (int i = 0; i < antallNoderINodeliste; i++) {
      inRack += nodeliste[i].getProsNode();
    }
    return inRack;
  }

  public Node getNode(int nodePosisjon){
    return nodeliste[nodePosisjon];
  }
}
