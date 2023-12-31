package List;

import java.util.Date;

public class ExpenseCategoryLists {
	private int expenseCategoryID;
	private String expenseCategoryName;
	private Date addDate;
	private int adminID;
	private String adminName;
	private int no;
	
	public ExpenseCategoryLists(int expenseCategoryID, String expenseCategoryName, int adminID, String adminName,Date addDate,int no) {
		super();
		this.expenseCategoryID = expenseCategoryID;
		this.expenseCategoryName = expenseCategoryName;
		this.addDate = addDate;
		this.adminID = adminID;
		this.adminName = adminName;
		this.no = no;
	}

	public int getExpenseCategoryID() {
		return expenseCategoryID;
	}

	public void setExpenseCategoryID(int expenseCategoryID) {
		this.expenseCategoryID = expenseCategoryID;
	}

	public String getExpenseCategoryName() {
		return expenseCategoryName;
	}

	public void setExpenseCategoryName(String expenseCategoryName) {
		this.expenseCategoryName = expenseCategoryName;
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	
}
