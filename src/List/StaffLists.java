package List;

import java.util.Date;

public class StaffLists {
	private int staffID;
	private String staffName;
	private Date joinDate;
	private String gender;
	private Date dateofBirth;
//	private String photo;
	private String phoneNo;
	private String presentAddress;
	private String password;
	private String designation;
	private int salary;
	private String adminID;
	private String adminName;
	private Date definedDate;
	private String userName;
	private int no;
	private String email;
	
	public StaffLists(String designation, int salary, String adminID, String adminName,
			Date definedDate) {
		super();
		this.designation = designation;
		this.salary = salary;
		this.adminID = adminID;
		this.adminName = adminName;
		this.definedDate = definedDate;
	}
	public StaffLists(int staffID, String staffName, Date joinDate, String gender, String phoneNo,int salary,String designation,String presentAddress,int no,String email) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.joinDate = joinDate;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.salary = salary;
		this.designation = designation;
		this.presentAddress = presentAddress;
		this.no = no;
		this.email = email;
	}
	
	public StaffLists(String email, String staffName, int salary) {
		super();
		this.email = email;
		this.staffName = staffName;
		this.salary = salary;
	}
	public StaffLists(int staffID, String staffName, Date joinDate, String gender, Date dateofBirth,
			String phoneNo, String presentAddress, String password,String userName,int salary,String designation,String adminID,String adminName,int no,String email) {
		super();
		this.staffID = staffID;
		this.staffName = staffName;
		this.joinDate = joinDate;
		this.gender = gender;
		this.dateofBirth = dateofBirth;
//		this.photo = photo;
		this.phoneNo = phoneNo;
		this.presentAddress = presentAddress;
		this.password = password;
		this.salary = salary;
		this.designation = designation;
		this.adminID = adminID;
		this.adminName = adminName;
		this.userName = userName;
		this.email = email;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
//	public String getPhoto() {
//		return photo;
//	}
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Date getDefinedDate() {
		return definedDate;
	}
	public void setDefinedDate(Date definedDate) {
		this.definedDate = definedDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	
}
