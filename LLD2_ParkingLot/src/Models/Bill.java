package Models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseClass{
    private Ticket ticket;
    private Date exitTime;
    private int amount;
    List<Payment> paymentList;
    private Gate gate;
}
