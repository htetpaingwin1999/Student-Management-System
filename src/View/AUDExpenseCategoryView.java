package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.ExpenseCategoryHandler;
import Handler.Validation;
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

public class AUDExpenseCategoryView {
	private static VBox vbAddExpenseCategoryView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lExpenseCategoryID;
	public static TextField tExpenseCategoryID;
	private static Label lExpenseCategoryIDError;
	private static VBox vbExpenseCategoryIDError;//a to a shay ma nyi lox
	private static Label lExpenseCategoryName;
	public static TextField tExpenseCategoryName;
	private static Label lExpenseCategoryNameError;
	private static VBox vbExpenseCategoryNameError;
	public static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static Button btnUpdate;
	private static Button btnDelete;
	public static HBox hbBtnCon;
	public static VBox vbAddExpenseCategoryView(int id,String name,int action)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = ExpenseCategoryListsView.vbExpenseCategoryListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Expense Category Listss");
		});
		
		vbAddExpenseCategoryView = new VBox();
				
		lTitle = new Label("Add New ExpenseCategory");
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
		hbBtnCon.setSpacing(10);

		lExpenseCategoryID = new Label("ExpenseCategory ID");
		Style.LabelFillColorAndSize(lExpenseCategoryID, "grey", 15);

		tExpenseCategoryID = new TextField();
		tExpenseCategoryID.setEditable(false);
		Style.TextFieldFill(tExpenseCategoryID, 470, "");
		
		lExpenseCategoryIDError = new Label("");
		Style.LabelFillColorAndSize(lExpenseCategoryIDError, "red", 15);

		vbExpenseCategoryIDError = new VBox();
		vbExpenseCategoryIDError.getChildren().addAll(tExpenseCategoryID,lExpenseCategoryIDError);
		vbExpenseCategoryIDError.setSpacing(3);
	
		if(action==1)
		{
			tExpenseCategoryID.setText(ExpenseCategoryHandler.GetNewID()+"");
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
		}
		if(action == 2)
		{
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			lTitle.setText("Update ExpenseCategory");
			tExpenseCategoryID.setText(id+"");
		}
		
		lExpenseCategoryName = new Label("ExpenseCategory Name");
		Style.LabelFillColorAndSize(lExpenseCategoryName, "white", 15);
		
		tExpenseCategoryName = new TextField();
		Style.TextFieldFill(tExpenseCategoryName, 470, name);

		lExpenseCategoryNameError = new Label("Use only alhpabets and maximum 50 characters");
		Style.LabelFillColorAndSize(lExpenseCategoryNameError, "red", 15);
		
		vbExpenseCategoryNameError = new VBox();
		vbExpenseCategoryNameError.getChildren().addAll(tExpenseCategoryName,lExpenseCategoryNameError);
		vbExpenseCategoryNameError.setSpacing(3);
		
		tExpenseCategoryName.setOnMouseExited(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			
			if(!Validation.checkName(tExpenseCategoryName.getText()) || tExpenseCategoryName.getText().length()>50)
			{
				lExpenseCategoryNameError.setVisible(true);
			}
			else
			{
				lExpenseCategoryNameError.setVisible(false);
				btnSave.setDisable(false);

				if(!tExpenseCategoryName.getText().equals(name))
				{
					btnUpdate.setDisable(false);
				}
			}
			
		});
		
		gp = new GridPane();
		gp.add(lExpenseCategoryID, 0, 0);
		gp.add(lExpenseCategoryName, 1, 0);
		gp.add(vbExpenseCategoryIDError, 0, 1);
		gp.add(vbExpenseCategoryNameError, 1, 1);
		gp.add(hbBtnCon, 0, 2);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 10, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			
			if(al.getResult() == ButtonType.YES)
			{
				ExpenseCategoryHandler.AddNewExpenseCategory(tExpenseCategoryName.getText(),1+"");
				tExpenseCategoryID.setText(ExpenseCategoryHandler.GetNewID()+"");
				Alert alss  = new Alert(AlertType.INFORMATION,"Add Succesfully");
				alss.showAndWait();
				tExpenseCategoryName.setText("");
			}
			btnSave.setDisable(true);
					
		});
		
		btnUpdate.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			
			if(al.getResult() == ButtonType.YES)
			{
				Handler.ExpenseCategoryHandler.UpdateExpenseCategory(id, tExpenseCategoryName.getText(), 1+"");
				
				Alert alss  = new Alert(AlertType.INFORMATION,"Update Succesfully");
				alss.showAndWait();
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = ExpenseCategoryListsView.vbExpenseCategoryListsView();
				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Expense Category Lists");
			}
					
		});
		
		btnCancel.setOnAction(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			lExpenseCategoryName.setVisible(false);
			if(action == 1)
			{
				tExpenseCategoryName.setText(name);
				tExpenseCategoryID.setText(id+"");
			}
			else
			{
				tExpenseCategoryID.setText(ExpenseCategoryHandler.GetNewID()+"");
				tExpenseCategoryName.setText("");
			}
		});
		
		vbAddExpenseCategoryView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddExpenseCategoryView, "#f2f2f2", 10, 10, 5);
		return vbAddExpenseCategoryView;
		}
}

