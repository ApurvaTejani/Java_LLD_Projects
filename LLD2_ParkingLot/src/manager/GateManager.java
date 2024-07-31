package manager;

import Models.Gate;
import Models.Operator;
import Models.enums.GateStatus;
import Models.enums.GateType;
import Repositories.GateRepository;

import java.util.ArrayList;
import java.util.List;

public class GateManager {
    public List<Gate> initializeGates(int noOfGates, List<Operator> operatorList,GateRepository gr){
        List<Gate> gateList= new ArrayList<>();
        for (int i = 0; i < noOfGates ; i++) {
            Gate g = new Gate();
            g.setGateType(GateType.ENTRY);
            g.setGateStatus(GateStatus.OPEN);
            g.setId(i+1);
            g.setOp(operatorList.get(i));
            g.setGateNumber("Entry Gate No "+(i+1));
            gr.save(g);
            gateList.add(g);
        }
        return gateList;
    }
}
