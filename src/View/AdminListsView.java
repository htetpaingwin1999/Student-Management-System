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
public class AdminListsView {
	private static VBox vbAdminListsView;
	public static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvAdmin;
	private static BorderPane bp;
	private static TextField tAdminEmailSearch;
	private static TextField tAdminNameSearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static Button btnSus;
	private static VBox vbAdminListsCon;
	private static ObservableList<AdminLists> data;
	private static AdminLists adl;
	public static HBox hbBtnCon;
	public static VBox vbWorkSpace;
	private static String gender;
	
	public static VBox vbAdminListsView()
	{
		vbAdminListsView = new VBox();
		
		lTitle = new Label("Admin Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 15, 50, 0,1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tAdminEmailSearch = new TextField();
		Style.TextFieldFill(tAdminEmailSearch, "Admin Name", 50, 15);

		tAdminNameSearch = new TextField();
		Style.TextFieldFill(tAdminNameSearch, "Admin Name", 50, 15);

		tAdminEmailSearch.setOnKeyTyped(e->{
			tvAdmin.getItems().clear();
			data = FXCollections.observableArrayList(AdminHandler.FilterAdmin(tAdminEmailSearch.getText(), tAdminNameSearch.getText(),0)); // current admin
			tvAdmin.setItems(data);
		});
		
		tAdminNameSearch.setOnKeyTyped(e->{
			tvAdmin.getItems().clear();
			data = FXCollections.observableArrayList(AdminHandler.FilterAdmin(tAdminEmailSearch.getText(), tAdminNameSearch.getText(),0)); // current admin
			tvAdmin.setItems(data);
		});
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");
		btnRefresh.setOnAction(e->{
			tvAdmin.getItems().clear();
			data = FXCollections.observableArrayList(AdminHandler.GetAllAdmin(0));//current admin
			tvAdmin.setItems(data);
			tAdminEmailSearch.setText(null);
			tAdminNameSearch.setText(null);
		});

		btnAdd = new Button("Add New Admin", new ImageView (new Image("Icon/Plus16.png")));
		Style.ButtonFillColorAndSize(btnAdd, 15,150,30, 10, 10, "green");
		
		btnSus = new Button("Suspended Account");
		Style.ButtonFillColorAndSize(btnSus, 15,150,30, 10, 10, "orange");
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(btnSus,tAdminNameSearch,btnRefresh,btnAdd);
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		AdminTable.tvAdminLists(0);
		tvAdmin = AdminTable.tvAdminLists(0);
		data = FXCollections.observableArrayList(AdminHandler.GetAllAdmin(0));
		tvAdmin.setItems(data);
		
		vbAdminListsCon = new VBox();
		Style.VBoxFillColorAndSizeAndPadding(vbAdminListsCon, "white",10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDAdminView.vbAddAdminView("","","","","","","","","",1,0);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Add New Admin");
		});
		
		btnSus.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = SusAdminListsView.vbAdminListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Admin Lists");
			MainView.UpdateIndex(MainView.lIndex2, "Suspended Admin Lists");
		});
		
		vbAdminListsCon.getChildren().addAll(hbFilterCon,tvAdmin);

		vbAdminListsView.getChildren().addAll(hbTitleCon,vbAdminListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbAdminListsView, "#f2f2f2", 10, 0,5);
		return vbAdminListsView;
	}
}
