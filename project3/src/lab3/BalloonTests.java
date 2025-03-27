package lab3;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import balloon.Balloon;

// balloon 1 fails because it allows balloon to be blown above maxRadius
// balloon 1 fails because it allows to blow balloon if its popped
// balloon 1 blows balloon after being popped


// balloon 2 blows balloon after being popped




// balloon 4 fails deflate test meaning that balloon has been popped when it shouldn't


//
public class BalloonTests {


	
	private Balloon bb;
	private Balloon bb2;
	private Balloon bb3;
	private Balloon bb4;
	private Balloon bb5;
	private Balloon bb6;
	private int maxRadius;
	
	@Before
	public void setup()
	{
		bb = new Balloon(5);
		bb2 = new Balloon(5);
		bb3 = new Balloon(5);
		bb4 = new Balloon(5);
		bb5 = new Balloon(5);
		bb6 = new Balloon(5);
		maxRadius = 5;
	}
		
	@Test
	public void testInitial()
	{	
		String msg = "A newly constructed Balloon should have radius zero";
		assertEquals(msg, 0, bb.getRadius());
		String msg2 = "A newly constructed Balloon should not be popped.";
		assertFalse(msg2, bb.isPopped());
	}
	
	
	
	
	@Test
	public void testBlow()
	{
		bb.blow(5);
//		assertTrue("test 1")
		String msg = "After calling blow(5) on a Balloon with maximum radius 10, the radius should be 5.";
		
		boolean holder = bb.getRadius() <= maxRadius;
		String msg2 = "test";
		
		assertEquals(msg, 5, bb.getRadius());
		assertTrue(msg2, holder);
		
	}
	
	
	@Test
	public void testpastMax()
	{
		bb2.blow(6);
		String msg = "Cant blow past max radius";
		boolean holder = bb2.getRadius() <= maxRadius;
		assertTrue(msg, holder);
		
	}
	
	@Test
	public void testBlowFunction()
	{
		bb6.blow(3);
		bb6.blow(2);
		String msg = "A balloons radius should be increads with the new blow amount not set to blow amount";
		assertEquals(msg, 5, bb6.getRadius());
		
	}
	
	
	@Test
	public void testBlowPastMax()
	{
		bb3.blow(6);	
		bb3.blow(6);
		String msg = "A balloon cannot be blown if its popped";
		assertTrue(msg, bb3.isPopped());
		
		
	}
	
	
	@Test
	public void testPopAndBlow()
	{
		bb4.pop();
		String msg = "A balloon cannot be blown after being popped";
		assertTrue(msg, bb4.isPopped());
		bb4.blow(3);
		String msg2 = "A balloon cannot be blown";
		boolean holder = bb4.getRadius() <= 0;
		assertTrue(msg2, holder);
		
		
	}
	
	@Test
	public void testNegativeBLow()
	{
		bb5.blow(-1);
		String msg = "A balloon cannot be blown a negative value";
		assertEquals(msg, 0, bb5.getRadius());
		boolean holder = bb5.getRadius() <= maxRadius;
		
	}
	
	@Test
	public void testDeflate()
	{
		bb.deflate();
		String msg = "After calling deflate() the Balloon should have radius 0";
		assertEquals(msg, 0, bb.getRadius());
		String msg2 = "After calling deflate() the Balloon shoudl not have been popped";
		assertFalse(msg2, bb.isPopped());
	}
	
	@Test
	public void testPop()
	{
		
		bb.pop();
		
		
		String msg = "After calling pop() the Balloon should have radius 0 ";
		assertEquals(msg, 0, bb.getRadius());
		String msg2 = "After calling pop() the Balloon should be popped";
		assertTrue(msg2, bb.isPopped());
	}
}
