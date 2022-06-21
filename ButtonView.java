package schaakbord;
import java.awt.*;
import javax.swing.*;

public class ButtonView extends JPanel{
    private String tekst = "Tekst van ButtonField";
    private JTextArea tekstveld;

    public ButtonView(){
        setBackground(Color.YELLOW);
        tekstveld = new JTextArea(tekst);
        add(tekstveld);
    }
    
}
