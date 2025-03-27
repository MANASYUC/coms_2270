package lab5;

public class nameInits {

	
	/**
	 * 
	 * Write a static method that takes a string argument containing a 
	 * person's full name as a parameter, and returns a string containing 
	 * just their initials. The name may have many parts or just one, e.g., 
	 * for the name "Cher" the method returns "C", for the 
	 * name "Edna del Humboldt von der Schooch" the method returns "EdHvdS". 
	 * Test your code.
	 */
	
	public static String getInitials(String fullName)
	{
		String initials = "";
		String[] names = fullName.split(" ");
		for(String first: names)
		{
			initials += first.charAt(0);
		}
		return initials;
	}
	
	
	public static int findFirstVowelIndex(String str) 
	{
        if (str == null || str.isEmpty()) 
        {
            return -1;
        }
        
        for (int i = 0; i < str.length(); i++) 
        {
        	char ch = str.charAt(i);
        	if("aeiouAEIOU".indexOf(ch) >= 0) 
        	{
        		return i;
        	}
            
        }
        return -1;
    }
	
	
	public static void main(String[] args) {
        System.out.println(getInitials("Cher"));
        System.out.println(getInitials("Edna del Humboldt von der Schooch")); 
        System.out.println(getInitials("John Doe"));
        System.out.println(findFirstVowelIndex("hrray Potter"));
        System.out.println(findFirstVowelIndex("hhn Due"));
        System.out.println(findFirstVowelIndex("xxyyzztt"));
        
        
    }

}

