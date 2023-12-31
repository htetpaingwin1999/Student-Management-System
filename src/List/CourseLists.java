package List;

import java.util.Date;

public class CourseLists {
	private int courseID;
	private String courseName;
	private int courseFee;
	private Date definedDate;
	private int adminID;
	private String adminName;
	private int no;

	public CourseLists(int courseID, String courseName, int courseFee, Date definedDate, int adminID,
			String adminName,int no) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.definedDate = definedDate;
		this.adminID = adminID;
		this.adminName = adminName;
		this.no = no;
	}
	
	public CourseLists(int courseID, int courseFee) {
		super();
		this.courseID = courseID;
		this.courseFee = courseFee;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	public Date getDefinedDate() {
		return definedDate;
	}
	public void setDefinedDate(Date definedDate) {
		this.definedDate = definedDate;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}
