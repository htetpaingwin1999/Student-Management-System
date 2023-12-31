package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.StaffHandler;
import Handler.Validation;
import List.StaffLists;
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

public class AUDSalaryPaymentView {
	private static VBox vbAddSalaryView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lStaffEmail;
	public static Label llStaffEmail;
	private static Label lStaffName;
	public static Label llStaffName;
	private static Label lSalary;
	private static Label llSalary;
	private static Label lAmount;
	private static TextField tAmount;
	private static VBox vbAmount;
	private static Label lAmountError;
	private static Label lNote;
	private static TextArea taNote;
	private static Label lNoteError;
	private static VBox vbNoteError;
	public static GridPane gp;
	private static Button btnSave,btnCancel,btnUpdate;
	private static HBox hbBtnCon;
	public static VBox AddSalaryView(String id,String email,String name,String salary,String amount,int action,int meid,String note,int from)
	{
		//from 1 means exp list //from 2 means salary lists
		
		if(from == 1)
		{
			MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = ExpenseListsView.vbExpenseListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1,"Expense Lists");		
			});
		}
		else
		{
			MainView.lIndex1.setOnMouseClicked(e->{
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = SalaryListsOrPaymentListsView.vbSalaryPaymentListsView(1);
				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Salary Lists");
				});	
		}
		
		
		
		btnSave = new Button("Save");
		Style.ButtonSave(btnSave);
		
		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		btnUpdate = new Button("Update");
		Style.ButtonUpdate(btnUpdate);
		
		Style.BtnDisable(btnSave, btnUpdate);
		
		hbBtnCon = new HBox();
		lTitle = new Label(name+" Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 10, 15, 0,1080,50);
		
		hbTitleCon.getChildren().add(lTitle);
		
		lStaffEmail = new Label("Staff Email:");
		Style.LabelFillColorAndSize(lStaffEmail, "grey", 15);

		llStaffEmail = new Label();
		Style.LabelFillColorAndSize(llStaffEmail, "black", 15);
		llStaffEmail.setText(email);
		
		lStaffName = new Label("Staff Name:");
		Style.LabelFillColorAndSize(lStaffName, "grey", 15);
		
		llStaffName = new Label();
		Style.LabelFillColorAndSize(llStaffName, "black", 15);
		llStaffName.setText(name);
		
		lSalary = new Label("Salary:");
		Style.LabelFillColorAndSize(lSalary, "grey", 15);

		llSalary = new Label();
		Style.LabelFillColorAndSize(llSalary, "black", 15);
		llSalary.setText(salary);
		
		lAmount = new Label("Amount:");
		Style.LabelFillColorAndSize(lAmount, "grey", 15);

		lAmountError = new Label("Type number greater than 1000");
		Style.LabelFillColorAndSize(lAmountError, "red", 15);
		
		tAmount = new TextField();
		tAmount.setText(amount);
		
		vbAmount = new VBox();
		vbAmount.getChildren().addAll(tAmount,lAmountError);
		
		lNote = new Label("Note:");
		Style.LabelFillColorAndSize(lNote, "grey", 15);

		taNote = new TextArea();
		taNote.setText(note);
		
		lNoteError = new Label("");
		Style.LabelFillColorAndSize(lNoteError, "red", 15);
		lNoteError.setText("You can type only 100 character at a time");

		vbNoteError = new VBox();
		vbNoteError.getChildren().addAll(taNote,lNoteError);
		vbNoteError.setSpacing(3);
		
		tAmount.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Handler.Validation.checkMoney(tAmount.getText()))
			{
				lAmountError.setVisible(true);
			}
			else
			{
				lAmountError.setVisible(false);
				if(Validation.checkMoney(tAmount.getText()))
				{
					btnSave.setDisable(false);
					if(!(tAmount.getText().equals(amount) && taNote.getText().equals(note)))
					{
						btnUpdate.setDisable(false);
					}
				}
			}
		});
		
		taNote.setOnKeyReleased(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(taNote.getText().length() < 100)
			{
				if(Handler.Validation.checkMoney(tAmount.getText()))
				{
					
						btnSave.setDisable(false);
						if(!(tAmount.getText().equals(amount) && taNote.getText().equals(note)))
						{
							btnUpdate.setDisable(false);
						}
					}
			}
			
			else {
				lNoteError.setVisible(true);	
			}
					
		});
		
		if(action == 1)
		{
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
		}
		else
		{
			StaffLists st = Handler.StaffHandler.GetStaffEmailNameSalary(meid);
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			llStaffEmail.setText(st.getEmail());
			llStaffName.setText(st.getStaffName());
			llSalary.setText(st.getSalary()+" ks");
			lTitle.setText(st.getStaffName()+" Salary");
		}
		
		hbBtnCon.setSpacing(5);
		
		gp = new GridPane();
		gp.add(lStaffEmail, 0, 0);
		gp.add(llStaffEmail, 1, 0);
		gp.add(lStaffName, 0, 1);
		gp.add(llStaffName, 1, 1);
		gp.add(lSalary, 0, 2);
		gp.add(llSalary, 1, 2);
		gp.add(lAmount, 0, 3);
		gp.add(vbAmount, 1 ,3);
		gp.add(lNote, 0, 4);
		gp.add(vbNoteError, 1, 4);
		gp.add(hbBtnCon, 1, 5);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 20, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to paid",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			
			if(al.getResult() == ButtonType.YES)
			{
				Handler.SalaryHandler.AddNewSalary(id, tAmount.getText(), taNote.getText(),llSalary.getText());
				Alert al1 = new Alert(AlertType.INFORMATION,"Paid Successfully");
				al1.showAndWait();
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
  				MainView.vbWorkSpace = SalaryListsOrPaymentListsView.vbSalaryPaymentListsView(1);
  				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
  				MainView.RemoveIndex();
  				MainView.UpdateIndex(MainView.lIndex1, "Salary Lists");
			}	
		});
		
		btnUpdate.setOnAction(e->{
			
			Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO);
			al.showAndWait();
			if(al.getResult() == ButtonType.YES)
			{
				
				Handler.SalaryHandler.UpdateSalary(Login.userid, tAmount.getText(), taNote.getText(), meid);
				Alert al1 = new Alert(AlertType.INFORMATION,"Upate Successfully");
				al1.showAndWait();
				
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
  				MainView.vbWorkSpace = SalaryListsOrPaymentListsView.vbSalaryPaymentListsView(1);
  				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
  				MainView.RemoveIndex();
  				MainView.UpdateIndex(MainView.lIndex1, "Salary Lists");
			}
		});
		
		btnCancel.setOnAction(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			lAmountError.setVisible(false);
			tAmount.setText(amount);
			taNote.setText(note);
		});
		
		vbAddSalaryView = new VBox();
		vbAddSalaryView.getChildren().addAll(hbTitleCon,gp);
		vbAddSalaryView.setPrefHeight(700);
		Style.VBoxFillColorAndSizeAndPadding(vbAddSalaryView, "white", 10, 20, 5);
		return vbAddSalaryView;
		}
}

