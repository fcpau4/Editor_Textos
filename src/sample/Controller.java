package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Font;

public class Controller {

        public MenuBar barMenu;
        public Menu fitxerMenu;
        public MenuItem sortirItem;


        public Menu editarMenu;
        public MenuItem copiarItem;
        public MenuItem tallarItem;
        public MenuItem enganxarItem;
        public MenuItem desfesItem;

        public Menu opcionsMenu;

        public Menu fontMenu;

        public MenuItem nimbusSansL;
        public MenuItem bitstreamCharter;
        public MenuItem freeMono;

        public Menu tamanyMenu;
        public MenuItem deu;
        public MenuItem dotze;
        public MenuItem catorze;

        public Menu ajudaMenu;

        public TextArea editorText;

        public void salirAction(ActionEvent actionEvent) {
                Platform.exit();
        }

        public void copiarAction(ActionEvent actionEvent) {
                editorText.copy();
        }

        public void tallarAction(ActionEvent actionEvent){
                editorText.cut();
        }

        public void enganxarAction(ActionEvent actionEvent){
                editorText.paste();
        }

        public void desferAction(ActionEvent actionEvent) {
                editorText.undo();
        }


        public void setFont(ActionEvent actionEvent) {
            MenuItem mi = (MenuItem) actionEvent.getSource();



            String font = mi.getText();


            switch (font){

                case "Nimbus Sans L":
                    editorText.setFont(Font.font(font));
                    break;
                case "Bitstream Charter":
                    editorText.setFont(Font.font(font));
                    break;
                case "FreeMono":
                    editorText.setFont(Font.font(font));
                    break;



            }
        }
}
