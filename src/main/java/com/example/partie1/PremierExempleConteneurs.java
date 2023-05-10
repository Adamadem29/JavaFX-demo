package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PremierExempleConteneurs extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        BorderPane root = new BorderPane();

        //Création du conteneurs de la barre de menu
        MenuBar topMenu = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem closeItem = new MenuItem("Close");
        fileMenu.getItems().addAll(newItem, openItem, saveItem, closeItem);

        Menu editMenu = new Menu("Edit");
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);

        Menu helpMenu = new Menu("Help");

        topMenu.getMenus().addAll(fileMenu, editMenu, helpMenu);

        root.setTop(topMenu);

        //Création de la partie gauche

        VBox leftBox = new VBox();
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(10);

        Label boutonsLabel = new Label("Boutons :");

        Button bouton1 = new Button("Bouton1");
        Button bouton2 = new Button("Bouton2");
        Button bouton3 = new Button("Bouton3");
        leftBox.getChildren().addAll(boutonsLabel, bouton1, bouton2, bouton3);

        //separator entre milieu et centre
        Separator midSeparator = new Separator(Orientation.VERTICAL);
        root.setLeft(new HBox(leftBox, midSeparator));

        //Centre de la page et formulaire
        GridPane midPane = new GridPane();
        midPane.setAlignment(Pos.CENTER);
        midPane.setHgap(10);
        midPane.setVgap(10);
        midPane.setPadding(new Insets(10));

        Label nameLabel = new Label("Name: ");
        midPane.add(nameLabel, 0, 0);
        TextField nameField = new TextField();
        midPane.add(nameField, 1, 0);
        Label mailLabel = new Label("Email: ");
        midPane.add(mailLabel, 0, 1);
        TextField mailField = new TextField();
        midPane.add(mailField, 1, 1);
        Label pwLabel = new Label("Password: ");
        midPane.add(pwLabel, 0, 2);
        TextField pwField = new TextField();
        midPane.add(pwField, 1, 2);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        buttonBox.getChildren().addAll(new Button("Submit"), new Button("Cancel"));
        midPane.add(buttonBox, 0,3, 2, 1);

        root.setCenter(midPane);

        //Bas de la page
        Label statusLabel = new Label("Ceci est un label de bas de page");
        VBox bas = new VBox(new Separator(Orientation.HORIZONTAL),statusLabel);
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(root, 600, 400);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();


    }
}
