package tictactoegame;

import java.util.logging.Handler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class entranceBase extends Pane {
      Stage stage = TictactoeGame.stage;

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final TextField UserNameField;
    protected final TextField PasswordField;
    protected final Button LogInButton;
    protected final Button RegisterButton;
    protected final Button PlayOfflineButton;
    protected final Button PlayOfflineVsComputer ;
        protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItem;
    protected final MenuItem menuItem0;
    public boolean click = false;

    public entranceBase() {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        UserNameField = new TextField();
        PasswordField = new TextField();
        LogInButton = new Button();
        RegisterButton = new Button();
        PlayOfflineButton = new Button();
        PlayOfflineVsComputer = new Button();
              menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();

        setId("Name");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
          setPrefHeight(581.0);
        setPrefWidth(569.0);
      //  setStyle("-fx-background-color: #7FEE73;");
         imageView.setFitHeight(638.0);
        imageView.setFitWidth(587.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("images/bb.png").toExternalForm()));

    
        //     imageView.setStyle("-fx-background-color: #FF0000");
// imageView.setImage(new Image(getClass().getResource("pp.png").toExternalForm()));

        label.setLayoutX(94.0);
        label.setLayoutY(101.0);
        label.setText("user name");
     label.setFont(new Font("Cambria", 24.0));  
       label.setTextFill(Color.web("#fff200"));
   // label.setStyle("-fx-background-color: #FFF200;");
       // label.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));

        label0.setLayoutX(94.0);
        label0.setLayoutY(154.0);
        label0.setText("password");
        label0.setFont(new Font("Cambria", 24.0));
     //   label0.setStyle("-fx-background-color: #FFF200;");
        label0.setTextFill(Color.web("#fff200"));
       // label0.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));

        UserNameField.setId("TextField");
        UserNameField.setLayoutX(200.0);
        UserNameField.setLayoutY(101.0);
       UserNameField.setStyle(" -fx-text-inner-color: yellow; -fx-border-color: #fff200; -fx-background-color: transperant;");
     //   UserNameField.setStyle("-fx-border-color: #fff200;");
     
        UserNameField.setFont(new Font("Cambria", 20.0));
     //   label0.setStyle("-fx-background-color: #FFF200;");
       // UserNameField.setTextFill(Color.web("#fff200"));

        PasswordField.setId("PasswordField");
        PasswordField.setLayoutX(200.0);
        PasswordField.setLayoutY(146.0);
     
      PasswordField.setStyle(" -fx-text-inner-color: yellow; -fx-border-color: #fff200; -fx-background-color: transperant;");
   //     PasswordField.setStyle("-fx-text-inner-color: yellow;");
                 PasswordField.setFont(new Font("Cambria", 20.0));

        LogInButton.setLayoutX(79.0);
        LogInButton.setLayoutY(303.0);
        LogInButton.setMnemonicParsing(false);
        LogInButton.setPrefHeight(37.0);
        LogInButton.setPrefWidth(186.0);
        LogInButton.setStyle("-fx-background-color: #FFF200;");

        LogInButton.setId("LogIn");

        LogInButton.setMnemonicParsing(false);
        LogInButton.setText("Log In");
        LogInButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {
                boolean x = false;
                int id=0;int score=0;
                if (UserNameField.getText().trim() != null && PasswordField.getText().trim() != null) {
                    x = new LogIn().login(UserNameField.getText().trim(), PasswordField.getText().trim());
                    id=new Record().getId(UserNameField.getText());
                    score=new Record().getScore(UserNameField.getText());
                    System.out.println("the CheckFlag is " + x);
                }
                if (x == false) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("SOMETHING WHENT WRONG PLEASE TRY AGAIN");
                    alert.showAndWait();
                } else {

                    //Stage stage= TicTac_DataBase.getStage();
                    onlineBase Base=new onlineBase(UserNameField.getText(),id,score);
                    Base.set();
                    Scene scene = new Scene(Base);
                    TictactoeGame.stage.setScene(scene);
                    

                }
            }
        });

        RegisterButton.setLayoutX(311.0);
        RegisterButton.setLayoutY(303.0);
        RegisterButton.setMnemonicParsing(false);
        RegisterButton.setPrefHeight(37.0);
        RegisterButton.setPrefWidth(186.0);
        RegisterButton.setMnemonicParsing(false);
        RegisterButton.setText("Registeer");
        RegisterButton.setStyle("-fx-background-color: #FFF200;");
        RegisterButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Scene scene = new Scene(new regestrationdbBase());
                TictactoeGame.stage.setScene(scene);
                TictactoeGame.stage.setScene(scene);
            }
        });
        
        
        PlayOfflineButton.setLayoutY(420.0);
        PlayOfflineVsComputer.setLayoutY(420.0);
         PlayOfflineButton.setLayoutX(79.0);
        PlayOfflineVsComputer.setLayoutX(311.0);
         PlayOfflineButton.setPrefHeight(37.0);
        PlayOfflineButton.setPrefWidth(186.0);
         PlayOfflineVsComputer.setPrefHeight(37.0);
        PlayOfflineVsComputer.setPrefWidth(186.0);
        PlayOfflineVsComputer.setStyle("-fx-background-radius: 30px;");
        PlayOfflineVsComputer.setStyle("-fx-background-color: #fff200;");
        PlayOfflineButton.setStyle("-fx-background-radius: 30px;");
        PlayOfflineButton.setStyle("-fx-background-color: #fff200;");
        PlayOfflineButton.setText("Play with frind");
        PlayOfflineVsComputer.setText("single player");
        
//         menuBar.setLayoutX(170.0);
//        menuBar.setLayoutY(420.0);
//        menuBar.setPrefHeight(37.0);
//        menuBar.setPrefWidth(100.0);
//        menuBar.setStyle("-fx-background-radius: 30px;");
//        menuBar.setStyle("-fx-background-color: #fff200;");
//
//        menu.setMnemonicParsing(false);
//        menu.setText("play offline");
//
//        menuItem.setMnemonicParsing(false);
//        menuItem.setText("vs Player");
//
//        menuItem0.setMnemonicParsing(false);
//        menuItem0.setText("vs Computer");

         PlayOfflineButton.setOnAction((event) -> {
            FXMLvsPlayer root = new FXMLvsPlayer();
            root.playerOne();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        });
        PlayOfflineVsComputer.setOnAction((event) -> {
            FXMLVsComputer root = new FXMLVsComputer();
            root.set();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
        });


         getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(UserNameField);
        getChildren().add(PasswordField);
        getChildren().add(LogInButton);
        getChildren().add(RegisterButton);
        getChildren().add(PlayOfflineButton);
        getChildren().add(PlayOfflineVsComputer);
  
//            getChildren().add(menuBar);
//         menu.getItems().add(menuItem);
//        menu.getItems().add(menuItem0);
//        
//        menuBar.getMenus().add(menu);
 

    }
}
