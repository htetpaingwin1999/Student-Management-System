package Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.*;

import List.SectionLists;
import List.StaffLists;
import List.StudentPaymentLists;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
//		Handler.ReportHandler.GetAllIncomeExpense("", "1", "2021","coursestudentpayment");
//		Handler.StudentHandler.JoinSection("1", "1","1");
//		Handler.StaffHandler.UpdateDesignationAndSalary(2+"", 1+"", 1+"", 2000+"");
//		Handler.IncomeReportHandler.GetIncome("Java", "8", "6", "2021");
//		System.out.println(Handler.StudentPaymentHandler.StudentPaymentByID("1,", "Java"));
//		System.out.println(Handler.IncomeReportHandler.getIncomeForDashboardChart("13","6", "2021"));
//		System.out.println(Math.pow(10, 2));
//		System.out.print(View.GeneralReportView.GetIncomePoint(128000f));
//		System.out.println(Handler.Validation.checkDate("2021-12-01"));
//		System.out.println(Handler.Validation.checkSectionOpenTime("12:00-01:00 AM"));
		CourseStudentHandler.RemoveSection(1, 1);
//		System.out.println(Validation.checkEmail("aa"));
//		Handler.StaffHandler.GetStaffData(1);
//		GetAllStaff(0);
       // StaffLists st = Handler.StaffHandler.GetStaffData(1);
        //System.out.print(st.getDesignation());
    	
	}
	public static void GetAllStaff(int status)
	{
		//status 1 = current
		//status 2 = suspend
		String gender = "Male";
		int no = 1;
		ArrayList<StaffLists> staffList = new ArrayList<StaffLists>();	
		try {
			Connection con = DBConnection.openConnection();
			
			String q = "select staffEmail from staffs";
			PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {	
			System.out.println(rs.getString(1));
		}
		con.close();
		} catch (SQLException e) {
		}
	}
		
}
