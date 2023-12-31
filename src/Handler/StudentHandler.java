package Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import List.CourseLists;
import List.StudentLists;
import List.StudentPaymentLists;


public class StudentHandler {	
	public static String GetStudentName(String id)
	{		
		try {
			Connection con = DBConnection.openConnection();
			String q = "select studentName from students where studentID=? and dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			return rs.getString(1);
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Unknown";
	}
	public static ArrayList<StudentLists> GetAllStudent()
	{
		int no = 1 ;
		ArrayList<StudentLists> studentList = new ArrayList<StudentLists>();	
		try {
			Connection con = DBConnection.openConnection();
		String q = " select st.studentID,st.studentName,st.phoneNo,st.presentAddress,s.staffID,s.staffName,st.registerDate from students as st join staffs as s on st.staffID=s.staffID where st.dt=0";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			StudentLists stf = new StudentLists(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7),no);
			studentList.add(stf);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	
	public static int GetNoofStudent()
	{
		try {
			Connection con = DBConnection.openConnection();
		String q ="select count(*) from students where dt='"+0+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			return rs.getInt(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return 0;
	}
	public static StudentLists GetStudentData(int studentID)
	{		
		StudentLists stf = null;
		try {
			Connection con = DBConnection.openConnection();
		String q = " select st.studentID,st.studentName,st.phoneNo,st.presentAddress,s.staffID,s.staffName,st.registerDate from students as st join staffs as s on st.staffID=s.staffID where st.studentID=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setInt(1, studentID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			 stf = new StudentLists(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7),1);
			return stf;
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stf;
	}
	public static ArrayList<StudentLists> FilterStudent(String id,String name,String phoneNo)
	{
		ArrayList<StudentLists> studentList = new ArrayList<StudentLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "";
			int no = 0;
		q = " select st.studentID,st.studentName,st.phoneNo,st.presentAddress,s.staffID,s.staffName,st.registerDate from students as st join staffs as s on st.staffID=s.staffID where st.dt='0' and st.studentID like '%"+id+"%' and st.studentName like '%"+name+"%' and st.phoneNo like '%"+phoneNo+"%'";
			
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			StudentLists stf = new StudentLists(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7),no);
			no++;
			studentList.add(stf);
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select studentID from students";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ID = rs.getInt(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return ID+1;
	}
	public static int GetStudentID(String sname)
	{		
		try {
			Connection con = DBConnection.openConnection();
			String q = "select studentID from students where studentName=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, sname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			return rs.getInt(1);
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void AddNewStudent(String name,String phoneNo,String presentAddress,int staffID)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into students(studentName,phoneNo,presentAddress,staffID,registerDate) VALUES (?,?,?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1, name);
		   ps.setString(2, phoneNo);
		   ps.setString(3, presentAddress);
		   ps.setInt(4, staffID);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateStudent(String id,String name,String phoneNo,String presentAddress,int staffID)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update students set studentName=?,phoneNo=?,presentAddress=?,staffID=? where studentID='"+id+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1, name);
		   ps.setString(2, phoneNo);
		   ps.setString(3, presentAddress);
		   ps.setInt(4, staffID);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Delete(String id)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update students set dt='1' where studentID='"+id+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void AddNewPayment(String amount,int staffID)
	{
		System.out.println("Course Student ID "+ GetNewCourseStudentID());
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into feepayments(csid,staffID,amount,addDate) VALUES (?,?,?,now())";
        
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1, GetNewCourseStudentID()+"");
		   ps.setInt(2, staffID);
		   ps.setString(3, amount);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void AddPerPayment(String csid,String amount,String userid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into feepayments(csid,staffID,amount,addDate) VALUES (?,?,?,now())";
        
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1,csid);
		   ps.setString(2, userid);
		   ps.setString(3, amount);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void JoinSection(String id,String secid,String staffID)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into sectionstudents(sid,studentID,staffID,addDate) VALUES (?,?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1, secid);
		   ps.setString(2, id);
		   ps.setString(3, staffID);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void JoinCourseStudent(String id,String cfid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into coursestudents (cfid,studentID,addDate) VALUES (?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1, cfid);
		   ps.setString(2, id);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isJoinSection(String id,String secid)
	{
		Connection con = DBConnection.openConnection();
		String q = "select * from sectionstudents where studentID='"+id+"' and sid='"+secid+"' and dt='0'";
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
			con.close();
			} catch (SQLException e) {
			}
		return false;
	}
	
	public static int GetNewCourseStudentID()
	{
		Connection con = DBConnection.openConnection();
		String q = "select csid from coursestudents order by csid desc limit 1";
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		  
		   ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			con.close();
			} catch (SQLException e) {
			}
		return 0;
	}
	
	public static boolean isExistedStudentToThisCourse(String id,String cid)
	{
		Connection con = DBConnection.openConnection();
		String q = " select 1 from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID where c.cid='"+cid+"'  and st.studentID='"+id+"' and cs.dt='0'";
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
			con.close();
			} catch (SQLException e) {
			}
		return false;
	}
	
	
//	public static int GetCourseStudentID(String id,String cname)
//	{
//		
//		Connection con = DBConnection.openConnection();
//		String q = " select csid from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID where c.cname='"+cname+"'  and st.studentID='"+id+"' limit 1";
//		try {
//		     PreparedStatement ps =con.prepareStatement(q);
//		   ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				return rs.getInt(1);
//			}
//			con.close();
//			} catch (SQLException e) {
//			}
//		return 0;
//	}
	
}
