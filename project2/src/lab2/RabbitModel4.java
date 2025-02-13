package lab2;


/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
	int population = 0;
	int lastYear = 0;
	int yearBefore = 0;
	
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
  {
    population = 0;
    lastYear = 1;
    yearBefore = 0;
    
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
	  
	  
	  population = lastYear + yearBefore;
	  yearBefore = lastYear ;
	  lastYear = population;
	  

  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  population = 0;
	  
  }
}
