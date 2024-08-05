package Repositories;

import Models.Bill;
import Models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class BillRepository {
    private Map<Integer, Bill> billDB= new TreeMap<>();
    private int incrementalInt;

    public Bill save(Bill bill) {
        incrementalInt++;
        billDB.put(incrementalInt,bill);
        bill.setId(incrementalInt);
        return bill;
    }
}
