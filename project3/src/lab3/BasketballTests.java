package lab3;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class BasketballTests
{
    // margin of error for floating-point comparisons
    private static final double EPSILON = 10e-07;
 
    private Basketball bb;

    @Before    
    public void setup()  // runs before every test case
    {
      bb = new Basketball(5);
    }
    
    @Test
    public void testInitial()
    {
      assertEquals(false, bb.isDribbleable());
    }

    @Test
    public void testInitialDiameter()
    {
      String msg = "A newly constructed basketball should have the diameter it was constructed with";
      assertEquals(msg, 5.0, bb.getDiameter(), EPSILON);
    }

    @Test
    public void testInflate()
    {
      bb.inflate();
      assertEquals(true, bb.isDribbleable());
    }

    @Test
    public void testDiameterAfterInflation()
    {
      bb.inflate();
      assertEquals(5.0, bb.getDiameter(), EPSILON);
    }
   
  }