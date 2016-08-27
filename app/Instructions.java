package app;
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
 * This class is used to display the image that contains the instructions of Chemistry Blaster. (Hours spent: 1.5)
 * 
 * @author       Isis So
 * @version 1.0 May 16, 2014
 * @version 2.0 May 23, 2014 
 * @version 3.0 May 30, 2014 No changes
 * @version 4.0 June 6, 2014 Made changes to constructor to fit with updated App class
 * @version 5.0 June 12, 2014 No changes
 */
public class Instructions extends JPanel implements ActionListener
{
  /**
   * instructions BufferedImage        This private variable is used for retrieving and displaying the instructions in the main menu, as opposed to displaying them in the form of JLabels. 
   */
  private BufferedImage instructions;
  
  /**
   * c            ChemistryBlasterApp  This private variable refers to the ChemistryBlasterApp class. 
   */ 
  private ChemistryBlasterApp c;
  
  /**
   * This Instructions() constructor is used to display the image that contains the instructions of Chemistry Blaster. The image's alignment is set.
   * @param   c          ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @param   backBtn   JButton   This is used for allowing the user to traverse back to the main menu from instructions and highscores. 
   * @param   picLabel   JLabel   This variable is used to create a new display area for the instructions image.
   * @param   resized    BufferedImage This variable is used to create a bigger picture of the instructions picture.
   * @param   g         Graphics2D   This variable is to allow acess to the methods in the Graphics2D class. 
   * @param   e         The purpose of the reference variable e is to reference the IOException class to catch errors regarding file io.
   * @exception   IOException   Exception is caught when the picture file cannot be properly read, which causes an exception to be thrown.
   */ 
  public Instructions(ChemistryBlasterApp c){
    this.c = c;
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    setBackground (Color.black);
    JButton backBtn = new JButton ("Back");
    try{
      instructions = ImageIO.read(new File("graphics/Instructions.png"));
      BufferedImage resized = new BufferedImage(700, 450, instructions.getType());  
      Graphics2D g = resized.createGraphics();  
      g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
      g.drawImage(instructions, 0, 0, 700, 450, null);
      g.dispose();
      instructions = resized;
      JLabel picLabel = new JLabel(new ImageIcon(instructions));
      add (Box.createRigidArea(new Dimension(240, 20)));
      picLabel.setLocation (50, 50);
      picLabel.setHorizontalAlignment (SwingConstants.CENTER);
      picLabel.setVerticalAlignment (SwingConstants.CENTER);
      add(picLabel);
    }
    catch(IOException e){
    }
    add (Box.createRigidArea(new Dimension(100, 20)));
    backBtn.addActionListener (this);
    backBtn.setMnemonic('B');
    add (backBtn);
  }
  
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent.
   * The if statement determines what method to call with its corresponding button. 
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   */
  public void actionPerformed(ActionEvent ae)
  {
    if (ae.getActionCommand().equals ("Back"))
      c.determinePanel(new MainMenu(c));
  }
}