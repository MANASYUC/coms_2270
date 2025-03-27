package lab6;
import java.util.ArrayList;
import java.util.Scanner;
import plotter.Plotter;
import java.io.FileNotFoundException;
import java.io.File;
import java.awt.Point;



import plotter.Polyline;

public class myPlotter 
{
	
	public static void main(String[] args) throws FileNotFoundException 
	{
	    ArrayList<Polyline> list = readFile("C:/eclipse/project6/src/lab6/hello.txt");  
	    Plotter plotter = new Plotter();

	    for (Polyline p : list) 
	    {
	        //System.out.println(p);
	    	plotter.plot(p);  
	    }
	}
   
	private static Polyline parseOneLine(String line) {
	    Scanner scanner = new Scanner(line);
	    
	    
	    
	    if (scanner.hasNextInt()) 
	    {  // Check if there's an optional width
	        int width = scanner.nextInt();  
	        String color = scanner.next();  
	        Polyline polyline = new Polyline(color, width);  

	        while (scanner.hasNextInt()) 
	        {
	            int x = scanner.nextInt();  
	            int y = scanner.nextInt();  
	            polyline.addPoint(new Point(x, y));  
	        }
	        return polyline;  
	        
	    } 
	    else 
	    {
	        String color = scanner.next();  
	        Polyline polyline = new Polyline(color);  

	        while (scanner.hasNextInt()) 
	        {
	            int x = scanner.nextInt(); 
	            int y = scanner.nextInt();  
	            polyline.addPoint(new Point(x, y));  
	        }
	        return polyline;  
	    }
	}
	
	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException 
	{
	    ArrayList<Polyline> polylines = new ArrayList<>();
	    File file = new File(filename);
	    Scanner fileScanner = new Scanner(file);

	    while (fileScanner.hasNextLine()) 
	    {
	        String line = fileScanner.nextLine();
	        if (line.isEmpty() || line.startsWith("#")) 
	        {
	            continue;  
	        }

	        Polyline polyline = parseOneLine(line);  
	        polylines.add(polyline);  
	    }

	    fileScanner.close();
	    return polylines;  
	}
	
}