package sample;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Controller {


        public MenuItem obrirItem;
        public MenuItem guardarItem;
        public MenuItem sortirItem;

        public MenuItem copiarItem;
        public MenuItem tallarItem;
        public MenuItem enganxarItem;
        public MenuItem desfesItem;

        public Menu fontMenu;
        public RadioMenuItem dejaVuSans;
        public RadioMenuItem freeMono;
        public RadioMenuItem monospaced;

        public Menu tamanyMenu;
        public Menu ajudaMenu;

        public TextArea editorText;

        public Button btTallar;
        public Button btCopiar;
        public Button btEnganxar;

        @FXML
        private Parent root;


        public void salirAction() {Platform.exit();}
        public void copiarAction() {
                editorText.copy();
        }
        public void tallarAction(){
                editorText.cut();
        }
        public void enganxarAction(){
                editorText.paste();
        }
        public void desferAction() {
                editorText.undo();
        }



        public void setFont(ActionEvent actionEvent) {

            RadioMenuItem rmi = (RadioMenuItem) actionEvent.getSource();
            String font = rmi.getText();

            double tam = editorText.getFont().getSize();

            switch(font){
                case "DejaVu Sans":
                    editorText.setFont(Font.font("DejaVu Sans", tam));
                    break;

                case "FreeMono":
                    editorText.setFont(Font.font("FreeMono", tam));

                    break;
                case "Monospaced":
                    editorText.setFont(Font.font("Monospaced", tam));
                    break;
            }

        }

        public void setSize(ActionEvent actionEvent){

            RadioMenuItem rmi = (RadioMenuItem) actionEvent.getSource();
            String size = rmi.getText();

            String f = editorText.getFont().getFamily();

            switch(size){
                case "16":
                    editorText.setFont(Font.font(f, 16.0));
                    break;
                case "20":
                    editorText.setFont(Font.font(f, 20.0));
                    break;
                case "24":
                    editorText.setFont(Font.font(f, 24.0));
                    break;
            }
        }


    public void btAction(ActionEvent actionEvent) {

        Button btAct = (Button) actionEvent.getSource();
        String accio = btAct.getText();
        switch(accio){
            case "Tallar":
                editorText.cut();
                break;
            case "Copiar":
                editorText.copy();
                break;
            case "Enganxar":
                editorText.paste();
                break;
        }
    }


    public void seleccionaEditar() {

        if(editorText.getSelectedText().equalsIgnoreCase("")){
            copiarItem.setDisable(true);
            enganxarItem.setDisable(true);
        }else{
            copiarItem.setDisable(false);
            enganxarItem.setDisable(false);
        }
    }

    public void sobreEditor() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Sobre el Bloc de Notes en Català");
        alert.setTitle("BLOC DE NOTES EN CATALÀ");
        alert.setContentText("Primers versió en Català disponible per als sistemes operatius de Windows.\n\n" +
                "\tVersió: 4.9\n\tSistema operatiu: Windows 8/10\n\n\n\n\nLlicència concedida per Microsoft Corporation" +
                        " inc a l'usuari:\n\n\tPau");
        alert.showAndWait();
    }

   public void dialogFile(ActionEvent actionEvent) {
       Stage stage = (Stage) root.getScene().getWindow();
       openDialog od = new openDialog();

       if(obrirItem == actionEvent.getSource()){

           editorText.setText(od.openFile(stage));

       }else if(guardarItem == actionEvent.getSource()){
           String txt = editorText.getText();
           od.saveFile(stage, txt);
       }
   }
}
