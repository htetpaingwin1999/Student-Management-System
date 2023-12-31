package List;

import java.util.Date;

public class DepartmentLists {
	private int departmentID;
	private String departmentName;
	private Date addDate;
	private int adminID;
	private String adminName;
	private int no;
	public DepartmentLists(int departmentID, String departmentName, int adminID, String adminName,Date addDate,int no) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.addDate = addDate;
		this.adminID = adminID;
		this.adminName = adminName;
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
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
