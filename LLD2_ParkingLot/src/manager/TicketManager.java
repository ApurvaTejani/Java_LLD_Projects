package manager;

import Controllers.TicketController;
import DTO.GenerateTicketRequestDTO;
import DTO.GeneratedTicketResponseDTO;
import Models.enums.VehicleType;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import console_display.TicketDisplay;
import service.TicketService;
import service.strategy.ParkingSlotAssignmentStrategy;
import service.strategy.RandomParkingSlotAssignStrategy;

import java.util.Scanner;

public class TicketManager {

    public GeneratedTicketResponseDTO initializeTicket(GateRepository gr, ParkingLotRepository plr, Scanner sc){
        TicketRepository tr= new TicketRepository();
        VehicleRepository vr = new VehicleRepository();
        ParkingSlotAssignmentStrategy random= new RandomParkingSlotAssignStrategy();
        TicketService ts= new TicketService(gr,vr,random,tr,plr);
        TicketController tc = new TicketController(ts);
        GenerateTicketRequestDTO dto= new GenerateTicketRequestDTO();
        TicketDisplay td= new TicketDisplay();
        while (true){
            System.out.println("Enter the Gate Number which you are in ");
            int gateId=sc.nextInt();
            dto.setGateId(gateId);
            sc.nextLine();
            System.out.println("Enter your full name ");
            String fullname=sc.nextLine();
            dto.setOwnerName(fullname);
            System.out.println("Enter your RTO registered vehicle number");
            String vehicleno=sc.nextLine();
            dto.setVehicleNumber(vehicleno);
            System.out.println("What is your Vehicle type (Car, Bike, Bus, Rick, Cab, Truck, Scooty)");
            String type= sc.nextLine();
            if(type.equals("Bike") || type.equals("Scooty")){
                dto.setVehicleType(VehicleType.SMALL);
            }
            else if(type.equals("Car") || type.equals("Rick") || type.equals("Cab")){
                dto.setVehicleType(VehicleType.MEDIUM);
            }
            else if(type.equals("Truck") || type.equals("Bus")){
                dto.setVehicleType(VehicleType.HEAVY);
            }
            System.out.println("Want to exit? ");
            String exit=sc.next();


            if(exit.equalsIgnoreCase("yes"))
                break;
            GeneratedTicketResponseDTO responseDTO=tc.generateTicket(dto);
            td.display(responseDTO);

        }
        GeneratedTicketResponseDTO responseDTO=tc.generateTicket(dto);
        return responseDTO;
    }
}
