package level3;
import app.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class is used to inform the user that they won the game. (1.5 hours spent)
 * 
 * @author Isis So
 * @version 1.0 June 6, 2014.
 * @version 2.0 June 12, 2014 No changes
 */
public class WinScreen extends JPanel implements ActionListener
{
  /**
   * t Timer The purpose of the Timer variable t is to create a timer that will call actionPerformed repeatedly so that the animation can run. 
   */
  private Timer t = new Timer(5, this);
    
  /**
   * comet BufferedImage The purpose of the BufferedImage variable comet is to store the image of the comet so that it can be animated.
   */
  private BufferedImage comet;
  
  /**
   * x int The purpose of the integer variable x is to keep track of the x value to move the image right.
   */
  private int x;
  
  /**
   * y int The purpose of the integer variable y is to keep track of the y value to move the image down.
   */
  private int y;
  
  /**
   * appeared boolean This variable is used to determine whether the text has appeared on screen yet.
   */
  private boolean appeared;
  
  /**
   * gameData NewGame The purpose of the NewGame variable is so that the methods and variables can be accessed to call the next level.
   */
  private NewGame gameData;
  
  /**
   * c ChemistryBlasterApp This variable refers to the ChemistryBlasterApp class. 
   */
  private ChemistryBlasterApp c;
  
  /**
   * The constructor is used to make a new WinScreen. It sets the instance variables, reads in the comet image, and starts the timer for the animation.
   * @param n The purpose of the reference variable n is to reference the NewGame class so that the score and lives can be recorded.
   * @param c ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @exception NullPointerException The try catch is used to catch any NullPointerException errors that may occur while reading for NewGame.
   * @exception IOException The try catch is used to catch any IO errors that may occur while reading the image.
   */ 
  public WinScreen(NewGame n, ChemistryBlasterApp c){
    this.c = c;
    try{
      if(!n.equals(null))
        gameData = n;
    }
    catch(NullPointerException e){
    }
    setBackground (Color.BLACK);
    try{
      comet = ImageIO.read(new File("graphics/Comet.png"));
    }
    catch(IOException e){
    }
    t.start();
  }
  
  /**
   * The purpose of the method paintComponent(Graphics c) is to draw the comet and the texts. 
   * The if statement determines if the comet is off screen.
   * @param c The purpose of the reference variable g is to reference the Graphics class so that the images can be drawn.
   */
  public void paintComponent(Graphics c){
    super.paintComponent(c);
    c.drawImage(comet, x -500, y+(-500), null);
    if(x==1100){
      c.setFont(new Font("Calibri", Font.PLAIN, 28));
      c.setColor(new Color(30,144,255));
      c.drawString("Congratulations! You've won!", 330, 150);
      c.setFont(new Font("Calibri", Font.PLAIN, 14));
      c.drawString("You are now officially the Captain of the IJ Computers of Science Spaceship!", 288, 370);          
      appeared = true;
    }
  }
  
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent.
   * The purpose of the if statement is to check if the text has appeared on the screen yet.
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   * @exception InterruptedException Exception is caught to ensure nothing interrupts the small delay before calling the HighScores panel.
   */
  public void actionPerformed(ActionEvent ae)
  {
    x++;
    y++;
    if(appeared){
      try{
        Thread.sleep(3500);
      }
      catch(InterruptedException e){
      }
      t.stop();
      c.determinePanel(new HighScores(gameData, c));
    }
    repaint();
    revalidate();
  } 
}