package level1;

/**
 * The purpose of the Question class is to store a question, the answer, and 2 other possible choices. (Hours spent: 1)
 * @author Jerry Liu
 * @version 1.0 May 16, 2014
 * @version 2.0 May 23, 2014 No changes
 * @version 3.0 May 30, 2014 No changes
 * @version 4.0 June 6, 2014 No changes
 * @version 5.0 June 12, 2014 Removed most methods, now extends MakeQuestion.
 */
public class Question extends app.MakeQuestion
{
  /**
   * name          type         purpose
   * choice1       String       The purpose of the String variable choice1 is to store the first possible option.
   * choice2       String       The purpose of the String variable choice2 is to store the second possible option.
   */
  private String  choice1, choice2;
  /**
   * The purpose of the constructor Question(String q, String a, String c1, String c2) is to set the question to q, the answer to a, the first choice to c1 and the second choice to c2.
   * @param q The purpose of the String variable q is to store the question to be asked.
   * @param a The purpose of the String variable a is to store the answer to the question stored by q.
   * @param c1 The purpose of the String variable c1 is to store the first choice to the question stored by q.
   * @param c2 The purpose of the String variable c2 is to store the second choice to the question stored by q.
   */
  public Question (String q, String a, String c1, String c2)
  {
    super(q, a);
    choice1 = c1;
    choice2 = c2;
  }
  /**
   * The purpose of the String return method getChoice1() is to return the first choice to the question.
   * @return String This returns the first choice for the question.
   */
  public String getChoice1()
  {
    return choice1;
  }
  /**
   * The purpose of the String return method getChoice2() is to return the second choice of the question.
   * @return String This returns the second choice for the question.
   */
  public String getChoice2()
  {
    return choice2;
  }
}