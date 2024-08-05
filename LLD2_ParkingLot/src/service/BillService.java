package service;

import Models.Bill;
import Models.Gate;
import Models.Ticket;
import Repositories.BillRepository;
import Repositories.GateRepository;
import Repositories.TicketRepository;
import service.strategy.FeesCalculationStrategy;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class BillService {

    private GateRepository gr;

    private TicketRepository tr;

    private FeesCalculationStrategy fcs;

    private BillRepository br;


    public BillService(GateRepository gr, TicketRepository tr,FeesCalculationStrategy fcs, BillRepository br){
        this.gr=gr;
        this.tr=tr;
        this.fcs=fcs;
        this.br=br;
    }

    public Bill generateBill(int gateId, int  ticketId){
        Bill bill = new Bill();
        bill.setExitTime(new Date());
        Optional<Gate> gateOptional=gr.findGateById(gateId);
        if(gateOptional.isEmpty()){
            System.out.println("Invalid Exit Gate - Gate Not Found");
        }
        bill.setExitGate(gateOptional.get());

        Optional<Ticket> ticketOptional=tr.findTicketById(ticketId);
        if(ticketOptional.isEmpty()){
            System.out.println("Invalid Ticket - Not Found");
        }
        bill.setTicket(ticketOptional.get());
        bill.setOp(gateOptional.get().getOp());
        Double amount=fcs.calculateAmount(ticketOptional.get().getEntryTime(),bill.getExitTime(),ticketOptional.get().getVehicle().getVehicleType());
        bill.setAmount(amount);
        Bill saveBill=br.save(bill);
       long randomNo=(long) (Math.random()*1000000000);
       saveBill.setInvoiceNumber(randomNo+""+saveBill.getId());




return bill;
    }
}
