package DTO;

import Models.Ticket;

public class GeneratedTicketResponseDTO {
    private Long ticketId;
    private ResponseStatus responseStatus;
    private String message;

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }


}
