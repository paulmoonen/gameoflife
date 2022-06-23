package schaakbord;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class ButtonView extends JPanel{
    private String invertColorTekst = "Invert colors";
    private String fillRandomTekst = "fill randomly";
    private String allCellsWhiteTekst = "all cells white";
    private JButton invertColorButton, fillRandomButton, allWhiteButton;
    private SchaakbordData borddata;
    private SchaakbordView schaakbordview;

    public ButtonView(SchaakbordData borddata, SchaakbordView schaakbordview){
        this.borddata = borddata;
        this.schaakbordview = schaakbordview;
        setBackground(Color.YELLOW);
        invertColorButton = new JButton(invertColorTekst);
        fillRandomButton = new JButton(fillRandomTekst);
        allWhiteButton = new JButton(allCellsWhiteTekst);

        add(invertColorButton);
        add(fillRandomButton);
        add(allWhiteButton);

        ActionListener eventhandler = new EventHandler();
        invertColorButton.addActionListener(eventhandler);
        fillRandomButton.addActionListener(eventhandler);
        allWhiteButton.addActionListener(eventhandler);
        
    }

    /**
     * een event handler die onderscheid maakt naar herkomst van het event
     */
    class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == invertColorButton){
                borddata.invertLives();
            }

            if(e.getSource() == fillRandomButton){
                borddata.seedRandom();
            }

            if(e.getSource() == allWhiteButton){
                borddata.allCellsWhite();
            }
            
            schaakbordview.repaint();
        }
    }   
    
}
