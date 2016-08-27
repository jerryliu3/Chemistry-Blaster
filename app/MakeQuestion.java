package app;
/**
 * This class is used to create a question that is used. (Hours spent: 1)
 *  
 * @author Jerry Liu
 * @version 1.0 June 12, 2014
 */
public class MakeQuestion
{
  /**
   * question      String       The purpose of the String variable question is to store the question that is being asked.
   */
  private String question;
  
  /**
   * answer        String       The purpose of the String variable answer is to store the answer to the question.
   */
  private String answer;
  
  /**
   * This constructor is used to make a new MakeQuestion object.
   * @param q String This variable is passed in to allow the class variable question to have a value.
   * @param a String This variable is passed in to allow the class variable answer to have a value.
   */
  public MakeQuestion(String q, String a)
  {
    question = q;
    answer = a;
  }
  
  /**
   * The purpose of the String return method getQuestion is to return the question stored by this class.
   * @return This returns the question.
   */
  public String getQuestion()
  {
    return question;
  }
  
  /**
   * The purpose of the String return method getAnswer() is to return the answer to the question.
   * @return This return the answer to the question.
   */
  public String getAnswer()
  {
    return answer;
  }
}