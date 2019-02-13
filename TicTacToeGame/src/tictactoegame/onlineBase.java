package tictactoegame;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
import static tictactoegame.TictactoeGame.stage;

public class onlineBase extends AnchorPane {
    //  static public int TURN = 0;
    
    Mediawin mwin = new Mediawin();
    Medialose mlose =new Medialose();
    Stage st  = new Stage();

    protected final ImageView imageView;
    protected final ImageView imageView0;
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
    protected final ListView onlineList;
    protected final ListView requestList;
    protected final Button logoutBtn;
    protected final Button recordsBtn;
    protected final Button recordNowBtn;
    protected final Button buttonExit;
    protected final Button backBtn;
    protected final Label dbscore;
    protected final Label scoreX;
    protected final Label scoreY;
    protected final Label opName;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label labelsx;
    protected final Label labelso;
    
    protected final Label turn;
    OnlinePlayer player;
    public int myScore = 0;
    public int oppScore = 0;
    int score;int id;
    Image imageX;
    Image imageO;

    public onlineBase(String n, int id, int score) 
    {
        this.score = score;
        imageView = new ImageView();
        imageView0 = new ImageView();
        this.id=id;
        player = new OnlinePlayer(this, n);
        player.setId(id);
        // File file = new File("C:\\Users\\youssef ali\\Desktop\\o.png");
        imageO = new Image(getClass().getClassLoader().getResource("images/oo.png").toExternalForm());

        //   File file1 = new File(getClass().getClassLoader().getResource("images/xx.png").toExternalForm());//remove file to constructor reminder
        imageX = new Image(getClass().getClassLoader().getResource("images/xx.png").toExternalForm());

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
        onlineList = new ListView();
        requestList = new ListView();
        logoutBtn = new Button();
        recordsBtn = new Button();
        recordNowBtn = new Button();
        buttonExit = new Button();
        backBtn = new Button();
        dbscore = new Label();
        scoreX = new Label();
        scoreY = new Label();
        opName = new Label();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        labelsx = new Label();
        labelso = new Label();

        turn = new Label();

        setId("AnchorPane");
        setPrefHeight(581.0);
        setPrefWidth(569.0);
        //  setStyle("-fx-background-color: #7FEE73;");
        imageView.setFitHeight(638.0);
        imageView.setFitWidth(599.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getClassLoader().getResource("images/bb.png").toExternalForm()));

        imageView0.setFitHeight(417.0);
        imageView0.setFitWidth(424.0);
        imageView0.setLayoutX(14.0);
        imageView0.setLayoutY(118.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getClassLoader().getResource("images/grid.png").toExternalForm()));

        gridPane.setLayoutX(20.0);
        gridPane.setLayoutY(149.0);
       
        gridPane.setPrefHeight(351.0);
        gridPane.setPrefWidth(441.0);

        //gridPane.setStyle("-fx-background-image: C:\Users\SherifAbdelmoniem\Desktop\kk;");
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(137.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(136.20001220703125);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(216.80003662109374);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(130.60002441406252);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(191.199951171875);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(161.7999755859375);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(88.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(124.00000610351563);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(124.00000610351563);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(110.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(96.79999389648438);

        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label.setLayoutX(160.0);
        label.setLayoutY(21.0);
        label.setPrefHeight(18.0);
        label.setPrefWidth(122.0);
        label.setText("Opponant name");
        label.setTextFill(Color.web("#fff200"));
        label.setFont(new Font("Cambria", 16.0));

        label0.setLayoutX(54.0);
        label0.setLayoutY(22.0);
        label0.setPrefHeight(18.0);
        label0.setPrefWidth(66.0);
        label0.setText("Score");
        label0.setFont(new Font(16.0));
         label0.setTextFill(Color.web("#fff200"));
        label0.setFont(new Font("Cambria", 16.0));

        label1.setLayoutX(472.0);
        label1.setLayoutY(164.0);
        label1.setPrefHeight(18.0);
        label1.setPrefWidth(106.0);
        label1.setText("Online Player");
       // label1.setFont(new Font(16.0));
        label1.setTextFill(Color.web("#fff200"));
        label1.setFont(new Font("Cambria", 16.0));

        label2.setLayoutX(472.0);
        label2.setLayoutY(325.0);
        label2.setPrefHeight(18.0);
        label2.setPrefWidth(106.0);
        label2.setText("Requestes");
 label2.setTextFill(Color.web("#fff200"));
        label2.setFont(new Font("Cambria", 16.0));       
//1 label2.setFont(new Font(16.0));

        button.setMnemonicParsing(false);
        
        button.setPrefHeight(88.0);
        button.setPrefWidth(122.0);
       // button.setStyle("-fx-background-color: #A7A7A5;");
        button.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button0, 1);
        button0.setMnemonicParsing(false);
       
        button0.setPrefHeight(88.0);
        button0.setPrefWidth(117.0);
     //   button0.setStyle("-fx-background-color: #A7A7A5;");
        button0.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button1, 2);
        button1.setMnemonicParsing(false);

        button1.setPrefHeight(88.0);
        button1.setPrefWidth(121.0);
      //  button1.setStyle("-fx-background-color: #A7A7A5;");
        button1.setStyle("-fx-background-color: transparent;");

        GridPane.setRowIndex(button2, 1);
        button2.setMnemonicParsing(false);
        
        button2.setPrefHeight(88.0);
        button2.setPrefWidth(120.0);
      //  button2.setStyle("-fx-background-color: #A7A7A5;");
        button2.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
       
        button3.setPrefHeight(88.0);
        button3.setPrefWidth(118.0);
      //  button3.setStyle("-fx-background-color: #A7A7A5;");
        button3.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button4, 2);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
       
        button4.setPrefHeight(88.0);
        button4.setPrefWidth(120.0);
    //    button4.setStyle("-fx-background-color: #A7A7A5;");
        button4.setStyle("-fx-background-color: transparent;");

        GridPane.setRowIndex(button5, 2);
        button5.setMnemonicParsing(false);
        
        button5.setPrefHeight(88.0);
        button5.setPrefWidth(122.0);
    //    button5.setStyle("-fx-background-color: #A7A7A5;");
        button5.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button6, 1);
        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
     
        button6.setPrefHeight(88.0);
        button6.setPrefWidth(120.0);
    //    button6.setStyle("-fx-background-color: #A7A7A5;");
        button6.setStyle("-fx-background-color: transparent;");

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
       
        button7.setPrefHeight(88.0);
        button7.setPrefWidth(122.0);
    //    button7.setStyle("-fx-background-color: #A7A7A5;");
        button7.setStyle("-fx-background-color: transparent;");

        onlineList.setLayoutX(472.0);
        onlineList.setLayoutY(197.0);
        onlineList.setPrefHeight(128.0);
        onlineList.setPrefWidth(106.0);
      //  onlineList.setTextFill(Color.web("#0076a3"));
       // onlineList.setTextFont(new Font("Cambria", 24.0));
  //    onlineList.setStyle("-fx-background-color: #BBFF00;");
     //   onlineList.setStyle("-fx-background-color: #F594CB;");
onlineList.setStyle(" -fx-text-inner-color: yellow; -fx-border-color: #fff200; -fx-background-color: transperant;");

        requestList.setLayoutX(474.0);
        requestList.setLayoutY(355.0);
        requestList.setPrefHeight(185.0);
        requestList.setPrefWidth(106.0);
       // requestList.setStyle("-fx-background-color: #BBFF00;");
        requestList.setStyle(" -fx-text-inner-color: yellow; -fx-border-color: #fff200; -fx-background-color: transperant;");

        logoutBtn.setLayoutX(462.0);
        logoutBtn.setLayoutY(13.0);
        logoutBtn.setMnemonicParsing(false);
        logoutBtn.setPrefHeight(50.0);
        logoutBtn.setPrefWidth(55.0);
        logoutBtn.setStyle("-fx-background-radius: 150px;");
        logoutBtn.setStyle("-fx-background-color: transparent;");

        Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/logout.png"));

        logoutBtn.setGraphic(new ImageView(image));

        recordsBtn.setLayoutX(398.0);
        recordsBtn.setLayoutY(13.0);
        recordsBtn.setMnemonicParsing(false);
        recordsBtn.setPrefHeight(50.0);
        recordsBtn.setPrefWidth(55.0);
        recordsBtn.setStyle("-fx-background-radius: 150px;");
        recordsBtn.setStyle("-fx-background-color: transparent;");
        Image recordsbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/records.png"));
        recordsBtn.setGraphic(new ImageView(recordsbtn));

        backBtn.setLayoutX(525.0);
        backBtn.setLayoutY(13.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(50.0);
        backBtn.setPrefWidth(55.0);
        backBtn.setStyle("-fx-background-radius: 150px;");
        backBtn.setStyle("-fx-background-color: transparent;");
        Image backbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/back.png"));
        backBtn.setGraphic(new ImageView(backbtn));

        recordNowBtn.setLayoutX(336.0);
        recordNowBtn.setLayoutY(13.0);
        recordNowBtn.setMnemonicParsing(false);
        recordNowBtn.setPrefHeight(50.0);
        recordNowBtn.setPrefWidth(55.0);
        recordNowBtn.setStyle("-fx-background-radius: 150px;");
        recordNowBtn.setStyle("-fx-background-color: transparent;");
        Image recordnowbtn = new Image(getClass().getClassLoader().getResourceAsStream("images/record.png"));
        recordNowBtn.setGraphic(new ImageView(recordnowbtn));

        buttonExit.setLayoutX(274.0);
        buttonExit.setLayoutY(13.0);
        buttonExit.setMnemonicParsing(false);
        buttonExit.setPrefHeight(50.0);
        buttonExit.setPrefWidth(55.0);
        buttonExit.setStyle("-fx-background-radius: 150px;");
        buttonExit.setStyle("-fx-background-color: transparent;");
        Image buttonexit = new Image(getClass().getClassLoader().getResourceAsStream("images/exit.png"));
        buttonExit.setGraphic(new ImageView(buttonexit));

        dbscore.setLayoutX(50.0);
        dbscore.setLayoutY(41.0);
        dbscore.setPrefHeight(43.0);
        dbscore.setPrefWidth(122.0);
        dbscore.setText(score+"");
           dbscore.setFont(new Font("Cambria", 24.0));
        dbscore.setTextFill(Color.web("#fff200"));
        
        labelsx.setLayoutX(20.0);
        labelsx.setLayoutY(537.0);
        labelsx.setPrefHeight(43.0);
        labelsx.setPrefWidth(60.0);
        labelsx.setText("your Score");
        labelsx.setStyle("-fx-background-radius: 150px;");
        labelsx.setStyle("-fx-background-color: transparent;");
        labelsx.setTextFill(Color.web("#fff200"));
        labelsx.setFont(new Font("Cambria", 12.0));
        
        scoreX.setLayoutX(98.0);
        scoreX.setLayoutY(537.0);
        scoreX.setPrefHeight(43.0);
        scoreX.setPrefWidth(60.0);
        scoreX.setStyle("-fx-background-radius: 150px;");
        scoreX.setStyle("-fx-background-color: transparent;");
        scoreX.setTextFill(Color.web("#fff200"));
        scoreX.setFont(new Font("Cambria", 24.0));
       // scoreX.setStyle("-fx-background-color: #ffffff;");
       
        labelso.setLayoutX(200.0);
        labelso.setLayoutY(537.0);
        labelso.setPrefHeight(43.0);
        labelso.setPrefWidth(60.0);
        labelso.setText(" Opp Score");
        labelso.setStyle("-fx-background-radius: 150px;");
        labelso.setStyle("-fx-background-color: transparent;");
        labelso.setTextFill(Color.web("#fff200"));
        labelso.setFont(new Font("Cambria", 12.0));

        scoreY.setLayoutX(289.0);
        scoreY.setLayoutY(537.0);
        scoreY.setPrefHeight(43.0);
        scoreY.setPrefWidth(60.0);
        scoreY.setStyle("-fx-background-radius: 150px;");
        scoreY.setStyle("-fx-background-color: transparent;");     
        scoreY.setTextFill(Color.web("#fff200"));
        scoreY.setFont(new Font("Cambria", 24.0));
//   scoreY.setStyle("-fx-background-color: #ffffff;");

        turn.setLayoutX(130.0);
        turn.setLayoutY(510.0);
        turn.setPrefHeight(43.0);
        turn.setPrefWidth(250.0);
        turn.setTextFill(Color.web("#fff200"));
        turn.setFont(new Font("Cambria", 24.0));
        turn.setStyle("-fx-background-color: transparent;");

        opName.setLayoutX(160.0);
        opName.setLayoutY(41.0);
        opName.setPrefHeight(43.0);
        opName.setPrefWidth(122.0);
        opName.setFont(new Font("Cambria", 24.0));
        opName.setTextFill(Color.web("#fff200"));
        
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
        getChildren().add(onlineList);
        getChildren().add(requestList);
        getChildren().add(logoutBtn);
        getChildren().add(recordsBtn);
        getChildren().add(recordNowBtn);
        getChildren().add(buttonExit);
        getChildren().add(backBtn);
        getChildren().add(dbscore);
        getChildren().add(scoreX);
        getChildren().add(scoreY);
        getChildren().add(opName);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(labelsx);
        getChildren().add(labelso);
        
        getChildren().add(turn);
        stage.setResizable(false);

        //setLabel("check");
    }

    onlineBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void set() {

        backBtn.setOnAction((event) -> {
            //player.send(4, "exit room");
            player.close();
            returnBack();
        });
        TictactoeGame.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                try {
                    player.close();
                } catch (Exception ex) {
                }
                System.exit(0);
                Platform.exit();
            }
        });
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button node = (Button) event.getSource();
                if (player.playing) {
                    if (TictactoeGame.TURN == 0) {
                        node.setDisable(true);
                        String sign;
                        ImageView img;
                        if (player.mySign.matches("x")) {
                            img = new ImageView(imageX);
                            sign = "x";
                        } else {
                            img = new ImageView(imageO);
                            sign = "o";
                        }
                        img.setFitHeight(node.getHeight() - 10);
                        img.setFitWidth(node.getWidth());
                        img.setPreserveRatio(true);
                        node.setGraphic(img);
                        TictactoeGame.TURN += 1;
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
                        player.send(2, player.mySign + " " + col + " " + row);
                    }
                }

            }
        };
        //gridPane.setBorder(BorderFactory.createLineBorder(Color.black));
        ObservableList<Node> childrens = gridPane.getChildren();
        childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
            but.setOnAction(buttonHandler);
            //but.setOpacity(0.1);
        });
        onlineList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + onlineList.getSelectionModel().getSelectedItem());
                String listText = (String) onlineList.getSelectionModel().getSelectedItem();
                System.out.println("Selected item: " + listText);
                if (listText != null && listText != "") {
                    int x = choose("send request?");
                    if (x == 1) {
                        player.send(0, listText);

                    }
                }
            }
        });

        requestList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                // Your action here
                String listText = (String) requestList.getSelectionModel().getSelectedItem();
                System.out.println("Selected item: " + listText);
                if (listText != null && listText != "") {
                    int x = choose("accept request?");

                    if (x == 1) {
                        player.send(1, listText);
                        requestList.getItems().remove(listText);
                    } else if (x == 0) {
                        requestList.getItems().remove(listText);
                    }
                }

            }
        });
        buttonExit.setOnAction((event) -> {
            if (player.playing) {
                System.out.println("exit");
                reset();
                player.send(4, "exit room");
            }
        });
        logoutBtn.setOnAction((event) -> {
            //player.send(4, "exit room");
            player.close();
            returnBack();
        });
        recordsBtn.setOnAction((event) -> {

            recordBase root = new recordBase(player.id);
            root.set();
            Scene scene = new Scene(root);
            st.setScene(scene); 
            st.show();
            
            ///////////////////////////////////////////////////////////////   
           
        });
        recordNowBtn.setOnAction((event)->{
        player.record();
        });
    }

    public void print(int x, int y, String name) {

        if (TictactoeGame.TURN == 1) {
            //if(!end){
            ImageView img;
            if (player.mySign.matches("o")) {
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

        }

    }

    public void printOnly(int x, int y, String sign) {

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

    public void setLabel(String text) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("message");
                alert.setHeaderText(text);
                ButtonType buttonTypeOne = new ButtonType("ok");
                alert.getButtonTypes().setAll(buttonTypeOne);
                alert.showAndWait();
            }
        });
    }

    public void setList(ArrayList<String> values) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (values.isEmpty()) {
                    onlineList.getItems().clear();
                    onlineList.setPlaceholder(new Label("No online Players"));
                } else {
                    onlineList.getItems().setAll(values);
                }
            }
        });
    }

    public void setRequests(ArrayList<String> values) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (values.isEmpty()) {
                    requestList.setPlaceholder(new Label("No requestes"));
                } else {
                    requestList.getItems().setAll(values);
                }
            }
        });
    }

    public void gameStart(String name) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                opName.setText(name);
                onlineList.setMouseTransparent(true);
                onlineList.setFocusTraversable(false);
                requestList.setMouseTransparent(true);
                requestList.setFocusTraversable(false);
            }
        });
    }

    public void gameEnd() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                opName.setText("not in a room");
                onlineList.setMouseTransparent(false);
                onlineList.setFocusTraversable(true);
                requestList.setMouseTransparent(false);
                requestList.setFocusTraversable(true);
            }
        });
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

    public void reset(String text) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("message");
                alert.setHeaderText(text);
                ButtonType buttonTypeOne = new ButtonType("ok");
                alert.getButtonTypes().setAll(buttonTypeOne);
                alert.showAndWait();
                ObservableList<Node> childrens = gridPane.getChildren();
                childrens.stream().map((children) -> (Button) children).forEachOrdered((but) -> {
                    but.setGraphic(null);
                    but.setDisable(false);

                });
            }
        });
    }


    public void setScoreVS(String text) {
        Platform.runLater(() -> {
            if (text.equals("win")) {
                try {
                    
                    mwin.start(st);
                } catch (Exception ex) {
                    Logger.getLogger(onlineBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                myScore++;
                score=score+10;
                new Record().setScore(this.id,score);
                dbscore.setText(score+"");
                scoreX.setText("" + myScore);
                scoreY.setText("" + oppScore);
            } else if (text.equals("lose")) {
                try {
                    mlose.start(st);
                } catch (Exception ex) {
                    Logger.getLogger(onlineBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                oppScore++;
                scoreY.setText("" + oppScore);
                scoreX.setText("" + myScore);
            }
        });

    }

    public void returnBack() {
        
        System.out.println("close");
        Platform.runLater(() -> {
            entranceBase Base = new entranceBase();
            Scene scene = new Scene(Base);
            TictactoeGame.stage.setScene(scene);
        });

    }

    public void setTurn() {
        Platform.runLater(() -> {
            if (TictactoeGame.TURN == 0) {
                turn.setText("   my turn");
            } else {
                turn.setText("other player turn");
            }
        });
    }
    public void clearTurn(){
    Platform.runLater(() -> {
            
                turn.setText("not in a game");
            
        });
    
    }
}

