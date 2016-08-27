package level2;

/**
 * This class is used to create a compound with a type and formula. (Hours spent: 1)
 * 
 * @author Isis So
 * @version 1.0 May 23, 2014 
 * @version 2.0 May 30, 2014 No changes
 * @version 3.0 June 6, 2014 Removed getRandomCompound method
 * @version 4.0 June 12, 2014 No changed
 */
public class Compound
{
  /**
   * compoundType  String     This private String variable is used to store the compound type (ionic or molecular) of the compound.
   */
  private String compoundType;
  
  /**
   * formula       String     This private String variable is used to store the chemical formula of the compound.
   */ 
  private String formula;
  
  /**
   * This constructor is used to create a new compound with a compound type and formula.
   * @param c This String variable is the passed in compound type.
   * @param f This String variable is the passed in formula.
   */ 
  public Compound(String c, String f){
    compoundType = c;
    formula = f;
  }
  
  /**
   * The getCompoundType() method returns the compound type of the compound.
   * @return  String  The type of compound is returned.
   */ 
  public String getCompoundType(){
    return compoundType;
  }
  
  /**
   * This getFormula() method returns the formula of the compound.
   * @return   String  The formula for the compound is returned.
   */ 
  public String getFormula(){
    return formula;
  }
}
