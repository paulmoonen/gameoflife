package gameoflife;
import java.awt.*;
import javax.swing.*;

/*
 * holds the different visible parts of the application nicely arranged
 */
public class ApplicationView extends JPanel {

    private TextView tv;
    private ChessboardView sbv;
    private ButtonsView btnvw;

    public ApplicationView(TextView tv, ChessboardView sbv, ButtonsView btnvw){
                                
        setLayout(new BorderLayout());
        add(tv, BorderLayout.NORTH);
        add(sbv, BorderLayout.CENTER);
        add(btnvw, BorderLayout.SOUTH);
    }   

      
}
