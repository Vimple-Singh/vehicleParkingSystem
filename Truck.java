public class Truck extends Vehicle {

	@Override
	public String type() {
		return "TRUCK";
	}

	@Override
	int spacesOccupied() {
		return 2;
	}
}
