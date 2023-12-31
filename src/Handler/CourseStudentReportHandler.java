package Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import List.CourseStudentReportLists;
import List.IncomeReportLists;

public class CourseStudentReportHandler {
	public static ArrayList<CourseStudentReportLists> getNoofStudentByCourse(String day,String month,String year)
	{
		ArrayList<CourseStudentReportLists> lists = new ArrayList<CourseStudentReportLists>();
		try {
		Connection con = DBConnection.openConnection();
		String q = "";
		int i = 0;
		
		if(!day.equals("") && !month.equals("") && !year.equals(""))
		{
			q = "select c.cName,count(cs.studentID) from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid  where year(cs.addDate)='"+year+"' and month(cs.addDate)='"+month+"' and day(cs.addDate)='"+day+"' and cs.dt='0' group by c.cid";
		}
		if(day.equals("") && !month.equals("") && !year.equals(""))
		{
			q = "select c.cName,count(cs.studentID) from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid  where year(cs.addDate)='"+year+"' and month(cs.addDate)='"+month+"' and cs.dt='0' group by c.cid";
		}
		if(day.equals("") && month.equals("") && !year.equals("")) {
			q = "select c.cName,count(cs.studentID) from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid  where year(cs.addDate)='"+year+"' and cs.dt='0' group by c.cid";			
		}
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
				i++;
				CourseStudentReportLists cs = new CourseStudentReportLists(i,rs.getString(1),rs.getInt(2));
				lists.add(cs);
		}	
		con.close();
		} catch (SQLException e) {
		}
	return lists;
	}
	
	public static int getNoofStudent(String day,String month,String year)
	{
		CourseStudentReportLists lists = null;
		try {
		Connection con = DBConnection.openConnection();
		String q = "";
		if(!day.equals("") && !month.equals("") && !year.equals(""))
		{
			q = "select count(cs.studentID) from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid  where year(cs.addDate)='"+year+"' and month(cs.addDate)='"+month+"' and day(cs.addDate)='"+day+"' and cs.dt='0' group by c.cid";
		}
		if(day.equals("") && !month.equals("") && !year.equals(""))
		{
			q = "select count(cs.studentID) from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid  where year(cs.addDate)='"+year+"' and month(cs.addDate)='"+month+"' and cs.dt='0' group by c.cid";
		}
		if(day.equals("") && month.equals("") && !year.equals(""))
		{
			q = "select count(cs.studentID) from coursestudents as cs join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid  where year(cs.addDate)='"+year+"' and cs.dt='0' group by c.cid";			
		}		PreparedStatement ps = con.prepareStatement(q);
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
