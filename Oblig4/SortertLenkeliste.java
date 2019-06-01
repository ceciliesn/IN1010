class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

  //skal sette inn elementer i sortert rekkefølge (fra minst til størst)
  @Override
  public void leggTil (T x){
    Node nyNode = new Node(x);
    if (startNode == null){
      startNode = nyNode;
    }
    else if (startNode.x.compareTo(nyNode.x) > 0){
      nyNode.neste = startNode;
      startNode = nyNode;
    }
    else {
      Node aktivNode = startNode;
      while (aktivNode.neste != null &&
        aktivNode.neste.x.compareTo(nyNode.x) < 0 ){
        aktivNode = aktivNode.neste;
      }
      nyNode.neste = aktivNode.neste;
      aktivNode.neste = nyNode;
    }
    antallNoder++;

  }

  //skal fjerne det største elementet
  @Override
  public T fjern(){
    return fjern(stoerrelse() - 1);
  }

  @Override
  public void sett(int pos, T x){
    throw new UnsupportedOperationException();
  }


  @Override
  public void leggTil(int pos, T x){
    throw new UnsupportedOperationException();
  }

}
