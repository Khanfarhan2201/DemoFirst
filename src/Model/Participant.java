package Model;

import java.util.Date;

public class Participant {
    private int participantID;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dateOfBirth;
    private String gender;
    private String occupation;
    private String company;
    private int registeredEventsCount;
    private String notes;

    public Participant() {
        // Default constructor
    }

    public Participant(int participantID, String name, String email, String phone, String address, Date dateOfBirth, String gender, String occupation, String company, int registeredEventsCount, String notes) {
        this.participantID = participantID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.occupation = occupation;
        this.company = company;
        this.registeredEventsCount = registeredEventsCount;
        this.notes = notes;
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getRegisteredEventsCount() {
        return registeredEventsCount;
    }

    public void setRegisteredEventsCount(int registeredEventsCount) {
        this.registeredEventsCount = registeredEventsCount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantID=" + participantID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", occupation='" + occupation + '\'' +
                ", company='" + company + '\'' +
                ", registeredEventsCount=" + registeredEventsCount +
                ", notes='" + notes + '\'' +
                '}';
    }
}
