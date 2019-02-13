package tictactoegame;

import java.awt.Point;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLvsPlayer extends AnchorPane {

    static public int TURN = 0;
    game rob = new game();
    Mediawin mp = new Mediawin();
    
    HashMap<Point, String> hmap = new HashMap<>();
    Stage stage = TictactoeGame.stage;
    Stage st = new Stage();
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
    protected final Button backBtn;
    protected final Button resetBtn;
    protected final Label label;
    protected final MenuBar menuBar;
    protected final Menu menu;

    protected final ImageView imageView;
       protected final ImageView imageView0;

    public FXMLvsPlayer() {
       

        imageView = new ImageView();
               imageView0 = new ImageView();
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
        backBtn = new Button();
        resetBtn = new Button();
        label = new Label();
        menuBar = new MenuBar();
        menu = new Menu();

        setId("AnchorPane");
         setPrefHeight(581.0);
        setPrefWidth(569.0);

    
        setStyle("-fx-background-color: #E82C0C;");
        imageView0.setFitHeight(382.0);
        imageView0.setFitWidth(432.0);
        imageView0.setLayoutX(90.0);
        imageView0.setLayoutY(-2.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getClassLoader().getResource("images/grid.png").toExternalForm()));

        imageView.setFitHeight(638.0);
        imageView.setFitWidth(587.0);
      //  imageView.setLayoutX(90.0);
        imageView.setLayoutY(-3.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("images/bb.png").toExternalForm()));

         gridPane.setLayoutX(70.0);
        gridPane.setLayoutY(28.0);
        gridPane.setPrefHeight(322.0);
        gridPane.setPrefWidth(412.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
        button.setMnemonicParsing(false);
        button.setOpacity(0.62);
        button.setPrefHeight(80.0);
        button.setPrefWidth(90.0);
        button.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
        button.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button0, 1);
        GridPane.setHalignment(button0, javafx.geometry.HPos.CENTER);
        button0.setMnemonicParsing(false);
        button0.setOpacity(0.62);
        button0.setPrefHeight(80.0);
        button0.setPrefWidth(90.0);
        button0.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
        button0.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button1, 2);
        GridPane.setHalignment(button1, javafx.geometry.HPos.CENTER);
        button1.setMnemonicParsing(false);
        button1.setOpacity(0.62);
        button1.setPrefHeight(80.0);
        button1.setPrefWidth(90.0);
        button1.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
        button1.setStyle("-fx-background-color: transparent;");

        GridPane.setHalignment(button2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setOpacity(0.62);
        button2.setPrefHeight(80.0);
        button2.setPrefWidth(90.0);
        button2.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
                button2.setStyle("-fx-background-color: transparent;");


        GridPane.setColumnIndex(button3, 1);
        GridPane.setHalignment(button3, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setOpacity(0.62);
        button3.setPrefHeight(80.0);
        button3.setPrefWidth(90.0);
        button3.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
                button3.setStyle("-fx-background-color: transparent;");


        GridPane.setColumnIndex(button4, 2);
        GridPane.setHalignment(button4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setOpacity(0.62);
        button4.setPrefHeight(80.0);
        button4.setPrefWidth(90.0);
        button4.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
                button4.setStyle("-fx-background-color: transparent;");


        GridPane.setHalignment(button5, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button5, 2);
        button5.setMnemonicParsing(false);
        button5.setOpacity(0.62);
        button5.setPrefHeight(80.0);
        button5.setPrefWidth(90.0);
        button5.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
                button5.setStyle("-fx-background-color: transparent;");


        GridPane.setColumnIndex(button6, 1);
        GridPane.setHalignment(button6, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setOpacity(0.62);
        button6.setPrefHeight(80.0);
        button6.setPrefWidth(90.0);
        button6.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
                button6.setStyle("-fx-background-color: transparent;");


        GridPane.setColumnIndex(button7, 2);
        GridPane.setHalignment(button7, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setOpacity(0.62);
        button7.setPrefHeight(80.0);
        button7.setPrefWidth(90.0);
        button7.setTextFill(javafx.scene.paint.Color.valueOf("#a7a7a5"));
                button7.setStyle("-fx-background-color: transparent;");


          backBtn.setLayoutX(500.0);
         backBtn.setLayoutY(13.0);
         backBtn.setMnemonicParsing(false);
         backBtn.setPrefHeight(50.0);
         backBtn.setPrefWidth(55.0);
         backBtn.setStyle("-fx-background-radius: 150px;");
         backBtn.setStyle("-fx-background-color: transparent;");
        Image backbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/back.png"));
        backBtn.setGraphic(new ImageView(backbtn));
          backBtn.setOnAction((event) -> {
              stage.setScene(new Scene(new entranceBase()));
          
        });
        
        resetBtn.setAlignment(javafx.geometry.Pos.CENTER);
        resetBtn.setLayoutX(223.0);
        resetBtn.setLayoutY(460.0);
        resetBtn.setMnemonicParsing(false);
        resetBtn.setPrefHeight(50.0);
        resetBtn.setPrefWidth(100.0);
         resetBtn.setStyle("-fx-background-radius: 150px;");
         resetBtn.setStyle("-fx-background-color: transparent;");
        Image resetbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/reset.png"));
        resetBtn.setGraphic(new ImageView(resetbtn));
       
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(89.0);
        label.setLayoutY(420.0);
        label.setOpacity(0.8);
        label.setPrefHeight(38.0);
        label.setPrefWidth(370.0);
        label.setStyle("-fx-background-color: #A9A9A9#DCDCDC;");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fff200"));
        label.setFont(new Font("Times New Roman Bold", 32.0));
                label.setStyle("-fx-background-color: transparent;");


        
        resetBtn.setStyle("-fx-background-radius: 150px;");
     resetBtn.setStyle("-fx-background-color: transparent;");
       // button9.setText("->");
      //  button9.setFont(new Font(18.0));
       resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                hmap.clear();
                reset();
                playerOne();
            }
        });

      
      
      

    
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
        getChildren().add(label);
        getChildren().add(backBtn);
        getChildren().add(resetBtn);
        stage.setResizable(false);

    }

    public void playerOne() {

       
        EventHandler<ActionEvent> buttonHandler;
        buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button node = (Button) event.getSource();
                node.setDisable(true);
                if (TURN == 0) {
                    Image imageO;
                    ImageView img;
                    imageO = new Image(getClass().getClassLoader().getResource("images/oo.png").toExternalForm());
                    img = new ImageView(imageO);
                            img.setFitHeight(node.getHeight() - 10);
                            img.setFitWidth(node.getWidth());
                            img.setPreserveRatio(true);
                            node.setGraphic(img);
                            TURN += 1;
                            int row, col;
                            if (gridPane.getRowIndex(node) == null) {
                                row = 0;
                            } else {
                                row = gridPane.getRowIndex(node);
                            }
                            if (gridPane.getColumnIndex(node) == null) {
                                col = 0;
                            } else {
                                col = gridPane.getColumnIndex(node);
                            }
                            hmap.put(new Point(col, row), "o");
                            
                            int x = rob.checkWin(hmap);
                            if (x == 0) {
                                playerTwo();
                            } else {
                                try {
                                    mp.start(st);
                                    if (x > 100) {
                                        setLabel("X wins");
                                    } else {
                                        setLabel("O wins");
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(FXMLvsPlayer.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                }

            }
        };
        ObservableList<Node> childrens = gridPane.getChildren();
        childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
            but.setOnAction(buttonHandler);
        });
    }

    public void playerTwo() {
        if (hmap.size() >= 9) {
            setLabel("Draw");
        } else {
            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Button node = (Button) event.getSource();
                    node.setDisable(true);
                    if (TURN == 1) {
                         Image imageX;
                    ImageView img;
                    imageX = new Image(getClass().getClassLoader().getResource("images/xx.png").toExternalForm());
                    img = new ImageView(imageX);
                            img.setFitHeight(node.getHeight() - 10);
                            img.setFitWidth(node.getWidth());
                            img.setPreserveRatio(true);
                            node.setGraphic(img);
                        TURN -= 1;
//                    ObservableList<Node> childrens = gridPane.getChildren();
//                childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
                        int row, col;
                        if (gridPane.getRowIndex(node) == null) {
                            row = 0;
                        } else {
                            row = gridPane.getRowIndex(node);
                        }
                        if (gridPane.getColumnIndex(node) == null) {
                            col = 0;
                        } else {
                            col = gridPane.getColumnIndex(node);
                        }

                        hmap.put(new Point(col, row), "x");

                        int x = rob.checkWin(hmap);
                        if (x != 0) {
                            try {
                                mp.start(st);
                                if (x > 100) {
                                    setLabel("X wins");
                                } else {
                                    setLabel("O wins");
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(FXMLvsPlayer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            playerOne();
                        }

                    }
                }
            };
            ObservableList<Node> childrens = gridPane.getChildren();
            childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
                but.setOnAction(buttonHandler);
            });
        }
    }

    public void setLabel(String s) {
        label.setText(s);
        ObservableList<Node> childrens = gridPane.getChildren();
        childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
            but.setDisable(true);
        });
    }

    private void reset() {
        TURN = 0;
        ObservableList<Node> childrens = gridPane.getChildren();
        childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
            but.setGraphic(null);
            but.setDisable(false);
            label.setText(" ");

        });
    }
}
