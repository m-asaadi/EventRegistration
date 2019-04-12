/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-f40f105-3613 modeling language!*/

package ca.mcgill.ecse321.eventregistration.model;

// line 16 "../../../../../EventRegistration.ump"
// line 40 "../../../../../EventRegistration.ump"
public class Registration
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int id;

  //Registration Associations
  private Participant participant;
  private Event event;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Registration(Participant aParticipant, Event aEvent)
  {
    id = nextId++;
    if (!setParticipant(aParticipant))
    {
      throw new RuntimeException("Unable to create Registration due to aParticipant");
    }
    if (!setEvent(aEvent))
    {
      throw new RuntimeException("Unable to create Registration due to aEvent");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getId()
  {
    return id;
  }

  public Participant getParticipant()
  {
    return participant;
  }

  public Event getEvent()
  {
    return event;
  }

  public boolean setParticipant(Participant aNewParticipant)
  {
    boolean wasSet = false;
    if (aNewParticipant != null)
    {
      participant = aNewParticipant;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setEvent(Event aNewEvent)
  {
    boolean wasSet = false;
    if (aNewEvent != null)
    {
      event = aNewEvent;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    participant = null;
    event = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "participant = "+(getParticipant()!=null?Integer.toHexString(System.identityHashCode(getParticipant())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null");
  }
}