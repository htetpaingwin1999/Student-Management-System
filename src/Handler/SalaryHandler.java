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

import List.SalaryLists;
import List.StaffLists;
import View.Login;


public class SalaryHandler {
	
	
	public static boolean isPaidThisMonth(String sid)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "select 1 from salaryexpenses as se join mainexpenses as me on se.meid=me.meid where se.staffID='"+sid+"' and year(me.addDate)=year(now()) and month(me.addDate)=month(now()) and me.dt='0'";
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
	
	
	public static ArrayList<SalaryLists> GetAllSalary()
	{
		ArrayList<SalaryLists> salaryPaymentLists = new ArrayList<SalaryLists>();	
		try {
			int no = 1;
			Connection con = DBConnection.openConnection();
			String q = "select s.staffID,s.staffName,me.addDate,ss.salary,me.amount,me.note,ad.adminID,ad.adminName,me.meid from salaryexpenses as se join mainexpenses as me on se.meid=me.meid join staffs as s on se.staffID=s.staffID join staffsalarys as ss on s.staffID=ss.staffID join admins as ad on me.adminID=ad.adminID where me.dt='0' and ss.dt='0' order by me.addDate and me.amount";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			SalaryLists sp = new SalaryLists(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),no);
			no++;
			salaryPaymentLists.add(sp);
		}
		con.close();
		} catch (SQLException e) {
		}
		return salaryPaymentLists;
	}
	
	public static ArrayList<SalaryLists> FilterStaff(String email,String name)
	{
		ArrayList<SalaryLists> salaryPaymentLists = new ArrayList<SalaryLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q ="";
			int no = 1;
			q =  "select s.staffID,s.staffName,me.addDate,ss.salary,me.amount,me.note,ad.adminID,ad.adminName,me.meid from salaryexpenses as se join mainexpenses as me on se.meid=me.meid join staffs as s on se.staffID=s.staffID join staffsalarys as ss on s.staffID=ss.staffID join admins as ad on me.adminID=ad.adminID where me.dt='0' and ss.dt='0' and s.staffEmail like '%"+email+"%' and s.staffName like '%"+name+"%' order by me.addDate and me.amount";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			SalaryLists sp = new SalaryLists(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),no);
			no++;
			salaryPaymentLists.add(sp);
		}
		con.close();
		} catch (SQLException e) {
		}
		return salaryPaymentLists;
	}

	
	public static void AddNewSalary(String staffID,String amount,String note,String salary)
	{
		Connection con = DBConnection.openConnection();
		String q;
		
		System.out.println("Main Expense is added");
		Handler.ExpenseHandler.AddNewMainExpense(amount, note,1);
		
		System.out.println("Salary Expense is added");
		int meid = Handler.ExpenseHandler.GetNewMainExpenseID();
		System.out.println(meid);
        q = "insert into salaryexpenses(meid,staffID,ecid) values (?,?,?)";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
		   ps.setInt(1, meid);
		   ps.setString(2, staffID);
		   ps.setString(3,"1");
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void UpdateSalary(String adminID,String amount,String note,int meid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update mainexpenses set adminID='"+adminID+"',amount='"+amount+"',note='"+note+"',addDate=now() where meid='"+meid+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteSalary(int meid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update mainexpenses set dt='1' where meid='"+meid+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
           ps.executeUpdate();
		   con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
