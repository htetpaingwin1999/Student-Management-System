package View;
import java.util.ArrayList;

import Handler.AdminHandler;
import Handler.DesignationHandler;
import Handler.IncomeReportHandler;
import List.AdminLists;
import List.CourseLists;
import List.DesignationLists;
import List.ExpenseReportLists;
import List.IncomeReportLists;
import Table.DesignationTable;
import Table.IncomeReportTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class ReportView {
	private static VBox vbReportListsView;
	
	private static Button btnCalculate;
	private static TextField tInput;
	private static HBox hbInputContainer;
	private static VBox vbReportContainer;
	private static String day="",month="",year="";	
	private static VBox vbContentContainer;
	private static HBox hbToggleContainer;
	private static ToggleButton tbExpense;
	private static ToggleButton tbGeneral;
	private static ToggleButton tbIncome;
	private static ToggleButton tbProfit;
	private static ToggleButton tbFine;
	private static ToggleButton tbNoofStudents;
	private static int index = 0; // 0= general room  ,1= income , 2=expense room , 3=profit room ,4=fine room, 5 =student room

	public static VBox vbReportListsView()
	{
		GetDay.CurrentDateTime.getDay();
		day = GetDay.CurrentDateTime.dd;
		month = GetDay.CurrentDateTime.mm;
		year = GetDay.CurrentDateTime.yyyy;
		
		tInput = new TextField();
		tInput.setPrefSize(600, 40);
		tInput.setFont(Font.font(20));
		tInput.setPromptText("dd-mm-yyyy");
		
		btnCalculate = new Button("Calculate");
		Style.ButtonFillColorAndSize(btnCalculate, 16, 100, 40, 0, 0, "blue");

		hbInputContainer = new HBox();
		hbInputContainer.getChildren().addAll(tInput,btnCalculate);
		Style.HBoxFillColorAndSizeAndPadding(hbInputContainer, "white", 10, 10, 20);
			
		tbGeneral = new ToggleButton("Overview");
		FillToggleButtonColor(tbGeneral);
		hightLightToggleButtonColor(tbGeneral);
		
		tbExpense = new ToggleButton("Expense");
		FillToggleButtonColor(tbExpense);

		tbIncome = new ToggleButton("Income");
		FillToggleButtonColor(tbIncome);

		tbProfit = new ToggleButton("Profit");
		FillToggleButtonColor(tbProfit);

		tbNoofStudents = new ToggleButton("Course");
		FillToggleButtonColor(tbNoofStudents);

//		tbFine = new ToggleButton("Fine");
//		FillToggleButtonColor(tbFine,1);
		
		hbToggleContainer = new HBox();
		hbToggleContainer.getChildren().addAll(tbGeneral,tbIncome,tbExpense,tbProfit,tbNoofStudents);
		hbToggleContainer.setSpacing(5);

		vbContentContainer = new VBox();
		vbContentContainer.getChildren().addAll(hbToggleContainer,GeneralReportView.vbGeneralReportView(GetDay.CurrentDateTime.dd, GetDay.CurrentDateTime.mm,GetDay.CurrentDateTime.yyyy));
		vbContentContainer.setPadding(new Insets(10,10,10,10));
		
		vbReportListsView = new VBox();
		vbReportListsView.getChildren().addAll(hbInputContainer,vbContentContainer);
		Style.VBoxFillColorAndSizeAndPadding(vbReportListsView, "white", 10, 10, 20);
	
		btnCalculate.setOnAction(e->{
			day = "";
			month = "";
			year = "";
			String [] arr = tInput.getText().split("-");
			switch(arr.length) {
			case 1: year = arr[0];
					break;
						
			case 2:	month = arr[0];
					year = arr[1];
					break;
					
			case 3:	day = arr[0];
					month = arr[1];
					year = arr[2];
					break;	
					
//			case 4: day = arr[0];
//					month = arr[1];
//					year = arr[2];
//					break;		
			}
			
			if(index ==0)
			{
				vbContentContainer.getChildren().clear();
				vbContentContainer.getChildren().addAll(hbToggleContainer,GeneralReportView.vbGeneralReportView(day,month,year));
			}
			
			else if(index ==1)
			{
				vbContentContainer.getChildren().clear();
				vbContentContainer.getChildren().addAll(hbToggleContainer,IncomeExpenseFineStudentReportView.vbReportView("Subject",0, day, month, year));
			}
			
			else if(index == 2)
			{
				vbContentContainer.getChildren().clear();
				vbContentContainer.getChildren().addAll(hbToggleContainer,IncomeExpenseFineStudentReportView.vbReportView("Expense Category", 1, day, month, year));
			}
			else if(index ==3)
			{
				vbContentContainer.getChildren().clear();
				vbContentContainer.getChildren().addAll(hbToggleContainer,ProfitReportView.vbReportView(day, month, year));
			}
//			else if(index ==4)
//			{
//				
//			}
			else if(index ==5)
			{
				vbContentContainer.getChildren().clear();
				vbContentContainer.getChildren().addAll(hbToggleContainer,IncomeExpenseFineStudentReportView.vbReportView("Subject",2, day, month, year));
			}
		});
		
		tbGeneral.setOnAction(e->{
			vbContentContainer.getChildren().clear();
			vbContentContainer.getChildren().addAll(hbToggleContainer,GeneralReportView.vbGeneralReportView(day,month,year));
			lowOpacityInToggleButton();
			hightLightToggleButtonColor(tbGeneral);
			index = 0;
		});
		
		tbIncome.setOnAction(e->{	
			vbContentContainer.getChildren().clear();
			vbContentContainer.getChildren().addAll(hbToggleContainer,IncomeExpenseFineStudentReportView.vbReportView("Subject",0, day, month, year));
			lowOpacityInToggleButton();
			hightLightToggleButtonColor(tbIncome);
			index = 1;
		});
		
		tbExpense.setOnAction(e->{
			vbContentContainer.getChildren().clear();
			vbContentContainer.getChildren().addAll(hbToggleContainer,IncomeExpenseFineStudentReportView.vbReportView("Expense Category", 1, day, month, year));
			lowOpacityInToggleButton();
			hightLightToggleButtonColor(tbExpense);
			index = 2;
		});
				
		tbProfit.setOnAction(e->{
			vbContentContainer.getChildren().clear();
			vbContentContainer.getChildren().addAll(hbToggleContainer,ProfitReportView.vbReportView(day, month, year));
			lowOpacityInToggleButton();
			hightLightToggleButtonColor(tbProfit);
			index = 3;
		});
//		
//		tbFine.setOnAction(e->{
//			tbExpense.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
//			tbIncome.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
//			tbProfit.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
//			tbNoofStudents.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
//			tbFine.setStyle("-fx-background-color:#3493db;-fx-opacity:1;");
//			index = 4;
//		});
		
		tbNoofStudents.setOnAction(e->{
			vbContentContainer.getChildren().clear();
			vbContentContainer.getChildren().addAll(hbToggleContainer,IncomeExpenseFineStudentReportView.vbReportView("", 2, day, month, year));
			lowOpacityInToggleButton();
			hightLightToggleButtonColor(tbNoofStudents);
			index = 5;
		});
		
		return vbReportListsView;
	}
	private static void hightLightToggleButtonColor(ToggleButton t)
	{
		t.setStyle("-fx-background-color:#3493db;-fx-opacity:1;");
	}
	private static void lowOpacityInToggleButton()
	{
		tbGeneral.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
		tbIncome.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
		tbExpense.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
		tbProfit.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
		tbNoofStudents.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
	}
	private static void FillToggleButtonColor(ToggleButton t)
	{
		t.setPrefSize(150, 50);
		t.setTextFill(Color.WHITE);
		t.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		t.setStyle("-fx-background-color:#3493db;-fx-opacity:0.3;");
	}
}
