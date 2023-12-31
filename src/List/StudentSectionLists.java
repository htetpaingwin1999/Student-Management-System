package List;
import java.util.*;
public class StudentSectionLists {
	private String studentID;
	private String studentName;
	private String sectionTitle;
	private String courseName;
	private String teacherName;
	private int coursFee;
	private Date addDate;
	private String staffName;
	public StudentSectionLists(String studentID, String studentName, String sectionTitle, String courseName,
			String teacherName, int coursFee, Date addDate, String staffName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.sectionTitle = sectionTitle;
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.coursFee = coursFee;
		this.addDate = addDate;
		this.staffName = staffName;
	}
	
}
