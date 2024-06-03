package Dao;

import Model.Participant;
import Utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {

    public void addParticipant(Participant participant) {
        String sql = "INSERT INTO Participants (Name, Email, Phone, Address, DateOfBirth, Gender, Occupation, Company, RegisteredEventsCount, Notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getEmail());
            stmt.setString(3, participant.getPhone());
            stmt.setString(4, participant.getAddress());
            stmt.setDate(5, new java.sql.Date(participant.getDateOfBirth().getTime()));
            stmt.setString(6, participant.getGender());
            stmt.setString(7, participant.getOccupation());
            stmt.setString(8, participant.getCompany());
            stmt.setInt(9, participant.getRegisteredEventsCount());
            stmt.setString(10, participant.getNotes());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Participant getParticipant(int participantID) {
        String sql = "SELECT * FROM Participants WHERE ParticipantID = ?";
        Participant participant = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, participantID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                participant = new Participant();
                participant.setParticipantID(rs.getInt("ParticipantID"));
                participant.setName(rs.getString("Name"));
                participant.setEmail(rs.getString("Email"));
                participant.setPhone(rs.getString("Phone"));
                participant.setAddress(rs.getString("Address"));
                participant.setDateOfBirth(rs.getDate("DateOfBirth"));
                participant.setGender(rs.getString("Gender"));
                participant.setOccupation(rs.getString("Occupation"));
                participant.setCompany(rs.getString("Company"));
                participant.setRegisteredEventsCount(rs.getInt("RegisteredEventsCount"));
                participant.setNotes(rs.getString("Notes"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participant;
    }

    public List<Participant> getAllParticipants() {
        String sql = "SELECT * FROM Participants";
        List<Participant> participants = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Participant participant = new Participant();
                participant.setParticipantID(rs.getInt("ParticipantID"));
                participant.setName(rs.getString("Name"));
                participant.setEmail(rs.getString("Email"));
                participant.setPhone(rs.getString("Phone"));
                participant.setAddress(rs.getString("Address"));
                participant.setDateOfBirth(rs.getDate("DateOfBirth"));
                participant.setGender(rs.getString("Gender"));
                participant.setOccupation(rs.getString("Occupation"));
                participant.setCompany(rs.getString("Company"));
                participant.setRegisteredEventsCount(rs.getInt("RegisteredEventsCount"));
                participant.setNotes(rs.getString("Notes"));
                participants.add(participant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participants;
    }

    public void updateParticipant(Participant participant) {
        String sql = "UPDATE Participants SET Name = ?, Email = ?, Phone = ?, Address = ?, DateOfBirth = ?, Gender = ?, Occupation = ?, Company = ?, RegisteredEventsCount = ?, Notes = ? WHERE ParticipantID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getEmail());
            stmt.setString(3, participant.getPhone());
            stmt.setString(4, participant.getAddress());
            stmt.setDate(5, new java.sql.Date(participant.getDateOfBirth().getTime()));
            stmt.setString(6, participant.getGender());
            stmt.setString(7, participant.getOccupation());
            stmt.setString(8, participant.getCompany());
            stmt.setInt(9, participant.getRegisteredEventsCount());
            stmt.setString(10, participant.getNotes());
            stmt.setInt(11, participant.getParticipantID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteParticipant(int participantID) {
        String sql = "DELETE FROM Participants WHERE ParticipantID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, participantID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
