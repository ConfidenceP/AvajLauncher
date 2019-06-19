package com.avajLauncher.simulator.vehicles;

public class AircraftFactory {

    private static Flyable flyable = null;

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch (type.toLowerCase()) {
            case "Baloon":
                flyable = new Baloon(name, coordinates);
                return flyable;
            case "JetPlane":
                flyable = new JetPlane(name, coordinates);
                return flyable;
            case "Helicopter":
                flyable = new Helicopter(name, coordinates);
                return flyable;
            default:
                System.out.println("Incorrect aircraft input!");
                System.exit(1);
        }
        return flyable;
    }
}
