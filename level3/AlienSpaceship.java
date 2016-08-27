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
 * The purpose of the AlienSpaceship class is to create a new AlienSpaceship with a lot of equations. (Hours spent: 2)
 * @author Jerry Liu & Isis So (javadoc)
 * @version 1.0 May 16, 2014
 * @version 2.0 May 23, 2014 Added constructor and methods 
 * @version 3.0 May 30, 2014 Added equations
 * @version 4.0 June 6, 2014 Added the getEquationsLeft() method to return the number of values left in the equations ArrayList.
 * @version 5.0 June 12, 2014 Removed methods that aren't used, javadoc changes (Isis)
 */
public class AlienSpaceship
{
  /**
   * equations ArrayList<Equation> The purpose of the reference variable equations is to reference the ArrayList class to create a new ArrayList of Equation.
   */  
  private ArrayList<Equation> equations;
  
  /**
   * alien     BufferedImage     The purpose of the reference variable alien is to reference the BufferdImage class to store the picture of the alien spaceship.
   */
  private BufferedImage alien;
  
  /**
   * x         int           The purpose of the integer variable x is to store the x coordinate of the alien spaceship.
   */
  private int x;
  
  /**
   * y         int           The purpose of the integer variable y is to store the y coordinate of the alien spaceship.
   */
  private int y;
  
  /**
   * The purpose of the constructor is to create a new AlienSpaceship and the equations.
   * @param e The purpose of the reference variable e is to reference the IOException class to catch errors regarding file io.
   * @exception IOException The purpose of the try catch is to catch errors when reading the picture for the alien spaceship.
   */
  public AlienSpaceship()
  {
    x=500;
    y=-250;
    equations= new ArrayList<Equation>();
    equations.add(new Equation("MgCl2 + ", " NaOH --> 2 NaCl + Mg(OH)2","NaOH", 2));
    equations.add(new Equation("BaCl2 + ", " Na2SO4 --> 2 NaCl + BaSO4","Na2SO4", 1));
    equations.add(new Equation("Fe + ", " Co(ClO3)2 --> Fe(ClO3)3 + Co","Co(ClO3)2", 1));
    equations.add(new Equation("Zn + ", " K2SO4 --> 2 K + ZnSO4", "K2SO4", 1));
    equations.add(new Equation("Mg + ", " AgNO3 --> 2 Ag + Mg(NO3)2","AgNO3", 2));
    equations.add(new Equation("2 Al + ", " HCl --> 3 H2 + 2 AlCl3","HCl", 6));
    equations.add(new Equation("Ni + ", " H2O --> H2 + Ni(OH)2","H2O", 2));
    equations.add(new Equation("Na2CO3 + ", " HCl --> 2 NaCl + H2O + CO2","HCl", 2));
    equations.add(new Equation("4 Al + ", " O2 --> 2 Al2O3","O2", 3));
    equations.add(new Equation("(CH3)2NNH2 + ", " N2O4 --> 4 H2O + 3 N2 + 2 CO2","N2O4", 2));
    try
    {
      alien = ImageIO.read(new File("graphics/testAlienSpaceship.png"));
    }
    catch(IOException e)
    {
    }
  }
  
  /**
   * This getX() method returns the x-coordinate of the flask.
   * @return   int   X-coordinate of flask is returned.
   */ 
  public int getX()
  {
    return x; 
  }
  
  /**
   * This getY() method returns the y-coordinate of the flask.
   * @return   int   Y-coordinate of flask is returned.
   */ 
  public int getY()
  {
    return y; 
  }
  
  /**
   * The purpose of the setY(int newY) method is to set a new value for the y coordinate.
   * @param newY The purpose of the integer variable newY is to store the new y value of the alien spaceship.
   */
  public void setY(int newY)
  {
    y = newY;
  }
  
  /**
   * The purpose of the BufferedImage return method getAlien() is to return the picture of the alien spaceship.
   * @return BufferedImage returns picture of alien spaceship. 
   */
  public BufferedImage getAlien()
  {
    return alien;
  }
  
  /**
   * The purpose of the getRandomEquation() method is to return a random equation from the ArrayList.
   * @return Equation returns a random equation.
   */
  public Equation getRandomEquation()
  {
    return equations.remove((int)(Math.random() * equations.size()));
  }
  
  /**
   * The purpose of the getEquationsLeft() method is to return the number of equations left in the ArrayList.
   * @return equations.size() returns the size of the equations ArrayList
   */
  public int getEquationsLeft()
  {
    return equations.size(); 
  }
}
