package hw1;

public class Balloon 
{
	
	/**
	 * Instance variables to hold values
	 * 
	 */
	private int groundPosition;
	private int maxGroundPosition;
	private int maxAltitude;
	private double tankCapacity;
	private int altitude;
	private int verticalVelocity;
	private int horizontalVelocity;
	private double fuel;
	private double maxBurnRate;
	private int time;
	private final int initialGroundPosition;
	
	
	
	/**
	 * instance method
	 * @param groundPosition
	 * @param maxGroundPosition
	 * @param maxAltitude
	 * @param tankCapacity
	 * Sets initial "Balloon" object with parameter values and defaults to the other
	 */
	public Balloon(int groundPosition, int maxGroundPosition, int maxAltitude, double tankCapacity) 
	{
	
		this.groundPosition = groundPosition;
		this.maxGroundPosition = maxGroundPosition;
		this.maxAltitude = maxAltitude;
		this.tankCapacity = tankCapacity;
		this.initialGroundPosition = groundPosition;
		this.altitude = 0;
		this.verticalVelocity = 0;
		this.horizontalVelocity = 0;
		this.fuel = 0;
		this.maxBurnRate = 0;
		this.time = 0;
	}
	
	/**
	 * get method
	 * @return vertivalVelocity
	 */
	public int getVerticalVelocity() 
	{
		
		return verticalVelocity;
	}
	
	
	/**
	 * get method
	 * @return horizontalVelocity
	 */
	public int getHorizontalVelocity() 
	{
		
		return horizontalVelocity;
	}
	
	/**
	 * get method
	 * @return altitude
	 */
	public int getAltitude() 
	{
		
		return altitude;
	}
	
	/**
	 * get method
	 * @return maxAltitude
	 */
	public int getMaxAltitude() 
	{
		
		return maxAltitude;
	}
	
	
	/**
	 * get method
	 * @return groundPosition
	 */
	public int getGroundPosition() 
	{
		
		return groundPosition;
	}
	
	/**
	 * get method
	 * @return maxGroundPosition
	 */
	public int getMaxGroundPosition() 
	{
		
		return maxGroundPosition;
	}
	
	
	/**
	 * get method
	 * @return fuel
	 */
	public double getFuel() 
	{
		
		return fuel;
	}
	
	
	/**
	 * get method
	 * @return tankCapacity
	 */
	public double getTankCapacity() 
	{
		
		return tankCapacity;
	}
	
	
	/**
	 * get method
	 * @return maxBurnRate
	 */
	public double getMaxBurnRate() 
	{
		
		return maxBurnRate;
	}
	
	
	
	/**
	 * mutator method
	 * @param tankCapacity
	 * sets this objects tankCapacity to the param value
	 */
	public void setTankCapacity(double tankCapacity)
	{
		
		this.tankCapacity = tankCapacity;
	}
	
	
	
	/**
	 * mutator method
	 * @param maxBurnRate
	 * sets this objects maxBurnRate to the param value
	 */
	public void setMaxBurnRate(double maxBurnRate) 
	{
		
		this.maxBurnRate = maxBurnRate;
	}
	
	
	
	/**
	 * mutator method
	 * @param time
	 * sets this objects time to param value
	 */
	public void setTime(int time) 
	{
		
		this.time = time;
	}
	
	
	

	/**
	 * mutator method
	 * Restores this objects groundPosition to its initial value
	 */
	public void restoreInitialGroundPosition() 
	{

		this.groundPosition = initialGroundPosition;	
	}
	
	
	/**
	 * mutator method
	 * @return time % 60
	 * this means that it returns the remained of the time value(ex: 100 % 60 will give 40)
	 */
	public int getSeconds() 
	{
		
		return time % 60;
	}
	
	
	
	/**
	 * mutator method
	 * first divides time by 60 to get into minutes
	 * @return minutes % 60
	 * this means that it will give the remained of minutes just at the getSeconds function
	 */
	public int getMinutes() 
	{
		
		int minutes = time / 60;
		return minutes % 60;
	}
	
	
	
	/**
	 * mutator method
	 * @return time / 3600
	 * just returns the whole number value of division of time in seconds to hours.
	 */
	public int getHours() 
	{
		
		return time / 3600;
	}
	
	
	
	
	/**
	 * mutator method
	 * @param delta
	 * adds param to vertialVelocity variable
	 * the altitude value is updated to the following
	 * 	- the max makes sure that the value is above 0
	 * 	- the min makes sure the value between the max altitude and altitude with the addition of vertical velocity
	 */
	public void adjustVerticalVelocity(int delta) 
	{
		
		verticalVelocity += delta;
		altitude = Math.max(0, Math.min(maxAltitude, altitude + delta));
	}
	
	
	
	/**
	 * mutator method
	 * @param delta
	 * adds param to horizontalVelocity variable
	 * the groundPosition value is update to the following
	 * line 2
	 * 	- first adds groundPosition and HorizontalVelocity
	 * 	- the first mod finds remainder between maxGroundPosition and the groundPosition added with the new HorizontalVelocity
	 * 	- this might give a negative num thats why adding another mod fixes this
	 * 		-  the second mod makes sure its above 0 and between the maxGroundPosition
	 */
	public void adjustHorizontalVelocity(int delta) 
	{
		
		horizontalVelocity += delta;
		groundPosition = (((groundPosition + horizontalVelocity) % maxGroundPosition) + maxGroundPosition) % maxGroundPosition;

		
	}
	
	
	
	/**
	 * mutator method
	 * @param amount
	 * line 1
	 * 	- sets new double variable to 
	 *	- the min amount between the difference between how much space there is in the tank and the amount of fuel to add
	 * @return addedFuel
	 */
	public double addFuel(double amount) 
	{
		
		double addedFuel = Math.min(amount, tankCapacity - fuel);
        fuel += addedFuel;
        return addedFuel;
	}
	
	
	
	/**
	 * mutator method
	 * adds 1 sec to time variable
	 * line 2
	 *	- sets new double variable to
	 *	- min between the maxBurnRate and fuel
	 *subtracts the value
	 * @return fuelBurn in a sec
	 */
	public double oneSecondUpdate() 
	{
		time += 1;
        double fuelBurn = Math.min(fuel, maxBurnRate);
        fuel -= fuelBurn;
        return fuelBurn;
	}
	
	
	

}
