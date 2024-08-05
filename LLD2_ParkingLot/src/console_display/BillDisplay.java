package console_display;

import DTO.BillResponseDTO;
import Models.Bill;

public class BillDisplay {


    public void display(BillResponseDTO responseDTO){
        Bill bill = responseDTO.getBill();
        System.out.println(("--").repeat(50));
        System.out.println("Bill Invoice no: "+bill.getInvoiceNumber());
        System.out.println("Owner name: "+bill.getTicket().getVehicle().getOwnerName());
        System.out.println("Vehicle No: "+bill.getTicket().getVehicle().getVehicleNumber());
        System.out.println("Bill Generated at (Exit time): "+bill.getExitTime());
        System.out.println("Exit Gate Number: "+bill.getExitGate().getGateNumber());
        System.out.println("Ticket Given by: "+bill.getOp().getName());
        System.out.println("Amount :"+bill.getAmount());
        System.out.println(("--").repeat(50));
    }
}
