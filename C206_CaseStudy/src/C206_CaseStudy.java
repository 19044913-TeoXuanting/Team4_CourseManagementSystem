import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int MEMBERS = 1;
	private static final int COURSE_CATEGORY = 2;
	private static final int COURSES = 3;
	private static final int COURSE_SCHEDULE = 4;
	private static final int COURSE_REGISTRATION = 5;
	private static final int QUIT = 6;

	public static void main(String[] args) {

		//Xuanting (Member Role 2: Course Category)
		ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
		
		categoryList.add(new CourseCategory("Liberal Arts & Sciences", "Understanding The Complex World That We Live In"));
		categoryList.add(new CourseCategory("Professional & Personal Development", "Enhancing Skills In Management, Finance, Strstegy & Marketing"));
		
		int option = 0;
		
		while (option != 6) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter option > ");
			
			if (option == MEMBERS) {

			} else if (option == COURSE_CATEGORY) {
				categoryMenu();
				int catType = Helper.readInt("Enter option > ");
				
				if (catType == 1) {
					//Add course category
 					CourseCategory courseCat = inputCategory();
 					C206_CaseStudy.addCategory(categoryList, courseCat);
 					
				} else if (catType == 2) {
					//View course category
					C206_CaseStudy.viewAllCategory(categoryList);
					
				} else if (catType == 3) {
					//Delete course category
					C206_CaseStudy.deleteCategory(categoryList);
				
				} else {
					System.out.println("Invalid type");
				}
				
			} else if (option == COURSES) {
				
			} else if (option == COURSE_SCHEDULE) {
				
			} else if (option == COURSE_REGISTRATION) {
				
			} else if (option == QUIT){
				System.out.println("Bye!");
			
			} else {
				System.out.println("Invalid option!");
			}
		}

	}

	//Xuanting
	private static void categoryMenu() {
		Helper.line(70, "=");
		System.out.println("COURSE CATEGORIES");
		Helper.line(70, "=");
		
		System.out.println("1. Add Course Category");
		System.out.println("2. View Course Category");
		System.out.println("3. Delete Course Catgeory");
	}
	
	//Xuanting
	public static void menu() {
		Helper.line(70, "=");
		System.out.println("COURSE MANAGEMENT SYSTEM");
		Helper.line(70, "=");
		
		System.out.println("1. Members");
		System.out.println("2. Course Category");
		System.out.println("3. Courses");
		System.out.println("4. Course Schedule");
		System.out.println("5. Course Registration");
		System.out.println("6. Quit");
		Helper.line(70, "-");
	}
	
	//=========================== Option 1 Members ===========================
	
	
	//=========================== Option 2 Course Category ===========================
	//Add Course Category
	public static CourseCategory inputCategory() {
		String name = Helper.readString("Enter course name > ");
		String description = Helper.readString("Enter category description > ");
		
		CourseCategory courseCat = new CourseCategory(name, description);
		return courseCat;
	}
	
	public static void addCategory(ArrayList<CourseCategory> categoryList, CourseCategory courseCat) {
		categoryList.add(courseCat);
		System.out.println("Category Added!");
	}
	
	//View Course Category
	public static String retrieveAllCategory(ArrayList<CourseCategory> categoryList) {
		String output = "";
		
		for (int i = 0; i < categoryList.size(); i++) {
			output += String.format("%-50s %-50s\n", categoryList.get(i).getName(), categoryList.get(i).getDescription());
		}
		return output;
	}
	
	public static void viewAllCategory(ArrayList<CourseCategory> categoryList) {
		Helper.line(70, "=");
		System.out.println("COURSE CATEGORY LIST");
		Helper.line(70, "=");
		
		String output = String.format("%-50s %-50s\n", "CATEGORY NAME", "CATEGORY DESCRIPTION");
		output += retrieveAllCategory(categoryList);
		System.out.println(output);
	}
	
	//Delete Course Category
	public static boolean doDeleteCategory(ArrayList<CourseCategory> categoryList, String name) {
		boolean isDeleted = false;
		
		for (int i = 0; i < categoryList.size(); i++) {
			if (name.equalsIgnoreCase(categoryList.get(i).getName())) {
				isDeleted = true;
			}
		}
		return isDeleted;
	}
	
	public static void deleteCategory(ArrayList<CourseCategory> categoryList) {
		C206_CaseStudy.viewAllCategory(categoryList);
		String name = Helper.readString("Enter category name > ");
		Boolean isDeleted = doDeleteCategory(categoryList, name);
		
		if (isDeleted == true) {
			System.out.println("Category " + name + "deleted!");
		} else {
			System.out.println("Invalid category name");
		}
	}
	
	
	//=========================== Option 3 Courses ===========================
	
	
	//=========================== Option 4 Course Schedule ===========================
	
	
	//=========================== Option 5 Course Registration ===========================

	
}
