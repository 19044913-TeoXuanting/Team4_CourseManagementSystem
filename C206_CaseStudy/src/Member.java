
public class Member {
	
	private String name;
	private String gender;
	private int mobile_number;
	private String email;
	private int dob;
	private String residence;

	public Member(String name, String gender, int mobile_number, String email, int dob, 
			String residence) {
		this.name = name;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.email = email;
		this.dob = dob;
		this.residence = residence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDob() {
		return dob;
	}
	
	public void setDob(int dob) {
		this.dob = dob;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

}
