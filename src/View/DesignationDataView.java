package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.DesignationHandler;
import List.DesignationLists;
import Table.DesignationTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
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

public class DesignationDataView {
	private static VBox vbAddDesignationView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lDesignationID;
	public static Label llDesignationID;
	private static Label lDesignationName;
	public static Label llDesignationName;
	public static Label lMaxSalary;
	private static Label llMaxSalary;
	private static Label lMinSalary;
	private static Label llMinSalary;
	
	private static Label lAdminID;
	private static Label llAdminID;
	private static Label lAdminName;
	private static Label llAdminName;
	private static Label lAddDate;
	public static Label llAddDate;
	private static HBox hbDesignationDetailCon;
	private static ImageView imgDesignation;
	private static BorderPane bpAboutDesignationNBtnCon;
	private static Button btnEdit;
	private static Button btnPrint;
	private static Button btnDownload;
	private static HBox hbBtnCon;
	private static ObservableList<DesignationLists> data;
	private static TableView tvDesignation;
	
	private static VBox vbDepartmentDataPart;
	private static HBox hbDepartmentTitlePart;
	private static Label  lDepartmentTitle;
	private static GridPane gpDepartmentDataPart;

	private static VBox vbAdminDataPart;
	private static HBox hbAdminTitlePart;
	private static Label  lAdminDataTitle;
	private static GridPane gpAdminDataPart;

	private static VBox vbDesignationDataPart;
	private static HBox hbDesignationTitlePart;
	private static Label  lDesignationDataTitle;
	private static GridPane gpDesignationDataPart;

	
	public static VBox vbDesignationDataView(int desid,String desname,int maxSalary,int minSalary,int adid,String adName,String addDate)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.lHome.setTextFill(Color.GREY);
            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = DesignationListsView.vbDesignationListsView();
            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Designation Lists");
		});
		
		DesignationTable.tvDesignationLists(1);
		tvDesignation = DesignationTable.tvDesignationLists(2);
		data = FXCollections.observableArrayList(DesignationHandler.GetDeisgnatonHistory(desid));
		tvDesignation.setItems(data);
		
		vbAddDesignationView = new VBox();
				
		lTitle = new Label(desname+" Designation Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 20, 50, 0,1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		lDesignationID = new Label("Designation ID:");
		Style.LabelFillColorAndSize(lDesignationID, "black", 17);

		llDesignationID = new Label();
		Style.LabelFillColorAndSize(llDesignationID, "grey", 17);
		llDesignationID.setText(desid+"");
		
		lDesignationName = new Label("Designation Name:");
		Style.LabelFillColorAndSize(lDesignationName, "black", 17);
		
		llDesignationName = new Label();
		Style.LabelFillColorAndSize(llDesignationName, "grey", 17);
		llDesignationName.setText(desname);
		
		lMaxSalary = new Label("Maximum Salary");
		Style.LabelFillColorAndSize(lMaxSalary, "black", 17);

		llMaxSalary = new Label();
		Style.LabelFillColorAndSize(llMaxSalary, "grey", 17);
		llMaxSalary.setText(maxSalary+"");
		
		lMinSalary = new Label("Minimum Salary");
		Style.LabelFillColorAndSize(lMinSalary, "black", 17);
		
		llMinSalary = new Label();
		Style.LabelFillColorAndSize(llMinSalary, "grey", 17);
		llMinSalary.setText(minSalary+"");
	
		lAdminID = new Label("Admin ID:");
		Style.LabelFillColorAndSize(lAdminID, "black", 17);
		
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
		
		DesignationTable.tvDesignationLists(1);
		tvDesignation = DesignationTable.tvDesignationLists(2);
		data = FXCollections.observableArrayList(DesignationHandler.GetDeisgnatonHistory(desid));
		tvDesignation.setItems(data);
				
		vbAdminDataPart = new VBox();
		
		hbAdminTitlePart = new HBox();
		
		ImageView imgAdminIcon = new ImageView(new Image("Icon/adminicon.png"));
		
		lAdminDataTitle = new Label("Admin Details");
		Style.LabelFillColorAndSize(lAdminDataTitle, "black", 18);

		hbAdminTitlePart.getChildren().addAll(imgAdminIcon, lAdminDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbAdminTitlePart, "white", 10, 10, 5);
		
		gpAdminDataPart = new GridPane();
		gpAdminDataPart.add(lAdminID, 0, 0);
		gpAdminDataPart.add(llAdminID, 1, 0);
		gpAdminDataPart.add(lAdminName, 0, 1);
		gpAdminDataPart.add(llAdminName, 1, 1);
		Style.GpFillColorAndSizeAndPadding(gpAdminDataPart, 10, 10, 17, 17, "white");
	
		vbAdminDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbAdminDataPart, hbAdminTitlePart, gpAdminDataPart);

		vbDesignationDataPart = new VBox();
		
		hbDesignationTitlePart = new HBox();
		
		ImageView imgDesignationIcon = new ImageView(new Image("Icon/job.png"));
		
		lDesignationDataTitle = new Label("Admin Details");
		Style.LabelFillColorAndSize(lDesignationDataTitle, "black", 18);

		hbDesignationTitlePart.getChildren().addAll(imgDesignationIcon, lDesignationDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbDesignationTitlePart, "white", 10, 10, 5);
		
		gpDesignationDataPart = new GridPane();
		gpDesignationDataPart.add(lDesignationID, 0, 0);
		gpDesignationDataPart.add(llDesignationID, 1, 0);
		gpDesignationDataPart.add(lDesignationName, 0, 1);
		gpDesignationDataPart.add(llDesignationName, 1, 1);
		gpDesignationDataPart.add(lMaxSalary, 0, 2);
		gpDesignationDataPart.add(llMaxSalary, 1, 2);
		gpDesignationDataPart.add(lMinSalary, 0, 3);
		gpDesignationDataPart.add(llMinSalary, 1, 3);
		gpDesignationDataPart.add(lAddDate, 0, 4);
		gpDesignationDataPart.add(llAddDate, 1, 4);
		Style.GpFillColorAndSizeAndPadding(gpDesignationDataPart, 10, 10, 17, 17, "white");
	
		vbDesignationDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbDesignationDataPart, hbDesignationTitlePart, gpDesignationDataPart);

		vbAddDesignationView.getChildren().addAll(hbTitleCon,vbDesignationDataPart,vbAdminDataPart,tvDesignation);
		vbAddDesignationView.setPrefHeight(700);
		Style.VBoxFillColorAndSizeAndPadding(vbAddDesignationView, "white", 10, 20, 10);
		return vbAddDesignationView;
		}
}

