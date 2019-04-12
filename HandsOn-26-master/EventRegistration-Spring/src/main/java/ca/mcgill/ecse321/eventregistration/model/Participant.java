/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.1-f40f105-3613 modeling language!*/

package ca.mcgill.ecse321.eventregistration.model;

// line 3 "../../../../../EventRegistration.ump"
// line 30 "../../../../../EventRegistration.ump"
public class Participant
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Participant Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Participant(String aName)
  {
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}