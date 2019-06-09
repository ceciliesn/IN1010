//Har problemer med å vise labyrintfil 4, får java.lang.OutOfMemory-feilmelding som jeg ikke klarer å diagnostisere. Fungerer fint når jeg skal vise øvrige labyrintfiler.

//for oppsett og utforming
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//handling/action
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.application.Platform;
import javafx.scene.control.Button;

//filvalg
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;


public class Hovedprogram extends Application {

    private Scene startside;
    private Scene labyrintBrett;
    private int bredde = 400;
    private int hoyde = 400;
    private Lenkeliste<String> utveier;
    private int teller = 0;
    private File labFil;
    private Labyrint labyrint;
    private Rute[][] rutenett;
    private Pane[][] pane;
    private GridPane labyrintRutenett;
    private Label actionKnapp;



    @Override
    public void start(Stage teater) throws Exception {

      //setter opp startvindu med valgalternativer og overskrift
      teater.setTitle("IN1010 Oblig 7");
      VBox menyValg = new VBox();
      TextField filVelger = new TextField();
      Button labVelger = new Button ("Vis labyrint");
      //setter opp stoppknapp for å kunne avslutte programmet
      StoppBehandler stopp = new StoppBehandler();
      Button stoppknapp = new Button ("Avslutt");
      stoppknapp.setOnAction(stopp);

      //lager og gir funksjonalitet til knapp for valg av labyrintfil
      Button valgKnapp = new Button ("Last inn labyrintfil");
      valgKnapp.setStyle("-fx-background-color: #ff0000;");
      valgKnapp.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        FileChooser filvelger = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Velg fil som slutter med *.in", "*.in");
        filvelger.getExtensionFilters().add(filter);
        filvelger.setTitle("Velg fil");
        //lager linje for å vise filvalg
        labFil = filvelger.showOpenDialog(null);
        System.out.println(labFil);
        if (labFil != null) {
          filVelger.setText(labFil.getPath());
          System.out.println(labFil.getPath());
        }
      }
      });

      //setter opp tilhørende funksjon for knapp for valg ved "Vis labyrint"
      labVelger.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        //lager BP-layout med gitte posisjoner
        BorderPane labyrintBP = new BorderPane();
        labyrintRutenett = new GridPane();
        actionKnapp = new Label("Trykk på rute for å finne veien ut");
        labyrintBP.setLeft(labyrintRutenett);
        labyrintBP.setBottom(actionKnapp);
        labyrintBP.setRight(stoppknapp);
        try {
            labyrint = labyrint.lesFraFil(labFil);
        }
        catch(Exception e) {}

        pane = new Pane[labyrint.hentAntallKolonner()][labyrint.hentAntallRader()];
        rutenett = labyrint.hentArray();
        for (Rute[] rute : rutenett){
            for (Rute r : rute){
                Pane pane2 = new Pane();
                labyrintRutenett.add(pane2, r.hentKolonnePlass(), r.hentRadplass());
                pane[r.hentKolonnePlass()][r.hentRadplass()] = pane2;
                labyrintTegner(pane2, r);
            }
        }
        labyrintBrett = new Scene(labyrintBP, bredde, hoyde);
        teater.setScene(labyrintBrett);
        teater.sizeToScene();
      }
      });

      //legger elementene til på startvinduet
      menyValg.getChildren().addAll(valgKnapp, filVelger, labVelger, stoppknapp);
      startside = new Scene(menyValg, 350, 200);
      teater.setScene(startside);
      teater.sizeToScene();
      teater.show();
    }

    //klasse for stoppbehandler for å kunne avslutte programmet
    public class StoppBehandler implements EventHandler<ActionEvent> {
      @Override
      public void handle(ActionEvent e) {
        Platform.exit();
      }
    }

    //metode for å farge labyrinten og vise antall utveier i tekstformat
    public void labyrintTegner(Pane pane, Rute rute){
      //sjekker om rutene er kantruter(#) og markerer evt disse ut fra gitt format
      if (rute.tilTegn() == '#'){
          pane.setStyle("-fx-border-color: darkcyan; -fx-border-style: solid; -fx-border-width: 5px; ");
      }
      //dersom det ikke er kantrute
      else {
          //setter handling for når musen klikkes
          pane.setOnMousePressed(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            utveier = labyrint.finnUtveiFra(rute.hentKolonnePlass(), rute.hentRadplass());
            int teller = utveier.stoerrelse();
            String ruteValg = utveier.fjern();
            boolean[][] losning = losningStringTilTabell(ruteValg, labyrint.hentAntallKolonner(), labyrint.hentAntallRader());
            fargUtveier(losning);
            actionKnapp.setText("Antall utveier: " + teller);
            }
          });
      }
    }

    //metode for å farge utveiene fra labyrinten
    private void fargUtveier(boolean[][] losning) {
        for (int i = 0; i < losning[0].length; i++ ) {
            for (int k = 0; k < losning.length; k++) {
                boolean bool = losning[k][i];
                if (bool) {
                  pane[i][k].setStyle("-fx-border-color: darkgoldenrod; -fx-border-style: dotted; -fx-border-width: 5px;");
                }
            }
        }
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

    public static void main (String[] args) {
        launch(args);
    }
}
