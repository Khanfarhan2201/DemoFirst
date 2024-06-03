package Dao;

import Model.Sponsorship;
import Utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SponsorshipDAO {

    public void addSponsorship(Sponsorship sponsorship) {
        String sql = "INSERT INTO Sponsorships (EventID, SponsorName, Amount, ContactPerson, ContactEmail, ContactPhone, SponsorshipType, SponsorshipDetails, SponsorLogo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sponsorship.getEventID());
            stmt.setString(2, sponsorship.getSponsorName());
            stmt.setDouble(3, sponsorship.getAmount());
            stmt.setString(4, sponsorship.getContactPerson());
            stmt.setString(5, sponsorship.getContactEmail());
            stmt.setString(6, sponsorship.getContactPhone());
            stmt.setString(7, sponsorship.getSponsorshipType());
            stmt.setString(8, sponsorship.getSponsorshipDetails());
            stmt.setString(9, sponsorship.getSponsorLogo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Sponsorship getSponsorship(int sponsorshipID) {
        String sql = "SELECT * FROM Sponsorships WHERE SponsorshipID = ?";
        Sponsorship sponsorship = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sponsorshipID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sponsorship = new Sponsorship();
                sponsorship.setSponsorshipID(rs.getInt("SponsorshipID"));
                sponsorship.setEventID(rs.getInt("EventID"));
                sponsorship.setSponsorName(rs.getString("SponsorName"));
                sponsorship.setAmount(rs.getDouble("Amount"));
                sponsorship.setContactPerson(rs.getString("ContactPerson"));
                sponsorship.setContactEmail(rs.getString("ContactEmail"));
                sponsorship.setContactPhone(rs.getString("ContactPhone"));
                sponsorship.setSponsorshipType(rs.getString("SponsorshipType"));
                sponsorship.setSponsorshipDetails(rs.getString("SponsorshipDetails"));
                sponsorship.setSponsorLogo(rs.getString("SponsorLogo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sponsorship;
    }

    public List<Sponsorship> getAllSponsorships() {
        String sql = "SELECT * FROM Sponsorships";
        List<Sponsorship> sponsorships = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Sponsorship sponsorship = new Sponsorship();
                sponsorship.setSponsorshipID(rs.getInt("SponsorshipID"));
                sponsorship.setEventID(rs.getInt("EventID"));
                sponsorship.setSponsorName(rs.getString("SponsorName"));
                sponsorship.setAmount(rs.getDouble("Amount"));
                sponsorship.setContactPerson(rs.getString("ContactPerson"));
                sponsorship.setContactEmail(rs.getString("ContactEmail"));
                sponsorship.setContactPhone(rs.getString("ContactPhone"));
                sponsorship.setSponsorshipType(rs.getString("SponsorshipType"));
                sponsorship.setSponsorshipDetails(rs.getString("SponsorshipDetails"));
                sponsorship.setSponsorLogo(rs.getString("SponsorLogo"));
                sponsorships.add(sponsorship);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sponsorships;
    }

    public void updateSponsorship(Sponsorship sponsorship) {
        String sql = "UPDATE Sponsorships SET EventID = ?, SponsorName = ?, Amount = ?, ContactPerson = ?, ContactEmail = ?, ContactPhone = ?, SponsorshipType = ?, SponsorshipDetails = ?, SponsorLogo = ? WHERE SponsorshipID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sponsorship.getEventID());
            stmt.setString(2, sponsorship.getSponsorName());
            stmt.setDouble(3, sponsorship.getAmount());
            stmt.setString(4, sponsorship.getContactPerson());
            stmt.setString(5, sponsorship.getContactEmail());
            stmt.setString(6, sponsorship.getContactPhone());
            stmt.setString(7, sponsorship.getSponsorshipType());
            stmt.setString(8, sponsorship.getSponsorshipDetails());
            stmt.setString(9, sponsorship.getSponsorLogo());
            stmt.setInt(10, sponsorship.getSponsorshipID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSponsorship(int sponsorshipID) {
        String sql = "DELETE FROM Sponsorships WHERE SponsorshipID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, sponsorshipID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // New method to delete sponsorships by EventID
    public void deleteSponsorshipsByEventID(int eventID) {
        String sql = "DELETE FROM Sponsorships WHERE EventID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eventID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
