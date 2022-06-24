package gameoflife;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/*
 * control buttons, with event listener to call appropriate functions
 */
public class ButtonsView extends JPanel{
    private String invertColorText     = "Invert colors";
    private String fillRandomText      = "Fill randomly";
    private String allCellsWhiteText   = "All cells white";
    private String nextGenerationText  = "Next generation";
    private JButton invertColorButton, fillRandomButton, allWhiteButton, nextGeneratioButton;
    private ChessboardData boarddata;
    private ChessboardView chessboardview;

    public ButtonsView(ChessboardData boarddata, ChessboardView chessboardview){
        this.boarddata = boarddata;
        this.chessboardview = chessboardview;
        setBackground(Color.YELLOW);
        invertColorButton   = new JButton(invertColorText);
        fillRandomButton    = new JButton(fillRandomText);
        allWhiteButton      = new JButton(allCellsWhiteText);
        nextGeneratioButton = new JButton(nextGenerationText);

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
     * one event handler, distinguishes by event origin
     */
    class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == invertColorButton){
                boarddata.invertLives();
            }

            if(e.getSource() == fillRandomButton){
                boarddata.seedRandom();
            }

            if(e.getSource() == allWhiteButton){
                boarddata.allCellsWhite();
            }

            if(e.getSource() == nextGeneratioButton){
                boarddata.nextGeneration();
            }

            chessboardview.repaint();
        }
    }       
}
