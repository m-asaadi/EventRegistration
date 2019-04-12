package ca.mcgill.ecse321.eventregistration.dto;

import java.util.ArrayList;
import java.util.List;

public class ParticipantDto {

	private String name;
	private List<EventDto> events;

	public ParticipantDto() {
	}

	public ParticipantDto(String name) {
		this(name, new ArrayList<EventDto>());
	}

	public ParticipantDto(String name, ArrayList<EventDto> arrayList) {
		this.name = name;
		this.events = arrayList;
	}

	public String getName() {
		return name;
	}

	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}
}
