package tictactoegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class regestrationdbBase extends Pane {
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Label label;
    protected final Label label0;
    protected final TextField UserNameField;
    protected final TextField PasswordField;
    protected final Label label1;
    protected final TextField NameField;
    protected final Button RegisterButton;
    protected final Button BackButton;

    public regestrationdbBase() {

        label = new Label();
        label0 = new Label();
        UserNameField = new TextField();
        PasswordField = new TextField();
        label1 = new Label();
        NameField = new TextField();
        RegisterButton = new Button();
        BackButton = new Button();
            imageView = new ImageView();
             imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
         setPrefHeight(581.0);
        setPrefWidth(569.0);
      //  setStyle("-fx-background-color: #7FEE73;");
        imageView.setFitHeight(638.0);
        imageView.setFitWidth(587.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("images/bb.png").toExternalForm()));

       

        label.setId("Name");
        label.setLayoutX(127.0);
        label.setLayoutY(115.0);
        label.setText("User Name");
         label.setFont(new Font("Cambria", 24.0));  
       label.setTextFill(Color.web("#fff200"));

        label0.setId("Password");
        label0.setLayoutX(129.0);
        label0.setLayoutY(168.0);
        label0.setText("Password");
         label0.setFont(new Font("Cambria", 24.0));  
       label0.setTextFill(Color.web("#fff200"));

        UserNameField.setId("TextField");
        UserNameField.setLayoutX(300.0);
        UserNameField.setLayoutY(111.0);
        UserNameField.setStyle(" -fx-text-inner-color: yellow; -fx-border-color: #fff200; -fx-background-color: transperant;");
     //   UserNameField.setStyle("-fx-border-color: #fff200;");
     
        UserNameField.setFont(new Font("Cambria", 20.0));

        PasswordField.setId("PasswordField");
        PasswordField.setLayoutX(300.0);
        PasswordField.setLayoutY(156.0);
        PasswordField.setStyle(" -fx-text-inner-color: yellow; -fx-border-color: #fff200; -fx-background-color: transperant;");
     //   UserNameField.setStyle("-fx-border-color: #fff200;");
     
        PasswordField.setFont(new Font("Cambria", 20.0));

        label1.setId("Name");
        label1.setLayoutX(127.0);
        label1.setLayoutY(79.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(120.0);
        label1.setText("Name");
         label1.setFont(new Font("Cambria", 24.0));  
       label1.setTextFill(Color.web("#fff200"));

        NameField.setId("TextField");
        NameField.setLayoutX(300.0);
        NameField.setLayoutY(75.0);
        NameField.setStyle(" -fx-text-inner-color: yellow; -fx-border-color: #fff200; -fx-background-color: transperant;");
     //   UserNameField.setStyle("-fx-border-color: #fff200;");
     
        NameField.setFont(new Font("Cambria", 20.0));

        
          RegisterButton.setLayoutX(217.0);
        RegisterButton.setLayoutY(350.0);
        RegisterButton.setMnemonicParsing(false);
        RegisterButton.setPrefHeight(37.0);
        RegisterButton.setPrefWidth(186.0);
        RegisterButton.setMnemonicParsing(false);
        RegisterButton.setStyle("-fx-background-color: #FFF200;");
       
     //   RegisterButton.setStyle("-fx-background-color: #A8A5D5;"); 
        
        
        RegisterButton.setText("Get Registered NOW");
        RegisterButton.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent t) {
           boolean x= false;
           if (NameField.getText().trim()!= null && UserNameField.getText().trim() != null && PasswordField.getText().trim()!= null )  
          {
           x =new Register().register(NameField.getText().trim() ,UserNameField.getText().trim() ,PasswordField.getText().trim());
           
           System.out.println("the CheckFlag is "+x);
          }
           if (x== false)
           {   Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information Dialog");
           alert.setHeaderText(null);
           alert.setContentText("SOMETHING WHENT WRONG PLEASE TRY AGAIN");
           alert.showAndWait();
           }
           else {
                    Scene scene =new Scene(new entranceBase());
                    TictactoeGame.stage.setScene(scene);
                   // TictactoeGame.stage.setScene(scene);
           }
        }
        });
        
        
         BackButton.setLayoutX(500.0);
         BackButton.setLayoutY(13.0);
         BackButton.setMnemonicParsing(false);
         BackButton.setPrefHeight(50.0);
         BackButton.setPrefWidth(55.0);
         BackButton.setStyle("-fx-background-radius: 150px;");
         BackButton.setStyle("-fx-background-color: transparent;");
        Image backbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/back.png"));
        BackButton.setGraphic(new ImageView(backbtn));
        BackButton.setOnAction((event) -> {
        TictactoeGame.stage.setScene(new Scene(new entranceBase()));
          
        });

     
        
        getChildren().add(imageView);
       // getChildren().add(imageView0);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(UserNameField);
        getChildren().add(PasswordField);
        getChildren().add(label1);
        getChildren().add(NameField);
        getChildren().add(RegisterButton);
        getChildren().add(BackButton);

    }
}
