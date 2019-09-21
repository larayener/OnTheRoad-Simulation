import org.junit.Test; 
import org.junit.Assert;

public class SimulationJUnitTest {
	@Test public void controlTest() {
		Car c = new Car(0,2);
		Passenger p1 = new Passenger(0,1);
		Passenger p2 = new Passenger(0,2);
		c.pickUp(p1);
		c.pickUp(p2);
		Assert.assertEquals(2, c.getyolcus().size(), 0.01);
		}
}
