package List;

public class CourseStudentReportLists {
	private int id;
	private String courseName;
	private int no;
	public CourseStudentReportLists(int no, String courseName, int id) {
		super();
		this.id = id;
		this.courseName = courseName;
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
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
}
