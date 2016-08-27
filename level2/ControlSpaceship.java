package level2;

import java.awt.event.*;
import javax.swing.*;
/**
 * This class is used to implement the controls for the user to control the spaceship with the arrow keys. (Hours spent: 2)
 * 
 * @author George Lim & Joshua Yuan, modified by Isis So and Jerry Liu
 * @version 1.0 May 30, 2014
 * @version 2.0 June 6, 2014 Made the class implement ActionListener and added appropriate methods.
 * @version 3.0 June 12, 2014 No changes
 */ 
public class ControlSpaceship extends KeyAdapter implements ActionListener
{
  /**
   * x        int       This private integer variable stores the x-coordinate of the left side of the spaceship.
   */
  private int x = 390;
  
  /**
   * y        int       The purpose of the private integer variable y is to store the y location of the top left corner of the spaceship.
   */
  private int y = 400;
  
  /**
   * velX     int       The purpose of the private integer variable velX is to store the amount horizontally the spaceship moves.
   */
  private int velX = 0;
  
  /**
   * velY     int       The purpose of the private integer variable velY is to store the amount vertically the spaceship moves.
   */
  private int velY = 0;
  
  /**
   * timer reference    The purpose of the private reference variable timer is to reference the Timer class to create a new timer.
   */ 
  private Timer timer = new Timer (2, this);
  
  /**
   * This is the default constructor, used to create a new ControlSpaceship object and start the timer.
   */ 
  public ControlSpaceship(){
    timer.start ();
  }
  
  /**
   * The purpose of the method actionPerformed(ActionEvent ae) is to perform certain actions based on what the program is doing.
   * The four if statements are used to prevent the spaceship from moving off the grid. 
   * @param ae The purpose of the reference variable ae is to get the action that the user did. 
   */
  public void actionPerformed (ActionEvent ae){
    x = x + velX;
    if(x<0)
      x=0;
    if(x>800)
      x=800;
    y = y + velY;
    if(y<0)
      y=0;
    if(y>450)
      y=450;
  }
  
  /**
   * This keyPressed(KeyEvent e) method is used to determine what should be pressed if certain keys are pressed.
   * If the up arrow key is pressed, the spaceship moves up 1 pixel. If the down arrow key is pressed, the spaceship moves down 1 pixel. If the left arrow key is pressed, the spaceship moves left 1 pixel. If the right arrow key is pressed, the spaceship moves right 1 pixel.
   * The purpose of the first if statement is to check if the user pressed the up key.
   * The purpose of the second if statement is to check if the user pressed the down key.
   * The purpose of the third if statement is to check if the user pressed the left key.
   * The purpose of the fourth if statement is to check if the user pressed the right key.
   * @param e The variable references the KeyEvent class to access its methods and variables if necessary.
   * @param i This variable is used to store the integer reference of the key the user pressed.
   */ 
  public void keyPressed(KeyEvent e){
    int i = e.getKeyCode();
    if (i == KeyEvent.VK_UP)
      velY = -1;
    if (i == KeyEvent.VK_DOWN)
      velY = 1;
    if (i == KeyEvent.VK_LEFT)
      velX = -1;
    if (i == KeyEvent.VK_RIGHT)
      velX = 1;
  }
  
  /**
   * This getX() method returns the x-coordinate of the spaceship.
   * @return   int   Current x-coordinate of the spaceship is returned.
   */ 
  public int getX(){
    return x;
  }
  
  /**
   * This getY() method returns the x-coordinate of the spaceship.
   * @return   int   Current y-coordinate of the spaceship is returned.
   */ 
  public int getY(){
    return y;
  }
  
  /**
   * The keyReleased(KeyEvent e) method sets the x-velocity and y-velocity to 0.
   * @param e The variable references the KeyEvent class to access its methods and variables if necessary.
   */ 
  public void keyReleased(KeyEvent e){
    velX = 0;
    velY = 0;
  }
}