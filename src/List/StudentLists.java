package List;
import java.util.*;
public class StudentLists {
	private int studentID;
	private String studentName;
	private String phoneNo;
	private String presentAddress;
	private int staffID;
	private String staffName;
	private Date joinDate;
	private int no;
	public StudentLists(int studentID, String studentName, String phoneNo, String presentAddress, int staffID,
			String staffName, Date joinDate,int no) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.phoneNo = phoneNo;
		this.presentAddress = presentAddress;
		this.staffID = staffID;
		this.staffName = staffName;
		this.joinDate = joinDate;
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
