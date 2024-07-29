import Controllers.TicketController;
import DTO.GenerateTicketRequestDTO;
import DTO.GeneratedTicketResponseDTO;
import DTO.ResponseStatus;
import Models.enums.VehicleType;
import service.TicketService;

public class Client {
    //Task 1- Generate a ticket of vehicle at entry gate
    public static void main(String[] args) {
        TicketService ts = new TicketService();
        TicketController tc = new TicketController(ts);
        GenerateTicketRequestDTO requestObject= new GenerateTicketRequestDTO();
        requestObject.setGateId(10L);
        requestObject.setVehicleNumber("MH47AR7546");
        requestObject.setVehicleType(VehicleType.SMALL);
        GeneratedTicketResponseDTO responseDTO= tc.generateTicket(requestObject);
        if(responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println(responseDTO.getTicketId());
        }
        else {
            System.out.println("Failed");
        }

    }


}
