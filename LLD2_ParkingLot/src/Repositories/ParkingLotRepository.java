package Repositories;

import Models.Gate;
import Models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotDB = new HashMap<>();
    private int incrementalInt;
    public ParkingLot findParkingLotByGateId(Gate gate){
        for(ParkingLot parkingLot: parkingLotDB.values()){
            if(parkingLot.getGates().contains(gate)){
                return parkingLot;
            }
        }

        return null;
    }
    public ParkingLot save(ParkingLot parkingLot) {
        incrementalInt++;
        parkingLotDB.put(incrementalInt,parkingLot);
        parkingLot.setId(incrementalInt);
        return parkingLot;
    }
}
