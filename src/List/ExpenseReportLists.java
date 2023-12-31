package List;
import java.util.*;
public class ExpenseReportLists {
	private int id;
	private int amount;
	private String addDate;
	private String catName; //Expense Category Name
	private int no;
	
	public ExpenseReportLists(int id,int amount,String catName,String addDate,int no) {
		super();
		this.id = id;
		this.addDate = addDate;
		this.catName = catName;
		this.amount = amount;
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
