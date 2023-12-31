package Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import List.SectionStudentLists;
import List.StudentPaymentLists;

public class SectionStudentHandler {

	public static ArrayList<SectionStudentLists> GetAllStudentBySection(int sectionid)
	{
		ArrayList<SectionStudentLists> studentList = new ArrayList<SectionStudentLists>();	
		try {
			int no = 1;
			Connection con = DBConnection.openConnection();
		String q = " select ss.ssid,st.studentID,st.studentName,stf.staffID,stf.staffName,ss.addDate from sectionstudents as ss join students as st on ss.studentID=st.studentID join staffs as stf on ss.staffID=stf.staffID where ss.dt='0' and ss.sid='"+sectionid+"'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			SectionStudentLists stf = new SectionStudentLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6),no);
			no++;
			studentList.add(stf);
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	
	
	public static ArrayList<SectionStudentLists> FilterSectionStudent(String studentID,String studentName,int sectionid)
	{
		ArrayList<SectionStudentLists> studentList = new ArrayList<SectionStudentLists>();	
		try {
			int no = 1;
			Connection con = DBConnection.openConnection();
			String q = "";
				q = " select ss.ssid,st.studentID,st.studentName,stf.staffID,stf.staffName,ss.addDate from sectionstudents as ss join students as st on ss.studentID=st.studentID join staffs as stf on ss.staffID=stf.staffID where ss.dt='0' and st.studentID like '%"+studentID+"%' and st.studentName like '%"+studentName+"%' and ss.sid='"+sectionid+"'";
				
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			SectionStudentLists stf = new SectionStudentLists(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6),no);		
			no++;
			studentList.add(stf);
		}
		con.close();
		} catch (SQLException e) {
		}
		return studentList;
	}
	
	
	public static void Delete(int ssid)
	{
		Connection con = DBConnection.openConnection();
		String q;
        q = "update sectionstudents set dt='1' where ssid='"+ssid+"'";
    	try {
		     PreparedStatement ps =con.prepareStatement(q);
           ps.executeUpdate();
		   con.close();
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
