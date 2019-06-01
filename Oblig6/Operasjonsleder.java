import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.Collections;

public class Operasjonsleder implements Runnable {
    private ArrayList<ArrayList<Melding>> kanaler = new ArrayList<>();
    private Monitor monitorDekrypterte;
    private int antallKanaler;
    private CountDownLatch oCount;

  public Operasjonsleder (Monitor monitorDekrypterte, int antallKanaler, CountDownLatch oCount) {
    this.monitorDekrypterte = monitorDekrypterte;
    this.antallKanaler = antallKanaler;
    this.oCount = oCount;
    for(int i = 0; i < antallKanaler; i++) {
      kanaler.add(new ArrayList<Melding>());
    }
  }

  //operasjonsleder henter dekryptert melding og legger i arraylist tilhørende korrekt kanal
  public void run() {
    Melding henteMelding = monitorDekrypterte.hentUtMelding();
    while (henteMelding != null) {
        //System.out.println("Operasjonsleder henter dekryptert melding " + henteMelding.hentSekvensnummer() + " fra kanal " + henteMelding.hentKanalId());
        kanaler.get(henteMelding.hentKanalId() - 1).add(henteMelding);
        henteMelding = monitorDekrypterte.hentUtMelding();
    }
    oCount.countDown();
    System.out.println("Operasjonsleder er ferdig med å lese meldinger. Skriver meldinger til fil.");
    skrivTilFil();
  }

  //operasjonsleder skriver meldingene til fil
  public void skrivTilFil() {
    for (int i = 0; i < antallKanaler; i++) {
      Collections.sort(kanaler.get(i)); //bruker Arraylist sin sort-funksjon for å sortere meldingene i riktig rekkefølge basert på sekvensnummer
      PrintWriter skriver = null;
      try {
        skriver = new PrintWriter("Kanal " + i, "utf-8");
        for (Melding m : kanaler.get(i)) {
            skriver.println(m.hentTekst() + "\n" + "\n");
        }
      } catch (IOException ioe) {}
      finally {
        skriver.close();
      }
    }
  }
}
