package View;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ProfitReportView {
	private static VBox vbReportView;
	private static Label lIncome;
	private static Label lExpense;
	private static Label lProfit;
	private static String date="";
	private static String title;
	public static VBox vbReportView(String day,String month,String year)
	{
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
		
		int income = Handler.IncomeReportHandler.getTotalAmount("", day, month, year);
		
		lIncome = new Label(date+" Income = "+income+" Ks");
		lIncome.setTextFill(Color.WHITE);
		lIncome.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		lIncome.setStyle("-fx-border-style:solid none none none;-fx-border-width:3;-fx-border-color:#3493db;");
		lIncome.setPrefWidth(1080);
		lIncome.setPadding(new Insets(10,15,0,10));

		int expense = Handler.ExpenseHandler.GetTotalAmount("", day, month, year);
		lExpense = new Label(date+" Expense = "+expense+" Ks");
		lExpense.setTextFill(Color.WHITE);
		lExpense.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		lExpense.setStyle("-fx-border-style:solid none none none;-fx-border-width:3;-fx-border-color:#3493db;");
		lExpense.setPrefWidth(1080);
		lExpense.setPadding(new Insets(10,15,0,10));

		int profit = income - expense;

		lProfit = new Label(date+" Profit = "+profit+" Ks");
		lProfit.setTextFill(Color.WHITE);
		lProfit.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		lProfit.setStyle("-fx-border-style:solid none none none;-fx-border-width:3;-fx-border-color:#3493db;");
		lProfit.setPrefWidth(1080);
		lProfit.setPadding(new Insets(10,15,0,10));
		
		if(profit > 0)
		{
			lProfit.setTextFill(Color.GREEN);
		}
		else
		{
			lProfit.setTextFill(Color.RED);
		}

		HBox hb =  AreaChartView.hbAreaChartView(date+" Profit", day,month,year);
		
		vbReportView.getChildren().addAll(hb,lIncome,lExpense,lProfit);
		vbReportView.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
	    vbReportView.setSpacing(30);
	    vbReportView.setPadding(new Insets(20,10,20,10));
	    return vbReportView;
	}
}
