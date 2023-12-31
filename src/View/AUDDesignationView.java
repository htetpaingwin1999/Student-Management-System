package View;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Date;

import Handler.DesignationHandler;
import Handler.Validation;
import List.DepartmentLists;
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

public class AUDDesignationView {
	private static VBox vbAddDesignationView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lDesignationID;
	public static TextField tDesignationID;
	private static Label lDesignationIDError;
	private static VBox vbDesignationIDError;//a to a shay ma nyi lox
	private static Label lDesignationName;
	public static TextField tDesignationName;
	private static Label lDesignationNameError;
	private static VBox vbDesignationNameError;
	private static Label lMaxSalary;
	public static TextField tMaxSalary;
	private static Label lMaxSalaryError;
	private static VBox vbMaxSalaryError;
	private static Label lMinSalary;
	public static TextField tMinSalary;
	private static Label lMinSalaryError;
	private static VBox vbMinSalaryError;
	public static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static Button btnUpdate;
	private static Button btnDelete;
	private static Label llDepartmentName;
	public static HBox hbBtnCon;
	public static VBox vbAddDesignationView(int designationID,String designationName,int maxSalary,int minSalary,int action)
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = DesignationListsView.vbDesignationListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.ChangeToUnactiveLink();
			MainView.UpdateIndex(MainView.lIndex1, "Designation Lists");
		});
		
		
		vbAddDesignationView = new VBox();
				
		lTitle = new Label("Add New Designation");
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

		lDesignationID = new Label("Designation ID");
		Style.LabelFillColorAndSize(lDesignationID, "grey", 15);
		
		tDesignationID = new TextField();
		tDesignationID.setEditable(false);
		Style.TextFieldFill(tDesignationID, 470, "");
		
		lDesignationIDError = new Label("");
		Style.LabelFillColorAndSize(lDesignationIDError, "red", 15);
		
		vbDesignationIDError = new VBox();
		vbDesignationIDError.getChildren().addAll(tDesignationID,lDesignationIDError);
		vbDesignationIDError.setSpacing(3);
		
		if(action == 1)
		{
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
			tDesignationID.setText(DesignationHandler.GetNewID()+"");
			lTitle.setText("Add New Designation");
		}
		if(action == 2)
		{
			tDesignationID.setText(designationID+"");
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			lTitle.setText("Update Designation");
		}
		lDesignationName = new Label("Designation Name");
		Style.LabelFillColorAndSize(lDesignationName, "grey", 15);

		tDesignationName = new TextField();
		Style.TextFieldFill(tDesignationName, 470, designationName);

		lDesignationNameError = new Label("Use only alhpabets and maximum 50 characters");
		Style.LabelFillColorAndSize(lDesignationNameError, "red", 15);
		
		vbDesignationNameError = new VBox();
		vbDesignationNameError.getChildren().addAll(tDesignationName,lDesignationNameError);
		vbDesignationNameError.setSpacing(3);
		
		lMaxSalary = new Label("Maximum Salary");
		Style.LabelFillColorAndSize(lMaxSalary, "grey", 15);
		
		tMaxSalary = new TextField();
		Style.TextFieldFill(tMaxSalary, 470, maxSalary+"");
		
		lMaxSalaryError = new Label("");
		Style.LabelFillColorAndSize(lMaxSalaryError, "red", 15);

		vbMaxSalaryError = new VBox();
		vbMaxSalaryError.getChildren().addAll(tMaxSalary,lMaxSalaryError);
		vbMaxSalaryError.setSpacing(3);
		
		lMinSalary = new Label("Minimum Salary");
		Style.LabelFillColorAndSize(lMinSalary, "grey", 15);

		tMinSalary = new TextField();
		Style.TextFieldFill(tMinSalary, 470, minSalary+"");
		
		lMinSalaryError = new Label("");
		Style.LabelFillColorAndSize(lMinSalaryError, "red", 15);

		vbMinSalaryError = new VBox();
		vbMinSalaryError.getChildren().addAll(tMinSalary,lMinSalaryError);
		vbMinSalaryError.setSpacing(3);
		
		tDesignationName.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkName(tDesignationName.getText()))
			{
				lDesignationNameError.setVisible(true);
			}
			else
			{
				if(tDesignationName.getText().length()<50)
				{
					if(Validation.checkMoney(tMaxSalary.getText()) && Validation.checkMoney(tMinSalary.getText()))
					{
						if(Integer.parseInt(tMaxSalary.getText()) > Integer.parseInt(tMinSalary.getText()))
						{
							lMinSalaryError.setVisible(false);
							lMaxSalaryError.setVisible(false);
							btnSave.setDisable(false);

							if(!(tMaxSalary.getText().equals(maxSalary+"") && tMinSalary.getText().equals(minSalary+"") && tDesignationName.getText().equals(designationName)))
							{ //nothing is up to date
								btnUpdate.setDisable(false);
							}
						}
						else
						{
							lMaxSalaryError.setText("Max salary must be greater than minimum salary");
							lMaxSalaryError.setVisible(true);
							lMinSalaryError.setText("Min salary must be less than maximum salary");
							lMinSalaryError.setVisible(true);
						}
						
					}	
					lDesignationNameError.setVisible(false);
				}
				else {
					lDesignationNameError.setVisible(true);
				}
				
			}
		});
		
		tMaxSalary.setOnKeyTyped(e->{
			btnSave.setDisable(true);
			btnUpdate.setDisable(true);
			if(!Validation.checkMoney(tMaxSalary.getText()) )
			{
				lMaxSalaryError.setText("Type Number");
				lMaxSalaryError.setVisible(true);
			}
			else
			{
				lMaxSalaryError.setVisible(false);
				if(Validation.checkName(tDesignationName.getText()) && Validation.checkMoney(tMinSalary.getText()))
				{
					
					if(Integer.parseInt(tMaxSalary.getText()) > Integer.parseInt(tMinSalary.getText()))
					{		
						lMaxSalaryError.setVisible(false);
						lMinSalaryError.setVisible(false);

						btnSave.setDisable(false);

						if(!(tMaxSalary.getText().equals(maxSalary+"") && tMinSalary.getText().equals(minSalary+"") && tDesignationName.getText().equals(designationName)))
						{ //nothing is up to date
							btnUpdate.setDisable(false);
						}
					}
					else
					{
						lMaxSalaryError.setText("Max salary must be greater than minimum salary");
						lMaxSalaryError.setVisible(true);
						lMinSalaryError.setText("Min salary must be less than maximum salary");
						lMinSalaryError.setVisible(true);
					}
					
				}
			}
		});
		
		tMinSalary.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkMoney(tMinSalary.getText()))
			{
				lMinSalaryError.setText("Type Number");
				lMinSalaryError.setVisible(true);
			}
			else
			{
				lMinSalaryError.setVisible(false);
				if(Validation.checkName(tDesignationName.getText()) && Validation.checkMoney(tMaxSalary.getText()))
				{
					if(Integer.parseInt(tMaxSalary.getText()) > Integer.parseInt(tMinSalary.getText()))
					{
						btnSave.setDisable(false);
						lMaxSalaryError.setVisible(false);
						lMinSalaryError.setVisible(false);
						if(!(tMaxSalary.getText().equals(maxSalary+"") && tMinSalary.getText().equals(minSalary+"") && tDesignationName.getText().equals(designationName)))
						{ //nothing is up to date
							btnUpdate.setDisable(false);
						}
					}
					else
					{
						lMinSalaryError.setVisible(true);
						lMaxSalaryError.setVisible(false);
						lMaxSalaryError.setText("Max salary must be greater than minimum salary");
						lMinSalaryError.setText("Min salary must be less than maximum salary");
					}
					
				}
			}
		});
		gp = new GridPane();
		gp.add(lDesignationID, 0, 0);
		gp.add(lDesignationName, 1, 0);
		gp.add(vbDesignationIDError, 0, 1);
		gp.add(vbDesignationNameError, 1, 1);
		gp.add(lMaxSalary, 0, 2);
		gp.add(lMinSalary, 1, 2);
		gp.add(vbMaxSalaryError, 0, 3);
		gp.add(vbMinSalaryError, 1, 3);
		gp.add(hbBtnCon, 0, 4);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 10, 20, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			btnSave.setDisable(true);
			if(al.getResult() == ButtonType.YES)
			{
					DesignationHandler.AddNewDesignation(tDesignationID.getText(),tDesignationName.getText(),tMaxSalary.getText(),tMinSalary.getText());
					Alert alsuccess = new Alert(AlertType.INFORMATION,"Added successfully");
					alsuccess.showAndWait();
					tDesignationID.setText(DesignationHandler.GetNewID()+"");
					tDesignationName.setText("");
					tMaxSalary.setText(maxSalary+"");
					tMinSalary.setText(minSalary+"");			
			}
			
		});
		
		btnUpdate.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			btnUpdate.setDisable(true);
			if(al.getResult() == ButtonType.YES)
			{
			    		
					if(!tDesignationName.getText().equals(designationName))
					{
						System.out.println("changing designation name");
		    			Handler.DesignationHandler.UpdateDesignationName(designationID+"", tDesignationName.getText());
					}
		
		    		if(!tMaxSalary.getText().equals(maxSalary+"") || !tMinSalary.getText().equals(minSalary+""))
		    		{
						System.out.println("changing designation salary");
		    			Handler.DesignationHandler.UpdateDesignationSalary(designationID+"", tMaxSalary.getText(), tMinSalary.getText());
		    		}
		    		Alert alsuccess = new Alert(AlertType.INFORMATION,"updated successfully");
					alsuccess.showAndWait();
		    		
					MainView.RemoveIndex();
					MainView.UpdateIndex(MainView.lIndex1, "Designation Lists");
	    			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
      				MainView.vbWorkSpace = DesignationListsView.vbDesignationListsView();
      				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);	          							
			}	    
		});
		
		btnCancel.setOnAction(e->{
			if(action == 1)
			{
				tDesignationID.setText(DesignationHandler.GetNewID()+"");
			}
			else
			{
				tDesignationID.setText(designationID+"");
			}
			btnSave.setDisable(true);
			btnUpdate.setDisable(true);
			lDesignationNameError.setVisible(false);
			lMaxSalaryError.setVisible(false);
			lMinSalaryError.setVisible(false);
			tDesignationName.setText(designationName);
			tMaxSalary.setText(maxSalary+"");
			tMinSalary.setText(minSalary+"");
			
		});
		
		vbAddDesignationView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddDesignationView, "#f2f2f2", 10, 0, 5);
		return vbAddDesignationView;
		}
}

