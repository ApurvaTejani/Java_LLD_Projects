package manager;

import Models.ParkingFloor;
import Models.ParkingSlot;
import Models.enums.FloorStatus;
import Models.enums.VehicleType;


import java.util.ArrayList;
import java.util.List;

public class ParkingFloorManager {
    public List<ParkingFloor> initializeParkingFloors(int NoOfParkingFloors, List<ParkingSlot>slotList){
        List<ParkingFloor> parkingFloorList= new ArrayList<>();
        List<VehicleType> vehicleTypeList= new ArrayList<>();
        for (int i = 0; i < slotList.size() ; i++) {
            vehicleTypeList.add(slotList.get(i).getSupportedvehicleType());
        }
        for (int i = 0; i <NoOfParkingFloors ; i++) {
            ParkingFloor pf = new ParkingFloor();
            pf.setId(i+100);
            pf.setNumber("FloorNo :"+(i+1));
            pf.setFloorStatus(FloorStatus.OPEN);
            pf.setParkingSlotList(slotList);
            pf.setVehicleTypeList(vehicleTypeList);
            parkingFloorList.add(pf);
        }
        return parkingFloorList;
    }
}
