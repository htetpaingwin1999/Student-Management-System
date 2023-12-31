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

import List.StaffLists;
import View.Login;


public class StaffHandler {	
	public static boolean IsStaff(int id)
	{
		try {
			System.out.print(id);
			Connection con = DBConnection.openConnection();
		String q = "select s.staffName from staffs as s where s.staffID=? and s.dt=?";
		PreparedStatement ps = con.prepareStatement(q);
	    ps.setInt(1, id);
		ps.setInt(2, 0);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {		
			return true;
		}
		con.close();
		} catch (SQLException e) {
		}
		return false;
	}
	public static int GetNoStaff()
	{
		int no = 0;
		try {
			Connection con = DBConnection.openConnection();
			String q = "select count(staffID) from staffs where dt='0' or  dt='2'";
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
	public static ArrayList<StaffLists> GetAllStaff(int status)
	{
		//status 1 = current
		//status 2 = suspend
		
		//status3 = current and teacher
		String gender = "Male";
		int no = 1;
		ArrayList<StaffLists> staffList = new ArrayList<StaffLists>();	
		try {
			Connection con = DBConnection.openConnection();
			
			String q = "";
			if(status !=3)
			{
				 q = "select s.staffID,s.staffName,s.joinDate,s.gender,s.phoneNo,ss.salary,des.desname,s.presentAddress,s.staffEmail from staffs as s join staffsalarys as ss on s.staffID=ss.staffID join designationsalarys as dess on ss.dessid=dess.dessid  join designations as des on dess.desid=des.desid join  admins as ad on ss.adminID=ad.adminID  where ss.dt='0' and s.dt='"+status+"' order by s.staffID";

			}
			if(status == 3)
			{
			 q = "select s.staffID,s.staffName,s.joinDate,s.gender,s.phoneNo,ss.salary,des.desname,s.presentAddress,s.staffEmail from staffs as s join staffsalarys as ss on s.staffID=ss.staffID join designationsalarys as dess on ss.dessid=dess.dessid  join designations as des on dess.desid=des.desid join  admins as ad on ss.adminID=ad.adminID  where ss.dt='0' and s.dt='"+0+"' and des.desname='Teacher' order by s.staffID";

			}
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
			StaffLists stf = new StaffLists(rs.getInt(1),rs.getString(2),rs.getDate(3),gender,rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),no,rs.getString(9));
			no++;
			staffList.add(stf);
			}
		con.close();
		} catch (SQLException e) {
		}
		return staffList;
	}
	
	public static ArrayList<StaffLists> StaffSalaryAndDesignationHistory(String staffID)
	{
		ArrayList<StaffLists> staffList = new ArrayList<StaffLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select des.desname,ss.salary,ad.adminID,ad.adminName,ss.definedDate from staffs as s join staffsalarys as ss on s.staffID=ss.staffID join designationsalarys as dess on ss.dessid=dess.dessid join designations as des on dess.desid=des.desid  join admins as ad on ss.adminID=ad.adminID where (ss.dt='0' or ss.dt='2') and ss.staffID='"+staffID+"' order by ss.ssid desc";
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				StaffLists stf = new StaffLists(rs.getString(1),rs.getInt(2),rs.getInt(3)+"",rs.getString(4),rs.getDate(5));			
				staffList.add(stf);
			}
			con.close();
		} catch (SQLException e) {
		}
		return staffList;
	}
	public static StaffLists GetStaffData(int staffID)
	{		
		StaffLists stf = null;
		String gender = "";
		
		try {
			Connection con = DBConnection.openConnection();
			
		String q = "select s.staffID,s.staffName,s.joinDate,s.gender,s.dateofBirth,s.phoneNo,s.presentAddress,s.password,s.username,ss.salary,des.desname,ad.adminID,ad.adminName,s.staffEmail from staffs as s join staffsalarys as ss on s.staffID=ss.staffID join designationsalarys as dess on ss.dessid=dess.dessid join designations as des on dess.desid=des.desid  join admins as ad on ss.adminID=ad.adminID where s.staffID='"+staffID+"' and ss.dt='0'";
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
		stf = new StaffLists(rs.getInt(1), rs.getString(2), rs.getDate(3), gender, rs.getDate(5),rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13),1,rs.getString(14));
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stf;
	}
	public static ArrayList<StaffLists> FilterStaff(String email,String name,int status)
	{
		String gender ="";
		int no = 1;
		ArrayList<StaffLists> staffList = new ArrayList<StaffLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q ="";
		q = "select s.staffID,s.staffName,s.joinDate,s.gender,s.phoneNo,ss.salary,des.desname,s.presentAddress,s.staffEmail from staffs as s join staffsalarys as ss on s.staffID=ss.staffID join designationsalarys as dess on ss.dessid=dess.dessid join designations as des on dess.desid=des.desid  join admins as ad on ss.adminID=ad.adminID where ss.dt='0' and s.staffEmail like '%"+email+"%' and s.staffName like '%"+name+"%' and s.dt='"+status+"'";
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
			StaffLists stf = new StaffLists(rs.getInt(1),rs.getString(2),rs.getDate(3),gender,rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),no,rs.getString(9));
			no++;
			
			staffList.add(stf);
			
		}
		con.close();
		} catch (SQLException e) {
		}
		return staffList;
	}
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select staffID from staffs order by staffID desc limit 1";
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
	public static int GetStaffID(String sname)
	{		
		try {
			Connection con = DBConnection.openConnection();
			String q = "select staffID from staffs where staffName=?";
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
	public static boolean AddNewStaff(String staffID,String name,String joinDate,String gender,String dob,String phoneNo,String presentAddress,String password,String salary,String desid,String username,String email)
	{
		boolean isTrue = false;
		Connection con = DBConnection.openConnection();
		String q;
		int g = 0;
		PreparedStatement ps;
		if(gender.equals("Male"))
		{
			g = 0;
		}
		else
		{
			g = 1;
		}
		
		String qdessid;
		int dessid = 0;

		qdessid = "select dessid from designationsalarys  as dess join designations as des on dess.desid=des.desid where des.desid='"+desid+"' order by dessid desc limit 1";
		try {
			ps = con.prepareStatement(qdessid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				dessid = rs.getInt(1);
			}
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
    	con = DBConnection.openConnection();
        q = "insert into staffs(staffName,gender,phoneNo,presentAddress,password,joinDate,dateofBirth,adminID,definedDate,username,staffEmail) VALUES (?,?,?,?,?,?,?,?,now(),?,?)";
    	try {
		   ps =con.prepareStatement(q);
		   ps.setString(1, name);
		   ps.setInt(2, g);
		   ps.setString(3, phoneNo);
		   ps.setString(4, presentAddress);
		   ps.setString(5, password);
		   ps.setString(6, joinDate);
		   ps.setString(7, dob);
		   ps.setString(8, Login.userid);
		   ps.setString(9, username);
		   ps.setString(10, email);
           ps.executeUpdate();
		   con.close();
		   isTrue = true;
		} catch (SQLException e) {
//			e.printStackTrace();
			isTrue = false;
		}
		
    	
    	if(isTrue == true)
    	{
	    	con = DBConnection.openConnection();
	    	q = " insert into staffsalarys (salary,adminID,staffID,definedDate,dessid) values (?,?,?,now(),?)";
	    	try {
	    		
	 		      ps =con.prepareStatement(q);
	 		   ps.setString(1, salary);
	 		   ps.setString(2, Login.userid);
	 		   ps.setString(3,Handler.StaffHandler.GetNewID()+"");
	 		   ps.setString(4, dessid+"");
	            ps.executeUpdate();
	 			con.close();
	 			return true;
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 		}
    	}
		return isTrue;
	}
	
	public static void UpdateStaffData(String staffID,String name,String joinDate,String gender,String dob,String phoneNo,String presentAddress,String password)
	{
		Connection con = DBConnection.openConnection();
		String q;
		int g = 0;
		PreparedStatement ps;
		if(gender.equals("Male"))
		{
			g = 0;
		}
		else
		{
			g = 1;
		}
		
		
		try {
			q = "update staffs set staffName='"+name+"',joinDate='"+joinDate+"',gender='"+g+"',dateofBirth='"+dob+"',phoneNo='"+phoneNo+"',presentAddress='"+presentAddress+"',password='"+password+"' where staffID='"+staffID+"'";
			ps = con.prepareStatement(q);
			ps.executeUpdate();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean UpdateStaffEmail(String staffID,String email)
	{
		Connection con = DBConnection.openConnection();
		String q;
		PreparedStatement ps;
		
		try {
			q = "update staffs set staffEmail='"+email+"' where staffID='"+staffID+"'";
			ps = con.prepareStatement(q);
			ps.executeUpdate();
			con.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
		
	
	public static void UpdateDesignationAndSalary(String staffID,String adminID,String desid,String salary)
	{
		Connection con = DBConnection.openConnection();
		String q;
		con = DBConnection.openConnection();
		PreparedStatement ps;
		int ssid = 1;
		
		String qdessid;
		int dessid = 0;

		qdessid = "select dessid from designationsalarys  as dess join designations as des on dess.desid=des.desid where des.desid='"+desid+"' order by dessid desc limit 1";
		try {
			ps = con.prepareStatement(qdessid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				dessid = rs.getInt(1);
			}
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		con = DBConnection.openConnection();
		q = "select ssid from staffsalarys as ss where ss.staffID='"+staffID+"'and ss.dt='0' order by ssid desc limit 1";
		ResultSet rs;
		try {
			ps = con.prepareStatement(q);
			rs = ps.executeQuery();
			while (rs.next()) {	
				ssid = rs.getInt(1);
			}
			con.close();
			
		}catch (SQLException e) {
 			e.printStackTrace();
 		}
		
		
		con = DBConnection.openConnection();
		q = "update staffsalarys set dt='2'  where ssid='"+ssid+"'";
		try {
			ps = con.prepareStatement(q);
			ps.executeUpdate();
			
		}catch (SQLException e) {
 			e.printStackTrace();
 		}
		
		q = " insert into staffsalarys (salary,adminID,staffID,dessid,definedDate) values(?,?,?,?,now())";
    	try {
 		   ps =con.prepareStatement(q);
 		   ps.setString(1, salary);
 		   ps.setString(2, adminID);
 		   ps.setString(3,staffID);
 		   ps.setString(4, dessid+"");
           ps.executeUpdate();
 			con.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
		
	}
	
	public static void DeleteStaff(int staffID)
	{
		Connection con = DBConnection.openConnection();
		try {
			String q  = "update staffs set dt='1' where staffID='"+staffID+"'";
			PreparedStatement ps;
			ps = con.prepareStatement(q);
			ps.executeUpdate();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static StaffLists GetStaffEmailNameSalary(int meid) // from salary expenses 
	{
		StaffLists stf = null;
		ArrayList<StaffLists> staffList = new ArrayList<StaffLists>();	
		try {
			Connection con = DBConnection.openConnection();
		String q = " select s.staffEmail,s.staffName,ss.salary from salaryexpenses as se join staffs as s on se.staffID=s.staffID join mainexpenses as me on se.meid=me.meid join staffsalarys as ss on s.staffID=ss.staffID  where se.meid='"+meid+"' and ss.dt='0'";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			stf = new StaffLists(rs.getString(1),rs.getString(2),rs.getInt(3));
		}
		con.close();
		} catch (SQLException e) {
		}
		return stf;
	}
}
