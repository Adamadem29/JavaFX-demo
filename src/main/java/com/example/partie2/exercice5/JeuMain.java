package com.example.partie2.exercice5;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    private static ArrayList<Obstacle> Obstacles;

    private double j1X;
    private double j1Y;
    private double j2X;
    private double j2Y;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        Obstacle LeObstacle = new Obstacle(220,210,60,270);
        Obstacle Le2Obstacle = new Obstacle(450,0,60,270);
        Obstacles = new ArrayList<>();
        Obstacles.add(LeObstacle);
        Obstacles.add(Le2Obstacle);
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().addAll(Obstacles);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, Obstacles);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, ArrayList<Obstacle> Obstacles) {
        scene.setOnKeyPressed((KeyEvent event) -> {
             j1X = j1.getLayoutX();
             j1Y = j1.getLayoutY();
             j2X = j2.getLayoutX();
             j2Y = j2.getLayoutY();

            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;



            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Joueur 1 a gagné");
                Label GameOver = new Label("Joueur 1 a Gagné");
                GameOver.setFont(new Font(40));
                BorderPane.setAlignment(GameOver, Pos.CENTER);
                root.setCenter(GameOver);
            }

            for (int i = 0; i < Obstacles.size(); ++i){
                if (Obstacles.get(i).estEnCollision(j1)){
                    System.out.println("Obstacle j1");
                    j1.setLayoutX(j1X);
                    j1.setLayoutY(j1Y);
                }
                if (Obstacles.get(i).estEnCollision(j2)){
                    System.out.println("Obstacle j2");
                    j2.setLayoutX(j2X);
                    j2.setLayoutY(j2Y);

                }
            }


        });
    }


}