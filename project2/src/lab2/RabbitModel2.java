package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel2
{
  // TODO - add instance variables as needed
	int population = 0;
	int year = 0;
	
	
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel2()
  {
    population = 0;
    year = 1;
    
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {	
	  if (year % 5 == 0) {
	  		population = 0;
	  		
	  }
	  else {
		  population += 1;
		  year += 1;
	  }
	  
	  
	  
	  
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  population = 2;
	  
  }
}
