package brd;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Game {
    private Pane root;
    private Bird bird;
    private Scene scene;
    private ArrayList<Pipe> pipes;

    public Game(Pane root, Scene scene) {
        this.root = root;
        this.scene = scene;
        this.pipes = new ArrayList<>();
        this.bird = new Bird(root);
    }

    public void init() {


        scene.setOnKeyPressed(event -> bird.jump());
        scene.setOnMouseClicked(event -> bird.jump());
        setBackground();
        initPipes();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                bird.moveDown();
                moveX();
            }
        };
        timer.start();
        playSound();
    }


    private void setBackground() {

        Image img = new Image(Settings.backgroundURL, Settings.screenWidth, Settings.screenHeight, false, true);
        BackgroundImage myBI = new BackgroundImage(img,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));


    }

    private void initPipes() {
        int gap = 150;
        for (int i = 1; i < 400; i++) {
            int x = new Random().nextInt(1000) + 600;
            int height1 = new Random().nextInt(200) + 50;
            int height2 = Settings.screenHeight - height1 - gap;
            int y2 = Settings.screenHeight - height2;
            Pipe p1 = new Pipe((int) (x * i / 1.5), 0, height1, false);
            Pipe p2 = new Pipe((int) (x * i / 1.5), y2, height2, true);
            pipes.add(p1);
            pipes.add(p2);
            root.getChildren().add(p1.getBody());
            root.getChildren().add(p2.getBody());

        }

    }

    private void moveX() {
        pipes.forEach(el -> {
            ImageView tmpPipe = el.getBody();
            tmpPipe.setTranslateX(tmpPipe.getTranslateX() - 3);
        });
    }

    private void playSound() {
        AudioClip soundMyNoise = new AudioClip(new File(Settings.songURL).toURI().toString());
        soundMyNoise.play();
    }

}
















