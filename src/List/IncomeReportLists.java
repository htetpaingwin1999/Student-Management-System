package List;
import java.util.*;
public class IncomeReportLists {
	private int id;
	private String courseName;
	private String addDate;
	private int amount;
	private int no;
	public IncomeReportLists(int id,  int amount,String courseName, String addDate,int no) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.addDate = addDate;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}