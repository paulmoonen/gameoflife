package gameoflife;
import java.awt.*;
import javax.swing.*;

/*
 * holds the different visible parts of the application spatially arranged
 * TextView:        a short line of user instruction, in top of application window
 * ChessboardView:  the central, main field, to display the patterns
 * ButtonsView:     the lower section, containing the buttons
 */
public class ApplicationView extends JPanel {

    public ApplicationView(TextView tv, ChessboardView sbv, ButtonsView btnvw){
                                
        setLayout(new BorderLayout());
        add(tv,     BorderLayout.NORTH);
        add(sbv,    BorderLayout.CENTER);
        add(btnvw,  BorderLayout.SOUTH);
    }         
}
