import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Testprogram {


  public static void main(String[] args) {
    File fil = new File("1.in");
  try {
    Labyrint labyrint = Labyrint.lesFraFil(fil);
    System.out.println(labyrint);

    labyrint.finnUtveiFra(5,3);
  }

    catch(FileNotFoundException e){
      System.out.println("File not found!");
    }

  }
}
