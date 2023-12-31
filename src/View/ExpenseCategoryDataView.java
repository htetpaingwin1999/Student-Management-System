package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.ExpenseCategoryHandler;
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

public class ExpenseCategoryDataView {
	private static VBox vbAddExpenseCategoryView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lExpenseCategoryID;
	public static Label llExpenseCategoryID;
	private static Label lExpenseCategoryName;
	public static Label llExpenseCategoryName;
	private static Label lAdminID;
	private static Label llAdminID;
	private static Label lAdminName;
	private static Label llAdminName;
	private static Label lAddDate;
	public static Label llAddDate;
	private static HBox hbExpenseCategoryDetailCon;
	private static ImageView imgExpenseCategory;
	private static BorderPane bpAboutExpenseCategoryNBtnCon;
	
	private static VBox vbExpenseCategoryDataPart;
	private static HBox hbExpenseCategoryTitlePart;
	private static Label  lExpenseCategoryTitle;
	private static GridPane gpExpenseCategoryDataPart;

	private static VBox vbAdminDataPart;
	private static HBox hbAdminTitlePart;
	private static Label  lAdminDataTitle;
	private static GridPane gpAdminDataPart;

	public static VBox vbExpenseCategoryDataView(int did,String dname,int adid,String adName,String addDate)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.lHome.setTextFill(Color.GREY);
            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = ExpenseCategoryListsView.vbExpenseCategoryListsView();
            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            MainView.RemoveIndex();
            MainView.UpdateIndex(MainView.lIndex1, "Expense Category Lists");

		});
		
		vbAddExpenseCategoryView = new VBox();
			
		lTitle = new Label(dname+" ExpenseCategory Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 20, 50, 0);
		
		lExpenseCategoryID = new Label("ExpenseCategory ID:");
		Style.LabelFillColorAndSize(lExpenseCategoryID, "black", 17);

		llExpenseCategoryID = new Label();
		llExpenseCategoryID.setText(did+"");
		Style.LabelFillColorAndSize(llExpenseCategoryID, "grey", 17);
		
		lExpenseCategoryName = new Label("ExpenseCategory Name:");
		Style.LabelFillColorAndSize(lExpenseCategoryName, "black", 17);
		
		llExpenseCategoryName = new Label();
		llExpenseCategoryName.setText(dname);
		Style.LabelFillColorAndSize(llExpenseCategoryName, "grey", 17);
		
		lAdminID = new Label("Admin ID:");
		Style.LabelFillColorAndSize(lAdminID, "black", 17);
		
		llAdminID = new Label();
		llAdminID.setText(adid+"");
		Style.LabelFillColorAndSize(llAdminID, "grey", 17);

		lAdminName = new Label("Admin Name:");
		Style.LabelFillColorAndSize(lAdminName, "black", 17);

		llAdminName = new Label();
		llAdminName.setText(adName);
		Style.LabelFillColorAndSize(llAdminName, "grey", 17);

		lAddDate = new Label("Add Date:");
		Style.LabelFillColorAndSize(lAddDate, "black", 17);

		llAddDate = new Label();
		llAddDate.setText(addDate);
		Style.LabelFillColorAndSize(llAddDate, "grey", 17);
		
		vbExpenseCategoryDataPart = new VBox();
		
		hbExpenseCategoryTitlePart = new HBox();
		
		ImageView imgExpenseCategoryIcon = new ImageView(new Image("Icon/category.png"));
		
		lExpenseCategoryTitle = new Label("ExpenseCategory Details");
		lExpenseCategoryTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
		lExpenseCategoryTitle.setTextFill(Color.BLACK);
		Style.LabelFillColorAndSize(lExpenseCategoryID, "black", 17);

		hbExpenseCategoryTitlePart.getChildren().addAll(imgExpenseCategoryIcon, lExpenseCategoryTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbExpenseCategoryTitlePart, "white", 10, 10, 10);
		
		gpExpenseCategoryDataPart = new GridPane();
		gpExpenseCategoryDataPart.add(lExpenseCategoryID, 0, 0);
		gpExpenseCategoryDataPart.add(llExpenseCategoryID, 1, 0);
		gpExpenseCategoryDataPart.add(lExpenseCategoryName, 0, 1);
		gpExpenseCategoryDataPart.add(llExpenseCategoryName, 1, 1);
		gpExpenseCategoryDataPart.add(lAddDate, 0, 2);
		gpExpenseCategoryDataPart.add(llAddDate, 1, 2);
		Style.GpFillColorAndSizeAndPadding(gpExpenseCategoryDataPart, 10, 10, 17, 17, "white");
		
		vbExpenseCategoryDataPart = new VBox();
		vbExpenseCategoryDataPart.getChildren().addAll(hbExpenseCategoryTitlePart,gpExpenseCategoryDataPart);
		vbExpenseCategoryDataPart.setStyle("-fx-background-color:#f9f9f9;-fx-border-color:grey;-fx-border-width: 1;-fx-border-style: solid;");

		vbAdminDataPart = new VBox();
		
		hbAdminTitlePart = new HBox();
		
		ImageView imgAdminIcon = new ImageView(new Image("Icon/adminicon.png"));
		
		lAdminDataTitle = new Label("Admin Details");
		lAdminDataTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
		lAdminDataTitle.setTextFill(Color.BLACK);
		
		hbAdminTitlePart.getChildren().addAll(imgAdminIcon, lAdminDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbAdminTitlePart, "white", 10, 10, 10);
		
		gpAdminDataPart = new GridPane();
		gpAdminDataPart.add(lAdminID, 0, 0);
		gpAdminDataPart.add(llAdminID, 1, 0);
		gpAdminDataPart.add(lAdminName, 0, 1);
		gpAdminDataPart.add(llAdminName, 1, 1);
		Style.GpFillColorAndSizeAndPadding(gpAdminDataPart, 10, 10, 17, 17, "white");

		vbAdminDataPart = new VBox();
		vbAdminDataPart.getChildren().addAll(hbAdminTitlePart,gpAdminDataPart);
		vbAdminDataPart.setStyle("-fx-background-color:#f9f9f9;-fx-border-color:grey;-fx-border-width: 1;-fx-border-style: solid;");

		vbAddExpenseCategoryView.getChildren().addAll(hbTitleCon,vbExpenseCategoryDataPart,vbAdminDataPart);
		Style.VBoxFillColorAndSizeAndPadding(vbAddExpenseCategoryView, "white", 10, 20, 10);
		vbAddExpenseCategoryView.setPrefHeight(700);
		return vbAddExpenseCategoryView;
		}
}

