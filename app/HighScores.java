package app;
import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

/**
 * This class is used to display the top 10 scores of Chemistry Blaster. (Hours spent: 9)
 * 
 * @author Isis So and Jerry Liu
 * @version 1.0 May 16, 2014 screen dump made only (Isis)
 * @version 2.0 May 23, 2014 No changes 
 * @version 3.0 May 30, 2014 Added methods for high scores to work as intended (Isis)
 * @version 4.0 June 6, 2014 Changed to work with printer, changed sort with high scores (Jerry)
 * @version 5.0 June 12, 2014 Added shortcut keys, javadoc changed (Isis)
 */
public class HighScores extends JPanel implements ActionListener
{
  /**
   * s         SpringLayout      This variable references the SpringLayout class so the layout can be set to Spring Layout.
   */
  private SpringLayout s = new SpringLayout();
  
  /**
   * gameData  NewGame           This variable references the NewGame class to record the user's stats (score, lives, etc).
   */
  private NewGame gameData;
  
  /**
   * header    String            This variable stores the header that appears in the high scores file.
   */
  protected String header = "Chemistry Blaster High Scores";
  
  /**
   * names     ArrayList<String> This stores the names of the players that make the high scores list. 
   */
  private ArrayList<String> names = new ArrayList<String>();
  
  /**
   * scores    ArrayList<Integer>    This stores the scores of the players that make the high scores list. 
   */
  private ArrayList<Integer> scores = new ArrayList<Integer>();
  
  /**
   * levels    ArrayList<Integer>    This stores the levels of the players that make the high scores list. 
   */
  private ArrayList<Integer> levels = new ArrayList<Integer>();
  
  /**
   * c         ChemistryBlasterApp This variable refers to the ChemistryBlasterApp class so that the methods inside it can be used.
   */
  private ChemistryBlasterApp c;
  
  /**
   * This HighScores() constructor is used to display the high scores.
   * The purpose of the first if statement is to check if the variable n is not null.
   * The purpose of the second if statement is to check if the add() method should be called.
   * The purpose of the third if statement is to check if the number of high scores is greater than 1.
   * @param   n          NewGame   The purpose of the reference variable n is to reference the NewGame class so that the information inside it can be used.
   * @param   c          ChemistryBlasterApp This parameter pass passes in the current ChemistryBlasterApp reference. 
   * @param   backBtn    JButton   This is used for allowing the user to traverse back to the main menu from high scores. 
   * @param   eraseBtn   JButton   This is used for allowing the user to clear the list of high scores.
   * @param   printBtn   JButton   This is used for allowing the user to print the high scores.
   * @param   e          NullPointerException The purpose of the reference variable e is to reference the NullPointerException class so that errors regarind null values can be caught.
   * @exception NullPointerException The purpose of both the try catch structures are to catch NullPointerExceptions to prevent the program from crashing when using null values.
   */ 
  public HighScores(NewGame n, ChemistryBlasterApp c){
    this.c = c;
    try{
      if(!n.equals(null))
        gameData = n;
    }
    catch(NullPointerException e){
    }
    setLayout(s);
    setBackground (Color.black);
    JButton backBtn = new JButton ("Back to Main Menu");
    JButton eraseBtn = new JButton ("Erase Current Scores");
    JButton printBtn = new JButton ("Print High Scores");
    backBtn.setMnemonic('B');
    eraseBtn.setMnemonic('E');
    printBtn.setMnemonic('P');
    backBtn.addActionListener (this);
    eraseBtn.addActionListener (this);
    printBtn.addActionListener (this);
    s.putConstraint(SpringLayout.WEST, backBtn, 10, SpringLayout.WEST, this);
    s.putConstraint (SpringLayout.SOUTH, backBtn, -10, SpringLayout.SOUTH, this);
    s.putConstraint(SpringLayout.WEST, eraseBtn, 410, SpringLayout.WEST, backBtn);
    s.putConstraint (SpringLayout.SOUTH, eraseBtn, 0, SpringLayout.SOUTH, backBtn);
    s.putConstraint(SpringLayout.WEST, printBtn, 820, SpringLayout.WEST, backBtn);
    s.putConstraint (SpringLayout.SOUTH, printBtn, 0, SpringLayout.SOUTH, backBtn);
    add (backBtn);
    add (eraseBtn);
    add (printBtn);
    read();
    try{
      if(!gameData.equals(null) && scores.size()==10 && gameData.getScore() > scores.get(9) || gameData.getScore() >0)
      {
        add();
      }
    }
    catch(NullPointerException e){
    }
    if(names.size() > 1)
      sort();
  }
  
  /**
   * This method is used to sort the high scores in descending order and keep only the 10 high scores.
   * The first for loop is used to read through the ArrayList of scores, and the second for loop is used to insert the scores, names, and level into appropriate locations.
   * The while loop is used to store remove the last score, name, and level in the ArrayList until there are only 10 scores.
   * @param holdScore The purpose of the integer variable holdScore is to store the current score being sorted.
   * @param holdLevel The purpose of the integer variable holdLevel is to store the current level being sorted.
   * @param y The purpose of the integer variable y is to store the location of the current high score being sorted.
   * @param holdName The purpose of the String variable holdName is to store the current name of the high score being sorted.
   * @param x The purpose of the integer variable x is to allow a for loop to go through all the high scores and sort them.
   */ 
  private void sort(){
    int holdScore, holdLevel, y;
    String holdName;
    for (int x = 1 ; x < scores.size() ; x++)
    {
      holdScore = scores.get(x);
      holdName = names.get(x);
      holdLevel = levels.get(x);
      for (y = x ; y > 0 && holdScore > scores.get(y - 1) ; y--)
      {
        scores.set(y, scores.get(y-1));
        names.set(y, names.get(y-1));
        levels.set(y, levels.get(y-1));
      }
      scores.set(y, holdScore);
      names.set(y, holdName);
      levels.set(y, holdLevel);
    }
    int counter = scores.size()-10;
    while(scores.size() > 10){
      names.remove(counter-1);
      scores.remove(counter-1);
      levels.remove(counter-1);
      counter--;
    }
    save();
  }
  
  /**
   * This add() method is used to add a player's name and score to the high scores list.
   * The purpose of the while loop is to run until the user enters a proper name.
   * The purpose of the first if statement is to check if the name is not blank.
   * The purpose of the second if statement is to check if the length of the name is greater than 20.
   * @param s The purpose of the String variable s is to store the name of the user who just got a high score.
   */ 
  private void add(){
    String s = "";
    while(true){
      s = JOptionPane.showInputDialog(this, "Enter your name (20 characters maximum):", "You've made high scores!", JOptionPane.WARNING_MESSAGE);
      if(!s.equals(""))
      {
        if(s.length() > 20)
          names.add(s.substring(0, 20));
        else
          names.add(s);
        break;
      }
    }
    scores.add(gameData.getScore());
    levels.add(gameData.getLevel());
    save();
  }
  
  /**
   * This read() method is used to read the high scores from the file they have been saved to.
   * The purpose of the first if statement is to check if the header of the file is correct.
   * The purpose of the for loop is to go through all the high scores in the file.
   * @param read BufferedReader This variable is used to create a new BufferedReader object.
   * @param name String This variable is used to store the name that is read directly from the file.
   * @param score String This variable ise used to store the score that is read directly from the file.
   * @param level String This variable ise used to store the level that is read directly from the file.
   * @param f The purpose of the reference variable f is to reference the NumberFormatException and FileNotFoundException classes to catch errors regarding number format problems and the file not being found.
   * @param n The purpose of the reference variable n is to reference the NullPointerException class to catch errors regarding null values.
   * @param e The purpose of the reference variable e is to reference the IOException class to catch errors regarding file io.
   * @param count The purpose of the integer variable count is to store the number of high scores in the file.
   * @exception NumberFormatException The exception is caught if there is a NumberFormatException error when trying to parse the score into an integer.
   * @exception NullPointerException The exception is caught if there is a NullPointerException error when reading for the file.
   * @exception FileNotFoundException The exception is caught if the file is not found when reading for the file.
   * @exception IOException The exception is caught if there are any IO errors when the file is read.
   */ 
  private void read(){
    BufferedReader read;
    String name, score, level;
    try{
      read = new BufferedReader (new FileReader ("app/HighScores.ijc"));
      if(read.readLine().equals(header)){
        int count = Integer.parseInt(read.readLine());
        for(int x=0;x<count;x++){
          name = read.readLine();
          names.add(name);
          score = read.readLine();
          level = read.readLine();
          try{
            scores.add(Integer.parseInt(score));
            levels.add(Integer.parseInt(level));
          }
          catch(NumberFormatException f){
            throw new IOException();
          }
        }
      }
      read.close();
    }
    catch (NullPointerException n){
    }
    catch (FileNotFoundException f){
    }
    catch (IOException e){        
    }
  }
  
  /**
   * The purpose of the method paintComponent(Graphics c) is to draw the high scores.
   * The for loop is used to draw the high scores on the screen.
   * @param c The purpose of the reference variable c is to reference the Graphics class so that the images can be drawn.
   * @param r The purpose of the integer variable r is to store the red that should be displayed.
   * @param g The purpose of the integer variable g is to store the green that should be displayed.
   * @param b The purpose of the integer variable b is to store the blue that should be displayed.
   * @param height The purpose of the integer variable height is to store the height that the high score should be displayed.
   */
  public void paintComponent(Graphics c){
    super.paintComponent(c);
    c.setColor(new Color (192,192,192));
    c.setFont(new Font("Stencil", Font.PLAIN, 70));
    c.drawString("High Scores", 275, 100);
    c.setFont(new Font("Calibri", Font.PLAIN, 28));
    int r = 0, g = 144, b = 255, height = 200;
    c.drawString("Player", 200, height - 50);
    c.drawString("Score", 530, height - 50);
    c.drawString("Level", 740, height - 50);
    for(int x = 0; x < names.size(); x++){
      c.setColor(new Color (r, g, b));
      c.drawString(names.get(x), 210, height);
      c.drawString(scores.get(x).toString(), 545, height);
      c.drawString(levels.get(x).toString(), 765, height);
      r+=10;
      g+=3;
      b-=6;
      height+=30;
    }
  }
  
  /**
   * This save() method is used to save the high scores into a file.
   * The for loop is used to read through all the names, scores, and levels.
   * @param out PrintWriter This variable is used to create a PrinterWriter object.
   * @param count The purpose of the integer variable count is to store the number of high scores there are.
   * @exception IOException The exception is caught if there are any IO errors when the file is read.
   */ 
  private void save(){
    PrintWriter out;
    try{
      out = new PrintWriter (new FileWriter ("app/HighScores.ijc"));
      out.println (header);
      out.println(names.size());
      for(int count = 0; count < names.size(); count++){
        out.println (names.get(count));
        out.println (scores.get(count));
        out.println (levels.get(count));
      }
      out.close();
    }
    catch (IOException e){
    }
  }
  
  /**
   * This print() method is used to create a new Printer object for printing high scores. The for loop is used to read through all the names, scores, and levels.
   * @param p Printer This variable is used to create a new Printer object.
   * @exception NullPointerException The exception is caught if the printer object is null when trying to be accessed.
   */
  private void print(){
    Printer p = new Printer();
    p.println("", "IJ COMPUTERS OF SCIENCE CHEMISTRY BLASTER HIGH SCORES", "");
    p.println("Names", "Scores", "");
    p.println();
    for(int x=0;x<names.size();x++){
      try{
        p.println(names.get(x),Integer.toString(scores.get(x)), Integer.toString(levels.get(x)));
      }
      catch(NullPointerException e){
      }
    }
    p.printUsingDialog();
  }
  
  /**
   * This erase() method is used to clear the high scores list.
   */ 
  private void erase(){
    names = new ArrayList<String>();
    levels = new ArrayList<Integer>();
    scores = new ArrayList<Integer>();
    save();
    read();
    JOptionPane.showMessageDialog(this, "There are no high scores anymore!", "Erased!", JOptionPane.PLAIN_MESSAGE);
  }
  
  /**
   * The purpose of the actionPerformed (ActionEvent ae) method is to process any time an ActionEvent is sent. 
   * The if statement determines what method to call with its corresponding button. 
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class so that ActionEvents will be sent to this method.
   */
  public void actionPerformed(ActionEvent ae)
  {
    if (ae.getActionCommand().equals ("Back to Main Menu"))
      c.determinePanel(new MainMenu(c));
    else if (ae.getActionCommand().equals ("Print High Scores"))
      print();
    else
      erase();
    this.invalidate();
    this.validate ();
    this.repaint();
  }
}