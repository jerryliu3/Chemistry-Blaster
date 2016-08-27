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
 * This class is used to create a flask that falls down in level 2. (Hours spent: 2)
 * 
 * @author Isis So
 * @version 1.0 May 23, 2014 
 * @version 2.0 May 30, 2014 No changes.
 * @version 3.0 June 6, 2014 Initialized y to be 100 lower.
 * @version 4.0 June 12, 2014 Changed constructor, removed the methods to set the x coordinate and set the compound, javadoc changed.
 */
public class Flask
{
  /**
   * flask     BufferedImage   This variable is used to create the image of the flasks that fall down.
   */
  private BufferedImage flask;
  
  /**
   * resized   BufferedImage   This variable is used to create the resized image of the flasks that fall down.
   */
  private BufferedImage resized;
  
  /**
   * compound  Compound        This variable is used to store the compound that the flask contains.
   */
  private Compound compound;
  
  /**
   * x         int             This variable is used to store the x-coordinate of the flask's location.
   */
  private int x;
  
  /**
   * y         int             This variable is used to store the y-coordinate of the flask's location.
   */ 
  private int y;
  
  /**
   * This constructor makes a new Flask object with a randomize height to start off at.
   * @param newX The purpose of the integer variable newX is to store the x coordinate that the Flask should be at.
   * @param c The purpose of the reference variable c is to store the Compound that the Flask should display/store.
   */ 
  public Flask(int newX, Compound c){
    x = newX;
    compound = c;
    y = (-1* ((int)(Math.random()*100))) - 100;
    draw();
  }
  
  /**
   * This draw() method is used to draw and resize the image of flask.
   * @param g The purpose of the reference variable g is to reference the Graphics2D class to draw an image.
   * @exception   IOException   Exception is caught when the picture file cannot be properly read, which causes an exception to be thrown.
   * @return flask The resized image of flask is returned.
   */ 
  public BufferedImage draw(){
    try{
      flask = ImageIO.read(new File("graphics/Flask.jpg"));
    }
    catch(IOException e){
    }
    resized = new BufferedImage(50, 75, flask.getType());  
    Graphics2D g = resized.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
    g.drawImage(flask, 0, 0, 50, 75, null);
    g.dispose();
    flask = resized;
    return flask;
  }
  
  /**
   * This getRandomCompound() method returns the compound of the flask.
   * @return   Compound   Compound is returned.
   */ 
  public Compound getCompound(){
    return compound;
  }
  
  /**
   * This getX() method returns the x-coordinate of the flask.
   * @return   int   X-coordinate of flask is returned.
   */ 
  public int getX(){
    return x;
  }
  
  /**
   * This getY() method returns the y-coordinate of the flask.
   * @return   int   Y-coordinate of flask is returned.
   */ 
  public int getY(){
    return y;
  }
  
  /**
   * This setY(int x) method sets the compound of the flask.
   * @param x   A new y-coordinate is set for the flask.
   */ 
  public void setY(int x){
    y = x;
  }
  
  /**
   * This getFlask() method returns the image of the flask.
   * @return   BufferedImage   Image of flask is returned.
   */ 
  public BufferedImage getFlask(){
    return flask;
  }
}