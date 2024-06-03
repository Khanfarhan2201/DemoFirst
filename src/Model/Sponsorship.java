package Model;

public class Sponsorship {
    private int sponsorshipID;
    private int eventID;
    private String sponsorName;
    private double amount;
    private String contactPerson;
    private String contactEmail;
    private String contactPhone;
    private String sponsorshipType;
    private String sponsorshipDetails;
    private String sponsorLogo;

    public Sponsorship() {
        // Default constructor
    }

    public Sponsorship(int sponsorshipID, int eventID, String sponsorName, double amount, String contactPerson, String contactEmail, String contactPhone, String sponsorshipType, String sponsorshipDetails, String sponsorLogo) {
        this.sponsorshipID = sponsorshipID;
        this.eventID = eventID;
        this.sponsorName = sponsorName;
        this.amount = amount;
        this.contactPerson = contactPerson;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.sponsorshipType = sponsorshipType;
        this.sponsorshipDetails = sponsorshipDetails;
        this.sponsorLogo = sponsorLogo;
    }

    public int getSponsorshipID() {
        return sponsorshipID;
    }

    public void setSponsorshipID(int sponsorshipID) {
        this.sponsorshipID = sponsorshipID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getSponsorshipType() {
        return sponsorshipType;
    }

    public void setSponsorshipType(String sponsorshipType) {
        this.sponsorshipType = sponsorshipType;
    }

    public String getSponsorshipDetails() {
        return sponsorshipDetails;
    }

    public void setSponsorshipDetails(String sponsorshipDetails) {
        this.sponsorshipDetails = sponsorshipDetails;
    }

    public String getSponsorLogo() {
        return sponsorLogo;
    }

    public void setSponsorLogo(String sponsorLogo) {
        this.sponsorLogo = sponsorLogo;
    }

    @Override
    public String toString() {
        return "Sponsorship{" +
                "sponsorshipID=" + sponsorshipID +
                ", eventID=" + eventID +
                ", sponsorName='" + sponsorName + '\'' +
                ", amount=" + amount +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", sponsorshipType='" + sponsorshipType + '\'' +
                ", sponsorshipDetails='" + sponsorshipDetails + '\'' +
                ", sponsorLogo='" + sponsorLogo + '\'' +
                '}';
    }
}
