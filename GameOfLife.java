package gameoflife;
import java.awt.event.*;
import javax.swing.*;

/**
 * Startup class of the 'gameoflife' application.
 * initiates various view and data objects and puts them together
 */
public class GameOfLife {
    public static void main(String args[]){

        final int squaresAlongSide = 30; //this chessboard is 30 X 30 squares

        //a JFrame to diaplay everything on screen
        JFrame myFrame = new JFrame();
        var boardData = new ChessboardData(squaresAlongSide);
        var chessboardview = new ChessboardView( boardData, squaresAlongSide );
        
        var tvw = new TextView();
        
        var btnvw = new ButtonsView(boardData, chessboardview);
        var appview = new ApplicationView(tvw, chessboardview, btnvw);

        chessboardview.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                int x = e.getX();
                int y = e.getY();

                if (x > 600){x = 600;}
                if (y > 600){y = 600;}
                
                /*
                 * find out which cell has been clicked
                 * chessboard = 600 X 600 pixels wide
                 * 30 squares along either side: 
                 * fields are 20 X 20 pixels wide
                 * position in SchaakbordData row = e.getX()  / 20
                 * position in SchaakbordData column = e.getY() / 20    
                 */
                boardData.toggleCell((x / 20), (y / 20));
                chessboardview.repaint();                    
            }

            @Override
            public void mouseExited(MouseEvent e){ }

            @Override
            public void mouseEntered(MouseEvent e){ }

            @Override
            public void mousePressed(MouseEvent e){ }

            @Override
            public void mouseReleased(MouseEvent e){ }
        });                  
        
        myFrame.setSize(600, 695);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Game Of Life");
        myFrame.setContentPane( appview );
        myFrame.setVisible(true);            
        
        chessboardview.repaint();  
               
    }    
}
