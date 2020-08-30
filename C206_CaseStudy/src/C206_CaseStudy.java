import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int MEMBERS = 1;
	private static final int COURSE_CATEGORY = 2;
	private static final int COURSES = 3;
	private static final int COURSE_SCHEDULE = 4;
	private static final int COURSE_REGISTRATION = 5;
	private static final int QUIT = 6;

	//Wei Liang (Member Role 1: Member)
	public static ArrayList<Member> member = new ArrayList<Member>();
	
	//Xuanting (Member Role 2: Course Category)
	public static ArrayList<CourseCategory> categoryList = new ArrayList<CourseCategory>();
	
	//Johnathan (Member Role 3: Course)
	public static ArrayList<CourseMain> course = new ArrayList<CourseMain>();
	
	//Ashley(Member Role 4: Course Schedule)
	public static ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();
	
	//Miyuki(Member Role: 5: Course Registration)
	public static ArrayList<register> registrationList = new ArrayList<register>();

	
	public static void main(String[] args) {

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
					
				} else if (choice==4) {
					C206_CaseStudy.updateMember(member);
					
				} else if (choice==5) {
					C206_CaseStudy.searchMember(member);
					
				} else {
					System.out.println("Invalid choice");
				}
				
			} else if (option == COURSE_CATEGORY) {
				categoryMenu();
				int catType = Helper.readInt("Enter option > ");
				
				if (catType == 1) {
					//Add course category
					CourseCategory category = addCategoryInfo();
 					C206_CaseStudy.addCategory(categoryList, category);
 					
				} else if (catType == 2) {
					//View course category
					C206_CaseStudy.viewAllCategory(categoryList, course);
					
				} else if (catType == 3) {
					//Delete course category
					C206_CaseStudy.deleteCategory(categoryList);
				
				} else if (catType == 4) {
					//Search course category
					C206_CaseStudy.searchCategory(categoryList);
					
				} else if (catType == 5) {
					//Update course category
					C206_CaseStudy.updateCategory(categoryList);

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
				
				} else if (schedType == 4) {
					C206_CaseStudy.updateSchedule(scheduleList);
					
				} else if (schedType == 5) {
					C206_CaseStudy.searchSchedule(scheduleList);
				
				} else {
					System.out.println("Invalid Type");
				}
				
			} else if (option == COURSE_REGISTRATION) {
				registration();
				int type = Helper.readInt("Enter option: ");
				
				if (type == 1) {
					C206_CaseStudy.register(registrationList, course);
					
				} else if(type == 2){
					C206_CaseStudy.viewRegistration(registrationList,scheduleList, member);
				
				} else if(type == 3) {
					C206_CaseStudy.deleteRegistration(registrationList,scheduleList);
				
				} else if (type == 4) {
					C206_CaseStudy.UpdateStatus(registrationList);
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
		Helper.line(90, "=");
		System.out.println("MEMBER'S ACCOUNT");
		Helper.line(90, "=");
		
		System.out.println("1. Add account");
		System.out.println("2. View account");
		System.out.println("3. Delete account");
		System.out.println("4. Update account");
		System.out.println("5. Search account");
	}
	
	//Xuanting
	private static void categoryMenu() {
		Helper.line(90, "=");
		System.out.println("COURSE CATEGORIES");
		Helper.line(90, "=");
		
		System.out.println("1. Add Course Category");
		System.out.println("2. View Course Category");
		System.out.println("3. Delete Course Category");
		System.out.println("4. Search Course Category");
		System.out.println("5. Update Course Category");
	}
	
	//Johnathan
	private static void showCourseMenu() {
		Helper.line(90, "=");
		System.out.println("COURSES");
		Helper.line(90, "=");
		
		System.out.println("1. Add Courses");
		System.out.println("2. View Courses");
		System.out.println("3. Delete Courses");
	}
	
	//Ashley
	private static void scheduleMenu() {
		Helper.line(90, "=");
		System.out.println("COURSE SCHEDULES");
		Helper.line(90, "=");
		
		System.out.println("1.Add Course Schedules");
		System.out.println("2.View Course Schedules");
		System.out.println("3.Delete Course Schedules");
		System.out.println("4.Update Course Schedules");
		System.out.println("5.Search Course Schedules");
	}
	
	//Miyuki
	private static void registration() {
		Helper.line(90, "=");
		System.out.println("COURSE REGISTRATION");
		Helper.line(90, "=");
		
		System.out.println("1. Registration");
		System.out.println("2. View Registration");
		System.out.println("3. Delete Registration");
		System.out.println("4. Update Registration status");
	}
	
	//Xuanting
	public static void menu() {
		Helper.line(90, "=");
		System.out.println("COURSE MANAGEMENT SYSTEM");
		Helper.line(90, "=");
		
		System.out.println("1. Members");
		System.out.println("2. Course Category");
		System.out.println("3. Courses");
		System.out.println("4. Course Schedule");
		System.out.println("5. Course Registration");
		System.out.println("6. Quit");
		Helper.line(90, "-");
	}
	
	
//================================================================= Option 1 Members =================================================================
	//Add Members
	public static Member inputDetails() {
		String name = Helper.readString("Enter name > ");
		String gender = Helper.readString("Enter gender > ");
		int mobile_number = Helper.readInt("Enter mobile number > ");
		String email = Helper.readString("Enter email > ");
		String dob = Helper.readString("Enter date of birth > ");
		String residence = Helper.readString("Enter country of residence > ");
		String password = Helper.readString("Enter password > ");

		Member details = new Member(name, gender, mobile_number, email, dob, residence, password);
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
			output += String.format("%-10s %-8s %-15d %-18s %-15s %s \n", member.get(i).getName(), member.get(i).getGender(),
					member.get(i).getMobile_number(), member.get(i).getEmail(), member.get(i).getDob(),
					member.get(i).getResidence());
		}
		return output;
	}
	
	public static void viewAllMember(ArrayList<Member> member) {
		Helper.line(90, "=");
		System.out.println("Member LIST");
		Helper.line(90, "=");
		
		String output = String.format("%-10s %-8s %-15s %-18s %-15s %s \n", "NAME", "GENDER", "MOBILE NUMBER", "EMAIL",
				"DATE OF BIRTH", "RESIDENCE");
		output += retrieveAllMember(member);
		System.out.println(output);
	}
	
	//Delete Member
	public static boolean DeleteMember(ArrayList<Member> member, String name) {
		boolean deleted = false;
		
		for (int i=0; i<member.size(); i++) {
			if (member.get(i).getName().equalsIgnoreCase(name)) {
				member.remove(i);
				deleted = true;
				break;
			}
		}
		return deleted;
	}
	
	public static void deleteMember(ArrayList<Member> member) {
		viewAllMember(member);
		String name = Helper.readString("Enter name of the account to be deleted > ");
		Boolean Isdeleted = DeleteMember(member, name);
		if (Isdeleted == false) {
			System.out.println("No member's account of the name '" + name + "'");
		} else {
			System.out.println("Member deleted");
		}
	}
	
	//Update Member
	public static boolean UpdateMember(ArrayList<Member> member, String name) {
		boolean updated = false;
		
		for (int i=0; i<member.size(); i++) {
			if (member.get(i).getName().equalsIgnoreCase(name)) {
				String password = Helper.readString("Enter new password > ");
				String residence = Helper.readString("Enter new residence > ");
				int mobile = Helper.readInt("Enter new mobile number > ");
				member.get(i).setPassword(password);
				member.get(i).setResidence(residence);
				member.get(i).setMobile_number(mobile);
				updated = true;
				break;
			}
		}
		return updated;
	}
	
	public static void updateMember(ArrayList<Member> member) {
		viewAllMember(member);
		String name = Helper.readString("Enter name of the member's account to be updated > ");
		Boolean Isupdated = UpdateMember(member, name);
		if (Isupdated == false) {
			System.out.println("There is no member's account with this name '" + name + "'");
		} else {
			System.out.println("Update succesfully");
		}
	}
	      
	//Search Member
	public static void searchMember(ArrayList<Member> member) {
		String residence = Helper.readString("Enter residence of the member > ");
		Helper.line(90, "=");
		System.out.println("Member LIST");
		Helper.line(90, "=");
		System.out.print(String.format("%-10s %-10s %-15s %-18s %-15s %s \n", "NAME", "GENDER", "MOBILE NUMBER", "EMAIL",
				"DATE OF BIRTH", "RESIDENCE"));
		boolean search = false;
		
		for (int i=0; i<member.size(); i++) {
			if (member.get(i).getResidence().equalsIgnoreCase(residence)) {
				String output = String.format("%-10s %-10s %-15d %-18s %-15s %s \n", member.get(i).getName(), member.get(i).getGender(),
						member.get(i).getMobile_number(), member.get(i).getEmail(), member.get(i).getDob(),
						member.get(i).getResidence());
				System.out.print(output);
				search = true;
			} 
		}
		if (search == false) {
			System.out.println("");
			System.out.println("No member lives in this residence '" + residence + "'");
		}
	}
	
//================================================================= Option 2 Course Category ==========================================================
	//Add Course Category
	public static CourseCategory addCategoryInfo() {
		String name = Helper.readString("Enter category name > ");
		String description = Helper.readString("Enter category description > ");

		CourseCategory category = new CourseCategory(name, description);
		return category;
	}
	
	public static void addCategory(ArrayList<CourseCategory> categoryList, CourseCategory category) {
		categoryList.add(category);
		System.out.println("Course Category Added!");
	}
		
	//View Course Category
	public static String retrieveAllCategory(ArrayList<CourseCategory> categoryList) {
		String output = "";
		
		for (int i = 0; i < categoryList.size(); i++) {
			output += String.format("%-50s %-50s\n", categoryList.get(i).getName(), categoryList.get(i).getDescription());
		}
		return output;
	}
	
	public static void viewAllCategory(ArrayList<CourseCategory> categoryList, ArrayList<CourseMain> course) {
		Helper.line(70, "=");
		System.out.println("COURSES BY CATEGORY LIST");
		Helper.line(70, "=");
		
		String output = String.format("%-50s %-50s\n", "CATEGORY NAME", "CATEGORY DESCRIPTION");
		output += retrieveAllCategory(categoryList);
		System.out.println(output);
	}

	//Delete Course Category
	public static void deleteCategory(ArrayList<CourseCategory> categoryList) {
		C206_CaseStudy.viewAllCategory(categoryList, course);
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
	
	//Update Course Category
	public static void updateCategory(ArrayList<CourseCategory> categoryList) {
		C206_CaseStudy.viewAllCategory(categoryList, course);
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
	

//================================================================= Option 3 Courses =================================================================
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
	
	
//================================================================= Option 4 Course Schedule ==========================================================
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
			output += String.format("%-20s %-20s %-20s %-15s %-15s\n", scheduleList.get(i).getStart(), scheduleList.get(i).getEnd(), 
					scheduleList.get(i).getPrice(), scheduleList.get(i).getId(),scheduleList.get(i).getLocation());
		}
		return output;
	}
	
	public static void viewAllSchedule(ArrayList<CourseSchedule> scheduleList) {
		Helper.line(70, "=");
		System.out.println("COURSE SCHEDULE LIST");
		Helper.line(70, "=");
		
		String output = String.format("%-20s %-20s %-20s %-15s %-15s\n", "COURSE START DATE", "COURSE END DATE", "COURSE PRICE", 
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
	
	//Update Course Schedule
	public static boolean UpdateSchedule(ArrayList<CourseSchedule> scheduleList, int Id) {
		boolean updated = false;
			
		for (int i=0; i<scheduleList.size(); i++) {
			if (scheduleList.get(i).getId() == Id) {
				String Start= Helper.readString("Enter new start date >  ");
				String End = Helper.readString("Enter new end date > ");
				String Location = Helper.readString("Enter new location > ");
				int Price = Helper.readInt("Enter new price > ");
				scheduleList.get(i).setStart(Start);
				scheduleList.get(i).setEnd(End);
				scheduleList.get(i).setLocation(Location);
				scheduleList.get(i).setPrice(Price);
				updated = true;
				break;
			}
		}
		return updated;
	}
		
	public static void updateSchedule(ArrayList<CourseSchedule> scheduleList) {
		viewAllSchedule(scheduleList);
		int Id = Helper.readInt("Enter ID of the Course Schedule to be updated > ");
		boolean Isupdated = UpdateSchedule(scheduleList, Id);
		
		if (Isupdated == false) {
			System.out.println("There is no course schedule with this ID '" + Id + "'");
		} else {
			System.out.println("Update succesfully");
		}
	}
		      
	//Search Course Schedule
	public static void searchSchedule(ArrayList<CourseSchedule> scheduleList) {
		int Price = Helper.readInt("Enter price of the course > ");
		Helper.line(90, "=");
		System.out.println("Course Schedule LIST");
		Helper.line(90, "=");
		
		System.out.print(String.format("%-20s %-20s %-20s %-15s %-15s\n", "COURSE START DATE", "COURSE END DATE", "COURSE PRICE", 
				"COURSE ID", "COURSE LOCATION"));
		boolean search = false;
			
		for (int i=0; i<scheduleList.size(); i++) {
			if (scheduleList.get(i).getPrice() == Price) {
				String output = String.format("%-20s %-20s %-20s %-15s %-15s\n", scheduleList.get(i).getStart(), scheduleList.get(i).getEnd(), 
						scheduleList.get(i).getPrice(), scheduleList.get(i).getId(),scheduleList.get(i).getLocation());
				System.out.print(output);
				search = true;
			} 
		}
		if (search == false) {
			System.out.println("");
			System.out.println("There is no course with this price '" + Price + "'");
		}
	}
		

//========================================================= Option 5 Course Registration ==========================================================
	//Delete Registration
	public static String deleteRegistration(ArrayList<register> registrationList, ArrayList<CourseSchedule>scheduleList) {
		LocalDate ld = LocalDate.now();
		String output = "";
		int Rid = Helper.readInt("Enter registration ID to delete: ");
		
		for (register r: registrationList) {
			if (r.getRegistrationNum() == Rid) {
				if(r.getStatus() == "Accepted") {
					for (CourseSchedule cs: scheduleList) {
						DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyy");
						String start = cs.getStart();
						LocalDate d = LocalDate.parse(start,f);
						
						if(d.isAfter(ld)) {
							registrationList.remove(r);
							output = "Sucessfully deleted!";
								
						} else {
							output = "Resgistration ID does not exist\n Delete not succesfull";
						}
					}
				}
			}
		}
		return output;
	}
		
	//View Registration
	public static void viewRegistration(ArrayList<register> registrationList, ArrayList<CourseSchedule>scheduleList, ArrayList<Member>member) {
		System.out.println("1. View all registration\n2. Search registration by course schedule id\n3.Search by member");
		int view = Helper.readInt("Enter how you want to view: ");
			
		Helper.line(80, "-");
		System.out.println("REGISTRATION LIST");
		Helper.line(80, "-");
			
		if(view ==1) {
			String output = String.format("%-20s %-30s %-20s %-30s", "Registration ID", "STUDENT EMAIL", "COURSE ID","STATUS", 
					"REGISTRATION DATE AND TIME");
				
			for(int i = 0; i<registrationList.size();i++) {
				output += String.format("%-20d %-30s %-20d %-30s\n" , registrationList.get(i).getRegistrationNum(), 
						registrationList.get(i).getEmail(), registrationList.get(i).getCourseID(),registrationList.get(i).getStatus(),
						registrationList.get(i).getDt());
			}
			System.out.println(output);
		
		} else if (view == 2) {
			int schedule_id = Helper.readInt("Enter course schedule id: ");
			
			for(CourseSchedule id :scheduleList ) {
				if(id.getId() == schedule_id) {
					String output = String.format("%-20s %-30s %-20s %-30s", "Registration ID", "STUDENT EMAIL", "COURSE ID","STATUS", 
						"REGISTRATION DATE AND TIME");
					
					for(int i = 0; i<registrationList.size();i++) {
						output += String.format("%-20d %-30s %-20d %-30s\n" , registrationList.get(i).getRegistrationNum(), 
								registrationList.get(i).getEmail(), registrationList.get(i).getCourseID(),registrationList.get(i).getStatus(),
								registrationList.get(i).getDt());
					}
					System.out.println(output);
				}
			}
			
		} else if(view == 3) {
			String name = Helper.readString("Enter member name: ");
			
			for(Member n: member) {
				if(n.getName().contains(name)) {
					String output = String.format("%-20s %-30s %-20s %-30s", "Registration ID", "STUDENT EMAIL", "COURSE ID","STATUS", 
							"REGISTRATION DATE AND TIME");
					
					for(int i = 0; i<registrationList.size();i++) {
						output += String.format("%-20d %-30s %-20d %-30s\n" , registrationList.get(i).getRegistrationNum(), 
								registrationList.get(i).getEmail(), registrationList.get(i).getCourseID(),registrationList.get(i).getStatus(),
								registrationList.get(i).getDt());
					}
					System.out.println(output);
				}
			}
		}
	}
		
	//Add Registration
	public static String register(ArrayList<register> registrationList, ArrayList<CourseMain>course) {
		C206_CaseStudy.viewAllCourses(course);
		String output = "";
		String courseID = Helper.readString("Enter course code to register: ");
		String email = Helper.readString("Enter email: ");
		
		if (!email.contains("@") || !email.contains(".com")) {
			output = ("Please enter a valid email!");
		
		} else {
			for(CourseMain id: course) {
				if(id.getCourseCode().equalsIgnoreCase(courseID)) {
					registrationList.add(new register(registrationList.size()+1,courseID,email));
					output = "Successfully registered!";
					
				} else {
					output = "Registration failed!";
				}
			}
		}
		return output;
	}
		
	//Update Status of Registration
	private static void UpdateStatus(ArrayList<register> registrationList) {
		C206_CaseStudy.viewRegistration(registrationList, null,null);
		int option = Helper.readInt("Enter registration id to update: ");

		for (register r: registrationList) {
			if(r.getRegistrationNum() == option) {
				String update = Helper.readString("Enter status: ");
				System.out.println("Status successfully updated");
			} else {
				System.out.println("Failed");
			}
		}	
	}
		
}
