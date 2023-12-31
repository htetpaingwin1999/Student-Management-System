package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.StudentHandler;
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

public class StudentDataView {
	private static VBox vbAddStudentView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lStudentID;
	public static Label llStudentID;
	private static Label lStudentName;
	public static Label llStudentName;
	
	private static Label lPhoneNo;
	public static Label llPhoneNo;
	private static Label lPresentAddress;
	public static Label llPresentAddress;
	private static Label lJoinDate;
	public static Label llJoinDate;
	
	public static GridPane gp;
	private static HBox hbUserDetailCon;
	private static ImageView imgUser;
	private static BorderPane bpAboutMeNBtnCon;
	private static Button btnEdit;
	private static Button btnPrint;
	private static Button btnDownload;
	private static HBox hbBtnCon;
	
	private static VBox vbStudentDataPart;
	private static HBox hbStudentTitlePart;
	private static Label  lStudentTitle;
	private static GridPane gpStudentDataPart;

	
	private static VBox vbPersonalDataPart;
	private static HBox hbPersonalTitlePart;
	private static Label  lPersonalDataTitle;
	private static GridPane gpPersonalDataPart;

	public static VBox vbStudentDataView(String id,String name,String joinDate,String phoneNo,String presentAddress)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.lHome.setTextFill(Color.GREY);
            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Student Lists");			
			MainView.vbWorkSpace = StudentListsView.vbStudentListsView();
            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
		});
		vbAddStudentView = new VBox();
				
		lTitle = new Label(name+" Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 20, 50, 0);

		lStudentID = new Label("Student ID:");
		Style.LabelFillColorAndSize(lStudentID, "black", 17);

		llStudentID = new Label();
		Style.LabelFillColorAndSize(llStudentID, "grey", 17);
		llStudentID.setText(id);
		
		lStudentName = new Label("Student Name:");
		Style.LabelFillColorAndSize(lStudentName, "black", 17);
		
		llStudentName = new Label();
		Style.LabelFillColorAndSize(llStudentName, "grey", 17);
		llStudentName.setText(name);
		
		lPhoneNo = new Label("Phone No:");
		Style.LabelFillColorAndSize(lPhoneNo, "black", 17);

		llPhoneNo = new Label();
		llPhoneNo.setText(phoneNo);
		Style.LabelFillColorAndSize(llPhoneNo, "grey", 17);
		 
		lPresentAddress = new Label("Present Address:");
		Style.LabelFillColorAndSize(lPresentAddress, "black", 17);

		llPresentAddress = new Label();
		llPresentAddress.setPrefWidth(470);
		llPresentAddress.setText(presentAddress);
		Style.LabelFillColorAndSize(llPresentAddress, "grey", 17);
		
		lJoinDate = new Label("Join Date:");
		Style.LabelFillColorAndSize(lJoinDate, "black", 17);

		llJoinDate = new Label();
		Style.LabelFillColorAndSize(llJoinDate, "grey", 17);
		llJoinDate.setText(joinDate);
		
		vbStudentDataPart = new VBox();
		
		hbStudentTitlePart = new HBox();
		
		ImageView imgStudentIcon = new ImageView(new Image("Icon/suitcase.png"));
		
		lStudentTitle = new Label("Student Details");
		lStudentTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
		
		hbStudentTitlePart.getChildren().addAll(imgStudentIcon, lStudentTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbStudentTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpStudentDataPart = new GridPane();
		gpStudentDataPart.add(lStudentID, 0, 0);
		gpStudentDataPart.add(llStudentID, 1, 0);
		gpStudentDataPart.add(lStudentName, 0, 1);
		gpStudentDataPart.add(llStudentName, 1, 1);
		gpStudentDataPart.add(lJoinDate, 0, 2);
		gpStudentDataPart.add(llJoinDate, 1, 2);
		Style.GpFillColorAndSizeAndPadding(gpStudentDataPart, 10, 10, 17, 17, "white");
		
		vbStudentDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbStudentDataPart, hbStudentTitlePart, gpStudentDataPart);
	
		vbPersonalDataPart = new VBox();
		
		hbPersonalTitlePart = new HBox();
		
		ImageView imgPersonalData = new ImageView(new Image("Icon/contact.png"));
		
		lPersonalDataTitle = new Label("Personal Information Details");
		lPersonalDataTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,18));
		
		hbPersonalTitlePart.getChildren().addAll(imgPersonalData, lPersonalDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbPersonalTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpPersonalDataPart = new GridPane();
		gpPersonalDataPart.add(lPhoneNo, 0, 0);
		gpPersonalDataPart.add(llPhoneNo, 1, 0);
		gpPersonalDataPart.add(lPresentAddress, 0, 1);
		gpPersonalDataPart.add(llPresentAddress, 1, 1);
		Style.GpFillColorAndSizeAndPadding(gpPersonalDataPart, 10, 10, 17, 17, "white");
		
		vbPersonalDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbPersonalDataPart, hbPersonalTitlePart, gpPersonalDataPart);
		
		vbAddStudentView.getChildren().addAll(hbTitleCon,vbStudentDataPart,vbPersonalDataPart);
		vbAddStudentView.setPrefHeight(700);
		Style.VBoxFillColorAndSizeAndPadding(vbAddStudentView, "white", 10, 20,10);
		return vbAddStudentView;
		}
}

