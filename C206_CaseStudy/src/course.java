
public class course {
	private int code;
	private String title;
	private String catgoryName;
	private String coursedes;
	
	public course(int code, String title, String categoryName, String coursedes) {
		this.code = code;
		this.title = title;
		this.catgoryName = categoryName;
		this.coursedes = coursedes;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCatgoryName() {
		return catgoryName;
	}

	public void setCatgoryName(String catgoryName) {
		this.catgoryName = catgoryName;
	}

	public String getCoursedes() {
		return coursedes;
	}

	public void setCoursedes(String coursedes) {
		this.coursedes = coursedes;
	}
}
