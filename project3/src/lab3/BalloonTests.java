package lab3;
import static org.junit.Assert.assertEquals;

import balloon1.Balloon;

public class BalloonTests {

//	private static final double EPSILON = 10e-07;
	private Balloon bb;

	public void setup()
	{
		bb = new Balloon(5);
	}
		
	public void testInitial()
	{	
		String msg = "A newly constructed Balloon should have radius zero";
		assertEquals(msg, 0, bb.getRadius());
		String msg2 = "A newly constructed Balloon should not be popped.";
		assertEquals(msg2, false, bb.isPopped());
	}
	
	/**
	 * @Test blow()
	 */
	public void testBlow()
	{
		bb.blow(5);
		String msg = "After calling blow(5) on a Balloon with maximum radius 10, the radius should be 5.";
		assertEquals(msg, 5, bb.getRadius());
	}
	
	/**
	 * @Test deflate()
	 */
	public void testDeflate()
	{
		bb.deflate();
		String msg = "After calling deflate() the Balloon should have radius 0";
		assertEquals(msg, 0, bb.getRadius());
	}
	
	/**
	 * @Test pop()
	 */
	public void testPop()
	{
		bb.pop();
		String msg = "After calling pop() the Balloon should have radius 0 ";
		assertEquals(msg, 0, bb.getRadius());
		String msg2 = "After calling pop() the Balloon should be popped";
		assertEquals(msg2, true, bb.isPopped());
	}
}
