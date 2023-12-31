package View;
import java.awt.Desktop;

import Handler.DesignationHandler;
import List.DesignationLists;
import Table.DesignationTable;
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
public class DesignationListsView {
	private static VBox vbDesignationListsView;
	public static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvDesignation;
	private static BorderPane bp;
	private static TextField tDesignationIDSearch;
	private static TextField tDesignationNameSearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static VBox vbDesignationListsCon;
	private static ObservableList<DesignationLists> data;
	private static DesignationLists adl;
	public static VBox vbWorkSpace;
	private static String gender;
	
	public static VBox vbDesignationListsView()
	{
		vbDesignationListsView = new VBox();
		
		/**/
		
		lTitle = new Label("Designation Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 15, 50, 0);
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tDesignationIDSearch = new TextField();
		tDesignationIDSearch.setPromptText("Designation ID");
		tDesignationIDSearch.setPrefHeight(50);
		tDesignationIDSearch.setFont(Font.font(15));

		tDesignationNameSearch = new TextField();
		tDesignationNameSearch.setPromptText("Designation Name");
		tDesignationNameSearch.setPrefHeight(50);
		tDesignationNameSearch.setFont(Font.font(15));

		tDesignationIDSearch.setOnKeyTyped(e->{
			tvDesignation.getItems().clear();
			data = FXCollections.observableArrayList(DesignationHandler.FilterDesignation(tDesignationIDSearch.getText(), ""));
			tvDesignation.setItems(data);
		});
		
		tDesignationNameSearch.setOnKeyTyped(e->{
			tvDesignation.getItems().clear();
			data = FXCollections.observableArrayList(DesignationHandler.FilterDesignation("", tDesignationNameSearch.getText()));
			tvDesignation.setItems(data);
		});
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");
		btnRefresh.setOnAction(e->{
			tvDesignation.getItems().clear();
			data = FXCollections.observableArrayList(DesignationHandler.GetAllDesignation());
			tvDesignation.setItems(data);
			tDesignationIDSearch.setText(null);
			tDesignationNameSearch.setText(null);
		});

		btnAdd = new Button("Add New Designation", new ImageView (new Image("Icon/Plus16.png")));
		btnAdd.setFont(Font.font("Times New Roman", 18));
		btnAdd.setPrefHeight(50);
		btnAdd.setStyle("-fx-background-color:green");
		btnAdd.setTextFill(Color.WHITE);
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tDesignationNameSearch,btnRefresh,btnAdd);
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		DesignationTable.tvDesignationLists(1);
		tvDesignation = DesignationTable.tvDesignationLists(1);
		data = FXCollections.observableArrayList(DesignationHandler.GetAllDesignation());
		tvDesignation.setItems(data);
		
		vbDesignationListsCon = new VBox();
		vbDesignationListsCon.getChildren().addAll(bp,tvDesignation);
		Style.VBoxFillColorAndSizeAndPadding(vbDesignationListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDDesignationView.vbAddDesignationView(0, "", 1100, 1000, 1);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Designation Lists");
		});

		vbDesignationListsView.getChildren().addAll(hbTitleCon,vbDesignationListsCon);
		vbDesignationListsView.setSpacing(5);
		Style.VBoxFillColorAndSizeAndPadding(vbDesignationListsView, "#f2f2f2", 10, 0, 5);
		
		return vbDesignationListsView;
	}
}
