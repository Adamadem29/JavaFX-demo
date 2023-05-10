package com.example.partie2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ColorPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane main = new BorderPane();

        //ajout du label en haut
        Label topLabel = new Label();
        main.setTop(topLabel);

        //ajout du Pane au milieu
        Pane centerPane = new Pane();
        main.setCenter(centerPane);

        //ajout des boutons en bas
        HBox bottomButtons = new HBox();
        bottomButtons.setAlignment(Pos.CENTER);
        bottomButtons.setSpacing(10);
        Button vertButton = new Button("Vert");
        Button rougeButton = new Button("Rouge");
        Button bleuButton = new Button("Bleu");

        bottomButtons.getChildren().addAll(vertButton, rougeButton, bleuButton);
        main.setBottom(bottomButtons);

        Scene scene = new Scene(main);


        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
