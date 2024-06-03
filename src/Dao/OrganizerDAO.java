package Dao;

import Model.Organizer;
import Utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganizerDAO {

    public void addOrganizer(Organizer organizer) {
        String sql = "INSERT INTO Organizers (Name, Email, Phone, Role, Address, Experience, Notes) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, organizer.getName());
            stmt.setString(2, organizer.getEmail());
            stmt.setString(3, organizer.getPhone());
            stmt.setString(4, organizer.getRole());
            stmt.setString(5, organizer.getAddress());
            stmt.setInt(6, organizer.getExperience());
            stmt.setString(7, organizer.getNotes());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Organizer getOrganizer(int organizerID) {
        String sql = "SELECT * FROM Organizers WHERE OrganizerID = ?";
        Organizer organizer = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, organizerID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                organizer = new Organizer();
                organizer.setOrganizerID(rs.getInt("OrganizerID"));
                organizer.setName(rs.getString("Name"));
                organizer.setEmail(rs.getString("Email"));
                organizer.setPhone(rs.getString("Phone"));
                organizer.setRole(rs.getString("Role"));
                organizer.setAddress(rs.getString("Address"));
                organizer.setExperience(rs.getInt("Experience"));
                organizer.setNotes(rs.getString("Notes"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return organizer;
    }

    public List<Organizer> getAllOrganizers() {
        String sql = "SELECT * FROM Organizers";
        List<Organizer> organizers = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Organizer organizer = new Organizer();
                organizer.setOrganizerID(rs.getInt("OrganizerID"));
                organizer.setName(rs.getString("Name"));
                organizer.setEmail(rs.getString("Email"));
                organizer.setPhone(rs.getString("Phone"));
                organizer.setRole(rs.getString("Role"));
                organizer.setAddress(rs.getString("Address"));
                organizer.setExperience(rs.getInt("Experience"));
                organizer.setNotes(rs.getString("Notes"));
                organizers.add(organizer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return organizers;
    }

    public void updateOrganizer(Organizer organizer) {
        String sql = "UPDATE Organizers SET Name = ?, Email = ?, Phone = ?, Role = ?, Address = ?, Experience = ?, Notes = ? WHERE OrganizerID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, organizer.getName());
            stmt.setString(2, organizer.getEmail());
            stmt.setString(3, organizer.getPhone());
            stmt.setString(4, organizer.getRole());
            stmt.setString(5, organizer.getAddress());
            stmt.setInt(6, organizer.getExperience());
            stmt.setString(7, organizer.getNotes());
            stmt.setInt(8, organizer.getOrganizerID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrganizer(int organizerID) {
        String sql = "DELETE FROM Organizers WHERE OrganizerID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, organizerID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
