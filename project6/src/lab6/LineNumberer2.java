package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer2
{
  public static void main(String[] args) throws FileNotFoundException
  {
    //File file = new File("C:\\eclipse\\project6\\src\\lab6\\story.txt");
    File file = new File("../project5/src/lab5/SimpleLoops.java");
    Scanner scanner = new Scanner(file);
    int lineCount = 1;

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      System.out.print(lineCount + " ");
      System.out.println(line);
      lineCount += 1;
    }
    scanner.close();
    
    
    System.out.println('\n');
    //prints total num of words per line
    String filePath = "C:/eclipse/project6/src/lab6/story.txt";
    printAllWords(filePath);
  }
  
  
  
  
  private static void printAllWords(String filename) 
	      throws FileNotFoundException
	  {
	    // open the file
	  	
	    File file = new File(filename);    
	    Scanner scanner = new Scanner(file);
	    int i = 1;
	    // while there are more lines...
	    while (scanner.hasNextLine())
	    {
	      // get the next line
	    
	      String line = scanner.nextLine();
	      
	      String[] words = line.split(" ");
	      
	      // Count the number of words
	      int wordCount = words.length;
	      System.out.println("Line: " + i + " Number of words in the line: " + wordCount);
	      i++;
	    }
	    
	    
	    scanner.close();

	  }
}