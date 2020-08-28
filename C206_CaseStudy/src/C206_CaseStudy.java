
import java.util.ArrayList;


public class C206_CaseStudy {
	
	private static final int MEMBERS = 1;
	private static final int COURSE_CATEGORY = 2;
	private static final int COURSES = 3;
	private static final int COURSE_SCHEDULE = 4;
	private static final int COURSE_REGISTRATION = 5;
	private static final int QUIT = 6;

	public static void main(String[] args) {
		
		//Wei Liang (Member Role 1: Member)
		ArrayList<Member> member = new ArrayList<Member>(); 
		
		member.add(new Member("zane", "male", 12345678, "zane@gmail.com", 01012000, "Singapore"));
		member.add(new Member("jenny", "female", 91234567, "jenny@gmail.com", 01012000, "Singapore"));	

		//Xuanting (Member Role 2: Course Category)
		ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
		
		//Johnathan (Member Role 3: Course)
		ArrayList<CourseMain> course = new ArrayList<CourseMain>();
		
		//Ashley(Member Role 4: Course Schedule)
		ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();
		scheduleList.add(new CourseSchedule("24/08/2020", "27/08/2020", 500, 1, "Singapore"));
		scheduleList.add(new CourseSchedule("25/08/2020", "30/08/2020", 300, 2, "Singapore"));
		
		//Miyuki(Member Role: 5: Course Registration)
		ArrayList<register>registrationList = new ArrayList<register>();
		ArrayList<course>courseList = new ArrayList<course>();
		
		int option = 0;
		
		while (option != 6) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter option > ");
			
			if (option == MEMBERS) {
				account();
				int choice = Helper.readInt("Enter your choice > ");
				
				if (choice==1) {
					Member details = inputDetails();
					C206_CaseStudy.addMember(member, details);
					
				} else if (choice==2) {
					C206_CaseStudy.viewAllMember(member);
					
				} else if (choice==3) {
					C206_CaseStudy.deleteMember(member);
					
				} else {
					System.out.println("Invalid choice");
				}
				
			} else if (option == COURSE_CATEGORY) {
				categoryMenu();
				int catType = Helper.readInt("Enter option > ");
				
				if (catType == 1) {
					//Add course category
 					C206_CaseStudy.addCategory(categoryList);
 					
				} else if (catType == 2) {
					//Search course category
					C206_CaseStudy.searchCategory(categoryList);
					
				} else if (catType == 3) {
					//Update course category
					C206_CaseStudy.updateCategory(categoryList);
				
				} else if (catType == 4) {
					//View course category
					C206_CaseStudy.viewAllCategory(categoryList);
					
				} else if (catType == 5) {
					//Delete course category
					C206_CaseStudy.deleteCategory(categoryList);

				} else {
					System.out.println("Invalid type");
				}
				
			} else if (option == COURSES) {
				showCourseMenu();
				int choice = Helper.readInt("Enter an option > ");
				
				if (choice == 1) {
					C206_CaseStudy.addCourse(course);
					
				} else if (choice == 2) {
					C206_CaseStudy.viewAllCourses(course);
				
				} else if (choice == 3) {
					C206_CaseStudy.delCourse(course);

				} else {
					System.out.println("Invalid Option");
				}	
				
			} else if (option == COURSE_SCHEDULE) {
				scheduleMenu();
				int schedType = Helper.readInt("Enter Your Choice > ");
				
				if (schedType == 1) {
					CourseSchedule courseSched = inputSchedule();
					C206_CaseStudy.addSchedule(scheduleList, courseSched);
				
				} else if (schedType == 2) {
					C206_CaseStudy.viewAllSchedule(scheduleList);
				
				} else if(schedType == 3) {
					C206_CaseStudy.deleteSchedule(scheduleList);
				
				} else {
					System.out.println("Invalid Type");
				}
				
			} else if (option == COURSE_REGISTRATION) {
				registration();
				int type = Helper.readInt("Enter option: ");
				
				if (type == 1) {
					C206_CaseStudy.register(registrationList, courseList);
					
				} else if(type == 2){
					C206_CaseStudy.viewAllRegistration(registrationList);
				
				} else if(type == 3) {
					C206_CaseStudy.deleteRegistration(registrationList);
				}

			} else if (option == QUIT) {
				System.out.println("Thank you for using the Course Management System!");
			
			} else {
				System.out.println("Invalid option!");
			}
		}
	}

	//Wei Liang
	private static void account() {
		Helper.line(70, "=");
		System.out.println("MEMBER'S ACCOUNT");
		Helper.line(70, "=");
		
		System.out.println("1. Add account");
		System.out.println("2. View account");
		System.out.println("3. Delete account");
	}
	
	//Xuanting
	private static void categoryMenu() {
		Helper.line(70, "=");
		System.out.println("COURSE CATEGORIES");
		Helper.line(70, "=");
		
		System.out.println("1. Add Course Category");
		System.out.println("2. Search Course Category");
		System.out.println("3. Update Course Category");
		System.out.println("4. View Course Category");
		System.out.println("5. Delete Course Catgeory");
	}
	
	//Johnathan
	private static void showCourseMenu() {
		Helper.line(70, "=");
		System.out.println("COURSES");
		Helper.line(70, "=");
		
		System.out.println("1. Add Courses");
		System.out.println("2. View Courses");
		System.out.println("3. Delete Courses");
	}
	
	//Ashley
	private static void scheduleMenu() {
		Helper.line(70, "=");
		System.out.println("COURSE SCHEDULES");
		Helper.line(70, "=");
		
		System.out.println("1.Add Course Schedules");
		System.out.println("2.View Course Schedules");
		System.out.println("3.Delete Course Schedules");
	}
	
	//Miyuki
	private static void registration() {
		System.out.println("1. Registration");
		System.out.println("2. View All Registration");
		System.out.println("3. Delete Registration");
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
	
	
//====================================================== Option 1 Members ======================================================
	//Add Members
	public static Member inputDetails() {
		String name = Helper.readString("Enter name > ");
		String gender = Helper.readString("Enter gender > ");
		int mobile_number = Helper.readInt("Enter mobile number > ");
		String email = Helper.readString("Enter email > ");
		int dob = Helper.readInt("Enter date of birth > ");
		String residence = Helper.readString("Enter country of residence > ");

		Member details = new Member(name, gender, mobile_number, email, dob, residence);
		return details;
	}
	
	public static void addMember(ArrayList<Member> member, Member details) {
		member.add(details);
		System.out.println("Member Added!");
	}
	
	//View Member
	public static String retrieveAllMember(ArrayList<Member> member) {
		String output = "";
		
		for (int i = 0; i < member.size(); i++) {
			output += String.format("%-10s %-10s %-15d %-18s %-15s %s \n", member.get(i).getName(), member.get(i).getGender(),
					member.get(i).getMobile_number(), member.get(i).getEmail(), member.get(i).getDob(),
					member.get(i).getResidence());
		}
		return output;
	}
	
	public static void viewAllMember(ArrayList<Member> member) {
		Helper.line(70, "=");
		System.out.println("Member LIST");
		Helper.line(70, "=");
		
		String output = String.format("%-10s %-10s %-15s %-18s %-15s %s \n", "NAME", "GENDER", "MOBILE NUMBER", "EMAIL",
				"DATE OF BIRTH", "RESIDENCE");
		output += retrieveAllMember(member);
		System.out.println(output);
	}
	
	//Delete Member
	public static void deleteMember(ArrayList<Member> member) {
		String name = Helper.readString("Enter name of the account to be deleted > ");
		int i=0;
		while (i<member.size()) {
			if (member.get(i).getName() == name) {
				member.remove(i);
				System.out.println("Member deleted");
			} else {
				i++;
			}
		}
	}

	
//====================================================== Option 2 Course Category ======================================================
	//Add Course Category
	public static void addCategory(ArrayList<CourseCategory> categoryList) {
		String name = Helper.readString("Enter category name > ");
		String description = Helper.readString("Enter category description > ");

		CourseCategory category = new CourseCategory(name, description);
		categoryList.add(category);
		System.out.println("Course Category Added!");
	}
	
	//Search Course Category
	public static void searchCategory(ArrayList<CourseCategory> categoryList) {
		String name = Helper.readString("Enter category name > ");
		String output = "";
		boolean isFound = false;
		
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getName().equalsIgnoreCase(name)) {
				output = String.format("%-50s %-50s\n", "CATEGORY NAME", "CATEGORY DESCRIPTION");
				output += String.format("%-50s %-50s\n", categoryList.get(i).getName(), categoryList.get(i).getDescription());
				
				isFound = true;
				System.out.println(output);
				break;
			}
		}
		if (isFound == false) {
			System.out.println("There is no such course category.");
		}
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
	
	//Update Course Category
	public static void updateCategory(ArrayList<CourseCategory> categoryList) {
		C206_CaseStudy.viewAllCategory(categoryList);
		String description = Helper.readString("Enter category description to update > ");
		boolean isUpdated = false;
		
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getDescription().equalsIgnoreCase(description)) {
				String updateDescription = Helper.readString("Enter new category description > ");
				categoryList.get(i).setDescription(updateDescription);
				
				isUpdated = true;
				System.out.println("Category Description Updated!");
				break;
			}
		}
		if (isUpdated == false) {
			System.out.println("Invalid category description.");
		}
	}

	//Delete Course Category
	public static void deleteCategory(ArrayList<CourseCategory> categoryList) {
		C206_CaseStudy.viewAllCategory(categoryList);
		String name = Helper.readString("Enter category name to delete > ");
		boolean isDeleted = false;
		
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getName().equalsIgnoreCase(name)) {
				categoryList.remove(i);
				
				isDeleted = true;
				System.out.println("Course Category deleted!");
				break;
			}
		}
		if (isDeleted == false) {
			System.out.println("Failed to delete.");
		}
	}
	

//====================================================== Option 3 Courses ======================================================
	//Add Courses
	public static void addCourse(ArrayList<CourseMain> course) {
		String courseCode = Helper.readString("Enter course code > ");
		String courseTitle = Helper.readString("Enter course title > ");
		String categoryName = Helper.readString("Enter category name > ");
		String courseDescription = Helper.readString("Enter course description > ");
		int courseDuration = Helper.readInt("Enter course duration > ");
		String prerequisiteCourse = Helper.readString("Enter pre-requisite course > ");
		
		CourseMain newCourse = new CourseMain(courseCode, courseTitle, categoryName, courseDescription, courseDuration, prerequisiteCourse);
		course.add(newCourse);
		System.out.println("Course added");
	}
	
	//View Courses
	public static String retrieveAllCourses(ArrayList<CourseMain> course) {
		String output = "";
		
		for (int i = 0; i < course.size(); i++) {
			output += String.format("%-15s %-20s %-20s %-30s %-20d %-30s\n",course.get(i).getCourseCode(), course.get(i).getCourseTitle(),
					course.get(i).getCategoryName(), course.get(i).getCategoryDescription(), course.get(i).getCourseDuration(), 
					course.get(i).getPrerequisiteCourse());	
		}
		return output;	
	}
	
	public static void viewAllCourses(ArrayList<CourseMain> course) {
		Helper.line(70, "=");
		System.out.println("LIST OF COURSES");
		Helper.line(70, "=");
		
		String output = String.format("%-15s %-20s %-20s %-30s %-20d %-30s\n", "COURSE CODE", "COURSE TITLE", "CATEGORY NAME", "CATEGORY DESCRIPTION",
				"COURSE DURATION", "PRE-REQUISITE COURSE");
		output += retrieveAllCourses(course);
		System.out.println(output);
	}

	//Delete courses
	public static void delCourse(ArrayList<CourseMain> course) {
		C206_CaseStudy.viewAllCourses(course);
		String courseCode = Helper.readString("Enter course code > ");

		for (int i = 0; i < course.size(); i++) {
			if (course.get(i).getCourseCode().equals(courseCode)) {
				course.remove(i);
				System.out.println("Course deleted");
			
			} else {
				System.out.println("Failed to delete");
			}
		}
	}
	
	
//====================================================== Option 4 Course Schedule ======================================================
	//Add Course Schedule
	public static CourseSchedule inputSchedule() {
		String Start = Helper.readString("Enter course start date > ");
		String End =  Helper.readString("Enter course end date > ");
		int Price = Helper.readInt("Enter course price > ");
		int Id = Helper.readInt("Enter course ID >");
		String Location = Helper.readString("Enter Location > ");
		
		CourseSchedule courseSched = new CourseSchedule(Start,End,Price,Id,Location);
		return courseSched;
	}
	
	public static void addSchedule(ArrayList<CourseSchedule> scheduleList, CourseSchedule courseSched) {
		scheduleList.add(courseSched);
		System.out.println("Schedule Added!");
	}
	
	//View Course Schedule
	public static String retrieveAllSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = "";
		
		for (int i = 0; i < scheduleList.size(); i++) {
			output += String.format("%-50s %-50s %-50s %-50s %-50s\n", scheduleList.get(i).getStart(), scheduleList.get(i).getEnd(), 
					scheduleList.get(i).getPrice(), scheduleList.get(i).getId(),scheduleList.get(i).getLocation());
		}
		return output;
	}
	
	public static void viewAllSchedule(ArrayList<CourseSchedule> scheduleList) {
		Helper.line(70, "=");
		System.out.println("COURSE SCHEDULE LIST");
		Helper.line(70, "=");
		
		String output = String.format("%-50s %-50s %-50s %-50s %-50s\n", "COURSE START DATE", "COURSE END DATE", "COURSE PRICE", 
				"COURSE ID", "COURSE LOCATION");
		output += retrieveAllSchedule(scheduleList);
		System.out.println(output);
	}
	
	//Delete Course Schedule
	public static boolean doDeleteSchedule(ArrayList<CourseSchedule> scheduleList, int Id) {
		boolean isDeleted = false;
		
		for (int i = 0; i < scheduleList.size(); i++) {
			if (scheduleList.get(i).getId() == Id) {
				isDeleted = true;
			}
		}
		return isDeleted;
	}
	
	public static void deleteSchedule(ArrayList<CourseSchedule> scheduleList) {
		C206_CaseStudy.viewAllSchedule(scheduleList);
		int Id = Helper.readInt("Enter course ID > ");
		Boolean isDeleted = doDeleteSchedule(scheduleList, Id);
		
		if (isDeleted == true) {
			scheduleList.remove(Id);
			System.out.println("Schedule " + Id + " deleted!");
		} else {
			System.out.println("Invalid Schedule ID");
		}
	}
	
	
//====================================================== Option 5 Course Registration ======================================================
	//Delete Registration
	private static void deleteRegistration(ArrayList<register> registrationList) {
		C206_CaseStudy.viewAllRegistration(registrationList);
		
		int Rid = Helper.readInt("Enter registration ID to delete: ");
		
		for (register r: registrationList) {
			if (r.getRegistrationNum() == Rid) {
				registrationList.remove(r);
				System.out.println("Sucessfully deleted!");
			} else {
				System.out.println("Resgistration ID does not exist\n Delete not succesfull");
			}
		}	
	}
	
	//View All Registration
	private static void viewAllRegistration(ArrayList<register> registrationList) {
		Helper.line(80, "-");
		System.out.println("REGISTRATION LIST");
		Helper.line(80, "-");
		
		String output = String.format("%-20s %-30s %-20s %-30s", "Registration ID", "STUDENT EMAIL", "COURSE ID","STATUS", "REGISTRATION DATE AND TIME");
		
		for(int i = 0; i<registrationList.size();i++) {
			 output += String.format("%-20d %-30s %-20d %-30s\n" , registrationList.get(i).getRegistrationNum(), registrationList.get(i).getEmail(), 
					 registrationList.get(i).getCourseID(),registrationList.get(i).getStatus(),registrationList.get(i).getDt());
		}
		System.out.println(output);
	
	}
	
	//Add Registration
	private static void register(ArrayList<register> registrationList, ArrayList<course>courseList) {
	//C206_CaseStudy.viewAllCourse(courseList);
		int courseID = Helper.readInt("Enter course id to register: ");
		String email = Helper.readString("Enter email: ");
		
		if (!email.contains("@") || !email.contains(".com")) {
			System.out.println("Please enter a valid email!");
		
		} else {
			for(course id: courseList) {
				if(id.getCode() == courseID) {
					registrationList.add(new register(registrationList.size()+1,courseID,email));
					System.out.println("Successfully registered!");
					
				} else {
					System.out.println("Registration failed!");
				}
			}
		}
	}
	
}


	

