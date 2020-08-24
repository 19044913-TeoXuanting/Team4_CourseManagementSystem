
public class CourseMain {

	private String courseCode;
	private String courseTitle;
	private String categoryName;
	private String categoryDescription;
	private int courseDuration;
	private String prerequisiteCourse;

	public CourseMain(String courseCode, String courseTitle, String categoryName, String categoryDescription,
			int courseDuration, String prerequisiteCourse) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.courseDuration = courseDuration;
		this.prerequisiteCourse = prerequisiteCourse;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getPrerequisiteCourse() {
		return prerequisiteCourse;
	}

	public void setPrerequisiteCourse(String prerequisiteCourse) {
		this.prerequisiteCourse = prerequisiteCourse;
	}
	
	
}
