package View;
import java.awt.Desktop;

import Handler.ExpenseHandler;
import List.ExpenseLists;
import Table.ExpenseTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class ExpenseListsView {
	private static VBox vbExpenseListsView;
	public static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvExpense;
	private static BorderPane bp;
	private static TextField tDateSearch;
	private static TextField tExpenseSearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static VBox vbExpenseListsCon;
	private static ObservableList<ExpenseLists> data;
	private static ExpenseLists adl;
	
	public static VBox vbWorkSpace;
	private static String gender;
	
	public static VBox vbExpenseListsView()
	{
		vbExpenseListsView = new VBox();
		
		
		lTitle = new Label("Expense Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPadding(new Insets(15,50,15,50));
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.setStyle("-fx-background-color:white");
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tDateSearch = new TextField();
		tDateSearch.setPromptText("Date");
		tDateSearch.setPrefHeight(30);
		tDateSearch.setFont(Font.font(15));

		tExpenseSearch = new TextField();
		tExpenseSearch.setPromptText("Category Name");
		tExpenseSearch.setPrefHeight(30);
		tExpenseSearch.setFont(Font.font(15));
		
		tDateSearch.setOnKeyTyped(e->{
			tvExpense.getItems().clear();
			data = FXCollections.observableArrayList(ExpenseHandler.FilterExpense(tDateSearch.getText(), tExpenseSearch.getText()));
			tvExpense.setItems(data);
			});
		
		tExpenseSearch.setOnKeyTyped(e->{
			tvExpense.getItems().clear();
			data = FXCollections.observableArrayList(ExpenseHandler.FilterExpense(tDateSearch.getText(), tExpenseSearch.getText()));
			tvExpense.setItems(data);
		});
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");
		btnRefresh.setOnAction(e->{
			tvExpense.getItems().clear();
			data = FXCollections.observableArrayList(ExpenseHandler.GetAllExpense());
			tvExpense.setItems(data);
			tDateSearch.setText(null);
			tExpenseSearch.setText(null);
		});

		btnAdd = new Button("Add New Expense", new ImageView (new Image("Icon/Plus16.png")));
		Style.BtnAdd(btnAdd);
		btnAdd.setPrefWidth(200);
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tDateSearch,tExpenseSearch,btnRefresh,btnAdd);
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
//		bp.setPadding(new Insets(10,10,10,0));
		
		ExpenseTable.tvExpenseLists(1);
		tvExpense = ExpenseTable.tvExpenseLists(1);
		data = FXCollections.observableArrayList(ExpenseHandler.GetAllExpense());
		tvExpense.setItems(data);
		
		vbExpenseListsCon = new VBox();
		vbExpenseListsCon.getChildren().addAll(bp,tvExpense);
		Style.VBoxFillColorAndSizeAndPadding(vbExpenseListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDExpenseView.vbAddExpenseView(0, "", "", 0, "", 1, "", 1);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Add New Expense");
		});

		vbExpenseListsView.getChildren().addAll(hbTitleCon,vbExpenseListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbExpenseListsView, "#f2f2f2", 10, 0, 5);
		
		
		return vbExpenseListsView;
	}
}
