package com.avajLauncher.weather;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {
            "RAIN", "FOG", "SUN", "SNOW"
    };

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int i = 0;
        return weather[i];
    }
}
