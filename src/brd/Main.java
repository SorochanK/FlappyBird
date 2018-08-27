package brd;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("brd.fxml"));
//        Group root=new Group();
        Pane root =new Pane();
        primaryStage.setTitle("Flappy Bird");
        Scene scene=new Scene(root, Settings.screenWidth, Settings.screenHeight);
        primaryStage.setScene(scene);
        new Game(root,scene).init();

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
