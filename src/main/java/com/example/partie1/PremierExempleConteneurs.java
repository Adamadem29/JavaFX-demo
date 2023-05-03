package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PremierExempleConteneurs extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        VBox vbox = new VBox();

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

        //Création du milieu de page
        HBox middleBox = new HBox();
        HBox.setHgrow(middleBox, Priority.ALWAYS );

        VBox leftBox = new VBox();
        VBox.setVgrow( leftBox, Priority.ALWAYS );
        Label boutonsLabel = new Label("Boutons :");
        Button bouton1 = new Button("Bouton1");
        Button bouton2 = new Button("Bouton2");
        Button bouton3 = new Button("Bouton3");
        leftBox.getChildren().addAll(boutonsLabel, bouton1, bouton2, bouton3);

        GridPane midPane = new GridPane();
        GridPane.setVgrow(midPane, Priority.ALWAYS);
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

        Separator midSeparator = new Separator(Orientation.VERTICAL);
        middleBox.getChildren().addAll(leftBox, midSeparator, midPane);

        // Ajout des contrôleurs au conteneur principal
        vbox.getChildren().addAll(
                topMenu,
                middleBox
        );

        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox );

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();


    }
}
