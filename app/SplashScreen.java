package app;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
/**
 * <p> The purpose of the SplashScreen class is to create a SplashScreen before the user plays the game. (Hours spent: 2)
 * @author Jerry Liu
 * @version 1.0 May 16, 2014
 * @version 2.0 May 23, 2014 No changes
 * @version 3.0 May 30, 2014 No changes
 * @version 4.0 June 6, 2014 Changed to fit with packages
 * @version 5.0 June 12, 2014 No changes
 */
public class SplashScreen extends JPanel implements ActionListener
{
  /**
   * The purpose of the BufferedImage variable spaceship is to store the image of the spaceship so that it can be animated.
   * The purpose of the Timer variable t is to create a timer that will call actionPerformed repeatedly so that the animation can run. 
   * c ChemistryBlasterApp This variable refers to the ChemistryBlasterApp class. 
   */
  
  /**
   * d  int  The purpose of the integer variable d is to increment the correct coordinate that the animation should be located, and allow the animation to work properly.
   */
  private int d;
  
  /**
   * logo  BufferedImage  The purpose of the BufferedImage variable logo is to store the image of the logo so that it can be animated.
   */
  private BufferedImage logo;
  
  /**
   * alien  BufferedImage  The purpose of the BufferedImage variable alien is to store the image of the alien spaceship so that it can be animated.
   */
  private BufferedImage alien;
  
  /**
   * spaceship  BufferedImage  The purpose of the BufferedImage variable spaceship is to store the image of the spaceship so that it can be animated.
   */
  private BufferedImage spaceship;
  
  /**
   * t  Timer  The purpose of the BufferedImage variable spaceship is to store the image of the spaceship so that it can be animated.
   */ 
  private Timer t;
  
  /**
   * c ChemistryBlasterApp This variable refers to the ChemistryBlasterApp class. 
   */
  private ChemistryBlasterApp c;
  
  /**
   * The purpose of the SplashScreen constructor is to create the images as well as create and start the timer.
   * @param c ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @param e The purpose of the reference variable e is to reference the IOException class to catch errors regarding file io.
   * @exception IOException The try catch is used to catch any IO errors that may occur while reading the image.
   */
  public SplashScreen (ChemistryBlasterApp c)
  {
    this.c = c;
    setBackground (Color.BLACK);
    d = -700;
    try
    {
      logo = ImageIO.read(new File("graphics/Logo.jpg"));
      alien = ImageIO.read(new File("graphics/testAlienSpaceship.png"));
      spaceship = ImageIO.read(new File("graphics/Spaceship.png"));
    }
    catch(IOException e)
    {
    }
    t = new Timer(1, this);
    t.start();
  }
  /*
   * The purpose of the paintComponent(Graphics c) method is to draw the pictures.
   * @param c The purpose of the reference variable c is to reference the Graphics class so that draw commands can be used.
   */
  public void paintComponent (Graphics c) 
  {
    super.paintComponent(c);
    c.setColor(Color.black);
    c.fillRect(0, 0, 1000, 600);
    //Logo
    c.drawImage(logo, d+150, 300, null);
    c.drawImage(alien, d-50, 320, null);
    c.drawImage(spaceship, d+ 490, 320, null);
    c.setColor(Color.red);
    c.drawLine(451+d, 375, 515+d, 345);
    c.drawLine(451+d, 425, 520+d, 390);
  }
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent.
   * The purpose of the if statement is to check if everything has traveled across the screen.
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   */
  public void actionPerformed (ActionEvent ae)
  {
    d++;
    if(d==1050)
    {
      t.stop();
      c.determinePanel(new MainMenu(c));
    }
    repaint();
    revalidate();
  }
}