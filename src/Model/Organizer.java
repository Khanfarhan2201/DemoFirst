package Model;

public class Organizer {
    private int organizerID;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String address;
    private int experience;
    private String notes;

    public Organizer() {
        // Default constructor
    }

    public Organizer(int organizerID, String name, String email, String phone, String role, String address, int experience, String notes) {
        this.organizerID = organizerID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.experience = experience;
        this.notes = notes;
    }

    public int getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(int organizerID) {
        this.organizerID = organizerID;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "organizerID=" + organizerID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                ", experience=" + experience +
                ", notes='" + notes + '\'' +
                '}';
    }
}
