import java.util.concurrent.CountDownLatch;

public class Hovedprogram {

  public static void main(String[] args) {

    int antallKryptografer = 20;
    int antallKanaler = 3;
    int antallTelegrafister = antallKanaler;

    Operasjonssentral ops = new Operasjonssentral(antallTelegrafister);
    Kanal[] kanaler = ops.hentKanalArray();

    CountDownLatch teleFerdig = new CountDownLatch(antallTelegrafister);
    CountDownLatch kryptoFerdig = new CountDownLatch(antallKryptografer);
    CountDownLatch oplFerdig = new CountDownLatch(1);

    Monitor monitorKrypterte = new Monitor(teleFerdig);
    Monitor monitorDekrypterte = new Monitor(kryptoFerdig);


    //Oppretter telegrafister og tråd, og starter tråden
    for (int i = 0; i < antallTelegrafister; i++){
      new Thread (new Telegrafist(kanaler[i], monitorKrypterte, teleFerdig)).start();
      System.out.println("Telegrafist nr. " + i + " opprettet og startet");
    }

    //Oppretter kryptografer og tråd, og starter tråden
    for (int i = 0; i < antallKryptografer; i++){
      new Thread (new Kryptograf(monitorKrypterte, monitorDekrypterte, kryptoFerdig)).start();
      System.out.println("Kryptograf nr. " + i + " opprettet og startet");
    }

    //Oppretter operasjonsleder og tråd, og starter tråden
    Thread opl = new Thread(new Operasjonsleder(monitorDekrypterte, antallKanaler, oplFerdig));
    opl.start();
    System.out.println("Operasjonsleder opprettet og startet");
  }
}
