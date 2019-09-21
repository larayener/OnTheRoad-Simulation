
public class SimulationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Passenger p1 = new Passenger(2, 25);
		Passenger p2 = new Passenger(11, 3);
		Passenger p3 = new Passenger (4, 20);
		Car c = new Car(4, 26);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(c);
		System.out.println(c.isYolUstunde(p1));
		System.out.println(c.isYolUstunde(p2));
		System.out.println(c.isYolUstunde(p3));
		System.out.println(c.getYolcuSayisi());
		c.pickUp(p3);
		System.out.println(c.getYolcuSayisi());
		c.dropOff(p2);
		System.out.println(c.getYolcuSayisi());
		System.out.println(c);
		Passenger p4 = new Passenger (4, 25);
		c.pickUp(p4);
		System.out.println(c);
		System.out.println();
	}

}
