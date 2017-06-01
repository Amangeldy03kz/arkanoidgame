package arkanoid;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class BallMover implements Runnable{
    private Pane panel;
    private Ball ball;
    private static final int STEPS = 1000;
    private static final int DELAY = 4;
    private Desk desk;
    
    public BallMover(Pane p, Ball b, Desk d){
        ball = b;
        panel = p;     
        desk = d;
    }
    @Override
    public void run(){
        while(!ball.gameIsOver){       
            Platform.runLater(new Runnable() {
                @Override public void run() {
                    ball.move(desk);
                }
            });    
            try{Thread.sleep(DELAY);}catch(InterruptedException e){e.printStackTrace();}
        }
    }
}