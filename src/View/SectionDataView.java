package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.StaffHandler;
import List.SectionLists;
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

public class SectionDataView {
	private static VBox vbAddStaffView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lSectionID,llSectionID;
	private static Label lCourseName,llCourseName;
	private static Label lCourseFee,llCourseFee;
	private static Label lStaffID,llStaffID;
	private static Label lStaffName,llStaffName;
	private static Label lAdminID,llAdminID;
	private static Label lAdminName,llAdminName;
	private static Label lStartDate,llStartDate;
	private static Label lEndDate,llEndDate;
	private static Label lFirstDay,llFirstDay;
	private static Label lSecondDay,llSecondDay;
	private static Label lFirstTime,llFirstTime;
	private static Label lSecondTime,llSecondTime;
	private static Label lModifiedDate,llModifiedDate;
	private static Label lNoofStudentJoined,llNoofStudentJoined;
	
	private static VBox vbCourseDataPart;
	private static HBox hbCourseTitlePart;
	private static Label  lCourseTitle;
	private static GridPane gpCourseDataPart;

	private static VBox vbAdminDataPart;
	private static HBox hbAdminTitlePart;
	private static Label  lAdminDataTitle;
	private static GridPane gpAdminDataPart;
	
	private static VBox vbSectionDataPart;
	private static HBox hbSectionTitlePart;
	private static Label  lSectionDataTitle;
	private static GridPane gpSectionDataPart;
	private static Button btnGetStudentJoin;
	
	
	public static VBox vbSectionDataView(int id,int isfnish)
	{
		SectionLists s = Handler.SectionHandler.GetSectionData(id);
		vbAddStaffView = new VBox();
			
		btnGetStudentJoin = new Button("Get No of Student");
		btnGetStudentJoin.setStyle("-fx-background-color:blue");
		btnGetStudentJoin.setPadding(new Insets(5,5,5,5));
		btnGetStudentJoin.setTextFill(Color.WHITE);
		btnGetStudentJoin.setFont(Font.font("Times New Roman", 15));
		btnGetStudentJoin.setPrefWidth(150);
		
	
		btnGetStudentJoin.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            MainView.vbWorkSpace = SectionStudentListView.vbSectionStudentListsView(id,isfnish);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.lHome.setTextFill(Color.GREY);
			if(isfnish == 0)
			{
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
				MainView.UpdateIndex(MainView.lIndex2, "Section Data");
				MainView.UpdateIndex(MainView.lIndex3, "No of Student");
			}
			else
			{
				MainView.RemoveIndex();
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
				MainView.UpdateIndex(MainView.lIndex2, "Finished Lists");
				MainView.UpdateIndex(MainView.lIndex3, "Finesed Section Data");
				MainView.UpdateIndex(MainView.lIndex4, "No of students");
			}
			

		});
		
		if(isfnish == 0)
		{
				MainView.lIndex1.setOnMouseClicked(e->{
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
	            MainView.vbWorkSpace = SectionListsView.vbSectionListsView();
				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				MainView.lHome.setTextFill(Color.GREY);
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
				
			});
		}
		else
		{
			MainView.lIndex1.setOnMouseClicked(e->{
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
	            MainView.vbWorkSpace = SectionListsView.vbSectionListsView();
				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				MainView.lHome.setTextFill(Color.GREY);
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
			});
			MainView.lIndex2.setOnMouseClicked(e->{
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
	            MainView.vbWorkSpace = FinishedSectionListsView.vbSectionListsView();
				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				MainView.lHome.setTextFill(Color.GREY);
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Expense Lists");
				MainView.UpdateIndex(MainView.lIndex1, "Finished Section Lists");
			});
		}
		
		lTitle = new Label("Section Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPadding(new Insets(20,50,20,50));
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.setStyle("-fx-background-color:white");
		hbTitleCon.getChildren().addAll(lTitle,btnGetStudentJoin);
		hbTitleCon.setSpacing(20);
		
		lSectionID = new Label("Section ID:");
		lSectionID.setFont(Font.font("Times New Roman", 17));
		lSectionID.setTextFill(Color.BLACK);

		llSectionID = new Label();
		llSectionID.setFont(Font.font("Times New Roman", 17));
		llSectionID.setTextFill(Color.GREY);
		llSectionID.setText(s.getSectionID()+"");
		
		lCourseName = new Label("Course Name:");
		lCourseName.setFont(Font.font("Times New Roman", 17));
		lCourseName.setTextFill(Color.BLACK);

		llCourseName = new Label();
		llCourseName.setFont(Font.font("Times New Roman", 17));
		llCourseName.setTextFill(Color.GREY);
		llCourseName.setText(s.getCourseName());

		lCourseFee = new Label("CourseFee:");
		lCourseFee.setFont(Font.font("Times New Roman", 17));
		lCourseFee.setTextFill(Color.BLACK);

		llCourseFee = new Label();
		llCourseFee.setFont(Font.font("Times New Roman", 17));
		llCourseFee.setTextFill(Color.GREY);
		llCourseFee.setText(s.getCourseFee()+"");

		lAdminID = new Label("Admin ID:");
		lAdminID.setFont(Font.font("Times New Roman", 17));
		lAdminID.setTextFill(Color.BLACK);

		llAdminID = new Label();
		llAdminID.setFont(Font.font("Times New Roman", 17));
		llAdminID.setTextFill(Color.GREY);
		llAdminID.setText(s.getAdminID()+"");
		
		lAdminName = new Label("Admin Name:");
		lAdminName.setFont(Font.font("Times New Roman", 17));
		lAdminName.setTextFill(Color.BLACK);

		llAdminName = new Label();
		llAdminName.setFont(Font.font("Times New Roman", 17));
		llAdminName.setTextFill(Color.GREY);
		llAdminName.setText(s.getAdminName());

		lStaffID = new Label("Teacher ID:");
		lStaffID.setFont(Font.font("Times New Roman", 17));
		lStaffID.setTextFill(Color.BLACK);

		llStaffID = new Label();
		llStaffID.setFont(Font.font("Times New Roman", 17));
		llStaffID.setTextFill(Color.GREY);
		llStaffID.setText(s.getStaffID()+"");
		
		lStaffName = new Label("Teacher Name:");
		lStaffName.setFont(Font.font("Times New Roman", 17));
		lStaffName.setTextFill(Color.BLACK);

		llStaffName = new Label();
		llStaffName.setFont(Font.font("Times New Roman", 17));
		llStaffName.setTextFill(Color.GREY);
		llStaffName.setText(s.getStaffName());
		
		lStartDate = new Label("Start Date:");
		lStartDate.setFont(Font.font("Times New Roman", 17));
		lStartDate.setTextFill(Color.BLACK);

		llStartDate = new Label();
		llStartDate.setFont(Font.font("Times New Roman", 17));
		llStartDate.setTextFill(Color.GREY);
		llStartDate.setText(s.getStartDate()+"");
		
		lEndDate = new Label("End Date:");
		lEndDate.setFont(Font.font("Times New Roman", 17));
		lEndDate.setTextFill(Color.BLACK);

		llEndDate = new Label();
		llEndDate.setFont(Font.font("Times New Roman", 17));
		llEndDate.setTextFill(Color.GREY);
		llEndDate.setText(s.getEndDate()+"");
		
		lFirstDay = new Label("First Day:");
		lFirstDay.setFont(Font.font("Times New Roman", 17));
		lFirstDay.setTextFill(Color.BLACK);

		llFirstDay = new Label();
		llFirstDay.setFont(Font.font("Times New Roman", 17));
		llFirstDay.setTextFill(Color.GREY);
		llFirstDay.setText(s.getFirstDay());
		
		lFirstTime = new Label("First Time:");
		lFirstTime.setFont(Font.font("Times New Roman", 17));
		lFirstTime.setTextFill(Color.BLACK);
		lFirstTime.setText(s.getFirstTime());
		
		llFirstTime = new Label();
		llFirstTime.setFont(Font.font("Times New Roman", 17));
		llFirstTime.setTextFill(Color.GREY);
		llFirstTime.setText(s.getFirstTime());
		
		lSecondDay = new Label("Second Day:");
		lSecondDay.setFont(Font.font("Times New Roman", 17));
		lSecondDay.setTextFill(Color.BLACK);

		llSecondDay = new Label();
		llSecondDay.setFont(Font.font("Times New Roman", 17));
		llSecondDay.setTextFill(Color.GREY);
		llSecondDay.setText(s.getSecondDay());

		lSecondTime = new Label("Second Time:");
		lSecondTime.setFont(Font.font("Times New Roman", 17));
		lSecondTime.setTextFill(Color.BLACK);

		llSecondTime = new Label();
		llSecondTime.setFont(Font.font("Times New Roman", 17));
		llSecondTime.setTextFill(Color.GREY);
		llSecondTime.setText(s.getSecondTime());
		
		lModifiedDate = new Label("Modified Date:");
		lModifiedDate.setFont(Font.font("Times New Roman", 17));
		lModifiedDate.setTextFill(Color.BLACK);

		llModifiedDate = new Label();
		llModifiedDate.setFont(Font.font("Times New Roman", 17));
		llModifiedDate.setTextFill(Color.GREY);
		llModifiedDate.setText(s.getDefinedDate()+"");

		lNoofStudentJoined = new Label("No of Student:");
		lNoofStudentJoined.setFont(Font.font("Times New Roman", 17));
		lNoofStudentJoined.setTextFill(Color.BLACK);

		llNoofStudentJoined = new Label();
		llNoofStudentJoined.setFont(Font.font("Times New Roman", 17));
		llNoofStudentJoined.setTextFill(Color.GREY);
		llNoofStudentJoined.setText(s.getNoOfStudent()+"");
	

		vbCourseDataPart = new VBox();
		
		hbCourseTitlePart = new HBox();
		
		ImageView imgCourseIcon = new ImageView(new Image("Icon/ocicon.png"));
		
		lCourseTitle = new Label("Course Details");
		Style.LabelFillColorAndSizeBold(lCourseTitle, "black", 18);
		
		hbCourseTitlePart.getChildren().addAll(imgCourseIcon, lCourseTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbCourseTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpCourseDataPart = new GridPane();
		gpCourseDataPart.add(lCourseName, 0, 0);
		gpCourseDataPart.add(llCourseName, 1, 0);
		gpCourseDataPart.add(lCourseFee, 0, 1);
		gpCourseDataPart.add(llCourseFee, 1, 1);
		Style.GpFillColorAndSizeAndPadding(gpCourseDataPart, 10,10, 17, 17, "white");
		
		vbCourseDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbCourseDataPart, hbCourseTitlePart, gpCourseDataPart);

		vbAdminDataPart = new VBox();
		
		hbAdminTitlePart = new HBox();
		
		ImageView imgAdminIcon = new ImageView(new Image("Icon/adminicon.png"));
		
		lAdminDataTitle = new Label("Admin & Teachers Details");
		Style.LabelFillColorAndSizeBold(lAdminDataTitle, "black", 18);
		
		hbAdminTitlePart.getChildren().addAll(imgAdminIcon, lAdminDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbAdminTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpAdminDataPart = new GridPane();
		gpAdminDataPart.add(lAdminID, 0, 0);
		gpAdminDataPart.add(llAdminID, 1, 0);
		gpAdminDataPart.add(lAdminName, 0, 1);
		gpAdminDataPart.add(llAdminName, 1, 1);
		gpAdminDataPart.add(lStaffID, 0, 2);
		gpAdminDataPart.add(llStaffID, 1, 2);
		gpAdminDataPart.add(lStaffName, 0, 3);
		gpAdminDataPart.add(llStaffName, 1, 3);
		Style.GpFillColorAndSizeAndPadding(gpAdminDataPart, 10, 10, 17, 17, "white");
	
		vbAdminDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbAdminDataPart, hbAdminTitlePart, gpAdminDataPart);
		
		vbSectionDataPart = new VBox();
		
		hbSectionTitlePart = new HBox();
		
		ImageView imgSectionIcon = new ImageView(new Image("Icon/category.png"));
		
		lSectionDataTitle = new Label("Section Details");
		Style.LabelFillColorAndSizeBold(lSectionDataTitle, "black", 18);
		
		hbSectionTitlePart.getChildren().addAll(imgSectionIcon, lSectionDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbSectionTitlePart, "#f9f9f9", 10, 10, 5);
		
		gpSectionDataPart = new GridPane();
		gpSectionDataPart.add(lSectionID, 0, 0);
		gpSectionDataPart.add(llSectionID, 1, 0);
		gpSectionDataPart.add(lStartDate, 2, 0);
		gpSectionDataPart.add(llStartDate, 3, 0);
		
		gpSectionDataPart.add(lEndDate, 0, 1);
		gpSectionDataPart.add(llEndDate, 1, 1);
		gpSectionDataPart.add(lFirstDay, 2, 1);
		gpSectionDataPart.add(llFirstDay, 3, 1);
		
		
		gpSectionDataPart.add(lFirstTime, 0, 2);
		gpSectionDataPart.add(llFirstTime, 1, 2);
		gpSectionDataPart.add(lSecondDay, 2, 2);
		gpSectionDataPart.add(llSecondDay, 3, 2);
		
		
		gpSectionDataPart.add(lModifiedDate, 0, 3);
		gpSectionDataPart.add(llModifiedDate, 1, 3);
		
		Style.GpFillColorAndSizeAndPadding(gpSectionDataPart, 10, 10, 17, 17, "white");
		
		vbSectionDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbSectionDataPart, hbSectionTitlePart, gpSectionDataPart);
		
		vbAddStaffView.getChildren().addAll(hbTitleCon,vbCourseDataPart,vbAdminDataPart,vbSectionDataPart);
		Style.VBoxFillColorAndSizeAndPadding(vbAddStaffView, "white", 10, 20, 5);
		vbAddStaffView.setPrefHeight(700);
		return vbAddStaffView;
		}
}

