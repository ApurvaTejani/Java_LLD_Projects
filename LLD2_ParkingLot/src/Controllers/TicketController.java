package Controllers;


import DTO.GenerateTicketRequestDTO;
import DTO.GeneratedTicketResponseDTO;
import DTO.ResponseStatus;
import Models.Ticket;
import service.TicketService;

public class TicketController {

    private TicketService ts;

    public TicketController(TicketService ts){
        this.ts=ts;
    }

    public GeneratedTicketResponseDTO generateTicket (GenerateTicketRequestDTO requestObject){
        GeneratedTicketResponseDTO responseDTO= new GeneratedTicketResponseDTO();
        try {
           Ticket ticket= ts.generateTicket(requestObject.getGateId(), requestObject.getVehicleType(), requestObject.getVehicleNumber(), requestObject.getOwnerName());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setTicket(ticket);
        }
        catch (Exception ex){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(ex.getMessage());
        }
        return responseDTO;
    }
}

