package service;


import Models.*;
import Models.enums.ParkingSpotStatus;
import Models.enums.VehicleType;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import service.strategy.ParkingSlotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gr;
    private VehicleRepository vr;

    private ParkingSlotAssignmentStrategy psas;

    private ParkingLotRepository plr;

    private TicketRepository tr;

    public TicketService(GateRepository gr, VehicleRepository vr, ParkingSlotAssignmentStrategy psas,TicketRepository tr,ParkingLotRepository plr) {
        this.gr = gr;
        this.vr = vr;
        this.psas = psas;
        this.tr=tr;
        this.plr=plr;
    }

    public Ticket generateTicket(int gateId, VehicleType vehicleType, String vehicleNumber, String ownerName){
           Ticket ticket= new Ticket();
           ticket.setEntryTime(new Date());
            Optional<Gate> gateOptional=gr.findGateById(gateId);
            if(gateOptional.isEmpty()){
                throw new RuntimeException("Invalid Gate entered");
            }

            Gate gate= gateOptional.get();
            ticket.setEntryGate(gate);

            ticket.setOp(gate.getOp());
            Optional<Vehicle> vehicleOptional=vr.findVehicleByNumber(vehicleNumber);
            Vehicle savedVehicle;

            if(vehicleOptional.isEmpty()){
                Vehicle vehicle= new Vehicle();
                vehicle.setVehicleNumber(vehicleNumber);
                vehicle.setOwnerName(ownerName);
                vehicle.setVehicleType(vehicleType);
                savedVehicle=vr.save(vehicle);
            }
            else {
                savedVehicle=vehicleOptional.get();
            }
            ticket.setVehicle(savedVehicle);
            ParkingLot parkingLot= plr.findParkingLotByGateId(gate);
            ParkingSlot parkingSlot=psas.assignParkingSlot(parkingLot,vehicleType);
            ticket.setAssignedParkingSpot(parkingSlot);
            ticket.setNumber("TICKET NO "+ticket.getId());
            parkingSlot.setCurrentParkingStatus(ParkingSpotStatus.OCCUPIED);
            Ticket savedTicket = tr.save(ticket);
            return savedTicket;

        }
}
