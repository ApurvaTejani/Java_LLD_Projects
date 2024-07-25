package Models;

import java.util.Date;

public class Ticket extends BaseClass {
    private Date entryTime;
    private ParkingSlot occupiedParkingSpot;
    private Gate gate;
    private Vehicle vehicle;
    private Operator op;
}
