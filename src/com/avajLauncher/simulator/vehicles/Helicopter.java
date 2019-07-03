package com.avajLauncher.simulator.vehicles;

import com.avajLauncher.simulator.WeatherTower;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        HashMap<String, String> map = new HashMap<>();
        map.put("SUN", "I see flames!");
        map.put("FOG", "I wonder if the radar can even find me here");
        map.put("SNOW", "I think I'm in the middle of snowball war.");
        map.put("RAIN", "Taking a bath high up here!");


        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(),
                    coordinates.getHeight() + 2 > 100 ? 100 : coordinates.getHeight() + 2);
        }
        if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                    coordinates.getHeight());
        }
        if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                    coordinates.getHeight());
        }
        if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                    coordinates.getHeight() - 12 < 0 ? 0 : coordinates.getHeight() - 12);
        }
        if (coordinates.getHeight() == 0)
        {
            System.out.println("Helicopter# " + this.name + this.id + " landing.");
        }

        System.out.println("Helicopter# " + this.name + this.id +  " " + map.get(weather));
//        System.out.println("Baloon#" + this.name + this.id +  );
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Helicopter# " + this.name + this.id + "registered To weather");
    }
}
