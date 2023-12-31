package View;
import java.sql.Date;
import java.util.ArrayList;

import List.CourseLists;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
public class PieChartView {
	
	
	public static HBox hbPieChartView(String title,String day,String month,String year)
	{
		 HBox hbGeneralPieChartView = new HBox();
//		       
//		 
//		 if(title == "Income")
//		 {
//			 
//			 ArrayList<CourseLists> c = Handler.CourseHandler.GetDeletePlusCurrentCourse();
//			 if(c.size() > 0)
//			 {
//				 ObservableList<PieChart.Data> incomePieChartData = new ObservableList<PieChart.Data>;
//				 PieChart.Data psIncome = null;
//				 for(CourseLists s:c)
//				 {
////					 incomePieChartData = FXCollections.observableArrayList(
////					         new PieChart.Data(title+"1", 13), 
////					         new PieChart.Data(title+"2", 25), 
////					         new PieChart.Data(title+"3", 10), 
////					         new PieChart.Data(title+"4", 22)); 
//					 psIncome= new PieChart.Data(s.getCourseName(),Handler.IncomeReportHandler.getTotalAmount(s.getCourseName(), day, month, year));
//					 incomePieChartData.add(psIncome);
//				 }
//
//			      PieChart pieChart = new PieChart(incomePieChartData); 
//			         
//			      pieChart.setTitle(title); 
//			       
//			      pieChart.setClockwise(true); 
//			       
//			      pieChart.setLabelLineLength(50); 
//
//			      pieChart.setLabelsVisible(true); 
//			       
//			      pieChart.setStartAngle(180);
//			      pieChart.setPrefSize(400, 400);
//			      hbGeneralPieChartView.getChildren().add(pieChart);
//			    }
//			 }
//		 if(title == "Both")
//		 {
//			  
//				 ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
//				            new PieChart.Data("Income", 1),
//				            new PieChart.Data("Expense", 1),
//				            new PieChart.Data("Profit", 0));
//
//			      PieChart pieChart = new PieChart(pieChartData); 
//			      pieChart.setTitle("Income Vs Expens Vs Profit"); 
//			      pieChart.setClockwise(true); 
//			      pieChart.setLabelLineLength(50); 
//			      pieChart.setLabelsVisible(true); 
//			      pieChart.setStartAngle(180);
//			      pieChart.setPrefSize(400, 400);
//			      hbGeneralPieChartView.getChildren().add(pieChart);
//		 }
////		 
////		 if(title == "Expense")
////		 {		
////			 	ObservableList<PieChart.Data> pieChartData = null;
////				 ArrayList <String> ecLists = Handler.ExpenseCategoryHandler.getExpenseCategoryList(2);
////				 if(ecLists.size() > 0)
////				 {
////					 PieChart.Data psExpense = null;
////					 for(String s:ecLists)
////					 {
////						 psExpense= new PieChart.Data("Expense",Handler.ExpenseHandler.GetTotalAmount(s, day, month, year));
////					 }
////					 pieChartData.add(psExpense);
////
////				      PieChart pieChart = new PieChart(pieChartData); 
////				      pieChart.setTitle("Income Vs Expens Vs Profit"); 
////				      pieChart.setClockwise(true); 
////				      pieChart.setLabelLineLength(50); 
////				      pieChart.setLabelsVisible(true); 
////				      pieChart.setStartAngle(180);
////				      pieChart.setPrefSize(400, 400);
////				      hbGeneralPieChartView.getChildren().add(pieChart);
////				    }
////		 }
		  return hbGeneralPieChartView;
	}
	
}
