package List;

import java.sql.Date;

public class SectionStudentLists {
	private int ssid;
	private int studentID;
	private String studentName;
	private int staffID;
	private String staffName;
	private Date addDate;	
	private int no;
	private String courseName;
	private String courseFee;
	public SectionStudentLists(int ssid, int studentID, String studentName, int staffID, String staffName,
			Date addDate,int no) {
		super();
		this.ssid = ssid;
		this.studentID = studentID;
		this.studentName = studentName;
		this.staffID = staffID;
		this.staffName = staffName;
		this.addDate = addDate;
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
}
