package Service;

import Dao.ParticipantDAO;
import Model.Participant;

import java.util.List;

public class ParticipantService {

    private ParticipantDAO participantDAO;

    public ParticipantService() {
        this.participantDAO = new ParticipantDAO();
    }

    public void addParticipant(Participant participant) {
        participantDAO.addParticipant(participant);
    }

    public Participant getParticipant(int participantID) {
        return participantDAO.getParticipant(participantID);
    }

    public List<Participant> getAllParticipants() {
        return participantDAO.getAllParticipants();
    }

    public void updateParticipant(Participant participant) {
        participantDAO.updateParticipant(participant);
    }

    public void deleteParticipant(int participantID) {
        participantDAO.deleteParticipant(participantID);
    }
}
