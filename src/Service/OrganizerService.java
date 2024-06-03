package Service;

import Dao.OrganizerDAO;
import Model.Organizer;

import java.util.List;

public class OrganizerService {

    private OrganizerDAO organizerDAO;

    public OrganizerService() {
        this.organizerDAO = new OrganizerDAO();
    }

    public void addOrganizer(Organizer organizer) {
        organizerDAO.addOrganizer(organizer);
    }

    public Organizer getOrganizer(int organizerID) {
        return organizerDAO.getOrganizer(organizerID);
    }

    public List<Organizer> getAllOrganizers() {
        return organizerDAO.getAllOrganizers();
    }

    public void updateOrganizer(Organizer organizer) {
        organizerDAO.updateOrganizer(organizer);
    }

    public void deleteOrganizer(int organizerID) {
        organizerDAO.deleteOrganizer(organizerID);
    }
}
