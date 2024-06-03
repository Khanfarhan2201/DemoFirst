package Service;

import Dao.SponsorshipDAO;
import Model.Sponsorship;

import java.util.List;

public class SponsorshipService {

    private SponsorshipDAO sponsorshipDAO;

    public SponsorshipService() {
        this.sponsorshipDAO = new SponsorshipDAO();
    }

    public void addSponsorship(Sponsorship sponsorship) {
        sponsorshipDAO.addSponsorship(sponsorship);
    }

    public Sponsorship getSponsorship(int sponsorshipID) {
        return sponsorshipDAO.getSponsorship(sponsorshipID);
    }

    public List<Sponsorship> getAllSponsorships() {
        return sponsorshipDAO.getAllSponsorships();
    }

    public void updateSponsorship(Sponsorship sponsorship) {
        sponsorshipDAO.updateSponsorship(sponsorship);
    }

    public void deleteSponsorship(int sponsorshipID) {
        sponsorshipDAO.deleteSponsorship(sponsorshipID);
    }
}
