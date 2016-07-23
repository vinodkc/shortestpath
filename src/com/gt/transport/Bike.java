package com.gt.transport;

public class Bike extends AbstractVehicle {

	public Bike() {
		super(10, 2,new WEATHER[] {WEATHER.SUNNY,WEATHER.WINDY} );
	}

	@Override
	public String toString() {
		return "Bike";
	}

}
