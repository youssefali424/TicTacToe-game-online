package tictactoegame;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public abstract class recordgrid extends AnchorPane {

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
    protected final ListView listView;
    protected final Button button8;
    protected final Button button9;

    public recordgrid() {

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
        listView = new ListView();
        button8 = new Button();
        button9 = new Button();

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
        imageView.setImage(new Image(getClass().getResource("../../../../bg.png").toExternalForm()));

        imageView0.setFitHeight(365.0);
        imageView0.setFitWidth(366.0);
        imageView0.setLayoutX(59.0);
        imageView0.setLayoutY(153.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../../../../grid.png").toExternalForm()));

        gridPane.setLayoutX(42.0);
        gridPane.setLayoutY(189.0);
        gridPane.setOpacity(0.58);
        gridPane.setPrefHeight(290.0);
        gridPane.setPrefWidth(442.0);
    //    gridPane.setStyle("-fx-background-image: C:\Users\SherifAbdelmoniem\Desktop\kk;");

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

        button.setMnemonicParsing(false);
        button.setPrefHeight(88.0);
        button.setPrefWidth(122.0);
        button.setStyle("-fx-background-color: #ffffff;");

        GridPane.setColumnIndex(button0, 1);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(88.0);
        button0.setPrefWidth(117.0);
        button0.setStyle("-fx-background-color: #ffffff;");

        GridPane.setColumnIndex(button1, 2);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(88.0);
        button1.setPrefWidth(121.0);
        button1.setStyle("-fx-background-color: #ffffff;");

        GridPane.setRowIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(88.0);
        button2.setPrefWidth(120.0);
        button2.setStyle("-fx-background-color: #ffffff;");

        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(88.0);
        button3.setPrefWidth(118.0);
        button3.setStyle("-fx-background-color: #ffffff;");

        GridPane.setColumnIndex(button4, 2);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(88.0);
        button4.setPrefWidth(121.0);
        button4.setStyle("-fx-background-color: #ffffff;");

        GridPane.setRowIndex(button5, 2);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(88.0);
        button5.setPrefWidth(122.0);
        button5.setStyle("-fx-background-color: #ffffff;");

        GridPane.setColumnIndex(button6, 1);
        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(88.0);
        button6.setPrefWidth(120.0);
        button6.setStyle("-fx-background-color: #ffffff;");

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(88.0);
        button7.setPrefWidth(122.0);
        button7.setStyle("-fx-background-color: #ffffff;");

        listView.setLayoutX(42.0);
        listView.setLayoutY(30.0);
        listView.setPrefHeight(138.0);
        listView.setPrefWidth(279.0);

        button8.setLayoutX(344.0);
        button8.setLayoutY(30.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(48.0);
        button8.setPrefWidth(118.0);
        button8.setText("Play");

        button9.setLayoutX(344.0);
        button9.setLayoutY(107.0);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(48.0);
        button9.setPrefWidth(122.0);
        button9.setText("pose");

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
        getChildren().add(button8);
        getChildren().add(button9);

    }
}
