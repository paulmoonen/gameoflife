package schaakbord;
import java.awt.*;
import javax.swing.*;

public class SchaakbordView extends JPanel{

    int schermBreedte, schermHoogte, stepX, stepY, bordgrootte;
    private SchaakbordData bordData; //beschik over de te tonen gegevens
    boolean cellAlive; //temporarily hold value
        
    //constructor
    public SchaakbordView(SchaakbordData bd, int bg){
        bordData = bd;          
        bordgrootte = bg;     
        schermBreedte = 400;
        schermHoogte = 400;
        
    }     

    /**
     * draws data
     * listens to repaint() call
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        stepX = schermBreedte / bordgrootte;
        stepY = schermHoogte / bordgrootte;
        Color fillColor;
         
        for( int row = 0; row < bordgrootte; row++){
            for( int col = 0; col < bordgrootte; col++){
                cellAlive = bordData.schaakbord[row][col];
                fillColor = (cellAlive)? Color.BLACK : Color.WHITE;
                g.setColor(fillColor);
                
                g.fillRect((int)(row * stepX), (int)(col * stepY), stepX, stepY);
            }
        }
    }  
      
}
