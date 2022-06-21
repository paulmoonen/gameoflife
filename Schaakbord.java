package schaakbord;
//import java.awt.*;
import javax.swing.*;

public class Schaakbord {
    public static void main(String args[]){

        final int schaakbordGrootte = 20;

        //maak een omvattend JFrame
        JFrame myFrame = new JFrame();
        SchaakbordData bordData = new SchaakbordData(schaakbordGrootte);
        SchaakbordView schaakbordview = new SchaakbordView( bordData, schaakbordGrootte );
        ButtonView btnvw = new ButtonView();
        TextView tvw = new TextView();
        ApplicationView appview = new ApplicationView(tvw, schaakbordview, btnvw);
        
        
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
