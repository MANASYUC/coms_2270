package postage1;

public class PostageUtil
{
  /**
   * Returns the cost of postage for a letter of the given weight.
   * @param weight
   *   given weight in ounces
   * @return
   *   cost of postage for the weight
   */
  public static double computePostage(double weight)
  {
    double total = 0;
    
    if(weight <= 1)
    {
    	total += .47;
    }
    else
    {
    	if(weight <= 3.5)
    	{
    		total += .47 +(Math.ceil(weight - 1)*.21);
    	}
    	else
    	{
    		total += .94 + (Math.ceil(weight - 1)*.21);
    	}
    }
    
    
    return total;
  }
}