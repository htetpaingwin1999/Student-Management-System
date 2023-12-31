package View;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class ChangePasswordView {
	private static VBox vbChangePasswordView;
	private static Label lTitle;
	private static Label lSubTitle;
	private static VBox vbTitleCon;
	private static Label lCurrent;
	private static PasswordField pCurrent;
	private static Label lCurrentError;
	private static VBox vbCurrent;

	private static Label lNew1;
	private static PasswordField pNew1;
	private static Label lNew1Error;
	private static VBox vbNew1;
	
	private static Label lNew2;
	private static PasswordField pNew2;
	private static Label lNew2Error;
	private static VBox vbNew2;

	
	private static GridPane gp;
	private static Button btnUpdate;
	private static Button btnCancel;
	private static HBox hbBtnCon;
	public static VBox vbChangePasswordView()
	{
		vbChangePasswordView = new VBox();
		lTitle = new Label("Change Password");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		lSubTitle = new Label("It is a good idea that you are not using anyone else");
		Style.LabelFillColorAndSize(lSubTitle, "grey", 15);
		
		vbTitleCon = new VBox();
		vbTitleCon.setPrefSize(1080,80);
		vbTitleCon.getChildren().addAll(lTitle,lSubTitle);		
		Style.VBoxFillColorAndSizeAndPadding(vbTitleCon, "white", 15, 50, 5);
		
		lCurrent = new Label("Current Password");
		Style.LabelFillColorAndSize(lCurrent, "grey", 15);

		pCurrent = new PasswordField();
		pCurrent.setPrefWidth(490);
		pCurrent.setText("");
		
		vbCurrent = new VBox();
		vbCurrent.getChildren().add(pCurrent);
		
		lNew1 = new Label("New Password");
		Style.LabelFillColorAndSize(lNew1, "grey", 15);

		lNew1Error = new Label("");
		Style.LabelFillColorAndSize(lNew1Error, "red", 15);

		pNew1 = new PasswordField();
		pNew1.setPrefWidth(490);
		pNew1.setText("");
		
		vbNew1 = new VBox();
		vbNew1.getChildren().addAll(pNew1,lNew1Error);
		
		lNew2 = new Label("Confirm Password");
		Style.LabelFillColorAndSize(lNew2, "grey", 15);

		pNew2 = new PasswordField();
		pNew2.setPrefWidth(490);
		pNew2.setText("");
		
		lNew2Error = new Label("Passwords do not match");
		Style.LabelFillColorAndSize(lNew2Error, "red", 15);

		vbNew2 = new VBox();
		vbNew2.getChildren().addAll(pNew2,lNew2Error);
		
		btnUpdate = new Button("Change");
		Style.ButtonUpdate(btnUpdate);
		btnUpdate.setDisable(true);
		
		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		hbBtnCon = new HBox();
		hbBtnCon.getChildren().addAll(btnUpdate,btnCancel);
		hbBtnCon.setSpacing(10);
		
		gp = new GridPane();
		gp.add(lCurrent, 0, 0);
		gp.add(vbCurrent, 0, 1);
		gp.add(lNew1, 0, 2);
		gp.add(vbNew1, 0, 3);
		gp.add(lNew2, 0, 4);
		gp.add(vbNew2, 0, 5);
		gp.add(hbBtnCon, 0, 6);
		gp.setVgap(20);
		Style.GpFillColorAndSizeAndPadding(gp, 20, 245, 0, 20, "white");
		gp.setPrefWidth(1080);
		
		pCurrent.setOnKeyTyped(e->{
			btnUpdate.setDisable(true);
			if(!pNew1.getText().equals(pCurrent.getText()))
			{
				
				if(Handler.Validation.checkPassword(pNew1.getText())&& pNew1.getText().equals(pNew2.getText()))
				{
					lNew1Error.setVisible(false);
					lNew2Error.setVisible(false);
					btnUpdate.setDisable(false);
				}
				
				else {
					if(!(pNew1.getText().equals("") && pNew2.getText().equals("")))
					{
						lNew2Error.setVisible(true);
					}
				}
			}
			else {
				if(!pNew1.getText().equals("")) {
					lNew1Error.setText("Please type new password different from current ones");
					lNew1Error.setVisible(true);
				}
			}
			
			
		});
		
		pNew1.setOnKeyTyped(e->{
			lNew1Error.setVisible(false);
			btnUpdate.setDisable(true);
			if(!Handler.Validation.checkPassword(pNew1.getText()))
			{	
				lNew1Error.setText(Handler.Validation.passwordError);
				lNew1Error.setVisible(true);
			}
			else
			{
				if(Handler.Validation.checkPassword(pCurrent.getText()))
				{
					if(pNew1.getText().equals(pNew2.getText()))
					{
						if(!pCurrent.getText().equals(pNew1.getText()))
						{
							btnUpdate.setDisable(false);
							lNew1Error.setVisible(false);
						}
						else {
							lNew1Error.setText("Please type new password different from current ones");
							lNew1Error.setVisible(true);
						}
					}
					else {
						if(!pNew2.getText().equals(""))
						{
							lNew2Error.setVisible(true);
						}
						else {
							lNew2Error.setVisible(false);
						}
						
					}
					
				}
			}
		});
		
		pNew2.setOnKeyTyped(e->{
			lNew2Error.setVisible(false);
			btnUpdate.setDisable(true);
			if(!pNew2.getText().equals(pNew1.getText()))
			{	
				lNew2Error.setText("Passwords do not match");
			}
			else
			{
				if(Handler.Validation.checkPassword(pCurrent.getText()) && Handler.Validation.checkPassword(pNew1.getText())) {
					 if(!pCurrent.getText().equals(pNew1.getText()))
					 {
						 btnUpdate.setDisable(false);
					 }
					 else {
						 lNew1Error.setText("Please type new password different from current ones");
						 lNew1Error.setVisible(true);					 }
					
				}
			}
			
		});
		
		btnUpdate.setOnAction(e->{
			if(Login.userpos.equals("1"))
			{
				Alert alChange = new Alert(AlertType.CONFIRMATION,"Are you sure to change the password",ButtonType.YES,ButtonType.CANCEL);
				alChange.showAndWait();
				
				if(alChange.getResult().equals(ButtonType.YES))
				{
					if(Handler.AccountHandler.IsAdmin(Login.email, pCurrent.getText()))
					{
						Handler.AccountHandler.UpdateAdminPassword(Login.userid, pNew1.getText());
						Alert alsus = new Alert(AlertType.INFORMATION,"Change Password Successfully");
						alsus.showAndWait();
						Alert al = new Alert(AlertType.INFORMATION,"Session Expired");
						al.show();
						pNew1.setText("");
						pCurrent.setText("");
						pNew2.setText("");
						
						Login.myStage.setScene(new Scene(Login.BpLogin(),850,500));
						Login.myStage.centerOnScreen();
						Login.myStage.show();
						Login.myStage.setResizable(false);
					}
					else
					{
						Alert al = new Alert(AlertType.ERROR,"Incorrect Password");
						al.showAndWait();
					}	
				}
				
			}
			if(Login.userpos.equals("2"))
			{
				Alert alChange = new Alert(AlertType.CONFIRMATION,"Are you sure to change the password",ButtonType.YES,ButtonType.CANCEL);
				alChange.showAndWait();
				
				if(alChange.getResult().equals(ButtonType.YES))
				{
					if(Handler.AccountHandler.IsStaff(Login.email, pCurrent.getText()))
					{
						Handler.AccountHandler.UpdateStaffPassword(Login.userid, pNew1.getText());
						Alert alsus = new Alert(AlertType.INFORMATION,"Change Password Successfully");
						alsus.showAndWait();
						Alert al = new Alert(AlertType.INFORMATION,"Session Expired");
						al.show();
						pNew1.setText("");
						pCurrent.setText("");
						pNew2.setText("");
						Login.myStage.setScene(new Scene(Login.BpLogin(),850,500));
						Login.myStage.centerOnScreen();
						Login.myStage.show();
						Login.myStage.setResizable(false);
					}
					else
					{
						Alert al = new Alert(AlertType.ERROR,"Incorrect Password");
						al.showAndWait();
					}	
				}
				
			}
		});
		
		btnCancel.setOnAction(e->{
			lNew1Error.setVisible(false);
			lNew2Error.setVisible(false);
			pCurrent.setText("");
			pNew1.setText("");
			pNew2.setText("");
		});
		
		vbChangePasswordView.getChildren().addAll(vbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbChangePasswordView, "#f2f2f2", 10, 0, 5);
		return vbChangePasswordView;	
	}

}
