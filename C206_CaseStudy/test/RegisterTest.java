import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest {
	
	private register Register1;
	private register Register2;

	@Before
	public void setUp() throws Exception {
		Register1 = new register(123,"123s","m@g.com");
		Register2 = new register(234,"234s","c@g.com");
		C206_CaseStudy.addCourse(C206_CaseStudy.course);
		C206_CaseStudy.addMember(member, details);
	}

	@After
	public void tearDown() throws Exception {
		C206_CaseStudy.registrationList.clear();
		Register1= null;
		Register2 = null;
	}
	@Test
	public void registertest() {
		//Test that the size of the arrayList is 0 before adding
		assertEquals("Test that the size of  Arraylist is 0 before adding", 0,C206_CaseStudy.registrationList.size());
		
		//Test that size of ArrayList is 1 after adding
		C206_CaseStudy.register(C206_CaseStudy.registrationList, C206_CaseStudy.course);
		assertEquals("Test that size of ArrayList is 1 after adding", 1, C206_CaseStudy.registrationList.size());
	
	}
	@Test
	public void deleteRegistertest() {
		//Test that the size of the array is not null before deleting
		
		//Test that the size of the arrayList is 0 before adding
				assertEquals("Test that the size of  Arraylist is 0 before adding", 0,C206_CaseStudy.registrationList.size());
				
				//Test that size of ArrayList is 1 after adding
				C206_CaseStudy.register(C206_CaseStudy.registrationList, C206_CaseStudy.course);
				assertEquals("Test that size of ArrayList is 1 after adding", 1, C206_CaseStudy.registrationList.size());
				
				//Test that the size of the arrayList is 0 after deleting
				C206_CaseStudy.deleteRegistration(registrationList, scheduleList);
	}
}
