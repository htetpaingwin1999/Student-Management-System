package View;
import java.awt.Desktop;

import Handler.StaffHandler;
import List.StaffLists;
import Table.StaffTable;
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
public class StaffListsView {
	private static VBox vbStaffListsView;
	public static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvStaff;
	private static BorderPane bp;
	private static TextField tStaffEmailSearch;
	private static TextField tStaffNameSearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static Button btnSus;
	private static VBox vbStaffListsCon;
	private static ObservableList<StaffLists> data;
	private static StaffLists adl;
	public static HBox hbBtnCon;
	public static VBox vbWorkSpace;
	
	public static VBox vbStaffListsView()
	{
		vbStaffListsView = new VBox();
		
		lTitle = new Label("Staff Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPadding(new Insets(15,50,15,50));
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.setStyle("-fx-background-color:white");
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tStaffEmailSearch = new TextField();
		tStaffEmailSearch.setPromptText("Staff Email");
		tStaffEmailSearch.setPrefHeight(50);
		tStaffEmailSearch.setFont(Font.font(15));
		
		tStaffNameSearch = new TextField();
		tStaffNameSearch.setPromptText("Staff Name");
		tStaffNameSearch.setPrefHeight(50);
		tStaffNameSearch.setFont(Font.font(15));

		tStaffEmailSearch.setOnKeyTyped(e->{
			tvStaff.getItems().clear();
			data = FXCollections.observableArrayList(StaffHandler.FilterStaff(tStaffEmailSearch.getText(),tStaffNameSearch.getText(),0));
			tvStaff.setItems(data);
		});
		
		tStaffNameSearch.setOnKeyTyped(e->{
			tvStaff.getItems().clear();
			data = FXCollections.observableArrayList(StaffHandler.FilterStaff(tStaffEmailSearch.getText(),tStaffNameSearch.getText(),0));
			tvStaff.setItems(data);
		});
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");
		btnRefresh.setOnAction(e->{
			tvStaff.getItems().clear();
			data = FXCollections.observableArrayList(StaffHandler.GetAllStaff(0));
			tvStaff.setItems(data);
			tStaffEmailSearch.setText(null);
			tStaffNameSearch.setText(null);
		});
		
		btnAdd = new Button("Add New Staff", new ImageView (new Image("Icon/Plus16.png")));
		Style.BtnAdd(btnAdd);
		
		btnSus = new Button("Suspended Account Lists");
		Style.BtnSus(btnSus);
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(btnSus,tStaffEmailSearch,tStaffNameSearch,btnRefresh,btnAdd);
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		StaffTable.tvStaffLists(1);
		tvStaff = StaffTable.tvStaffLists(1);
		data = FXCollections.observableArrayList(StaffHandler.GetAllStaff(0));
		tvStaff.setItems(data);
		
		vbStaffListsCon = new VBox();
		vbStaffListsCon.getChildren().addAll(bp,tvStaff);
		Style.VBoxFillColorAndSizeAndPadding(vbStaffListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDStaffView.vbAddStaffView("","","","Female","","","","BSDS!123a11","","","",1,0);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Add New Staff");
		});
		
		btnSus.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = SusStaffListsView.vbStaffListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Staff Lists");
			MainView.UpdateIndex(MainView.lIndex2, "Suspended Account Lists");
		});

		vbStaffListsView.getChildren().addAll(hbTitleCon,vbStaffListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbStaffListsView, "#f2f2f2", 10, 10, 5);
		
		return vbStaffListsView;
	}
}
