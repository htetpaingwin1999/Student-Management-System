package View;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

import Handler.CourseStudentReportHandler;
import List.CourseLists;
import List.CourseStudentReportLists;
import List.ExpenseLists;
import List.ExpenseReportLists;
import List.IncomeReportLists;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
public class IncomeExpenseFineStudentReportView {
	private static VBox vbReportView;
	private static TableView tvReport;
	private static ComboBox cbChoose;
	private static Label lChoose;
	private static HBox hbChooseContainer;
	private static Label lTotalAmount;
	private static Label lTotal;
	private static HBox hbTotalContainer;
	private static VBox vbFirstPart;
	private static VBox vbSecondPart;
	private static BorderPane bp;
	private static ArrayList<String> cl;
	private static Button btnSearch;
	private static ObservableList <IncomeReportLists> dataIncome;
	private static ObservableList<ExpenseLists> dataExpense;
	private static ObservableList <CourseStudentReportLists> dataCourseStudent;
	private static String chooseValue;
	private static String date;

	public static VBox vbReportView(String category,int choose,String day,String month,String year)
	{
		String [] tabName = {"Income","Expense","Course"};
		chooseValue = "";
		
		vbReportView = new VBox();
		
		
		if(!year.equals("") && !month.equals("") && !day.equals(""))
		{
			date = year+"-"+month+"-"+day+" ";
		}
		else if(!year.equals("") && !month.equals("") && day.equals(""))
		{
			date = year+"-"+month+" ";
		}
		else if(!year.equals("") && month.equals("") && day.equals(""))
		{
			date = year +" ";
		}
		else
		{
			date = "Invalid date";
		}
		lChoose = new Label(category+"");
		lChoose.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		lChoose.setTextFill(Color.WHITE);
		
		cbChoose = new ComboBox();
		
		btnSearch = new Button("Filter");
		btnSearch.setStyle("-fx-background-color:blue");
		btnSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 16));
		btnSearch.setTextFill(Color.WHITE);
		btnSearch.setPrefWidth(100);
		
		hbChooseContainer = new HBox();
		hbChooseContainer.setSpacing(20);
		hbChooseContainer.setPrefSize(200,50);
		
		lTotal =  new Label(date);
		lTotal.setTextFill(Color.BLUE);
		lTotal.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 2));
		
		lTotalAmount = new Label("");
		lTotalAmount.setTextFill(Color.WHITE);
		lTotalAmount.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		
		hbTotalContainer = new HBox();
		
		hbTotalContainer.getChildren().addAll(lTotalAmount,lTotal);
		hbTotalContainer.setSpacing(20);
		hbTotalContainer.setPadding(new Insets(10,0,10,0));

		if(choose == 0 || choose == 2) // subject for income
		{
			hbTotalContainer.getChildren().clear();
			
			cl = Handler.CourseHandler.GetAllCourseName(2);
			for(String s:cl)
			{
				cbChoose.getItems().addAll(s);
			}
			if(cl.size() > 0)
			{
				cbChoose.getSelectionModel().select(0);
			}
			hbChooseContainer.getChildren().clear();
			
			if(choose == 0)
			{
				hbChooseContainer.getChildren().addAll(lChoose,cbChoose,btnSearch);
				tvReport = Table.IncomeReportTable.tvReportLists();
				dataIncome = FXCollections.observableArrayList(Handler.IncomeReportHandler.GetTotalIncome(day, month, year));
				if(Handler.IncomeReportHandler.getTotalAmount(chooseValue, day, month, year) >0)
				{
					tvReport.setItems(dataIncome);
				}
				lTotalAmount.setText("Total = "+Handler.IncomeReportHandler.getTotalAmount(chooseValue, day, month, year)+" Ks");
				hbTotalContainer.getChildren().addAll(lTotal,lTotalAmount);
			}
			else
			{
				tvReport = Table.CourseStudentReportTable.tvReportLists();
				dataCourseStudent = FXCollections.observableArrayList(Handler.CourseStudentReportHandler.getNoofStudentByCourse(day, month, year));
				tvReport.setItems(dataCourseStudent);
				lTotalAmount.setText("Total = "+CourseStudentReportHandler.getNoofStudentByCourse(day, month, year).size()+" Person");
				hbTotalContainer.getChildren().addAll(lTotal,lTotalAmount);
			}
		}
		if(choose == 1)
		{
			hbTotalContainer.getChildren().clear();
			hbChooseContainer.getChildren().addAll(lChoose,cbChoose,btnSearch);
			cl = Handler.ExpenseCategoryHandler.getExpenseCategoryList(0);
			String value = "";
			for(String s:cl)
			{
				cbChoose.getItems().addAll(s);
			}
			
			cbChoose.getSelectionModel().select(0);
			tvReport = Table.ExpenseTable.tvExpenseLists(2);
			dataExpense = FXCollections.observableArrayList(Handler.ExpenseHandler.ExpenseReport(chooseValue,day, month, year));
			tvReport.setItems(dataExpense);
			lTotalAmount.setText("Total = "+Handler.ExpenseHandler.GetTotalAmount(chooseValue, day, month, year)+" Ks");
			hbTotalContainer.getChildren().addAll(lTotal,lTotalAmount);
		}
		vbFirstPart = new VBox();
		vbFirstPart.getChildren().addAll(hbChooseContainer,tvReport);
		vbFirstPart.setSpacing(5);
		
		vbSecondPart = new VBox();
		vbSecondPart.getChildren().add(hbTotalContainer);
		
		bp = new BorderPane();
		bp.setTop(vbFirstPart);
		bp.setBottom(vbSecondPart);
		
		vbReportView.getChildren().add(bp);
		vbReportView.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
	    vbReportView.setPadding(new Insets(10,10,0,10));
	            
		
		btnSearch.setOnAction(e->{			
				vbFirstPart.getChildren().remove(tvReport);
				if(cl.size() > 0)
				{
					chooseValue = cbChoose.getValue().toString();
				}
				
				if(choose == 0)
				{
					tvReport = Table.IncomeReportTable.tvReportLists();
					dataIncome = FXCollections.observableArrayList(Handler.IncomeReportHandler.GetIncomeBySub(chooseValue,day, month, year));
					tvReport.getItems().clear();
					if(Handler.IncomeReportHandler.getTotalAmount(chooseValue, day, month, year) >0)
					{
						tvReport.setItems(dataIncome);
					}
					lTotalAmount.setText("Total = "+Handler.IncomeReportHandler.getTotalAmount(chooseValue, day, month, year)+" Ks");
				}
				else if(choose == 1)
				{
					tvReport = Table.ExpenseTable.tvExpenseLists(2);
					dataExpense = FXCollections.observableArrayList(Handler.ExpenseHandler.ExpenseReport(chooseValue,day, month, year));
					tvReport.setItems(dataExpense);
					lTotalAmount.setText("Total = "+Handler.ExpenseHandler.GetTotalAmount(chooseValue, day, month, year)+" Ks");
				}
				vbFirstPart.getChildren().add(tvReport);
			
		});
		vbReportView.setPadding(new Insets(10,30,10,30));
		vbReportView.setPrefHeight(500);
		return vbReportView;
	}
}
