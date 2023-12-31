package List;

import java.util.Date;

import javafx.scene.control.Button;

public class AdminLists {
	private int adminID;
	private String adminName;
	private Date joinDate;
	private String gender;
	private Date dateofBirth;
	private String photo;
	private String phoneNo;
	private String presentAddress;
	private String password;
	private String userName;
	private String email;
	private int no;
	public AdminLists(int adminID, String adminName, Date joinDate, String gender, String phoneNo,int no) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.joinDate = joinDate;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.no = no;
	}
	
	public AdminLists(int adminID, String adminName, Date joinDate, String gender, Date dateofBirth, String photo,
			String phoneNo, String presentAddress, String password,String userName,int no,String email) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.joinDate = joinDate;
		this.gender = gender;
		this.dateofBirth = dateofBirth;
		this.photo = photo;
		this.phoneNo = phoneNo;
		this.presentAddress = presentAddress;
		this.password = password;
		this.userName = userName;
		this.no = no;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
