package lab5;

public class Lab5Example
{
  public static void main(String[] args)
  {
    System.out.println(longestRun("aabbbccd"));
    System.out.println("Expected 3");
    System.out.println(longestRun("aaa"));
    System.out.println("Expected 3");
    System.out.println(longestRun("aabbbb"));
    System.out.println("Expected 4");
  }
  
 
  /**
   * changes
   * 1) corrected the for loop so that it included the last letter
   * 2) the max var should be updated not count
   * 3) then count should be reset so that it checks the next letter
   * 4) and after the loop it should check the last run
   * 
   * @param s
   * @return
   */
  public static int longestRun(String s)
  {
    int count = 1;
    int max = 1;
    
    // start with the first character, see how long a run there is
    char current = s.charAt(0);
    for (int i = 1; i < s.length(); i++)
    {
      char c = s.charAt(i);
      if (c == current)
      {
        // matches the 'current' character, add 1
        count += 1;
      }
      else
      {
        // that was the end of the run; if it was a longer run, make that the max
        if (count > max)
        {
        	max = count;
        }

        // start counting a new run of a different character
        current = c;
        count = 1; 
      }
      
      if (count > max)
      {
        max = count; 
      }
    }
    
    // this should be the length of the longest run we found
    return max;
  }

  
  
}
