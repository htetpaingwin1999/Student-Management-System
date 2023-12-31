package View;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Date;

import Handler.StaffHandler;
import Handler.Validation;
import List.DepartmentLists;
import List.DesignationLists;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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

public class AUDStaffView {
	private static VBox vbAddStaffView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	
	private static Label lStaffEmail;
	public static TextField tStaffEmail;
	private static Label lStaffEmailError;
	private static VBox vbStaffEmailError;
	
	private static Label lStaffName;
	public static TextField tStaffName;
	private static Label lStaffNameError;
	private static VBox vbStaffNameError;
	
	private static Label lPassword;
	private static TextField tPassword;
	private static Label lPasswordError;
	private static VBox vbPasswordError;
	
	private static Label lUsername;
	private static TextField tUsername;
	private static Label lUsernameError;
	private static VBox vbUsernameError;
	
	private static Label lGender;
	public static RadioButton rbMale;
	private static RadioButton rbFemale;
	private static HBox hbGenderCon;
	
	private static Label lDoB;
	public static TextField dpDoB;
	private static Label lDoBError;
	private static VBox vbDoBError;
	
	private static Label lphoneNo;
	public static TextField tPhoneNo;
	private static Label lphoneNoError;
	private static VBox vbphoneNoError;
	
	private static Label lPresentAddress;
	public static TextArea taPresentAddress;
	private static Label lPresentAddressError;
	private static VBox vbPresentAddressError;
	
	private static Label lJoinDate;
	public static TextField dpJoinDate;
	private static Label lJoinDateError;
	private static VBox vbJoinDateError;
	
	public static GridPane gp,gpJob;
	
	private static Label lDesignation;
	private static Label lDesignationError;
	private static VBox vbDesignationError;
	private static ComboBox cbDesignation;
	private static Label lMaxSalaryNMinSalary;
	private static HBox hbDesignationCon;
	
	private static Label lSalary;
	private static TextField tSalary;
	private static Label lSalaryError;
	private static VBox vbSalaryError;
	
	private static Button btnSave;
	private static Button btnUpdate;
	private static Button btnCancel;
	private static Button btnNext;
	private static Button btnPrevious;
	
	public static HBox hbBtnCon;
	private static int jSalary = 0;
	private static String g;
	
	private static boolean isFound = false;
	
	public static VBox vbAddStaffView(String email,String name,String joinDate,String gender,String doB,String phoneNo,String presentAddress,String password,String salary,String designationName,String username,int action,int staffID)
	{
		g = gender;
		
			
		vbAddStaffView = new VBox();
		ArrayList<DesignationLists> designationLists = Handler.DesignationHandler.GetAllDesignation();
			
		lTitle = new Label("Add New Staff");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 15, 50, 0,1080,50);
		
		btnSave = new Button("Save");
		Style.ButtonSave(btnSave);
		
		btnUpdate = new Button("Update");
		Style.ButtonUpdate(btnUpdate);

		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		btnNext = new Button("Next");
		Style.ButtonFillColorAndSize(btnNext, 15, 100, 30,10,10,"blue");
		
		btnPrevious = new Button("Previous");
		Style.ButtonFillColorAndSize(btnPrevious, 15, 100, 30,10,10,"orange");
		
		Style.BtnDisable(btnSave, btnUpdate);
				
		hbBtnCon = new HBox();
		
		lStaffEmail = new Label("Email");
		Style.LabelFillColorAndSize(lStaffEmail, "grey", 15);
		
		tStaffEmail = new TextField();
		Style.TextFieldFill(tStaffEmail, 470, email);
		
		lStaffEmailError = new Label("Please Type Valid Email and maximum 50 characters");
		Style.LabelFillColorAndSize(lStaffEmailError, "red", 15);
		
		vbStaffEmailError = new VBox();
		vbStaffEmailError.getChildren().addAll(tStaffEmail,lStaffEmailError);
		vbStaffEmailError.setSpacing(3);
		
		lStaffName = new Label("Staff Name");
		Style.LabelFillColorAndSize(lStaffName, "grey", 15);
		
		tStaffName = new TextField();
		Style.TextFieldFill(tStaffName, 470, name);
		
		lStaffNameError = new Label("Use only alphabets and maximum 50 characters");
		Style.LabelFillColorAndSize(lStaffNameError, "red", 15);

		vbStaffNameError = new VBox();
		vbStaffNameError.getChildren().addAll(tStaffName,lStaffNameError);
		vbStaffNameError.setSpacing(3);
		
		tStaffName.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			
			if(!Validation.checkName(tStaffName.getText()))
			{
				lStaffNameError.setVisible(true);
			}
			else
			{
				lStaffNameError.setVisible(false);
		    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
			}
		});
		
		tStaffEmail.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkEmail(tStaffEmail.getText()))
			{
				lStaffEmailError.setVisible(true);
			}
			else
			{
				lStaffEmailError.setVisible(false);
		    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);

			}
		});
		
		lUsername = new Label("Username");
		Style.LabelFillColorAndSize(lUsername, "grey", 15);
		
		tUsername = new TextField();
		tUsername.setEditable(false);
		Style.TextFieldFill(tUsername, 470, username);
		
		lUsernameError = new Label("");
		Style.LabelFillColorAndSize(lUsernameError, "red", 15);
		
		vbUsernameError = new VBox();
		vbUsernameError.getChildren().addAll(tUsername,lUsernameError);
		vbUsernameError.setSpacing(3);
			
		lPassword = new Label("Password");
		Style.LabelFillColorAndSize(lPassword, "grey", 15);
	
		tPassword = new TextField();
		Style.TextFieldFill(tPassword, 470, password);
		
		lPasswordError = new Label("");
		Style.LabelFillColorAndSize(lPasswordError, "red", 15);

		vbPasswordError = new VBox();
		vbPasswordError.getChildren().addAll(tPassword,lPasswordError);
		vbPasswordError.setSpacing(3);
		
		tPassword.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			
			if(Validation.checkPassword(tPassword.getText()) == false)
			{
				lPasswordError.setText(Validation.passwordError);
				lPasswordError.setVisible(true);
			}	
			else
			{
				lPasswordError.setVisible(false);
		    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
			}
		});
		
		lGender = new Label("Gender");
		Style.LabelFillColorAndSize(lGender, "grey", 15);
	
		rbMale = new RadioButton("Male");
		rbMale.setFont(Font.font("Times New Roman", 15));
		
		rbFemale = new RadioButton("Female");
		rbFemale.setFont(Font.font("Times New Roman",15));	
		
		
		rbMale.setOnAction(e->{
			rbMale.selectedProperty().set(true);
			rbFemale.selectedProperty().set(false);
			g = "Male";
	    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
			
		});
		rbFemale.setOnAction(e->{
			rbMale.selectedProperty().set(false);
			rbFemale.selectedProperty().set(true);
			g = "Female";
	    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
		});
		
		if(gender.equals("Male"))
		{
			rbMale.selectedProperty().set(true);
			rbFemale.selectedProperty().set(false);	
		}
		else if(gender.equals("Female"))
		{
			rbMale.selectedProperty().set(false);
			rbFemale.selectedProperty().set(true);
		}
	
		hbBtnCon.setSpacing(10);
		
		hbGenderCon = new HBox();
		hbGenderCon.getChildren().addAll(rbMale,rbFemale);
		hbGenderCon.setSpacing(10);
		
		lDoB = new Label("Date of Birth");
		Style.LabelFillColorAndSize(lDoB, "grey", 15);

		dpDoB = new TextField();
		Style.TextFieldFill(dpDoB, 470, doB);

		lDoBError = new Label("Type in this format 'yyyy-mm-dd'");
		Style.LabelFillColorAndSize(lDoBError, "red", 15);
		
		vbDoBError = new VBox();
		vbDoBError.getChildren().addAll(dpDoB,lDoBError);
		vbDoBError.setSpacing(3);
		
		dpDoB.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(Validation.checkDate(dpDoB.getText()) == false)
			{
				lDoBError.setVisible(true);
			}	
			else
			{
				lDoBError.setVisible(false);
		    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
			}
		});
			
		lDesignation = new Label("Designation");
		Style.LabelFillColorAndSize(lDesignation, "grey", 15);
		
		lDesignationError = new Label("");
		Style.LabelFillColorAndSize(lDesignationError, "red", 15);
		
		vbDesignationError = new VBox();
		
		cbDesignation = new ComboBox();
				
		lMaxSalaryNMinSalary = new Label("");
		Style.LabelFillColorAndSize(lMaxSalaryNMinSalary, "grey", 15);
		
		DesignationLists maxmind;
		
		if(action == 1)
		{
			hbBtnCon.getChildren().addAll(btnPrevious,btnSave,btnCancel);
			tUsername.setText("BSDS-"+Handler.StaffHandler.GetNewID());
		}
		if(action == 2)
		{
			MainView.lIndex1.setOnMouseClicked(e->{
				MainView.RemoveIndex();
  				MainView.UpdateIndex(MainView.lIndex1, "Staff Lists");
	            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = StaffListsView.vbStaffListsView();
	            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			});
			tUsername.setEditable(false);
			lTitle.setText("Update Staff");
			hbBtnCon.getChildren().addAll(btnPrevious,btnUpdate,btnCancel);		 
		}
		
		
		if(designationLists.size()>0)
		{	
			for(DesignationLists d:designationLists) 
			{
				cbDesignation.getItems().addAll(d.getDesignationName());

				if(designationName.equals(d.getDesignationName()))
				{
					cbDesignation.getSelectionModel().select(designationName);
					isFound = true;
				}
			}

			if(action == 2 && isFound == false) // wanted designatioins is removed from designation tables
			{
				cbDesignation.getItems().add(designationName); // so manually added
				cbDesignation.getSelectionModel().select(designationName);
			}
			if(action == 1)
			{
				cbDesignation.getSelectionModel().select(0);
				// can include found data or new ones
				
			}
			
			maxmind = Handler.DesignationHandler.GetMaxAndMinSalary(cbDesignation.getValue().toString());
			lMaxSalaryNMinSalary.setText("Maxmimum salary :"+ maxmind.getMaxSalary() +"Ks - Minimum Salary :"+maxmind.getMinSalary());		
			
//			if(action == 2 && isFound == false)
//			{
//				//old designation is delete and no new same data is found 
//				cbDesignation.getItems().add(designationName);
//				cbDesignation.getSelectionModel().select(index+1);
//				DesignationLists mm = Handler.DesignationHandler.GetMaxAndMinSalary(designationName);
//				lMaxSalaryNMinSalary.setText("Maxmimum salary :"+ mm.getMaxSalary() +"Ks - Minimum Salary :"+mm.getMinSalary());		
//			}
			
		}
		if(designationLists.size() == 0)
		{
			if(action == 1)
			{
				Style.BtnDisable(btnSave, btnUpdate);
				lDesignationError.setText("No Designation provided");
				lDesignationError.setVisible(true);
				lMaxSalaryNMinSalary.setText("");
				cbDesignation.getItems().add("No Designation has been Provide");
				cbDesignation.getSelectionModel().select(0);
			}
			else {
				cbDesignation.getItems().add(designationName);
				cbDesignation.getSelectionModel().select(designationName);
			}
		}

		if((action ==1 && designationLists.size() > 0 ) || action == 2 )
		{
			cbDesignation.setOnAction(e->{
				
			Style.BtnDisable(btnSave, btnUpdate);
			if(designationLists.size()>0 || action == 2 )
			{
				DesignationLists mm = Handler.DesignationHandler.GetMaxAndMinSalary(cbDesignation.getValue().toString());
				lMaxSalaryNMinSalary.setText("Maxmimum salary :"+ mm.getMaxSalary() +"Ks - Minimum Salary :"+mm.getMinSalary());
				 if(Validation.checkName(tStaffName.getText()) && Validation.checkDate(dpJoinDate.getText()) && Validation.checkDate(dpDoB.getText()) && Validation.checkPhone(tPhoneNo.getText()) && taPresentAddress.getText().length() > 3 && designationLists.size()>0 && Validation.checkMoney(tSalary.getText())) 
			     {
					 jSalary = Integer.parseInt(tSalary.getText());
						if(jSalary > mm.getMaxSalary())
						{
							lSalaryError.setText("Overthe maxmium salary,Reduce amount"+mm.getMaxSalary());	
							lSalaryError.setVisible(true);
						}
						else if(jSalary < mm.getMinSalary())
						{
//							vbSalaryError.getChildren().add(lSalaryError);
							lSalaryError.setText("Below the minimum salary,Add more amount");
							lSalaryError.setVisible(true);
						}
						else
						{
							lSalaryError.setText("");	
					    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
						}
			     }
			}
			});
		}
		
		else
		{
			lDesignationError.setText("No Designation provided");
			lDesignationError.setVisible(true);
			lMaxSalaryNMinSalary.setText("");		
		}
		
				
		hbDesignationCon = new HBox();
		hbDesignationCon.getChildren().addAll(cbDesignation,lMaxSalaryNMinSalary);
		hbDesignationCon.setSpacing(50);
		
		lDesignationError = new Label("");
		Style.LabelFillColorAndSize(lDesignationError, "red", 15);
		lDesignationError.setVisible(false);
		
		vbDesignationError = new VBox();
		vbDesignationError.getChildren().addAll(hbDesignationCon,lDesignationError);
		vbDesignationError.setSpacing(3);
		
		lSalary = new Label("Salary");
		Style.LabelFillColorAndSize(lSalary, "grey", 15);

		tSalary = new TextField();
		Style.TextFieldFill(tSalary, 470, salary);
		 
		lSalaryError = new Label();
		Style.LabelFillColorAndSize(lSalaryError, "red", 15);
		
		vbSalaryError = new VBox();
		vbSalaryError.getChildren().addAll(tSalary,lSalaryError);
		vbSalaryError.setSpacing(3);
		
		tSalary.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkMoney(tSalary.getText()))
			{
				lSalaryError.setText("Salary must be number");
				lSalaryError.setVisible(true);
			}
			if(Validation.checkMoney(tSalary.getText()))
			{
				if(designationLists.size() > 0)
				{
					DesignationLists ds = Handler.DesignationHandler.GetMaxAndMinSalary(cbDesignation.getValue().toString());
					jSalary = Integer.parseInt(tSalary.getText());
					if(jSalary > ds.getMaxSalary())
					{
						lSalaryError.setText("Overthe maxmium salary,Reduce amount"+ds.getMaxSalary());
						lSalaryError.setVisible(true);
					}
					else if(jSalary < ds.getMinSalary())
					{
						lSalaryError.setText("Below the minimum salary,Add more amount");
						lSalaryError.setVisible(true);
					}
					else
					{
						lSalaryError.setVisible(false);
				    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
					}
				}
				else
				{
					lDesignationError.setText("No Designation provided");
					lDesignationError.setVisible(true);
					lMaxSalaryNMinSalary.setText("");
				}
			}
		});
		
		lphoneNo = new Label("Phone No");
		Style.LabelFillColorAndSize(lphoneNo, "grey", 15);

		tPhoneNo = new TextField();
		tPhoneNo.setPrefWidth(470);
		tPhoneNo.setText(phoneNo);
		Style.TextFieldFill(tPhoneNo, 470, phoneNo);
		 
		lphoneNoError = new Label("Tyep in this format 09*********,09*****,02******");
		Style.LabelFillColorAndSize(lphoneNoError, "red", 15);
		lphoneNoError.setVisible(false);

		vbphoneNoError = new VBox();
		vbphoneNoError.getChildren().addAll(tPhoneNo,lphoneNoError);
		vbphoneNoError.setSpacing(3);
		
		tPhoneNo.setOnMouseExited(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(Validation.checkPhone(tPhoneNo.getText()) == false)
			{
				lphoneNoError.setVisible(true);
			}	
			else
			{
				lphoneNoError.setVisible(false);
		    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
			}
		});
		
		lPresentAddress = new Label("Present Address");
		Style.LabelFillColorAndSize(lPresentAddress, "grey", 15);

		taPresentAddress = new TextArea();
		taPresentAddress.setPrefWidth(470);
		taPresentAddress.setPrefHeight(100);
		taPresentAddress.setText(presentAddress);
				
		lPresentAddressError = new Label("Type minimum 3 characters and maximum 50 characters");
		Style.LabelFillColorAndSize(lPresentAddressError, "red", 15);
		lPresentAddressError.setVisible(false);

		vbPresentAddressError = new VBox();
		vbPresentAddressError.getChildren().addAll(taPresentAddress,lPresentAddressError);
		vbPresentAddressError.setSpacing(3);
		
		taPresentAddress.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(taPresentAddress.getText().length() < 3 || taPresentAddress.getText().length()>50)
			{
				lPresentAddressError.setVisible(true);
			}	
			else
			{
				lPresentAddressError.setVisible(false);
		    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
			}
		});
		lJoinDate = new Label("Join Date");
		Style.LabelFillColorAndSize(lJoinDate, "grey", 15);

		dpJoinDate = new TextField();
		Style.TextFieldFill(dpJoinDate, 470,joinDate);
		
		lJoinDateError = new Label("Type in this format 'yyyy-mm-dd'");
		Style.LabelFillColorAndSize(lJoinDateError, "red", 15);

		vbJoinDateError = new VBox();
		vbJoinDateError.getChildren().addAll(dpJoinDate,lJoinDateError);
		vbJoinDateError.setSpacing(3);

		dpJoinDate.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(Validation.checkDate(dpJoinDate.getText()) == false)
			{
				lJoinDateError.setVisible(true);
			}	
			else
			{
				lJoinDateError.setVisible(false);
		    	CheckValidAndIsOld(name,email,doB,joinDate,password,presentAddress,designationName,salary,gender,g,designationLists.size(),phoneNo);
			}
		});
		
		
		gp = new GridPane();
		gp.add(lStaffName, 0, 0);
		gp.add(lStaffEmail, 1, 0);
		gp.add(vbStaffNameError, 0,1);
		gp.add(vbStaffEmailError, 1, 1);
		gp.add(lJoinDate, 0, 2);
		gp.add(lGender, 1, 2);
		gp.add(vbJoinDateError, 0, 3);
		gp.add(hbGenderCon, 1, 3);
		gp.add(lDoB, 0, 4);
		gp.add(lphoneNo, 1, 4);
		gp.add(vbDoBError, 0, 5);
		gp.add(vbphoneNoError, 1, 5);
		gp.add(lPassword, 0, 6);
		gp.add(lUsername, 1, 6);
		gp.add(vbPasswordError, 0, 7);
		gp.add(vbUsernameError, 1, 7);
		gp.add(lPresentAddress, 0,8);
		gp.add(vbPresentAddressError,0,9);
		gp.add(btnNext, 0, 10);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 10, "white");
		
		gpJob = new GridPane();
		gpJob.setHgap(20);
		gpJob.setVgap(10);
		gpJob.add(hbDesignationCon, 0, 0);
		gpJob.add(vbDesignationError,0,1 );
		gpJob.add(lSalary, 0, 2);
		gpJob.add(vbSalaryError, 0, 3);
		gpJob.add(hbBtnCon, 0, 4);
		Style.GpFillColorAndSizeAndPadding(gpJob, 10, 10, 20, 10, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			if(al.getResult() == ButtonType.YES)
			{
					DesignationLists ds = Handler.DesignationHandler.GetMaxAndMinSalary(cbDesignation.getValue().toString());	
			    	if(StaffHandler.AddNewStaff("", tStaffName.getText(), dpJoinDate.getText().toString(),g,dpDoB.getText().toString(), tPhoneNo.getText(), taPresentAddress.getText(), tPassword.getText(), tSalary.getText(), ds.getDesignationID()+"",tUsername.getText(),tStaffEmail.getText()))
			    	{
			    		Alert alsuccess = new Alert(AlertType.INFORMATION,"Added Succesfully");
						alsuccess.showAndWait();
						tStaffEmail.setText("");
				    	tUsername.setText("BSDA-"+StaffHandler.GetNewID()+"");
						dpJoinDate.setText("");
						dpDoB.setText("");
						rbMale.setSelected(false);
						rbFemale.setSelected(true);
						tPassword.setText("BSDS!123a11");
						tPhoneNo.setText("");
						taPresentAddress.setText("");
						tStaffName.setText("");
						cbDesignation.getSelectionModel().select(0);
						tSalary.setText("");
			    	}
			    	else
			    	{
			    		Alert alsuccess = new Alert(AlertType.ERROR,"Use different email address");
						alsuccess.showAndWait();
			    	}  	
			}
		});
		
		btnUpdate.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			if(al.getResult() == ButtonType.YES)
			{
				
					Handler.StaffHandler.UpdateStaffData(staffID+"", tStaffName.getText(), dpJoinDate.getText(),g, dpDoB.getText(), tPhoneNo.getText(), taPresentAddress.getText(), tPassword.getText());	
						
					if(!tSalary.getText().equals(salary) || !cbDesignation.getValue().toString().equals(designationName))
					{
						DesignationLists ds = Handler.DesignationHandler.GetMaxAndMinSalary(cbDesignation.getValue().toString());
						Handler.StaffHandler.UpdateDesignationAndSalary(staffID+"", Login.userid, ds.getDesignationID()+"", tSalary.getText());
						Alert alsuccess = new Alert(AlertType.INFORMATION,"Staff desigantion and salary is updated");
						alsuccess.showAndWait();	
					}
					if(!tStaffEmail.getText().equals(email))
					{
						
						if(Handler.StaffHandler.UpdateStaffEmail(staffID+"", tStaffEmail.getText()))
						{
						}
						else
						{
							Alert alss = new Alert(AlertType.ERROR,"You can't update email to other's email");
							alss.showAndWait();
						}
					}
					else
					{
						Alert alss = new Alert(AlertType.INFORMATION,"Update successfully");
						alss.showAndWait();
					}
					
					MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
					MainView.vbWorkSpace = StaffListsView.vbStaffListsView();
					MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
					MainView.RemoveIndex();
	  				MainView.UpdateIndex(MainView.lIndex1, "Staff Lists");
			}
					
		});
		
		btnCancel.setOnAction(e->{
			lStaffNameError.setVisible(false);
			lStaffEmailError.setVisible(false);
			lPresentAddressError.setVisible(false);
			lphoneNoError.setVisible(false);
			lDoBError.setVisible(false);
			lJoinDateError.setVisible(false);
			lDesignationError.setVisible(false);
			lSalaryError.setVisible(false);
			lPasswordError.setVisible(false);
			lphoneNoError.setVisible(false);
			Style.BtnDisable(btnSave, btnUpdate);
			if(gender.equals("Male"))
			{
				rbMale.selectedProperty().set(true);
				rbFemale.selectedProperty().set(false);	
			}
			else if(gender.equals("Female"))
			{
				rbMale.selectedProperty().set(false);
				rbFemale.selectedProperty().set(true);
			}
			if(action == 1)
			{
				tStaffEmail.setText(StaffHandler.GetNewID()+"");
				tUsername.setText("BSDA-"+StaffHandler.GetNewID()+"");
			}
			else
			{
				tStaffEmail.setText(email);
				tUsername.setText(username);
			}
			dpJoinDate.setText(joinDate);
			dpDoB.setText(doB);
			tPassword.setText(password);
			tPhoneNo.setText(phoneNo);
			taPresentAddress.setText(presentAddress);
			tStaffName.setText(name);
			tSalary.setText(salary);
			
		});
		
		btnNext.setOnAction(e->{
			vbAddStaffView.getChildren().remove(gp);
			vbAddStaffView.getChildren().addAll(gpJob);

		});
		btnPrevious.setOnAction(e->{
			vbAddStaffView.getChildren().remove(gpJob);
			vbAddStaffView.getChildren().addAll(gp);

		});
		vbAddStaffView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddStaffView, "#f2f2f2", 10, 0, 5);
		return vbAddStaffView;
		}
	
	private static void CheckValidAndIsOld(String name,String email,String doB,String joinDate,String password,String presentAddress,String designationName,String salary,String gender,String g,int dsize,String phone)
	{
		if(Validation.checkName(tStaffName.getText()) && tStaffName.getText().length()<50 && Validation.checkEmail(tStaffEmail.getText()) && tStaffEmail.getText().length()<50 && Validation.checkDate(dpDoB.getText()) && Validation.checkDate(dpJoinDate.getText()) && Validation.checkPassword(tPassword.getText()) && taPresentAddress.getText().length() >=3  && taPresentAddress.getText().length()<50 && Validation.checkMoney(tSalary.getText()) && Validation.checkPhone(tPhoneNo.getText()))
		{
			if(dsize >0)
			{
				btnSave.setDisable(false);
			}
			if(!(tStaffName.getText().equals(name) && tStaffEmail.getText().equals(tStaffEmail.getText()) && dpDoB.getText().equals(doB) && dpJoinDate.getText().equals(joinDate) && tPassword.getText().equals(password) && taPresentAddress.getText().equals(presentAddress) && cbDesignation.getValue().toString().equals(designationName) && tPhoneNo.getText().equals(phone)  && tSalary.getText().equals(salary) && gender.equals(g)))
	    	{
				btnUpdate.setDisable(false);
	    	}
		}
	
	}
}

