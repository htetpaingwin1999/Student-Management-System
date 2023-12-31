package View;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Date;

import Handler.ExpenseCategoryHandler;
import Handler.ExpenseHandler;
import Handler.Validation;
import List.ExpenseCategoryLists;
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

public class AUDExpenseView {
	private static VBox vbAddExpenseView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lExpenseID;
	public static TextField tExpenseID;
	private static Label lExpenseIDError;
	private static VBox vbExpenseIDError;//a to a shay ma nyi lox
	private static Label lexpenseCategoryName;
	private static ComboBox cbexpenseCategoryName;
	private static Label lexpenseCategoryNameError;
	private static VBox vbexpenseCategoryNameError;
	private static Label lAmount;
	public static TextField tAmount;
	private static Label lAmountError;
	private static VBox vbAmountError;
	private static Label lNote;
	public static TextArea taNote;
	private static Label lNoteError;
	private static VBox vbNoteError;
	public static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static Button btnUpdate;
	private static Button btnDelete;
	public static HBox hbBtnCon;
	private static String changedName;
	public static VBox vbAddExpenseView(int expenseID,String note,String amount,int expenseCategoryID,String expenseCategoryName,int adminID,String adminName,int action)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = ExpenseListsView.vbExpenseListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Expense Lists");
		});
		
		
		vbAddExpenseView = new VBox();
		ArrayList<ExpenseCategoryLists> ecLists = Handler.ExpenseCategoryHandler.GetAllExpenseCategory();
				
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
		
		changedName = expenseCategoryName;
		
		hbBtnCon = new HBox();
		hbBtnCon.setSpacing(10);

		if(action==1)
		{
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
			lTitle.setText("Add New Expense");
		}
		if(action == 2)
		{
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			lTitle.setText("Update Expense");
		}
		
		lExpenseID = new Label("Expense ID");
		Style.LabelFillColorAndSize(lExpenseID, "grey", 15);

		tExpenseID = new TextField();
		tExpenseID.setEditable(false);
		Style.TextFieldFill(tExpenseID, 470, "");
		
		lExpenseIDError = new Label("");
		Style.LabelFillColorAndSize(lExpenseIDError, "red", 15);

		vbExpenseIDError = new VBox();
		vbExpenseIDError.getChildren().addAll(tExpenseID);
		vbExpenseIDError.setSpacing(3);
		
		if(action == 1)
		{
			tExpenseID.setText((ExpenseHandler.GetNewMainExpenseID()+1)+"");
		}
		else
		{
			tExpenseID.setText(expenseID+"");
		}
		
		
		lexpenseCategoryName = new Label("Expense Category Name");
		Style.LabelFillColorAndSize(lexpenseCategoryName, "grey", 15);
		
		cbexpenseCategoryName = new ComboBox();
		cbexpenseCategoryName.setPrefWidth(470);
		
		lexpenseCategoryNameError = new Label("No expenseCategory provided");
		Style.LabelFillColorAndSize(lexpenseCategoryNameError, "red", 15);

		vbexpenseCategoryNameError = new VBox();
		vbexpenseCategoryNameError.getChildren().addAll(cbexpenseCategoryName);
		vbexpenseCategoryNameError.setSpacing(3);
		
		boolean isFound = false;
		if(action == 1)
		{
			if(ecLists.size() >0)
			{
				for(ExpenseCategoryLists d:ecLists)
				{
					cbexpenseCategoryName.getItems().add(d.getExpenseCategoryName());	
				}
				cbexpenseCategoryName.getSelectionModel().select(0);
			}
			else
			{
				btnSave.setDisable(true);
				vbexpenseCategoryNameError.getChildren().remove(lexpenseCategoryNameError);
				vbexpenseCategoryNameError.getChildren().add(lexpenseCategoryNameError);
			}
		}
		else
		{
			
			for(ExpenseCategoryLists d:ecLists)
			{
				cbexpenseCategoryName.getItems().add(d.getExpenseCategoryName());	
				if(expenseCategoryName ==d.getExpenseCategoryName())
				{
					isFound = true;
					cbexpenseCategoryName.getSelectionModel().select(expenseCategoryName);
				}
			}
			if(isFound == false)
			{
				cbexpenseCategoryName.getItems().add(expenseCategoryName);
				cbexpenseCategoryName.getSelectionModel().select(expenseCategoryName);
			}
		}
		
		cbexpenseCategoryName.setOnMouseClicked(e->{
			if(ecLists.size() >0)
			{
				changedName =cbexpenseCategoryName.getValue().toString();
			}
		});
		
		lAmount = new Label("Amount");
		Style.LabelFillColorAndSize(lAmount, "grey", 15);
		
		tAmount = new TextField();
		tAmount.setPrefWidth(470);
		tAmount.setText(amount+"");
		
		lAmountError = new Label("Type number");
		Style.LabelFillColorAndSize(lAmountError, "red", 15);
		
		vbAmountError = new VBox();
		vbAmountError.getChildren().addAll(tAmount,lAmountError);
		vbAmountError.setSpacing(3);
		
		lNote = new Label("Note");
		Style.LabelFillColorAndSize(lNote, "grey", 15);
		
		taNote = new TextArea();
		taNote.setPrefWidth(470);
		taNote.setText(note);
		
		lNoteError = new Label("");
		Style.LabelFillColorAndSize(lNoteError, "red", 15);
		lNoteError.setText("You can type only 100 character at a time");

		vbNoteError = new VBox();
		vbNoteError.getChildren().addAll(taNote,lNoteError);
		vbNoteError.setSpacing(3);
		
		tAmount.setOnKeyReleased(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkMoney(tAmount.getText()) && ecLists.size()>0)
			{
				lAmountError.setVisible(true);
			}
			else
			{
				lAmountError.setVisible(false);
				btnSave.setDisable(false);
				if(!(tAmount.getText().equals(amount) && taNote.getText().equals(note)))
				{
					btnUpdate.setDisable(false);
				}
			}
		});
		
		taNote.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(taNote.getLength() > 100 && ecLists.size()>0)
			{
				lNoteError.setVisible(true);	
			}
			else
			{
				lNoteError.setVisible(false);
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
		
		
		gp = new GridPane();
		gp.add(lExpenseID, 0, 0);
		gp.add(vbExpenseIDError, 0, 1);
		gp.add(lexpenseCategoryName, 0, 2);
		gp.add(vbexpenseCategoryNameError, 0, 3);
		gp.add(lAmount, 0, 4);
		gp.add(vbAmountError, 0, 5);
		gp.add(lNote, 0, 6);
		gp.add(vbNoteError, 0, 7);
		gp.add(hbBtnCon, 0, 8);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 20, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			if(al.getResult() == ButtonType.YES)
			{ 
	    		int ecid = Handler.ExpenseCategoryHandler.GetID(cbexpenseCategoryName.getValue().toString());
	    		ExpenseHandler.AddNewMainExpense(tAmount.getText(), taNote.getText(),ecid);
	    		Alert alsuccess = new Alert(AlertType.INFORMATION,"Add successfully");
	    		alsuccess.showAndWait();
	    		tExpenseID.setText(ExpenseHandler.GetNewMainExpenseID()+1+"");
				cbexpenseCategoryName.getSelectionModel().select(0);
				tAmount.setText("");
				taNote.setText("");				
			}		
		});
		
		
		btnUpdate.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			if(al.getResult() == ButtonType.YES)
			{
					
					changedName = cbexpenseCategoryName.getValue().toString();						
					
					if(changedName.equals(expenseCategoryName)) //old name so use old id
					{
						Handler.ExpenseHandler.UpdateExpense(expenseID, tAmount.getText(), expenseCategoryID, taNote.getText(),Integer.parseInt(Login.userid));	
					}
					else
					{
						Handler.ExpenseHandler.UpdateExpense(expenseID, tAmount.getText(), ExpenseCategoryHandler.GetID(changedName), taNote.getText(),Integer.parseInt(Login.userid));
					}
					
					Alert alsuccess = new Alert(AlertType.INFORMATION,"Update successfully");
					alsuccess.showAndWait();
					
					MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
					MainView.vbWorkSpace = ExpenseListsView.vbExpenseListsView();
					MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
					MainView.RemoveIndex();
					MainView.UpdateIndex(MainView.lIndex1, "Expense Lists");
				}
						
		});
		
		btnCancel.setOnAction(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			tAmount.setText(amount);
			taNote.setText(note);
		});
		
		vbAddExpenseView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddExpenseView, "#f2f2f2", 10, 0, 5);
		return vbAddExpenseView;
		}
}

