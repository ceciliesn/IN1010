class Integrasjonstest{

  public static void main(String[] args) {
    LegemiddelB rivotril = new LegemiddelB("Rivotril", 150, 7, 13);
    LegemiddelA fentanyl = new LegemiddelA("Fentanyl", 475, 23, 50);
    LegemiddelC yasmin = new LegemiddelC("Yasmin", 279, 11);

    Lege proktor = new Lege("Doktor Proktor");
    Lege dyregod = new Fastlege ("Doktor Dyregod", 45);

    Resept blaaResept = new BlaaResept(fentanyl, proktor, 4, 3);
    Resept militaerResept = new MilitaerResept(rivotril, proktor, 19, 6);
    Resept pResept = new PResept(yasmin, dyregod, 7, 7); //setter reit 7 for aa se om dette korrigeres

    skrivUtFellesInfo(blaaResept);
    infoA(fentanyl);

    skrivUtFellesInfo(militaerResept);
    infoB(rivotril);
    militaerResept.bruk();
    System.out.println();
    System.out.println("Sjekker at reit er redusert på resept ID 1 etter bruk. Forventet reit: 5. Faktisk reit: " + militaerResept.hentReit());

    skrivUtFellesInfo(pResept);
    System.out.println("Avtalenummer: " + ((Fastlege)dyregod).hentAvtaleNummer()); //caster
  }

  public static void skrivUtFellesInfo(Resept reseptnavn){
    System.out.println();
    System.out.println("Legemiddel: " + reseptnavn.hentLegemiddel().hentNavn());
    System.out.println("Legemiddel ID: " + reseptnavn.hentLegemiddel().hentId());
    System.out.println("Virkestoff: " + reseptnavn.hentLegemiddel().hentVirkestoff());
    System.out.println("Original pris: " + reseptnavn.hentLegemiddel().hentPris());
    System.out.println("Reseptfarge: " + reseptnavn.farge() + " - Faktisk pris: " + reseptnavn.prisAaBetale());
    System.out.println("Resept ID: " + reseptnavn.hentId());
    System.out.println("Reit: " + reseptnavn.hentReit());
    System.out.println("Pasient ID: " + reseptnavn.hentPasientId());
    System.out.println("Utskrivende lege: " + reseptnavn.hentLege().hentLegeNavn());
  }

  public static void infoA(LegemiddelA legemiddel){
    System.out.println(legemiddel.hentNavn() + " - Narkotisk styrke: " + legemiddel.hentStyrke());
  }

  public static void infoB(LegemiddelB legemiddel){
    System.out.println(legemiddel.hentNavn() + " - Vanedannende styrke: " + legemiddel.hentStyrke());
  }
}
