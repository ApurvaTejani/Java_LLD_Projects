
import DTO.GeneratedTicketResponseDTO;

import Models.*;

import Repositories.GateRepository;
import Repositories.ParkingLotRepository;

import console_display.TicketDisplay;
import manager.*;

import java.util.List;
import java.util.Scanner;

public class Client {
    //Task 1- Generate a ticket of vehicle at entry gate
    public static void main(String[] args) {

        //Initialize Setup
        Scanner sc = new Scanner(System.in);
        ParkingLotSetupUserInfo ui = new ParkingLotSetupUserInfo();
        ui.initializeSetup(sc);

        // Operator initialization
        OperatorManager om = new OperatorManager();
        List<Operator> operatorList = om.initializeOperators(ui.getNoOfGates(), sc);

        // Gate initialization and Gate DB Save
        GateManager gm = new GateManager();
        GateRepository gr = new GateRepository();
        List<Gate> gateList=gm.initializeGates(ui.getNoOfGates(),operatorList,gr);

        // Parking Slot initialization
        ParkingSlotManager psm= new ParkingSlotManager();
        List<ParkingSlot> parkingSlotList=psm.initializeParkingSlots(ui.getNoOfParkingSlots());

        // Parking Floor initialization
        ParkingFloorManager pfm= new ParkingFloorManager();
        List<ParkingFloor> parkingFloorList=pfm.initializeParkingFloors(ui.getNoOfParkingFloors(),parkingSlotList);

        // Parking Floor initialization and save to ParkingLot DB
        ParkingLotManager plm = new ParkingLotManager();
        ParkingLotRepository plr= new ParkingLotRepository();
        ParkingLot pl = plm.initializeParkingLot(gateList,parkingFloorList,ui.getNoOfParkingSlots(),plr);

        System.out.println("Your Parking Lot Setup is Completed....Thanks for info We have updated in our database");

        // Get Response of Ticket
        TicketManager tm = new TicketManager();
        GeneratedTicketResponseDTO dto=tm.initializeTicket(gr,plr,sc);





    }

// Make all models first

// Requirement
// 1. Generate a ticket at entry of a vehicle at a gate

// TicketController
// Inputs and Outputs of a controller
// Inputs of a controller
// 1. Can models be this input?

// 2. Can we have multiple parameters in input?
// 2.1 Single parameter is advisable, because the code won't break if accept more values, via more properties in request object

}
