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
import List.StudentPaymentLists;
import View.Login;


public class CourseHandler {	
	
	public static ArrayList<String> GetAllCourseName(int dt)
	{
		ArrayList<String> courseName = new ArrayList<String>();
		try {
			Connection con = DBConnection.openConnection();
			String q = "select cName from courses where dt='"+dt+"'";
			if(dt==2)
			{
				q = "select cName from courses group by cName";
			}
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String name = rs.getString(1);
				courseName.add(name);
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseName;
	}
	
	public static int  GetNoofCourses()
	{
		try {
			Connection con = DBConnection.openConnection();
			String q = "select count(*) from courses where dt='0'";
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return rs.getInt(1);
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public static ArrayList<CourseLists> GetAllCourse() // Current Course
	{
		int no = 1;
		ArrayList<CourseLists> courseLists = new ArrayList<CourseLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select c.cid,c.cName,cf.cFee,c.definedDate,ad.adminID,ad.adminName from courses as c join coursefees as cf on cf.cid=c.cid join admins as ad on cf.adminID=ad.adminID and c.definedDate=cf.definedDate where c.dt=0 and cf.dt='0' group by c.cid";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {	
			CourseLists c = new CourseLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getInt(5),rs.getString(6),no);
			no++;
			courseLists.add(c);
		}
		con.close();
		} catch (SQLException e) {
		}
		return courseLists;
	}
	
	public static ArrayList<CourseLists> GetDeletePlusCurrentCourse() // Detelete Course + Current course;
	{
		ArrayList<CourseLists> courseLists = new ArrayList<CourseLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select c.cid,c.cName,cf.cFee,c.definedDate,ad.adminID,ad.adminName from courses as c join coursefees as cf on cf.cid=c.cid join admins as ad on cf.adminID=ad.adminID and c.definedDate=cf.definedDate group by c.cName";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {	
			CourseLists c = new CourseLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getInt(5),rs.getString(6),1);
			courseLists.add(c);
		}
		con.close();
		} catch (SQLException e) {
		}
		return courseLists;
	}
	
	public static ArrayList<CourseLists> GetCourseHistory(int cid)
	{
		int no = 1;
		ArrayList<CourseLists> courseLists = new ArrayList<CourseLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select c.cid,c.cName,cf.cFee,cf.definedDate,ad.adminID,ad.adminName from courses as c join coursefees as cf on cf.cid=c.cid join admins as ad on cf.adminID=ad.adminID where c.cid='"+cid+"' order by cf.definedDate desc";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {	
			CourseLists c = new CourseLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getInt(5),rs.getString(6),no);
			courseLists.add(c);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return courseLists;
	}
	public static CourseLists GetCourseData(int did)
	{	
		CourseLists c = null;
		try {
			Connection con = DBConnection.openConnection();
			String q = "select c.cid,c.cName,cf.cFee,c.definedDate,ad.adminID,ad.adminName from courses as c join coursefees as cf on cf.cid=c.cid join admins as ad on cf.adminID=ad.adminID and c.definedDate=cf.definedDate group by c.cid where cid=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			c = new CourseLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getInt(5),rs.getString(6),1);
			return c;
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	public static ArrayList<CourseLists> FilterCourse(String id,String name)
	{
		int no = 1;
		ArrayList<CourseLists> courseLists = new ArrayList<CourseLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q ="";
		q= "select c.cid,c.cName,cf.cFee,c.definedDate,ad.adminID,ad.adminName from courses as c join coursefees as cf on cf.cid=c.cid and cf.definedDate=c.definedDate join  admins as ad on cf.adminID=ad.adminID where c.cid like '%"+id+"%' and c.cname like '%"+name+"%' and cf.dt='0' and c.dt='0' order by c.cid";

		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			CourseLists c = new CourseLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getInt(5),rs.getString(6),no);
			no++;
			courseLists.add(c);
		}
		con.close();
		} catch (SQLException e) {
		}
		return courseLists;
	}
	
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select cid from courses";
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
	public static int GetUpdatedCourseFee(String cName)
	{

		try {
			Connection con = DBConnection.openConnection();
		String q = "select cf.cFee from courses as c join coursefees as cf on c.cid=cf.cid where c.cName=? limit 1";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, cName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			return rs.getInt(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return 0;
	}
	
	public static int GetUpdatedCourseFeeID(String cid)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "select cf.cfid from coursesfees as cf join courses as c on cf.cid=c.cid and cf.definedDate=c.definedDate where c.cid='"+cid+"'";
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
	public static int GetCourseID(String cName,int fee)
	{
		//fee means where it taking fee data or course id
		try {
			Connection con = DBConnection.openConnection();
			String q = null;
		
			q = "select cf.cfid from coursefees as cf join courses as c on cf.cid=c.cid where c.cName=? order by cf.cfid desc limit 1";
		
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, cName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			return rs.getInt(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return 0;
	}
	public static void AddNewCourse(int cid,String cName,int cFee,String adminID)
	{
		
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into courses (cName,definedDate) values(?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, cName);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	con = DBConnection.openConnection();
        q = "insert into coursefees (cfee,adminID,cid,definedDate) values(?,?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setInt(1, cFee);
		   ps.setString(2, adminID);
		   ps.setInt(3, cid);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void DeleteCourse(int cid)
	{
		Connection con = DBConnection.openConnection();
		String q= "";
		q = "update courses set dt='1' where cid='"+cid+"'";
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
		     con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void UpdateCourseName(int cid,String name)
	{
		Connection con = DBConnection.openConnection();
		String q= "";
		q = "update courses set cName='"+name+"' where cid='"+cid+"'";
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
		     con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateCourseFee(String cid,String fee)
	{	
		Connection con = DBConnection.openConnection();
		String q= "";
		q = "update courses set definedDate=now() where cid='"+cid+"'";
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
		     con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		con = DBConnection.openConnection();
		q = "update coursefees set dt='2' where cid='"+cid+"'";
		try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
		     
		   
	     q = "insert into coursefees (cfee,adminID,cid,definedDate) values(?,?,?,now())";
	     ps =con.prepareStatement(q);
	     ps.setString(1, fee);
	     ps.setString(2, Login.userid);
	     ps.setString(3, cid);
	     ps.executeUpdate();
		     con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
