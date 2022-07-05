package gameoflife;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/*
 * control buttons, with event listener to call appropriate functions
 */
public class ButtonsView extends JPanel{
    private String invertColorText          = "Invert";
    private String fillRandomText           = "Random";
    private String allCellsWhiteText        = "Clear";
    private String nextGenerationText       = "Next Generation";
    private String runPauseText             = "Run / Pause";
    
    private Timer timer;                    //heartbeat of the flow of new patterns 
    private Boolean paused;                 //toggles timer on and of
    private int timerDelay = 500;           //ms delay between timer pulses
        
    private JButton invertColorButton; 
    private JButton fillRandomButton;   
    private JButton allWhiteButton;
    private JButton nextGeneratioButton;
    private JButton runPauseButton;
            
    private ChessboardData boarddata;
    private ChessboardView chessboardview;

    //constructor
    public ButtonsView(ChessboardData boarddata, ChessboardView chessboardview){
        this.boarddata = boarddata;
        this.chessboardview = chessboardview;
        this.paused = true;
        timer = new Timer(timerDelay, new TimerListener());
        timer.start();
                                
        setBackground(Color.YELLOW);
        invertColorButton   = new JButton(invertColorText);
        fillRandomButton    = new JButton(fillRandomText);
        allWhiteButton      = new JButton(allCellsWhiteText);
        nextGeneratioButton = new JButton(nextGenerationText);
        runPauseButton      = new JButton(runPauseText);
                                
        ActionListener eventhandler = new EventHandler();
        invertColorButton.addActionListener(eventhandler);
        fillRandomButton.addActionListener(eventhandler);
        allWhiteButton.addActionListener(eventhandler);
        nextGeneratioButton.addActionListener(eventhandler);  
        runPauseButton.addActionListener(eventhandler);  
                
        add(fillRandomButton);
        add(invertColorButton);
        add(allWhiteButton);
        add(nextGeneratioButton);
        add(runPauseButton);
    }

    /**
     * event listener for timer pulses
     */
    class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent timerEvent){
            
            if(!paused){
                //if not paused, calculate next generation and show the result
                boarddata.nextGeneration();
                chessboardview.repaint();
            }            
        }
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
                paused = true;  //to enable drawing a new pattern manually
                boarddata.allCellsWhite();
            }

            if(e.getSource() == nextGeneratioButton){
                boarddata.nextGeneration();
            }        
            
            if(e.getSource() == runPauseButton){
                //toggle the switch-variable to start / stop the flow of new patterns
                paused = !paused;                
            }

            chessboardview.repaint();
        }
    }      
}
