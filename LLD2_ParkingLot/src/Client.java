import Controllers.TicketController;
import DTO.GenerateTicketRequestDTO;
import DTO.GeneratedTicketResponseDTO;
import DTO.ResponseStatus;
import Models.Gate;
import Models.ParkingFloor;
import Models.ParkingLot;
import Models.ParkingSlot;
import Models.enums.VehicleType;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
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
        int parkingFloors=sc.nextInt();
        System.out.println("Enter how many parking slots each parking floor has: ");
        int parkingSlots=sc.nextInt();
        System.out.println("Enter number of Entry Gates");
        int noOfGates= sc.nextInt();
        ParkingLot pl = new ParkingLot();
        List<ParkingFloor> parkingFloorList= new ArrayList<>();
        for (int i = 0; i <parkingFloors ; i++) {
            parkingFloorList.add(new ParkingFloor());
        }
        pl.setParkingFloors(parkingFloorList);
        List<ParkingSlot> parkingSlotList= new ArrayList<>();
        for (int i = 0; i < parkingSlots; i++) {
            parkingSlotList.add(new ParkingSlot());
        }
        for (int i = 0; i < parkingFloors ; i++) {
            parkingFloorList.get(i).setParkingSlotList(parkingSlotList);
        }
        List<Gate> gateList= new ArrayList<>();
        for (int i = 0; i < noOfGates ; i++) {
            gateList.add(new Gate());
        }

        pl.setGates(gateList);



    GateRepository gr = new GateRepository();
        for (int i = 0; i <noOfGates ; i++) {
            gr.save(gateList.get(i));
        }

    ParkingLotRepository plr= new ParkingLotRepository();
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
    tc.generateTicket(dto);

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
