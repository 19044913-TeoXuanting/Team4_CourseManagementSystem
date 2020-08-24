

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19030425, 24 Aug 2020 2:40:17 pm
 */

public class CourseSchedule {
	private String Start;
	private String End;
	private int Price;
	private int Id;
	private String Location;

public CourseSchedule(String start,String End, int Price, int Id, String Location) {
	this.Start = start;
	this.End = End;
	this.Price = Price;
	this.Id = Id;
	this.Location = Location;
}

/**
 * @return the location
 */
public String getLocation() {
	return Location;
}

/**
 * @param location the location to set
 */
public void setLocation(String location) {
	Location = location;
}

/**
 * @return the start
 */

/**
 * @return the price
 */
public int getPrice() {
	return Price;
}

/**
 * @return the start
 */
public String getStart() {
	return Start;
}

/**
 * @param start the start to set
 */
public void setStart(String start) {
	Start = start;
}

/**
 * @return the end
 */
public String getEnd() {
	return End;
}

/**
 * @param end the end to set
 */
public void setEnd(String end) {
	End = end;
}

/**
 * @param price the price to set
 */
public void setPrice(int Price) {
	this.Price = Price;
}

/**
 * @return the id
 */
public int getId() {
	return Id;
}

/**
 * @param id the id to set
 */
public void setId(int Id) {
	this.Id = Id;
}
}
