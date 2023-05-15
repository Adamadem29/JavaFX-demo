package com.example.partie2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ColorPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    private Label topLabel;

    private Pane centerPane;

    private int nbrVertClick = 0;
    private int nbrRougeClick = 0;
    private int nbrBleuClick = 0;

    @Override
    public void start(Stage primaryStage) {
        BorderPane main = new BorderPane();

        //ajout du label en haut
        topLabel = new Label();
        BorderPane.setAlignment(topLabel, Pos.CENTER);
        topLabel.setFont(new Font(16));
        topLabel.setPadding(new Insets(10.0));
        main.setTop(topLabel);

        //ajout du Pane au milieu
        centerPane = new Pane();
        main.setCenter(centerPane);


        //ajout des boutons en bas
        HBox bottomButtons = new HBox();
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setSpacing(10);
        bottomButtons.setPadding(new Insets(0.0,0.0,10.0,0.0));
        Button vertButton = new Button("Vert");
        vertButton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> vertButtonClick(actionEvent) );
        Button rougeButton = new Button("Rouge");
        rougeButton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> rougeButtonClick(actionEvent) );
        Button bleuButton = new Button("Bleu");
        bleuButton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> bleuButtonClick(actionEvent) );


        bottomButtons.getChildren().addAll(vertButton, rougeButton, bleuButton);
        main.setBottom(bottomButtons);



        Scene scene = new Scene(main);


        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //gestionnaire d'évennement
    private void vertButtonClick(Event event){
        ++nbrVertClick;
        topLabel.setText("Vert choisi " + nbrVertClick + " fois" );
        centerPane.setStyle("-fx-background-color: green;");
    }

    private void rougeButtonClick(Event event){
        ++nbrRougeClick;
        topLabel.setText("Rouge choisi " + nbrRougeClick + " fois" );
        centerPane.setStyle("-fx-background-color: red;");
    }

    private void bleuButtonClick(Event event){
        ++nbrBleuClick;
        topLabel.setText("Bleu choisi " + nbrBleuClick + " fois" );
        centerPane.setStyle("-fx-background-color: blue;");
    }
}
