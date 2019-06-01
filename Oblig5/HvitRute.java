public class HvitRute extends Rute {

  public HvitRute(int kolonnePlass, int radPlass, Labyrint labyrint) {
    super(kolonnePlass, radPlass, labyrint);
  }

  @Override
  public char tilTegn() {
    return '.';
  }

}
