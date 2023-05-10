package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToe extends Application {



    public void setRandomLabel (Label label, Image croix, Image rond, Image vide){
        Random random = new Random();
        int nombre = random.nextInt(3);

        if (nombre == 0) {
            label.setGraphic(new ImageView(croix));
        }
        if (nombre == 1){
            label.setGraphic(new ImageView(vide));
        }
        if (nombre == 2) {
            label.setGraphic(new ImageView(rond));
        }
    }



    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        root.setAlignment(Pos.CENTER);


        Image croix = new Image( TicTacToe.class.getResource("Croix.png").toString());
        Image rond = new Image( TicTacToe.class.getResource("Rond.png").toString());
        Image vide = new Image( TicTacToe.class.getResource("Vide.png").toString());
        ImageView imageCroix = new ImageView(croix);
        ImageView imageRond = new ImageView(rond);
        ImageView imageVide = new ImageView(vide);

        Label label00 = new Label();
        setRandomLabel(label00, croix, rond, vide);
        root.add(label00,0,0);

        Label label01 = new Label();
        setRandomLabel(label01, croix, rond, vide);
        root.add(label01,0,1);

        Label label02 = new Label();
        setRandomLabel(label02, croix, rond, vide);
        root.add(label02,0,2);

        Label label10 = new Label();
        setRandomLabel(label10, croix, rond, vide);
        root.add(label10,1,0);

        Label label11 = new Label();
        setRandomLabel(label11, croix, rond, vide);
        root.add(label11,1,1);

        Label label12 = new Label();
        setRandomLabel(label12, croix, rond, vide);
        root.add(label12,1,2);

        Label label20 = new Label();
        setRandomLabel(label20, croix, rond, vide);
        root.add(label20,2,0);

        Label label21 = new Label();
        setRandomLabel(label21, croix, rond, vide);
        root.add(label21,2,1);

        Label label22 = new Label();
        setRandomLabel(label22, croix, rond, vide);
        root.add(label22,2,2);





        // Ajout du conteneur à la scene
        Scene scene = new Scene(root);


        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tic Tac Toe");

        // Affichage de la fenêtre
        primaryStage.show();

    }
}
