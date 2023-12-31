package Handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import List.CourseStudentLists;
import List.StudentPaymentLists;

public class CourseStudentHandler {

	public static ArrayList<CourseStudentLists> GetAllCourseStudents() // it is only intend for feepayment
	{
		ArrayList<CourseStudentLists> studentList = new ArrayList<CourseStudentLists>();	
		try {
			int no = 1;
			Connection con = DBConnection.openConnection();
		String q = "select cs.csid,c.cname,cf.cfee,st.studentID,st.studentName,cs.addDate,sum(fp.amount),fp.fpid,cf.cfid from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID where cs.dt='0' and fp.dt='0' group by cs.csid";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
		CourseStudentLists cs = new  CourseStudentLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDate(6),no,rs.getInt(7),rs.getInt(8),rs.getInt(9));
			no++;
			studentList.add(cs);
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	
	
	public static ArrayList<CourseStudentLists> FilterCourseStudents(String studentID,String studentName,String cname) // it is only intend for feepayment
	{
		ArrayList<CourseStudentLists> studentList = new ArrayList<CourseStudentLists>();	
		try {
		int no = 1;
		Connection con = DBConnection.openConnection();
		String q = "select cs.csid,c.cname,cf.cfee,st.studentID,st.studentName,cs.addDate,sum(fp.amount),fp.fpid,cf.cfid from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID where cs.dt='0' and fp.dt='0' and st.studentID like '%"+studentID+"%' and st.studentName like '%"+studentName+"%' and c.cname like '%"+cname+"%'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			CourseStudentLists cs = new  CourseStudentLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDate(6),no,rs.getInt(7),rs.getInt(8),rs.getInt(9));
			no++;
			studentList.add(cs);
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	
	
	
	
	public static void RemoveCourseStudent(int csid) // Remove student from course
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update coursestudents set dt='1' where csid='"+csid+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
           ps.executeUpdate();
           
           q = "update feepayments set dt='1' where csid='"+csid+"'";
   		   ps =con.prepareStatement(q);
           ps.executeUpdate();
		   con.close();
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void RemoveSection(int cfid,int studentID) // Remove student from course
	{
		Connection con = DBConnection.openConnection();
		String q;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int no = 0;
        try {
         q = "select ss.ssid from sectionstudents as ss join sections as s on ss.sid=s.sid join coursefees as cf on s.cfid=cf.cfid join students as st on ss.studentID=st.studentID join courses as c on cf.cid=c.cid where cf.cfid='"+cfid+"' and ss.studentID='"+studentID+"' and ss.dt='0'";
        PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			arr.add(rs.getInt(1));
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        con = DBConnection.openConnection();
        try {
       for(int i = 0; i<arr.size();i++)
       {
    	q = "update sectionstudents set dt='1' where ssid='"+arr.get(i)+"'";
        PreparedStatement ps = con.prepareStatement(q);
   		ps.executeUpdate();
       }
        	
   		con.close();
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
        
        
	}
	
}
