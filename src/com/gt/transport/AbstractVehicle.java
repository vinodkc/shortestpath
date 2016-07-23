package com.gt.transport;

public class AbstractVehicle implements Vehicle {

	int speed;
	int timeToCrossCrater;
	WEATHER supportedWeathers[];

	AbstractVehicle(int speed, int timeToCrossAcrater,
			WEATHER supportedWeathers[]) {
		this.speed = speed;
		this.timeToCrossCrater = timeToCrossAcrater;
		this.supportedWeathers = supportedWeathers;
	}

	@Override
	public boolean isSupportedWeather(WEATHER w) {
		for (WEATHER weather : supportedWeathers) {
			if (weather == w) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getTimeToCrossCrater() {
		return timeToCrossCrater;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

}
