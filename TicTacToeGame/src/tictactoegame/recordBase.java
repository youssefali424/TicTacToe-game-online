package tictactoegame;

import java.awt.Point;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class recordBase extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final ListView listView;
    protected final Button playBtn;
    protected final Button pauseBtn;
    protected final Button backBtn;
        protected final ImageView imageView;
         protected final ImageView imageView0;
    Timeline timeline;
    Image imageX;
    Image imageO;

    Stage stage = TictactoeGame.stage;
    int id=0;//dah raqmo el mafrood fel daatbase 7yt3'yer
    public recordBase(int num) {
        id=num;
        
        imageO = new Image(getClass().getClassLoader().getResource("images/oo.png").toExternalForm());

        
        imageX = new Image(getClass().getClassLoader().getResource("images/xx.png").toExternalForm());
           imageView = new ImageView();
           imageView0 = new ImageView();
        timeline = new Timeline();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        listView = new ListView();
        playBtn = new Button();
        pauseBtn = new Button();
        backBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(496.0);
        setPrefWidth(502.0);
        
        imageView.setFitHeight(503.0);
        imageView.setFitWidth(502.0);
        imageView.setLayoutY(-4.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
          imageView.setImage(new Image(getClass().getClassLoader().getResource("images/bb.png").toExternalForm()));

 imageView0.setFitHeight(385.0);
        imageView0.setFitWidth(391.0);
        imageView0.setLayoutX(70.0);
        imageView0.setLayoutY(139.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getClassLoader().getResource("images/grid.png").toExternalForm()));

   

          gridPane.setLayoutX(44.0);
        gridPane.setLayoutY(187.0);
        gridPane.setOpacity(0.58);
        gridPane.setPrefHeight(292.0);
        gridPane.setPrefWidth(441.0);
        //gridPane.setStyle("-fx-background-image: C:\Users\SherifAbdelmoniem\Desktop\kk;");
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(88.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(166.4000244140625);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(94.0000244140625);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(135.20001220703125);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(118.79997558593746);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(88.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(110.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(110.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(110.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(110.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);


        button.setMnemonicParsing(false);
        button.setOpacity(0.52);
        button.setPrefHeight(88.0);
        button.setPrefWidth(120.0);
        button.setStyle("-fx-background-color: #A7A7A5;");
                button.setStyle("-fx-background-color: transparent;");
        GridPane.setColumnIndex(button0, 1);
        button0.setMnemonicParsing(false);
        button0.setOpacity(0.52);
        button0.setPrefHeight(88.0);
        button0.setPrefWidth(120.0);
        button0.setStyle("-fx-background-color: #A7A7A5;");
                button0.setStyle("-fx-background-color: transparent;");
        
        GridPane.setColumnIndex(button1, 2);
        button1.setMnemonicParsing(false);
        button1.setOpacity(0.52);
        button1.setPrefHeight(88.0);
        button1.setPrefWidth(120.0);
        button1.setStyle("-fx-background-color: #A7A7A5;");
                button1.setStyle("-fx-background-color: transparent;");
        
        GridPane.setRowIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setOpacity(0.52);
        button2.setPrefHeight(88.0);
        button2.setPrefWidth(120.0);
        button2.setStyle("-fx-background-color: #A7A7A5;");
            button2.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setOpacity(0.52);
        button3.setPrefHeight(88.0);
        button3.setPrefWidth(120.0);
        button3.setStyle("-fx-background-color: #A7A7A5;");
            button3.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button4, 2);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setOpacity(0.53);
        button4.setPrefHeight(88.0);
        button4.setPrefWidth(120.0);
        button4.setStyle("-fx-background-color: #A7A7A5;");
            button4.setStyle("-fx-background-color: transparent;");

        GridPane.setRowIndex(button5, 2);
        button5.setMnemonicParsing(false);
        button5.setOpacity(0.52);
        button5.setPrefHeight(88.0);
        button5.setPrefWidth(120.0);
        button5.setStyle("-fx-background-color: #A7A7A5;");
            button5.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button6, 1);
        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setOpacity(0.52);
        button6.setPrefHeight(88.0);
        button6.setPrefWidth(120.0);
        button6.setStyle("-fx-background-color: #A7A7A5;");
            button6.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setOpacity(0.52);
        button7.setPrefHeight(88.0);
        button7.setPrefWidth(120.0);
        button7.setStyle("-fx-background-color: #A7A7A5;");
            button7.setStyle("-fx-background-color: transparent;");

        listView.setLayoutX(42.0);
        listView.setLayoutY(30.0);
        listView.setPrefHeight(110.0);
        listView.setPrefWidth(279.0);

        
             backBtn.setLayoutX(450.0);
        backBtn.setLayoutY(13.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(50.0);
        backBtn.setPrefWidth(55.0);
        backBtn.setStyle("-fx-background-radius: 150px;");
        backBtn.setStyle("-fx-background-color: transparent;");
        Image backbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/back.png"));
        backBtn.setGraphic(new ImageView(backbtn));
        
        playBtn.setLayoutX(344.0);
        playBtn.setLayoutY(30.0);
        playBtn.setMnemonicParsing(false);
        playBtn.setPrefHeight(48.0);
        playBtn.setPrefWidth(118.0);
        playBtn.setText("Play");
        playBtn.setTextFill(Color.web("#fff200"));
        playBtn.setFont(new Font("Cambria", 14.0));
         playBtn.setStyle("-fx-background-radius: 150px;");
         playBtn.setStyle("-fx-background-color: transparent;");
        Image playbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/play.png"));
        playBtn.setGraphic(new ImageView(playbtn));
       

        pauseBtn.setLayoutX(344.0);
        pauseBtn.setLayoutY(107.0);
        pauseBtn.setMnemonicParsing(false);
        pauseBtn.setPrefHeight(48.0);
        pauseBtn.setTextFill(Color.web("#fff200"));
        pauseBtn.setPrefWidth(122.0);
        pauseBtn.setText("pose");
        pauseBtn.setFont(new Font("Cambria", 14.0));
         pauseBtn.setStyle("-fx-background-radius: 150px;");
         pauseBtn.setStyle("-fx-background-color: transparent;");
        Image pausebtn = new Image(getClass().getClassLoader().getResourceAsStream("images/pause.png"));
        pauseBtn.setGraphic(new ImageView(pausebtn));
            getChildren().add(imageView);
            getChildren().add(imageView0);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        
        getChildren().add(gridPane);
        getChildren().add(listView);
        getChildren().add(playBtn);
        getChildren().add(pauseBtn);
      //  getChildren().add(backBtn);
        stage.setResizable(false);
        


    }
    
    
    

    public void set() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                List list = new Record().getGameNum(id);
                if (list != null) {
                    listView.getItems().setAll(list);
                    listView.setMouseTransparent(false);
                    listView.setFocusTraversable(true);
                } else {
                    listView.setMouseTransparent(true);
                    listView.setFocusTraversable(false);
                    listView.getItems().setAll("no records");
                }
            }
        });
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                // Your action here
                String listText = (String) listView.getSelectionModel().getSelectedItem();
                System.out.println("Selected item: " + listText);
                if (listText != null && listText != "") {
                    int x = choose("replay game ?");
                    if (x == 1) {

                        timeline.stop();
                        timeline.getKeyFrames().clear();
                        reset();
                        String[] text = listText.split(" ");
                        Duration timepoint = Duration.ZERO;
                        Duration pause = Duration.seconds(1);
                        LinkedHashMap<Point, String> hTemp = new Record().getGame(id, Integer.valueOf(text[1]));
                        if (hTemp != null && !hTemp.isEmpty()) {

                            Iterator it = hTemp.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry pair = (Map.Entry) it.next();
                                Point temp = (Point) pair.getKey();
                                String sign = (String) pair.getValue();
                                timepoint = timepoint.add(pause);
                                KeyFrame keyFrame = new KeyFrame(timepoint, e -> printOnly(temp.x, temp.y, sign));

                                timeline.getKeyFrames().add(keyFrame);

                            }
                        }
                        timeline.play();
                        //timeline.setCycleCount(1);
                    }
                }

            }
        });
        pauseBtn.setOnAction((event) -> {
            timeline.pause();
        });
        playBtn.setOnAction((event) -> {
            timeline.play();
        });
          backBtn.setOnAction((event)->{
        stage.setScene(new Scene(new onlineBase("", id, id)));
        });
        
    }

    public void printOnly(int x, int y, String sign) {
        System.out.println("in print");

        //if (TestTic.TURN == 1) {
        //if(!end){
        ImageView img;
        if (sign.matches("x")) {
            img = new ImageView(imageX);
        } else {
            img = new ImageView(imageO);
        }

        ObservableList<Node> childrens = gridPane.getChildren();
        childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
            int row, col;
            if (gridPane.getRowIndex(but) == null) {
                row = 0;
            } else {
                row = gridPane.getRowIndex(but);
            }
            if (gridPane.getColumnIndex(but) == null) {
                col = 0;
            } else {
                col = gridPane.getColumnIndex(but);
            }
            if (row == y && col == x) {
                img.setFitHeight(but.getHeight() - 10);
                img.setFitWidth(but.getWidth());
                img.setPreserveRatio(true);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        but.setGraphic(img);
                        but.setDisable(true);
                    }
                });

            }
        });
        // }

        //}
    }

    public int choose(String text) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(text);

        ButtonType buttonTypeOne = new ButtonType("yes");
        ButtonType buttonTypeTwo = new ButtonType("no");

        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            return 1;
        } else if (result.get() == buttonTypeTwo) {
            return 0;
        }
        return -1;
    }

    public void reset() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ObservableList<Node> childrens = gridPane.getChildren();
                childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
                    but.setGraphic(null);
                    but.setDisable(false);

                });
            }
        });
    }
}
