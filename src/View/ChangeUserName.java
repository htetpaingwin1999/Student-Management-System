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
import javafx.scene.control.TextField;
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
public class ChangeUserName {
	private static VBox vbChangePasswordView;
	private static Label lTitle;
	private static Label lSubTitle;
	private static VBox vbTitleCon;
	private static Label lCurrent;
	private static PasswordField pCurrent;
	private static Label lCurrentError;
	private static VBox vbCurrent;

	private static Label lUsername;
	private static TextField tUsername;
	private static Label lUsernameError;
	private static VBox vbUsername;
	
	private static GridPane gp;
	private static Button btnSave;
	private static Button btnCancel;
	private static HBox hbBtnCon;
	public static VBox vbChangePasswordView(String username,String id)
	{
		vbChangePasswordView = new VBox();
		lTitle = new Label("Change Username");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		lSubTitle = new Label("It is a good idea that you are using beautiful name else");
		Style.LabelFillColorAndSize(lSubTitle, "grey", 15);

		
		vbTitleCon = new VBox();
		vbTitleCon.setPrefSize(1080,80);
		vbTitleCon.getChildren().addAll(lTitle,lSubTitle);
		Style.VBoxFillColorAndSizeAndPadding(vbTitleCon, "white", 15, 50, 5);
		
		lCurrent = new Label("Password");
		Style.LabelFillColorAndSize(lCurrent, "grey", 15);
		
		lCurrentError = new Label("Incorrect Password");
		Style.LabelFillColorAndSize(lCurrentError, "red", 15);
		
		pCurrent = new PasswordField();
		pCurrent.setPrefWidth(490);
		pCurrent.setText("");
		
		vbCurrent = new VBox();
		vbCurrent.getChildren().addAll(pCurrent,lCurrentError);
		vbCurrent.setSpacing(3);

		lUsername = new Label("Name");
		Style.LabelFillColorAndSize(lUsername, "grey", 15);

		lUsernameError = new Label("Type minimum 4 characters and maximum 50 characters");
		Style.LabelFillColorAndSize(lUsernameError, "red", 15);

		tUsername = new TextField();
		tUsername.setPrefWidth(490);
		tUsername.setText(username);
		
		vbUsername = new VBox();
		vbUsername.getChildren().addAll(tUsername,lUsernameError);
		vbUsername.setSpacing(3);
		
		btnSave = new Button("Save Change");
		Style.ButtonSave(btnSave);
		btnSave.setDisable(true);
		
		btnCancel = new Button("Clear");
		Style.ButtonCancel(btnCancel);
		
		hbBtnCon = new HBox();
		hbBtnCon.getChildren().addAll(btnSave,btnCancel);
		hbBtnCon.setSpacing(10);
		
		gp = new GridPane();
		gp.add(lUsername, 0, 0);
		gp.add(vbUsername, 0, 1);
		gp.add(lCurrent, 0, 2);
		gp.add(vbCurrent, 0, 3);
		gp.add(hbBtnCon, 0, 4);
		gp.setVgap(20);
		Style.GpFillColorAndSizeAndPadding(gp, 20, 245, 0, 20, "white");
		gp.setPrefWidth(1080);
		
		tUsername.setOnKeyReleased(e->{
			btnSave.setDisable(true);
			if(tUsername.getText().length()<4 || tUsername.getText().length()>50)
			{
				lUsernameError.setVisible(true);
			}
			else
			{
				lUsernameError.setVisible(false);
				if(pCurrent.getText().length() >= 4)
				{
					btnSave.setDisable(false);	
				}
			}
		});
		
		pCurrent.setOnKeyReleased(e->{
			btnSave.setDisable(true);
			if(pCurrent.getText().length() >= 4)
			{
				btnSave.setDisable(false);	
			}
			
		});
		btnSave.setOnAction(e->{
			 Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to change username",ButtonType.YES,ButtonType.NO);
			 al.showAndWait();
			 if(al.getResult() == ButtonType.YES)
			 {
				 if(Login.userpos.equals("1") )//Admin
					{
						if(Handler.AccountHandler.IsAdmin(Login.email,pCurrent.getText()))
						{
							Handler.AccountHandler.UpdateAdminUsername(id, tUsername.getText());
							MainView.lUsername.setText(tUsername.getText());
							MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
							MainView.vbWorkSpace = DashboardView.vbDashboardView();
							MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
							MainView.RemoveIndex();
							MainView.UpdateIndex(MainView.lHome, "Home");
						}
						else
						{
							Alert alerr = new Alert(AlertType.ERROR,"Incorrect password");
							alerr.showAndWait();
							lCurrentError.setVisible(true);
						}
					}
					
					if(Login.userpos.equals("2") )//Staff
					{
						if(Handler.AccountHandler.IsStaff(Login.email,pCurrent.getText()))
						{
							Login.username = tUsername.getText();
							Handler.AccountHandler.UpdateStaffUsername(id, tUsername.getText());
							MainView.lUsername.setText(tUsername.getText());
							MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
							MainView.vbWorkSpace = DashboardView.vbDashboardView();
							MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
							MainView.RemoveIndex();
							MainView.UpdateIndex(MainView.lHome, "Home");
						}
						else
						{
							lCurrentError.setVisible(true);
							Alert alerr = new Alert(AlertType.ERROR,"Incorrect password for staff");
							alerr.showAndWait();
						}
					}	
			 }
			
		});
		
		btnCancel.setOnAction(e->{
			lCurrentError.setVisible(false);
			lUsernameError.setVisible(false);
			tUsername.setText("");
			pCurrent.setText("");
		});
		vbChangePasswordView.getChildren().addAll(vbTitleCon,gp);
		Style.VBoxFillColorAndSizeAndPadding(vbChangePasswordView, "#f2f2f2", 10, 0, 5);
		return vbChangePasswordView;	}
}
