package Models;

import Models.enums.ParkingSpotStatus;
import Models.enums.VehicleType;

public class ParkingSlot extends BaseClass{
    private String number;
    private ParkingSpotStatus currentParkingStatus;
    private VehicleType supportedvehicleType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ParkingSpotStatus getCurrentParkingStatus() {
        return currentParkingStatus;
    }

    public void setCurrentParkingStatus(ParkingSpotStatus currentParkingStatus) {
        this.currentParkingStatus = currentParkingStatus;
    }

    public VehicleType getSupportedvehicleType() {
        return supportedvehicleType;
    }

    public void setSupportedvehicleType(VehicleType supportedvehicleType) {
        this.supportedvehicleType = supportedvehicleType;
    }
}
