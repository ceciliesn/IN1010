public class TestLegemiddel {
  public static void main(String[] args) {
    Legemiddel morfin = new LegemiddelA("Morfin", 375, 43, 7);
    Legemiddel sobril = new LegemiddelB("Sobril", 59.50, 17, 4);
    Legemiddel paracet = new LegemiddelC("Paracet", 19.90, 11);

    //Tester Legemiddel A
    System.out.printf("FORVENTET RESULTAT %n Legemiddel: Morfin %n Pris: 375 %n Virkestoff 43 %n ID:0 %n Narkotisk styrke: 7 %n");
    System.out.println();
    System.out.println(("FAKTISK RESULTAT:"));
    skrivUt(morfin);
    System.out.println("Narkotisk styrke: " + morfin.hentStyrke());
    System.out.println();

    //Tester Legemiddel B
    System.out.printf("FORVENTET RESULTAT %n Legemiddel: Sobril %n Pris: 59.50 %n Virkestoff 17 %n ID:1 %n Vanedannende styrke: 4 %n");
    System.out.println();
    System.out.println(("FAKTISK RESULTAT:"));
    skrivUt(sobril);
    System.out.println("Vanedannende styrke: " + sobril.hentStyrke());
    System.out.println();

    //Tester Legemiddel C
    System.out.printf("FORVENTET RESULTAT %n Legemiddel: Paracet %n Pris: 19.90 %n Virkestoff 11 %n ID: 2 %n Ny pris: 27.50 %n");
    System.out.println();
    System.out.println(("FAKTISK RESULTAT:"));
    skrivUt(paracet);
    paracet.settNyPris(27.50);
    System.out.println("Forventer ny pris 27.50");
    System.out.println("Ny pris Paracet: " + paracet.hentPris());
  }

  //lager egen metode for utskrift av legemiddel for bruk i enhetstesting.
  public static void skrivUt(Legemiddel legemiddel){
    System.out.println("Legemiddel: " + legemiddel.hentNavn());
    System.out.println("Pris: " + legemiddel.hentPris());
    System.out.println("Virkestoff: " + legemiddel.hentVirkestoff());
    System.out.println("Legemiddel ID: " + legemiddel.hentId());
  }

}
