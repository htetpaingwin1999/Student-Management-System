package View;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Date;
import Handler.Validation;
import List.CourseLists;
import List.StaffLists;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class AUDSectionView {
	private static VBox vbAddSectionView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lSectionID;
	public static TextField tSectionID;
	private static Label lSectionIDError;
	private static VBox vbSectionIDError;//a to a shay ma nyi lox
	private static Label lCourseName;
	public static ComboBox cbCourseName;
	private static Label llCourseName;
	private static Label lCourseNameError;
	private static VBox vbCourseNameError;
	private static Label lFee;
	private static TextField tFee;
	private static Label lFeeError;
	private static VBox vbFeeError;
	
	private static Label lStaffName;
	public static ComboBox cbStaffName;
	public static Label llStaffName;
	
	private static Label lStaffNameError;
	private static VBox vbStaffNameError;
	
	private static Label lStartDate;
	public static DatePicker dpStartDate;
	private static Label lStartDateError;
	private static VBox vbStartDateError;
	
	private static Label lEndDate;
	public static DatePicker dpEndDate;
	private static Label lEndDateError;
	private static VBox vbEndDateError;
	
	private static Label lFirstDay;
	public static ComboBox cbFirstDay;
	private static Label lFirstDayError;
	private static VBox vbFirstDayError;
	
	private static Label lFirstTime;
	public static TextField tFirstTime;
	private static Label lFirstTimeError;
	private static VBox vbFirstTimeError;
	
	private static Label lSecondDay;
	public static ComboBox cbSecondDay;
	private static Label lSecondDayError;
	private static VBox vbSecondDayError;
	
	private static Label lSecondTime;
	public static TextField tSecondTime;
	private static Label lSecondTimeError;
	private static VBox vbSecondTimeError;
	
	public static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static Button btnUpdate;
	private static Button btnDelete;
	public static HBox hbBtnCon;
	
	private static int chooseIndex1 = 0;
	private static int chooseIndex2 = 0;
	
	public static VBox vbAddSectionView(int sectionID,String courseName,String staffName,String startDate,String endDate,String firstDay,String firstTime,String secondDay,String secondTime,int action,int fee)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = SectionListsView.vbSectionListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
		});
		
		vbAddSectionView = new VBox();
		
		ArrayList<CourseLists> courseLists = Handler.CourseHandler.GetAllCourse();
		ArrayList<StaffLists> staffLists = Handler.StaffHandler.GetAllStaff(3); //three - teacher 
				
		lTitle = new Label("Add New Section");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 15, 50, 0);
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		btnSave = new Button("Save");
		Style.ButtonSave(btnSave);
		
		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		btnUpdate = new Button("Update");
		Style.ButtonUpdate(btnUpdate);
		
		Style.BtnDisable(btnSave, btnUpdate);
		
		hbBtnCon = new HBox();
		hbBtnCon.setSpacing(10);
		
		lSectionID = new Label("Section ID");
		Style.LabelFillColorAndSize(lSectionID, "grey", 15);

		tSectionID = new TextField();
		Style.TextFieldFill(tSectionID, 470, sectionID+"");
		tSectionID.setEditable(false);

		lSectionIDError = new Label("");
		Style.LabelFillColorAndSize(lSectionIDError, "red", 15);

		vbSectionIDError = new VBox();
		vbSectionIDError.getChildren().addAll(tSectionID,lSectionIDError);
		vbSectionIDError.setSpacing(3);
		
		lCourseName = new Label("Course Name");
		Style.LabelFillColorAndSize(lCourseName, "grey", 15);

		llCourseName = new Label(courseName);
		Style.LabelFillColorAndSize(llCourseName, "black", 15);

		cbCourseName = new ComboBox();
		cbCourseName.setPrefWidth(470);

		lCourseNameError = new Label("No Course Providied");
		Style.LabelFillColorAndSize(lCourseNameError, "red", 15);

		vbCourseNameError = new VBox();
		vbCourseNameError.setSpacing(3);
		vbCourseNameError.getChildren().addAll(cbCourseName,lCourseNameError);
		
		lFee = new Label("Fee");
		Style.LabelFillColorAndSize(lFee, "grey", 15);

		tFee = new TextField();
		tFee.setPrefWidth(470);
		tFee.setEditable(false);
		
		lFeeError = new Label("");
		Style.LabelFillColorAndSize(lFeeError, "red", 15);
		
		vbFeeError = new VBox();
		vbFeeError.getChildren().addAll(tFee,lFeeError);
		vbFeeError.setSpacing(3);
		
		lStaffName = new Label("Staff Name");
		Style.LabelFillColorAndSize(lStaffName, "grey", 15);

		llStaffName = new Label(""+staffName);
		Style.LabelFillColorAndSize(llStaffName, "black", 15);

		cbStaffName = new ComboBox();
		cbStaffName.setPrefWidth(470);

		lStaffNameError = new Label("");
		Style.LabelFillColorAndSize(lStaffNameError, "red", 15);
		
		vbStaffNameError = new VBox();
		vbStaffNameError.getChildren().addAll(cbStaffName,lStaffNameError);
		vbStaffNameError.setSpacing(3);
		
		lStartDate = new Label("Start Date");
		Style.LabelFillColorAndSize(lStartDate, "grey", 15);

		dpStartDate = new DatePicker();
		dpStartDate.setPrefWidth(470);
		dpStartDate.setPromptText(startDate);
		dpStartDate.setEditable(false);
		
		lStartDateError = new Label("");
		Style.LabelFillColorAndSize(lStartDateError, "red", 15);
		lStartDateError.setText("Choose start Date");

		vbStartDateError = new VBox();
		vbStartDateError.getChildren().addAll(dpStartDate,lStartDateError);
		vbStartDateError.setSpacing(3);
		
		lEndDate = new Label("End Date");
		Style.LabelFillColorAndSize(lEndDate, "grey", 15);

		dpEndDate = new DatePicker();
		dpEndDate.setPrefWidth(470);
		dpEndDate.setPromptText(endDate);
		dpEndDate.setEditable(false);

		lEndDateError = new Label("");
		Style.LabelFillColorAndSize(lEndDateError, "red", 15);
		lEndDateError.setText("Choose start Date");

		vbEndDateError = new VBox();
		vbEndDateError.getChildren().addAll(dpEndDate,lEndDateError);
		vbEndDateError.setSpacing(3);
			
		lFirstDay = new Label("First Day");
		Style.LabelFillColorAndSize(lFirstDay, "grey", 15);

		cbFirstDay = new ComboBox();
		cbFirstDay.setPrefWidth(470);

		lFirstDayError = new Label("Choose different day");
		Style.LabelFillColorAndSize(lFirstDayError, "red", 15);
		
		vbFirstDayError = new VBox();
		vbFirstDayError.getChildren().addAll(cbFirstDay,lFirstDayError);
		vbFirstDayError.setSpacing(3);
		
		lFirstTime = new Label("First Time");
		Style.LabelFillColorAndSize(lFirstTime, "grey", 15);

		tFirstTime = new TextField();
		Style.TextFieldFill(tFirstTime, 470, firstTime);

		lFirstTimeError = new Label("Times must be 0:00-00:00 AM/PM or 00:00-0:00 AM/PM");
		Style.LabelFillColorAndSize(lFirstTimeError, "red", 15);
		
		vbFirstTimeError = new VBox();
		vbFirstTimeError.getChildren().addAll(tFirstTime,lFirstTimeError);
		vbFirstTimeError.setSpacing(3);
		
		lSecondDay = new Label("Second Day");
		Style.LabelFillColorAndSize(lSecondDay, "grey", 15);

		cbSecondDay = new ComboBox();
		cbSecondDay.setPrefWidth(470);

		lSecondDayError = new Label("Choose different day");
		Style.LabelFillColorAndSize(lSecondDayError, "red", 15);
		
		cbFirstDay.getItems().addAll("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturaday");
		cbSecondDay.getItems().addAll("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturaday");
		cbFirstDay.getSelectionModel().select(0);
		cbSecondDay.getSelectionModel().select(1);

		vbSecondDayError = new VBox();
		vbSecondDayError.getChildren().addAll(cbSecondDay,lSecondDayError);
		vbSecondDayError.setSpacing(3);
		
		lSecondTime = new Label("Second Time");
		Style.LabelFillColorAndSize(lSecondTime, "grey", 15);

		tSecondTime = new TextField();
		Style.TextFieldFill(tSecondTime, 470, secondTime);

		lSecondTimeError = new Label("Times must be 0:00-00:00 AM/PM or 00:00-0:00 AM/PM");
		Style.LabelFillColorAndSize(lSecondTimeError, "red", 15);
		
		vbSecondTimeError = new VBox();
		vbSecondTimeError.getChildren().addAll(tSecondTime,lSecondTimeError);
		vbSecondTimeError.setSpacing(3);
		
		if(action==1)
		{	
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
			if(courseLists.size() ==0)
			{
				cbCourseName.getItems().add("No Course is Provided");
				lCourseNameError.setVisible(true);
			}
			if(courseLists.size()>0)
			{
				for(CourseLists c:courseLists)
				{
					cbCourseName.getItems().add(c.getCourseName());
					cbCourseName.getSelectionModel().select(0);
				}
				cbCourseName.getSelectionModel().select(0);
				tFee.setText(Handler.CourseHandler.GetUpdatedCourseFee(cbCourseName.getValue().toString())+"");
				
				cbCourseName.setOnAction(e->{
					tFee.setText(Handler.CourseHandler.GetUpdatedCourseFee(cbCourseName.getValue().toString())+"");
				});
				tSectionID.setText(Handler.SectionHandler.GetNewID()+"");
			}
			if(staffLists.size() == 0)
			{
				lStaffNameError.setText("No Teacher is employed");
				cbStaffName.getItems().add("No Teacher is employed");
				cbStaffName.getSelectionModel().select(0);
				lStaffNameError.setVisible(true);
			}
			if(staffLists.size()>0)
			{
				for(StaffLists c:staffLists)
				{
					cbStaffName.getItems().add(c.getStaffName());
				}
				cbStaffName.getSelectionModel().select(0);
			}
		}
		if(action == 2)
		{
			tFee.setText(fee+"");
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			lTitle.setText("Update Section");
	
			String []days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturaday"};
			int i = 0;
			for(String s:days)
			{
				
				if(firstDay.equals(s))
				{
					cbFirstDay.getSelectionModel().select(i);
					chooseIndex1 = i;
				}
				if(secondDay.equals(s))
				{
					cbSecondDay.getSelectionModel().select(i);
					chooseIndex2 = i;
				}
				i++;
			}
			
	}
		
		if(action == 2)
		{
			vbCourseNameError.getChildren().clear();
			vbCourseNameError.getChildren().addAll(llCourseName,lCourseNameError);
			vbStaffNameError.getChildren().clear();
			vbStaffNameError.getChildren().addAll(llStaffName,lStaffNameError);
		}
		
		gp = new GridPane();
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 10, "white");
		gp.add(lSectionID, 0, 0);
		gp.add(vbSectionIDError, 0, 1);

		gp.add(lCourseName, 1, 0);
		gp.add(vbCourseNameError, 1, 1);
		gp.add(lFee, 0, 2);
		gp.add(lStaffName, 1, 2);
		gp.add(vbFeeError, 0, 3);		
		gp.add(vbStaffNameError, 1, 3);
		
		gp.add(lStartDate, 0, 4);
		gp.add(lEndDate, 1, 4);
		gp.add(vbStartDateError, 0, 5);
		gp.add(vbEndDateError, 1, 5);
		
		gp.add(lFirstDay, 0, 6);
		gp.add(lFirstTime, 1, 6);
		gp.add(vbFirstDayError,0,7);
		gp.add(vbFirstTimeError, 1, 7);
		
		gp.add(lSecondDay, 0, 8);
		gp.add(lSecondTime, 1, 8);	
		gp.add(vbSecondDayError, 0, 9);
		gp.add(vbSecondTimeError, 1, 9);
		
		gp.add(hbBtnCon, 0, 10);
		
		tFirstTime.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkSectionOpenTime(tFirstTime.getText()))
			{
				lFirstTimeError.setVisible(true);
			}
			else
			{
				lFirstTimeError.setVisible(false);
				CheckIsOldAndValid(firstTime,secondTime,startDate,endDate,firstDay,secondDay,courseLists.size(),staffLists.size());
			}
		});
		
		tSecondTime.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkSectionOpenTime(tSecondTime.getText()))
			{
				lSecondTimeError.setVisible(true);
			}
			else
			{
				lSecondTimeError.setVisible(false);
				CheckIsOldAndValid(firstTime,secondTime,startDate,endDate,firstDay,secondDay,courseLists.size(),staffLists.size());
			}
		});
		
		cbFirstDay.setOnAction(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(cbFirstDay.getValue().toString().equals(cbSecondDay.getValue().toString()))
			{
				CheckDayMatch(true);
			}
			else
			{
				CheckDayMatch(false);
				CheckIsOldAndValid(firstTime,secondTime,startDate,endDate,firstDay,secondDay,courseLists.size(),staffLists.size());
			}		
		});
		
		cbSecondDay.setOnAction(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(cbFirstDay.getValue().toString().equals(cbSecondDay.getValue().toString()))
			{
				CheckDayMatch(true);
			}
			else
			{
				CheckDayMatch(false);
				CheckIsOldAndValid(firstTime,secondTime,startDate,endDate,firstDay,secondDay,courseLists.size(),staffLists.size());
			}		
		});
		
		
		dpStartDate.setOnAction(e->{
			if(!dpStartDate.getValue().equals(null))
			{
				CheckIsOldAndValid(firstTime,secondTime,startDate,endDate,firstDay,secondDay,courseLists.size(),staffLists.size());
			}		
			
		});
		
		dpEndDate.setOnAction(e->{
			if(!dpEndDate.getValue().equals(null))
			{
				CheckIsOldAndValid(firstTime,secondTime,startDate,endDate,firstDay,secondDay,courseLists.size(),staffLists.size());
			}		
			
		});
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to add new section",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();			
			if(al.getResult() == ButtonType.YES)
			{
				Alert al1 = new Alert(AlertType.INFORMATION,"Add succesfully");
				al1.showAndWait();		
					System.out.println(cbCourseName.getValue().toString()+Handler.CourseHandler.GetCourseID(cbCourseName.getValue().toString(),1));
					Handler.SectionHandler.AddNewSection(Handler.CourseHandler.GetCourseID(cbCourseName.getValue().toString(),1), dpStartDate.getValue().toString(), dpEndDate.getValue().toString(), cbFirstDay.getValue().toString(), tFirstTime.getText(), cbSecondDay.getValue().toString(), tSecondTime.getText().toString(), 1, Handler.StaffHandler.GetStaffID(cbStaffName.getValue().toString()));
					cbCourseName.getSelectionModel().select(0);
					cbStaffName.getSelectionModel().select(0);
					tFirstTime.setText("");
					tSecondTime.setText("");
					tSectionID.setText(Handler.SectionHandler.GetNewID()+"");
					dpStartDate.setValue(null);
					dpEndDate.setValue(null);
			}
		});
	
		btnUpdate.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to update this section",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();			
			if(al.getResult() == ButtonType.YES)
			{
				Handler.SectionHandler.UpdateSection(sectionID, dpStartDate.getValue().toString(), dpEndDate.getValue().toString(), cbFirstDay.getValue().toString(),tFirstTime.getText(), cbSecondDay.getValue().toString(), tSecondTime.getText());
				Alert alsuccess = new Alert(AlertType.INFORMATION,"Update Successfully");
				alsuccess.showAndWait();	
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = SectionListsView.vbSectionListsView();
				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				MainView.RemoveIndex();
  				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
			}
		});
		
		btnCancel.setOnAction(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			lStaffNameError.setVisible(false);
			lCourseNameError.setVisible(false);
			lStartDateError.setVisible(false);
			lEndDateError.setVisible(false);
			lFirstTimeError.setVisible(false);
			lSecondTimeError.setVisible(false);
			lFirstDayError.setVisible(false);
			lSecondDayError.setVisible(false);
			if(action == 2)
			{
				
				cbFirstDay.getSelectionModel().select(chooseIndex1);
				cbSecondDay.getSelectionModel().select(chooseIndex2);
				tSectionID.setText(sectionID+"");	
			}
			
			else
			{
				tSectionID.setText(Handler.SectionHandler.GetNewID()+"");
				cbFirstDay.getSelectionModel().select(0);
				cbSecondDay.getSelectionModel().select(1);
			}
			cbCourseName.getSelectionModel().select(0);
			cbStaffName.getSelectionModel().select(0);
			tFirstTime.setText(firstTime);
			tSecondTime.setText(secondTime);
			dpStartDate.setValue(null);
			dpEndDate.setValue(null);
		});
		vbAddSectionView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddSectionView, "#f2f2f2", 10, 0, 5);
		return vbAddSectionView;
		}
	
	private static void CheckIsOldAndValid(String firstTime,String secondTime,String st,String ed,String fd,String sd,int csize,int ssize)
	{
		if(Validation.checkSectionOpenTime(tFirstTime.getText()) && Validation.checkSectionOpenTime(tSecondTime.getText()) && dpStartDate.getValue()!=null && dpEndDate.getValue() !=null && csize >0 && ssize >0 && !cbFirstDay.getValue().toString().equals(cbSecondDay))
		{
			btnSave.setDisable(false);
			if(!(tFirstTime.getText().equals(firstTime) && tSecondTime.getText().equals(secondTime) && dpStartDate.getValue().toString().equals(st) && dpEndDate.getValue().toString().equals(ed) && cbFirstDay.getValue().toString().equals(fd) && cbSecondDay.getValue().toString().equals(sd) && cbFirstDay.getValue().toString().equals(cbSecondDay.getValue().toString())))
			{
				btnUpdate.setDisable(false);
			}
		}							
	}
	private static void CheckDayMatch(boolean b)
	{
		lFirstDayError.setVisible(b);
		lSecondDayError.setVisible(b);
	}
}

