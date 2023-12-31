package List;

import java.sql.Date;

public class CourseStudentLists {
	private int csid;
	private String cname;
	private int fee;
	private int stid;
	private String stname;
	private Date addDate;
	private int no;
	private int total;
	private int fpid;
	private int cfid;
	public CourseStudentLists(int csid, String cname, int fee, int stid, String stname,
			Date addDate, int no,int total,int fpid,int cfid) {
		super();
		this.csid = csid;
		this.cname = cname;
		this.fee = fee;
		this.stid = stid;
		this.stname = stname;
		this.addDate = addDate;
		this.no = no;
		this.total = total;
		this.fpid = fpid;
		this.cfid = cfid;
	}
	
	
	public int getCfid() {
		return cfid;
	}


	public void setCfid(int cfid) {
		this.cfid = cfid;
	}


	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getFpid() {
		return fpid;
	}

	public void setFpid(int fpid) {
		this.fpid = fpid;
	}

	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	
	
	
}
