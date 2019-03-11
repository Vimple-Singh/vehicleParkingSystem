import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	View view = new View();
	CarParking cp = new CarParking();

	public void runProgram() {
		view.startProgram("");
		try {
			while ((cp.limit = cp.getCarParks(br.readLine())) == -1) {
			}
			view.takeInput("");
			cp.setUp();
			while (!(cp.input = br.readLine()).equals("QUIT")) {
				System.out.println("USER: ");
				String[] array = cp.input.toUpperCase().split("\\s+");
				String command = array[0];
				switch (command) {
				case "ENTER":
					cp.enter(array);
					break;
				case "EXIT":
					cp.exit(array);
					break;
				case "REPORT":
					cp.report();
					break;
				default:
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
