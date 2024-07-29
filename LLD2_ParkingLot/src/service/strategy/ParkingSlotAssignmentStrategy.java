package service.strategy;

import Models.ParkingSlot;
import Models.enums.VehicleType;

public interface ParkingSlotAssignmentStrategy {
    ParkingSlot assignParkingSlot(Long gateId, VehicleType vehicleType);
}
