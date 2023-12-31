package View;
import java.awt.Desktop;

import Handler.ExpenseCategoryHandler;
import List.ExpenseCategoryLists;
import Table.ExpenseCategoryTable;
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
public class ExpenseCategoryListsView {
	private static VBox vbExpenseCategoryListsView;
	public static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvExpenseCategory;
	private static BorderPane bp;
	private static TextField tExpenseCategoryIDSearch;
	private static TextField tExpenseCategorySearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static VBox vbExpenseCategoryListsCon;
	private static ObservableList<ExpenseCategoryLists> data;
	private static ExpenseCategoryLists adl;
	public static VBox vbWorkSpace;
	private static String gender;
	
	public static VBox vbExpenseCategoryListsView()
	{
		vbExpenseCategoryListsView = new VBox();
		
		/**/
		lTitle = new Label("ExpenseCategory Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 15, 50, 0);
		
		bp = new BorderPane();
		
		tExpenseCategoryIDSearch = new TextField();
		tExpenseCategoryIDSearch.setPromptText("ExpenseCategory ID");
		tExpenseCategoryIDSearch.setPrefHeight(50);

		tExpenseCategorySearch = new TextField();
		tExpenseCategorySearch.setPromptText("ExpenseCategory Name");
		tExpenseCategorySearch.setPrefHeight(50);

		tExpenseCategoryIDSearch.setOnKeyTyped(e->{
			tvExpenseCategory.getItems().clear();
			data = FXCollections.observableArrayList(ExpenseCategoryHandler.FilterExpenseCategory(tExpenseCategoryIDSearch.getText(),""));
			tvExpenseCategory.setItems(data);
		});
		
		tExpenseCategorySearch.setOnKeyTyped(e->{
			tvExpenseCategory.getItems().clear();
			data = FXCollections.observableArrayList(ExpenseCategoryHandler.FilterExpenseCategory("", tExpenseCategorySearch.getText()));
			tvExpenseCategory.setItems(data);
		});
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");
		btnRefresh.setOnAction(e->{
			tvExpenseCategory.getItems().clear();
			data = FXCollections.observableArrayList(ExpenseCategoryHandler.GetAllExpenseCategory());
			tvExpenseCategory.setItems(data);
			tExpenseCategoryIDSearch.setText(null);
			tExpenseCategorySearch.setText(null);
		});

		btnAdd = new Button("Add New ExpenseCategory", new ImageView (new Image("Icon/Plus16.png")));
		Style.BtnAdd(btnAdd);
		btnAdd.setPrefWidth(250);
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tExpenseCategoryIDSearch,tExpenseCategorySearch,btnRefresh,btnAdd);
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
//		bp.setPadding(new Insets(10,10,10,0));
		
		ExpenseCategoryTable.tvExpenseCategoryLists();
		tvExpenseCategory = ExpenseCategoryTable.tvExpenseCategoryLists();
		data = FXCollections.observableArrayList(ExpenseCategoryHandler.GetAllExpenseCategory());
		System.out.println(data.size());
		tvExpenseCategory.setItems(data);
		
		vbExpenseCategoryListsCon = new VBox();
		vbExpenseCategoryListsCon.getChildren().addAll(bp,tvExpenseCategory);
		Style.VBoxFillColorAndSizeAndPadding(vbExpenseCategoryListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDExpenseCategoryView.vbAddExpenseCategoryView(0, "", 1);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Expense Category Lists");
	
		});

		vbExpenseCategoryListsView.getChildren().addAll(hbTitleCon,vbExpenseCategoryListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbExpenseCategoryListsView, "#f2f2f2", 10, 0, 5);
		
		return vbExpenseCategoryListsView;
	}
}
