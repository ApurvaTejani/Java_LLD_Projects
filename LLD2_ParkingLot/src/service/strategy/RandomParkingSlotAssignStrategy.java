package service.strategy;


import Models.ParkingFloor;
import Models.ParkingLot;
import Models.ParkingSlot;
import Models.enums.ParkingSpotStatus;
import Models.enums.VehicleType;
import Repositories.ParkingLotRepository;

import java.util.List;

public class RandomParkingSlotAssignStrategy implements ParkingSlotAssignmentStrategy{

    private ParkingLotRepository plr;
    @Override
    public ParkingSlot assignParkingSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor floor:parkingLot.getParkingFloors()){
            for (ParkingSlot slot:floor.getParkingSlotList()){
                if(slot.getSupportedvehicleType().equals(vehicleType) && slot.getCurrentParkingStatus().equals(ParkingSpotStatus.AVAILABLE))
                    return slot;
            }
        }
        return null;
    }
}
