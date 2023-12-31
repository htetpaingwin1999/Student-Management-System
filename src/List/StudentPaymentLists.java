package List;
import java.util.*;
public class StudentPaymentLists {
	private int fpid;
	private int studentID;
	private String studentName;
	private String courseName;
	private int courseFee;
	private int paidAmount;
	private Date addDate;
	private int staffID;
	private String staffName;
	public StudentPaymentLists(int fpid, int studentID, String studentName, String courseName, int courseFee,
			int paidAmount, Date addDate, int staffID, String staffName) {
		super();
		this.fpid = fpid;
		this.studentID = studentID;
		this.studentName = studentName;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.paidAmount = paidAmount;
		this.addDate = addDate;
		this.staffID = staffID;
		this.staffName = staffName;
	}
	public int getFpid() {
		return fpid;
	}
	public void setFpid(int fpid) {
		this.fpid = fpid;
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
	public int getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
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
	
	
	

	
}
