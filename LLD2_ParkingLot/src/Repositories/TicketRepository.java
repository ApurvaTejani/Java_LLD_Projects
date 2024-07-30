package Repositories;


import Models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {

    private Map<Integer,Ticket> ticketDB= new TreeMap<>();
    private int incrementalInt;

    public Ticket save(Ticket ticket) {
        incrementalInt++;
        ticketDB.put(incrementalInt,ticket);
        ticket.setId(incrementalInt);
        return ticket;
    }
}
