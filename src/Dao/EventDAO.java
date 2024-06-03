package Dao;

import Model.Event;
import Utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public void addEvent(Event event) {
        String sql = "INSERT INTO Events (Name, StartDate, EndDate, Location, Description, StartTime, EndTime, Capacity, Category, Status, OrganizerID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, event.getName());
            stmt.setDate(2, new java.sql.Date(event.getStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date(event.getEndDate().getTime()));
            stmt.setString(4, event.getLocation());
            stmt.setString(5, event.getDescription());
            stmt.setTime(6, event.getStartTime() != null ? Time.valueOf(event.getStartTime()) : null);
            stmt.setTime(7, event.getEndTime() != null ? Time.valueOf(event.getEndTime()) : null);
            stmt.setInt(8, event.getCapacity());
            stmt.setString(9, event.getCategory());
            stmt.setString(10, event.getStatus());
            stmt.setInt(11, event.getOrganizerID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Event getEvent(int eventID) {
        String sql = "SELECT * FROM Events WHERE EventID = ?";
        Event event = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eventID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                event = new Event();
                event.setEventID(rs.getInt("EventID"));
                event.setName(rs.getString("Name"));
                event.setStartDate(rs.getDate("StartDate"));
                event.setEndDate(rs.getDate("EndDate"));
                event.setLocation(rs.getString("Location"));
                event.setDescription(rs.getString("Description"));
                Time startTime = rs.getTime("StartTime");
                event.setStartTime(startTime != null ? startTime.toString() : null);
                Time endTime = rs.getTime("EndTime");
                event.setEndTime(endTime != null ? endTime.toString() : null);
                event.setCapacity(rs.getInt("Capacity"));
                event.setCategory(rs.getString("Category"));
                event.setStatus(rs.getString("Status"));
                event.setOrganizerID(rs.getInt("OrganizerID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return event;
    }

    public List<Event> getAllEvents() {
        String sql = "SELECT * FROM Events";
        List<Event> events = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Event event = new Event();
                event.setEventID(rs.getInt("EventID"));
                event.setName(rs.getString("Name"));
                event.setStartDate(rs.getDate("StartDate"));
                event.setEndDate(rs.getDate("EndDate"));
                event.setLocation(rs.getString("Location"));
                event.setDescription(rs.getString("Description"));
                Time startTime = rs.getTime("StartTime");
                event.setStartTime(startTime != null ? startTime.toString() : null);
                Time endTime = rs.getTime("EndTime");
                event.setEndTime(endTime != null ? endTime.toString() : null);
                event.setCapacity(rs.getInt("Capacity"));
                event.setCategory(rs.getString("Category"));
                event.setStatus(rs.getString("Status"));
                event.setOrganizerID(rs.getInt("OrganizerID"));
                events.add(event);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public void updateEvent(Event event) {
        String sql = "UPDATE Events SET Name = ?, StartDate = ?, EndDate = ?, Location = ?, Description = ?, StartTime = ?, EndTime = ?, Capacity = ?, Category = ?, Status = ?, OrganizerID = ? WHERE EventID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, event.getName());
            stmt.setDate(2, new java.sql.Date(event.getStartDate().getTime()));
            stmt.setDate(3, new java.sql.Date(event.getEndDate().getTime()));
            stmt.setString(4, event.getLocation());
            stmt.setString(5, event.getDescription());
            stmt.setTime(6, event.getStartTime() != null ? Time.valueOf(event.getStartTime()) : null);
            stmt.setTime(7, event.getEndTime() != null ? Time.valueOf(event.getEndTime()) : null);
            stmt.setInt(8, event.getCapacity());
            stmt.setString(9, event.getCategory());
            stmt.setString(10, event.getStatus());
            stmt.setInt(11, event.getOrganizerID());
            stmt.setInt(12, event.getEventID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int eventID) {
        String sql = "DELETE FROM Events WHERE EventID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eventID);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
