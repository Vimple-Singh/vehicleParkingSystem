import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarParking {

	int limit;
	String input;
	List<Vehicle> vehicle = new ArrayList<>();
	Map<String, Integer> report = new HashMap<>();

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public int getCarParks(String carParks) {
		System.out.println("Program: How many spaces does the car park have?");
		System.out.println("USER: ");
		try {
			carParks = br.readLine();
			return Integer.parseInt(carParks);
		} catch (IOException e) {
			return -1;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public void enter(String[] array) {
		if (array.length != 2) {
			System.out.println("Please input ENTER CAR or ENTER TRUCK only!");
			return;
		}
		int count = 0;

		for (int i = 0; i < vehicle.size(); i++) {
			count += vehicle.get(i).spacesOccupied();
		}
		if (count > limit) {
			return;
		}
		if (array[1].equals("CAR")) {
			vehicle.add(new Car());
			report.put("Cars Entered", report.get("Cars Entered") + 1);
			report.put("Parking Cars", report.get("Parking Cars") + 1);
			report.put("Spaces available", report.get("Spaces available") - 1);
		} else if (array[1].equals("TRUCK")) {
			vehicle.add(new Truck());
			report.put("Trucks Entered", report.get("Trucks Entered") + 1);
			report.put("Parking Trucks", report.get("Parking Trucks") + 1);
			report.put("Spaces available", report.get("Spaces available") - 2);
		}
	}

	public void exit(String[] array) {
		if (array.length != 3 || vehicle.isEmpty()) {
			System.out.println("Please input EXIT CAR (HOURS) or EXIT TRUCK (HOURS) only!");
			return;
		}
		try {
			int hours = Integer.parseInt(array[2]);
			int index = find(array[1]);
			if (index == -1) {
				return;
			}
			vehicle.remove(index);
			if (array[1].equals("CAR")) {
				report.put("Cars Exited", report.get("Cars Exited") + 1);
				report.put("Parking Cars", report.get("Parking Cars") - 1);
				report.put("Spaces available", report.get("Spaces available") + 1);
				report.put("Fees paid", report.get("Fees paid") + hours * 2);
			} else if (array[1].equals("TRUCK")) {
				report.put("Trucks Exited", report.get("Trucks Exited") + 1);
				report.put("Parking Trucks", report.get("Parking Trucks") - 1);
				report.put("Spaces available", report.get("Spaces available") + 2);
				report.put("Fees paid", report.get("Fees paid") + hours * 3);
			}
		} catch (NumberFormatException e) {
			return;
		}
	}

	private int find(String type) {
		for (int i = 0; i < vehicle.size(); i++) {
			if (vehicle.get(i).type().equals(type)) {
				return i;
			}
		}
		return -1;
	}

	public void setUp() {
		report.put("Cars Entered", 0);
		report.put("Trucks Entered", 0);
		report.put("Cars Exited", 0);
		report.put("Trucks Exited", 0);
		report.put("Parking Cars", 0);
		report.put("Parking Trucks", 0);
		report.put("Spaces available", limit);
		report.put("Fees paid", 0);
	}

	public void report() {
		for (String key : report.keySet()) {
			System.out.println(key + ": " + report.get(key));
		}
	}
}
