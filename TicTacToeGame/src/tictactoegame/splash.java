package tictactoegame;

import java.io.File;
import java.io.InputStream;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class splash extends AnchorPane {

    Stage stage = TictactoeGame.stage;

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Label logopane;
    protected final Label welcompane;
    protected final Label namepane;
    //   protected final ImageView imageView0;

    public splash() {
        imageView = new ImageView();
        imageView0 = new ImageView();

        //   imageView0 = new ImageView();
        logopane = new Label();
        welcompane = new Label();
        namepane = new Label();

        setId("AnchorPane");
        setPrefHeight(581.0);
        setPrefWidth(569.0);

        imageView.setFitHeight(638.0);
        imageView.setFitWidth(587.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("images/bb.png").toExternalForm()));

//        InputStream stream = getClass().getClassLoader().getResourceAsStream("bb.jpg");
//        Image newImage = new Image(stream);
//        imageView.setImage(newImage);

        imageView0.setFitHeight(291.0);
        imageView0.setFitWidth(219.0);
        imageView0.setLayoutX(202.0);
        imageView0.setLayoutY(24.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getClassLoader().getResource("images/hh.png").toExternalForm()));

        TranslateTransition tt = new TranslateTransition(Duration.millis(2000), imageView0);
        tt.setByY(700);
        tt.play();

        welcompane.setLayoutX(68.0);
        welcompane.setLayoutY(421.0);
        welcompane.setPrefHeight(52.0);
        welcompane.setPrefWidth(490.0);
        welcompane.setText("Welcome to iti play station");
        welcompane.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        welcompane.setTextFill(Color.web("#fff200"));
        welcompane.setFont(new Font("Bell MT", 43.0));
        welcompane.setVisible(false);
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(2000), welcompane);
        tt1.setByY(700);
        tt1.play();

        namepane.setLayoutX(156.0);
        namepane.setLayoutY(329.0);
        namepane.setPrefHeight(48.0);
        namepane.setPrefWidth(314.0);
        namepane.setText("  Tic Tac Toe");
        namepane.setTextFill(Color.web("#fff200"));
        namepane.setFont(new Font("Bodoni MT Bold", 52.0));
        namepane.setVisible(false);
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(2000), namepane);
        tt2.setByY(700);
        tt2.play();

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(logopane);
        getChildren().add(welcompane);
        getChildren().add(namepane);
      //  stage.setResizable(false);
        //      getChildren().add(imageView0);
        imageView0.setVisible(true);
      
        tt.setOnFinished(event -> {
            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(1), imageView0);
            translateTransition1.setByY(-700);
            translateTransition1.play();

            tt1.setOnFinished(event1 -> {

                namepane.setVisible(true);

                TranslateTransition translateTransition11 = new TranslateTransition(Duration.seconds(1), namepane);
                translateTransition11.setByY(-700);
                translateTransition11.play();

                translateTransition11.setOnFinished(event2 -> {

                    welcompane.setVisible(true);
                    TranslateTransition translateTransition111 = new TranslateTransition(Duration.seconds(1), welcompane);
                    translateTransition111.setByY(-700);
                    translateTransition111.play();

                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(4), imageView0);
                    FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(4), welcompane);
                    FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(4), namepane);
                    translateTransition111.setOnFinished(event4 -> {

                        fadeTransition.setFromValue(1);
                        fadeTransition.setToValue(0.01);
                        fadeTransition.play();

                        fadeTransition1.setFromValue(1);
                        fadeTransition11.setFromValue(1);
                        fadeTransition1.setToValue(0.01);
                        fadeTransition11.setToValue(0.01);
                        fadeTransition1.play();
                        fadeTransition11.play();

                    }
                    );

                    fadeTransition11.setOnFinished(event5 -> {
                    stage.setScene(new Scene(new entranceBase()));
                    

                    });

                });
            });

        });

    }

}
