package lab3;

public class Basketball
{
	
	private double givenDiameter;
	private boolean dribbleable;
	
	  public Basketball(double givenDiameter)
	  {
		  this.givenDiameter = givenDiameter;
		  this.dribbleable = false;
	  }
	
	  public boolean isDribbleable()
	  {
	    return dribbleable;
	  }
	
	  public double getDiameter()
	  {
	    return givenDiameter;
	  }
	
	  public double getCircumference()
	  {
	    return 0;
	  }
	
	  public void inflate()
	  {
		  dribbleable = true;
	  }
}