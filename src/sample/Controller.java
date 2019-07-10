package sample;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    Random r = new Random();
    int count = 0;
    int justePrix = r.nextInt(50000);

    @FXML
    private TextField Resultat;

    @FXML
    private TextField Prix;

    @FXML
    private Button ButtonEnvoyer;

    @FXML
    private TextField Reponses;

    @FXML
    private TextField nbrCoups;

    @FXML
    private Button Rejouer;

    @FXML
    private void ButtonEnvoyerOnClick() {
        try {
            String oldPrix = Prix.getText();
            int newPrix = Integer.parseInt(oldPrix);
            if (newPrix > 50000) {
                Resultat.setText("Veuillez entrer un prix plus petit ou egal à 50 000 €");
                Prix.setText("");
            } else if (justePrix > newPrix) {
                count++;
                if (count > 1) {
                    nbrCoups.setText( "Nombre de coups : " + count );
                } else {
                    nbrCoups.setText( "Nombre de coup : " + count );
                }
                Prix.setText("");
                Resultat.setText("Votre prix est : " + newPrix);
                Reponses.setText("C'est plus !");
            } else if (justePrix < newPrix){
                count++;
                if (count > 1) {
                    nbrCoups.setText( "Nombre de coups : " + count );
                } else {
                    nbrCoups.setText( "Nombre de coup : " + count );
                }
                Prix.setText("");
                Resultat.setText("Votre prix est : " + newPrix);
                Reponses.setText("C'est moins !");
            } else if (justePrix == newPrix) {
                if (count > 1) {
                    Prix.setText("");
                    Resultat.setText("Bravo, le juste prix est : " + justePrix + " €. Vous avez gagné en " + count + " coups.");
                    Reponses.setText("Gagné !");
                    ButtonEnvoyer.setDisable( true );
                }else {
                    Prix.setText("");
                    Resultat.setText("Bravo, le juste prix est : " + justePrix + " €. Vous avez gagné en " + count + " coup.");
                    Reponses.setText("Gagné !");
                    ButtonEnvoyer.setDisable( true );
                }
            }
        } catch (Exception e) {
            Resultat.setText("Seul les nombres entier sont accepté ! Veuillez recommencer !");
            Prix.setText("");
        }
    }

    @FXML
    private void rejouer(){
        count = 0;
        Random r = new Random();
        justePrix = r.nextInt(50000);
        Resultat.setText("Veuillez entrer un prix plus petit ou egal à 50 000 €");
        Reponses.setText( "" );
        Prix.setText( "" );
        nbrCoups.setText( "Nombre de coup : " + count );
        ButtonEnvoyer.setDisable( false );
    }
}