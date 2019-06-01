import java.util.concurrent.CountDownLatch;

public class Kryptograf implements Runnable {

  private Monitor monitorKrypterte; //mottar fra denne
  private Monitor monitorDekrypterte; //sender videre til denne
  private int kryptoId; //brukes for å identifisere kryptografene
  private static int teller = 0;
  private CountDownLatch kCount;

  public Kryptograf (Monitor monitorKrypterte, Monitor monitorDekrypterte, CountDownLatch kCount) {
    this.monitorKrypterte = monitorKrypterte;
    this.monitorDekrypterte = monitorDekrypterte;
    this.kCount = kCount;
    kryptoId = teller++;
  }

  @Override
  public void run() {
    Melding krypto = monitorKrypterte.hentUtMelding();
    while (krypto != null) {
      krypto.dekrypter();
      monitorDekrypterte.leggTilMelding(krypto);
      //System.out.println("Kryptograf nr. " + kryptoId + " har dekryptert og lagt til en melding");
      krypto = monitorKrypterte.hentUtMelding();
    }
    System.out.println("Kryptograf nr. " + kryptoId + " er ferdig");
    kCount.countDown();
  }
}
