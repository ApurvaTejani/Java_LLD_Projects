import Controllers.TicketController;
import DTO.GenerateTicketRequestDTO;
import DTO.GeneratedTicketResponseDTO;
import DTO.ResponseStatus;
import Models.*;
import Models.enums.GateStatus;
import Models.enums.GateType;
import Models.enums.ParkingSpotStatus;
import Models.enums.VehicleType;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import manager.*;
import service.GateService;
import service.TicketService;
import service.VehicleService;
import service.strategy.RandomParkingSlotAssignStrategy;
import service.strategy.ParkingSlotAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    //Task 1- Generate a ticket of vehicle at entry gate
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many parking floors you need: ");
        int NoOfParkingFloors=sc.nextInt();
        System.out.println("Enter how many parking slots each parking floor has: ");
        int NoOfParkingSlots=sc.nextInt();
        System.out.println("Enter number of Entry Gates");
        int noOfGates= sc.nextInt();

        // Operator initialization
        OperatorManager om = new OperatorManager();
        List<Operator> operatorList = om.initializeOperators(noOfGates, sc);

        // Gate initialization and Gate DB Save
        GateManager gm = new GateManager();
        GateRepository gr = new GateRepository();
        List<Gate> gateList=gm.initializeGates(noOfGates,operatorList,gr);

        // Parking Slot initialization
        ParkingSlotManager psm= new ParkingSlotManager();
        List<ParkingSlot> parkingSlotList=psm.initializeParkingSlots(NoOfParkingSlots);

        // Parking Floor initialization
        ParkingFloorManager pfm= new ParkingFloorManager();
        List<ParkingFloor> parkingFloorList=pfm.initializeParkingFloors(NoOfParkingFloors,parkingSlotList);

        // Parking Floor initialization and save to ParkingLot DB
        ParkingLotManager plm = new ParkingLotManager();
        ParkingLotRepository plr= new ParkingLotRepository();
        ParkingLot pl = plm.initializeParkingLot(gateList,parkingFloorList,NoOfParkingSlots,plr);


        TicketRepository tr= new TicketRepository();
        VehicleRepository vr = new VehicleRepository();
        ParkingSlotAssignmentStrategy random= new RandomParkingSlotAssignStrategy();
        TicketService ts= new TicketService(gr,vr,random,tr,plr);
        TicketController tc = new TicketController(ts);
        GenerateTicketRequestDTO dto= new GenerateTicketRequestDTO();
        dto.setGateId(1);
        dto.setVehicleType(VehicleType.SMALL);
        dto.setOwnerName("Apurva");
        dto.setVehicleNumber("MH47AR7546");
        GeneratedTicketResponseDTO responseDTO=tc.generateTicket(dto);
        System.out.println(responseDTO.toString());


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
