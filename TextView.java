package gameoflife;
import java.awt.Color;
import javax.swing.*;

public class TextView extends JPanel{
    private String text = "Click a cell to toggle color. Make groups of colored cells to start the Game of Life.";
    private JLabel textLabel;
    

    public TextView(){
        setBackground(Color.YELLOW);
        textLabel = new JLabel(text);
        add(textLabel);        
    }
    
}
