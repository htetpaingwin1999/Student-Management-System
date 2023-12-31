package List;
import java.util.*;

public class SectionLists {
	private int sectionID;
	private int courseID;
	private String courseName;
	private int courseFee;
	private Date startDate;
	private Date endDate;
	private String firstDay;
	private String firstTime;
	private String secondDay;
	private String secondTime;
	private String adminName;
	private int adminID;
	private String staffName;
	private int staffID;
	private Date definedDate;
	private String cfid;
	private int noOfStudent;
	private int no;
	public SectionLists(int sectionID, int courseID, String courseName, int courseFee, Date startDate, Date endDate,
			String firstDay, String firstTime, String secondDay, String secondTime, int adminID,String adminName,
			int staffID,String staffName, Date definedDate, String cfid,int no) {
		super();
		this.sectionID = sectionID;
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.firstDay = firstDay;
		this.firstTime = firstTime;
		this.secondDay = secondDay;
		this.secondTime = secondTime;
		this.adminName = adminName;
		this.adminID = adminID;
		this.staffName = staffName;
		this.staffID = staffID;
		this.definedDate = definedDate;
		this.cfid = cfid;
		this.no = no;
	}
	public SectionLists(int sectionID, int courseID, String courseName, int courseFee, Date startDate, Date endDate,
			String firstDay, String firstTime, String secondDay, String secondTime, int adminID,String adminName,
			int staffID,String staffName, Date definedDate, String cfid,int noOfStudent,int no) {
		super();
		this.sectionID = sectionID;
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.firstDay = firstDay;
		this.firstTime = firstTime;
		this.secondDay = secondDay;
		this.secondTime = secondTime;
		this.adminName = adminName;
		this.adminID = adminID;
		this.staffName = staffName;
		this.staffID = staffID;
		this.definedDate = definedDate;
		this.cfid = cfid;
		this.noOfStudent = noOfStudent;
		this.no = no;
	}
	
	public SectionLists(int sectionID, int courseID,String courseName,int courseFee,int no) {
		super();
		this.sectionID = sectionID;
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseFee =courseFee;
		this.no = no;
	}
	

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNoOfStudent() {
		return noOfStudent;
	}

	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}

	public int getSectionID() {
		return sectionID;
	}
	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getFirstDay() {
		return firstDay;
	}
	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	public String getSecondDay() {
		return secondDay;
	}
	public void setSecondDay(String secondDay) {
		this.secondDay = secondDay;
	}
	public String getSecondTime() {
		return secondTime;
	}
	public void setSecondTime(String secondTime) {
		this.secondTime = secondTime;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public Date getDefinedDate() {
		return definedDate;
	}
	public void setDefinedDate(Date definedDate) {
		this.definedDate = definedDate;
	}
	public String getCfid() {
		return cfid;
	}
	public void setCfid(String cfid) {
		this.cfid = cfid;
	}
	
	
}
