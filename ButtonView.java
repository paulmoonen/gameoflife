package schaakbord;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class ButtonView extends JPanel{
    private String tekst = "Invert colors";
    private JButton button;
    private SchaakbordData borddata;
    private SchaakbordView schaakbordview;

    public ButtonView(SchaakbordData borddata, SchaakbordView schaakbordview){
        this.borddata = borddata;
        this.schaakbordview = schaakbordview;
        setBackground(Color.YELLOW);
        button = new JButton(tekst);
        add(button);

        ActionListener handler = new Handler();
        button.addActionListener(handler);
    }

    class Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            borddata.invertLives();
            schaakbordview.repaint();
        }
    }
    
}
