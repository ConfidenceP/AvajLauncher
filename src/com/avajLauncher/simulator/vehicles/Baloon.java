package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.simulator.WeatherTower;
import com.avajLauncher.weather.WeatherProvider;

import java.util.HashMap;
import java.util.Map;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);

    }

    public void updateConditions()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("SUN", "its hot");
        map.put("FOG", "its foggy");
        map.put("SNOW", "its chilly");
        map.put("RAIN", "its wetty");


        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(),
                    coordinates.getHeight() + 4 > 100 ? 100 : coordinates.getHeight() + 4);
        }
        if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 5 < 0 ? 0 : coordinates.getHeight() - 5);
        }
        if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 3 < 0 ? 0 : coordinates.getHeight() - 3);
        }
        if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 15 < 0 ? 0 : coordinates.getHeight() - 15);
        }
        if (coordinates.getHeight() == 0)
        {
            System.out.println("Baloon# " + this.name + this.id + " landing.");
        }

        System.out.println("Baloon# " + this.name + this.id +  " " + map.get(weather));
//        System.out.println("Baloon#" + this.name + this.id +  );
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Baloon# " + this.name + this.id + "registered To weather");
    }
}
