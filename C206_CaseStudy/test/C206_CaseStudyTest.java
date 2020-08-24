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
	
	//Xuanting(Member Role 2: Course Category)
	private ArrayList<CourseCategory> categoryList;
	private CourseCategory courseCat1;
	private CourseCategory courseCat2;

	@Before
	public void setUp() throws Exception {
		//Prepare test data 

		//Wei Liang (Member Role 1: Member)
		member1 = new Member("zane", "male", 12345678, "zane@gmail.com", 01012000, "Singapore");
		member2 = new Member("jenny", "female", 91234567, "jenny@gmail.com", 01012000, "Singapore");
		
		//Xuanting(Member Role 2: Course Category)
		courseCat1 = new CourseCategory("Liberal Arts & Sciences", "Understanding The Complex World That We Live In");
		courseCat1 = new CourseCategory("Professional & Personal Development", "Enhancing Skills In Management, Finance, Strstegy & Marketing");
		categoryList = new ArrayList<CourseCategory>();
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
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
	}
	
	//Xuanting(Member Role 2: Course Category)
	@Test
	public void addCourseCategoryTest() {
		//categoryList is present, course category can be added - boundary
		assertNull("Check if there is a valid CourseCategory arraylist to add to", "categoryList");
		
		//Given an empty categoryList, after adding 1 course category, the size of the categoryList is 1 - normal
		//The category just added is as same as the first item of the list
		C206_CaseStudy.addCategory(categoryList, courseCat1);
		assertEquals("Check that categoryList size is 1", 1, categoryList.size());
		assertSame("Check that course category is added", courseCat1, categoryList.get(0));
	
		//Add another category. Test that the size of categoryList is 2? - normal
		//The category just added is as same as the second item of the list
		C206_CaseStudy.addCategory(categoryList, courseCat2);
		assertEquals("Check that categoryList size is 2", 2, categoryList.size());
		assertSame("Check that course category is added", courseCat2, categoryList.get(1));
	}
	
	//Xuanting(Member Role 2: Course Category)
	@Test
	public void retrieveAllCategoryTest() {
		//Test if categoryList is present, and not empty - boundary
		assertNull("Test if there is a valid CourseCategory arraylist to retrieve category", categoryList);
		
		//Test if the list of category retrieved from the C206_CaseStudy is empty - boundary
		String allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		String testOutput = "";
		assertEquals("Check that ViewAllCategory", testOutput, allCategory);
		
		//Given an empty list, after adding 2 categories, test if the size of categoryList is 2 - normal
		C206_CaseStudy.addCategory(categoryList, courseCat1);
		C206_CaseStudy.addCategory(categoryList, courseCat2);
		assertEquals("Test that categoryList size is 2", 2, categoryList.size());
		
		//Test if the expected output string is the same as the list of category retrieved from the C206_CaseStudy
		allCategory = C206_CaseStudy.retrieveAllCategory(categoryList);
		testOutput = String.format("%-50s %-50s\n", "Liberal Arts & Sciences", "Understanding The Complex World That We Live In");
		testOutput += String.format("%-50s %-50s\n", "Professional & Personal Development", "Enhancing Skills In Management, Finance, Strstegy & Marketing");
		assertEquals("Test that ViewAllCategory", testOutput, allCategory);
	}
	
	//Xuanting(Member Role 2: Course Category)
	@Test
	public void doDeleteCategoryTest() {
		//Normal
		Boolean ok = C206_CaseStudy.doDeleteCategory(categoryList, "Liberal Arts & Sciences");
		assertTrue("Test that existing course category is ok to delete?", ok);
		
		//Boundary
		assertNotNull("Test if there is valid categoryList to delete from", categoryList);
		C206_CaseStudy.addCategory(categoryList, courseCat1);
		
		//Error (Non-existing course category)
		ok = C206_CaseStudy.doDeleteCategory(categoryList, "Hospitality");
		assertFalse("Test that non-existing course category is NOT ok to delete?", ok);	
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
}
