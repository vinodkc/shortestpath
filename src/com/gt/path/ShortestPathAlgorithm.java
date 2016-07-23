package com.gt.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gt.path.Orbit;
import com.gt.transport.Vehicle;
import com.gt.transport.Vehicle.WEATHER;

public class ShortestPathAlgorithm {
	private final List<Location> locations;
	private final List<Orbit> orbits;
	private Set<Location> settledNodes;
	private Set<Location> unSettledNodes;
	private Map<Location, Location> predecessors;
	private Map<Location, Integer> distance;

	private final Vehicle[] vehicles;
	private final WEATHER weather;

	public ShortestPathAlgorithm(Graph graph, Vehicle[] vehicles,
			WEATHER weather) {
		// create a copy of the array so that we can operate on this array
		this.locations = new ArrayList<Location>(graph.getLocations());
		this.orbits = new ArrayList<Orbit>(graph.getOrbits());
		this.vehicles = vehicles;
		this.weather = weather;
	}

	public void execute(Location source, Vehicle vehicle) {
		settledNodes = new HashSet<Location>();
		unSettledNodes = new HashSet<Location>();
		distance = new HashMap<Location, Integer>();
		predecessors = new HashMap<Location, Location>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Location node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node, vehicle);
		}
	}

	private void findMinimalDistances(Location node, Vehicle vehicle) {
		List<Location> adjacentNodes = getNeighbors(node);
		for (Location target : adjacentNodes) {
			int newDist = getShortestDistance(node)
					+ getDistance(node, target, vehicle);
			if (getShortestDistance(target) > newDist) {
				distance.put(target, newDist);
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private int getDistance(Location node, Location target, Vehicle vehicle) {
		for (Orbit edge : orbits) {
			if (edge.getSource().equals(node)
					&& edge.getDestination().equals(target)) {
				return getTimeInMinutes(vehicle, edge);
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Location> getNeighbors(Location node) {
		List<Location> neighbors = new ArrayList<Location>();
		for (Orbit edge : orbits) {
			if (edge.getSource().equals(node)
					&& !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	private Location getMinimum(Set<Location> vertexes) {
		Location minimum = null;
		for (Location vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Location vertex) {
		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(Location destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<Location> getPath(Location target) {
		LinkedList<Location> path = new LinkedList<Location>();
		Location step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

	private int getTimeInMinutes(Vehicle vehicle, Orbit orbit) {
		int maxSpeed = getMaxSpeed(vehicle, orbit);

		return (int) ((orbit.getDistance() / maxSpeed) * 60 + (orbit
				.getCraterCount() * (1 + weather.getCraterFactor()))
				* vehicle.getTimeToCrossCrater());
	}

	private int getMaxSpeed(Vehicle vehicle, Orbit orbit) {
		return (orbit.getMaxAllowedSpeed() > vehicle.getSpeed()) ? vehicle
				.getSpeed() : orbit.getMaxAllowedSpeed();
	}

}
