package DTO;

import Models.Ticket;

public class GeneratedTicketResponseDTO {
private Ticket ticket;
private ResponseStatus responseStatus;
private String message;

    @Override
    public String toString() {
        return "GeneratedTicketResponseDTO{" +
                "ticket=" + ticket +
                ", responseStatus=" + responseStatus +
                ", message='" + message + '\'' +
                '}';
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
