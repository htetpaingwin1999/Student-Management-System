package View;
import Handler.Validation;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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


public class Login extends Application {
	public static Stage myStage;
	public static BorderPane bp;
	private static VBox vbSignIn;
	private static VBox vbLeftImage;
	private static Label lSignInTitle;
	private static Label lUserEmail;
	private static TextField tUserEmail;
	private static Label lPassword;
	private static PasswordField pPassword;
	private static Button btnSignIn;
	private static HBox hbSinginContainer;
	public static String userid,userpos,username;
	private static GridPane gp;
	private static HBox hbRadioButon;
	private static RadioButton rbAdmin,rbStaff;
	private static Label lTypeHelp;
	public static String email;
	public static void main(String args[])
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		myStage = new Stage();
		BorderPane bp = BpLogin();
		myStage.setScene(new Scene(bp,850,500));
		myStage.centerOnScreen();
		myStage.show();
		myStage.setResizable(false);
		Image icon = new Image("Icon/moon.png");
		myStage.getIcons().add(icon);
	}
	public static BorderPane BpLogin()
	{
		bp = new BorderPane();
		
		vbLeftImage =new VBox(new ImageView(new Image("Icon/left.png")));
		vbLeftImage.setPrefSize(400, 500);
		vbLeftImage.setStyle("-fx-background-color:#23F7DA;");
		
		vbSignIn = new VBox();
		vbSignIn.setPrefSize(400, 500);
		vbSignIn.setStyle("-fx-background-color:white");
		
		lSignInTitle = new Label("Sign in To Brilliant Developers Group");
		Style.LabelFillColorAndSize(lSignInTitle,"grey",20);
		
		lUserEmail = new Label("User Email");
		Style.LabelFillColorAndSize(lUserEmail,"grey",15);
		
		tUserEmail = new TextField("");
		tUserEmail.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		tUserEmail.setPrefWidth(320);
		
		lPassword = new Label("Password");
		lPassword.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		Style.LabelFillColorAndSize(lPassword,"grey",15);

		pPassword = new PasswordField();
		pPassword.setPrefWidth(320);
		pPassword.setText("");
		
		btnSignIn = new Button("Sign In");
		btnSignIn.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));
		btnSignIn.setTextFill(Color.WHITE);
		btnSignIn.setStyle("-fx-background-color:orange;");
		btnSignIn.setPrefSize(320,40);
		
		hbRadioButon = new HBox();
		
		rbAdmin = new RadioButton("Admin");
		rbAdmin.setSelected(true);
		rbAdmin.setFont(Font.font(15));

		rbStaff = new RadioButton("Staff");
		rbStaff.setSelected(false);
		rbStaff.setFont(Font.font(15));
		
		hbRadioButon.getChildren().addAll(rbAdmin,rbStaff);
		hbRadioButon.setSpacing(30);
		
		lTypeHelp = new Label("admin");
		
		
		rbAdmin.setOnAction(e->{
			rbStaff.setSelected(false);
			rbAdmin.setSelected(true);
			lTypeHelp.setText("admin");
		});

		rbStaff.setOnAction(e->{
			rbStaff.setSelected(true);
			rbAdmin.setSelected(false);
			lTypeHelp.setText("staff");
		});
		gp = new GridPane();
		gp.add(lUserEmail, 0, 0);
		gp.add(tUserEmail, 0, 1);
		gp.add(lPassword, 0, 2);
		gp.add(pPassword, 0, 3);
		gp.add(hbRadioButon, 0, 4);
		gp.add(btnSignIn, 0, 5);
		gp.setVgap(20);
		
		vbSignIn.getChildren().addAll(lSignInTitle,gp);
		vbSignIn.setSpacing(20);
		vbSignIn.setPadding(new Insets(40,40,40,40));
		
		bp.setLeft(vbLeftImage);
		bp.setRight(vbSignIn);
		
		btnSignIn.setOnAction(e->{
			
			if(lTypeHelp.getText().equals("admin"))
			{
				if(Handler.AccountHandler.IsAdmin(tUserEmail.getText(),pPassword.getText()))
				{
					Login.userpos = "1";
					email = tUserEmail.getText();	
					Login.userid = Handler.AccountHandler.GetAdminIDFromEmail(tUserEmail.getText())+"";
					Login.username = Handler.AccountHandler.AdminUsername(Login.userid);
					myStage.setScene(new Scene(MainView.vbMainView(Login.userid)));
					myStage.centerOnScreen();
					myStage.show();
				}
				else
				{
					Alert al = new Alert(AlertType.ERROR,"Invalid  Admin Login Attemp");
					al.showAndWait();
				}
			}
			if(lTypeHelp.getText().equals("staff"))
			{
				if(Handler.AccountHandler.IsStaff(tUserEmail.getText(),pPassword.getText()))
				{
					Login.userpos = "2";
					email = tUserEmail.getText();
					Login.userid = Handler.AccountHandler.GetStaffIDFromEmail(tUserEmail.getText())+"";
					Login.username = Handler.AccountHandler.StaffUsername(Login.userid);
					myStage.setScene(new Scene(MainView.vbMainView(Login.userid)));
					myStage.centerOnScreen();
					myStage.show();
				}
				else
				{
					Alert al = new Alert(AlertType.ERROR,"Invalid Staff Login Attemp");
					al.showAndWait();
				}
			}
			
		});
		return bp;
	}
	
}

