package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.ExpenseHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

public class ExpenseDataView {
	private static VBox vbAddExpenseView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lExpenseID;
	public static Label llExpenseID;
	private static Label lAmount;
	public static Label llAmount;
	
	public static Label lExpenseCategoryID;
	private static Label llExpenseCategoryID;
	private static Label lExpenseCategoryName;
	private static Label llExpenseCategoryName;
	public static Label lNote;
	private static Label llNote;
	
	private static Label lAdminID;
	private static Label llAdminID;
	private static Label lAdminName;
	private static Label llAdminName;
	private static Label lAddDate;
	public static Label llAddDate;
	
	private static VBox vbExpenseDataPart;
	private static HBox hbExpenseTitlePart;
	private static Label  lExpenseTitle;
	private static GridPane gpExpenseDataPart;

	
	private static VBox vbExpenseCategoryDataPart;
	private static HBox hbExpenseCategoryTitlePart;
	private static Label lExpenseCategoryTitle;
	private static GridPane gpExpenseCategoryDataPart;

	private static VBox vbAdminDataPart;
	private static HBox hbAdminTitlePart;
	private static Label  lAdminDataTitle;
	private static GridPane gpAdminDataPart;

	public static VBox vbExpenseDataView(int eid,String note,int amount,int ecid,String ecname,int adid,String adName,String addDate)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.lHome.setTextFill(Color.GREY);
            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = ExpenseListsView.vbExpenseListsView();
            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Expense Lists");
		});
		
		vbAddExpenseView = new VBox();
				
		lTitle = new Label("Expense Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 20, 50, 0);
		
		lExpenseID = new Label("Expense ID:");
		Style.LabelFillColorAndSize(lExpenseID, "black", 17);

		llExpenseID = new Label();
		Style.LabelFillColorAndSize(llExpenseID, "grey", 17);
		llExpenseID.setText(eid+"");
		
		lAmount = new Label("Expense Name:");
		Style.LabelFillColorAndSize(lAmount, "black", 17);
		
		llAmount = new Label();
		Style.LabelFillColorAndSize(llAmount, "grey", 17);
		llAmount.setText(amount+"");
		
		lNote = new Label("Note");
		Style.LabelFillColorAndSize(lNote, "black", 17);

		llNote = new Label();
		Style.LabelFillColorAndSize(llNote, "grey", 17);
		llNote.setText(note);;
		
		lExpenseCategoryID = new Label("Expense Category ID:");
		Style.LabelFillColorAndSize(lExpenseCategoryID, "black", 17);


		llExpenseCategoryID = new Label();
		Style.LabelFillColorAndSize(llExpenseCategoryID, "grey", 17);
		llExpenseCategoryID.setText(ecid+"");
		
		lExpenseCategoryName = new Label("ExpenseCategory Name:");
		Style.LabelFillColorAndSize(lExpenseCategoryName, "black", 17);
		
		llExpenseCategoryName = new Label();
		Style.LabelFillColorAndSize(llExpenseCategoryName, "grey", 17);
		llExpenseCategoryName.setText(ecname);
		
		lAdminID = new Label("Admin ID:");
		Style.LabelFillColorAndSize(lAdminID, "black", 17);
		lAdminID.setTextFill(Color.BLACK);
		
		llAdminID = new Label();
		llAdminID.setText(adid+"");
		Style.LabelFillColorAndSize(llAdminID, "grey", 17);

		lAdminName = new Label("Admin Name:");
		Style.LabelFillColorAndSize(lAdminName, "black", 17);
	
		llAdminName = new Label();
		Style.LabelFillColorAndSize(llAdminName, "grey", 17);
		llAdminName.setText(adName);
		
		lAddDate = new Label("Add Date:");
		Style.LabelFillColorAndSize(lAddDate, "black", 17);

		llAddDate = new Label();
		Style.LabelFillColorAndSize(llAddDate, "grey", 17);
		llAddDate.setText(addDate);
		
		vbExpenseCategoryDataPart = new VBox();
		
		hbExpenseCategoryTitlePart = new HBox();
		
		ImageView imgExpenseCategoryIcon = new ImageView(new Image("Icon/category.png"));
		
		lExpenseCategoryTitle = new Label("ExpenseCategory Details");
		lExpenseCategoryTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
		
		hbExpenseCategoryTitlePart.getChildren().addAll(imgExpenseCategoryIcon, lExpenseCategoryTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbExpenseCategoryTitlePart, "white", 10, 10, 10);
		
		gpExpenseCategoryDataPart = new GridPane();
		gpExpenseCategoryDataPart.add(lExpenseCategoryID, 0, 0);
		gpExpenseCategoryDataPart.add(llExpenseCategoryID, 1, 0);
		gpExpenseCategoryDataPart.add(lExpenseCategoryName, 0, 1);
		gpExpenseCategoryDataPart.add(llExpenseCategoryName, 1, 1);
		Style.GpFillColorAndSizeAndPadding(gpExpenseCategoryDataPart, 10, 10, 17, 17, "white");
		
		vbExpenseCategoryDataPart = new VBox();
		vbExpenseCategoryDataPart.getChildren().addAll(hbExpenseCategoryTitlePart,gpExpenseCategoryDataPart);
		vbExpenseCategoryDataPart.setStyle("-fx-background-color:#f9f9f9;-fx-border-color:grey;-fx-border-width: 1;-fx-border-style: solid;");

		vbAdminDataPart = new VBox();
		
		hbAdminTitlePart = new HBox();
		
		ImageView imgAdminIcon = new ImageView(new Image("Icon/adminicon.png"));
		
		lAdminDataTitle = new Label("Admin Details");
		lAdminDataTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
		
		hbAdminTitlePart.getChildren().addAll(imgAdminIcon, lAdminDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbAdminTitlePart, "white", 10, 10, 10);
		
		gpAdminDataPart = new GridPane();
		gpAdminDataPart.add(lAdminID, 0, 0);
		gpAdminDataPart.add(llAdminID, 1, 0);
		gpAdminDataPart.add(lAdminName, 0, 1);
		gpAdminDataPart.add(llAdminName, 1, 1);
		gpAdminDataPart.setPadding(new Insets(10,10,10,10));
		Style.GpFillColorAndSizeAndPadding(gpAdminDataPart, 10, 10, 17, 17, "white");
		
		vbAdminDataPart = new VBox();
		vbAdminDataPart.getChildren().addAll(hbAdminTitlePart,gpAdminDataPart);
		vbAdminDataPart.setStyle("-fx-background-color:#f9f9f9;-fx-border-color:grey;-fx-border-width: 1;-fx-border-style: solid;");

		vbExpenseDataPart = new VBox();
		
		hbExpenseTitlePart = new HBox();
		
		ImageView imgExpenseIcon = new ImageView(new Image("Icon/category.png"));
		
		lExpenseTitle = new Label("Expense Details");
		lExpenseTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
		
		hbExpenseTitlePart.getChildren().addAll(imgExpenseIcon, lExpenseTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbExpenseTitlePart, "white", 10, 10, 10);
		
		gpExpenseDataPart = new GridPane();
		gpExpenseDataPart.add(lExpenseID, 0, 0);
		gpExpenseDataPart.add(llExpenseID, 1, 0);
		gpExpenseDataPart.add(lAmount, 0, 1);
		gpExpenseDataPart.add(llAmount, 1, 1);
		gpExpenseDataPart.add(lNote, 0, 2);
		gpExpenseDataPart.add(llNote, 1, 2);
		gpExpenseDataPart.add(lAddDate, 0, 3);
		gpExpenseDataPart.add(llAddDate, 1, 3);
		Style.GpFillColorAndSizeAndPadding(gpExpenseDataPart, 10, 10, 17, 17, "white");
		
		vbExpenseDataPart = new VBox();
		vbExpenseDataPart.getChildren().addAll(hbExpenseTitlePart,gpExpenseDataPart);
		vbExpenseDataPart.setStyle("-fx-background-color:#f9f9f9;-fx-border-color:grey;-fx-border-width: 1;-fx-border-style: solid;");
		
		vbAddExpenseView.getChildren().addAll(hbTitleCon,vbExpenseDataPart,vbExpenseCategoryDataPart,vbAdminDataPart);
		vbAddExpenseView.setPrefHeight(700);
		Style.VBoxFillColorAndSizeAndPadding(vbAddExpenseView, "white", 10, 20, 10);
		return vbAddExpenseView;
		}
}

