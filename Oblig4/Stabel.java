class Stabel <T> extends Lenkeliste<T>{

  //legge til elementer paa slutten av listen
  public void leggPaa (T x){
    leggTil(x);
  }

  //fjerne elementer paa slutten av listen
  public T taAv(){
    return fjern(stoerrelse() - 1);
  }
}
