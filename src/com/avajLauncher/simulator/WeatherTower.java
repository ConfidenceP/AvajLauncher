package com.avajLauncher.simulator;

import com.avajLauncher.simulator.vehicles.Coordinates;
import com.avajLauncher.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
