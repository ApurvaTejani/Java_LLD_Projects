package Repositories;

import Models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Long,Ticket> ticketDB = new HashMap<>();
    private long incrementalValue;
    public void save(Ticket ticket){
        incrementalValue++;
        ticketDB.put(incrementalValue,ticket);
    }
}
