package brd;

import javafx.animation.Animation;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.concurrent.ThreadLocalRandom;


public class Bird {
    private double x;
    private double y;
    private int height;
    private int width;
    private Pane root;
    private ImageView body;

    public Bird(Pane root) {

        x = Settings.screenWidth / 2.5;
        y = Settings.screenHeight / 2;
        this.root = root;

        body = new ImageView();
        Image im = new Image(Settings.faceURL);
        body.setImage(im);
        body.setX(x);
        body.setY(y);
        body.setFitWidth(Settings.birdWidth);
        body.setFitHeight(Settings.birdHeight);
        body.setSmooth(true);
        root.getChildren().add(body);

    }

    public void jump() {
        TranslateTransition tr = new TranslateTransition(Duration.millis(200), body);
        tr.setToY(body.getTranslateY() - 35);
        tr.play();

    }

    public void moveDown() {
        body.setTranslateY(body.getTranslateY() + 3);
    }
}








