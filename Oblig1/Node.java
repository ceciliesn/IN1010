public class Node{
  int minne;
  int antPros;

  public Node (int minne, int antPros){
    this.minne = minne;
    this.antPros = antPros;
  }

  public int getProsNode(){ //metoden returnerer antall prosessorer i noden
    return antPros;
  }

  public int getMinne(){ //metoden returnerer nodens minne
    return minne;
  }

}
