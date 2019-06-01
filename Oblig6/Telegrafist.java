import java.util.concurrent.CountDownLatch;

public class Telegrafist implements Runnable {

  private Kanal kanal; //kanalen telegrafisten hører på
  private Monitor monitorKrypterte; //monitor telegrafisten sender til
  private int telegrafistID; //for å identifisere de ulike telegrafistene
  private static int teller = 0;
  private CountDownLatch tCount;
  private int kanalId;
  private int sekvensnummer;

  public Telegrafist(Kanal kanal, Monitor monitorKrypterte, CountDownLatch tCount) {
    this.kanal = kanal;
    this.monitorKrypterte = monitorKrypterte;
    this.tCount = tCount;
    this.telegrafistID = teller++;
    kanalId = kanal.hentId();
    sekvensnummer = 1;
  }

  //en telegrafist lytter på hver sin kanal helt til det ikke kommer flere meldinger
  @Override
  public void run() {
      String lytteMelding = kanal.lytt();
      while (lytteMelding != null) {
        Melding kryptertMelding = new Melding(lytteMelding, sekvensnummer++, kanalId);
        monitorKrypterte.leggTilMelding(kryptertMelding);
        //System.out.println("Telegrafist " + telegrafistID + " har lagt en melding i kryptert monitor");
        lytteMelding = kanal.lytt();
      }
      System.out.println("Telegrafist nr. " + telegrafistID + " er ferdig");
      tCount.countDown();
  }
}
