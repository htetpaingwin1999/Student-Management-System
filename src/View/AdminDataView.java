package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.AdminHandler;
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

public class AdminDataView {
	private static VBox vbAddAdminView;
	
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	
	private static Label llAdminEmail;
	public static Label lllAdminEmail;
	private static Label lAdminName;
	public static Label llAdminName;
	private static Label lPassword;
	private static Label llPassword;
	private static Label lUserName;
	private static Label llUserName;
	private static Label lGender;
	private static Label llGender;
	private static Label lDoB;
	public static Label llDoB;
	private static Label lPhoneNo;
	public static Label llPhoneNo;
	private static Label lPresentAddress;
	public static Label llPresentAddress;
	private static Label lJoinDate;
	public static Label llJoinDate;	
	private static VBox vbJobDataPart;
	private static HBox hbJobTitlePart;
	private static Label  lJobTitle;
	private static GridPane gpJobDataPart;
	
	private static VBox vbPersonalDataPart;
	private static HBox hbPersonalTitlePart;
	private static Label  lPersonalDataTitle;
	private static GridPane gpPersonalDataPart;

	
	private static VBox vbAccountDataPart;
	private static HBox hbAccountTitlePart;
	private static Label  lAccountTitle;
	private static GridPane gpAccountDataPart;
	public static VBox vbAdminDataView(String email,String name,String joinDate,String gender,String doB,String phoneNo,String presentAddress,String password,String userName,boolean own,int isData)  
	{
		// isData = 0 , owner admin is showing
		// isData = 1 , myself showing
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AdminListsView.vbAdminListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Admin Lists");
		});
		
		vbAddAdminView = new VBox();
				
		lTitle = new Label(name+" Detail");
		Style.LabelFillColorAndSize(lTitle, "black", 17);
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 17, 50, 0,1080,50);
			
		llAdminEmail = new Label("Admin Email:");
		Style.LabelFillColorAndSize(llAdminEmail, "black", 17);

		lllAdminEmail = new Label();
		Style.LabelFillColorAndSize(lllAdminEmail, "grey", 17);
		lllAdminEmail.setText(email);
		
		lAdminName = new Label("Admin Name:");
		Style.LabelFillColorAndSize(lAdminName, "black", 17);
		
		llAdminName = new Label();
		Style.LabelFillColorAndSize(llAdminName, "grey", 17);
		llAdminName.setText(name);
		
		lPassword = new Label("Password:");
		Style.LabelFillColorAndSize(lPassword, "black", 17);

		llPassword = new Label();
		llPassword.setText(password);
		Style.LabelFillColorAndSize(llPassword, "grey", 17);
	
		lUserName = new Label("UserName:");
		Style.LabelFillColorAndSize(lUserName, "black", 17);
		
		llUserName = new Label();
		Style.LabelFillColorAndSize(llUserName, "grey", 17);
		llUserName.setText(userName);
		
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

		lPhoneNo = new Label("Phone No:");
		Style.LabelFillColorAndSize(lPhoneNo, "black", 17);
		
		llPhoneNo = new Label();
		llPhoneNo.setText(phoneNo);
		Style.LabelFillColorAndSize(llPhoneNo, "grey", 17);
		 
		lPresentAddress = new Label("Present Address:");
		Style.LabelFillColorAndSize(lPresentAddress, "black", 17);

		llPresentAddress = new Label();
		llPresentAddress.setText(presentAddress);
		Style.LabelFillColorAndSize(llPresentAddress, "grey", 17);
				
		lJoinDate = new Label("Join Date:");
		Style.LabelFillColorAndSize(lJoinDate, "black", 17);

		lJoinDate.setTextFill(Color.BLACK);

		llJoinDate = new Label();
		Style.LabelFillColorAndSize(llJoinDate, "grey", 17);
		llJoinDate.setText(joinDate);
		
		vbJobDataPart = new VBox();
		
		hbJobTitlePart = new HBox();
		
		ImageView imgJobIcon = new ImageView(new Image("Icon/suitcase.png"));
		
		lJobTitle = new Label("Job Details");
		Style.LabelFillColorAndSizeBold(lJobTitle, "black", 17);

		hbJobTitlePart.getChildren().addAll(imgJobIcon, lJobTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbJobTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpJobDataPart = new GridPane();
		gpJobDataPart.add(lAdminName, 0, 0);
		gpJobDataPart.add(llAdminName, 1, 0);
		gpJobDataPart.add(llAdminEmail, 0, 1);
		gpJobDataPart.add(lllAdminEmail, 1, 1);
		gpJobDataPart.add(lJoinDate, 0, 2);
		gpJobDataPart.add(llJoinDate, 1, 2);
		Style.GpFillColorAndSizeAndPadding(gpJobDataPart, 10, 10, 17, 17,"white");
			
		vbJobDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbJobDataPart, hbJobTitlePart, gpJobDataPart);

		vbPersonalDataPart = new VBox();
		
		hbPersonalTitlePart = new HBox();
		
		ImageView imgPersonalData = new ImageView(new Image("Icon/contact.png"));
		
		lPersonalDataTitle = new Label("Personal Information Details");
		Style.LabelFillColorAndSizeBold(lPersonalDataTitle, "black", 17);

		
		hbPersonalTitlePart.getChildren().addAll(imgPersonalData, lPersonalDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbPersonalTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpPersonalDataPart = new GridPane();
		gpPersonalDataPart.add(lGender, 0, 1);
		gpPersonalDataPart.add(llGender, 1,1);
		gpPersonalDataPart.add(lDoB, 0, 2);
		gpPersonalDataPart.add(llDoB, 1, 2);
		gpPersonalDataPart.add(lPhoneNo, 0, 3);
		gpPersonalDataPart.add(llPhoneNo, 1, 3);
		gpPersonalDataPart.add(lPresentAddress, 0,4);
		gpPersonalDataPart.add(llPresentAddress,1,4);
		Style.GpFillColorAndSizeAndPadding(gpPersonalDataPart, 10, 10, 17, 17,"white");
	
		vbPersonalDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbPersonalDataPart, hbPersonalTitlePart, gpPersonalDataPart);

		vbAccountDataPart = new VBox();
		
		hbAccountTitlePart = new HBox();
		
		ImageView imgAccountIcon = new ImageView(new Image("Icon/contact.png"));
		
		lAccountTitle = new Label("Account Details");
		Style.LabelFillColorAndSizeBold(lAccountTitle, "black", 17);
		
		hbAccountTitlePart.getChildren().addAll(imgAccountIcon, lAccountTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbAccountTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpAccountDataPart = new GridPane();
		gpAccountDataPart.add(lUserName, 0, 0);
		gpAccountDataPart.add(llUserName, 1, 0);
		Style.GpFillColorAndSizeAndPadding(gpAccountDataPart, 10, 10, 17, 17,"white");
		
		if(isData ==0)
		{
			gpAccountDataPart.add(lPassword, 0, 1);
			gpAccountDataPart.add(llPassword, 1, 1);	
		}
		if(isData == 1)
		{
			lTitle.setText("Your Detail");
		}
	
		vbAccountDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbAccountDataPart, hbAccountTitlePart, gpAccountDataPart);
		
		if(Login.userid.equals("1")) //admin role
		{
			vbAddAdminView.getChildren().addAll(hbTitleCon,vbJobDataPart,vbPersonalDataPart,vbAccountDataPart);

		}
		else
		{
			vbAddAdminView.getChildren().addAll(hbTitleCon,vbJobDataPart,vbPersonalDataPart);

		}
		Style.VBoxFillColorAndSizeAndPadding(vbAddAdminView, "white", 10, 20, 10);
		vbAddAdminView.setPrefHeight(700);
		return vbAddAdminView;
		}
}

