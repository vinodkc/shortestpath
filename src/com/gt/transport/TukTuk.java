package com.gt.transport;

public class TukTuk extends AbstractVehicle {
	public TukTuk() {
		super(12, 1,new WEATHER[] {WEATHER.SUNNY,WEATHER.RAINY} );
	}

	@Override
	public String toString() {
		return "TukTuk";
	}
	
}
