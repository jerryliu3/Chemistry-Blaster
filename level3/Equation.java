package level3;

/**
 * The purpose of the Equation class is to store the equation used in level 3. (Hours spent: 1)
 * @author Jerry Liu    
 * @version 1.0  June 6, 2014
 * @version 2.0 June 12, 2014 Removed methods that aren't used.
 */
public class Equation
{
  /**
   * firstPart     String       The purpose of the private String variable firstPart is to store the first part of the equation before the compound that needs to be balanced.
   */
  private String firstPart;
  
  /**
   * secondPart    String       The purpose of the private String variable secondPart is to store the second part of the equation from the compound that needs to be balanced.
   */
  private String secondPart;
  
  /**
   * compound      String       The purpose of the private String variable compound is to store the compound that needs to be balanced.
   */
  private String compound;
  
  /**
   * answer        int          The purpose of the private integer variable answer is to store the correct coefficient for the compounds that needs to be balanced.
   */
  private int answer;
  
  /**
   * counter       int          The purpose of the private integer variable counter is to store the number of times the user has shot the spaceship to balance the equation.
   */
  private int counter;
  
  /**
   * The purpose of the constructor Equation(String firstPart, String secondPart, String compound, int answer) is to create a new Equation with everything needed to work in level 3.
   * @param firstPart The purpose of the String variable firstPart is to store the first part of the equation before the compound that needs to be balanced.
   * @param secondPart The purpose of the String variable secondPart is to store the second part of the equation from the compound that needs to be balanced.
   * @param compound The purpose of the String variable compound is to store the compound that is being balanced.
   * @param answer The purpose of the integer variable answer is to store the correct number of times the user needs to shoot the equation to balance it.
   */
  public Equation(String firstPart, String secondPart, String compound, int answer)
  {
    this.firstPart = firstPart;
    this.secondPart = secondPart;
    this.compound = compound;
    this.answer = answer;
  }
  /**
   * The purpose of the String return method displayEquation() is to return the entire equation as a String.
   * The purpose of the if statement is to check if the number of times the user has shot the spaceship is 0.
   * @return   String   The equation is returned.
   */
  public String displayEquation()
  {
    if(counter==0)
      return firstPart + "_" + secondPart;
    return firstPart + counter + secondPart;
  }
  /**
   *The purpose of the integer return method getAnswer() is to return the correct number of times the user should shoot the spaceship to balance the equation.
   * @return   int   Answer of equation is returned.
   */
  public int getAnswer()
  {
    return answer;
  }
  /**
   * The purpose of the increaseCounter() method is to increase the variable that stores the number of times the user has hit the spaceship.
   */
  public void increaseCounter()
  {
    counter++; 
  }
  /**
   * The purpose of the integer return method getCounter() is to return the number of times the user has hit the spaceship.
   * @return   int   Counter of equation is returned.
   */
  public int getCounter()
  {
    return counter; 
  }
  /**
   * The purpose of the String return method getCompound() is to return the compound that needs to be balanced.
   * @return   String   Compound of equation is returned.
   */
  public String getCompound()
  {
    return compound; 
  }
}