package List;

import java.util.Date;

public class ExpenseLists {
	private int no;
	private int expenseID;
	private int amount;
	private String note; // may be salary for staff or may be null
	private int expenseCategoryID; // may be zero for salary payment or any other number for other exepense category
	private String expenseCategoryName; // may be salary payment or other name
	private Date addDate; 
	private int adminID;
	private String adminName;
	
	public ExpenseLists(int expenseID, int amount, String note, int expenseCategoryID,
			String expenseCategoryName,int adminID, String adminName,Date addDate,int no) {
		super();
		this.expenseID = expenseID;
		this.amount = amount;
		this.note = note;
		this.expenseCategoryID = expenseCategoryID;
		this.expenseCategoryName = expenseCategoryName;
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


	public int getExpenseID() {
		return expenseID;
	}

	public void setExpenseID(int expenseID) {
		this.expenseID = expenseID;
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
	
}
