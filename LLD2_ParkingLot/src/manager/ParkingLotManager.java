package manager;

import Models.Gate;
import Models.ParkingFloor;
import Models.ParkingLot;
import Models.ParkingSlot;
import Models.enums.ParkingLotStatus;
import Repositories.ParkingLotRepository;

import java.util.List;

public class ParkingLotManager {
    public ParkingLot initializeParkingLot(List<Gate>gateList, List<ParkingFloor> parkingFloorList, int NoOfSlots, ParkingLotRepository plr){
        ParkingLot pl = new ParkingLot();
        pl.setId(54322);
        pl.setAddress("Inorbit Mall");
        pl.setGates(gateList);
        pl.setParkingFloors(parkingFloorList);
        int capacity=parkingFloorList.size()*NoOfSlots;
        pl.setCapacity(capacity);
        pl.setParkingLotStatus(ParkingLotStatus.OPEN);
        pl.setGates(gateList);
        plr.save(pl);
        return pl;
    }
}
