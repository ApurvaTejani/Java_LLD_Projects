package manager;

import Controllers.BillController;
import DTO.BillRequestDTO;
import DTO.BillResponseDTO;
import DTO.BillResponseStatus;
import Models.Bill;
import Repositories.BillRepository;
import Repositories.GateRepository;
import Repositories.TicketRepository;
import service.BillService;
import service.strategy.BasicFeesCalculationWithTaxStrategy;
import service.strategy.FeesCalculationStrategy;

import java.util.Scanner;

public class BillManager {


    public void initializeBill(GateRepository gr, TicketRepository tr,Scanner sc){

        BillRepository br = new BillRepository();
        FeesCalculationStrategy fcs= new BasicFeesCalculationWithTaxStrategy();
        BillService bs = new BillService(gr,tr,fcs,br);
        BillController bc = new BillController(bs);
        BillRequestDTO dto=new BillRequestDTO();
        System.out.println("Enter the gate id where you exiting from: ");
        int gateId=sc.nextInt();
        dto.setGateId(gateId);
        System.out.println("Enter your ticket id number: ");
        int ticketId=sc.nextInt();
        dto.setTicketId(ticketId);
        BillResponseDTO responseDTO=bc.generateBill(dto);
        if(responseDTO.getBillStatus().equals(BillResponseStatus.FAILED)){
            System.out.println("Bill not generated successfully");
        }


    }
}
