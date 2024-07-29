package service.strategy;

import Models.ParkingSlot;
import Models.enums.VehicleType;

public class FirstParkingSlotAssignStrategy implements ParkingSlotAssignmentStrategy{
    @Override
    public ParkingSlot assignParkingSlot(Long gateId, VehicleType vehicleType) {
        return null;
    }
}
