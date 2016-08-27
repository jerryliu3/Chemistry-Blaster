package app;
import level1.*;
import level2.*;
import level3.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
/**
 * This class is used to create the main menu of the Chemistry Blaster game. (Hours spent: 13)
 * 
 * @author Isis So and Jerry Liu
 * @version 1.0 May 16, 2014 Made basic traversing of game work (Both)
 * @version 2.0 May 23, 2014 Removed methods and created determinePanel(JPanel addPanel) method for KISS purposes (Isis)
 * @version 3.0 May 30, 2014 Added level() and increaseLevel() methods. (Jerry)
 * @version 4.0 June 6, 2014 Added key shortcuts (Isis), made to work with CHM (Jerry)
 * @version 5.0 June 12, 2014 Javadoc changes (Both)
 */
public class ChemistryBlasterApp extends JFrame implements ActionListener
{
  /**
   * j        JPanel      This private variable is used to store a JPanel class at a specific time of the game.
   */
  private JPanel j;
  
  /**
   * This constructor is used to make the menu items, menus, and menu bar for the window.
   * The window size and visibility are set, along with the menu bar. The window is set to dispose automatically once it is closed. 
   * 
   * @param    quitItem     JMenuItem    This variable is used to create a 'Quit' menu item object. 
   * @param    aboutItem    JMenuItem    This variable is used to create a 'About' menu item object. 
   * @param    chmItem      JMenuItem    This variable is used to open the chm file.
   * @param    fileMenu     JMenu        This variable is used to create the "File" menu object. 
   * @param    helpMenu     JMenu        This variable is used to create the "Help" menu object. 
   * @param    myMenus      JMenuBar     This variable is used to create the menu bar object. 
   * @param    DISPOSE_ON_CLOSE      Final int    This static final variable is used to dispose of the window once it is closed.  
   */
  public ChemistryBlasterApp()
  {
    super ("Chemistry Blaster");
    
    JMenuItem quitItem = new JMenuItem ("Quit");
    JMenuItem aboutItem = new JMenuItem ("About");
    JMenuItem chmItem = new JMenuItem("CHM File");
    quitItem.setAccelerator(KeyStroke.getKeyStroke("control Q"));
    aboutItem.setAccelerator(KeyStroke.getKeyStroke("control A"));
    chmItem.setAccelerator(KeyStroke.getKeyStroke("control I"));
    quitItem.addActionListener(this);
    aboutItem.addActionListener(this);
    chmItem.addActionListener(this);
    JMenu fileMenu = new JMenu ("File");
    fileMenu.setMnemonic('F');
    fileMenu.add (quitItem);
    fileMenu.addActionListener(this);
    JMenu helpMenu = new JMenu ("Help");
    helpMenu.setMnemonic('H');
    helpMenu.add (aboutItem);
    helpMenu.add(chmItem);
    helpMenu.addActionListener(this);
    JMenuBar myMenus = new JMenuBar ();
    myMenus.add (fileMenu);
    myMenus.add (helpMenu);
    setJMenuBar (myMenus);
    
    setSize (1000, 600);
    setResizable (false);
    setVisible (true);
    
    j = new SplashScreen(this);
    add(j);
    this.setLocationRelativeTo(null);
    this.invalidate();
    this.validate ();
    this.repaint();
    
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
  }
  
  /**
   * This method is used to remove the current panel and display another one on the screen.
   * @param   addPanel  JPanel  This variable refers to the panel that should be added to the screen after the current panel is removed.
   * @exception NullPointerException The purpose of the try catch structure is to catch NullPointerExceptions when removing the current JPanel.
   */ 
  public void determinePanel(JPanel addPanel)
  {
    try{
      remove(j);
    }
    catch(NullPointerException e){
    }
    j = addPanel;
    add(j);
    j.requestFocusInWindow();
    this.invalidate();
    this.validate();
    this.repaint();
  }
  
  /**
   * This method is used to start the game at a certain level.
   * The if statement checks if the level is 1, 2 or 3.
   * @param  g  NewGame  This variable is used to store the game data of the user (score, lives, etc).
   * @param  level  int  This variable is used to store the level the user is on.
   */
  public void level(int level)
  {
    remove(j);
    NewGame g = new NewGame(level);
    if(level==1)
      j = new Level1(g, this);
    else if (level == 2)
      j = new Level2(g, this);
    else
      j = new Level3(g, this);
    add(j);
    j.requestFocusInWindow();
    this.invalidate();
    this.validate();
    this.repaint();
  }
  
  /**
   * This increaseLevel(NewGame g, int level) method is used to change the level panel the user is on. 
   * The purpose of the if statement is to check which level the user is going to.
   * @param g NewGame This variable stores the data of the game to be passed onto the next level.
   * @param level int This variable stores the level the user will be playing next. 
   * @exception NullPointerException This exception is caught if the JPanel being removed is equal to null.
   */ 
  public void increaseLevel(app.NewGame g, int level)
  {
    try{
      remove(j);
    }
    catch(NullPointerException e){
    }
    if(level==2)
      j = new level2.Level2(g, this);
    else
      j = new level3.Level3(g, this);
    add(j);
    j.requestFocusInWindow();
    this.invalidate();
    this.validate();
    this.repaint();
  }
  
  /**
   * This method is used to make the dialog box for the About menu item.
   * @param D JDialog This final reference variable is used to make a new JDialog box for the about button. 
   * @param button The purpose of the reference variable button is to reference the JButton class to create a new JButton that allows the user to close the JDialog.
   * @param field1 The purpose of the reference variable field1 is to reference the JLabel class to create a new JLabel that talks about the creators of the game.
   * @param field2 The purpose of the reference variable field2 is to reference the JLabel class to create a new JLabel that continues to talk about the creators of the game.
   */ 
  private void dialog ()
  {
    final JDialog D = new JDialog (this, "About IJ Computers of Science");
    D.setSize (800, 200);
    D.setResizable (false);
    D.setLayout (new FlowLayout ());
    JButton button = new JButton ("Close");
    JLabel field1 = new JLabel ("This program was created by Jerry Liu and Isis So from IJ Computers of Science.");
    JLabel field2 = new JLabel("They are currently Grade 10 students at William Lyon Mackenzie taking ICS 4U0 and SCH 3U3.");
    field1.setFont (new Font ("Serif", Font.PLAIN, 16));
    field2.setFont (new Font ("Serif", Font.PLAIN, 16));
    D.add (field1);
    D.add(field2);
    button.addActionListener (new ActionListener (){
      public void actionPerformed (ActionEvent e)
      {
        D.dispose ();
      }
    });
    D.add (button);
    D.setLocationRelativeTo (this);
    D.setVisible (true);
  }
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent.
   * The purpose of the first if statement is to check which file menu choice they clicked on.
   * The purpose of the second if statement is to check if the user clicked on the about file menu choice.
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   * @exception IOException The purpose of the try catch structure is to catch errors regarding file io.
   */
  public void actionPerformed (ActionEvent ae)
  {
    if(ae.getActionCommand().equals("Quit"))
      System.exit (0);
    else if(ae.getActionCommand().equals("CHM File"))
    {
      try{
        Runtime.getRuntime().exec("HH.EXE ms-its:ChemistryBlaster.chm::/Welcome.html");
      } 
      catch (IOException e){
      }
    }
    else{
      if(ae.getActionCommand().equals("About"))
        dialog();
    }
  }
}
