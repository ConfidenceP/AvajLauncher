package com.avajLauncher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.avajLauncher.simulator.vehicles.AircraftFactory;
import com.avajLauncher.simulator.vehicles.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {


        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
//            BufferedReader reader = new BufferedReader(new FileReader(args[0])); /** Instantiating BufferedReader **/
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);

                if (simulations <= 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
//
                    flyables.add(flyable);
                }

                for (Flyable flyable: flyables) {
                    flyable.registerTower(weatherTower);
                }
                for(int i = 1; i <= simulations; i++)
                {
                    weatherTower.changeWeather();
                }
            }
        }
        catch (IOException e)
        {
            Logger.addMessage("error lol");
        }

        /** Look at creating class to handle exceptions **/

        finally {
            Logger.addMessage("**** finally i am done ****");
//            reader.close(); /** Look at moving reader.close to finally block **/
            Logger.logMessage();
        }
    }
}
