import java.util.ArrayList;
import java.util.Random;

public class Simulation {
	private Station[] stations;
	private int time;
	private int stationno;
	private int revenue;
	private int miles;
	
	public Simulation(int stationno) {
		this.stationno = stationno;
		stations = new Station[stationno];
		for (int i = 0; i < stationno; i++) {
			Station s = new Station(i);
			stations[i] = s;
			Random p = new Random();
			int randomPass = p.nextInt(stationno/2);
			int randomCar = p.nextInt(5);
			for (int j = 0; j < randomPass; j++) {
				Passenger k = createRandomPassenger(stations[i]);
				stations[i].addPassenger(k);
			}
			for (int l = 0; l < randomCar; l++) {
				Car m = createRandomCar(stations[i]);
				stations[i].addCar(m);
			}
		}
		time = 0;
		miles = 0;
	}
	
	public Simulation(Station[] k) {
		stations = k;
		time = 0;
		stationno = k.length;
		for (Station s1 : stations) {
			for (Car c1 : s1.getcars()) {
			}
		}
		miles = 0;
	}
	
	public Passenger createRandomPassenger(Station k) {
		Random r = new Random();
		int randomInt = r.nextInt(stationno);
		while (randomInt == k.getID()) {
			randomInt = r.nextInt(stationno);
		}
		Passenger p = new Passenger(k.getID(), randomInt);
		return p;
	}
	
	public Car createRandomCar(Station k) {
		Random r = new Random();
		int randomInt = r.nextInt(stationno);
		while (randomInt == k.getID()) {
			randomInt = r.nextInt(stationno);
		}
		Car c = new Car(k.getID(), randomInt);
		return c;
	}
	
	
//	public void zamanIlerlet() {
//		if (status) {
//			return;
//		}
//		if (currentstation < destination) {
//			currentstation++;
//			revenue+= passengers.size() * 10;
//		}
//		else if (currentstation > destination) {
//			currentstation--;
//			revenue+= passengers.size() * 10;
//		}
//		// Easy loop: arrays, array lists...
//		for (Passenger o : passengers) {
//			o.updateCurrentStation(currentstation);
//		}
//		if (currentstation == destination) {
//			status = true;
//		}
//	}
	
	public void zamanIlerlet() {
		for (Station stat : stations) {
			for (Car c : stat.getcars()) {
				for (int i = 0; i < c.getyolcus().size(); i++) {
					Passenger p = c.getyolcus().get(i);
					revenue+= 10;
					if (c.getcurrentstation() == p.getDestination()) {
						c.dropOff(p);
					}
				}
				for (int i = 0; i < stat.getpassengers().size(); i++) {
					Passenger p = stat.getpassengers().get(i);
					if (c.getYolcuSayisi() == 3) {
						break;
					}
					if (c.isYolUstunde(p)) {
						c.pickUp(p);
						stat.removePassenger(p);
					}
				}
			}
		}
		time++;
		ArrayList<Car> islistesi = new ArrayList<Car>();
		for (int i = 0; i < stations.length; i++) {
			Station stat = stations[i];
			for (int j = 0; j < stat.getcars().size(); j++) {
				Car c = stat.getcars().get(j);
				if (c.nextStation() != -1) {
					int nextstatno = c.nextStation();
					c.setcurrentstation(c.nextStation());
					islistesi.add(c);
					miles++;
					for (int g = 0; g < c.getyolcus().size(); g++) {
						Passenger p = c.getyolcus().get(g);
						p.updateCurrentStation(nextstatno);
					}
					// Station nextStat = stations[c.nextStation()];
					// nextStat.addCar(c);
				}
				stat.removeCar(c);
			}
		}
		for (int i = 0; i < islistesi.size(); i++) {
			Car c = islistesi.get(i);
			stations[c.getcurrentstation()].addCar(c);
		}
	}
	
	public int getRevenue() {
		return revenue;
	}
	
	public double getAverageRevenue() {
		return (double)revenue/miles;
	}
	
	public String toString() {
		String s = "Simulation at time ### " + time + ": ### ";
		for (Station k : stations) {
			s+= k.toString();
			s+= "\n---------\n";
		}
		s+= "\nMiles travelled: " + miles + " / Total revenue: " + revenue + " / Average revenue: " + this.getAverageRevenue();
		return s;
	}
	
	
	
	public static void main(String[] args) {
		// Simulation sim = new Simulation(4);
		Station[] stations = new Station[3];
		Passenger p1 = new Passenger(2,1);
		Passenger p2 = new Passenger (0,1);
		Car c1 = new Car(0,2);
		Car c2 = new Car(2,1);
		stations[0] = new Station(0);
		stations[1] = new Station(1);
		stations[2] = new Station(2);
		stations[0].addCar(c1);
		stations[2].addCar(c2);
		stations[2].addPassenger(p1);
		stations[0].addPassenger(p2);
		Simulation sim = new Simulation(stations);
		System.out.println(sim);
		sim.zamanIlerlet();
		System.out.println(sim);
		sim.zamanIlerlet();
		System.out.println(sim);
		sim.zamanIlerlet();
		System.out.println(sim);
	}
}
