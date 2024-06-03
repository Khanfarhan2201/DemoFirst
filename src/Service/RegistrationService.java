package Service;

import Dao.RegistrationDAO;
import Model.Registration;

import java.util.List;

public class RegistrationService {

    private RegistrationDAO registrationDAO;

    public RegistrationService() {
        this.registrationDAO = new RegistrationDAO();
    }

    public void addRegistration(Registration registration) {
        registrationDAO.addRegistration(registration);
    }

    public Registration getRegistration(int registrationID) {
        return registrationDAO.getRegistration(registrationID);
    }

    public List<Registration> getAllRegistrations() {
        return registrationDAO.getAllRegistrations();
    }

    public void updateRegistration(Registration registration) {
        registrationDAO.updateRegistration(registration);
    }

    public void deleteRegistration(int registrationID) {
        registrationDAO.deleteRegistration(registrationID);
    }
}
