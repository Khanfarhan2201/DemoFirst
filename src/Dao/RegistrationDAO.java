package Dao;

import Model.Registration;
import Utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {

    public void addRegistration(Registration registration) {
        String sql = "INSERT INTO Registrations (EventID, ParticipantID, RegistrationDate, Status, PaymentStatus, PaymentMethod, Remarks) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registration.getEventID());
            stmt.setInt(2, registration.getParticipantID());
            stmt.setDate(3, new java.sql.Date(registration.getRegistrationDate().getTime()));
            stmt.setString(4, registration.getStatus());
            stmt.setString(5, registration.getPaymentStatus());
            stmt.setString(6, registration.getPaymentMethod());
            stmt.setString(7, registration.getRemarks());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Registration getRegistration(int registrationID) {
        String sql = "SELECT * FROM Registrations WHERE RegistrationID = ?";
        Registration registration = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registrationID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                registration = new Registration();
                registration.setRegistrationID(rs.getInt("RegistrationID"));
                registration.setEventID(rs.getInt("EventID"));
                registration.setParticipantID(rs.getInt("ParticipantID"));
                registration.setRegistrationDate(rs.getDate("RegistrationDate"));
                registration.setStatus(rs.getString("Status"));
                registration.setPaymentStatus(rs.getString("PaymentStatus"));
                registration.setPaymentMethod(rs.getString("PaymentMethod"));
                registration.setRemarks(rs.getString("Remarks"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registration;
    }

    public List<Registration> getAllRegistrations() {
        String sql = "SELECT * FROM Registrations";
        List<Registration> registrations = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Registration registration = new Registration();
                registration.setRegistrationID(rs.getInt("RegistrationID"));
                registration.setEventID(rs.getInt("EventID"));
                registration.setParticipantID(rs.getInt("ParticipantID"));
                registration.setRegistrationDate(rs.getDate("RegistrationDate"));
                registration.setStatus(rs.getString("Status"));
                registration.setPaymentStatus(rs.getString("PaymentStatus"));
                registration.setPaymentMethod(rs.getString("PaymentMethod"));
                registration.setRemarks(rs.getString("Remarks"));
                registrations.add(registration);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrations;
    }

    public void updateRegistration(Registration registration) {
        String sql = "UPDATE Registrations SET EventID = ?, ParticipantID = ?, RegistrationDate = ?, Status = ?, PaymentStatus = ?, PaymentMethod = ?, Remarks = ? WHERE RegistrationID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registration.getEventID());
            stmt.setInt(2, registration.getParticipantID());
            stmt.setDate(3, new java.sql.Date(registration.getRegistrationDate().getTime()));
            stmt.setString(4, registration.getStatus());
            stmt.setString(5, registration.getPaymentStatus());
            stmt.setString(6, registration.getPaymentMethod());
            stmt.setString(7, registration.getRemarks());
            stmt.setInt(8, registration.getRegistrationID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRegistration(int registrationID) {
        String sql = "DELETE FROM Registrations WHERE RegistrationID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registrationID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
