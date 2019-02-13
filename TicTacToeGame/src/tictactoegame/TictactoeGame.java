/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author SherifAbdelmoniem
 */
public class TictactoeGame extends Application {
        static public int TURN=0;

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        splash ui = new splash();

        Scene scene = new Scene(ui);
        
        
        /*
         URL url =getClass().getClassLoader().getResource("images/l4.mp3");
 Media sound = new Media(url.toString());
 MediaPlayer mediaPlayer = new MediaPlayer(media);
 MediaView mediaView = new MediaView(mediaPlayer);
 mediaPlayer.setAutoPlay(true);  
          
        */

     //   String musicFile = "C:\\Users\\SherifAbdelmoniem\\Desktop\\14.mp3";     // For example
//
      // Media sound = new Media(new File(musicFile).toURI().toString());
        /*URL url =getClass().getClassLoader().getResource("images/l4.mp3");
        Media sound = new Media(getClass().getClassLoader().getResource("images/l4.mp3").toExternalForm());
// URL url =getClass().getClassLoader().getResource("images/l4.mp4");
// Media sound = new Media(url.toString());
       MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);  */

        stage.setScene(scene);
     //   stage.setResizable(false);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
