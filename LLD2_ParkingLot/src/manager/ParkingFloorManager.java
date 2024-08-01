package manager;

import Models.ParkingFloor;
import Models.ParkingSlot;
import Models.enums.FloorStatus;
import Models.enums.ParkingSpotStatus;
import Models.enums.VehicleType;


import java.util.ArrayList;
import java.util.List;

public class ParkingFloorManager {
    public List<ParkingFloor> initializeParkingFloors(int NoOfParkingFloors,int NoOfParkingSlots){
        List<ParkingFloor> parkingFloorList = new ArrayList<>();

        for (int i = 0; i < NoOfParkingFloors; i++) {
            ParkingFloor pf = new ParkingFloor();
            pf.setId(i + 100);
            pf.setNumber("FloorNo :" + (i + 1));
            pf.setFloorStatus(FloorStatus.OPEN);

            List<ParkingSlot> parkingSlotList = new ArrayList<>();
            List<VehicleType> vehicleTypeList = new ArrayList<>();
            for (int j = 0; j < NoOfParkingSlots; j++) {
                ParkingSlot ps = new ParkingSlot();
                int assigner = j % 3;
                ps.setId((i+1)*(j+1)+10);
                ps.setNumber("SlotNo:"+(i+1)+""+ j+""+10);
                ps.setCurrentParkingStatus(ParkingSpotStatus.AVAILABLE);
                if (assigner == 0) {
                    ps.setSupportedvehicleType(VehicleType.SMALL);
                } else if (assigner == 1) {
                    ps.setSupportedvehicleType(VehicleType.MEDIUM);
                } else if (assigner == 2) {
                    ps.setSupportedvehicleType(VehicleType.HEAVY);
                }
                parkingSlotList.add(ps);
                vehicleTypeList.add(ps.getSupportedvehicleType());
            }

            pf.setParkingSlotList(parkingSlotList);
            pf.setVehicleTypeList(vehicleTypeList);
            parkingFloorList.add(pf);
        }

        return parkingFloorList;
    }
}
