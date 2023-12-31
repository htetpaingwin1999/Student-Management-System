package Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import List.CourseStudentLists;
import List.StudentLists;
import List.StudentPaymentLists;

public class StudentPaymentHandler {
	
	public static ArrayList<CourseStudentLists> GetAllPayment() // it is only intend for feepayment
	{
		ArrayList<CourseStudentLists> studentList = new ArrayList<CourseStudentLists>();	
		try {
			int no = 1;
			Connection con = DBConnection.openConnection();
		String q = "select cs.csid,c.cname,cf.cfee,st.studentID,st.studentName,cs.addDate,fp.amount,fp.fpid,cf.cfid from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID where cs.dt='0' and fp.dt='0'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
		CourseStudentLists cs = new  CourseStudentLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDate(6),no,rs.getInt(7),rs.getInt(8),rs.getInt(9));
			no++;
			studentList.add(cs);
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	
	
	public static ArrayList<CourseStudentLists> FilterPayment(String studentID,String studentName,String cname) // it is only intend for feepayment
	{
		ArrayList<CourseStudentLists> studentList = new ArrayList<CourseStudentLists>();	
		try {
			int no = 1;
			Connection con = DBConnection.openConnection();
		String q = "select cs.csid,c.cname,cf.cfee,st.studentID,st.studentName,cs.addDate,fp.amount,fp.fpid,cf.cfid from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID where cs.dt='0' and fp.dt='0' and st.studentID like '%"+studentID+"%' and st.studentName like '%"+studentName+"%' and c.cname like '%"+cname+"%' and fp.addDate like '"+""+"%'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			CourseStudentLists cs = new  CourseStudentLists(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getDate(6),no,rs.getInt(7),rs.getInt(8),rs.getInt(9));
			no++;
			studentList.add(cs);
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	
//	public static ArrayList<StudentPaymentLists> GetAllStudentPaymentLists()
//	{
//		ArrayList<StudentPaymentLists> paymentLists = new ArrayList<StudentPaymentLists>();	
//		try {
//			Connection con = DBConnection.openConnection();
//		String q = "select fp.fpid,st.studentID,st.studentName,c.cName,cf.cfee,fp.amount,fp.addDate,stf.staffID,stf.staffName from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID join staffs as stf on fp.staffID=stf.staffID where fp.dt='0'";
//		PreparedStatement ps = con.prepareStatement(q);
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {	
//			StudentPaymentLists pl = new StudentPaymentLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getDate(7),rs.getInt(8),rs.getString(9));
//			paymentLists.add(pl);
//		}
//		con.close();
//		} catch (SQLException e) {
//		}
//		return paymentLists;
//	}
	
	public static ArrayList<StudentPaymentLists> GetTodayPayment()
	{
		ArrayList<StudentPaymentLists> paymentLists = new ArrayList<StudentPaymentLists>();	
		try {
			Connection con = DBConnection.openConnection();
		String q = "select fp.fpid,st.studentID,st.studentName,c.cName,cf.cfee,fp.amount,fp.addDate,stf.staffID,stf.staffName from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID join staffs as stf on fp.staffID=stf.staffID where fp.dt='0' and fp.addDate=date(now())";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			StudentPaymentLists pl = new StudentPaymentLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getDate(7),rs.getInt(8),rs.getString(9));
			paymentLists.add(pl);
		}
		con.close();
		} catch (SQLException e) {
		}
		return paymentLists;
	}
//	public static ArrayList<StudentPaymentLists> FilterStudentPaymentLists(String studentID,String studentName,String cName)
//	{
//		ArrayList<StudentPaymentLists> paymentLists = new ArrayList<StudentPaymentLists>();	
//		try {
//			Connection con = DBConnection.openConnection();
//		String q = "select fp.fpid,st.studentID,st.studentName,c.cName,cf.cfee,fp.amount,fp.addDate,stf.staffID,stf.staffName from feepayments as fp join coursestudents as cs on fp.csid=cs.csid join coursefees as cf on cs.cfid=cf.cfid join courses as c on cf.cid=c.cid join students as st on cs.studentID=st.studentID join staffs as stf on fp.staffID=stf.staffID where fp.dt='0' and st.studentID like '%"+studentID+"%' and st.studentName like '%"+studentName+"%' and c.cName like '%"+cName+"%'";
//		PreparedStatement ps = con.prepareStatement(q);
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {	
//			StudentPaymentLists pl = new StudentPaymentLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getDate(7),rs.getInt(8),rs.getString(9));
//			paymentLists.add(pl);
//		}
//		con.close();
//		} catch (SQLException e) {
//		}
//		return paymentLists;
//	}
	
	public static void DeleteStudentPaymentLists(int fpid)
	{
		ArrayList<StudentPaymentLists> paymentLists = new ArrayList<StudentPaymentLists>();	
		try {
			Connection con = DBConnection.openConnection();
		String q = "update feepayments set dt='1' where fpid='"+fpid+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		
		con.close();
		} catch (SQLException e) {
		}
	}
	
	public static void DeleEntirePayment(int csid)
	{
		ArrayList<StudentPaymentLists> paymentLists = new ArrayList<StudentPaymentLists>();	
		try {
			Connection con = DBConnection.openConnection();
		String q = "update feepayments set dt='1' where csid='"+csid+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ps.executeUpdate();
		
		con.close();
		} catch (SQLException e) {
		}
	}
	
	public static  int StudentPaymentByID(int csid)
	{
		try {
			Connection con = DBConnection.openConnection();
		String q = "select sum(fp.amount) from feepayments as fp where fp.dt='0' and fp.csid='"+csid+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			return  rs.getInt(1);
		}
		con.close();
		} catch (SQLException e) {
		}
		return 0;
	}
}
