package brd;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pipe {
    private int x;
    private int y;
    private int height;
    private int width;
    private ImageView body;

    public Pipe(int x, int y, int height, boolean is_reversed) {

        this.x = x;
        this.y = y;
        int ratio = is_reversed ? 0 : 180;
        Image img = new Image(Settings.pipeURL, Settings.pipeWidth, height, true, true);
        body = new ImageView(img);
        body.setRotate(ratio);
        body.setX(x);
        body.setY(y);
        body.setFitHeight(height);


    }

    public ImageView getBody() {
        return body;
    }
}
