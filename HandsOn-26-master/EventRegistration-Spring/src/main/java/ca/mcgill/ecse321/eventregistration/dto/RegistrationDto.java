package ca.mcgill.ecse321.eventregistration.dto;

public class RegistrationDto {

	private ParticipantDto participant;
	private EventDto event;

	public RegistrationDto() {
	}

	public RegistrationDto(ParticipantDto participant, EventDto event) {
		this.participant = participant;
		this.event = event;
	}

	public ParticipantDto getParticipant() {
		return participant;
	}

	public void setParticipant(ParticipantDto participant) {
		this.participant = participant;
	}

	public EventDto getEvent() {
		return event;
	}

	public void setEvent(EventDto event) {
		this.event = event;
	}
}