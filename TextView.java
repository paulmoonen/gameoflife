package gameoflife;
import java.awt.Color;
import javax.swing.*;

public class TextView extends JPanel{
    private String text = "Click to toggle the color of cells, then use the Next Generation button below.";
    private JLabel textLabel;
    

    public TextView(){
        setBackground(Color.YELLOW);
        textLabel = new JLabel(text);
        add(textLabel);        
    }
    
}
