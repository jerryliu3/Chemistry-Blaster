package app;

/**
 * This class is used to store the data for a new game of Chemistry Blaster. (1 hour spent)
 *  
 * @author       Isis So
 * @version 1.0 May 23, 2014 
 * @version 2.0 May 30, 2014 Added methods
 * @version 3.0 June 6, 2014 No changes
 * @version 4.0 June 12, 2014 No changes
 */
public class NewGame
{
  /**
   * level   int   This private variable stores the level the user is on.
   */
  private int level;
 
  /** 
   * lives   int   This private variable stores the number of lives the user has.
   */
  private int lives;
  
  /**
   * score   int   This private variable stores the score the user has.
   */ 
  private int score;
  
  /**
   * This constructor passes makes a new game starting at the level choice of the user. The number of lives is set to 3.
   * @param   levelChoice   int   This variable stores the level choice of the user. The instance variable 'level' is then given the value of this parameter pass. 
   */ 
  public NewGame(int levelChoice){
    this.level = levelChoice;
    lives = 3;
    score = 0;
  }
  
  /**
   * This getLevel() method returns the level the user is currently on. 
   * @return   int   Current level of user is returned.
   */ 
  public int getLevel(){
    return level;
  }
  
  /**
   * This setLevel() method increments the level of the user.
   */ 
  public void setLevel(){
    level++;
  }
  
  /**
   * This getLives() method returns the number of lives the user has.
   * @return   int   Current number of lives of user is returned.
   */ 
  public int getLives(){
    return lives;
  }
  
  /**
   * This setLives() method sets the number of lives of the user.
   * The purpose of the if statement is to check if the lives should be increased or decreased.
   * @param   increase   boolean   True if number of lives should increase.
   */ 
  public void setLives(boolean increase){
    if (increase)
      lives++;
    else
      lives--;
  }
  
  /**
   * This getScore() method returns the number of lives the user has.
   * @return   getScore   Current score of the user is returned.
   */ 
  public int getScore(){
    return score;
  }
  
  /**
   * This setScore() method sets the number of lives of the user.
   * @param   int   points   This variable stores the number of points that should be added to the current score.
   */ 
  public void setScore(int points){
    score = getScore() + points;
  }
}