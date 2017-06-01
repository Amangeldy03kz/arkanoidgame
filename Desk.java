package arkanoid;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Desk {
    private Pane panel;
    private Ball ball;
    private static final int DELAY = 1;
    private ImageView imv_b,imv_t;
    private Image image;
    private static final int WIDTH = 24;
    private static final int LENGTH = 120;
    private double x,h;
    private double y,v;
    private double dx = 10;
   
    public Desk(Pane p){
        x = 340;
        h = 340;
        panel = p;
        imv_b = new ImageView();
        imv_t = new ImageView();
        image = new Image(getClass().getResourceAsStream("desk2.png"));
        imv_b.setImage(image);
        imv_t.setImage(image);
        panel.getChildren().add(imv_b); 
        panel.getChildren().add(imv_t); 
        imv_b.setX(340);
        imv_b.setY(575);
        imv_t.setX(340);
        imv_t.setY(10);
        
    }
    public void moveRightButtom(double maxX)
    {
       x += dx;
       if(x+LENGTH >= maxX){
           x = maxX-LENGTH;
       }
       imv_b.setX(x);
       }
    public void moveLeftButtom(double maxX)
    {
       x -= dx;
       if(x <= 0){
           x = 0;
       }
       imv_b.setX(x);
    }
    
    public void moveRightTop(double maxX)
    {
       h += dx;
       if(h+LENGTH >= maxX){
           h = maxX-LENGTH;
       }
       imv_t.setX(h);
       }
    public void moveLeftTop(double maxX)
    {
       h -= dx;
       if(h <= 0){
           h = 0;
       }
       imv_t.setX(h);
    }
    
    
    public double getX(){return x;}
    public double getH(){return h;}
    public double getWidth(){return WIDTH;}
    public double getLength(){return LENGTH;}
}

    

