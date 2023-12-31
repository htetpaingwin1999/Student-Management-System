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

import List.ExpenseLists;
import View.Login;


public class ExpenseHandler {	
	
	
	public static ArrayList<ExpenseLists> FilterExpense(String  date,String ecname)
	{
		int no = 1;
		ArrayList<ExpenseLists> expenseLists = new ArrayList<ExpenseLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select me.meid,me.amount,me.note,me.ecid,ec.ecname,ad.adminID,ad.adminName,me.addDate from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' and ec.ecname like '%"+ecname+"%' and me.addDate like '%"+date+"%' order by me.addDate desc";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ExpenseLists d = new ExpenseLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getDate(8),no);
			no++;
			expenseLists.add(d);
		}con.close();
		} catch (SQLException e) {
		}
		return expenseLists;
	}
	public static int GetNewID() //Get Main Expense ID
	{
		int ID = 0;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select eid from expenses";
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
	
	/*new */
	
	public static ArrayList<ExpenseLists> GetAllExpense()
	{
		int no = 1;
		ArrayList<ExpenseLists> expenseLists = new ArrayList<ExpenseLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "select me.meid,me.amount,me.note,me.ecid,ec.ecname,ad.adminID,ad.adminName,me.addDate from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' order by me.addDate desc";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			ExpenseLists d = new ExpenseLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getDate(8),no);
			no++;
			expenseLists.add(d);
		}
		con.close();
		} catch (SQLException e) {
		}
		return expenseLists;
	}
	
	public static int GetNewMainExpenseID() //Get Main Expense ID
	{
		int ID = 1;
		try {
			Connection con = DBConnection.openConnection();
		String q = "select meid from mainexpenses";
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
	
	public static void AddNewMainExpense(String amount,String note,int ecid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "insert into mainexpenses(amount,note,adminID,addDate,ecid) values (?,?,?,now(),?)";
    	try {
		  PreparedStatement ps =con.prepareStatement(q);
		 
		   ps.setString(1, amount);
		   ps.setString(2, note);
		   ps.setString(3, Login.userid);
		   ps.setInt(4, ecid);
           ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		/*new */

	
	
	public static void UpdateExpense(int eid,String amount,int ecid,String note,int adminID)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update mainexpenses set amount='"+amount+"',note ='"+note+"',adminID='"+adminID+"',addDate=now() where meid='"+eid+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		     ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public static void DeleteExpense(int eid)
	{
		Connection con = DBConnection.openConnection();
		String q;
		q = "update mainexpenses set dt='1' where meid='"+eid+"'";
    	try {
		    PreparedStatement ps =con.prepareStatement(q);
		  ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	public static ArrayList<ExpenseLists> ExpenseReport(String cat,String day,String month,String year)
	{
		ArrayList<ExpenseLists> expenseLists = new ArrayList<ExpenseLists>();
		String q = "";
		int no = 1;
		try {
			Connection con = DBConnection.openConnection();	
			if(!day.equals("") && !month.equals("") && !year.equals(""))
			{
				q = "select me.meid,me.amount,me.note,me.ecid,ec.ecname,ad.adminID,ad.adminName,me.addDate from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' and year(me.addDate)='"+year+"' and month(me.addDate)='"+month+"' and day(me.addDate)='"+day+"' and ec.ecname like '%"+cat+"%'";
			}
			
			if(day.equals("") && !month.equals("") && !year.equals(""))
			{
				q = "select me.meid,me.amount,me.note,me.ecid,ec.ecname,ad.adminID,ad.adminName,me.addDate from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' and year(me.addDate)='"+year+"' and month(me.addDate)='"+month+"' and ec.ecname like '%"+cat+"%'";
	
			}
			if(day.equals("") && month.equals("") && !year.equals(""))
			{
				q = "select me.meid,me.amount,me.note,me.ecid,ec.ecname,ad.adminID,ad.adminName,me.addDate from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' and year(me.addDate)='"+year+"' and ec.ecname like '%"+cat+"%'";
			}
		
			PreparedStatement ps;
			ResultSet rs;
			ps= con.prepareStatement(q);
				rs = ps.executeQuery();
				while (rs.next()) {	
					ExpenseLists d = new ExpenseLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getDate(8),no);
					expenseLists.add(d);
					no++;
				}
		con.close();
		} catch (SQLException e) {
		}
		return expenseLists;
	}
	
	
	
	public static int GetTotalAmount(String cat,String day,String month,String year)
	{
		int amount = 0;
		String q = "";
		int no = 0;
		try {
			Connection con = DBConnection.openConnection();
			
			
				if(!day.equals("") && !month.equals("") && !year.equals(""))
				{
					q = "select sum(me.amount) from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' and year(me.addDate)='"+year+"' and month(me.addDate)='"+month+"' and day(me.addDate)='"+day+"' and ec.ecname like '%"+cat+"%'";
				}
				
				if(day.equals("") && !month.equals("") && !year.equals(""))
				{
					q = "select sum(me.amount) from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' and year(me.addDate)='"+year+"' and month(me.addDate)='"+month+"' and ec.ecname like '%"+cat+"%'";
		
				}
				if(day.equals("") && month.equals("") && !year.equals(""))
				{
					q = "select sum(me.amount) from mainexpenses as me join admins as ad on me.adminID=ad.adminID join expensecategories as ec on me.ecid=ec.ecid where me.dt='0' and year(me.addDate)='"+year+"' and ec.ecname like '%"+cat+"%'";
				}
			
			PreparedStatement ps;
			ResultSet rs;
			
			ps= con.prepareStatement(q);
			rs = ps.executeQuery();
			while (rs.next()) {
				amount = amount + rs.getInt(1);
			}
			
		con.close();
		} catch (SQLException e) {
		}
		return amount;
	}
	
	public static int GetTotalAmountForDashboard()
	{
		try {
			Connection con = DBConnection.openConnection();		
			String q = "select sum(me.amount) from mainexpenses as me where me.dt='0'";
			PreparedStatement ps;
			ResultSet rs;
			ps= con.prepareStatement(q);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		con.close();
		} catch (SQLException e) {
		}
		return 0;
	}
	
	
}
