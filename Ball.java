package arkanoid;

import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public class Ball {
    private double x;
    private double y;
    private double dx=1;
    private double dy=-1;
    private ImageView imv;
    private Image image;
    private AudioClip clip, clip2, clip3;
    public boolean gameIsOver = false;
    private Pane panel;
    
    public Ball(double x, double y, Pane p){
        
        this.x = x;
        this.y = y;
        imv = new ImageView();
        image = new Image(getClass().getResourceAsStream("ball.png"));
        imv.setImage(image);
        panel = p;
        panel.getChildren().add(imv);
        URL resource = getClass().getResource("bounce.wav");
        clip = new AudioClip(resource.toString());
        URL resource2 = getClass().getResource("win2.wav");
        clip2 = new AudioClip(resource2.toString());
        URL resource3 = getClass().getResource("lose2.wav");
        clip3 = new AudioClip(resource3.toString());
    }
    public void move(Desk desk)
    {
         x += dx;
         y += dy;
        
        if((getX()+10<desk.getX() || getX()>desk.getX()+desk.getLength())         
                && (getY()>panel.getHeight()-10) && !gameIsOver) {
            Arkanoid.i++;
            gameIsOver = true;
            imv.setVisible(false);
            Arkanoid.shouted = false;
            clip3.play();
        }
        else if((getX()+10<desk.getH() || getX()>desk.getH()+desk.getLength())
                && getY()<0 && !gameIsOver){
            Arkanoid.j++;
            gameIsOver = true;
            imv.setVisible(false);
            Arkanoid.shouted = false;
            clip2.play();
        }
       
        else if ((getX()<= 0) || (getX() + 10 >= panel.getWidth())) {
                dx = -dx;
                clip.play();
       }
       else if ((getX()>=desk.getX() && getX()+10<=desk.getX()+desk.getLength())
               && (getY()+10>= panel.getHeight()-25)) {
                y = panel.getHeight() - desk.getWidth()-25;
                dy = -dy;
                clip.play();
       }
       else if ((getX()>=desk.getH() && getX()+10<=desk.getH()+desk.getLength())
               && (getY()<= 25)) {
                y = 25;
                dy = -dy;
                clip.play();
       }
        Arkanoid.score.setText((Arkanoid.i)+"\n"+"\n"+"\n"+ Arkanoid.j);
//       else if(getY()<0){
//           dy = - dy;
//           clip.play();
//       }
       
      
       imv.setX(x);
       imv.setY(y);
    }
    public double getX(){return this.x;}
    public double getY(){return this.y;}
    public ImageView getView(){return imv;}
}
