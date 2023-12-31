package View;
import java.util.ArrayList;

import Handler.StudentPaymentHandler;
import List.StudentPaymentLists;
import Table.StudentPaymentTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
public class DashboardView {
	private static VBox vbDashboardView;
	private static HBox hbStudentCon;
	private static Label lStudent;
	private static Label lNoOfStudent;
	private static HBox hbNoOfStudentCon;
	private static VBox vbStudentCon;
	private static HBox hbSectionCon;
	private static Label lSection;
	private static Label lNoOfSection;
	private static HBox hbNoOfSectionCon;
	private static VBox vbSectionCon;
	private static HBox hbIncomeCon;
	private static Label lIncome;
	private static Label lNoOfIncome;
	private static HBox hbNoOfIncomeCon;
	private static VBox vbIncomeCon;
	
	private static HBox hbCourseCon;
	private static Label lCourse;
	private static Label lNoOfCourse;
	private static HBox hbNoOfCourseCon;
	private static VBox vbCourseCon;
	
	private static HBox hbStaffCon;
	private static Label lStaff;
	private static Label lNoOfStaff;
	private static HBox hbNoOfStaffCon;
	private static VBox vbStaffCon;
	
	private static HBox hbExpenseCon;
	private static Label lExpense;
	private static Label lNoOfExpense;
	private static HBox hbNoOfExpenseCon;
	private static VBox vbExpenseCon;
	
	private static VBox vbChart;
	private static TableView tvStudentPayment;
	
	private static HBox hb1stReportCon;
	private static HBox hb2ndReportCon;
	private static ObservableList<StudentPaymentLists> data;

	private static void VbCon(VBox vb,String color)
	{
		vb.setSpacing(10);
		vb.setPadding(new Insets(20,0,10,30));
		vb.setStyle("-fx-background-color:"+color);
		vb.setPrefWidth(127.5);
	}
	private static void LNo(Label l)
	{
		l.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		l.setPrefWidth(127.5);
		l.setTextFill(Color.WHITE);
		l.setAlignment(Pos.CENTER);
	}
	private static void HbNo(HBox hb,String color)
	{
		hb.setPadding(new Insets(20,13.75,20,0));
		hb.setStyle("-fx-background-color:"+color);
		hb.setPrefWidth(127.5);
	}
	public static VBox vbDashboardView()
	{
		vbDashboardView = new VBox();
		vbDashboardView.setStyle("-fx-background-color:white");
		
		StudentPaymentTable.tvStudentPaymentLists();
		tvStudentPayment = StudentPaymentTable.tvStudentPaymentLists();
		data = FXCollections.observableArrayList(StudentPaymentHandler.GetTodayPayment());
		tvStudentPayment.setItems(data);
		
		lCourse = new Label("Course");
		Style.LabelFillColorAndSize(lCourse, "white", 18);
		
		vbCourseCon = new VBox();
		vbCourseCon.getChildren().addAll(new ImageView(new Image("Icon/Course.png")),lCourse);
		VbCon(vbCourseCon,"#a300ff");
		
		lNoOfCourse = new Label(Handler.CourseHandler.GetNoofCourses()+"");
		LNo(lNoOfCourse);
		
		hbNoOfCourseCon = new HBox();
		hbNoOfCourseCon.getChildren().add(lNoOfCourse);
		HbNo(hbNoOfCourseCon,"#a300ff");

		hbCourseCon = new HBox();
		hbCourseCon.getChildren().addAll(vbCourseCon,hbNoOfCourseCon);
		hbCourseCon.setPrefWidth(255);
		
		lStudent = new Label("Student");
		Style.LabelFillColorAndSize(lStudent, "white", 18);
		
		vbStudentCon = new VBox();
		VbCon(vbStudentCon,"#ffa300");
		vbStudentCon.getChildren().addAll(new ImageView(new Image("Icon/Student.png")),lStudent);

		lNoOfStudent = new Label(Handler.StudentHandler.GetNoofStudent()+"");
		LNo(lNoOfStudent);

		hbNoOfStudentCon = new HBox();
		HbNo(hbNoOfStudentCon,"#ffa300");
		hbNoOfStudentCon.getChildren().add(lNoOfStudent);

		hbStudentCon = new HBox();
		hbStudentCon.getChildren().addAll(vbStudentCon,hbNoOfStudentCon);
		hbStudentCon.setPrefWidth(255);		

		lSection = new Label("Section");
		Style.LabelFillColorAndSize(lSection, "white", 18);
		
		vbSectionCon = new VBox();
		vbSectionCon.getChildren().addAll(new ImageView(new Image("Icon/Section.png")),lSection);
		VbCon(vbSectionCon,"#198c19");
		
		lNoOfSection = new Label(Handler.SectionHandler.GetNoofSection()+"");
		LNo(lNoOfSection);
		
		hbNoOfSectionCon = new HBox();
		hbNoOfSectionCon.getChildren().add(lNoOfSection);
		HbNo(hbNoOfSectionCon,"#198c19");

		hbSectionCon = new HBox();
		hbSectionCon.getChildren().addAll(vbSectionCon,hbNoOfSectionCon);
		hbSectionCon.setPrefWidth(255);
		
		lExpense = new Label("Expense");
		Style.LabelFillColorAndSize(lExpense, "white", 18);
		
		vbExpenseCon = new VBox();
		vbExpenseCon.getChildren().addAll(new ImageView(new Image("Icon/Expense.png")),lExpense);
		VbCon(vbExpenseCon,"#0000ff");
		vbExpenseCon.setPrefWidth(500);
		
		lNoOfExpense = new Label(Handler.ExpenseHandler.GetTotalAmountForDashboard()+" ks");
		LNo(lNoOfExpense);
		lNoOfExpense.setPrefWidth(500);
		
		hbNoOfExpenseCon = new HBox();
		hbNoOfExpenseCon.getChildren().add(lNoOfExpense);
		HbNo(hbNoOfExpenseCon,"#0000ff");
		hbNoOfExpenseCon.setPrefWidth(500);

		hbExpenseCon = new HBox();
		hbExpenseCon.getChildren().addAll(vbExpenseCon,hbNoOfExpenseCon);
		hbExpenseCon.setPrefWidth(540);
		
		lStaff = new Label("Staff");
		Style.LabelFillColorAndSize(lStaff, "white", 18);
		
		vbStaffCon = new VBox();
		vbStaffCon.getChildren().addAll(new ImageView(new Image("Icon/Teacher.png")),lStaff);
		VbCon(vbStaffCon,"#0000ff");
		
		lNoOfStaff = new Label(Handler.StaffHandler.GetNoStaff()+"");
		LNo(lNoOfStaff);
		
		hbNoOfStaffCon = new HBox();
		hbNoOfStaffCon.getChildren().add(lNoOfStaff);
		HbNo(hbNoOfStaffCon,"#0000ff");

		hbStaffCon = new HBox();
		hbStaffCon.getChildren().addAll(vbStaffCon,hbNoOfStaffCon);
		hbStaffCon.setPrefWidth(255);
		
		lIncome = new Label("Income");
		Style.LabelFillColorAndSize(lIncome, "white", 18);
		
		vbIncomeCon = new VBox();
		vbIncomeCon.getChildren().addAll(new ImageView(new Image("Icon/Income.png")),lIncome);
		VbCon(vbIncomeCon,"#198c19");
		vbIncomeCon.setPrefWidth(500);

		lNoOfIncome = new Label(Handler.IncomeReportHandler.TotalIncomeForDashboard(Login.userpos)+" ks");
		LNo(lNoOfIncome);
		lNoOfIncome.setPrefWidth(500);

		hbNoOfIncomeCon = new HBox();
		hbNoOfIncomeCon.getChildren().add(lNoOfIncome);
		HbNo(hbNoOfIncomeCon,"#198c19");
		hbNoOfIncomeCon.setPrefWidth(500);

		hbIncomeCon = new HBox();
		hbIncomeCon.getChildren().addAll(vbIncomeCon,hbNoOfIncomeCon);
		hbIncomeCon.setPrefWidth(540);
		
		hb1stReportCon = new HBox();
		hb1stReportCon.setPrefSize(1080,100);
		Style.HBoxFillColorAndSizeAndPadding(hb1stReportCon, "white", 10, 10, 20);
		
		hb2ndReportCon = new HBox();
		Style.HBoxFillColorAndSizeAndPadding(hb2ndReportCon, "white", 10, 10, 20);
		hb2ndReportCon.setPrefSize(1080,100);
		
		if(Login.userpos.equals("1"))
		{
			vbChart = vbChart();
			
			hb1stReportCon.getChildren().addAll(hbCourseCon,hbSectionCon,hbStaffCon,hbStudentCon);
			hb2ndReportCon.getChildren().addAll(hbIncomeCon,hbExpenseCon);

			vbDashboardView.getChildren().addAll(hb1stReportCon,hb2ndReportCon,vbChart);
		}
		GetDay.CurrentDateTime.getDay();
		if(Login.userpos.equals("2"))
		{
			vbIncomeCon.setPrefWidth(255);
			hbNoOfIncomeCon.setPrefWidth(255);
			lNoOfIncome.setPrefWidth(255);
			vbChart = new VBox();
			hb1stReportCon.getChildren().addAll(hbCourseCon,hbSectionCon,hbStudentCon,hbIncomeCon);
			vbChart.getChildren().addAll(tvStudentPayment);
			vbChart.setPadding(new Insets(10,30,10,30));
			
			vbDashboardView.getChildren().addAll(hb1stReportCon,vbChart);
			lNoOfIncome.setText(Handler.IncomeReportHandler.getTotalAmount("",GetDay.CurrentDateTime.dd, GetDay.CurrentDateTime.mm, GetDay.CurrentDateTime.yyyy)+" Ks");
		}
		vbDashboardView.setPrefSize(1080, 638);
		vbDashboardView.setSpacing(10);
		return vbDashboardView;
	}
	private static VBox vbChart()
	{
		VBox vbChart = new VBox();
		int noofDays = 31;
		
		NumberAxis xAxis = new NumberAxis(1, 31, 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number,Number> ac = 
            new AreaChart<Number,Number>(xAxis,yAxis);
        ac.setTitle("Income Vs Expenses");
        
		String s[] = {"9","4","6","1"};
		GetDay.CurrentDateTime.getDay();
		String mm = GetDay.CurrentDateTime.mm;
		int yy = Integer.parseInt(GetDay.CurrentDateTime.yyyy);
		for(String m:s)
		{
			if(mm.equals(m))
			{
				xAxis = new NumberAxis(1, 30, 1);
				noofDays = 30;
			}
		}
		
		if(mm.equals("2"))
		{
			if(yy%4==0 || (yy%100==0 && yy%400 == 0))
			{
				xAxis = new NumberAxis(1, 29, 1);
				noofDays = 29;
			}
			else
			{
				xAxis = new NumberAxis(1, 28, 1);
				noofDays = 28;
			}
		}
		
		else
		{
			xAxis = new NumberAxis(1, 31, 1);
			noofDays = 31;

		}
		XYChart.Series seriesIncome= new XYChart.Series();
        seriesIncome.setName("6-2021 Income");
        
       
       for(int i= 0 ; i <noofDays;i++)
        {
        	 seriesIncome.getData().add(new XYChart.Data(i+1,Handler.IncomeReportHandler.getIncomeForDashboardChart((i+1)+"", mm, yy+"")));
        }
        
        XYChart.Series seriesExpense = new XYChart.Series();
        seriesExpense.setName("6-2021 Expense");
        
        for(int i= 0 ; i <noofDays;i++)
        {
        	 seriesExpense.getData().add(new XYChart.Data(i+1,Handler.ExpenseHandler.GetTotalAmount("",(i+1)+"", mm, yy+"")));
        }
        ac.getData().addAll(seriesIncome, seriesExpense);

//		VBox vbChart = new VBox();
//		
//		NumberAxis xAxis = new NumberAxis(1, 12, 1);
//        final NumberAxis yAxis = new NumberAxis();
//        final AreaChart<Number,Number> ac = 
//            new AreaChart<Number,Number>(xAxis,yAxis);
//        ac.setTitle("Income Vs Expenses");
//        
//		
//		xAxis = new NumberAxis(1, 12, 1);
//		GetDay.CurrentDateTime.getDay();
//		String yy  = GetDay.CurrentDateTime.yyyy;
//			
//		XYChart.Series seriesIncome= new XYChart.Series();
//        seriesIncome.setName(yy+" Income");
//        
//       
//       for(int i= 0 ; i <12;i++)
//        {
//        	 seriesIncome.getData().add(new XYChart.Data(i+1,Handler.IncomeReportHandler.getIncomeForDashboardChart("",(i+1)+"",yy)));
//        }
//        
//        XYChart.Series seriesExpense = new XYChart.Series();
//        seriesExpense.setName(yy+" Expense");
//        
//        for(int i= 0 ; i <12;i++)
//        {
//        	 seriesExpense.getData().add(new XYChart.Data(i+1,Handler.ExpenseHandler.GetTotalAmount("","",(i+1)+"" , yy)));
//        }
//        ac.getData().addAll(seriesIncome, seriesExpense);
//        
		
        vbChart.getChildren().add(ac);
        vbChart.setPrefWidth(1080);
        return vbChart;
	}
	
}
