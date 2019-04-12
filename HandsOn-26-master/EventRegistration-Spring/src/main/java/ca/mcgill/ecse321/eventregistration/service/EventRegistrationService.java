package ca.mcgill.ecse321.eventregistration.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import ca.mcgill.ecse321.eventregistration.model.Event;
import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.model.Registration;
import ca.mcgill.ecse321.eventregistration.model.RegistrationManager;
import ca.mcgill.ecse321.eventregistration.persistence.PersistenceXStream;

@Service
public class EventRegistrationService {

	private RegistrationManager rm;

	public EventRegistrationService(RegistrationManager rm) {
		this.rm = rm;
	}

	public Participant createParticipant(String name) throws InvalidInputException {
		if (name == null || name.trim().length() == 0) {
			throw new InvalidInputException("Participant name cannot be empty!");
		}
		Participant p = new Participant(name);
		rm.addParticipant(p);
		PersistenceXStream.saveToXMLwithXStream(rm);
		return p;
	}

	public List<Participant> findAllParticipants() {
		return rm.getParticipants();
	}

	public List<Event> findAllEvents() {
		return rm.getEvents();
	}

	public List<Event> getEventsForParticipant(Participant p) {
		List<Event> events = Lists.newArrayList();
		List<Registration> allRegistrations = rm.getRegistrations();
		for (Registration registration : allRegistrations) {
			if (registration.getParticipant().equals(p)) {
				events.add(registration.getEvent());
			}
		}
		return events;
	}

	public Event createEvent(String name, Date date, Time startTime, Time endTime) throws InvalidInputException {
		if (date == null || name == null || startTime == null || endTime == null) {
			throw new InvalidInputException(
					"Event name cannot be empty! Event date cannot be empty! Event start time cannot be empty! Event end time cannot be empty!");
		}
		if (name.equals("") || name.trim().length() == 0) {
			throw new InvalidInputException("Event name cannot be empty!");
		}

		if (endTime.before(startTime)) {
			throw new InvalidInputException("Event end time cannot be before event start time!");
		}
		Event e = new Event(name, date, startTime, endTime);
		rm.addEvent(e);
		PersistenceXStream.saveToXMLwithXStream(rm);
		return e;
	}

	public Registration register(Participant participant, Event event) throws InvalidInputException {

		if ((participant == null) || (event == null)) {
			throw new InvalidInputException(
					"Participant needs to be selected for registration! Event needs to be selected for registration!");
		}

		if (verify(participant, event) == 1) {
			throw new InvalidInputException("Participant does not exist! Event does not exist!");

		}

		Registration reg = new Registration(participant, event);
		rm.addRegistration(reg);
		PersistenceXStream.saveToXMLwithXStream(rm);
		return reg;
	}

	public int verify(Participant person, Event event) {
		List<Participant> per = this.rm.getParticipants();
		List<Event> eve = this.rm.getEvents();

		for (Participant p : per) {
			if (p.equals(person)) {
				return 0;
			}
		}
		for (Event e : eve) {
			if (e.equals(event)) {
				return 0;
			}
		}
		return 1;
	}

	public Participant getParticipantByName(String name) throws InvalidInputException {
		List<Participant> per = this.rm.getParticipants();
		Participant participant = null;
		for (Participant par : per) {
			if (par.getName().equals(name)) {
				participant = par;

			}
		}

		if (participant == null) {
			throw new InvalidInputException("Participant does not exist");
		} else {
			return participant;
		}
	}
	
	public Event getEventByName(String name) throws InvalidInputException {
		List<Event> eve = this.rm.getEvents();
		Event event = null;
		for (Event ev : eve) {
			if (ev.getName().equals(name)) {
				event= ev;

			}
		}

		if (event == null) {
		throw new InvalidInputException("Event does not exist");
		} else {
			return event;
		} 
		}

}
