package com.gt.transport;

import com.gt.transport.Vehicle.WEATHER;

public class Traffic {
	/*private Orbit[] orbits;

	public Traffic(Orbit[] orbits) {
		this.orbits = orbits;
	}
*/
	/*public Result findShortestPath(Vehicle[] vehicles, WEATHER weather) {
		Result result = new Result(null, null, Integer.MAX_VALUE);
		for (Vehicle vehicle : vehicles) {
			if (vehicle.isSupportedWeather(weather)) {
				for (Orbit orbit : orbits) {

					int maxSpeed = getMaxSpeed(vehicle, orbit);

					int timeMinutes = getTimeInMinutes(weather, vehicle, orbit, maxSpeed);

					System.out.println("Vehicle :" + vehicle + " Orbit :"
							+ orbit + " Time : " + timeMinutes);
					if (timeMinutes < result.getTimeMinutes()) {
						result.setOrbit(orbit);
						result.setVehicle(vehicle);
						result.setTimeMinutes(timeMinutes);
					}

				}

			}

		}
		return result;
	}

	private int getTimeInMinutes(WEATHER weather, Vehicle vehicle, Orbit orbit,
			int maxSpeed) {
		return (int) ((orbit.getDistance() / maxSpeed) * 60 + (orbit
				.getCraterCount() * (1 + weather.getCraterFactor()))
				* vehicle.getTimeToCrossCrater());
	}

	private int getMaxSpeed(Vehicle vehicle, Orbit orbit) {
		return (orbit.getMaxAllowedSpeed() > vehicle
				.getSpeed()) ? vehicle.getSpeed() : orbit
				.getMaxAllowedSpeed();
	}
*/
}
