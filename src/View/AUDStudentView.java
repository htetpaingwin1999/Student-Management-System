package View;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Date;

import Handler.StudentHandler;
import Handler.Validation;
import List.DepartmentLists;
import List.DesignationLists;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class AUDStudentView {
	private static VBox vbAddStudentView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lStudentID;
	public static TextField tStudentID;
	private static Label lStudentIDError;
	private static VBox vbStudentIDError;
	private static Label lStudentName;
	public static TextField tStudentName;
	private static Label lStudentNameError;
	private static VBox vbStudentNameError;
	private static Label lPhoneNo;
	public static TextField tPhoneNo;
	private static Label lPhoneNoError;
	private static VBox vbPhoneNoError;
	private static Label lPresentAddress;
	public static TextArea taPresentAddress;
	private static Label lPresentAddressError;
	private static VBox vbPresentAddressError;
	public static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static Button btnUpdate;
	private static Button btnDelete;
	public static HBox hbBtnCon;
	public static VBox vbAddStudentView(int studentID,String studentName,String phoneNo,String address,int action)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = StudentListsView.vbStudentListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Student Lists");
		});
		
		vbAddStudentView = new VBox();
			
		lTitle = new Label("Add New Student");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 15, 50, 0,1080,50);
		
		btnSave = new Button("Save");
		Style.ButtonSave(btnSave);

		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		btnUpdate = new Button("Update");
		Style.ButtonUpdate(btnUpdate);
		
		Style.BtnDisable(btnSave, btnUpdate);
		
		hbBtnCon = new HBox();
		hbBtnCon.setSpacing(10);

		lStudentID = new Label("Student ID");
		Style.LabelFillColorAndSize(lStudentID, "grey", 15);

		tStudentID = new TextField();
		tStudentID.setEditable(false);
		Style.TextFieldFill(tStudentID, 470, "");
		
		lStudentIDError = new Label("");
		Style.LabelFillColorAndSize(lStudentIDError, "grey", 15);

		vbStudentIDError = new VBox();
		vbStudentIDError.getChildren().addAll(tStudentID,lStudentIDError);
		vbStudentIDError.setSpacing(3);
		
		lStudentName = new Label("Student Name");
		Style.LabelFillColorAndSize(lStudentName, "grey", 15);

		tStudentName = new TextField();
		Style.TextFieldFill(tStudentName, 470, studentName);
		
		lStudentNameError = new Label("Use only alphabets and maximum 50 characters");
		Style.LabelFillColorAndSize(lStudentNameError, "red", 15);

		vbStudentNameError = new VBox();
		vbStudentNameError.getChildren().addAll(tStudentName,lStudentNameError);
		vbStudentNameError.setSpacing(3);
		
		tStudentName.setOnKeyReleased(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkName(tStudentName.getText()))
			{
				lStudentNameError.setVisible(true);
			}
			else
			{
				lStudentNameError.setVisible(false);
				CheckIsOldAndValid(studentName,phoneNo,address);
			}
		});
		
		if(action == 1)
		{
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
			tStudentID.setText(StudentHandler.GetNewID()+"");	
		}
		if(action !=1)
		{
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			tStudentID.setText(studentID+"");
		}
	
		lPhoneNo = new Label("Phone No");
		Style.LabelFillColorAndSize(lPhoneNo, "grey", 15);

		tPhoneNo = new TextField();
		Style.TextFieldFill(tPhoneNo, 470, phoneNo);

		lPhoneNoError = new Label("Type in this format 09-********* or 02-****** or 09-******");
		Style.LabelFillColorAndSize(lPhoneNoError, "red", 15);
		
		vbPhoneNoError = new VBox();
		vbPhoneNoError.getChildren().addAll(tPhoneNo,lPhoneNoError);
		vbPhoneNoError.setSpacing(3);
		
		tPhoneNo.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkPhone(tPhoneNo.getText()))
			{
				lPhoneNoError.setVisible(true);
			}				
			else
			{
				lPhoneNoError.setVisible(false);
				CheckIsOldAndValid(studentName,phoneNo,address);
			}
		});
		
		lPresentAddress = new Label("Present Address");
		Style.LabelFillColorAndSize(lPresentAddress, "grey", 15);
		
		taPresentAddress = new TextArea();
		taPresentAddress.setPrefWidth(470);
		taPresentAddress.setPrefHeight(100);
		taPresentAddress.setText(address);
				
		lPresentAddressError = new Label("Type minimum 4 character and maximum 50 characters");
		Style.LabelFillColorAndSize(lPresentAddressError, "red", 15);
		
		vbPresentAddressError = new VBox();
		vbPresentAddressError.getChildren().addAll(taPresentAddress,lPresentAddressError);
		vbPresentAddressError.setSpacing(3);
		
		taPresentAddress.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(taPresentAddress.getText().length() < 3)
			{
				lPresentAddressError.setVisible(true);
			}
			else
			{
				lPresentAddressError.setVisible(false);
				CheckIsOldAndValid(studentName,phoneNo,address);
			}
		});
		
		gp = new GridPane();
		gp.add(lStudentID, 0, 0);
		gp.add(lStudentName, 1, 0);
		gp.add(vbStudentIDError, 0, 1);
		gp.add(vbStudentNameError, 1, 1);
		gp.add(lPhoneNo, 0,2 );
		gp.add(vbPhoneNoError, 0, 3);
		gp.add(lPresentAddress, 0,4);
		gp.add(vbPresentAddressError,0,5);
		gp.add(hbBtnCon, 0, 6);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 10, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			
			if(al.getResult() == ButtonType.YES)
			{
				Handler.StudentHandler.AddNewStudent(tStudentName.getText(), tPhoneNo.getText(), taPresentAddress.getText(),1);
				tStudentID.setText(Handler.StudentHandler.GetNewID()+"");
				tStudentName.setText("");
				tPhoneNo.setText("");
				taPresentAddress.setText("");
			}
				
		});
		
		btnUpdate.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			
			if(al.getResult() == ButtonType.YES)
			{
				Handler.StudentHandler.UpdateStudent(tStudentID.getText(), tStudentName.getText(), tPhoneNo.getText(), taPresentAddress.getText(), 1);
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
  				MainView.vbWorkSpace = StudentListsView.vbStudentListsView();
  				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
  				MainView.lHome.setTextFill(Color.GREY);
  				MainView.RemoveIndex();
  				MainView.UpdateIndex(MainView.lIndex1, "Student Lists");
			}
		});
		
		btnCancel.setOnAction(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			lStudentNameError.setVisible(false);
			lPhoneNoError.setVisible(false);
			lPresentAddressError.setVisible(false);
			if(action == 1)
			{
				tStudentID.setText(Handler.StudentHandler.GetNewID()+"");
			}
			tStudentName.setText(studentName);
			tPhoneNo.setText(phoneNo);
			taPresentAddress.setText(address);
			
		});
		
		vbAddStudentView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddStudentView, "#f2f2f2", 10, 0, 5);

		return vbAddStudentView;
		}
	private static void CheckIsOldAndValid(String name,String phoneNo,String add)
	{
		if(Validation.checkName(tStudentName.getText()) && tStudentName.getText().length()<50 && Validation.checkPhone(tPhoneNo.getText()) && taPresentAddress.getText().length() >3 && taPresentAddress.getText().length()<50)
		{
			btnSave.setDisable(false);
			if(!(tStudentName.getText().equals(name) && tPhoneNo.getText().equals(phoneNo) && taPresentAddress.getText().equals(add) ))
			{
				btnUpdate.setDisable(false);
			}
		}
	}
}

