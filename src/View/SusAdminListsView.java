package View;
import java.awt.Desktop;

import Handler.AdminHandler;
import List.AdminLists;
import Table.AdminTable;
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
public class SusAdminListsView {
	private static VBox vbAdminListsView;
	public static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvAdmin;
	private static BorderPane bp;
	private static TextField tAdminIDSearch;
	private static TextField tAdminSearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static VBox vbAdminListsCon;
	private static ObservableList<AdminLists> data;
	private static AdminLists adl;
	public static VBox vbWorkSpace;
	private static String gender;
	
	public static VBox vbAdminListsView()
	{
		vbAdminListsView = new VBox();
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AdminListsView.vbAdminListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Admin Lists");
		});
		
		/**/

		lTitle = new Label("Suspended Admin Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPadding(new Insets(15,50,15,50));
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.setStyle("-fx-background-color:white");
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tAdminIDSearch = new TextField();
		tAdminIDSearch.setPromptText("Admin Email");
		tAdminIDSearch.setPrefHeight(50);
		tAdminIDSearch.setFont(Font.font(15));

		tAdminSearch = new TextField();
		tAdminSearch.setPromptText("Admin Name");
		tAdminSearch.setPrefHeight(50);
		tAdminSearch.setFont(Font.font(15));

		tAdminIDSearch.setOnKeyTyped(e->{
			tvAdmin.getItems().clear();
			data = FXCollections.observableArrayList(AdminHandler.FilterAdmin(tAdminIDSearch.getText(),tAdminSearch.getText(),2));
			tvAdmin.setItems(data);
		});
		
		tAdminSearch.setOnKeyTyped(e->{
			tvAdmin.getItems().clear();
			data = FXCollections.observableArrayList(AdminHandler.FilterAdmin(tAdminIDSearch.getText(),tAdminSearch.getText(),2));
			tvAdmin.setItems(data);
		});
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");
		btnRefresh.setOnAction(e->{
			tvAdmin.getItems().clear();
			data = FXCollections.observableArrayList(AdminHandler.GetAllAdmin(2));
			tvAdmin.setItems(data);
			tAdminIDSearch.setText(null);
			tAdminSearch.setText(null);
		});
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tAdminIDSearch,tAdminSearch,btnRefresh);
		hbFilterCon.setSpacing(10);
		
		bp.setLeft(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		AdminTable.tvAdminLists(2);
		tvAdmin = AdminTable.tvAdminLists(2);
		data = FXCollections.observableArrayList(AdminHandler.GetAllAdmin(2));
		tvAdmin.setItems(data);
		
		vbAdminListsCon = new VBox();
		vbAdminListsCon.getChildren().addAll(bp,tvAdmin);
		Style.VBoxFillColorAndSizeAndPadding(vbAdminListsCon, "white", 10, 10, 5);

		
		vbAdminListsView.getChildren().addAll(hbTitleCon,vbAdminListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbAdminListsView, "#f2f2f2", 10, 0, 5);
		
		
		return vbAdminListsView;
	}
}
