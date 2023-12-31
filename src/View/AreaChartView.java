package View;
import java.sql.Date;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
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
public class AreaChartView {
	public static HBox hbAreaChartView(String title,String day,String month,String year)
	{ HBox hbAreaChartView = new HBox();
	
	 int noofDays = 31;
	 int noofMonths = 12;
		
	 NumberAxis xAxis;
	 NumberAxis yAxis = new NumberAxis();
	 AreaChart<Number,Number> ac;
   
   if(!month.equals("") && !year.equals(""))
	{
		try
		{
			int yy = Integer.parseInt(year);
			String s[] = {"9","4","6","1"};
			GetDay.CurrentDateTime.getDay();
			String mm = month;
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
			
			ac =  new AreaChart<Number,Number>(xAxis,yAxis);
	        ac.setTitle("Income Vs Expenses");
			ac.prefWidth(1000);

			XYChart.Series seriesIncome= new XYChart.Series();
	        seriesIncome.setName(month+"-"+year+" Income");
	       
	       for(int i= 0 ; i <noofDays;i++)
	        {
	        	 seriesIncome.getData().add(new XYChart.Data(i+1,Handler.IncomeReportHandler.getIncomeForDashboardChart((i+1)+"", mm, yy+"")));
	        }
	        
	        XYChart.Series seriesExpense = new XYChart.Series();
	        seriesExpense.setName(month+"-"+year+" Expense");
	        
	        for(int i= 0 ; i <noofDays;i++)
	        {
	        	 seriesExpense.getData().add(new XYChart.Data(i+1,Handler.ExpenseHandler.GetTotalAmount("",(i+1)+"", mm, yy+"")));
	        }
	        
	        if(title.equals("Both"))
	        {
		        ac.getData().addAll(seriesIncome, seriesExpense);

	        }
	        else if(title.equals("Income"))
	        {
		        ac.getData().addAll(seriesIncome);
		        ac.setTitle("Income");

	        }
	        else if(title.equals("Expense"))
	        {
		        ac.getData().addAll(seriesExpense);
		        ac.setTitle("Expense");
	        }
	        else {
		        ac.getData().addAll(seriesIncome, seriesExpense);
		        ac.setTitle("Profit");
	        }
	        
	        ac.setPrefWidth(1000);
	        hbAreaChartView.getChildren().add(ac);

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	if(month.equals("") && !year.equals(""))
	{
		xAxis = new NumberAxis(1,12, 1);
		XYChart.Series seriesIncome= new XYChart.Series();
       seriesIncome.setName(year+" Income");
       
       XYChart.Series seriesExpense= new XYChart.Series();
       seriesExpense.setName(year+" Expense");
		 for(int i= 0 ; i <12;i++)
	       {
	         seriesIncome.getData().add(new XYChart.Data(i+1,Handler.IncomeReportHandler.getIncomeForDashboardChart("", (i+1)+"", year+"")));
	       }
       for(int i= 0 ; i <12;i++)
	       {
       	 seriesExpense.getData().add(new XYChart.Data(i+1,Handler.ExpenseHandler.GetTotalAmount("","",(i+1)+"", year+"")));
	       }
       
       ac =  new AreaChart<Number,Number>(xAxis,yAxis);
       ac.setTitle("Income Vs Expenses");
		ac.prefWidth(1000);
		
		 if(title.equals("Both"))
	        {
		        ac.getData().addAll(seriesIncome, seriesExpense);

	        }
	        else if(title.equals("Income"))
	        {
		        ac.getData().addAll(seriesIncome);
		        ac.setTitle("Income");

	        }
	        else if(title.equals("Expense"))
	        {
		        ac.getData().addAll(seriesExpense);
		        ac.setTitle("Expense");
	        }
	        else {
		        ac.getData().addAll(seriesIncome, seriesExpense);
		        ac.setTitle("Profit");
	        }
	        ac.setPrefWidth(1000);
       hbAreaChartView.getChildren().add(ac);

	 }
   return hbAreaChartView;
	}
}
