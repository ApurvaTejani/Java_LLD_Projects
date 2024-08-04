package Repositories;


import Models.Ticket;

import java.util.Map;
import java.util.Optional;
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


    public Optional<Ticket> findTicketById(int ticketId){
        // db.execute('select * from gate where id = ticktId');
        if(ticketDB.containsKey(ticketId)){
            return Optional.of(ticketDB.get(ticketId));
        }
        return Optional.empty();
    }
}
