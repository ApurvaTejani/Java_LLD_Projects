package DTO;

import Models.Bill;

public class BillResponseDTO {

    private Bill bill;

    private BillResponseStatus billStatus;

    private String message;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public BillResponseStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillResponseStatus billStatus) {
        this.billStatus = billStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
