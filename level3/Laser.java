package level3;

import app.*;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * The purpose of the Laser class is to create a String that will be shot from the spaceship displaying the compound it is to balance the equation.
 * @author Jerry Liu     1 hour
 * @version 1.0 May 30, 2014 
 * @version 2.0 June 6, 2014 No changes
 * @version 3.0 June 12, 2014 No changes
 */
public class Laser
{
  /**
   * x          int        The purpose of the integer variable x is to store the x coordinate of the laser.
   */
  private int x;
  
  /**
   * y          int        The purpose of the integer variable y is to store the y coordinate of the laser.
   */
  private int y;
  
  /**
   * display    String     The purpose of the String variable display is to store the String that is displayed.
   */
  private String display;
  
  /**
   * The purpose of the constructor Laser(int newX, int newY) is to set the beginning x and y coordinates for the laser.
   * @param newX The purpose of the integer variable newX is to store the x coordinate of the laser.
   * @param newY The purpose of the integer variable newY is to store the y coordinate of the laser.
   */
  public Laser(int newX, int newY)
  {
    x=newX;
    y = newY;
  }
  /**
   * The purpose of the integer return method getX() is to return the value of the x coordinate.
   * @return   int   X-coordinate of spaceship is returned.
   */
  public int getX()
  {
    return x; 
  }
  /**
   *The purpose of the setX(int newX) method is to set a new value for x.
   * @param newX The purpose of the integer variable newX is to store the new value that x should be.
   */
  public void setX(int newX)
  {
    x = newX;
  }
  /**
   * The purpose of the integer return method getY() is to return the y coordinate.
   * @return   int   Y-coordinate of spaceship is returned.
   */
  public int getY()
  {
    return y;
  }
  /**
   * The purpose of the String return method getString() is to return the String that should be displayed.
   * @return String The laser's display is returned.
   */
  public String getString()
  {
    return display; 
  }
  /**
   * The purpose of the setString(String newString) method is to set a new String to be displayed.
   * @param newString The purpose of the String variable newString is to store the new String that should be displayed.
   */
  public void setString(String newString)
  {
    display = newString;
  }
}