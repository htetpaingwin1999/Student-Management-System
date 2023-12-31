package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.CourseHandler;
import Handler.Validation;
import List.CourseLists;
import List.StudentPaymentLists;
import Table.CourseStudentTable;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.Scene;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddPaymentView {
	private static VBox vbRegisterStudentView;
	private static Label lAmount;
	private static TextField tAmount;
	private static Label lAmountError;
	private static VBox vbAmountError;
	private static HBox hbSearchCon;
	private static Button btnSave;
	private static Button btnCancel;
	public static HBox hbBtnCon;
	private static GridPane gp;	
	private static Label lRestAmount;
	public static Stage myStage;
	public static void main(String args[])
	{
		Application.launch(args);
	}
	
	public static void vbShowRegisterView(int csid,int fee)
	{
		myStage = new Stage();
		myStage.centerOnScreen();
		myStage.setResizable(false);
		myStage.setWidth(300);
		myStage.setHeight(300);
		
		int total = Handler.StudentPaymentHandler.StudentPaymentByID(csid);
		vbRegisterStudentView = new VBox();	
		
		lAmount = new Label("Amount");
		Style.LabelFillColorAndSize(lAmount, "grey", 15);
		
		tAmount = new TextField();
		tAmount.setText("");
		
		lRestAmount = new Label("Rest Amount "+(fee-total)+"Ks");
		Style.LabelFillColorAndSize(lRestAmount, "blue", 17);
		
		lAmountError = new Label("Type number");
		Style.LabelFillColorAndSize(lAmountError, "red", 17);
		
		vbAmountError = new VBox();
		vbAmountError.getChildren().addAll(tAmount,lAmountError);
		vbAmountError.setSpacing(5);
		
		btnSave = new Button("Save");
		Style.ButtonFillColorAndSize(btnSave, 15, 100, 30, 10, 10, "green");

		btnCancel = new Button("Clear");
		Style.ButtonFillColorAndSize(btnCancel, 15, 100, 30, 10, 10, "grey");
		
		hbBtnCon = new HBox();
		hbBtnCon.getChildren().addAll(btnSave,btnCancel);
		hbBtnCon.setSpacing(20);
		
		gp = new GridPane();
		gp.add(lAmount, 0, 1);
		gp.add(vbAmountError, 0, 2);
		gp.add(hbBtnCon, 0, 3);
		Style.GpFillColorAndSizeAndPadding(gp, 0, 0, 20, 20, "transparent");
		
		if((fee-total) > 0)
		{
				tAmount.setOnKeyTyped(e->{
				btnSave.setDisable(true);
				if(!Validation.checkFine(tAmount.getText()))
				{
					lAmountError.setText("Type number");
					lAmountError.setVisible(false);
				}
				else
				{
					if(Integer.parseInt(tAmount.getText())+total > fee)
					{
						lAmountError.setText("Reduce your payment amount");
						lAmountError.setVisible(true);
					}
					else
					{
						btnSave.setDisable(false);
						lAmountError.setVisible(false);
					}
				}
			});	
		}
		else
		{
			tAmount.setEditable(false);
			btnSave.setDisable(true);
		}
		
		
		
		btnSave.setOnAction(e->{		
	   	 Handler.StudentHandler.AddPerPayment(csid+"", tAmount.getText(), Login.userid);
	   	 Alert al = new Alert(AlertType.INFORMATION,"Add successfully");
	   	 al.showAndWait();
		 myStage.close();
			
		});
		
		btnCancel.setOnAction(e->{
			vbAmountError.getChildren().remove(lAmountError);
			if(fee-total > 0)
			{
				tAmount.setEditable(true);
			}
			else
			{
				tAmount.setEditable(false);
			}
			btnSave.setDisable(true);
		});
		
		vbRegisterStudentView.getChildren().addAll(lRestAmount,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbRegisterStudentView, "white", 10, 20, 20);
		
		Scene sc = new Scene(vbRegisterStudentView);
		myStage.setScene(sc);
		myStage.initModality(Modality.WINDOW_MODAL);
		myStage.initOwner(Login.myStage);
		myStage.show();
	}
}

