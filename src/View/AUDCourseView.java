package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.CourseHandler;
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

public class AUDCourseView {
	private static VBox vbAddCourseView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lCourseID;
	public static TextField tCourseID;
	private static Label lCourseIDError;
	private static VBox vbCourseIDError;//a to a shay ma nyi lox
	private static Label lCourseName;
	public static TextField tCourseName;
	private static Label lCourseNameError;
	private static VBox vbCourseNameError;
	private static Label lCourseFee;
	public static TextField tCourseFee;
	private static Label lCourseFeeError;
	private static VBox vbCourseFeeError;
	public static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static Button btnUpdate;
	private static Button btnDelete;
	public static HBox hbBtnCon;
	public static VBox vbAddCourseView(int id,String name,String fee,int action)
	{
		
		if(action == 2)
		{
			
			MainView.lIndex1.setOnMouseClicked(e->{
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Course Lists");
	            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = CourseListsView.vbCourseListsView(Login.userid,Login.userpos);
	            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			});	
		}
		
		vbAddCourseView = new VBox();
				
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
		
		btnSave.setDisable(true);
		btnUpdate.setDisable(true);
		
		hbBtnCon = new HBox();
		
		
		lCourseID = new Label("Course ID");
		Style.LabelFillColorAndSize(lCourseID, "grey", 15);
		
		tCourseID = new TextField();
		Style.TextFieldFill(tCourseID, 470, "");
		tCourseID.setEditable(false);
		
		lCourseIDError = new Label("");
		Style.LabelFillColorAndSize(lCourseIDError, "red", 15);
		
		vbCourseIDError = new VBox();
		vbCourseIDError.getChildren().addAll(tCourseID,lCourseIDError);
		vbCourseIDError.setSpacing(3);
		
		if(action==1)
		{
			hbBtnCon.getChildren().addAll(btnSave,btnCancel);
			tCourseID.setText(CourseHandler.GetNewID()+"");
			hbBtnCon.setSpacing(10);
			lTitle.setText("Add New Course");
		}
		if(action == 2)
		{
			hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
			hbBtnCon.setSpacing(10);
			lTitle.setText("Update Course");
			tCourseID.setText(id+"");
		}
		
		lCourseName = new Label("Course Name");
		Style.LabelFillColorAndSize(lCourseName, "grey", 15);

		tCourseName = new TextField();
		Style.TextFieldFill(tCourseName, 470, name);
		
		lCourseNameError = new Label("Use only alphabets and maximum 50 characters");
		Style.LabelFillColorAndSize(lCourseNameError, "red", 15);

		vbCourseNameError = new VBox();
		vbCourseNameError.getChildren().addAll(tCourseName,lCourseNameError);
		vbCourseNameError.setSpacing(3);
	
		lCourseFee = new Label("Course Fee");
		Style.LabelFillColorAndSize(lCourseFee, "grey", 15);
		
		tCourseFee = new TextField();
		Style.TextFieldFill(tCourseFee, 470, fee);
		
		lCourseFeeError = new Label("Type number between 1000 and 1000000");
		Style.LabelFillColorAndSize(lCourseFeeError, "red", 15);
		
		vbCourseFeeError = new VBox();
		vbCourseFeeError.getChildren().addAll(tCourseFee,lCourseFeeError);
		vbCourseFeeError.setSpacing(3);
		
		tCourseName.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkCourseName(tCourseName.getText()))
			{
				
				lCourseNameError.setVisible(true);
			}
			else
			{
				lCourseNameError.setVisible(false);
				if(Validation.checkMoney(tCourseFee.getText()) && !tCourseName.getText().equals(name)&&  tCourseName.getText().length()<50)
				{
					btnSave.setDisable(false);
					if(!(tCourseFee.getText().equals(fee) && tCourseName.getText().equals(name)))
					{
						btnUpdate.setDisable(false);
					}
				}
				if(tCourseName.getText().length()>50)
				{
					lCourseNameError.setVisible(true);
				}
			}
		});
		
		tCourseFee.setOnKeyTyped(e->{
			Style.BtnDisable(btnSave, btnUpdate);
			if(!Validation.checkMoney(tCourseFee.getText()))
			{
				lCourseFeeError.setVisible(true);
				Style.BtnDisable(btnSave, btnUpdate);
			}
			else
			{
				lCourseFeeError.setVisible(false);
				if(Validation.checkCourseName(tCourseName.getText()) && !tCourseFee.getText().equals(fee))
				{
					btnSave.setDisable(false);
					if(!(tCourseFee.getText().equals(fee) && tCourseName.getText().equals(name)))
					{
						btnUpdate.setDisable(false);
					}				
				}
			}
		});
		
		gp = new GridPane();
		gp.add(lCourseID, 0, 0);
		gp.add(lCourseName, 1, 0);
		gp.add(vbCourseIDError, 0, 1);
		gp.add(vbCourseNameError, 1, 1);
		gp.add(lCourseFee, 0, 2);
		gp.add(vbCourseFeeError, 0, 3);
		gp.add(hbBtnCon, 0, 4);
		Style.GpFillColorAndSizeAndPadding(gp, 10, 10, 20, 10, "white");
		
		btnSave.setOnAction(e->{
			Alert al = new Alert(AlertType.INFORMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
			al.showAndWait();
			
			if(al.getResult() == ButtonType.YES)
			{
				CourseHandler.AddNewCourse(Integer.parseInt(tCourseID.getText()),tCourseName.getText(),Integer.parseInt(tCourseFee.getText()),Login.userid);		
				btnSave.setDisable(true);
				tCourseID.setText(CourseHandler.GetNewID()+"");
				tCourseName.setText("");
				tCourseFee.setText("");	
				Alert alsuccess = new Alert(AlertType.INFORMATION,"Add course succesfully");
				alsuccess.showAndWait();
			}		
		});
		
		btnUpdate.setOnAction(e->{
			String oldname = name;
			String oldfee = fee;
			Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to update",ButtonType.YES,ButtonType.NO);
			al.showAndWait();
			if(al.getResult() == ButtonType.YES)
			{
				if(!(tCourseName.getText().equals(oldname) && tCourseFee.getText().equals(oldfee)) || tCourseName.getText().equals(oldname) && !tCourseFee.getText().equals(oldfee))
				{

					if(!tCourseName.getText().equals(oldname) && tCourseFee.getText().equals(oldfee))
					{
						Handler.CourseHandler.UpdateCourseName(id, tCourseName.getText());
					
					}
					if(tCourseName.getText().equals(oldname) && !tCourseFee.getText().equals(oldfee))
					{
						Handler.CourseHandler.UpdateCourseFee(id+"", tCourseFee.getText());
					}
					
					Alert alsuccess = new Alert(AlertType.INFORMATION,"Update course succesfully");
					alsuccess.showAndWait();
					
					MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
					MainView.vbWorkSpace = CourseListsView.vbCourseListsView(Login.userid,Login.userpos);
					MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
					MainView.RemoveIndex();
					MainView.UpdateIndex(MainView.lIndex1, "Course Lists");
				}
			}
	
			
		});
		
		
		btnCancel.setOnAction(e->{
			btnSave.setDisable(true);
			btnUpdate.setDisable(true);
			lCourseFeeError.setVisible(false);
			lCourseNameError.setVisible(false);
			if(action == 1)
			{
				tCourseID.setText(CourseHandler.GetNewID()+"");
				tCourseID.setText(CourseHandler.GetNewID()+"");
				tCourseName.setText("");
				tCourseFee.setText("");	
				btnSave.setDisable(true);
			}
			else
			{
				tCourseID.setText(id+"");
				tCourseName.setText(name);
			}
			
		});
		vbAddCourseView.getChildren().addAll(hbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbAddCourseView, "#f2f2f2", 10, 0, 5);
		return vbAddCourseView;
		}
}

