package Model;

import java.util.Date;

public class Event {
    private int eventID;
    private String name;
    private Date startDate;
    private Date endDate;
    private String location;
    private String description;
    private String startTime;
    private String endTime;
    private int capacity;
    private String category;
    private String status;
    private int organizerID;

    public Event() {
        // Default constructor
    }

    public Event(int eventID, String name, Date startDate, Date endDate, String location, String description, String startTime, String endTime, int capacity, String category, String status, int organizerID) {
        this.eventID = eventID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate != null ? endDate : startDate; // Default endDate to startDate if null
        this.location = location != null && !location.isEmpty() ? location : "Unknown Location"; // Set default location if null or empty
        this.description = description;
        this.startTime = startTime != null && !startTime.isEmpty() ? startTime : null;
        this.endTime = endTime != null && !endTime.isEmpty() ? endTime : null;
        this.capacity = capacity;
        this.category = category;
        this.status = status;
        this.organizerID = organizerID;
    }





    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", organizerID=" + organizerID +
                '}';
    }
}
