package app;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class is used to allow the user to adjust to changing levels. (Hours spent: 1.5)
 * @author Isis So
 * @version 1.0 June 6, 2014
 * @version 2.0 June 12, 2014 No changes 
 */
public class LevelTransition extends JPanel implements ActionListener
{
  /**
   * countDown  int                   The purpose of the integer variable countDown is to decrease the count down until the next level.
   */
  private int countDown;
  
  /**
   * delay      int                   The purpose of the integer variable delay is to decrease the slow the animation enough to keep it on screen.
   */
  private int delay;
  
  /**
   * gameData   NewGame               The purpose of the NewGame variable is so that the methods and variables can be accessed to call the next level.
   */
  private NewGame gameData;
  
  /**
   * t          Timer                 The purpose of the Timer variable t is to create a timer that will call actionPerformed repeatedly so that the animation can run. 
   */
  private Timer t = new Timer(30, this);
  
  /**
   * c          ChemistryBlasterApp   This variable refers to the ChemistryBlasterApp class. 
   */
  private ChemistryBlasterApp c;
  
  /**
   * The purpose of the SplashScreen constructor is to create the images as well as create and start the timer.
   * @param c ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @param n The purpose of the reference variable n is to reference the NewGame class so that the score and lives can be recorded.
   */
  public LevelTransition(NewGame n, ChemistryBlasterApp c){
    this.c = c;
    setBackground (Color.orange);
    gameData = n;
    delay = 90;
    countDown = 3;
    pause();
  }
  
  /**
   * The purpose of the pause method is to pause the program and make a JDialog appear so the user can take a break, return to the main menu or exit the game.
   * The inner classes are used to determine what action should be performed when the buttons "Resume", "Main Menu", and "Exit Game" are pressed.
   * @param D The purpose of the final reference variable D is to reference the JDialog class so that a new JDialog can be created.
   * @param button The purpose of the reference variable button is to reference the JButton class so that a button to unpause the game can be made.
   * @param close The purpose of the reference variable close is to reference the JButton class so that a button to exit the program can be made.
   * @param field1 The purpose of the reference variable field1 is to reference the JLabel class so that it can tell the user they've paused the program.
   * @param e The purpose of the reference variable e is to reference the ActionEvent class so that what the user clicks on can be processed.
   */
  private void pause(){
    final JDialog D = new JDialog (c, "");
    D.setSize (180, 100);
    D.setResizable (false);
    D.setUndecorated(true);
    D.setLayout (new FlowLayout ());
    JButton button = new JButton ("Continue to Next Level");
    JButton close = new JButton ("Exit Game");
    JLabel field1 = new JLabel ("Confirm:");
    field1.setFont (new Font ("Serif", Font.PLAIN, 16));
    D.add (field1);
    D.add (button);
    D.add(close);
    D.setLocationRelativeTo (this);
    D.setVisible (true);
    button.setMnemonic('C');
    close.setMnemonic('Q');
    button.addActionListener (new ActionListener (){
      public void actionPerformed (ActionEvent e){
        t.start();
        requestFocusInWindow();
        gameData.setLevel();
        gameData.setLives(true);
        D.dispose ();
      }
    });
    close.addActionListener (new ActionListener (){
      public void actionPerformed (ActionEvent e){
        D.dispose();
        c.determinePanel(new HighScores(gameData, c));
        return;
      }
    });
  }
  
  /*
   * The purpose of the paintComponent(Graphics c) method is to draw the animation.
   * @param c The purpose of the reference variable c is to reference the Graphics class so that draw commands can be used.x
   */
  public void paintComponent (Graphics c) {
    super.paintComponent(c);
    c.setColor(Color.black);
    c.setFont(new Font("Stencil", Font.PLAIN, 70));
    c.drawString ("NEXT LEVEL APPEARS IN:", 90, 100);
    c.setFont(new Font("Stencil", Font.PLAIN, 300));
    c.drawString (String.valueOf(countDown), 415, 400);
  }
  
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent.
   * The purpose of the first if statement is to check if countDown should be decreased.
   * The purpose of the second if statement is to check if the delay is 0.
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   */
  public void actionPerformed (ActionEvent ae)
  {
    delay--;
    if(delay%30 == 0)
      countDown--;
    if(delay == 0)
    {
      t.stop();
      c.increaseLevel(gameData, gameData.getLevel());
    }
    repaint();
    revalidate();
  }
}