package View;

import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class GeneralReportView {
	private static VBox vbProgressContainer;
	private static ProgressBar incomeProgressBar,expenseProgressBar,profitProgressBar;;//fineProgressBar;
	private static Label lIncomeProgressTitle,lExpenseProgressTitle,lProfitProgressTitle;//lFineProgressTitle;
	private static VBox vbIncomeProgressContainer,vbExpenseProgressContainer,vbProfitProgressContainer;//vbFineProgressContainer;
	private static HBox hbPieChartView,hbChartViewView;
	private static HBox hbFirstPart;
	private static HBox hbSecondPart;
	private static VBox vbGeneralReportView;
	private static HBox hbChartView;
	public static VBox vbGeneralReportView(String day,String month,String year)
	{
		vbProgressContainer = new VBox();
		
		int income = Handler.IncomeReportHandler.getTotalAmount("", day, month, year);
		System.out.print(income);
		int expense = Handler.ExpenseHandler.GetTotalAmount("", day, month, year);
		int profit = income - expense;
		
		int times = 1;
		int divisor = 1;
		if(income > expense)
		{
				divisor = (int) Math.pow(10, (income+"").length());				
		}
		else
		{
			divisor = (int) Math.pow(10, (expense+"").length());				
		}
		
		incomeProgressBar = new ProgressBar(0);
		incomeProgressBar.setPrefSize(400, 10);
		
        incomeProgressBar.setProgress(((float)income/(float)divisor));
        
        lIncomeProgressTitle = new Label("Income");
        lIncomeProgressTitle.setTextFill(Color.WHITE);
        lIncomeProgressTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

        vbIncomeProgressContainer = new VBox();
        vbIncomeProgressContainer.getChildren().addAll(lIncomeProgressTitle,incomeProgressBar);
        vbIncomeProgressContainer.setSpacing(10);

        expenseProgressBar = new ProgressBar(0);
        expenseProgressBar.setPrefSize(400, 10);
		
        expenseProgressBar.setProgress(((float)expense/(float)divisor));
        
        lExpenseProgressTitle = new Label("Expense");
        lExpenseProgressTitle.setTextFill(Color.WHITE);
        lExpenseProgressTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

        vbExpenseProgressContainer = new VBox();
        vbExpenseProgressContainer.getChildren().addAll(lExpenseProgressTitle,expenseProgressBar);
        vbExpenseProgressContainer.setSpacing(10);
        
        profitProgressBar = new ProgressBar(0);
        profitProgressBar.setPrefSize(400, 10);
		
        profitProgressBar.setProgress(((float)(income-expense)/(float)divisor));
        
        lProfitProgressTitle = new Label("Profit");
        lProfitProgressTitle.setTextFill(Color.WHITE);
        lProfitProgressTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));

        vbProfitProgressContainer = new VBox();
        vbProfitProgressContainer.getChildren().addAll(lProfitProgressTitle,profitProgressBar);
        vbProfitProgressContainer.setSpacing(0);
        
//        fineProgressBar = new ProgressBar(0);
//        fineProgressBar.setPrefSize(400, 10);
//		
//        fineProgressBar.setProgress(0.1);
//        
//        lFineProgressTitle = new Label("Fine");
//        lFineProgressTitle.setTextFill(Color.WHITE);
//        lFineProgressTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
//
//        vbFineProgressContainer = new VBox();
//        vbFineProgressContainer.getChildren().addAll(lFineProgressTitle,fineProgressBar);
//        vbFineProgressContainer.setSpacing(10);
//         
        vbProgressContainer.getChildren().addAll(vbIncomeProgressContainer,vbExpenseProgressContainer,vbProfitProgressContainer);
        vbProgressContainer.setSpacing(10);
        vbProgressContainer.setPadding(new Insets(10,0,0,0));
        
        hbFirstPart = new HBox();
        hbFirstPart.getChildren().addAll(vbProgressContainer);
        hbFirstPart.setSpacing(50);
        
      
        hbChartView = AreaChartView.hbAreaChartView("Both", day,month,year);
        
        hbSecondPart = new HBox();
        hbSecondPart.getChildren().add(hbChartView);
        
        vbGeneralReportView = new VBox();
        vbGeneralReportView.getChildren().addAll(hbFirstPart,hbSecondPart);
        vbGeneralReportView.setSpacing(10);
        vbGeneralReportView.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
        vbGeneralReportView.setPadding(new Insets(0,10,0,10));
       
        //Event Listener
        expenseProgressBar.setOnMouseClicked(e->{
        	hbSecondPart.getChildren().remove(hbChartView);
        	hbFirstPart.getChildren().remove(hbPieChartView);
        	hbChartView = AreaChartView.hbAreaChartView("Expense",day,month,year);
        	hbSecondPart.getChildren().add(hbChartView);
        });
        incomeProgressBar.setOnMouseClicked(e->{
        	hbSecondPart.getChildren().remove(hbChartView);
        	hbFirstPart.getChildren().remove(hbPieChartView);
        	hbChartView = AreaChartView.hbAreaChartView("Income", day,month,year);
        	hbSecondPart.getChildren().add(hbChartView);
        });
        profitProgressBar.setOnMouseClicked(e->{
        	hbSecondPart.getChildren().remove(hbChartView);
        	hbFirstPart.getChildren().remove(hbPieChartView);
        	hbChartView = AreaChartView.hbAreaChartView("Both",day,month,year);
//        	hbPieChartView = PieChartView.hbPieChartView("Both",day,month,year);
//        	hbFirstPart.getChildren().add(hbPieChartView);
        	hbSecondPart.getChildren().add(hbChartView);
        });
//        fineProgressBar.setOnMouseClicked(e->{
//        	hbSecondPart.getChildren().remove(hbChartView);
//        	hbFirstPart.getChildren().remove(hbPieChartView);
//        	hbChartView = BarChartView.hbAreaChartView("Fine", "", "", "");
////        	hbPieChartView = PieChartView.hbPieChartView("Fine", "", "", "");
//        	hbFirstPart.getChildren().add(hbPieChartView);
//        	hbSecondPart.getChildren().add(hbChartView);
       // });
		return vbGeneralReportView;
	}
	
//	public static float  GetIncomePoint(float value)
//	{
//		int times = 1;
//		int divisor = 1;
//		if((value+"").length()>4)
//		{
//			times = ((value+"").length()) - 4;
//			for(int i=0;i<times;i++)
//			{
//				divisor = divisor * 10; 
//			}
//		}
//	}
}
