package gameoflife;
import java.awt.event.*;
import javax.swing.*;

public class Chessboard {
    public static void main(String args[]){

        final int squaresAlongSide = 30; //this chessboard is 30 X 30 squares

        //maak een omvattend JFrame
        JFrame myFrame = new JFrame();
        ChessboardData bordData = new ChessboardData(squaresAlongSide);
        ChessboardView schaakbordview = new ChessboardView( bordData, squaresAlongSide );
        ButtonsView btnvw = new ButtonsView(bordData, schaakbordview);
        TextView tvw = new TextView();
        ApplicationView appview = new ApplicationView(tvw, schaakbordview, btnvw);

        schaakbordview.addMouseListener(new MouseListener(){
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
                bordData.toggleCell((x / 20), (y / 20));
                schaakbordview.repaint();                    
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
        
        myFrame.setSize(650, 700);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Schaakbord");
        myFrame.setContentPane( appview );
        myFrame.setVisible(true);            
        
        schaakbordview.repaint();           
        
    }    
}
