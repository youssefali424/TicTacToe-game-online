
package tictactoegame;
import java.io.File;  
import java.net.URL;
import javafx.application.Application;  
import static javafx.application.Application.launch;
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.scene.text.Font;
import javafx.stage.Stage;  
import javafx.stage.WindowEvent;
public class Medialose extends Application  
{  
  
    @Override  
    public void start(Stage primaryStage) throws Exception { 
      


        // TODO Auto-generated method stub  
        //Initialising path of the media file, replace this with your file path   
     /*   String path = "images/lose.mp4";  
          
        //Instantiating Media class  
        Media media = new Media(new File(path).toURI().toString());  
          
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
          
        //Instantiating MediaView class   
        MediaView mediaView = new MediaView(mediaPlayer);  */
     
  URL url =getClass().getClassLoader().getResource("images/lose.mp4");
 Media media = new Media(url.toString());
 MediaPlayer mediaPlayer = new MediaPlayer(media);
 MediaView mediaView = new MediaView(mediaPlayer);
 mediaPlayer.setAutoPlay(true);  
          
        //by setting this property to true, the Video will be played   
        mediaPlayer.setAutoPlay(true);  
       

          
        //setting group and scene   
        Group root = new Group();  
        root.getChildren().add(mediaView);  
        Scene scene = new Scene(root,300,200);  
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Playing video");  
        primaryStage.show();  
        primaryStage.setResizable(false);
                  primaryStage.setOnCloseRequest((WindowEvent event1) -> {
      mediaPlayer.dispose();
    });
    }  
    public static void main(String[] args) {  
        launch(args);  
    } 

      
} 