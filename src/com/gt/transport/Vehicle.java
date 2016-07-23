package com.gt.transport;

public interface Vehicle {
	int getSpeed();

	int getTimeToCrossCrater();

	boolean isSupportedWeather(WEATHER weather);

	public enum WEATHER {
		SUNNY(-0.1), RAINY(0.2), WINDY(0.0);

		private double craterFactor;

		WEATHER(double craterFactor) {
			this.craterFactor = craterFactor;
		}

		public double getCraterFactor() {
			return craterFactor;
		}

	}

}
