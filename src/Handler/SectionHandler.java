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
import List.SectionLists;

public class SectionHandler {	
	
	public static ArrayList<SectionLists> GetAllSection(int status)
	{
		int no = 1;
		//status 0 current sections
		//status 2 finished sections
		ArrayList<SectionLists> sectionsLists = new ArrayList<SectionLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select s.sid,c.cid,c.cname,cf.cfee,s.startDate,s.endDate,s.firstday,s.firsttime,s.secondday,s.secondtime,a.adminID,a.adminName,st.staffID,st.staffName,s.definedDate,cf.cfid from sections as s join coursefees as cf on cf.cfid = s.cfid join courses as c on cf.cid = c.cid join admins as a on s.adminID=a.adminID join staffs as st on s.staffID=st.staffID where s.dt='"+status+"'";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			SectionLists s = new SectionLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),
					rs.getString(12),rs.getInt(13),rs.getString(14),rs.getDate(15),rs.getString(16),no);
			no++;
			sectionsLists.add(s);
		}
		con.close();
		} catch (SQLException e) {
		}
		return sectionsLists;
	}
	
	
	public static int GetNoofSection()
	{
		try {
			Connection con = DBConnection.openConnection();
			String q = "select count(*) from sections where dt='"+0+"'";
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
	
	
	public static SectionLists GetSectionData(int sid)
	{
		SectionLists s = null;
		
		try {
			Connection con = DBConnection.openConnection();
			String q = "select s.sid,c.cid,c.cname,cf.cfee,s.startDate,s.endDate,s.firstday,s.firsttime,s.secondday,s.secondtime,a.adminID,a.adminName,st.staffID,st.staffName,s.definedDate,cf.cfid from sections as s join coursefees as cf on cf.cfid = s.cfid join courses as c on cf.cid = c.cid join admins as a on s.adminID=a.adminID join staffs as st on s.staffID=st.staffID where s.sid='"+sid+"'";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			s = new SectionLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),
					rs.getString(12),rs.getInt(13),rs.getString(14),rs.getDate(15),rs.getString(16),1);
			return s;
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	public static ArrayList<SectionLists> FilterSection(String name,int status)
	{
		int no = 1;
		//status 0  current section
		//status 2 finised section
		ArrayList<SectionLists> sectionsLists = new ArrayList<SectionLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "";
			q = "select s.sid,c.cid,c.cname,cf.cfee,s.startDate,s.endDate,s.firstday,s.firsttime,s.secondday,s.secondtime,a.adminID,a.adminName,st.staffID,st.staffName,s.definedDate from sections as s join coursefees as cf on cf.cfid = s.cfid join courses as c on cf.cid = c.cid join admins as a on s.adminID=a.adminID join staffs as st on s.staffID=st.staffID where s.dt='"+status+"' and c.cName like '%"+name+"%'";	
			
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			SectionLists s = new SectionLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),
					rs.getString(12),rs.getInt(13),rs.getString(14),rs.getDate(15),"Pending",no);
			no++;
			sectionsLists.add(s);
		}
		con.close();
		} catch (SQLException e) {
		}
		return sectionsLists;
	}
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select sid from sections order by sid desc limit 1";
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
	
	public static int GetCourseFeeID(int sid)
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select sid from sections order by sid='"+sid+"'";
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
	public static void AddNewSection(int cfid,String startDate,String endDate,String firstday,String firsttime,String secondday,String secondtime,int adminID,int staffID)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into sections (cfid,startDate,endDate,firstday,firsttime,secondday,secondtime,adminID,staffID,definedDate) values(?,?,?,?,?,?,?,?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setInt(1, cfid);
		   ps.setString(2, startDate);
		   ps.setString(3, endDate);
		   ps.setString(4, firstday);
		   ps.setString(5, firsttime);
		   ps.setString(6, secondday);
		   ps.setString(7, secondtime);
		   ps.setInt(8, adminID);
		   ps.setInt(9, staffID);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateSection(int sid,String startDate,String endDate,String firstday,String firsttime,String secondday,String secondtime)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update sections set startDate='"+startDate+"',endDate='"+endDate+"',firstday='"+firstday+"',firsttime='"+firsttime+"',secondday='"+secondday+"',secondtime='"+secondtime+"',definedDate=now() where sid='"+sid+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteSection(int sid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update sections set dt='"+1+"' where sid="+sid+"";
        try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void FinishSection(int sid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update sections set Dt='"+2+"' where sid="+sid+"";
        try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
