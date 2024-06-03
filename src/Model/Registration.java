package Model;

import java.util.Date;

public class Registration {
    private int registrationID;
    private int eventID;
    private int participantID;
    private Date registrationDate;
    private String status;
    private String paymentStatus;
    private String paymentMethod;
    private String remarks;

    public Registration() {
        // Default constructor
    }

    public Registration(int registrationID, int eventID, int participantID, Date registrationDate, String status, String paymentStatus, String paymentMethod, String remarks) {
        this.registrationID = registrationID;
        this.eventID = eventID;
        this.participantID = participantID;
        this.registrationDate = registrationDate;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.remarks = remarks;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationID=" + registrationID +
                ", eventID=" + eventID +
                ", participantID=" + participantID +
                ", registrationDate=" + registrationDate +
                ", status='" + status + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
