public class Car extends Vehicle {

	@Override
	public String type() {
		return "CAR";
	}

	@Override
	int spacesOccupied() {
		return 1;
	}
}
