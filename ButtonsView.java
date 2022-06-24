package gameoflife;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class ButtonsView extends JPanel{
    private String invertColorTekst = "Invert colors";
    private String fillRandomTekst = "fill randomly";
    private String allCellsWhiteTekst = "all cells white";
    private String nextGenerationTekst = "next generation";
    private JButton invertColorButton, fillRandomButton, allWhiteButton, nextGeneratioButton;
    private ChessboardData borddata;
    private ChessboardView schaakbordview;

    public ButtonsView(ChessboardData borddata, ChessboardView schaakbordview){
        this.borddata = borddata;
        this.schaakbordview = schaakbordview;
        setBackground(Color.YELLOW);
        invertColorButton = new JButton(invertColorTekst);
        fillRandomButton = new JButton(fillRandomTekst);
        allWhiteButton = new JButton(allCellsWhiteTekst);
        nextGeneratioButton = new JButton(nextGenerationTekst);

        add(invertColorButton);
        add(fillRandomButton);
        add(allWhiteButton);
        add(nextGeneratioButton);

        ActionListener eventhandler = new EventHandler();
        invertColorButton.addActionListener(eventhandler);
        fillRandomButton.addActionListener(eventhandler);
        allWhiteButton.addActionListener(eventhandler);
        nextGeneratioButton.addActionListener(eventhandler);
        
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

            if(e.getSource() == nextGeneratioButton){
                borddata.nextGeneration();
            }

            schaakbordview.repaint();
        }
    }   
    
}
