package gameoflife;
import java.awt.*;
import javax.swing.*;

public class ChessboardView extends JPanel{

    int stepX, stepY, bordgrootte;
    int schermHoogte = 600;
    int schermBreedte = 600;
    private ChessboardData bordData; //beschik over de te tonen gegevens
    boolean cellAlive; //temporarily hold value
        
    //constructor
    public ChessboardView(ChessboardData bd, int bg){
        bordData = bd;          
        bordgrootte = bg;                     
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
                
                g.fillRect((row * stepX), (col * stepY), stepX, stepY);
            }
        }
    }  
      
}