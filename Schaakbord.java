package schaakbord;
import java.awt.event.*;
//import java.awt.MouseInfo.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class Schaakbord {
    public static void main(String args[]){

        final int schaakbordGrootte = 20;

        //maak een omvattend JFrame
        JFrame myFrame = new JFrame();
        SchaakbordData bordData = new SchaakbordData(schaakbordGrootte);
        SchaakbordView schaakbordview = new SchaakbordView( bordData, schaakbordGrootte );
        ButtonView btnvw = new ButtonView(bordData, schaakbordview);
        TextView tvw = new TextView();
        ApplicationView appview = new ApplicationView(tvw, schaakbordview, btnvw);

        schaakbordview.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                int x = e.getX();
                int y = e.getY();
                System.out.println("klik, x: " + x + " y: " + y);
            }

            @Override
            public void mouseExited(MouseEvent e){
                System.out.println("mouse exited");
            }

            @Override
            public void mouseEntered(MouseEvent e){
                System.out.println("mouse entered");
            }

            @Override
            public void mousePressed(MouseEvent e){
                System.out.println("mouse pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e){
                System.out.println("mouse released");
            }
        });                  
        
        myFrame.setSize(400, 400);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Schaakbord");
        myFrame.setContentPane( appview );
        myFrame.setVisible(true);            
        
        //bordData.allCellsWhite();
        //bordData.invertLives();
        schaakbordview.repaint();           
        
    }    
}
