import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.CountDownLatch;

public class Monitor {
  private ArrayList<Melding> meldingsliste = new ArrayList<Melding>();
  private Lock laas = new ReentrantLock();
  private Condition harInnhold = laas.newCondition();
  private CountDownLatch count;

  public Monitor(CountDownLatch count) {
    this.count = count;
  }

  public void leggTilMelding(Melding melding) {
    laas.lock();
    try {
      meldingsliste.add(melding);
      harInnhold.signal();
    }
    finally {
      laas.unlock();
    }
  }

  //henter ut melding fra monitor. Dersom det ikke finnes flere meldinger returnerer siste melding null
  public Melding hentUtMelding() {
    laas.lock();
    Melding henteMelding = null;
    try {
        if (count.getCount() != 0 && meldingsliste.isEmpty()) {
          while (meldingsliste.isEmpty() && count.getCount() != 0) {
            harInnhold.await();
            System.out.print("");
          }
        }
        if (count.getCount() == 0 && meldingsliste.isEmpty()) {
          henteMelding = null;
        }
        else {
          henteMelding = meldingsliste.remove(0);
        }

    }
    catch (InterruptedException e){}
    finally {
      laas.unlock();
    }
    return henteMelding;
  }

}
