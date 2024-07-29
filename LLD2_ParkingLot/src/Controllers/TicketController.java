package Controllers;

import DTO.GenerateTicketRequestDTO;
import DTO.GeneratedTicketResponseDTO;
import DTO.ResponseStatus;
import Models.Ticket;
import service.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ts){
        ticketService=ts;
    }
    public GeneratedTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestObjectDTO){
        GeneratedTicketResponseDTO responseDTO = new GeneratedTicketResponseDTO();
        try{
            Ticket ticket = ticketService.generateTicket(requestObjectDTO.getGateId(),requestObjectDTO.getVehicleNumber(),requestObjectDTO.getVehicleType());
            responseDTO.setTicketId(ticket.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
