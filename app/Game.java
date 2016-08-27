package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * This class is used to display the image that contains the instructions of Chemistry Blaster. (Hours spent: 2)
 * 
 * @author  Isis So and Jerry Liu
 * @version 1.0 May 16, 2014 screen dump made only (Isis)
 * @version 2.0 May 23, 2014 No changes
 * @version 3.0 May 30, 2014 Changed font and graphics and added back button (Isis)
 * @version 4.0 June 6, 2014 Made to fit with packages (Jerry)
 * @version 5.0 June 12, 2014 Added shortcut keys, javadoced changed (Isis)
 */
public class Game extends JPanel implements ActionListener
{
  /**
   * c       ChemistryBlasterApp This private reference variable refers to the ChemistryBlasterApp class so that the methods inside it can be used.
   */ 
  private ChemistryBlasterApp c;
  
  /**
   * This constructor is used to draw the level choice buttons onto the JPanel. The buttons have colors and alignment set. 
   * The buttons have inner classes that are used to create a new game with its corresponding level.
   * @param   c          ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @param   level1   JButton   This variable is used to create a the 'Level 1: Passenger Status' button.
   * @param   level2   JButton   This variable is used to create a the 'Level 2: Crew Status' button.
   * @param   level3   JButton   This variable is used to create a the 'Level 3: Defense Officer Status' button.
   * @param   backBtn   JButton   This is used for allowing the user to traverse back to the main menu from instructions and highscores. 
   * @param   title    JLabel This is used to create a new display area for telling the user to choose a level.
   */ 
  public Game(ChemistryBlasterApp c)
  {
    this.c = c;
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    setLayout(null);
    setBackground (Color.black);
    JLabel title = new JLabel ("Choose a level:");
    JButton level1 = new JButton ("Level 1: Passenger Status");
    JButton level2 = new JButton ("Level 2: Crew Status");    
    JButton level3 = new JButton ("Level 3: Defense Officer Status");
    JButton backBtn = new JButton ("Back to Main Menu");
    title.setFont (new Font("Stencil", Font.PLAIN, 50));
    title.setForeground (new Color (192,192,192));
    level1.setForeground (Color.blue);
    level2.setForeground (Color.red);
    level3.setForeground (new Color (0, 128, 0));
    title.setBounds(300, 50, 600, 70);
    level1.setBounds(390, 170, 220, 30);
    level2.setBounds(390, 240, 220, 30);
    level3.setBounds(390, 310, 220, 30);
    backBtn.setBounds(390, 380, 220, 30);
    level1.setMnemonic('1');
    level2.setMnemonic('2');
    level3.setMnemonic('3');
    backBtn.setMnemonic('B');
    level1.addActionListener(this);
    level2.addActionListener(this);
    level3.addActionListener(this);
    backBtn.addActionListener (this);
    add(title);
    add(level1);
    add(level2);
    add(level3);
    add(backBtn);
    setVisible(true);
  }
  
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent. 
   * The if statement determines where the program should go (which method to call in ChemistryBlasterApp).
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   */
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getActionCommand().equals("Level 1: Passenger Status"))
      c.level(1);
    else if(ae.getActionCommand().equals("Level 2: Crew Status"))
      c.increaseLevel(new NewGame(2), 2);
    else if(ae.getActionCommand().equals("Level 3: Defense Officer Status"))
      c.increaseLevel(new NewGame(3), 3);
    else
      c.determinePanel(new MainMenu(c));
    this.invalidate();
    this.validate();
    this.repaint();
  }
}