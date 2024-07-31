package console_display;

import DTO.GeneratedTicketResponseDTO;
import Models.Ticket;

public class TicketDisplay {
    public void display(GeneratedTicketResponseDTO dto) {
        Ticket ticket=dto.getTicket();
        System.out.println(("--").repeat(50));
        System.out.println("Ticket Invoice no: "+ticket.getId());
        System.out.println("Owner name: "+ticket.getVehicle().getOwnerName());
        System.out.println("Vehicle No: "+ticket.getVehicle().getVehicleNumber());
        System.out.println("Ticket Generated at: "+ticket.getEntryTime());
        System.out.println("Entry Gate Number: "+ticket.getEntryGate().getGateNumber());
        System.out.println("Ticket Given by: "+ticket.getOp().getName());
        System.out.println("Assigned Slot: "+ticket.getAssignedParkingSpot().getNumber());
        System.out.println(("--").repeat(50));
    }
}
