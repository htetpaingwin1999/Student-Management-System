package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.AdminHandler;
import Handler.Validation;
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

public class AUDAdminView {
	private static VBox vbAddAdminView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lAdminEmail;
	public static TextField tAdminEmail;
	private static Label lAdminEmailError;
	private static VBox vbAdminEmailError;
	private static Label lAdminName;
	public static TextField tAdminName;
	private static Label lAdminNameError;
	private static VBox vbAdminNameError;
	private static Label lPassword;
	private static TextField tPassword;
	private static Label lPasswordError;
	private static VBox vbPasswordError;
	private static Label lUserName;
	private static TextField tUserName;
	private static Label lUserNameError;
	private static VBox vbUserNameError;
	private static Label lGender;
	public static RadioButton rbMale;
	private static RadioButton rbFemale;
	private static HBox hbGenderCon;
	private static Label lDoB;
	public static TextField dpDoB;
	private static Label lDoBError;
	private static VBox vbDoBError;
	private static Label lPhoneNo;
	public static TextField tPhoneNo;
	private static Label lPhoneNoError;
	private static VBox vbPhoneNoError;
	private static Label lPresentAddress;
	public static TextArea taPresentAddress;
	private static Label lPresentAddressError;
	private static VBox vbPresentAddressError;
	private static Label lJoinDate;
	public static TextField dpJoinDate;
	private static Label lJoinDateError;
	private static VBox vbJoinDateError;
	public static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static Button btnUpdate;
	private static Button btnDelete;
	public static HBox hbBtnCon;
	private static String g;
	private static Label lUsernameHelp;
	public static VBox vbAddAdminView(String email,String name,String joinDate,String gender,String doB,String phoneNo,String presentAddress,String password,String username,int action,int id)
	{
		
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AdminListsView.vbAdminListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.UpdateIndex(MainView.lIndex1, "Admin Lists");
		});
		
		 g = "Male";
		
		 lUsernameHelp = new Label();
		 lUsernameHelp.setText(username);
		 
		vbAddAdminView = new VBox();
				
		lTitle = new Label("");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 15, 50, 0,1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		btnSave = new Button("Save");
		Style.ButtonSave(btnSave);

		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		btnUpdate = new Button("Update");
		Style.ButtonUpdate(btnUpdate);
		
		Style.BtnDisable(btnSave, btnUpdate);
		
		hbBtnCon = new HBox();

		lAdminEmail = new Label("Email");
		Style.LabelFillColorAndSize(lAdminEmail, "GREY", 15);

		tAdminEmail = new TextField();
		Style.TextFieldFill(tAdminEmail, 470, email);
				
		lAdminEmailError = new Label("Please Type Valid Email and maximum 50 characters");
		Style.LabelFillColorAndSize(lAdminEmailError, "red", 15);

		vbAdminEmailError = new VBox();
		vbAdminEmailError.getChildren().addAll(tAdminEmail,lAdminEmailError);
		vbAdminEmailError.setSpacing(3);
		
		lAdminName = new Label("Admin Name");
		Style.LabelFillColorAndSize(lAdminName, "grey", 15);
		
		tAdminName = new TextField();
		Style.TextFieldFill(tAdminName, 470, name);
		
		lAdminNameError = new Label("Use only alphabets and maximum 50 characters");
		Style.LabelFillColorAndSize(lAdminNameError, "red", 15);
		
		vbAdminNameError = new VBox();
		vbAdminNameError.getChildren().addAll(tAdminName,lAdminNameError);
		vbAdminNameError.setSpacing(3);
		
		tAdminName.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Handler.Validation.checkName(tAdminName.getText()))
			{
				lAdminNameError.setVisible(true);
			}
			else
			{
				lAdminNameError.setVisible(false);
				if(action == 1)
				{
					tUserName.setText(tAdminName.getText());
				}
				
				if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
				{
					btnSave.setDisable(false);
					CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
				}
				
			}
		});
		
		
		tAdminEmail.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Handler.Validation.checkEmail(tAdminEmail.getText()) || tAdminEmail.getText().length()>100)
			{
				lAdminEmailError.setVisible(true);
			}
			else
			{
				lAdminEmailError.setVisible(false);
				 
				if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
				{				
					btnSave.setDisable(false);
					CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
				}
			}
		});
		
		
		lPassword = new Label("Password");
		Style.LabelFillColorAndSize(lPassword, "grey", 15);
		
		tPassword = new TextField();
		Style.TextFieldFill(tPassword, 470, password);
		
		if(action==1)
		{
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
			hbBtnCon.setSpacing(10);
			lTitle.setText("Add New Admin");
			tPassword.setText("Admin123!a");
		}
		if(action == 2 )
		{
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			hbBtnCon.setSpacing(10);
			lTitle.setText("Update Admin");
			tPassword.setEditable(false);
		}
		
		lPasswordError = new Label("");
		Style.LabelFillColorAndSize(lPasswordError, "red", 15);

		vbPasswordError = new VBox();
		vbPasswordError.getChildren().addAll(tPassword,lPasswordError);
		vbPasswordError.setSpacing(3);
		
		lUserName = new Label("Username");
		Style.LabelFillColorAndSize(lUserName, "grey", 15);
		
		tUserName = new TextField();
		Style.TextFieldFill(tUserName, 470, username);

		lUserNameError = new Label("");
		Style.LabelFillColorAndSize(lUserNameError, "red", 15);
		
		vbUserNameError = new VBox();
		vbUserNameError.getChildren().addAll(tUserName,lUserNameError);
		vbUserNameError.setSpacing(3);
		
		tPassword.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			
			if(!Validation.checkPassword(tPassword.getText()))
			{
				lPasswordError.setVisible(true);
				lPasswordError.setText(Validation.passwordError);
			}		
			else
			{
				lPasswordError.setVisible(false);
				if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
				{				
					btnSave.setDisable(false);
					CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
				}
			}
		});
		
		lGender = new Label("Gender");
		Style.LabelFillColorAndSize(lGender, "grey", 15);
		
		rbMale = new RadioButton("Male");
		rbMale.setFont(Font.font("Times New Roman", 15));
		rbMale.selectedProperty().set(true);
		
		rbFemale = new RadioButton("Female");
		rbFemale.setFont(Font.font("Times New Roman",15));
		
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
		
		rbFemale.setOnAction(e->{
			rbMale.selectedProperty().set(false);
			rbFemale.selectedProperty().set(true);
			g ="Female";
			if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
			{				
				btnSave.setDisable(false);
				CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
			}
		});
		rbMale.setOnAction(e->{
			rbMale.selectedProperty().set(true);
			rbFemale.selectedProperty().set(false);
			g = "Male";
			if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
			{				
				btnSave.setDisable(false);
				CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
			}
		});
		
		hbGenderCon = new HBox();
		hbGenderCon.getChildren().addAll(rbMale,rbFemale);
		hbGenderCon.setSpacing(10);
		
		lDoB = new Label("Date of Birth");
		Style.LabelFillColorAndSize(lDoB, "grey", 15);

		dpDoB = new TextField();
		Style.TextFieldFill(dpDoB, 470, doB);

		lDoBError = new Label("Type in this format yyyy-mm-dd");
		Style.LabelFillColorAndSize(lDoBError, "red", 15);
		
		vbDoBError = new VBox();
		vbDoBError.getChildren().addAll(dpDoB,lDoBError);
		vbDoBError.setSpacing(3);
	
		lPhoneNo = new Label("Phone No");
		Style.LabelFillColorAndSize(lPhoneNo, "grey", 15);

		tPhoneNo = new TextField();
		Style.TextFieldFill(tPhoneNo, 470, phoneNo);
		 
		lPhoneNoError = new Label("Type in this format 09********* or 09****** or 02******");
		Style.LabelFillColorAndSize(lPhoneNoError, "red", 15);
		
		vbPhoneNoError = new VBox();
		vbPhoneNoError.getChildren().addAll(tPhoneNo,lPhoneNoError);
		vbPhoneNoError.setSpacing(3);
		
		tPhoneNo.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkPhone(tPhoneNo.getText()))
			{
				lPhoneNoError.setVisible(true);
				if(!dpDoB.getText().equals("")) {
					Style.CheckDate(dpDoB, lDoBError);
				}
			}	
			else
			{
				lPhoneNoError.setVisible(false);
				Style.CheckDate(dpDoB, lDoBError);
				
				if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
				{				
					btnSave.setDisable(false);
					CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
				}
			}
		});
		
		dpDoB.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkDate(dpDoB.getText()))
			{
				lDoBError.setVisible(true);
				Style.CheckPhoneNo(tPhoneNo, lPhoneNoError);
			}	
			else
			{
				lDoBError.setVisible(false);
				Style.CheckPhoneNo(tPhoneNo, lPhoneNoError);
				 
				if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
				{				
					btnSave.setDisable(false);
					CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
				}
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
		
		vbPresentAddressError = new VBox();
		vbPresentAddressError.getChildren().addAll(taPresentAddress,lPresentAddressError);
		vbPresentAddressError.setSpacing(3);
		
		taPresentAddress.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			
			if(taPresentAddress.getText().length()<3 || taPresentAddress.getText().length()>50)
			{
				lPresentAddressError.setVisible(true);
			}			
			else
			{
				lPresentAddressError.setVisible(false);
				if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
				{				
					btnSave.setDisable(false);
					CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
				}
				
			}
		});
		
		
		lJoinDate = new Label("Join Date");
		Style.LabelFillColorAndSize(lJoinDate, "grey", 15);

		dpJoinDate = new TextField();
		Style.TextFieldFill(dpJoinDate, 470, joinDate);
		
		lJoinDateError = new Label("Type in this format yyyy-mm-dd");
		Style.LabelFillColorAndSize(lJoinDateError, "red", 15);
		
		vbJoinDateError = new VBox();
		vbJoinDateError.getChildren().addAll(dpJoinDate,lJoinDateError);
		vbJoinDateError.setSpacing(3);
		
		dpJoinDate.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkDate(dpJoinDate.getText()))
			{
				lJoinDateError.setVisible(true);
			}	
			else
			{
				lJoinDateError.setVisible(false);
				if(Style.CheckAllValid(tAdminEmail,tAdminName,dpJoinDate,dpDoB,tPassword,taPresentAddress,tPhoneNo))
				{				
					btnSave.setDisable(false);
					CheckForUpdate(name,email,joinDate,doB,password,presentAddress,phoneNo,gender,g);
				}
			}
		});
		gp = new GridPane();
		gp.add(lAdminName, 0, 0);
		gp.add(lAdminEmail, 1, 0);
		gp.add(vbAdminNameError, 0, 1);
		gp.add(vbAdminEmailError, 1, 1);
		gp.add(lJoinDate, 0, 2);
		gp.add(lGender, 1, 2);
		gp.add(vbJoinDateError, 0, 3);
		gp.add(hbGenderCon, 1, 3);
		gp.add(lDoB, 0, 4);
		gp.add(lPhoneNo, 1, 4);
		gp.add(vbDoBError, 0, 5);
		gp.add(vbPhoneNoError, 1, 5);
		gp.add(lUserName, 0, 6);
		gp.add(lPassword, 1, 6);
		gp.add(vbUserNameError, 0, 7);
		gp.add(vbPasswordError, 1, 7);
		gp.add(lPresentAddress, 0,8);
		gp.add(vbPresentAddressError,0,9);
		gp.add(hbBtnCon, 0, 10);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 10, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			btnSave.setDisable(true);
			if(al.getResult() == ButtonType.YES)
			{
				AdminHandler.AddNewAdmin(tAdminName.getText(),dpJoinDate.getText().toString(), gender, dpDoB.getText().toString(), tPhoneNo.getText(), taPresentAddress.getText(), tPassword.getText(),tUserName.getText(),tAdminEmail.getText());
				Alert alsuccess = new Alert(AlertType.INFORMATION,"Added successfully");
				alsuccess.showAndWait();
				tAdminEmail.setText("");
				dpJoinDate.setText(joinDate);
				dpDoB.setText(doB);
				rbMale.setSelected(true);
				rbFemale.setSelected(false);
				tPassword.setText("");
				tPhoneNo.setText("");
				taPresentAddress.setText("");
				tAdminName.setText("");
			}					
		});
		
		
		btnUpdate.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			
			if(al.getResult() == ButtonType.YES)
			{
	    	  if(tAdminEmail.getText().equals(email))
	    	  {
	    		  if(Handler.AdminHandler.UpdateAdminData(id,tAdminName.getText(), dpJoinDate.getText()+"", g, dpDoB.getText()+"", tPhoneNo.getText(), taPresentAddress.getText(), tPassword.getText(),tUserName.getText()));
	 	    			Alert alsuccess = new Alert(AlertType.INFORMATION,"update successfully");
	 		    	    alsuccess.showAndWait(); 	    	
	    	  }
	    	  else
	    	  {
	    		  if(Handler.AdminHandler.UpdateAdmin(id,tAdminName.getText(), dpJoinDate.getText()+"", g, dpDoB.getText()+"", tPhoneNo.getText(), taPresentAddress.getText(), tPassword.getText(),tUserName.getText(),tAdminEmail.getText()))
	 			 {
	 	    			Alert alsuccess = new Alert(AlertType.INFORMATION,"update successfully");
	 		    	    alsuccess.showAndWait();
	 		    	   MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
	 					MainView.vbWorkSpace = AdminListsView.vbAdminListsView();
	 					MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
	 					MainView.UpdateIndex(MainView.lIndex1, "Admin Lists");
	 			 }
	 	    	 else
	 	    	 {
	 	    			Alert alerror = new Alert(AlertType.ERROR,"Please use different email");
	 		    	    alerror.showAndWait();
	 	    	 }
	    	  }
	    	
	    		
			}
		});
		
		btnCancel.setOnAction(e->{
			btnSave.setDisable(true);
			btnUpdate.setDisable(true);
			lJoinDateError.setVisible(false);
			lPresentAddressError.setVisible(false);
			lPhoneNoError.setVisible(false);
			lDoBError.setVisible(false);
			lPasswordError.setVisible(false);
			lUserNameError.setVisible(false);
			lAdminNameError.setVisible(false);
			lAdminEmailError.setVisible(false);
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
				tUserName.setText("");
				tPassword.setText("Admin123!a");
			}
			else
			{
				tAdminName.setText(name);
				tUserName.setText(username);
			}
			
			tAdminEmail.setText(email+"");
			dpJoinDate.setText(joinDate);
			dpDoB.setText(doB+"");
			tPassword.setText(password);
			tPhoneNo.setText(phoneNo);
			taPresentAddress.setText(presentAddress);
			
		});
		
		vbAddAdminView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddAdminView, "#f2f2f2", 10, 0, 5);
		return vbAddAdminView;
		}
	
	private static void CheckForUpdate(String name,String email,String joinDate,String doB,String password,String presentAddress,String phoneNo,String gender,String newgender)
	{
		btnUpdate.setDisable(true);
		if(!(tAdminName.getText().equals(name) && tAdminEmail.getText().equals(email) && dpJoinDate.getText().equals(joinDate) && dpDoB.getText().equals(doB) && tPassword.getText().equals(password) && taPresentAddress.getText().equals(presentAddress) && tPhoneNo.getText().equals(phoneNo)  && newgender.equals(gender)))
		{
			btnUpdate.setDisable(false);
		}
	}
}

