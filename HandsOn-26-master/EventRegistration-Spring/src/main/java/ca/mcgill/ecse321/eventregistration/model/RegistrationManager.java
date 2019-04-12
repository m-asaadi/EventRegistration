/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-f40f105-3613 modeling language!*/

package ca.mcgill.ecse321.eventregistration.model;
import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 23 "../../../../../EventRegistration.ump"
// line 45 "../../../../../EventRegistration.ump"
public class RegistrationManager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegistrationManager Associations
  private List<Registration> registrations;
  private List<Participant> participants;
  private List<Event> events;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegistrationManager()
  {
    registrations = new ArrayList<Registration>();
    participants = new ArrayList<Participant>();
    events = new ArrayList<Event>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Registration getRegistration(int index)
  {
    Registration aRegistration = registrations.get(index);
    return aRegistration;
  }

  public List<Registration> getRegistrations()
  {
    List<Registration> newRegistrations = Collections.unmodifiableList(registrations);
    return newRegistrations;
  }

  public int numberOfRegistrations()
  {
    int number = registrations.size();
    return number;
  }

  public boolean hasRegistrations()
  {
    boolean has = registrations.size() > 0;
    return has;
  }

  public int indexOfRegistration(Registration aRegistration)
  {
    int index = registrations.indexOf(aRegistration);
    return index;
  }

  public Participant getParticipant(int index)
  {
    Participant aParticipant = participants.get(index);
    return aParticipant;
  }

  public List<Participant> getParticipants()
  {
    List<Participant> newParticipants = Collections.unmodifiableList(participants);
    return newParticipants;
  }

  public int numberOfParticipants()
  {
    int number = participants.size();
    return number;
  }

  public boolean hasParticipants()
  {
    boolean has = participants.size() > 0;
    return has;
  }

  public int indexOfParticipant(Participant aParticipant)
  {
    int index = participants.indexOf(aParticipant);
    return index;
  }

  public Event getEvent(int index)
  {
    Event aEvent = events.get(index);
    return aEvent;
  }

  public List<Event> getEvents()
  {
    List<Event> newEvents = Collections.unmodifiableList(events);
    return newEvents;
  }

  public int numberOfEvents()
  {
    int number = events.size();
    return number;
  }

  public boolean hasEvents()
  {
    boolean has = events.size() > 0;
    return has;
  }

  public int indexOfEvent(Event aEvent)
  {
    int index = events.indexOf(aEvent);
    return index;
  }

  public static int minimumNumberOfRegistrations()
  {
    return 0;
  }

  public boolean addRegistration(Registration aRegistration)
  {
    boolean wasAdded = false;
    if (registrations.contains(aRegistration)) { return false; }
    registrations.add(aRegistration);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRegistration(Registration aRegistration)
  {
    boolean wasRemoved = false;
    if (registrations.contains(aRegistration))
    {
      registrations.remove(aRegistration);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRegistrationAt(Registration aRegistration, int index)
  {  
    boolean wasAdded = false;
    if(addRegistration(aRegistration))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegistrations()) { index = numberOfRegistrations() - 1; }
      registrations.remove(aRegistration);
      registrations.add(index, aRegistration);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRegistrationAt(Registration aRegistration, int index)
  {
    boolean wasAdded = false;
    if(registrations.contains(aRegistration))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegistrations()) { index = numberOfRegistrations() - 1; }
      registrations.remove(aRegistration);
      registrations.add(index, aRegistration);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRegistrationAt(aRegistration, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfParticipants()
  {
    return 0;
  }

  public boolean addParticipant(Participant aParticipant)
  {
    boolean wasAdded = false;
    if (participants.contains(aParticipant)) { return false; }
    participants.add(aParticipant);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeParticipant(Participant aParticipant)
  {
    boolean wasRemoved = false;
    if (participants.contains(aParticipant))
    {
      participants.remove(aParticipant);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addParticipantAt(Participant aParticipant, int index)
  {  
    boolean wasAdded = false;
    if(addParticipant(aParticipant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParticipants()) { index = numberOfParticipants() - 1; }
      participants.remove(aParticipant);
      participants.add(index, aParticipant);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveParticipantAt(Participant aParticipant, int index)
  {
    boolean wasAdded = false;
    if(participants.contains(aParticipant))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfParticipants()) { index = numberOfParticipants() - 1; }
      participants.remove(aParticipant);
      participants.add(index, aParticipant);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addParticipantAt(aParticipant, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfEvents()
  {
    return 0;
  }

  public boolean addEvent(Event aEvent)
  {
    boolean wasAdded = false;
    if (events.contains(aEvent)) { return false; }
    events.add(aEvent);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEvent(Event aEvent)
  {
    boolean wasRemoved = false;
    if (events.contains(aEvent))
    {
      events.remove(aEvent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addEventAt(Event aEvent, int index)
  {  
    boolean wasAdded = false;
    if(addEvent(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEventAt(Event aEvent, int index)
  {
    boolean wasAdded = false;
    if(events.contains(aEvent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEvents()) { index = numberOfEvents() - 1; }
      events.remove(aEvent);
      events.add(index, aEvent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEventAt(aEvent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    registrations.clear();
    participants.clear();
    events.clear();
  }

}