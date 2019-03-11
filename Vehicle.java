public abstract class Vehicle {

	private int hoursOccupied;

	abstract String type();

	public int getHoursOccupied() {
		return hoursOccupied;
	}

	public void setHoursOccupied(int hoursOccupied) {
		this.hoursOccupied = hoursOccupied;
	}

	abstract int spacesOccupied();

}
