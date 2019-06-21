package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.simulator.WeatherTower;
import com.avajLauncher.weather.WeatherProvider;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);

    }

    public void updateConditions() {
        WeatherProvider weatherProvider;
//        if (weatherProvider.getCurrentWeather(coordinates)) {
//
//        }
    }

    public void registerTower(WeatherTower weatherTower) {

    }
}
