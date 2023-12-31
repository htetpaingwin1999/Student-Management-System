package List;

import java.util.Date;

public class DesignationLists {
	private int designationID;
	private String designationName;
	private int maxSalary;
	private int minSalary;
	private Date addDate;
	private int adminID;
	private String adminName;
	private int no;
	
	public DesignationLists(int designationID, String designationName, int maxSalary, int minSalary,int adminID, String adminName,Date addDate,int no) {
		super();
		this.designationID = designationID;
		this.designationName = designationName;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.addDate = addDate;
		this.adminID = adminID;
		this.adminName = adminName;
		this.no = no;
	}
	
	public DesignationLists(int designationID, int maxSalary, int minSalary) {
		super();
		this.designationID = designationID;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDesignationID() {
		return designationID;
	}

	public void setDesignationID(int designationID) {
		this.designationID = designationID;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
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
