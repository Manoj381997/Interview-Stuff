import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static boolean validateCommand(String[] command, int noOfArgs, String key) {
		if (command.length != noOfArgs || !command[0].equalsIgnoreCase(key)) {
			System.out.println("Error: Invalid command syntax.");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		Network network = new Network();
		
		while (true) {
			System.out.println("Inputs would be:\n1. ADD\n2. CONNECT\n3. INFO_ROUTE\n4. Forbid Node");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("\nEnter the Command for Adding the Computer");
				String[] addCommand = sc.nextLine().trim().split(" ");
				if (validateCommand(addCommand, 2, "ADD")) {
					boolean isAdded = network.addComputer(addCommand[1]);
					if (isAdded) System.out.println("Successfully added "+ addCommand[1]);
					else System.out.println("Error: That name already exists.");
				}
				break;

			case 2:
				System.out.println("\nEnter the Command for Connecting the Computers");
				String[] connectCommand = sc.nextLine().trim().split(" ");
				if (validateCommand(connectCommand, 3, "CONNECT")) {
					if (connectCommand[1].equals(connectCommand[2])) {
						System.out.println("Error: Cannot connect computer to itself.");
						break;
					}
					boolean isConnected = network.connectComputer(connectCommand[1], connectCommand[2]);
					if (isConnected) System.out.println("Successfully connected");
					else System.out.println("Error: Computers are already connected.");
				}
				break;
			case 3:
				System.out.println("\nEnter the Command for transferring info via Computers");
				String[] routeCommand = sc.nextLine().trim().split(" ");
				if (validateCommand(routeCommand, 3, "INFO_ROUTE")) {
					if (routeCommand[1].equals(routeCommand[2])) {
						System.out.println(routeCommand[1]+" -> "+routeCommand[2]);
						break;
					}
					List<Computer> routes = network.getInfoRoute(routeCommand[1], routeCommand[2]);
					if (routes == null) {
						System.out.println("The src computer doesnt have any connection with dest computer");
						break;
					}
					System.out.println(routeCommand[1]+" "+routes);
				}
				break;
			case 4:
				System.out.println("\nEnter the Command for Forbidding info via Computers");
				String[] forbidCommand = sc.nextLine().trim().split(" ");
				if (validateCommand(forbidCommand, 3, "FORBID")) {
					if (forbidCommand[1].equals(forbidCommand[2])) {
						System.out.println("Same Nodes cannot be forbidden");
						break;
					}
					boolean isForbaded = network.forbidRoute(forbidCommand[1], forbidCommand[2]);
					if (isForbaded) System.out.println(forbidCommand[2]+" is forbaded from "+forbidCommand[1]);
					else System.out.println("The Dest node is already forbaded from src node");
				}
				break;
			default:
				isExit = true;
				break;
			}
			if (isExit) break;
		}
		sc.close();
		System.out.println("Thanks...");
	}

}
