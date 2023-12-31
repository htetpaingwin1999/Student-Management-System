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

import com.mysql.cj.protocol.Resultset;

import List.ExpenseCategoryLists;


public class ExpenseCategoryHandler {	
	
	public static ArrayList<ExpenseCategoryLists> GetAllExpenseCategory()
	{
		int no = 1;
		ArrayList<ExpenseCategoryLists> expenseCategoryLists = new ArrayList<ExpenseCategoryLists>();
		try {
			Connection con = DBConnection.openConnection();
			String q = "select ec.ecid,ec.ecname,ad.adminID,ad.adminName,ec.addDate from expensecategories as ec join admins as ad on ec.adminID=ad.adminID where ec.dt='0' and ec.ecid !='1'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ExpenseCategoryLists d = new ExpenseCategoryLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDate(5),no);
			no++;
			expenseCategoryLists.add(d);
		}
		
		con.close();
		} catch (SQLException e) {
		}
		return expenseCategoryLists;
	}
	public static ExpenseCategoryLists GetExpenseCategoryData(int ecid)
	{
		ExpenseCategoryLists ad = null;
		try {
			Connection con = DBConnection.openConnection();
			String q = "select ec.ecid,ec.ecname,ad.adminID,ad.adminName,ec.addDate from expensecategories as ec join admins as ad on ec.adminID=ad.adminID where ec.ecid='"+ecid+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ExpenseCategoryLists d = new ExpenseCategoryLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDate(5),1);
			return ad;
		}
		con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ad;
	}
	public static int GetID(String ecname)
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select ecid from expensecategories where ecname= '"+ecname+"'";
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
	public static ArrayList<ExpenseCategoryLists> FilterExpenseCategory(String id,String ecname)
	{
		int no = 1;
		ArrayList<ExpenseCategoryLists> expenseCategoryLists = new ArrayList<ExpenseCategoryLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select ec.ecid,ec.ecname,ad.adminID,ad.adminName,ec.addDate from expensecategories as ec join admins as ad on ec.adminID=ad.adminID where ec.ecid like '%"+id+"%' and ec.ecname like '%"+ecname+"%' and ec.dt='0' and ec.ecid !=1";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ExpenseCategoryLists d = new ExpenseCategoryLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getDate(5),no);
			no++;
			expenseCategoryLists.add(d);
		}
		con.close();
		} catch (SQLException e) {
		}
		return expenseCategoryLists;
	}
	public static int GetNewID()
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select ecid from expensecategories order by ecid desc limit 1";
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
	public static void AddNewExpenseCategory(String ecname,String adminID)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into expensecategories(ecname,adminID,addDate) values(?,?,now())";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setString(1, ecname);
		   ps.setString(2, adminID);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getExpenseCategoryList(int dt)
	{
		ArrayList<String> catLists = new ArrayList<String>();
		Connection con = DBConnection.openConnection();
		String q;
		try {
			q = "select ec.ecname from expensecategories as ec where ec.dt='"+dt+"'";
			if(dt==2)
			{
				q = "select ec.ecname from expensecategories as ec";
			}
			
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs =ps.executeQuery(q);
			while(rs.next())
			{
				String cat = rs.getString(1);
				catLists.add(cat);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catLists;
	}
	
	public static void UpdateExpenseCategory(int ecid,String ecname,String i)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update expensecategories set ecname='"+ecname+"',adminID='"+i+"' where ecid='"+ecid+"'";
    	try {
		   PreparedStatement ps =con.prepareStatement(q);
		   ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteExpenseCategory(int ecid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update expensecategories set dt='"+1+"' where ecid='"+ecid+"'";
    	try {
		   PreparedStatement ps =con.prepareStatement(q);
		   ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
