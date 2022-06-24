package gameoflife;
import java.awt.Color;
import javax.swing.*;

public class TextView extends JPanel{
    private String text = "Click a cell to toggle color";
    private JTextArea textfield;

    public TextView(){
        setBackground(Color.BLUE);
        textfield = new JTextArea(text);
        add(textfield);
    }
    
}
