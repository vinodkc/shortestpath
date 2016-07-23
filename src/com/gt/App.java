package com.gt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.gt.path.ShortestPathAlgorithm;
import com.gt.path.Graph;
import com.gt.path.Location;
import com.gt.path.Orbit;
import com.gt.transport.Bike;
import com.gt.transport.SuperCar;
import com.gt.transport.TukTuk;
import com.gt.transport.Vehicle;
import com.gt.transport.Vehicle.WEATHER;

public class App {
	private List<Location> locations = new ArrayList<Location>();
	private List<Orbit> orbits = new ArrayList<Orbit>();

	public static void main(String[] args) {

		new App().start();
	}

	public void start() {

		/*
		 * for (int i = 0; i < 11; i++) { Location location = new
		 * Location("Node_" + i, "Node_" + i); locations.add(location); }
		 * 
		 * addLane("Orbit_0", 0, 1, 85); addLane("Orbit_1", 0, 2, 217);
		 * addLane("Orbit_2", 0, 4, 173); addLane("Orbit_3", 2, 6, 186);
		 * addLane("Orbit_4", 2, 7, 103); addLane("Orbit_5", 3, 7, 183);
		 * addLane("Orbit_6", 5, 8, 250); addLane("Orbit_7", 8, 9, 84);
		 * addLane("Orbit_8", 7, 9, 167); addLane("Orbit_9", 4, 9, 502);
		 * addLane("Orbit_10", 9, 10, 40); addLane("Orbit_11", 1, 10, 600);
		 */

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the weather");
		String weatherStr = scanner.nextLine();

		WEATHER weather = WEATHER.valueOf(weatherStr.toUpperCase());

		System.out.println("Enter Orbit1 traffic speed in mm/hr : ");
		int orbit1MaxTrafficSpeed = Integer.parseInt(scanner.nextLine());

		System.out.println("Enter Orbit2 traffic speed in mm/hr : ");
		int orbit2MaxTrafficSpeed = Integer.parseInt(scanner.nextLine());

		System.out.println("Enter Orbit3 traffic speed in mm/hr : ");
		int orbit3MaxTrafficSpeed = Integer.parseInt(scanner.nextLine());

		System.out.println("Enter Orbit4 traffic speed in mm/hr : ");
		int orbit4MaxTrafficSpeed = Integer.parseInt(scanner.nextLine());

		locations.add(new Location("Silk Dorb"));
		locations.add(new Location("Hallitharam"));
		locations.add(new Location("RK Puram"));

		orbits.add(new Orbit("Orbit1", locations.get(0), locations.get(1), 10,
				18, 20, orbit1MaxTrafficSpeed));
		orbits.add(new Orbit("Orbit2", locations.get(0), locations.get(1), 10,
				20, 10, orbit2MaxTrafficSpeed));
		orbits.add(new Orbit("Orbit3", locations.get(0), locations.get(2), 10,
				30, 15, orbit3MaxTrafficSpeed));
		orbits.add(new Orbit("Orbit4", locations.get(1), locations.get(2), 10,
				15, 18, orbit3MaxTrafficSpeed));

		Graph graph = new Graph(locations, orbits);
		ShortestPathAlgorithm sra = new ShortestPathAlgorithm(graph,
				new Vehicle[] { new Bike(), new SuperCar(), new TukTuk() },
				weather);
		sra.execute(locations.get(0), new Bike());
		LinkedList<Location> path = sra.getPath(locations.get(2));

		for (Location location : path) {
			System.out.println(location);
		}

	}

}
