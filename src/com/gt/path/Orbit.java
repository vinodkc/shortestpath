package com.gt.path;

public class Orbit {
	private final String name;
	private final Location source;
	private final Location destination;
	private final int weight;
	
	private final int distance;
	private final int craterCount;
	private final int maxAllowedSpeed;
	
	public int getDistance() {
		return distance;
	}

	public int getCraterCount() {
		return craterCount;
	}

	public int getMaxAllowedSpeed() {
		return maxAllowedSpeed;
	}

	public Orbit(String name, Location source, Location destination, int weight,int distance,int craterCount,int maxAllowedSpeed) {
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		
		this.distance = distance;
		this.craterCount = craterCount;
		this.maxAllowedSpeed = maxAllowedSpeed;
	}

	public String getName() {
		return name;
	}

	public Location getDestination() {
		return destination;
	}

	public Location getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return name;
	}
}
