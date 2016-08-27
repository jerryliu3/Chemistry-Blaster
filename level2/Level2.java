package level2;
import app.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * The Level2 class creates the second level of the Chemistry Blaster game. (Hours spent: 13.5)
 * 
 * @author       Isis So
 * @version 1.0 May 16, 2014
 * @version 2.0 May 23, 2014 Methods added
 * @version 3.0 May 30, 2014 Added pause, made text fields to show lives, scores, waves
 * @version 4.0 June 6, 2014 Changed output for text fields, added teaching tutorial before game, changed to fit with packages, changed randomizeFlasks() method
 * @version 5.0 June 12, 2014 Changed teaching method before game
 */ 
public class Level2 extends JPanel implements ActionListener
{
  /**
   * s   SpringLayout   This variable references the SpringLayout class so the layout of the JPanel can be set to Spring Layout.
   */
  private SpringLayout s = new SpringLayout();
  
  /**
   * gameData   NewGame   This variable references the NewGame class to record the user's stats (score, lives, etc).
   */
  private NewGame gameData;
  
  /**
   * spaceship   BufferedImage   This variable is used to store the image of the spaceship used during the game.
   */
  private BufferedImage spaceship;
  
  /**
   * controlSpaceship BufferedImage     The purpose of the reference variable controlSpaceship is to reference the ControlSpaceship3 class to allow the user to move the spaceship and shoot lasers.
   */  
  private ControlSpaceship controlSpaceship;
  
  /**
   * controlSpaceship   ControlSpaceship   This variable is used to reference the ControlSpaceship class, which allows the user to control the spaceship using the arrow keys.
   */
  private BufferedImage teach2;
  
  /**
   * pause   JButton   This variable is used to create a new JButton for the user to pause the game. 
   */
  private JButton pause;
  
  /**
   * numToDrop   int   This variable is used to store the random number of flasks to drop on the screen at once.
   */
  private int numToDrop;
  
  /**
   * hit   int   This variable is used to store the number of flasks that should be hit before moving onto the next level. The variable is initiated a value of 15; thus, 15 flasks must be correctly hit.
   */
  private int hit = 15;
  
  /**
   * teaching      int       The purpose of the integer variable teaching is to store whether or not the user is currently being taught how to play the level.
   */
  private int teaching;
  
  /**
   * t   Timer   The purpose of the variable is to reference the Timer class so that a timer can be created and used.
   */
  private Timer t = new Timer (7, this);
  
  /**
   * flasks   ArrayList<Flask>   This variable is used to create an ArrayList of Flask. The ArrayList stores the flasks that are to fall.
   */
  private ArrayList<Flask> flasks = new ArrayList<Flask>();
  
  /**
   * compounds   ArrayList<Compound>   This variable is used to create an ArrayList of Compound. The ArrayList stores the possible compounds of the flasks that are to fall.
   */
  private ArrayList<Compound> compounds = new ArrayList<Compound>();
  
  /**
   * location   ArrayList<Integer>   This variable is used to create an ArrayList of Integer. The ArrayList stores the 4 possible x-locations of the flasks that are to fall.
   */
  private ArrayList<Integer> locations = new ArrayList<Integer>();
  
  /**
   * taught        boolean       The purpose of the boolean variable taught is to store whether or not the teaching screen has appeared.
   */
  private boolean taught;
  
  /**
   * compoundToHit String This variable is used to store the type of compound that is supposed to be hit. 
   */
  private String compoundToHit;
  
  /**
   * c ChemistryBlasterApp This variable refers to the ChemistryBlasterApp class. 
   */ 
  private ChemistryBlasterApp c;
  
  /**
   * The purpose of the constructor Level2(NewGame n) is to retrieve the correct data of the user's current game (lives, scores, etc.) and start the game.
   * @param c ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @param n The purpose of the reference variable n is to reference the NewGame class so that the score and lives can be recorded.
   * @param r This variable is used to store a randomized number of 0 or 1. If the value is 0, then molecular compounds need to be hit; otherwise, ionic compounds need to be hit.
   * @exception IOException The purpose of the try catch is to prevent errors regarding IO from crashing the program.
   */
  public Level2(NewGame n, ChemistryBlasterApp c){
    this.c = c;
    if (n != null)
      gameData = n;
    else
      gameData = new NewGame(3);
    setLayout(s);
    setBackground(new Color(30,144,255));
    setVisible(true);
    try{
      spaceship = ImageIO.read(new File("graphics/Spaceship.png"));
      teach2 = ImageIO.read(new File("graphics/Level2Teach2.png"));
    }
    catch(IOException e){
    }
    if(Math.random() < 0.5)
      compoundToHit = "molecular";
    else
      compoundToHit = "ionic";
    pause = new JButton("Pause");
    pause.addActionListener(this);
    s.putConstraint(SpringLayout.WEST, pause, 10, SpringLayout.WEST, this);
    s.putConstraint (SpringLayout.SOUTH, pause, -10, SpringLayout.SOUTH, this);
    pause.setMnemonic('W');
    add(pause);
    readCompounds();
    randomizeFlasks();
    controlSpaceship = new ControlSpaceship();
    t.start();
    this.repaint();
    this.revalidate();
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
   * This method is used to read the compounds from the file of compounds using an if statement to check if the header is correct, and a while loop to read the file.   * @param read BufferedReader This variable references the BufferedReader class to use its methods and variables.
   * @param compoundType String This variable is used to store the compound type of the compound.
   * @param formula String This variable is used to store the formula of the compound.
   * @param c Compound This variable is used to make a new Compound object.
   * @exception   IOException   Exception is caught when the file cannot be properly read, which causes an exception to be thrown.
   */ 
  private void readCompounds(){
    BufferedReader read;
    String compoundType = "", formula = "";
    try{
      read = new BufferedReader(new FileReader("level2/Compounds.ijc"));
      if (read.readLine().equals ("Chemistry Blaster Compounds")){
        int count = Integer.parseInt(read.readLine());
        for(int x=0;x<count;x++){
          compoundType = read.readLine();
          formula = read.readLine();
          Compound c = new Compound (compoundType, formula);
          compounds.add (c);
        }
      }
    }
    catch(IOException e){
    }
  }
  /**
   * The purpose of the method paintComponent(Graphics g) is to draw the spaceship and falling flasks with compounds.
   * The first for loop is used to draw and examine all the flasks. The first for loop inside this one is used to split up the formula of each compound in each flask. 
   * The second for loop inside the main one is used to draw the formula character by character. The if statements are used resize characters for subscripts.
   * @param g The purpose of the reference variable g is to reference the Graphics class so that the images can be drawn.
   * @param characters This variable is used to store the characters of each compound formula, so that the formula can be subscripted properly.
   */
  public void paintComponent (Graphics g){
    super.paintComponent(g);
    if(teaching!=0 && teaching <=1500 && !taught)
      g.drawImage(teach2, 0, 0, null);
    else{
      for (int r = 0; r < flasks.size(); r++){
        ArrayList<Character> characters = new ArrayList<Character>();
        g.drawImage(flasks.get(r).getFlask(), flasks.get(r).getX(), flasks.get(r).getY(), null);
        g.setColor(Color.black);
        for(int l = 0; l < flasks.get(r).getCompound().getFormula().length(); l++)
          characters.add(flasks.get(r).getCompound().getFormula().charAt(l));
        for(int y = 0, x =6; y < characters.size(); y++, x=x+9){
          if(Character.isDigit(characters.get(y)))
            g.setFont(new Font("Calibri", Font.PLAIN, 10));
          else
            g.setFont(new Font("Calibri", Font.PLAIN, 15));
          g.drawString(characters.get(y).toString(), flasks.get(r).getX() + x, flasks.get(r).getY() + 65);
        }
      }
      g.drawImage(spaceship,controlSpaceship.getX(),controlSpaceship.getY(), null);
      g.setFont(new Font("Calibri", Font.PLAIN, 18));
      g.setColor(Color.black);
      g.drawString("Score: " + Integer.toString(gameData.getScore()), 25, 500);
      g.drawString("Lives:" + Integer.toString(gameData.getLives()), 100, 500);
      g.drawString("Need to Hit: " + Integer.toString(hit), 175, 500);
      g.drawString("Hit this compound type: " + compoundToHit, 325, 500);
    }
  }
  
  /**
   * The randomizeFlasks() method is used to randomize a number of flasks to drop, recreate the flasks to drop, randomize their x-locations, and add new randomized compounds using 3 for loops. The score, number of lives, and number of flasks left to hit are also updated. 
   */ 
  private void randomizeFlasks(){
    numToDrop = (int)(Math.random()*4)+1;
    locations = new ArrayList<Integer>();
    for (int x = 100; x<= 1000; x+=250)
      locations.add(x);
    flasks = new ArrayList<Flask>();
    for (int i = 0; i < numToDrop; i++){
      flasks.add(new Flask(locations.remove((int)(Math.random()*locations.size())),compounds.get((int)(Math.random()*compounds.size())) ));
    }
  }
  
  /**
   * The purpose of the method actionPerformed(ActionEvent ae) is to perform certain actions based on what the program is doing.
   * The purpose of the try catch structure is to stop errors regarding NullPointerExceptions from crashing the program.
   * The purpose of the first for loop is to allow all the dropped flasks to be examined. The mext 2 for loops inside this one traverses through the x and y values of the flasks.
   * The if statement inside these nested for loops checks whether the user's spaceship hit the flasks. The if statement inside this one checks if the user hit the flask containing the correct compound, in which case, score increases, the flask is removed, and the number left to hit decreases. Otherwise, the user loses a life.
   * The next if statement checks if a set of flasks has finished its fall, in which case, a new set of flasks falls. 
   * The purpose of the next if structure is to check if the game is finished (whether the user lost or won) and what to do.
   * The purpose of the last if structure is to check if the user has paused. 
   * @param ae The purpose of the reference variable ae is to get the action that the user did. 
   * @param e The purpose of the reference variable e is to reference the NullPointerException class so that NullPointerExceptions can be caught and prevent the program from crashing.
   * @exception NullPointerException The exception is caught if there it points to null while reading if the user paused the game.
   */
  public void actionPerformed(ActionEvent ae){
    if(!taught){
      teaching++;
      repaint();
      if(teaching==1000){
        taught = true;
        addKeyListener();
      }
      this.invalidate();
      this.validate();
      this.repaint();
      return;
    }
    for (int f = 0; f < flasks.size(); f++){
      for(int x = flasks.get(f).getX(); x < flasks.get(f).getX() + 50; x++){
        for(int y = flasks.get(f).getY(); y < flasks.get(f).getY() + 70; y++){
          if((x >= controlSpaceship.getX() && x <= controlSpaceship.getX() + spaceship.getWidth(null)) && (y >= controlSpaceship.getY() && y <= controlSpaceship.getY() + spaceship.getHeight(null))){
            if(flasks.get(f).getCompound().getCompoundType().equals(compoundToHit.toString())){
              hit--;              
              gameData.setScore(1);
            }
            else
              gameData.setLives(false);
            flasks.remove(f);
            randomizeFlasks();
            return;
          }
        }
      }
      flasks.get(f).setY(flasks.get(f).getY()+1);
      if(flasks.get(f).getY() >= 600){
        randomizeFlasks();
        break;
      }
    }
    if(gameData.getLives()==0 || hit == 0){
      repaint();
      t.stop();
      if(gameData.getLives()==0)
        c.determinePanel(new HighScores(gameData, c));
      else{
        c.determinePanel(new LevelTransition(gameData, c));
        return;
      }
    }
    try{
      if(ae.getActionCommand().equals("Pause")){
        pause();
        return;
      }
    }
    catch(NullPointerException e){
    }
    this.invalidate();
    this.validate();
    this.repaint();
  }
}