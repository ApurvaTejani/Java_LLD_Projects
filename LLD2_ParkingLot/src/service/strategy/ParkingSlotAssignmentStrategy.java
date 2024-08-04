package service.strategy;

import Models.ParkingLot;
import Models.ParkingSlot;
import Models.enums.VehicleType;

import java.util.Optional;

public interface ParkingSlotAssignmentStrategy {
    Optional<ParkingSlot> assignParkingSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
