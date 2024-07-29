package service;

import Models.Vehicle;
import Models.enums.VehicleType;

public class VehicleService {
    private Vehicle vehicle;
    public Vehicle getVehicleFromRepo(String vehicleNumber, VehicleType vehicleType) {
        // Call to repo and then to DB to see if Vehicle is present or not
        return null;
    }

    public void registerVehicle(String vehicleNumber, VehicleType vehicleType) {
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setVehicleType(vehicleType);
    }
}
