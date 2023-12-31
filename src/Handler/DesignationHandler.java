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

import List.DesignationLists;
import View.Login;


public class DesignationHandler {	
	
	public static ArrayList<DesignationLists> GetAllDesignation()
	{
		int no = 1;
		ArrayList<DesignationLists> designationLists = new ArrayList<DesignationLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select des.desid,des.desname,dess.max_salary,dess.min_salary,ad.adminID,ad.adminName,des.definedDate from designations as des join designationsalarys as dess on des.desid=dess.desid join admins as ad on dess.adminID=ad.adminID where dess.dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			
			DesignationLists d = new DesignationLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDate(7),no);
			designationLists.add(d);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return designationLists;
	}
	
	public static ArrayList<DesignationLists> GetDeisgnatonHistory(int desid)
	{
		int no = 1;
		ArrayList<DesignationLists> designationLists = new ArrayList<DesignationLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select des.desid,des.desname,dess.max_salary,dess.min_salary,ad.adminID,ad.adminName,des.definedDate from designations as des join designationsalarys as dess on des.desid=dess.desid join admins as ad on dess.adminID=ad.adminID where des.desid='"+desid+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			DesignationLists d = new DesignationLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDate(7),no);
			designationLists.add(d);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return designationLists;
	}
	public static DesignationLists GetDesignationData(int desid)
	{
		DesignationLists d = null;
		try {
			Connection con = DBConnection.openConnection();
			String q = "select des.desid,des.desname,dess.max_salary,dess.min_salary,ad.adminID,ad.adminName,des.definedDate from designations as des join designationsalarys as dess on des.desid=dess.desid join admins as ad on dess.adminID=ad.adminID where des.desid=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setInt(1, desid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			d = new DesignationLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDate(7),1);
			return d;
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}
	public static ArrayList<DesignationLists> FilterDesignation(String id,String name)
	{
		int no = 1;
		ArrayList<DesignationLists> designationLists = new ArrayList<DesignationLists>();	
		try {
			String q ="";
		Connection con = DBConnection.openConnection();
		q = "select des.desid,des.desname,dess.max_salary,dess.min_salary,ad.adminID,ad.adminName,des.definedDate from designations as des join designationsalarys as dess on des.desid=dess.desid join admins as ad on dess.adminID=ad.adminID where des.desname like '%"+name+"%' and des.desid like '%"+id+"%' and dess.dt='0'";
		
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			DesignationLists d = new DesignationLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getDate(7),no);
			designationLists.add(d);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return designationLists;
	}
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select desid from designations order by desid desc limit 1";
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
	public static DesignationLists GetMaxAndMinSalary(String desname)
	{
		try {
			Connection con = DBConnection.openConnection();
			String q = "select des.desid,dess.max_salary,dess.min_salary from designations as des join designationsalarys as dess on des.desid=dess.desid where des.desname=? and dess.dt=0";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, desname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			DesignationLists d = new DesignationLists(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			return d;
		}
		con.close();
		} catch (SQLException e) {
		}
		return null;
	}
	public static void AddNewDesignation(String desid,String desname,String maxSalary,String minSalary)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into designations (desname,definedDate) values(?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, desname);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	con = DBConnection.openConnection();
        q = "insert into designationsalarys (desid,adminID,max_salary,min_salary,definedDate) values(?,?,?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, desid);
		   ps.setString(2, Login.userid);
		   ps.setString(3, maxSalary);
		   ps.setString(4, minSalary);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public static void UpdateDesignationName(String desid,String desname)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update designations set desname='"+desname+"' where desid='"+desid+"'";
    	try {
		   PreparedStatement ps =con.prepareStatement(q);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateDesignationSalary(String desid,String maxSalary,String minSalary)
	{
		UpdateDesignationStatus(desid,2);
		Connection con = DBConnection.openConnection();
		String q = "";
    	con = DBConnection.openConnection();

        q = "insert into designationsalarys (desid,adminID,max_salary,min_salary,definedDate) values(?,?,?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1, desid);
		   ps.setString(2, Login.userid);
		   ps.setString(3, maxSalary);
		   ps.setString(4, minSalary);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public static int GetDesignationID(String desname)
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select desid from designations where desname='"+desname+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ID = rs.getInt(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return ID;
	}
	public static void UpdateDesignationStatus(String desid,int status)
	{
		Connection con = DBConnection.openConnection();
		String q = "";
    	con = DBConnection.openConnection();
    	
    	q = "update designationsalarys set dt='"+status+"' where desid='"+desid+"'"; //2 means update // 1 means delete // o means current
    	PreparedStatement psupdate;
		try {
			psupdate = con.prepareStatement(q);
	    	psupdate.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    
	}
	public static void DeleteDesgiantion(String desid)
	{
		Connection con = DBConnection.openConnection();
		String q = "";
    	con = DBConnection.openConnection();
    	
    	q = "update designationsalarys set dt='1' where desid='"+desid+"'"; //2 means update // 1 means delete // o means current
    	PreparedStatement psupdate;
		try {
			psupdate = con.prepareStatement(q);
	    	psupdate.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
