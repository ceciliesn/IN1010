//Iterable er et grensesnitt som brukes for å gjøre listene itererbare.

interface Liste<T> extends Iterable<T>{
  public int stoerrelse();
  public void leggTil(int pos, T x);
  public void leggTil(T x);
  public void sett(int pos, T x);
  public T hent(int pos);
  public T fjern(int pos);
  public T fjern();
}
