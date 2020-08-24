import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class C206_CaseStudyTest {
	
	ArrayList<Member> member = new ArrayList<Member>(); 
	
	//Xuanting(Member Role 2: Course Category)
	private CourseCategory courseCat1;
	private CourseCategory courseCat2;
	
	//(Member Role 2: Course Category)
	private ArrayList<CourseCategory> categoryList;
	
	@Before
	public void setUp() throws Exception {
		//Prepare test data 
		
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
	
	public void addMemberTest() {
		assertNotNull("Test if there is valid member arraylist to add to", member);
	}
	
	public void retrieveAllMemberTest() {
		assertNotNull("Test if there is a valid member arraylist to retrieve category", member);
	}
	
	public void deleteMemberTest() {
		assertNotNull("Test if there is a valid member arraylist to retrieve category", member);
	}
	
	
	//Xuanting(Member Role 2: Course Category)
	@Test
	public void addCourseCategoryTest() {
		//categoryList is not null, course category can be added - boundary
		assertNotNull("Check if there is a valid CourseCategory arraylist to add to", "categoryList");
		
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
		//Test if categoryList is not null, but empty - boundary
		assertNotNull("Test if there is a valid CourseCategory arratlist to retrieve category", categoryList);
		
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
