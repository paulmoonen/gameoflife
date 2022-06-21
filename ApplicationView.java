package schaakbord;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.MouseEvent;

/*
 * holds the different visible parts of the application nicely arranged
 */
public class ApplicationView extends JPanel {

    private TextView tv;
    private SchaakbordView sbv;
    private ButtonView btnvw;

    public ApplicationView(TextView tv, SchaakbordView sbv, ButtonView btnvw){
        this.tv = tv;
        this.sbv = sbv;
        this.btnvw = btnvw;
                        
        setLayout(new BorderLayout());
        add(tv, BorderLayout.NORTH);
        add(sbv, BorderLayout.CENTER);
        add(btnvw, BorderLayout.SOUTH);
    }   

      
}