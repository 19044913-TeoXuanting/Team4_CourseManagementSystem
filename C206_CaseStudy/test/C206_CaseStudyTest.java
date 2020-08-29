import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class C206_CaseStudyTest {
	
	//Wei Liang (Member Role 1: Member)
	private ArrayList<Member> member = new ArrayList<Member>(); 
	private Member member1;
	private Member member2;
	
	//Xuanting (Member Role 2: Course Category)
	private ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
	private CourseCategory courseCat1;
	private CourseCategory courseCat2;
	
	//Miyuki (Member Role 5: Course Registration)
	private register Register1;
	private register Register2;

	
	@Before
	public void setUp() throws Exception {
		//Prepare test data 

		//Wei Liang (Member Role 1: Member)
		member1 = new Member("zane", "male", 12345678, "zane@gmail.com", "01012000", "Singapore", "123456");
		member2 = new Member("jenny", "female", 91234567, "jenny@gmail.com", "01012000", "Singapore", "234567");
		
		//Xuanting (Member Role 2: Course Category)
		courseCat1 = new CourseCategory("Liberal Arts & Sciences", "Understanding The Complex World That We Live In");
		courseCat2 = new CourseCategory("Professional & Personal Development", "");
		
		//Miyuki (Member Role 5: Course Registration)
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
		member1 = null;
		member2 = null;
		courseCat1 = null;
		courseCat2 = null;
	}


	//Wei Liang (Member Role 1: Member)
	@Test
	public void addMemberTest() {
		
		assertNotNull("Test if there is valid member arraylist to add to", member);
		
		C206_CaseStudy.addMember(member, member1);		
		assertEquals("Test if that member arraylist size is 1?", 1, member.size());
		
		assertSame("Test that account detail is added same as 1st item of the list?", member1, member.get(0));
	}
	
	//Wei Liang (Member Role 1: Member)
	@Test
	public void retrieveAllMemberTest() {
		
		assertNotNull("Test if there is a valid member arraylist to retrieve", member);
		
		String allMember= C206_CaseStudy.retrieveAllMember(member);
		String testOutput = "";
		testOutput += String.format("%-10s %-10s %-15s %-18s %-15s %s \n", "zane", "male", 12345678, "zane@gmail.com", "01-01-2002", "Singapore");
		testOutput += String.format("%-10s %-10s %-15s %-18s %-15s %s \n", "jenny", "female", 91234567, "jenny@gmail.com", "01-01-2000", "Singapore");
		assertEquals("Check the ViewAllMember", testOutput, allMember);
	}
	
	//Wei Liang (Member Role 1: Member)
	@Test
	public void deleteMemberTest() {
		assertNotNull("Test if there is a valid member arraylist to delete", member);
		
		boolean deleted = C206_CaseStudy.DeleteMember(member,"jenny");
		assertTrue("Test if member is deleted", deleted);
	}
	
	//Wei Liang (Member Role 1: Member)
	@Test
	public void UpdateMemberTest() {
		assertNotNull("Test if there is a valid member arraylist to update", member);
		
		boolean update = C206_CaseStudy.UpdateMember(member,"zane");
		assertFalse("Test if member is updated", update );
	}
	
	//Wei Liang (Member Role 1: Member)
		@Test
		public void SearchMemberTest() {
			assertNotNull("Test if there is a valid member arraylist to search", member);
			
		}
	
		
	//Xuanting (Member Role 2: Course Category)
	@Test
	public void addCourseCategoryTest() {
		//Check if arraylist exist - normal
		assertNull("Test that there is a valid category arraylist to add", categoryList);
		
		//Check if size of arraylist will be 1 after adding an element in - normal
		C206_CaseStudy.addCategory(categoryList, courseCat1);
		assertEquals("Test that category arraylist size is 1", 1, categoryList.size());
		
		//Check if size of arraylist will be 2 after adding element in - boundary
		C206_CaseStudy.addCategory(categoryList, courseCat2);
		assertEquals("Test that categiry arraylist size is 2", 2, categoryList.size());

	}
	
	//Xuanting (Member Role 2: Course Category)
	@Test
	public void retrieveAllCategoryTest() {
		//Check if arraylist exist, and is empty - boundary
		assertNull("Test that there is a valid category arraylist to retrieve", categoryList);
		
		//Check if expected testOutput string will display the list of categories retrieved from category arraylist - normal
		String allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		String testOutput = "";
		
		testOutput = String.format("%-50s %-50s", "Liberal Arts & Sciences", "Understanding The Complex World That We Live In");
		testOutput += String.format("%-50s %-50s", "Professional & Personal Development", "");
		assertEquals("Test that viewAllCategory", testOutput, allCategory);
	}
	
	//Xuanting (Member Role 2: Course Category)
	@Test
	public void deleteCategoryTest() {
		//Check if arraylist is empty before deleting - boundary
		assertNull("Test that category arraylist is empty", categoryList);
		
		//Check that category arraylist size is 1 after deleting element - normal
		C206_CaseStudy.addCategory(categoryList, courseCat1);
		assertEquals("Test that category arraylist size is 1", 1, C206_CaseStudy.categoryList.size());
	}
	
	//Xuanting (Member Role 2: Course Category)
	@Test
	public void searchCategoryTest() {
		//Check if arraylist exist - boundary
		assertNull("Test that there is a valid category arraylist to search from", categoryList);
		
		//Check if expected testOutput string will display the list of categories retrieved from category arraylist - normal
		String allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		String testOutput = "";
				
		testOutput = String.format("%-50s %-50s", "Liberal Arts & Sciences", "Understanding The Complex World That We Live In");
		testOutput += String.format("%-50s %-50s", "Professional & Personal Development", "");
		assertEquals("Test that viewAllCategory", testOutput, allCategory);
	}
	
	//Xuanting (Member Role 2: Course Category)
	public void updateCategoryTest() {
		//Check if arraylist exist - boundary
		assertNull("Test that there is a valid category arraylist to update", categoryList);
	}

	
	//Miyuki (Member Role 5: Course Registration)
	@Test
	public void registertest() {
		//Test that the size of the arrayList is 0 before adding
		assertEquals("Test that the size of Arraylist is 0 before adding", 0,C206_CaseStudy.registrationList.size());
		
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

	
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
