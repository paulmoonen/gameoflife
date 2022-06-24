package gameoflife;
import java.awt.*;
import javax.swing.*;

public class ChessboardView extends JPanel{

    int stepX, stepY, squaresAlongSide;
    int boardHeight = 600;
    int boardWidth = 600;
    private ChessboardData boardData;    //reference to data to dispay
    boolean cellAlive;                  //temporarily hold value
        
    //constructor
    public ChessboardView(ChessboardData bd, int sas){
        boardData = bd;          
        squaresAlongSide = sas;                     
    }     

    /**
     * draws data
     * listens to repaint() call
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        stepX = boardWidth / squaresAlongSide;
        stepY = boardHeight / squaresAlongSide;
        Color fillColor;
         
        for( int row = 0; row < squaresAlongSide; row++){
            for( int col = 0; col < squaresAlongSide; col++){
                cellAlive = boardData.chessboard[row][col];
                fillColor = (cellAlive)? Color.BLACK : Color.WHITE;
                g.setColor(fillColor);
                
                g.fillRect((row * stepX), (col * stepY), stepX, stepY);
            }
        }
    }  
      
}
