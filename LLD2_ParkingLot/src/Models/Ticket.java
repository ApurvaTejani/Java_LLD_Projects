package Models;

import java.util.Date;

public class Ticket extends BaseClass {



    private String number;
    private Date entryTime;
    private ParkingSlot assignedParkingSpot;
    private Gate entryGate;
    private Vehicle vehicle;
    private Operator generatedBy;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSlot getAssignedParkingSpot() {
        return assignedParkingSpot;
    }

    public void setAssignedParkingSpot(ParkingSlot assignedParkingSpot) {
        this.assignedParkingSpot = assignedParkingSpot;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Operator getOp() {
        return generatedBy;
    }

    public void setOp(Operator op) {
        this.generatedBy = op;
    }
}
