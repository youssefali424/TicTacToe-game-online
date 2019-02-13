/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author SherifAbdelmoniem
 */
public class offlineMode extends AnchorPane {

    Stage stage = TictactoeGame.stage;
    //  static public int TURN=0;

    protected final ImageView imageView;
    protected final Button button;
    protected final Button button1;
    //   Stage stage = TictactoeGame.stage; 

    public offlineMode() {
        imageView = new ImageView();
        button = new Button();
        button1 = new Button();

        setId("AnchorPane");
        setPrefHeight(650.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #E82C0C;");

          imageView.setFitHeight(650.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(-1.0);
        imageView.setLayoutY(-3.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("bg.png").toExternalForm()));
        button.setLayoutX(180.0);
        button.setLayoutY(140.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(37.0);
        button.setPrefWidth(186.0);
        button.setMnemonicParsing(false);
        button.setText("play with friend");
        button.setStyle("-fx-background-color: #A8A5D5;");

        button.setOnAction((event) -> {
            FXMLvsPlayer root = new FXMLvsPlayer();
            root.playerOne();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        });

        button1.setLayoutX(180.0);
        button1.setLayoutY(260.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(37.0);
        button1.setPrefWidth(186.0);
        button1.setOnAction((event) -> {
            FXMLVsComputer root = new FXMLVsComputer();
            root.set();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        });

        button1.setStyle("-fx-background-color: #A8A5D5;");
        button1.setText("play with computer");
        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(button1);

    }

}
