package sample;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;

public class openDialog {

    void saveFile(Stage stage, String content){
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guarda l'arxiu");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files", "*txt"));
            File newFile = fileChooser.showSaveDialog(stage);
            if (newFile != null) {
                readFile(newFile);
                writeFile(newFile, content);
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    String openFile(Stage stage) {
    try {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Obre el fitxer");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        String content = "";
        if (selectedFile != null) {
            content = readFile(selectedFile);
            stage.setTitle(selectedFile.getName() + " - " + selectedFile.getAbsolutePath());
        }

        return content;
    }catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
        return null;
   }

   private String readFile(File f){

       try {
           BufferedReader br = new BufferedReader(new FileReader(f));
           String text = "";
           String line;

           while((line=br.readLine())!=null){
               text+=line+"\n";
           }

           br.close();
           return text;

       } catch (IOException e) {
           e.printStackTrace();
       }
       return null;
   }

    private void writeFile(File f, String content){

        BufferedWriter bw;
        try {
            bw=new BufferedWriter(new FileWriter(f));
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
