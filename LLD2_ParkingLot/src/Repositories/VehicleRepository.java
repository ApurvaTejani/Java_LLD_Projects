package Repositories;


import Models.Gate;
import Models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<Integer, Vehicle> vehicleDB = new TreeMap<>();

    private int incrementalInt;
    public Optional<Vehicle> findVehicleByNumber(String  vehicleNumber){
        for (Vehicle vehicle:
                vehicleDB.values()) {
            if(vehicle.getVehicleNumber().equals(vehicleNumber))
                return Optional.of(vehicle);
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        incrementalInt++;
        vehicleDB.put(incrementalInt,vehicle);
        vehicle.setId(incrementalInt);
        return vehicle;
    }
}

