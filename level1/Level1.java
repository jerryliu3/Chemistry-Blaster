package level1;
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
 * The purpose of the Level1 class is to create the first level of the ChemistryBlaster game.
 * @author Jerry Liu (12 hours) & Isis So (1 hour; changed display method for lives, scores, etc, errortrapped pause)
 * @version 1.0 May 16, 2014
 * @version 2.0 May 23, 2014 Methods added and changed to improve quality
 * @version 3.0 May 30, 2014 Added pause, made text fields to show lives, scores, waves
 * @version 4.0 June 6, 2014 Changed output for text fields, added teaching tutorial before game, changed to fit with packages, errortrapped pause
 * @version 5.0 June 12, 2014 Changed teaching method before game
 */
public class Level1 extends JPanel implements ActionListener
{
  /**
   * s             SpringLayout     The purpose of the reference variable s is to reference the SpringLayout class so the layout can be set to Spring Layout.
   */
  private SpringLayout s = new SpringLayout();
  
  /**
   * t             Timer     The purpose of the reference variable t is to reference the Timer class so that a timer can be created and used.
   */
  private Timer t;
  
  /**
   * a             Asteroid     The purpose of the reference variable a is to reference the Asteroid class so that Asteroids can be created.
   */
  private Asteroid a;
  
  /**
   * counter       int           The purpose of the integer variable counter is to store how many asteroids the user has destroyed on the current wave.
   */
  private int counter;
  
  /**
   * spaceship     BufferedImage     The purpose of the reference variable spaceship is to store the image of the spaceship used during the game.
   */
  private BufferedImage spaceship;
  
  /**
   * teach1        BufferedImage     The purpose of the reference variable teach1 is to store the image of the teaching screen that is used in the beginning of the level.
   */
  private BufferedImage teach1;
  
  /**
   * displayQuestion JLabel   The purpose of the reference variable displayQuestion is to reference the JLabel class so that the question can be displayed.
   */
  private JLabel displayQuestion;
  
  /**
   * choose        reference     The purpose of the reference variable choose is to reference the ArrayList class to create an ArrayList of JButtons.
   */
  private ArrayList<JButton>choose = new ArrayList<JButton>();
  
  /**
   * choice1       JButton     The purpose of the reference variable choice1 is to reference the JButton class so that a choice for the question can be clicked.
   */
  private JButton choice1;
  
  /**
   * choice2       JButton     The purpose of the reference variable choice2 is to reference the JButton class so that a choice for the question can be clicked.
   */
  private JButton choice2;
  /**
   * choice3       JButton     The purpose of the reference variable choice3 is to reference the JButton class so that a choice for the question can be clicked.
   */
  private JButton choice3;
  
  /**
   * choice        Question     The purpose of the reference variable chocie is to reference the Question class to store the Question chosen to be asked.
   */
  private Question choice;
  
  /**
   * wave          int           The purpose of the integer variable wave is to store which wave the user is on.
   */
  private int wave;
  
  /**
   * delay         int           The purpose of the integer variable delay is to store the delay for the timer to decide how fast the asteroid moves.
   */
  private int delay;
  
  /**
   * gameData      NewGame     The purpose of the reference variable gameData is to reference the NewGame class to record the user's stats (score, lives, etc).
   */
  private NewGame gameData;
  
  /**
   * pause         JButton     The purpose of the refernece variable pause is to create a button that the user can press to pause the game.
   */
  private JButton pause;
  
  /**
   * c             reference     The purpose of the reference variable c is to reference the ChemsitryBlasterApp to be able to access the methods inside of it.
   */
  private ChemistryBlasterApp c;
  
  /**
   * taught        boolean       The purpose of the boolean variable taught is to store whether or not the teaching screen has appeared.
   */
  private boolean taught = false;
  
  /**
   * teaching      int           The purpose of the integer variable teaching is to store whether or not the user is currently being taught how to play the level.
   */
  private int teaching;
  
  /**
   * The purpose of the constructor Level1(NewGame n) is to create the questions, and start the game.
   * The purpose of the try catch structure is to prevent the program from crashing when it's reading the spaceship image.
   * @exception IOException The purpose of the try catch is so that errors regarding IO can be caught and prevent the program from crashing.
   * @param n The purpose of the reference variable n is to reference the NewGame class so that the score and lives can be recorded.
   */
  public Level1(NewGame n, ChemistryBlasterApp c){
    this.c = c;
    gameData = n;
    setLayout(s);
    setBackground(Color.black);
    setVisible(true);
    a = new Asteroid();
    try{
      spaceship = ImageIO.read(new File("graphics/Spaceship.png"));
      teach1 = ImageIO.read(new File("graphics/Level1Teach3.png"));
    }
    catch(IOException e){
    }
    wave = 1;
    delay = 20;
    t = new Timer(delay, this);
    t.start();
    setVisible(true);
    this.repaint();
    this.revalidate();
    pause = new JButton("Pause");
    pause.setMnemonic('W');
    pause.addActionListener(this);
    s.putConstraint(SpringLayout.WEST, pause, 10, SpringLayout.WEST, this);
    s.putConstraint (SpringLayout.SOUTH, pause, -10, SpringLayout.SOUTH, this);
    add(pause);
    update();
  }
  
  /**
   * The purpose of the pause method is to pause the program and make a JDialog appear so the user can take a break or exit the game.
   * The inner classes are used to determine what action should be performed when the buttons "Resume" and "Exit Game" are pressed.
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
   * The purpose of the method paintComponent(Graphics g) is to draw the asteroid and spaceship.
   * The purpose of the if statement is to check if the teaching picture should be drawn or the asteroids and the spaceship.
   * @param g The purpose of the reference variable g is to reference the Graphics class so that the images can be drawn.
   */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    if(teaching>0 && teaching <=500 && !taught)
      g.drawImage(teach1, 0, 0, null);
    else{
      g.drawImage(a.getPicture(), a.getX(), 120, null);
      displayQuestion.setLocation(a.getX()+130, 295);
      g.drawImage(spaceship, 50, 200, null);
    }
    g.setFont(new Font("Calibri", Font.PLAIN, 18));
    g.setColor(new Color(30,144,255));
    g.drawString("Wave: " + Integer.toString(wave), 25, 500);
    g.drawString("Score: " + Integer.toString(gameData.getScore()), 100, 500);
    g.drawString("Lives:" + Integer.toString(gameData.getLives()), 175, 500);
  }
  
  /**
   * The purpose of the method update() is to display a new question and reset the asteroid.
   * The purpose of the try catch structure is to catch NullPointerExceptions when removing the buttons and the JLabel displaying the question.
   * @exception   NullPointerException   Exception is caught to prevent the program from crashing if there is nothing to remove.
   */
  private void update(){
    try{
      remove(choice1);
      remove(choice2);
      remove(choice3);
      remove(displayQuestion);
    }
    catch(NullPointerException e){
    }
    a.setX(900);
    choice = a.getRandomQuestion();
    displayQuestion = new JLabel(choice.getQuestion());
    add(displayQuestion);
    choose.add(new JButton(choice.getAnswer()));
    choose.add(new JButton(choice.getChoice1()));
    choose.add(new JButton(choice.getChoice2()));
    choice1 = choose.remove((int)(Math.random() * choose.size()));
    choice2 = choose.remove((int)(Math.random() * choose.size()));
    choice3 = choose.remove(0);
    
    s.putConstraint(SpringLayout.WEST, choice1, 50, SpringLayout.WEST, this);
    s.putConstraint(SpringLayout.NORTH, choice1, 20, SpringLayout.NORTH, this);
    add(choice1);
    choice1.addActionListener(this);
    s.putConstraint(SpringLayout.WEST, choice2, 50, SpringLayout.EAST, choice1);
    s.putConstraint(SpringLayout.NORTH, choice2,0, SpringLayout.NORTH, choice1);
    add(choice2);
    choice2.addActionListener(this);
    s.putConstraint(SpringLayout.WEST, choice3, 50, SpringLayout.EAST, choice2);
    s.putConstraint(SpringLayout.NORTH, choice3,0, SpringLayout.NORTH, choice2);
    add(choice3);
    choice3.addActionListener(this);
  }
  /**
   * The purpose of the method actionPerformed(ActionEvent ae) is to perform certain actions based on what the program is doing.
   * The purpose of the first if statement is to check if the user is not being taught.
   * The purpose of the second if statement is to check if the asteroid hit the spaceship.
   * The purpose of the third if statement is to check if the user hasn't been taught yet.
   * The purpose of the next if statement is to check if the asteroid reached the point where the user should be taught how to play the level.
   * The purpose of the next if statement is to check if the user is done being taught.
   * The purpose of the first if statement is to check if the user clicked on the pause button, or the correct answer.
   * The purpose of the next if structure is to check if the game is finished (whether the user lost or won) and what to do.
   * The purpose of the next if structure is to check if the user won the game.
   * The purpose of the next if structure is to check if the user has completed the wave.
   * @param ae The purpose of the reference variable ae is to get the action that the user did. 
   * @exception NullPointerException The purpose of the try catch structure is to stop errors regarding NullPointerExceptions from crashing the program.
   */
  public void actionPerformed(ActionEvent ae){
    if(teaching==0 || teaching == 500)
    {
      a.setX(a.getX()-1);
      if(a.getX()<=125){
        gameData.setLives(false);
        update();
        this.repaint();
      }
    }
    if(!taught)
    {
      if(a.getX()==500)
      {
        try
        {
          remove(displayQuestion);
        }
        catch(NullPointerException e)
        {}
        teaching++;
        repaint();
        if(teaching==500)
        {
          taught = true;
          add(displayQuestion);
        }
      }
      this.invalidate();
      this.validate();
      this.repaint();
      return;
    }
    try{
      if(ae.getActionCommand().equals("Pause")){
        pause();
        return;
      }
      else if(ae.getActionCommand().equals(choice.getAnswer())){
        gameData.setScore(1);
        counter++;
      }
      else
        gameData.setLives(false); 
      update();
    }
    catch(NullPointerException e){
    }
    if(gameData.getLives()==0 || counter == 3 && wave == 3){
      repaint();
      t.stop();
      if(gameData.getLives()==0)
        c.determinePanel(new HighScores(gameData, c));
      else{
        c.determinePanel(new LevelTransition(gameData, c));
        return;
      }
    }
    if(counter==3){
      wave++;
      delay -= 5;
      counter = 0;
      t.stop();
      t = new Timer(delay, this);
      t.start();
    }
    this.invalidate();
    this.validate();
    this.repaint();
  }
}