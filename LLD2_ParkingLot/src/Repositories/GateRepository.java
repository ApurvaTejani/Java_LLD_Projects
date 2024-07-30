package Repositories;

import Models.Gate;
import Models.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Integer, Gate> gateDB = new TreeMap<>();

    private int incrementalInt;
    public Optional<Gate> findGateById(int gateId){
        // db.execute('select * from gate where gate_id = gateId');
        if(gateDB.containsKey(gateId)){
            return Optional.of(gateDB.get(gateId));
        }
        return Optional.empty();
    }
    public Gate save(Gate gate) {
        incrementalInt++;
        gateDB.put(incrementalInt,gate);
        return gate;
    }


}
