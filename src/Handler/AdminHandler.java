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

import List.AdminLists;


public class AdminHandler {	
	public static boolean isAdmin(int id)
	{
		ArrayList<AdminLists> adminList = new ArrayList<AdminLists>();	
		try {
			Connection con = DBConnection.openConnection();
		String q = "select ad.adminName from admins as ad where ad.adminID=? and ad.Dt=?";
		PreparedStatement ps = con.prepareStatement(q);
	    ps.setInt(1, id);
		ps.setInt(2, -1);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {		
			return true;
		}
		con.close();
		} catch (SQLException e) {
		}
		return false;
	}
	public static ArrayList<AdminLists> GetAllAdmin(int status)
	{
		String gender = "";
		int no = 1;
		ArrayList<AdminLists> adminList = new ArrayList<AdminLists>();	
		try {
			Connection con = DBConnection.openConnection();
		String q = "select adminID,adminName,joinDate,gender,dateofBirth,phoneNo,presentAddress,password,userName,adminEmail from admins where dt="+status+"";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {		
			if(rs.getInt(4) == 0)
			{
				gender = "Male";
			}
			else
			{
				gender = "Female";
			}
			AdminLists ad = new AdminLists(rs.getInt(1),rs.getString(2),rs.getDate(3),gender,rs.getDate(5),"",rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),no,rs.getString(10));
			adminList.add(ad);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return adminList;
	}
	public static AdminLists GetAdminData(int adminID)
	{
		String gender = "";
		AdminLists ad = null;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select adminID,adminName,joinDate,gender,dateofBirth,phoneNo,presentAddress,password,username,adminEmail from admins where adminID =?" ;
		PreparedStatement ps = con.prepareStatement(q);
		ps.setInt(1, adminID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			if(rs.getInt(4) == 0)
			{
				gender = "Male";
			}
			else
			{
				gender = "Female";
			}
			ad = new AdminLists(rs.getInt(1),rs.getString(2),rs.getDate(3),gender,rs.getDate(5),"",rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),1,rs.getString(10));
			return ad;
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ad;
	}
	public static ArrayList<AdminLists> FilterAdmin(String email,String name,int status)
	{
		int no = 1;
		ArrayList<AdminLists> adminList = new ArrayList<AdminLists>();	
		try {
		Connection con = DBConnection.openConnection();
		String q = "";
		q = "select adminID,adminName,joinDate,gender,dateofBirth,phoneNo,presentAddress,password,userName,adminEmail from admins where adminEmail like '%"+email+"%' and adminName like '%"+name+"%' and dt='"+status+"'" ;
			
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			AdminLists ad = null;
			if(rs.getInt(4) == 0)
			{
				ad = new AdminLists(rs.getInt(1),rs.getString(2),rs.getDate(3),"Male",rs.getDate(5),"",rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),no,rs.getString(10));
			}
			else
			{
				ad = new AdminLists(rs.getInt(1),rs.getString(2),rs.getDate(3),"Female",rs.getDate(5),"",rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),no,rs.getString(10));
			}
			adminList.add(ad);
			no++;
		}
		con.close();
		} catch (SQLException e) {
		}
		return adminList;
	}
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select adminID from admins";
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
	public static void AddNewAdmin(String name,String joinDate,String gender,String dob,String phoneNo,String presentAddress,String password,String userName,String email)
	{
		
		Connection con = DBConnection.openConnection();
		
		if(gender.equals("Male"))
		{
			gender = 0+"";
		}
		else
		{
			gender =  1+"";
		}
		String q;
        q = "insert into admins(adminName,gender,phoneNo,presentAddress,password,userName,joinDate,dateofBirth,adminEmail) VALUES (?,?,?,?,?,?,?,?,?)";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, name);
		   ps.setString(2, gender);
		   ps.setString(3,phoneNo);
		   ps.setString(4, presentAddress);
		   ps.setString(5, password);
		   ps.setString(6, userName);
		   ps.setString(7, joinDate);
		   ps.setString(8, dob);
		   ps.setString(9, email);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean UpdateAdmin(int adminID,String name,String joinDate,String gender,String dob,String phoneNo,String presentAddress,String password,String userName,String email)
	{
		
		Connection con = DBConnection.openConnection();
		
		if(gender.equals("Male"))
		{
			gender = 0+"";
		}
		else
		{
			gender =  1+"";
		}
		String q;
		
        q = "update admins set adminName=?,gender=?,phoneNo=?,presentAddress=?,password=?,userName=?,joinDate=?,dateofBirth=?,adminEmail=? where adminID='"+adminID+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, name);
		   ps.setString(2, gender);
		   ps.setString(3,phoneNo);
		   ps.setString(4, presentAddress);
		   ps.setString(5, password);
		   ps.setString(6, userName);
		   ps.setString(7, joinDate);
		   ps.setString(8, dob);
		   ps.setString(9, email);
           ps.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static boolean UpdateAdminData(int adminID,String name,String joinDate,String gender,String dob,String phoneNo,String presentAddress,String password,String userName)
	{
		
		Connection con = DBConnection.openConnection();
		
		if(gender.equals("Male"))
		{
			gender = 0+"";
		}
		else
		{
			gender =  1+"";
		}
		String q;
		
        q = "update admins set adminName=?,gender=?,phoneNo=?,presentAddress=?,password=?,userName=?,joinDate=?,dateofBirth=? where adminID='"+adminID+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, name);
		   ps.setString(2, gender);
		   ps.setString(3,phoneNo);
		   ps.setString(4, presentAddress);
		   ps.setString(5, password);
		   ps.setString(6, userName);
		   ps.setString(7, joinDate);
		   ps.setString(8, dob);
           ps.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void DeleteAdmin(String adminID)
	{
		
		Connection con = DBConnection.openConnection();
		String q;
        q = "update admins set dt='1' where adminID='"+adminID+"'";
    	try {
		  PreparedStatement ps =con.prepareStatement(q);
		  ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean IsEmailValid(String email)
	{
		Connection con = DBConnection.openConnection();
		String q = "select adminEmail from admin where adminEmail='"+email+"'";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
