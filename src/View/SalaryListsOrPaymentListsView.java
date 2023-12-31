package View;
import java.util.ArrayList;

import Handler.SalaryHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import List.SalaryLists;
import Table.SalaryTable;

public class SalaryListsOrPaymentListsView {
	private static VBox vbSalaryPaymentListsView;
	public static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvSalaryPayment;
	private static BorderPane bp;
	private static TextField tStaffEmailSearch;
	private static TextField tStaffNameSearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static VBox vbSalaryPaymentListsCon;
	private static ObservableList<SalaryLists> data;
	private static SalaryListsOrPaymentListsView adl;
	private static Button btnFilter;
	
	private static Button btnSave;
	private static Button btnCancel;
	public static HBox hbBtnCon;
	public static VBox vbWorkSpace;
	private static String gender;
	
	public static VBox vbSalaryPaymentListsView(int choose)
	{
		vbSalaryPaymentListsView = new VBox();
		//choose 1 for updated salary list
	    // choose 2 for salary history
		/**/
		btnSave = new Button("Save");
		Style.ButtonSave(btnSave);

		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		hbBtnCon = new HBox();
		hbBtnCon.getChildren().addAll(btnSave,btnCancel);
		hbBtnCon.setSpacing(10);
		
		
		lTitle = new Label("Salary Payment Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 15, 50, 0,1080,50);
		
		bp = new BorderPane();
		
		tStaffEmailSearch = new TextField();
		tStaffEmailSearch.setPromptText("Staff Email");
		tStaffEmailSearch.setPrefHeight(50);
		tStaffEmailSearch.setFont(Font.font(15));

		tStaffNameSearch = new TextField();
		tStaffNameSearch.setPromptText("Staff Name");
		tStaffNameSearch.setPrefHeight(50);
		tStaffNameSearch.setFont(Font.font(15));

		btnFilter = new Button("Paid History");

		tStaffEmailSearch.setOnKeyTyped(e->{
			tvSalaryPayment.getItems().clear();
			data = FXCollections.observableArrayList(SalaryHandler.FilterStaff(tStaffEmailSearch.getText(),tStaffNameSearch.getText()));
			tvSalaryPayment.setItems(data);
		});
		
		tStaffNameSearch.setOnKeyTyped(e->{
			tvSalaryPayment.getItems().clear();
			data = FXCollections.observableArrayList(SalaryHandler.FilterStaff(tStaffEmailSearch.getText(),tStaffNameSearch.getText()));
			tvSalaryPayment.setItems(data);
		});
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");
		btnRefresh.setOnAction(e->{
			tvSalaryPayment.getItems().clear();
			data = FXCollections.observableArrayList(SalaryHandler.GetAllSalary());
			tvSalaryPayment.setItems(data);
			tStaffEmailSearch.setText(null);
			tStaffNameSearch.setText(null);
		});

		btnAdd = new Button("Add New Department", new ImageView (new Image("Icon/Plus16.png")));
		btnAdd.setFont(Font.font("Times New Roman", 18));
		btnAdd.setPrefHeight(50);
		btnAdd.setStyle("-fx-background-color:green");
		btnAdd.setTextFill(Color.WHITE);
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tStaffEmailSearch,tStaffNameSearch,btnRefresh);
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		SalaryTable.tvSalaryLists();
		tvSalaryPayment =SalaryTable.tvSalaryLists();
		data = FXCollections.observableArrayList(Handler.SalaryHandler.GetAllSalary());
		tvSalaryPayment.setItems(data);
		
		tvSalaryPayment.setOnMouseClicked(e->{
        	int index = tvSalaryPayment.getSelectionModel().getSelectedIndex();
        	if(index >=0)
        	{
        		SalaryLists s = data.get(index);
            	Alert al = new Alert(AlertType.INFORMATION,s.getNote());
            	al.showAndWait();
        	} 
        });
		
		vbSalaryPaymentListsCon = new VBox();
		vbSalaryPaymentListsCon.getChildren().addAll(bp,tvSalaryPayment);
		Style.VBoxFillColorAndSizeAndPadding(vbSalaryPaymentListsCon, "white", 10, 10, 10);

		vbSalaryPaymentListsView.getChildren().addAll(hbTitleCon,vbSalaryPaymentListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbSalaryPaymentListsView, "#f2f2f2", 10, 0, 5);

		
		return vbSalaryPaymentListsView;
	}
}
