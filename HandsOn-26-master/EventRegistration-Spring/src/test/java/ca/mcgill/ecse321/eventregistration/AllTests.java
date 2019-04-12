package ca.mcgill.ecse321.eventregistration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ca.mcgill.ecse321.eventregistration.persistence.TestPersistence;
import ca.mcgill.ecse321.eventregistration.service.TestEventRegistrationService;

@RunWith(Suite.class)
@SuiteClasses({ TestEventRegistrationService.class, TestPersistence.class })
public class AllTests {

}
