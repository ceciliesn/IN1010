public class TestResept{

  public static void main(String[] args) {
    Lege proktor = new Fastlege("Doktor Proktor", 5);
    Lege dyregod = new Lege ("Doktor Dyregod");
    Legemiddel rivotril = new LegemiddelB("Rivotril", 150, 7, 13);
    Legemiddel fentanyl = new LegemiddelA("Fentanyl", 475, 23, 50);
    Legemiddel yasmin = new LegemiddelC("Yasmin", 279, 11);

    //Tester blaaResept - sjekker at pris reduseres med 75%
    Resept blaaResept = new BlaaResept(fentanyl, proktor, 4, 3);
    System.out.println();
    System.out.printf("FORVENTET RESULTAT: %n Legemiddel: Fentanyl %n Resept ID: 0 %n Pasient ID: 4 %n Utskrivende lege: Doktor Proktor %n Reit: 3 %n Original pris: 475 %n Reseptfarge: Blaa - Faktisk pris: 118.75 %n Oppdatert reit: 2");
    System.out.println();
    skrivUt(blaaResept);

    //Tester milietaerResept - sjekker at prisen blir 0;
    Resept militaerResept = new MilitaerResept(rivotril, proktor, 5, 6);
    System.out.println();
    System.out.printf("FORVENTET RESULTAT: %n Legemiddel: Rivotril %n Resept ID: 1 %n Pasient ID: 5 %n Utskrivende lege: Doktor Proktor %n Reit: 6 %n Original pris: 150 %n Reseptfarge: Hvit - Faktisk pris: 0 %n Oppdatert reit: 5");
    System.out.println();
    skrivUt(militaerResept);

    //Tester P-Resept - sjekker at reit blir 3 selv om den settes til noe annet
    Resept pResept = new PResept(yasmin, dyregod, 7, 11);
    System.out.println();
    System.out.printf("FORVENTET RESULTAT: %n Legemiddel: Yasmin %n Resept ID: 2 %n Pasient ID: 7 %n Utskrivende lege: Doktor Dyregod %n Reit: 3 %n Original pris: 279 %n Reseptfarge: Hvit - Faktisk pris: 163 %n Oppdatert reit: 2");
    System.out.println();
    skrivUt(pResept);
    }

    //egen skrivUt for enklere enhetstesting.
    public static void skrivUt(Resept reseptnavn){
      System.out.println();
      System.out.println("FAKTISK RESULTAT:");
      System.out.println("Legemiddel: " + reseptnavn.hentLegemiddel().hentNavn());
      System.out.println("Resept ID: " + reseptnavn.hentId());
      System.out.println("Pasient ID: " + reseptnavn.hentPasientId());
      System.out.println("Utskrivende lege: " + reseptnavn.hentLege().hentLegeNavn());
      System.out.println("Reit: " + reseptnavn.hentReit());
      System.out.println("Original pris: " + reseptnavn.hentLegemiddel().hentPris());
      System.out.println("Reseptfarge: " + reseptnavn.farge() + " - Faktisk pris: " + reseptnavn.prisAaBetale());
      reseptnavn.bruk(); //bruker for aa sjekke at reit reduseres
      System.out.println("Oppdatert reit: " + reseptnavn.hentReit());
    }

}
