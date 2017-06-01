package arkanoid;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Arkanoid extends Application {
    static boolean shouted = false;
    static int i=0;
    static int j=0;
//    int order = 1;
    static Text score;
    ImageView imv;
    Image image;
    @Override
    public void start(Stage primaryStage) {
        final Pane panel = new Pane();
        imv = new ImageView();
        image = new Image(getClass().getResourceAsStream("background.png"));
        imv.setImage(image);
        score=new Text("0"+"\n"+"\n"+"\n"+ "0");
        StackPane root = new StackPane();
        root.getChildren().add(imv);
        root.getChildren().add(panel);
        root.getChildren().add(score);
        score.setFont(Font.font ("Verdana", 40));
        score.setX(700);
        score.setY(60);
        score.setFill(Color.RED);
        final Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        Desk desk = new Desk(panel);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE  && shouted==false) 
                {
                    startGame(panel, desk);
                    shouted = true;
                }
                else if(event.getCode() == KeyCode.RIGHT)
                    desk.moveRightButtom(scene.getWidth());
                else if(event.getCode() == KeyCode.LEFT)
                    desk.moveLeftButtom(scene.getWidth());
                else if(event.getCode() == KeyCode.A)
                    desk.moveLeftTop(scene.getWidth());
                else if(event.getCode() == KeyCode.D)
                    desk.moveRightTop(scene.getWidth());

            }
        });
        //♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE);
                else if(event.getCode() == KeyCode.RIGHT)
                    desk.moveRightButtom(scene.getWidth());
                else if(event.getCode() == KeyCode.LEFT)
                    desk.moveLeftButtom(scene.getWidth());
                else if(event.getCode() == KeyCode.A)
                    desk.moveLeftTop(scene.getWidth());
                else if(event.getCode() == KeyCode.D)
                    desk.moveRightTop(scene.getWidth());

            }
        });
      
   }
    public void startGame(Pane panel, Desk desk){
        Ball ball = new Ball(desk.getX()+60,panel.getHeight()-35,panel);
        BallMover sp = new BallMover(panel, ball, desk);
        Thread t = new Thread(sp);
        t.start();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
