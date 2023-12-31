package Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import List.AdminLists;

public class AccountHandler {
	public static boolean IsAdmin(String email,String password)
	{
		try {
			
			Connection con = DBConnection.openConnection();
		String q = "select 1 from admins as ad where ad.adminEmail='"+email+"' and binary ad.password='"+password+"' and ad.dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {		
			return true;
		}
		con.close();
		} catch (SQLException e) {
		}
		return false;
	}
	public static String AdminUsername(String id)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "select username from admins as ad where ad.adminID='"+id+"'";// and ad.password='"+password+"' and ad.dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {		
			return rs.getString(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return "Unknown";
	}
	
	public static void UpdateAdminPassword(String id,String password)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "update admins set password='"+password+"' where adminID='"+id+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		} catch (SQLException e) {
		}
	}
	
	public static void UpdateStaffUsername(String id,String username)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "update staffs set username='"+username+"' where staffID='"+id+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		} catch (SQLException e) {
		}
	}
	

	public static void UpdateAdminUsername(String id,String username)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "update admins set username='"+username+"' where adminID='"+id+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		} catch (SQLException e) {
		}
	}
	
	public static void UpdateStaffPassword(String id,String password)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "update staffs set password='"+password+"' where staffID='"+id+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		} catch (SQLException e) {
		}
	}
	
	public static boolean IsStaff(String email,String password)
	{
		try {
			Connection con = DBConnection.openConnection();
			String q = "select 1 from staffs as st where st.staffEmail='"+email+"' and binary st.password='"+password+"' and st.dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {		
			return true;
		}
		con.close();
		} catch (SQLException e) {
		}
		return false;
	}
	public static String StaffUsername(String id)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "select username from staffs as st where st.staffID='"+id+"'";// and ad.password='"+password+"' and ad.dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {		
			return rs.getString(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return "Unknown";
	}
	
	public static void SuspendAdminAccount(String id,int state)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "update admins set dt='"+(state)+"' where adminID='"+id+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		} catch (SQLException e) {
		}
	}
	
	public static void SuspendStaffAccount(String id,int state)
	{
		try {
			Connection con = DBConnection.openConnection();
			String q = "update staffs set dt='"+(state)+"' where staffID='"+id+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		} catch (SQLException e) {
		}
	}
	
	public static int  GetAdminIDFromEmail(String email)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = " select adminID from admins where adminEmail='"+email+"'";
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
	
	public static int  GetStaffIDFromEmail(String email)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = " select staffID from staffs where staffEmail='"+email+"'";
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
}
