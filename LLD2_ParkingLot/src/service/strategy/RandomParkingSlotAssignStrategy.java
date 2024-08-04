package service.strategy;

import manager.TicketManager;
import Models.ParkingFloor;
import Models.ParkingLot;
import Models.ParkingSlot;
import Models.enums.ParkingSpotStatus;
import Models.enums.VehicleType;
import Repositories.ParkingLotRepository;

import java.util.List;
import java.util.Optional;

public class RandomParkingSlotAssignStrategy implements ParkingSlotAssignmentStrategy{
    int enteredSmallVehicle=0;
    int enteredMediumVehicle=0;
    int enteredHeavyVehicle=0;

    private ParkingLotRepository plr;
    @Override
    public Optional<ParkingSlot> assignParkingSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor floor:parkingLot.getParkingFloors()){
            for (ParkingSlot slot:floor.getParkingSlotList()){
                if(slot.getSupportedvehicleType().equals(vehicleType) && slot.getCurrentParkingStatus().equals(ParkingSpotStatus.AVAILABLE)) {
                    slot.setParkingFloor(floor);
                    if(vehicleType.equals(VehicleType.SMALL))
                    {
                        enteredSmallVehicle++;
                        if (enteredSmallVehicle==TicketManager.getCountSmall()){
                            System.out.println("PARKING IS FULL FOR TWO WHEELERS");
                        }
                    } else if (vehicleType.equals(VehicleType.MEDIUM)) {
                        enteredMediumVehicle++;
                        if (enteredMediumVehicle==TicketManager.getCountMedium()){
                            System.out.println("PARKING IS FULL FOR FOUR WHEELERS - CAR,CABS");
                        }
                    } else if (vehicleType.equals(VehicleType.HEAVY)) {
                        enteredHeavyVehicle++;
                        if (enteredHeavyVehicle==TicketManager.getCountHeavy()){
                            System.out.println("PARKING IS FULL FOR HEAVY VEHICLES - BUS,TRUCKS");
                        }
                    }
                    else {
                        throw new RuntimeException("Vehicle Type entered is invalid");
                    }
                    return Optional.of(slot);
                }
            }
        }
        return Optional.empty();
    }
}
