package gameoflife;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/*
 * control buttons, with event listener to call appropriate functions
 */
public class ButtonsView extends JPanel{
    private String invertColorText          = "Invert lives";
    private String fillRandomText           = "Random live cells";
    private String allCellsWhiteText        = "Clear";
    private String nextGenerationText       = "Next generation";
    private String chessboardButtonString   = "Chessboard";
        
    private JButton invertColorButton; 
    private JButton fillRandomButton;   
    private JButton allWhiteButton;
    private JButton nextGeneratioButton;
    private JButton chessboardButton;
        
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
        chessboardButton    = new JButton(chessboardButtonString);
                        
        ActionListener eventhandler = new EventHandler();
        invertColorButton.addActionListener(eventhandler);
        fillRandomButton.addActionListener(eventhandler);
        allWhiteButton.addActionListener(eventhandler);
        nextGeneratioButton.addActionListener(eventhandler);    
        chessboardButton.addActionListener(eventhandler);   
        
        add(fillRandomButton);
        add(chessboardButton);
        add(invertColorButton);
        add(allWhiteButton);
        add(nextGeneratioButton);
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

            if(e.getSource() == chessboardButton){
                boarddata.fillChessboardStyle();
            }

            chessboardview.repaint();
        }
    }      
}
