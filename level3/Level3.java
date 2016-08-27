package level3;
import app.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * The purpose of the Level3 class is to create the third level of the game.
 * @author Jerry Liu (15 hours) & Isis So (0.5 hours for changing display method for lives, scores, etc, errortrapped pause)
 * @version 1.0 May 23, 2014 Methods added and changed to improve quality
 * @version 2.0 May 30, 2014 Added pause, made text fields to show lives, scores, waves
 * @version 3.0 June 6, 2014 Changed output for text fields, added teaching tutorial before game, changed to fit with packages, errortrapped pause
 * @version 4.0 June 12, 2014 Changed teaching method before game, added dialog method
 */
public class Level3 extends JPanel implements ActionListener
{
  /**
   * a        AlienSpaceship             The purpose of the reference variable a is to reference the AlienSpaceship class to create a new alien spaceship to be shot.
   */
  private AlienSpaceship a;
  
  /**
   * s        SpringLayout             The purpose of the reference variable s is to reference the SpringLayout class to set the layout of the level to SpringLayout.
   */
  private SpringLayout s = new SpringLayout();
  
  /**
   * gameData     NewGame             The purpose of the reference variable gameData is to reference the NewGame class to store the game being played.
   */
  private NewGame gameData;
  
  /**
   * spaceship BufferedImage            The purpose of the reference variable spaceship is to store the picture of the spaceship.
   */
  private BufferedImage spaceship;
  
  /**
   * controlSpaceship BufferedImage     The purpose of the reference variable controlSpaceship is to reference the ControlSpaceship3 class to allow the user to move the spaceship and shoot lasers.
   */  
  private ControlSpaceship3 controlSpaceship;
  
  /**
   * teach3        BufferedImage     The purpose of the reference variable teach1 is to store the image of the teaching screen that is used in the beginning of the level.
   */
  private BufferedImage teach3;
  
  /**
   * pause    JButton             The purpose of the reference variable pause is to reference the JButton class to create a JButton that the user can click on to pause the game.
   */
  private JButton pause;
  
  /**
   * t        Timer             The purpose of the reference variable t is to reference the Timer class to create a new Timer that is used in level 3.
   */
  private Timer t = new Timer (15, this);
  
  /**
   * lasers   ArrayList <Laser>     The purpose of the reference variable lasers is to reference the ArrayList class to create an ArrayList of Laser objects.
   */
  private ArrayList <Laser> lasers = new ArrayList<Laser>();
  
  /**
   * equation reference             The purpose of the reference variable equation is to reference the Equation class to store the current Equation.
   */
  private Equation equation;
  
  /**
   * c ChemistryBlasterApp This variable refers to the ChemistryBlasterApp class. 
   */
  private ChemistryBlasterApp c;
  
  /**
   * teaching      int       The purpose of the integer variable teaching is to store whether or not the user is currently being taught how to play the level.
   */
  private int teaching;
  
  /**
   * counter       int      The purpose of the integer variable counter is to store how many equations were balanced.
   */
  private int counter;
 
  /**
   * taught        boolean       The purpose of the boolean variable taught is to store whether or not the teaching screen has appeared.
   */
  private boolean taught;
  
  /**
   * The purpose of the constructor Level3(NewGame n) is to create the game.
   * The purpose of the first if statement is to check if there has already been a NewGame created.
   * @param c ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @param n The purpose of the reference variable n is to reference the NewGame class so that the score and lives can be recorded.
   * @exception IOException The purpose of the try catch is to catch errors regarding IO when getting the picture for the spaceship.
   */
  public Level3(NewGame n, ChemistryBlasterApp c)
  {
    this.c = c;
    setLayout(s);
    setBackground(Color.black);
    if (n != null)
      gameData = n;
    else
      gameData = new NewGame(3);
    try
    {
      spaceship = ImageIO.read(new File("graphics/Spaceship.png"));
      teach3 = ImageIO.read(new File("graphics/Level3Teach1.png"));
    }
    catch(IOException e)
    {    
    }
    pause = new JButton("Pause");
    pause.setMnemonic('W');
    pause.addActionListener(this);
    s.putConstraint(SpringLayout.WEST, pause, 10, SpringLayout.WEST, this);
    s.putConstraint (SpringLayout.SOUTH, pause, -10, SpringLayout.SOUTH, this);
    setVisible(true);
    controlSpaceship = new ControlSpaceship3(this);
    dialog();
    this.repaint();
    this.revalidate();
    a = new AlienSpaceship();
    update();
  }
  
  /**
   * This method is used to add a KeyListener for the user to control the spaceship with the arrow keys.
   */ 
  private void addKeyListener(){
    addKeyListener(controlSpaceship); 
  }
  
  /**
   * The purpose of the pause method is to pause the program and make a JDialog appear so the user can take a break, return to the main menu or exit the game.
   * The inner classes are used to determine what action should be performed when the buttons "Resume", "Main Menu", and "Exit Game" are pressed.
   * @param C The purpose of the final reference variable C is to reference the ChemistryBlasterApp class so that the methods inside it can be used.
   * @param D The purpose of the final reference variable D is to reference the JDialog class so that a new JDialog can be created.
   * @param button The purpose of the reference variable button is to reference the JButton class so that a button to unpause the game can be made.
   * @param close The purpose of the reference variable close is to reference the JButton class so that a button to exit the program can be made.
   * @param field1 The purpose of the reference variable field1 is to reference the JLabel class so that it can tell the user they've paused the program.
   * @param e The purpose of the reference variable e is to reference the ActionEvent class so that what the user clicks on can be processed.
   */
  private void pause(){
    t.stop();
    final JDialog D = new JDialog (c, "Paused");
    D.setSize (180, 100);
    D.setResizable (false);
    D.setUndecorated(true);
    c.setEnabled(false);
    D.setLayout (new FlowLayout ());
    JButton button = new JButton ("Resume");
    JButton close = new JButton ("Exit Game");
    JLabel field1 = new JLabel ("You have paused the game.");
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
        c.setEnabled(true);
        requestFocusInWindow();
        D.dispose ();
      }
    });
    close.addActionListener (new ActionListener (){
      public void actionPerformed (ActionEvent e){
        c.setEnabled(true);
        gameData = null;
        c.determinePanel(new MainMenu(c));
        D.dispose();
      }
    });
  }
  
  /**
   * The purpose of the dialog() method is to create a JDialog that makes sure the user understands how to balance an equation before playing the level.
   * @param D The purpose of the final reference variable D is to reference the JDialog class to create a new JDialog window that teaches the user how to balance equations.
   */
  private void dialog(){
    final JDialog D = new JDialog (c, "How to balance an equation");
    D.setSize (1200, 600);
    D.setUndecorated(true);
    D.setResizable (false);
    SpringLayout s = new SpringLayout();
    D.setLayout (s);
    ImageIcon pic = new ImageIcon("graphics/Level3TestPicture.png");
    JLabel explain = new JLabel();
    explain.setIcon(pic);
    D.add (explain);
    final TestEquation EQUATION= new TestEquation("2 Fe + _ Cl2 --> 2 FeCl3", "2 Fe + 3 Cl2 --> 2 FeCl3");
    final JTextField ANSWERFIELD = new JTextField(20);
    JButton exitButton=new JButton("Submit");
    s.putConstraint(SpringLayout.WEST, ANSWERFIELD, 100, SpringLayout.WEST, this);
    s.putConstraint(SpringLayout.NORTH, ANSWERFIELD, 15, SpringLayout.SOUTH, explain);
    s.putConstraint(SpringLayout.WEST, exitButton, 5, SpringLayout.EAST, ANSWERFIELD);
    s.putConstraint(SpringLayout.NORTH, exitButton, 0, SpringLayout.NORTH, ANSWERFIELD);
    D.add(ANSWERFIELD);
    ANSWERFIELD.setText(EQUATION.getQuestion());
    D.add(exitButton);
    D.setLocationRelativeTo (this);
    D.setVisible (true);
    D.invalidate();
    D.validate();
    D.repaint();
    exitButton.addActionListener (new ActionListener ()
                                    {
      public void actionPerformed (ActionEvent e){
        if(ANSWERFIELD.getText().equals(EQUATION.getAnswer())){
          JOptionPane.showMessageDialog(D, "You balanced the equation! Get ready to play level 3!", "Success!", JOptionPane.PLAIN_MESSAGE);
          add(pause);
          t.start();
          D.dispose();
        }
        else{
          JOptionPane.showMessageDialog(D, "Sorry, that was incorrect. Try again!", "Nice try!", JOptionPane.PLAIN_MESSAGE);
          ANSWERFIELD.setText(EQUATION.getQuestion());
        }}});
  }
  
  /**
   * The purpose of the method paintComponent(Graphics g) is to draw the spaceship, lasers and alien spaceship.
   * The purpose of the first if statement is to check if the laser reached the end of the screen.
   * The purpose of the second if statement is to check if the laser hit the alien spaceship.
   * The purpose of the third if statement is to check what the size of the character should be.
   * The first for loop is used to go through all the lasers and move them, as well as check if the laser has reached the end of the screen or hit the alien spaceship.
   * The second for loop is used to add all the characters of the Equation to an ArrayList.
   * The third for loop is used to draw the formula character by character. The if statements are used resize characters for subscripts.
   * @exception NullPointerException The try catch catches null pointer exceptions to prevent the program from crashing when accessing Lasers.
   * @param g The purpose of the reference variable g is to reference the Graphics class so that the images can be drawn.
   * @param characters This variable is used to store the characters of each compound formula, so that the formula can be subscripted properly.
   * @param l The purpose of the reference variable l is to reference the Laser class to go through all the lasers.
   */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    if(teaching!=0 && teaching <=1500 && !taught)
    {
      g.drawImage(teach3, 0, 0, null);
    }
    else
    {
      g.drawImage(spaceship,controlSpaceship.getX(),controlSpaceship.getY(), null);
      g.drawImage(a.getAlien(), a.getX(), a.getY(), null);
      ArrayList<Character> characters;
      try
      {
        for(Laser l : lasers)
        {
          characters = new ArrayList<Character>();
          l.setX(l.getX()+3);
          g.setColor(Color.white);
          for(int x = 0; x < l.getString().length(); x++)
            characters.add(l.getString().charAt(x));
          g.setFont(new Font("Calibri", Font.PLAIN, 15));
          g.drawString(characters.get(0).toString(), l.getX(), l.getY());
          for(int y = 1, z = 9; y < characters.size(); y++, z=z+9)
          {
            if(Character.isDigit(characters.get(y)))
              g.setFont(new Font("Calibri", Font.PLAIN, 10));
            else
              g.setFont(new Font("Calibri", Font.PLAIN, 15));
            g.drawString(characters.get(y).toString(), l.getX() + 6 + z, l.getY());
          }
          if(l.getX()>1000)
          {
            lasers.remove(l);
            break;
          }
          else
          {
            if(l.getString().equals(equation.getCompound()) && l.getX() + l.getString().length()*6>a.getX() && l.getX()<a.getX()+a.getAlien().getWidth(null) && l.getY()>a.getY() && l.getY() <a.getY()+150)
            {
              lasers.remove(l);
              equation.increaseCounter();
              break;
            }
          }
        }
      }
      catch(NullPointerException e)
      {}
      //start
      g.setColor(Color.white);
      characters = new ArrayList<Character>();
      for(int l = 0; l < equation.displayEquation().length(); l++)
        characters.add(equation.displayEquation().charAt(l));
      g.setFont(new Font("Calibri", Font.PLAIN, 15));
      g.drawString(characters.get(0).toString(), a.getX() + 6, a.getY() + 200);
      for(int y = 1, x = 9; y < characters.size(); y++, x=x+9){
        if(Character.isDigit(characters.get(y)) && characters.get(y-1).charValue()!=32 && (characters.get(y-1).charValue() <48 || characters.get(y-1).charValue()>57))
          g.setFont(new Font("Calibri", Font.PLAIN, 10));
        else
          g.setFont(new Font("Calibri", Font.PLAIN, 15));
        g.drawString(characters.get(y).toString(), a.getX() + 6 + x, a.getY() + 200);
      }
      g.setFont(new Font("Calibri", Font.PLAIN, 18));
      g.setColor(new Color(30,144,255));
      g.drawString("Score: " + Integer.toString(gameData.getScore()), 25, 500);
      g.drawString("Lives:" + Integer.toString(gameData.getLives()), 100, 500);
      g.drawString("Spaceships Destroyed: " + Integer.toString(counter), 175, 500);
    }
  }
  
  /**
   * The purpose of the method actionPerformed(ActionEvent ae) is to perform certain actions based on what the program is doing.
   * The purpose of the first if statement is to check if the user clicked on the pause button.
   * The purpose of the second if statement is to check if the alien spaceship has reached the end of the screen.
   * The purpose of the third if statement is to check if the user hit the alien spaceship the correct number of times.
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class to get the action that the user did.
   * @exception NullPointerException The purpose of the try catch structure is to stop errors regarding NullPointerExceptions from crashing the program.
   */
  public void actionPerformed(ActionEvent ae)
  {
    if(!taught)
    {
      teaching++;
      repaint();
      if(teaching==500)
      {
        taught = true;
        addKeyListener();
      }
      this.invalidate();
      this.validate();
      this.repaint();
      return;
    }
    try{
      if(ae.getActionCommand().equals("Pause")){
        pause();
      }
    }
    catch(NullPointerException e){
    }
    
    if(gameData.getLives()==0 || a.getEquationsLeft()==0){
      t.stop();
      if(a.getEquationsLeft()==0)
        c.determinePanel(new WinScreen(gameData, c));
      else
        c.determinePanel(new HighScores(gameData, c));
      return;
    }
    if(a.getY()>550)
    {
      if(equation.getAnswer() == equation.getCounter())
      {
        gameData.setScore(equation.getCounter());
        counter++;
      }
      else
      {
        gameData.setLives(false);
        gameData.setScore(Math.abs(equation.getAnswer() - equation.getCounter()) * -1);
      }
      update();
    }
    a.setY(a.getY()+1);
    this.invalidate();
    this.validate();
    this.repaint();
  }
  
  /**
   * The purpose of the addLaser(Laser newL) method is to add a new Laser to the lasers ArrayList.
   * @param newL The purpose of the reference variable newL is to reference the Laser class to store the Laser to be added.
   */
  public void addLaser(Laser newL)
  {
    newL.setString(equation.getCompound());
    lasers.add(newL); 
  }
  
  /**
   * The purpose of the update() method is to create a new AlienSpaceship and get a random equation, as well as update the current lives and score.
   */
  private void update()
  {
    a.setY(-250);
    equation = a.getRandomEquation();
  }
}