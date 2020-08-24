import java.time.LocalDateTime;
public class register {
	
		private int registrationNum;
		private int courseID;
		private String email;
		private String status;
		private LocalDateTime dt;
		
		public register(int registrationNum, int courseID, String email) {
			this.registrationNum = registrationNum;
			this.courseID = courseID;
			this.email = email;
			this.status = "Pending";
			this.dt = LocalDateTime.now();
			
		}

		public int getRegistrationNum() {
			return registrationNum;
		}

		public void setRegistrationNum(int registrationNum) {
			this.registrationNum = registrationNum;
		}

		public int getCourseID() {
			return courseID;
		}

		public void setCourseID(int courseID) {
			this.courseID = courseID;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public LocalDateTime getDt() {
			return dt;
		}

		public void setDt(LocalDateTime dt) {
			this.dt = dt;
		}
		
		
		
	}


