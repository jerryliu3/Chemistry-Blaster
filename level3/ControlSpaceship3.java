package level3;

import app.*;
import level2.*;
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
/**
 * This class is used to implement the controls for the user to move the spaceship up and down in level 3. (Hours spent: 0.5)
 * @author George Lim & Joshua Yuan, modified by Isis So and Jerry Liu
 * @version 1.0 May 30, 2014
 * @version 2.0 June 6, 2014 Made the class implement ActionListener and added appropriate methods.
 * @version 3.0 June 12, 2014 No changes
 */ 
public class ControlSpaceship3 extends KeyAdapter implements ActionListener
{
  /**
   * x            int            The purpose of the private integer variable x is to store the x location of the top left corner of the spaceship.
   */
  private int x = 0;
  
  /**
   * y            int            The purpose of the private integer variable y is to store the y location of the top left corner of the spaceship.
   */
  private int y = 0;
  
  /**
   * velY         int            The purpose of the private integer variable velY is to store the amount vertically the spaceship moves.
   */
  private int velY = 0;
  
  /**
   * timer        reference      The purpose of the private reference variable timer is to create a new Timer that'll move the spaceship.
   */
  private Timer timer = new Timer (2, this);
  
  /**
   * l            reference      The purpose of the private reference variable l is to reference the Level3 class so that it can use the methods inside of it.
   */
  private Level3 l;
  
  /**
   * The purpose of the ControlSpaceship3(Level3 newL) constructor is to create a ControlSpaceship3 object with a reference to Level3.
   * @param newL The purpose of the reference variable newL is to reference the Level3 class so that the methods inside of it can be used.
   */
  public ControlSpaceship3(Level3 newL)
  {
    x= 50;
    l = newL; 
    timer.start ();
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
   * The purpose of the actionPerformed(ActionEvent ae) method is to store the new y value for the spaceship.
   * @param ae The purpose of the reference variable ae is to reference the ActionEvent class to store what the user did.
   * The purpose of the 2 if statements are to stop the spaceship from moving off the screen.
   */
  public void actionPerformed(ActionEvent ae)
  {
    y = y + velY;
    if(y<0)
      y=0;
    if(y>450)
      y=450;
  }
  /**
   * The purpose of the method keyPressed(KeyEvent e) is to move the spaceship if the user pressed up or down.
   * The purpose of the first if statement is to check if the user pressed the up key.
   * The purpose of the second if statement is to check if the user pressed the down key.
   * @param e The KeyEvent variable e will store what the user clicked on the keyboard.
   * @param i The purpose of the integer variable i is to get the key code of the key that the user pressed.
   */
  public void keyPressed(KeyEvent e)
  {
    int i = e.getKeyCode();
    if (i == KeyEvent.VK_UP)
      velY = -2;
    if (i == KeyEvent.VK_DOWN)
      velY = 2;
  }
  
  /**
   * The purpose of the keyReleased(KeyEvent e) method is to shoot a laser (compound) if they pressed enter, and to stop moving the spaceship.
   * The purpose of the if statement is to check if the user released the enter key to shoot a compound.
   * @param e The KeyEvent variable e will store what the user clicked on the keyboard.
   * @param i The purpose of the integer variable i is to get the key code of the key that the user pressed.
   * @param laser The purpose of the Laser variable laser is to make a new laser object.
   */
  public void keyReleased(KeyEvent e){
    int i = e.getKeyCode();
    if(i==KeyEvent.VK_ENTER)
    {
      Laser laser = new Laser(x+150, y+60);
      l.addLaser(laser);
    }
    velY = 0;
  } 
}