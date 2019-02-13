
package tictactoegame;
import java.net.URL;
import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.stage.Stage;  
import javafx.stage.WindowEvent;
public class Mediawin extends Application  
{  
  
    @Override  
    public void start(Stage primaryStage) throws Exception { 
      

        
        URL url =getClass().getClassLoader().getResource("images/win.mp4");
 Media media = new Media(url.toString());
 MediaPlayer mediaPlayer = new MediaPlayer(media);
 MediaView mediaView = new MediaView(mediaPlayer);
 mediaPlayer.setAutoPlay(true);  
       

          
        //setting group and scene   
        Group root = new Group();  
        root.getChildren().add(mediaView);  
        Scene scene = new Scene(root,400,360);  
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