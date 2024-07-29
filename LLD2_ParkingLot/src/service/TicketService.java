package service;

import Models.Gate;

import Models.ParkingSlot;
import Models.Ticket;
import Models.Vehicle;
import Models.enums.VehicleType;
import Repositories.TicketRepository;
import service.strategy.ParkingSlotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private VehicleService vs;
    private GateService gs;

    private ParkingSlotAssignmentStrategy psas;
    public Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) {
        // Set the 5 parameters of Ticket
        Ticket ticket = new Ticket();
        Gate gate = gs.getGateObjectById(gateId);
        ticket.setEntryTime(new Date());
        Vehicle vh = vs.getVehicleFromRepo( vehicleNumber, vehicleType);
        if(vh==null){
            vs.registerVehicle(vh.getVehicleNumber(),vh.getVehicleType());
        }
        ParkingSlot ps=psas.assignParkingSlot(gateId,vehicleType);
        TicketRepository tr = new TicketRepository();
        ticket.setVehicle(vh);
        ticket.setEntryGate(gate);
        ticket.setOp(gate.getOp());
        ticket.setAssignedParkingSpot(ps);
        tr.save(ticket);

        return  ticket;
    }
}
