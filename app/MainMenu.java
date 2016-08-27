package app;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * This class is used to create the main menu of the Chemistry Blaster game. (Hours spent: 10.5)
 *  
 * @author       Isis So
 * @version 1.0 May 16, 2014
 * @version 2.0 May 23, 2014 Added background picture
 * @version 3.0 May 30, 2014 No changes
 * @version 4.0 June 6, 2014 Changed to fit with packages
 * @version 5.0 June 12, 2014 No changes
 */
public class MainMenu extends JPanel implements ActionListener
{
  
  /**
   * background   BufferedImage        This is used for retrieving and displaying the background in the main menu. 
   */
  private BufferedImage background;
  
  /**
   * c            ChemistryBlasterApp  This variable refers to the ChemistryBlasterApp class. 
   */ 
  private ChemistryBlasterApp c;
  
  /**
   * This constructor is used to set the layout of the JPanel to BoxLayout and call the mainMenu() method to display the main menu. 
   * @param c ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   */ 
  public MainMenu(ChemistryBlasterApp c){
    this.c = c;
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    mainMenu();
  }
  
  /**
   * This mainMenu() method is used to draw the main menu buttons onto the JPanel. The buttons have different and alignment set.
   * @param   gameName   JLabel   This variable is used to create a new display area for the game title.
   * @param   play   JButton   This variable is used to create a the 'Play' button.
   * @param   instructions   JButton   This variable is used to create a the 'Instructions' button.
   * @param   highScores   JButton   This variable is used to create a the 'High Scores' button.
   * @param   exit   JButton   This variable is used to create a the 'Exit' button.
   * @exception   IOException   Exception is caught when the picture file cannot be properly read, which causes an exception to be thrown.
   */ 
  public void mainMenu(){
    try
    {
      background = ImageIO.read(new File("graphics/Background.jpg"));
    }
    catch(IOException e)
    {
    }
    
    JLabel gameName = new JLabel ("Chemistry Blaster");
    gameName.setForeground (Color.orange);
    gameName.setFont(new Font("Stencil", Font.PLAIN, 70));
    JButton play = new JButton("Play");
    JButton instructions = new JButton("Instructions");
    JButton highScores = new JButton("High Scores");    
    JButton exit = new JButton("Exit");
    play.setMnemonic('P');
    instructions.setMnemonic('R');
    highScores.setMnemonic('S');
    exit.setMnemonic('Q');
    play.addActionListener(this);
    instructions.addActionListener(this);
    highScores.addActionListener(this);
    exit.addActionListener(this);
    gameName.setAlignmentX(Component.CENTER_ALIGNMENT);
    play.setAlignmentX(Component.CENTER_ALIGNMENT);
    instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
    highScores.setAlignmentX(Component.CENTER_ALIGNMENT);
    exit.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    add (Box.createRigidArea(new Dimension(0, 50)));
    add (gameName);
    add (Box.createRigidArea(new Dimension(0, 110)));
    add (play);
    add (Box.createRigidArea(new Dimension(0, 20)));
    add (instructions);
    add (Box.createRigidArea(new Dimension(0, 20)));
    add (highScores);
    add (Box.createRigidArea(new Dimension(0, 20)));
    add (exit);
  }

  /**
   * The purpose of the paintComponent(Graphics c) method is to draw the pictures.
   * @param c The purpose of the reference variable c is to reference the Graphics class so that draw commands can be used.
   */ 
  public void paintComponent(Graphics c){
    super.paintComponent(c);
    c.drawImage(background, 0, 0, getWidth(), getHeight(), this);
  }
  
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent.
   * The if statement determines what method/action to perform.. 
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   */
  public void actionPerformed (ActionEvent ae){
    removeAll();
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    if (ae.getActionCommand().equals ("Play"))
      c.determinePanel(new Game(c));
    else if (ae.getActionCommand().equals ("Instructions"))
      c.determinePanel(new Instructions(c));
    else if (ae.getActionCommand().equals("High Scores"))
      c.determinePanel(new HighScores(null, c));
    else
      System.exit (0);
    this.invalidate();
    this.validate();
    this.repaint();
  }
}