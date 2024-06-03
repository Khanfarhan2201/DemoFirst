package Service;

import Dao.EventDAO;
import Model.Event;
import Dao.EventDAO;
import Dao.SponsorshipDAO;
import java.util.List;

public class EventService {

    private EventDAO eventDAO;
    private SponsorshipDAO sponsorshipDAO;
    public EventService() {

        this.eventDAO = new EventDAO();
        this.sponsorshipDAO = new SponsorshipDAO();
    }

    public void addEvent(Event event) {
        eventDAO.addEvent(event);
    }

    public Event getEvent(int eventID) {
        return eventDAO.getEvent(eventID);
    }

    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    public void updateEvent(Event event) {
        eventDAO.updateEvent(event);
    }

    // In EventService
    public void deleteEvent(int eventID) {
        // First delete related sponsorships
        sponsorshipDAO.deleteSponsorshipsByEventID(eventID);
        // Then delete the event
        eventDAO.deleteEvent(eventID);
    }

}
