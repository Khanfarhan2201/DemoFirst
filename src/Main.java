import Model.Event;
import Model.Participant;
import Model.Organizer;
import Model.Sponsorship;
import Service.*;
import  Model.Registration;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();
        OrganizerService organizerService = new OrganizerService();
        RegistrationService registrationService = new RegistrationService();
        SponsorshipService sponsorshipService = new SponsorshipService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("Event Management System");
            System.out.println("1. Events");
            System.out.println("2. Participants");
            System.out.println("3. Organizers");
            System.out.println("4. Sponsors");
            System.out.println("5. Registration");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    eventSubMenu(scanner, eventService, sdf);
                    break;
                case 2:
                    participantSubMenu(scanner, participantService, sdf);
                    break;
                case 3:
                    organizerSubMenu(scanner, organizerService);
                    break;
                case 4:
                    sponsorSubMenu(scanner, sponsorshipService);
                    break;

                case 6:

                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void eventSubMenu(Scanner scanner, EventService eventService, SimpleDateFormat sdf) {
        while (true) {
            System.out.println("\nEvents Menu");
            System.out.println("1. Add Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. View All Events");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    addEvent(scanner, eventService, sdf);
                    break;
                case 2:
                    // Implement update event logic
                    updateEvent(scanner, eventService, sdf);
                    break;
                case 3:
                    deleteEvent(scanner, eventService);
                    break;
                case 4:
                    viewAllEvents(eventService);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEvent(Scanner scanner, EventService eventService, SimpleDateFormat sdf) {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        System.out.print("Enter event date Start (yyyy-MM-dd): ");
        String eventDateStr = scanner.nextLine();
        Date eventDate;
        try {
            eventDate = sdf.parse(eventDateStr);
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please use the correct format (yyyy-MM-dd).");
            return;
        }

        // Gather other event details
        System.out.print("Enter event location: ");
        String location = scanner.nextLine();

        System.out.print("Enter event description: ");
        String description = scanner.nextLine();

        System.out.print("Enter event start time (HH:mm:ss): ");
        String startTime = scanner.nextLine();

        System.out.print("Enter event end time (HH:mm:ss): ");
        String endTime = scanner.nextLine();

        System.out.print("Enter event capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.print("Enter event category: ");
        String category = scanner.nextLine();

        System.out.print("Enter event status: ");
        String status = scanner.nextLine();

        System.out.print("Enter organizer ID: ");
        int organizerID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        // Create the Event object
        Event event = new Event(0, eventName, eventDate, null, location, description, startTime, endTime, capacity, category, status, organizerID);

        eventService.addEvent(event);
        System.out.println("Event added successfully!");
    }

    private static void updateEvent(Scanner scanner, EventService eventService, SimpleDateFormat sdf) {
        System.out.print("Enter event ID to update: ");
        int eventID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Event event = eventService.getEvent(eventID);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter new event name: ");
        String eventName = scanner.nextLine();
        event.setName(eventName);

        System.out.print("Enter new event date (yyyy-MM-dd): ");
        String eventDateStr = scanner.nextLine();
        Date eventDate;
        try {
            eventDate = sdf.parse(eventDateStr);
            event.setStartDate(eventDate);
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please use the correct format (yyyy-MM-dd).");
            return;
        }
        System.out.println("Enter New Event Location: ");
        String location = scanner.nextLine();
        event.setLocation(location);

        System.out.println("Enter New Event Status");

        String status = scanner.nextLine();
        event.setStatus(status);

        // Similarly, gather other event details to update from the user

        eventService.updateEvent(event);
        System.out.println("Event updated successfully!");
    }

    private static void deleteEvent(Scanner scanner, EventService eventService) {
        System.out.print("Enter event ID to delete: ");
        int eventID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        eventService.deleteEvent(eventID);
        System.out.println("Event deleted successfully!");
    }

    private static void viewAllEvents(EventService eventService) {
        List<Event> events = eventService.getAllEvents();
        System.out.println("Events:");
        for (Event e : events) {
            System.out.println(e);
        }
    }

    private static void participantSubMenu(Scanner scanner, ParticipantService participantService, SimpleDateFormat sdf) {
        while (true) {
            System.out.println("\nParticipants Menu");
            System.out.println("1. Add Participant");
            System.out.println("2. Update Participant");
            System.out.println("3. Delete Participant");
            System.out.println("4. View All Participant");
            System.out.println("5. View Participants By Id");
            System.out.println("6. Back to Main Menu");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addParticipant(scanner, participantService, sdf);
                    break;
                case 2:
                    updateParticipant(scanner, participantService, sdf);
                    break;
                case 3:
                    deleteParticipant(scanner, participantService);
                    break;
                case 4:
                    viewAllParticipants(participantService);
                    break;
                case 5:
                    viewParticipantByID(scanner, participantService);
                    break;
                    case 6:
                        return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            // Implement the submenu for participants
        }
    }

    private static void addParticipant(Scanner scanner, ParticipantService participantService, SimpleDateFormat sdf ) {
        System.out.print("Enter participant name: ");
        String name = scanner.nextLine();

        System.out.print("Enter participant email: ");
        String email = scanner.nextLine();

        System.out.print("Enter participant phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter participant address: ");
        String address = scanner.nextLine();

        System.out.println("Enter Date of Birth (yyyy-MM-dd): ");
        Date dateOfBirth = null;
        try {
            String dobStr = scanner.nextLine();
            dateOfBirth = sdf.parse(dobStr);
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please use the correct format (yyyy-MM-dd).");
            // Handle the error as needed
        }

        System.out.println("Enter Gender");
        String Gender = scanner.nextLine();

        System.out.println("Enter Occupation");
        String Occupation = scanner.nextLine();

        System.out.println("Enter company of the Participant");
        String Company = scanner.nextLine();

        System.out.println("Enter RegisteredEventsCount");
        int RegisteredEventsCount = scanner.nextInt();

        System.out.println("Write something about Participant");
        String Notes = scanner.nextLine();
        // Create the Participant object
        Participant participant = new Participant(0, name, email, phoneNumber, address, dateOfBirth, Gender, Occupation, Company, RegisteredEventsCount, Notes);

        participantService.addParticipant(participant);
        System.out.println("Participant added successfully!");
    }
    private static void updateParticipant(Scanner scanner, ParticipantService participantService, SimpleDateFormat sdf) {
        System.out.print("Enter participant ID to update: ");
        int participantID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Participant participant = participantService.getParticipant(participantID);
        if (participant == null) {
            System.out.println("Participant not found.");
            return;
        }

        System.out.print("Enter new participant name: ");
        String name = scanner.nextLine();
        participant.setName(name);

        System.out.print("Enter new participant email: ");
        String email = scanner.nextLine();
        participant.setEmail(email);

        System.out.print("Enter new participant phone number: ");
        String phoneNumber = scanner.nextLine();
        participant.setPhone(phoneNumber);

        System.out.print("Enter new participant address: ");
        String address = scanner.nextLine();
        participant.setAddress(address);

        System.out.print("Enter new Date of Birth (yyyy-MM-dd) or leave blank to keep current: ");
        String dobStr = scanner.nextLine();
        if (!dobStr.isEmpty()) {
            try {
                Date dateOfBirth = sdf.parse(dobStr);
                participant.setDateOfBirth(dateOfBirth);
            } catch (ParseException e) {
                System.out.println("Error parsing date. Please use the correct format (yyyy-MM-dd).");
                return;
            }
        }

        System.out.print("Enter new gender: ");
        String gender = scanner.nextLine();
        participant.setGender(gender);

        System.out.print("Enter new occupation: ");
        String occupation = scanner.nextLine();
        participant.setOccupation(occupation);

        System.out.print("Enter new company: ");
        String company = scanner.nextLine();
        participant.setCompany(company);

        System.out.print("Enter new registered events count: ");
        int registeredEventsCount = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        participant.setRegisteredEventsCount(registeredEventsCount);

        System.out.print("Enter new notes: ");
        String notes = scanner.nextLine();
        participant.setNotes(notes);

        participantService.updateParticipant(participant);
        System.out.println("Participant updated successfully!");
    }

    private static void viewAllParticipants(ParticipantService participantService) {
        List<Participant> participants = participantService.getAllParticipants();
        System.out.println("Participants:");
        for (Participant p : participants) {
            System.out.println(p);
        }
    }

    private static void viewParticipantByID(Scanner scanner, ParticipantService participantService) {
        System.out.print("Enter participant ID: ");
        int participantID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Participant participant = participantService.getParticipant(participantID);
        if (participant == null) {
            System.out.println("Participant not found.");
        } else {
            System.out.println(participant);
        }
    }

    private static void deleteParticipant(Scanner scanner, ParticipantService participantService) {
        System.out.print("Enter participant ID to delete: ");
        int participantID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        participantService.deleteParticipant(participantID);
        System.out.println("Participant deleted successfully!");
    }


    private static void organizerSubMenu(Scanner scanner, OrganizerService organizerService) {
        while (true) {
            System.out.println("\nOrganizers Menu");
            System.out.println("1. Add Organizer");
            System.out.println("2. Update Organizer");
            System.out.println("3. Delete Organizer");
            System.out.println("4. View All Organizers");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    addOrganizer(scanner, organizerService);
                    break;
                case 2:
                    // Implement update organizer logic
                    updateOrganizer(scanner, organizerService);
                    break;
                case 3:
                    // Implement delete organizer logic
                    deleteOrganizer(scanner, organizerService);

                    break;
                case 4:
                    // Implement view all organizers logic
                    viewAllOrganizers(organizerService);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addOrganizer(Scanner scanner, OrganizerService organizerService) {
        System.out.print("Enter organizer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter organizer email: ");
        String email = scanner.nextLine();

        System.out.print("Enter organizer phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter organizer role: ");
        String role = scanner.nextLine();

        System.out.print("Enter organizer address: ");
        String address = scanner.nextLine();

        System.out.print("Enter organizer experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.print("Enter organizer notes: ");
        String notes = scanner.nextLine();

        Organizer organizer = new Organizer(0, name, email, phone, role, address, experience, notes);
        organizerService.addOrganizer(organizer);
        System.out.println("Organizer added successfully!");
    }
    private static void updateOrganizer(Scanner scanner, OrganizerService organizerService) {
        System.out.print("Enter organizer ID to update: ");
        int organizerID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Organizer organizer = organizerService.getOrganizer(organizerID);
        if (organizer == null) {
            System.out.println("Organizer not found.");
            return;
        }

        System.out.print("Enter new organizer name: ");
        String name = scanner.nextLine();
        organizer.setName(name);

        System.out.print("Enter new organizer email: ");
        String email = scanner.nextLine();
        organizer.setEmail(email);


        System.out.println("Enter new organizer phone number: ");
        String phone = scanner.nextLine();
        organizer.setPhone(phone);

        System.out.println("Enter New Role");
        String role = scanner.nextLine();
        organizer.setRole(role);

        System.out.println("Enter new organizer address: ");
        String address = scanner.nextLine();
        organizer.setAddress(address);

        System.out.println("Enter new organizer experience: ");
        int experience = scanner.nextInt();
        organizer.setExperience(experience);

        // Similarly, gather other organizer details to update from the user

        organizerService.updateOrganizer(organizer);
        System.out.println("Organizer updated successfully!");
    }

    private static void deleteOrganizer(Scanner scanner, OrganizerService organizerService) {
        System.out.print("Enter organizer ID to delete: ");
        int organizerID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        organizerService.deleteOrganizer(organizerID);
        System.out.println("Organizer deleted successfully!");
    }

    private static void viewAllOrganizers(OrganizerService organizerService) {
        List<Organizer> organizers = organizerService.getAllOrganizers();
        System.out.println("Organizers:");
        for (Organizer organizer : organizers) {
            System.out.println(organizer);
        }
    }

    private static void sponsorSubMenu(Scanner scanner, SponsorshipService sponsorshipService) {
        while (true) {
            System.out.println("\nSponsors Menu");
            System.out.println("1. Add Sponsorship");
            System.out.println("2. Update Sponsorship");
            System.out.println("3. Delete Sponsorship");
            System.out.println("4. View All Sponsorships");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    addSponsorship(scanner, sponsorshipService);
                    break;
                case 2:
                    updateSponsorship(scanner, sponsorshipService);
                    break;
                case 3:
                    deleteSponsorship(scanner, sponsorshipService);
                    break;
                case 4:
                    viewAllSponsorships(sponsorshipService);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSponsorship(Scanner scanner, SponsorshipService sponsorshipService) {
        System.out.print("Enter event ID: ");
        int eventID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.print("Enter sponsor name: ");
        String sponsorName = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume the newline

        System.out.print("Enter contact person: ");
        String contactPerson = scanner.nextLine();

        System.out.print("Enter contact email: ");
        String contactEmail = scanner.nextLine();

        System.out.print("Enter contact phone: ");
        String contactPhone = scanner.nextLine();

        System.out.print("Enter sponsorship type: ");
        String sponsorshipType = scanner.nextLine();

        System.out.print("Enter sponsorship details: ");
        String sponsorshipDetails = scanner.nextLine();

        System.out.print("Enter sponsor logo: ");
        String sponsorLogo = scanner.nextLine();

        // Create a new Sponsorship object
        Sponsorship sponsorship = new Sponsorship(0, eventID, sponsorName, amount, contactPerson, contactEmail, contactPhone, sponsorshipType, sponsorshipDetails, sponsorLogo);

        // Add the sponsorship using the SponsorshipService
        sponsorshipService.addSponsorship(sponsorship);
        System.out.println("Sponsorship added successfully!");
    }


    private static void updateSponsorship(Scanner scanner, SponsorshipService sponsorshipService) {
        System.out.print("Enter sponsorship ID to update: ");
        int sponsorshipID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Sponsorship sponsorship = sponsorshipService.getSponsorship(sponsorshipID);
        if (sponsorship == null) {
            System.out.println("Sponsorship not found.");
            return;
        }

        System.out.print("Enter new event ID: ");
        int eventID = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        sponsorship.setEventID(eventID);

        System.out.print("Enter new sponsor name: ");
        String sponsorName = scanner.nextLine();
        sponsorship.setSponsorName(sponsorName);

        System.out.print("Enter new amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume the newline
        sponsorship.setAmount(amount);

        System.out.print("Enter new contact person: ");
        String contactPerson = scanner.nextLine();
        sponsorship.setContactPerson(contactPerson);

        System.out.print("Enter new contact email: ");
        String contactEmail = scanner.nextLine();
        sponsorship.setContactEmail(contactEmail);

        System.out.print("Enter new contact phone: ");
        String contactPhone = scanner.nextLine();
        sponsorship.setContactPhone(contactPhone);

        System.out.print("Enter new sponsorship type: ");
        String sponsorshipType = scanner.nextLine();
        sponsorship.setSponsorshipType(sponsorshipType);

        System.out.print("Enter new sponsorship details: ");
        String sponsorshipDetails = scanner.nextLine();
        sponsorship.setSponsorshipDetails(sponsorshipDetails);

        System.out.print("Enter new sponsor logo: ");
        String sponsorLogo = scanner.nextLine();
        sponsorship.setSponsorLogo(sponsorLogo);

        sponsorshipService.updateSponsorship(sponsorship);
        System.out.println("Sponsorship updated successfully!");
    }


    private static void deleteSponsorship(Scanner scanner, SponsorshipService sponsorshipService) {
        System.out.print("Enter sponsorship ID to delete: ");
        int sponsorshipID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        sponsorshipService.deleteSponsorship(sponsorshipID);
        System.out.println("Sponsorship deleted successfully!");
    }


    private static void viewAllSponsorships(SponsorshipService sponsorshipService) {
        List<Sponsorship> sponsorships = sponsorshipService.getAllSponsorships();
        System.out.println("Sponsorships:");
        for (Sponsorship sponsorship : sponsorships) {
            System.out.println(sponsorship);
        }
    }


}
