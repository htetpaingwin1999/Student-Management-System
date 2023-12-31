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

import List.DepartmentLists;


public class DepartmentHandler {	
	
	public static ArrayList<DepartmentLists> GetAllDepartment()
	{
		int no = 1;
		ArrayList<DepartmentLists> departmentLists = new ArrayList<DepartmentLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select d.did,d.dname,ad.adminID,ad.adminName,d.addDate from departments as d join admins as ad on d.adminID=ad.adminID where d.dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			DepartmentLists d = new DepartmentLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDate(5),no);
			no++;
			departmentLists.add(d);
		}
		con.close();
		} catch (SQLException e) {
		}
		return departmentLists;
	}
	public static DepartmentLists GetDepartmentData(int did)
	{
		
		
		DepartmentLists ad = null;
		try {
			Connection con = DBConnection.openConnection();
			String q = "select d.did,d.dname,ad.adminID,ad.adminName,d.addDate from departments as d join admins as ad on d.adminID=ad.adminID where d.did= ?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setInt(1, did);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			DepartmentLists d = new DepartmentLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDate(5),1);
			return ad;
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ad;
	}
	public static ArrayList<DepartmentLists> FilterDepartment(String id,String name)
	{
		ArrayList<DepartmentLists> departmentLists = new ArrayList<DepartmentLists>();	
		try {
		Connection con = DBConnection.openConnection();
		String q ="";
		int no = 1;
		q = "select d.did,d.dname,ad.adminID,ad.adminName,d.addDate from departments as d join admins as ad on d.adminID=ad.adminID where d.did like '%"+id+"%' and d.dname like '%"+name+"%' and d.dt='0'";	
			
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			DepartmentLists d = new DepartmentLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDate(5),no);
			departmentLists.add(d);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return departmentLists;
	}
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select did from departments";
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
	public static int GetID(String name)
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select did from departments where dname= '"+name+"'";
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
	public static void AddNewDepartment(String name,int adminID)
	{
		
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into departments (dname,adminID,addDate) values(?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, name);
		   ps.setInt(2, adminID);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateDepartment(String name,int did ,int adminID)
	{
		
		Connection con = DBConnection.openConnection();
		String q;
        q = "update departments set dname='"+name+"',adminID='"+adminID+"' where did='"+did+"'";
    	try {
		   PreparedStatement ps =con.prepareStatement(q);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteDepartment(int did)
	{
		
		Connection con = DBConnection.openConnection();
		String q;
        q = "update departments set dt='1' where did='"+did+"'";
    	try {
		   PreparedStatement ps =con.prepareStatement(q);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
