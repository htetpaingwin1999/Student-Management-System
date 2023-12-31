package View;
import Handler.AdminHandler;
import Handler.StaffHandler;
import Handler.StudentHandler;
import List.StudentLists;
import Table.StudentTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class StudentListsView {
	private static VBox vbStudentListsView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvStudent;
	private static BorderPane bp;
	private static TextField tStudentID;
	private static TextField tStudentName;
	private static TextField tStudentPhoneNo;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static VBox vbStudentListsCon;
	private static ObservableList<StudentLists> data;

	public static VBox vbStudentListsView()
	{
		vbStudentListsView = new VBox();
		
		lTitle = new Label("Student Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 15, 50, 0);
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tStudentID = new TextField();
		Style.TextFieldFill(tStudentID, "Student ID", 30, 15);

		tStudentName = new TextField();
		Style.TextFieldFill(tStudentName, "Student Name", 30, 15);

		tStudentPhoneNo = new TextField();
		Style.TextFieldFill(tStudentPhoneNo, "Student Phone No", 30, 15);

		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");

		btnAdd = new Button("Add New Student", new ImageView (new Image("Icon/Plus16.png")));
		Style.BtnAdd(btnAdd);
		
		hbFilterCon = new HBox();
		if(Login.userpos.equals("1"))
		{
		hbFilterCon.getChildren().addAll(tStudentID,tStudentName,tStudentPhoneNo,btnRefresh);
		}
		else
		{
			hbFilterCon.getChildren().addAll(tStudentID,tStudentName,tStudentPhoneNo,btnRefresh,btnAdd);
		}
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
				
		StudentTable.tvStudentLists();
		data = FXCollections.observableArrayList(StudentHandler.GetAllStudent());
		tvStudent = StudentTable.tvStudentLists();
		tvStudent.setItems(data);

		btnRefresh.setOnAction(e->{
			tvStudent.getItems().clear();
			data = FXCollections.observableArrayList(StudentHandler.GetAllStudent());
			tvStudent.setItems(data);
			tStudentName.setText(null);
			tStudentID.setText(null);
			tStudentPhoneNo.setText(null);
		});
		
		tStudentID.setOnKeyTyped(e->{
			tvStudent.getItems().clear();
			data = FXCollections.observableArrayList(StudentHandler.FilterStudent(tStudentID.getText(), tStudentName.getText(),tStudentPhoneNo.getText()));
			tvStudent.setItems(data);
		});
		
		tStudentName.setOnKeyTyped(e->{
			tvStudent.getItems().clear();
			data = FXCollections.observableArrayList(StudentHandler.FilterStudent(tStudentID.getText(), tStudentName.getText(),tStudentPhoneNo.getText()));
			tvStudent.setItems(data);
		});
		
		tStudentPhoneNo.setOnKeyTyped(e->{
			tvStudent.getItems().clear();
			data = FXCollections.observableArrayList(StudentHandler.FilterStudent(tStudentID.getText(), tStudentName.getText(),tStudentPhoneNo.getText()));
			tvStudent.setItems(data);
		});
		
		vbStudentListsCon = new VBox();
		vbStudentListsCon.getChildren().addAll(bp,tvStudent);
		Style.VBoxFillColorAndSizeAndPadding(vbStudentListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDStudentView.vbAddStudentView(0, "", "", "", 1);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Add New Student");
		});
		
		vbStudentListsView.getChildren().addAll(hbTitleCon,vbStudentListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbStudentListsView, "white", 10, 0, 5);
		return vbStudentListsView;
	}
}
