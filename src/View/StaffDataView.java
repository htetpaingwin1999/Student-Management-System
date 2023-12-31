package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.StaffHandler;
import List.CourseLists;
import List.StaffLists;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;

public class StaffDataView {
	private static VBox vbAddStaffView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lStaffID;
	public static Label llStaffID;
	private static Label lStaffName;
	public static Label llStaffName;
	private static Label lPassword;
	private static Label llPassword;
	private static Label lGender;
	private static Label llGender;
	private static Label lDoB;
	public static Label llDoB;
	private static Label lPhoto;
	private Desktop desktop;
	private static FileChooser fcImage;
	private static Button btnOpenImage;
	public static Label lChooseImagePath;
	private static HBox hbImageCon;
	
	private static Label lEmail;
	public static Label llEmail;
	
	private static Label lPhoneNo;
	public static Label llPhoneNo;
	private static Label lPresentAddress;
	public static Label llPresentAddress;
	private static Label lJoinDate;
	public static Label llJoinDate;
	private static Label lDepartment;
	private static Label llDepartment;
	private static Label lDesignation;
	private static Label llDesignation;
	private static Label lSalary;
	private static Label llSalary;
	private static Label lUserName;
	private static Label llUserName;
	private static HBox hbUserDetailCon;
	private static ImageView imgUser;
	private static HBox hbDetails;
	private static Button btnEdit;
	private static Button btnPrint;
	private static Button btnDownload;
	private static TableView tvStaffHistory;
 	private static ObservableList<StaffLists> data;
 	
 	private static VBox vbJobDataPart;
	private static HBox hbJobTitlePart;
	private static Label  lJobTitle;
	private static GridPane gpJobDataPart;

	
	private static VBox vbPersonalDataPart;
	private static HBox hbPersonalTitlePart;
	private static Label  lPersonalDataTitle;
	private static GridPane gpPersonalDataPart;

	
	private static VBox vbAccountDataPart;
	private static HBox hbAccountDataPart;
	private static Label  lAccountTitle;
	private static GridPane gpAccountDataPart;
 	
	public static VBox vbStaffDataView(String id,String name,String joinDate,String gender,String doB,String phoneNo,String presentAddress,String password,String designation,String salary,String username,String email,int isData) // is data means staff or admin looking his or her account
	{
		// isData = 0  , admin is showing the whole data
		// isData = 1 , staff  is showing his or her data
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.lHome.setTextFill(Color.GREY);
            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Staff Lists");
            MainView.vbWorkSpace = StaffListsView.vbStaffListsView();
            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
		});
		vbAddStaffView = new VBox();
				
		lTitle = new Label(name+" Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 20, 50, 5);

		lStaffID = new Label("Staff ID:");
		Style.LabelFillColorAndSize(lStaffID, "black", 17);

		llStaffID = new Label();
		Style.LabelFillColorAndSize(llStaffID, "grey", 17);
		llStaffID.setText(id);
		
		lEmail = new Label("Email:");
		Style.LabelFillColorAndSize(lEmail, "black", 17);

		llEmail = new Label();
		Style.LabelFillColorAndSize(llEmail, "grey", 17);
		llEmail.setText(email);
		
		lStaffName = new Label("Staff Name:");
		Style.LabelFillColorAndSize(lStaffName, "black", 17);

		llStaffName = new Label();
		Style.LabelFillColorAndSize(llStaffName, "grey", 17);
		llStaffName.setText(name);
		
		lPassword = new Label("Password:");
		Style.LabelFillColorAndSize(lPassword, "black", 17);

		llPassword = new Label();
		Style.LabelFillColorAndSize(llPassword, "grey", 17);
		llPassword.setText(password);

		lGender = new Label("Gender:");
		Style.LabelFillColorAndSize(lGender, "black", 17);
	
		llGender = new Label();
		Style.LabelFillColorAndSize(llGender, "grey", 17);
		llGender.setText(gender);
		
		lDoB = new Label("Date of Birth:");
		Style.LabelFillColorAndSize(lDoB, "black", 17);

		llDoB = new Label();
		Style.LabelFillColorAndSize(llDoB, "grey", 17);
		llDoB.setText(doB);

//		lPhoto = new Label("Upload Photo:");
//		lPhoto.setFont(Font.font("Times New Roman", 17));
//		lPhoto.setTextFill(Color.BLACK);
//
//		btnOpenImage = new Button("Open Image");
//		btnOpenImage.setPrefWidth(100);
//		
//		lChooseImagePath = new Label("No File Choosen");
//		lChooseImagePath.setFont(Font.font("Times New Roman", 17));
//		lChooseImagePath.setTextFill(Color.GREY);
//
//		hbImageCon = new HBox();
//		hbImageCon.getChildren().addAll(btnOpenImage,lChooseImagePath);
//		hbImageCon.setSpacing(5);
//		hbImageCon.setPrefWidth(470);
//		
		lPhoneNo = new Label("Phone No:");
		Style.LabelFillColorAndSize(lPhoneNo, "black", 17);

		llPhoneNo = new Label();
		Style.LabelFillColorAndSize(llPhoneNo, "grey", 17);
		llPhoneNo.setText(phoneNo);
		
		lPresentAddress = new Label("Present Address:");
		Style.LabelFillColorAndSize(lPresentAddress, "black", 17);

		llPresentAddress = new Label();
		llPresentAddress.setPrefWidth(470);
		llPresentAddress.setText(presentAddress);
		Style.LabelFillColorAndSize(llPresentAddress, "grey", 17);
				
		lDesignation = new Label("Designation:");
		Style.LabelFillColorAndSize(lDesignation, "black", 17);

		llDesignation = new Label();
		Style.LabelFillColorAndSize(llDesignation, "grey", 17);
		llDesignation.setText(designation);
		
				
		lSalary = new Label("Salary:");
		Style.LabelFillColorAndSize(lSalary, "black", 17);

		llSalary = new Label();
		Style.LabelFillColorAndSize(llSalary, "grey", 17);
		llSalary.setText(salary);
		
		lJoinDate = new Label("Join Date:");
		Style.LabelFillColorAndSize(lJoinDate, "black", 17);

		llJoinDate = new Label();
		Style.LabelFillColorAndSize(llJoinDate, "grey", 17);
		llJoinDate.setText(joinDate);
		
		lUserName = new Label("UserName:");
		Style.LabelFillColorAndSize(lUserName, "black", 17);
		
		llUserName = new Label();
		Style.LabelFillColorAndSize(llUserName, "grey", 17);
		llUserName.setText(username);

		tvStaffHistory = Table.StaffTable.tvStaffLists(2);
		data = FXCollections.observableArrayList(Handler.StaffHandler.StaffSalaryAndDesignationHistory(id));
		tvStaffHistory.setItems(data);
		
		vbJobDataPart = new VBox();
		
		hbJobTitlePart = new HBox();
		
		ImageView imgJobIcon = new ImageView(new Image("Icon/suitcase.png"));
		
		lJobTitle = new Label("Job Details");
		Style.LabelFillColorAndSizeBold(lJobTitle, "black", 18);
		
		hbJobTitlePart.getChildren().addAll(imgJobIcon, lJobTitle);
		hbJobTitlePart.setPadding(new Insets(10,10,10,10));
		hbJobTitlePart.setSpacing(5);
		
		gpJobDataPart = new GridPane();
		gpJobDataPart.add(lStaffID, 0, 0);
		gpJobDataPart.add(llStaffID, 1, 0);
		gpJobDataPart.add(lStaffName, 0, 1);
		gpJobDataPart.add(llStaffName, 1, 1);
		gpJobDataPart.add(lEmail, 0, 2);
		gpJobDataPart.add(llEmail, 1, 2);
		gpJobDataPart.add(lJoinDate, 0, 3);
		gpJobDataPart.add(llJoinDate, 1, 3);
		gpJobDataPart.add(lDesignation, 0, 4);
		gpJobDataPart.add(llDesignation, 1, 4);
		gpJobDataPart.add(lSalary, 0, 5);
		gpJobDataPart.add(llSalary, 1, 5);
		Style.GpFillColorAndSizeAndPadding(gpJobDataPart, 10, 10, 17, 17, "white");
		
		vbJobDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbJobDataPart, hbJobTitlePart, gpJobDataPart);
	
		vbPersonalDataPart = new VBox();
		
		hbPersonalTitlePart = new HBox();
		
		ImageView imgPersonalData = new ImageView(new Image("Icon/contact.png"));
		
		lPersonalDataTitle = new Label("Personal Information Details");
		Style.LabelFillColorAndSizeBold(lPersonalDataTitle, "black", 18);

		hbPersonalTitlePart.getChildren().addAll(imgPersonalData, lPersonalDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbPersonalTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpPersonalDataPart = new GridPane();
		gpPersonalDataPart.add(lGender, 0, 1);
		gpPersonalDataPart.add(llGender, 1,1);
		gpPersonalDataPart.add(lDoB, 0, 2);
		gpPersonalDataPart.add(llDoB, 1, 2);
		gpPersonalDataPart.add(lPhoneNo, 0, 3);
		gpPersonalDataPart.add(llPhoneNo, 1, 3);
		gpPersonalDataPart.add(lPresentAddress, 0, 4);
		gpPersonalDataPart.add(llPresentAddress, 1, 4);
		Style.GpFillColorAndSizeAndPadding(gpPersonalDataPart, 10, 10, 17, 17, "white");

		vbPersonalDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbPersonalDataPart, hbPersonalTitlePart, gpPersonalDataPart);

		vbAccountDataPart = new VBox();
		
		hbAccountDataPart = new HBox();
		
		ImageView imgAccountIcon = new ImageView(new Image("Icon/contact.png"));
		
		lAccountTitle = new Label("Account Details");
		Style.LabelFillColorAndSizeBold(lAccountTitle, "black", 18);
		
		hbAccountDataPart.getChildren().addAll(imgAccountIcon, lAccountTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbAccountDataPart, "#f9f9f9", 10, 10, 5);
		
		gpAccountDataPart = new GridPane();
		gpAccountDataPart.add(lUserName, 0, 0);
		gpAccountDataPart.add(llUserName, 1, 0);
		Style.GpFillColorAndSizeAndPadding(gpAccountDataPart, 10, 10, 17, 17, "white");
		if(isData == 0)
		{
			gpAccountDataPart.add(lPassword, 0, 1);
			gpAccountDataPart.add(llPassword, 1, 1);
		}
	
		vbAccountDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbAccountDataPart, hbAccountDataPart, gpAccountDataPart);
		
		VBox vb = new VBox();
		vb.getChildren().addAll(hbTitleCon,vbJobDataPart,vbPersonalDataPart,vbAccountDataPart,tvStaffHistory);
		vb.setSpacing(20);
		
		ScrollPane sp = new ScrollPane();
		sp.setContent(vb);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.NEVER);
		sp.setPadding(new Insets(10,10,10,10));
		
		vbAddStaffView.getChildren().addAll(sp);
		vbAddStaffView.setPrefHeight(700);
		Style.VBoxFillColorAndSizeAndPadding(vbAddStaffView, "white", 10, 20, 5);
		return vbAddStaffView;
		}
}

