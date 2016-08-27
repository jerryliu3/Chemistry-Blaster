package level1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

/**
 * This is the Asteroid class and it will create an image of an asteroid and store its coordinates. (Hours spent: 1)
 * @author Jerry Liu 
 * @version 1.0 May 16, 2014 
 * @version 2.0 May 23, 2014 Added questions
 * @version 3.0 May 30, 2014 No changes
 * @version 4.0 June 6, 2014 No changes
 * @version 5.0 June 12, 2014 Removed methods that aren't used.
 */
public class Asteroid
{
  /**
   * x                int              The purpose of the private integer variable x is to store the x coordinate of the left side of the asteroid.
   */
  private int x;
  
  /**
   * picture          BufferedImage        The purpose of the private reference variable picture is to reference the BufferedImage class so that the asteroid picture can be created.
   */
  private BufferedImage picture;
  
  /**
   * questions        ArrayList <Question>        The purpose of the private reference variable questions is to create an ArrayList of the questions to be asked.
   */
  private ArrayList <Question>questions;
  
  /**
   * The purpose of the Asteroid() constructor is to set the starting coordinates of the asteroid and store the picture.
   * @param e The purpose of the reference variable e is to reference the IOException class to catch errors regarding file io.
   * @exception IOException The purpose of the try catch is to reference the IOException class so that errors regarding IO can be caught and stop the program from crashing.
   */
  public Asteroid (){
    x=900;
    try{
      picture = ImageIO.read(new File("graphics/Asteroid2.jpg"));
    }
    catch(IOException e){
    }
    questions = new ArrayList<Question>();
    questions.add(new Question("Is water polar or non-polar?", "Polar", "Non-polar", "Can be both"));
    questions.add(new Question("What is the molar mass of water?", "18.02g/mol", "20.00g/mol", "3.00g/mol"));
    questions.add(new Question("What is the charge of 2 chlorate ions?", "2-", "2+", "4-"));
    questions.add(new Question("What is the name of CuO?", "cupric oxide", "copper oxide", "cuprous oxide"));
    questions.add(new Question("NaOH + HCl is this type of reaction.", "Double Displacement", "Combustion", "Decomposition"));
    questions.add(new Question("What state are noble gases?", "Gas", "Liquid", "Solid"));
    questions.add(new Question("The first element on the periodic table is:", "H", "He", "E"));
    questions.add(new Question("This metal is liquid at room temperature.", "mercury", "tungsten", "bromine"));
    questions.add(new Question("The temperature 453K in Celsius is...", "180", "No such thing!", "100"));
    questions.add(new Question("Particles move faster at lower temperatures.", "False", "True", "Sometimes"));
    questions.add(new Question("Pressure affects the rate of dissolving.", "False", "True", "Only for gases"));
    questions.add(new Question("This is considered a base (without OH)", "Ammonium", "Carbon Monoxide", "Chlorine Gas"));
    questions.add(new Question("How much Kelvin is 0 degrees celsius?", "273 K", "-273 K", "100 K"));
    questions.add(new Question("What is used as a common oven cleaner?", "NaOH", "NaCl", "NaClO"));
    questions.add(new Question("What is the charge on a hydronium ion?", "1+", "1-", "0"));
  }
  
  /**
   * This getX() method returns the x-coordinate of the asteroid.
   * @return int X-coordinate of asteroid is returned.
   */ 
  public int getX(){
    return x; 
  }
  
  /**
   * This setX(int y) method sets the compound of the asteroid.
   * @param int A new x-coordinate is set for the asteroid.
   */ 
  public void setX(int y){
    x=y; 
  }
  
  /**
   * This getPicture() method returns the image of the asteroid.
   * @return BufferedImage Image of asteroid is returned.
   */ 
  public BufferedImage getPicture(){
    return picture;
  }
  
  /**
   * This getRandomQuestion() method returns a random question for the asteroid.
   * @return Question A random compound is returned.
   */ 
  public Question getRandomQuestion(){
    return questions.remove((int)(Math.random() * questions.size()));
  }
}
