package manager;

import Models.ParkingSlot;
import Models.enums.ParkingSpotStatus;
import Models.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlotManager {


    public List<ParkingSlot> initializeParkingSlots(int NoOfParkingSlots){
        List<ParkingSlot> parkingSlotList= new ArrayList<>();
        for (int i = 0; i <NoOfParkingSlots ; i++) {
            ParkingSlot ps= new ParkingSlot();
            int assigner=i%3;
            ps.setId(i+100);
            ps.setNumber("SlotNo:"+i+100);
            ps.setCurrentParkingStatus(ParkingSpotStatus.AVAILABLE);
            if(assigner==0) {
                ps.setSupportedvehicleType(VehicleType.SMALL);
            } else if (assigner==1) {
                ps.setSupportedvehicleType(VehicleType.MEDIUM);
            } else if (assigner==2) {
                ps.setSupportedvehicleType(VehicleType.HEAVY);
            }
            parkingSlotList.add(ps);
        }
        return parkingSlotList;
    }
}
