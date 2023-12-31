package List;

import java.util.Date;

public class SalaryLists {
	private String staffEmail;
	private String staffName;
	private Date payDate;
	private int salary;
	private int amount;
	private String note;
	private int adminID;
	private String adminName;
	private int meid;
	private int no;
	
	public SalaryLists(String staffEmail, String staffName, Date payDate, int salary, int amount, String note,
			int adminID, String adminName,int meid,int no) {
		super();
		this.staffEmail = staffEmail;
		this.staffName = staffName;
		this.payDate = payDate;
		this.salary = salary;
		this.amount = amount;
		this.note = note;
		this.adminID = adminID;
		this.adminName = adminName;
		this.meid = meid;
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMeid() {
		return meid;
	}
	public void setMeid(int meid) {
		this.meid = meid;
	}
	
	
	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
