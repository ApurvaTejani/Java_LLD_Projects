package service.strategy;

import Models.ParkingLot;
import Models.ParkingSlot;
import Models.enums.VehicleType;

public interface ParkingSlotAssignmentStrategy {
    ParkingSlot assignParkingSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
