package com.gt.transport;

public class SuperCar extends AbstractVehicle {
	public SuperCar() {
		super(20, 3, new WEATHER[] { WEATHER.SUNNY, WEATHER.RAINY,
				WEATHER.WINDY });
	}

	@Override
	public String toString() {
		return "Car";
	}
	
}
