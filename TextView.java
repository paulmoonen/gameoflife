package schaakbord;
import java.awt.Color;
import javax.swing.*;

public class TextView extends JPanel{
    private String tekst = "Tekst van TextField";
    private JTextArea tekstveld;

    public TextView(){
        setBackground(Color.BLUE);
        tekstveld = new JTextArea(tekst);
        add(tekstveld);
    }
    
}
