package Models;

import Models.enums.FloorStatus;
import Models.enums.VehicleType;

import java.util.List;

public class ParkingFloor extends BaseClass {
    private String number;
    private List<ParkingLot> parkingLotsList;
    private List<VehicleType> vehicleTypeList;
    private FloorStatus floorStatus;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ParkingLot> getParkingLotsList() {
        return parkingLotsList;
    }

    public void setParkingLotsList(List<ParkingLot> parkingLotsList) {
        this.parkingLotsList = parkingLotsList;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }
}
