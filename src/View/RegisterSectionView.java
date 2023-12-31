package View;

import Handler.StudentHandler;
import Handler.Validation;
import List.DesignationLists;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class RegisterSectionView extends Application {
	private static VBox vbRegisterStudentView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lStudentID;
	public static Label  llStudentID;
	private static Label lCourseName;
	private static Label llCourseName;
	private static Label lCourseFee;
	private static Label llCourseFee;
	private static Label lStudentName;
	public static Label  llStudentName;
	private static Label lAmount;
	private static TextField tAmount;
	private static Label lAmountError;
	private static VBox vbAmountError;
	private static TextField tSearch;
	private static Button btnSearch;
	private static HBox hbSearchCon;
	private static Button btnSave;
	private static Button btnCancel;
	public static HBox hbBtnCon;
	private static GridPane gp;
	private static Stage myStage;
	private static Scene sc;
	private static Label lIsJoin;
	private static boolean canJoin = false;
	private static boolean isOld = false;
	private static boolean isValid;
	public static void main(String args[])
	{
		Application.launch(args);
	}
	public static void ShowRegisterView(String courseName,int courseFee,int sectionID,int cid,String cfid)
	{
		
		myStage = new Stage();
		
		vbRegisterStudentView = new VBox();	
		
		tSearch = new TextField("");
		tSearch.setPromptText("Type Student ID");
		
		btnSearch = new Button("Search");
		Style.ButtonUpdate(btnSearch);
		
		hbSearchCon = new HBox();
		hbSearchCon.getChildren().addAll(tSearch,btnSearch);
		hbSearchCon.setSpacing(20);
		
		gp = new GridPane();
		
		btnSave = new Button("Save");
		btnSave.setDisable(true);
		Style.ButtonSave(btnSave);
		
		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		lStudentID = new Label("Student ID:");
		Style.LabelFillColorAndSize(lStudentID, "grey", 15);

		llStudentID = new Label("");
		Style.LabelFillColorAndSize(llStudentID, "grey", 15);

		lStudentName = new Label("Student Name:");
		Style.LabelFillColorAndSize(lStudentName, "grey", 15);

		llStudentName = new Label("");
		Style.LabelFillColorAndSize(llStudentName, "grey", 15);

		lCourseName = new Label("Course Name");
		Style.LabelFillColorAndSize(lCourseName, "grey", 15);

		llCourseName = new Label("");
		Style.LabelFillColorAndSize(llCourseName, "grey", 15);

		lCourseFee = new Label("Course Fee");
		Style.LabelFillColorAndSize(lCourseFee, "grey", 15);

		llCourseFee = new Label("");
		llCourseFee.setText(courseFee+"");
		Style.LabelFillColorAndSize(llCourseFee, "grey", 15);
		
		lAmount = new Label("Amount");
		Style.LabelFillColorAndSize(lAmount, "grey", 15);

		tAmount = new TextField();
		tAmount.setEditable(false);
		
		lAmountError = new Label("");
		Style.LabelFillColorAndSize(lAmountError, "red", 15);

		vbAmountError = new VBox();
		vbAmountError.getChildren().addAll(tAmount,lAmountError);
		vbAmountError.setSpacing(5);
		
//		lDiscount = new Label("Discount");
//		
//		tDiscount = new TextField();
//
//		lDiscountError = new Label("");
//		lDiscountError.setFont(Font.font("Times New Roman",15));
//		lDiscountError.setTextFill(Color.GREY);
//		
//		vbDiscountError = new VBox();
//		vbDiscountError.getChildren().add(tDiscount);
//		vbDiscountError.setSpacing(5);
//		
//		chDiscount = new CheckBox("Discount");
//		chDiscount.setSelected(false);
//		
//		chPayLater = new CheckBox("Pay Later");
//		chPayLater.setSelected(false);		
		
		hbBtnCon = new HBox();
		hbBtnCon.getChildren().addAll(btnSave,btnCancel);
		hbBtnCon.setSpacing(20);
		
		lIsJoin = new Label("");
		lIsJoin.setFont(Font.font("Times New Roman",15));
		
		tAmount.setOnKeyTyped(e->{
			btnSave.setDisable(true);
				if(!Validation.checkMoney(tAmount.getText()))
				{
					lAmountError.setText("Paid Fee must be number");
					lAmountError.setVisible(true);
				}
				if(Validation.checkMoney(tAmount.getText()))
				{
					if(Integer.parseInt(tAmount.getText()) > Integer.parseInt(llCourseFee.getText()))
					{
						lAmountError.setText("Reduce the Price");
						lAmountError.setVisible(true);
					}
					if(Integer.parseInt(tAmount.getText()) <0)
					{
						lAmountError.setText("Type number above 0");
						lAmountError.setVisible(true);
					}
					if(Integer.parseInt(tAmount.getText()) <= Integer.parseInt(llCourseFee.getText()))
					{
						btnSave.setDisable(false);
						lAmountError.setVisible(false);
					}
				}
		});
		
		gp.add(lStudentID, 0, 0);
		gp.add(llStudentID, 1, 0);
		gp.add(lStudentName, 0, 1);
		gp.add(llStudentName, 1, 1);
		gp.add(lCourseName, 0, 2);
		gp.add(llCourseName, 1, 2);
		gp.add(lCourseFee, 0, 3);
		gp.add(llCourseFee, 1, 3);
		gp.add(lAmount, 0, 4);
		gp.add(vbAmountError, 0, 5);
//		gp.add(chDiscount, 0, 7);
//		gp.add(lDiscount, 0, 8);
//		gp.add(vbDiscountError, 0, 9);
		gp.add(hbBtnCon, 0, 6);
		gp.setHgap(20);
		gp.setVgap(20);
		
		btnSearch.setOnAction(e->{
			lAmountError.setVisible(false);
			btnSave.setDisable(true);
			llStudentName.setText(Handler.StudentHandler.GetStudentName(tSearch.getText()));
			if(!llStudentName.getText().equals("Unknown"))
			{
				lAmountError.setText("");
				tAmount.setText("");
				
				llStudentID.setText(tSearch.getText());
				if(Handler.StudentHandler.isExistedStudentToThisCourse(llStudentID.getText(), cid+"")) // Student has joined the course past
				{
					isOld = true;
					if(Handler.StudentHandler.isJoinSection(llStudentID.getText(), sectionID+"")) // Student has joined the same section already
					{
						lIsJoin.setText(llStudentName.getText()+"  cannot join the section again");
						lIsJoin.setTextFill(Color.RED);	
						tAmount.setEditable(false);
						canJoin = false;
						btnSave.setDisable(true);
					}
					else
					{
						lIsJoin.setText(llStudentName.getText()+" has already join this course agin.\nYou don't need to pay fee again for this section.Thank you for joining the section");
						tAmount.setEditable(false);
						lIsJoin.setTextFill(Color.GREEN);
						canJoin = true;
						btnSave.setDisable(false);
					}
				}
				else
				{
					lIsJoin.setText("Thank you for joining this course and section");
					lIsJoin.setTextFill(Color.GREEN);
					tAmount.setEditable(true);
					canJoin =true;
					isOld = false;
				}
			}
			else
			{
				lAmountError.setText("");
				tAmount.setText("");
				llStudentID.setText("Invalid ID");
				lIsJoin.setText("");
				canJoin = false; // invalid id cannot join
				isOld = true; //
				btnSave.setDisable(true);
				tAmount.setEditable(false);
			} 
		});
		

		btnSave.setOnAction(e->{
				Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to add",ButtonType.YES,ButtonType.NO);
				al.showAndWait();
				if(al.getResult() == ButtonType.YES)
				{
					if(!llStudentID.getText().equals(""))
					{
						 vbAmountError.getChildren().remove(lAmountError);
							if(canJoin == true) // student can join the section for old coure or new course
							{
								if(isOld == false)
								{
									Alert al2 = new Alert(AlertType.CONFIRMATION,"Are you sure to join",ButtonType.YES,ButtonType.NO);
									al2.showAndWait();
									if(al2.getResult() == ButtonType.YES)
									{
										Handler.StudentHandler.JoinSection(llStudentID.getText(), sectionID+"","1");
										Handler.StudentHandler.JoinCourseStudent(llStudentID.getText(), cfid+"");
										Handler.StudentHandler.AddNewPayment(tAmount.getText(),1);	
										myStage.close();
									}
								}
								else
								{
									Handler.StudentHandler.JoinSection(llStudentID.getText(), sectionID+"","1");
									myStage.close();
								}
							}
					}
				}
				
		});
		
		btnCancel.setOnAction(e->{
			 vbAmountError.getChildren().remove(lAmountError);
			 tAmount.setText("");
			 btnSave.setDisable(true);
		});
		
		vbRegisterStudentView.getChildren().addAll(hbSearchCon,gp,lIsJoin);
		Style.VBoxFillColorAndSizeAndPadding(vbRegisterStudentView, "white", 0, 0, 20);
		vbRegisterStudentView.setPadding(new Insets(10,10,10,50));
		
		myStage.setScene(new Scene(vbRegisterStudentView,700,500));
		myStage.initModality(Modality.WINDOW_MODAL);
		myStage.initOwner(Login.myStage);
		myStage.show();
		myStage.centerOnScreen();

	}
	public void start() throws Exception {
		
		
	}
	
}
