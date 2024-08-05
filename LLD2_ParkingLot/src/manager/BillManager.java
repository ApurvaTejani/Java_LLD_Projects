package manager;

import Controllers.BillController;
import DTO.BillRequestDTO;
import DTO.BillResponseDTO;
import DTO.BillResponseStatus;;
import Repositories.BillRepository;
import Repositories.GateRepository;
import Repositories.TicketRepository;
import console_display.BillDisplay;
import service.BillService;
import service.strategy.BasicFeesCalculationWithTaxStrategy;
import service.strategy.FeesCalculationStrategy;

import java.util.Scanner;

public class BillManager {


    public void initializeBill(GateRepository gr, TicketRepository tr,Scanner sc){

        BillRepository br = new BillRepository();
        TicketManager tm = new TicketManager();
        FeesCalculationStrategy fcs= new BasicFeesCalculationWithTaxStrategy();
        BillDisplay bd= new BillDisplay();
        BillService bs = new BillService(gr,tr,fcs,br);
        BillController bc = new BillController(bs);
        BillRequestDTO dto=new BillRequestDTO();
        while(true) {
            System.out.println("Enter the gate id where you exiting from: ");
            int gateId = sc.nextInt();
            dto.setGateId(gateId);
            System.out.println("Enter your ticket id number: ");
            int ticketId = sc.nextInt();
            dto.setTicketId(ticketId);
            System.out.println("Want to exit? ");
            String exit=sc.next();

            BillResponseDTO responseDTO = bc.generateBill(dto);

            if (responseDTO.getBillStatus().equals(BillResponseStatus.FAILED)) {
                System.out.println(("--").repeat(50));
                System.out.println("Bill is not Generated Successfully Reason - " + responseDTO.getMessage());
                System.out.println(("--").repeat(50));
                continue;
            }
            bd.display(responseDTO);
            if(exit.equalsIgnoreCase("yes")){
                break;
            }
        }


    }
}
