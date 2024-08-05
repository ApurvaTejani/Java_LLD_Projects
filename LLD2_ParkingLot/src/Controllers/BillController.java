package Controllers;

import DTO.BillRequestDTO;
import DTO.BillResponseDTO;
import DTO.BillResponseStatus;
import Models.Bill;
import service.BillService;

public class BillController {

    private BillService bs;


    public BillController(BillService bs){
        this.bs=bs;
    }
    public BillResponseDTO generateBill(BillRequestDTO requestObject){
        BillResponseDTO responseDTO= new BillResponseDTO();
        try{
            Bill bill=bs.generateBill(requestObject.getGateId(), requestObject.getTicketId());
            responseDTO.setBill(bill);
            responseDTO.setBillStatus(BillResponseStatus.SUCCESS);
        }
        catch (Exception ex){
            responseDTO.setBillStatus(BillResponseStatus.FAILED);
            responseDTO.setMessage(ex.getMessage());
        }
        return responseDTO;
    }
}
