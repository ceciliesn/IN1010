import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.text.*;
import javafx.scene.layout.BorderPane;



public class Testing extends Application {

  private Labyrint labyrint;
  private GridPane rutenett = new GridPane();
  private Stage teater;
  private File valgtFil;
  private Rute[][] spillebrett;
  private int rader;
  private int kolonner;

  @Override
  public void start(Stage teater) throws Exception{ //sett opp scenen
    this.teater = teater;

    GridPane rutenett = new GridPane();
    rutenett.setGridLinesVisible(true);


    Pane kulisser = new Pane();
    kulisser.setPrefSize(600,600);
    Scene scene = new Scene (kulisser);

    //sette opp stoppknapp
    StoppBehandler stopp = new StoppBehandler();
    Button stoppknapp = new Button("Avslutt");
    stoppknapp.setLayoutX(530);
    stoppknapp.setLayoutY(565);
    stoppknapp.setOnAction(stopp);
    kulisser.getChildren().add(stoppknapp);

    Button velgLab = new Button("Vennligst velg ønsket labyrint");
    velgLab.setLayoutX(100);
    velgLab.setLayoutY(40);
    velgLab.setFont(new Font(25));
    kulisser.getChildren().add(velgLab);

    //labyrint = lagLabyrint(teater);

    teater.setTitle("Labyrint IN1010"); //setter tittel
    teater.setScene(scene);
    teater.show(); //angir at teppet går opp
  }


  /**
   * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
   * av losningstien.
   * @param losningString String-representasjon av utveien
   * @param bredde        bredde til labyrinten
   * @param hoyde         hoyde til labyrinten
   * @return              2D-representasjon av rutene der true indikerer at
   *                      ruten er en del av utveien.
   */
  static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
      boolean[][] losning = new boolean[hoyde][bredde];
      java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
      java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
      while (m.find()) {
          int x = Integer.parseInt(m.group(1));
          int y = Integer.parseInt(m.group(2));
          losning[y][x] = true;
      }
      return losning;
  }

  public class StoppBehandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
      Platform.exit();
    }
  }


  public Labyrint lagLabyrint (Stage teater){
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Velg ønsket labyrint");
      File labyrintfil = fileChooser.showOpenDialog(teater);
      //labyrint = Labyrint.lesFraFil(labyrintfil);
      try {
        if (labyrintfil != null){
          System.out.println(labyrintfil.getPath());
          labyrint = Labyrint.lesFraFil(labyrintfil);

        }
      } catch (FileNotFoundException e) {
          System.out.printf("Kunne ikke lese fra fil");
      }
      return labyrint;
    }

  }
