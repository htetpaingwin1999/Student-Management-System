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

import List.IncomeReportLists;
import List.StudentPaymentLists;
import View.Login;


public class IncomeReportHandler {	
	
	public static ArrayList<IncomeReportLists> GetIncomeBySub(String sub,String day,String month,String year)
	{
		int i = 0;
		int no = 1;
		ArrayList<IncomeReportLists> IncomeExpense = new ArrayList<IncomeReportLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "";
			if(!day.equals("") && !month.equals("") && !year.equals(""))
			{
				q = "select sum(fp.amount),c.cname,fp.addDate from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where fp.dt='0' and year(fp.addDate)="+year+" and month(fp.addDate)="+month+" and day(fp.addDate)="+day+" and c.cname='"+sub+"' order by fp.fpid desc";
			}
			if(day.equals("") && !month.equals("") && !year.equals(""))
			{
				q = "select sum(fp.amount),c.cname,fp.addDate from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where fp.dt='0' and year(fp.addDate)="+year+" and month(fp.addDate)="+month+" and c.cname='"+sub+"' order by fp.fpid desc";
			}
			if(day.equals("") && month.equals("") && !year.equals(""))
			{
				q = "select sum(fp.amount),c.cname,fp.addDate from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where fp.dt='0' and year(fp.addDate)="+year+" and c.cname='"+sub+"' order by fp.fpid desc";
			}
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
					i++;
					IncomeReportLists ie = new IncomeReportLists(i,rs.getInt(1),rs.getString(2),rs.getDate(3)+"",no);
					no++;
					IncomeExpense.add(ie);	
			}	
			con.close();
			} catch (SQLException e) {
		}
		return IncomeExpense;
	}
	public static ArrayList<IncomeReportLists> GetTotalIncome(String day,String month,String year)
	{
		int i = 0;
		int no = 1;
		ArrayList<IncomeReportLists> IncomeExpense = new ArrayList<IncomeReportLists>();	
		try {
			Connection con = DBConnection.openConnection();
			String q = "";
			if(!day.equals("") && !month.equals("") && !year.equals(""))
			{
				q = "select sum(fp.amount),c.cname,fp.addDate from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where fp.dt='0' and year(fp.addDate)="+year+" and month(fp.addDate)="+month+" and day(fp.addDate)="+day+" order by fp.fpid desc";
			}
			if(day.equals("") && !month.equals("") && !year.equals(""))
			{
				q = "select sum(fp.amount),c.cname,fp.addDate from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where fp.dt='0' and year(fp.addDate)="+year+" and month(fp.addDate)="+month+" order by fp.fpid desc";
			}
			if(day.equals("") && month.equals("") && !year.equals(""))
			{
				q = "select sum(fp.amount),c.cname,fp.addDate from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where fp.dt='0' and year(fp.addDate)="+year+" order by fp.fpid desc";
			}
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
					i++;
					IncomeReportLists ie = new IncomeReportLists(i,rs.getInt(1),rs.getString(2),rs.getDate(3)+"",no);
					no++;
					IncomeExpense.add(ie);	
			}	
			con.close();
			} catch (SQLException e) {
		}
		return IncomeExpense;
	}	
	public static int getTotalAmount(String sub,String day,String month,String year)
	{
		try {
			String q = "";
			Connection con = DBConnection.openConnection();
			if(!day.equals("") && !month.equals("") && !year.equals(""))
			{
				 q = "select sum(fp.amount) from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where year(fp.addDate)="+year+" and month(fp.addDate) ="+month+" and day(fp.addDate) ="+day+"  and c.cname like '%"+sub+"%' and fp.dt='0' order by fp.fpid desc";
			}
			
			if(day.equals("") && !month.equals("") && !year.equals(""))
			{
				 q = "select sum(fp.amount) from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where year(fp.addDate)="+year+" and month(fp.addDate)="+month+"  and c.cname like '%"+sub+"%' and fp.dt='0' order by fp.fpid desc";
			}
			if(day.equals("") && month.equals("") && !year.equals(""))
			{
				 q = "select sum(fp.amount) from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid where year(fp.addDate)="+year+" and c.cname like '%"+sub+"%' and fp.dt='0' order by fp.fpid desc";
			}
			
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
	public static int getIncomeForDashboardChart(String day,String month,String year)
	{
		int income = 0;
		try {
			Connection con = DBConnection.openConnection();
			String q = "";
			if(!day.equals("") && !month.equals("") && !year.equals(""))
			{
			 q = "select sum(fp.amount) from feepayments as fp where year(fp.addDate)="+year+" and month(fp.addDate)="+month+" and day(fp.addDate)="+day+" and fp.dt='0' order by fp.fpid desc";
			}
			if(day.equals("") && !month.equals("") && !year.equals(""))
			{
				 q = "select sum(fp.amount) from feepayments as fp where year(fp.addDate)="+year+" and month(fp.addDate)="+month+" and fp.dt='0' order by fp.fpid desc";
			}
			if(day.equals("") && month.equals("") && !year.equals(""))
			{
				 q = "select sum(fp.amount) from feepayments as fp where year(fp.addDate)="+year+" and fp.dt='0' order by fp.fpid desc";
			}
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {	
				income = rs.getInt(1);
				return income;
				
			}	
			con.close();
			} catch (SQLException e) {
		}
		return income;
	}
	public static int TotalIncomeForDashboard(String role)
	{
		Connection con = DBConnection.openConnection();
		String q = "";
		if(role.equals("1")) //means admi
		{
			q = "select sum(amount) from feepayments where dt='0'";
		}
		else
		{
			 q = "select sum(amount) from feepayments where addDate=now() and dt='0' and staffID='"+Login.userid+"'";
		}
		try {
		     PreparedStatement ps =con.prepareStatement(q);
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
