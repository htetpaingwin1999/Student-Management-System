package View;
import Handler.CourseStudentHandler;
import Handler.SectionHandler;
import List.CourseStudentLists;
import Table.CourseStudentTable;
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
public class CourseStudentListsView {
	private static VBox vbCourseStudentListsView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvCourseStudent;
	private static BorderPane bp;
	private static TextField tStudentID;
	private static TextField tStudentName;
	private static TextField tCourseName;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static VBox vbCourseStudentListsCon;
	private static ObservableList<CourseStudentLists> data;
	public static VBox vbCourseStudentListsView()
	{
		vbCourseStudentListsView = new VBox();
		
		lTitle = new Label("Course and Student Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 15, 50, 0,1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tStudentID = new TextField();
		Style.TextFieldFill(tStudentID, "Student ID", 30, 15);

		tStudentName = new TextField();
		Style.TextFieldFill(tStudentID, "Student Name", 30, 15);
		
		tCourseName = new TextField();
		Style.TextFieldFill(tCourseName, "Course Name", 30, 15);

		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");

		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tStudentID,tStudentName,tCourseName);
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		CourseStudentTable.tvCourseStudent(2);
		tvCourseStudent = CourseStudentTable.tvCourseStudent(2);
		data = FXCollections.observableArrayList(CourseStudentHandler.GetAllCourseStudents());
		tvCourseStudent.setItems(data);		
		
		vbCourseStudentListsCon = new VBox();
		vbCourseStudentListsCon.getChildren().addAll(bp,tvCourseStudent);
		Style.VBoxFillColorAndSizeAndPadding(vbCourseStudentListsCon, "white", 10, 10, 10);
		
		btnRefresh.setOnAction(e->{
			tvCourseStudent.getItems().clear();
			data = FXCollections.observableArrayList(CourseStudentHandler.GetAllCourseStudents());
			tvCourseStudent.setItems(data);	
		});
		
		tCourseName.setOnKeyTyped(e->{
			tvCourseStudent.getItems().clear();
			data = FXCollections.observableArrayList(CourseStudentHandler.FilterCourseStudents(tStudentID.getText(), tStudentName.getText(), tCourseName.getText()));
			tvCourseStudent.setItems(data);	
			
		});
		
		tStudentID.setOnKeyTyped(e->{
			tvCourseStudent.getItems().clear();
			data = FXCollections.observableArrayList(CourseStudentHandler.FilterCourseStudents(tStudentID.getText(), tStudentName.getText(), tCourseName.getText()));
			tvCourseStudent.setItems(data);	
			
		});
		
		tStudentName.setOnKeyTyped(e->{
			tvCourseStudent.getItems().clear();
			data = FXCollections.observableArrayList(CourseStudentHandler.FilterCourseStudents(tStudentID.getText(), tStudentName.getText(), tCourseName.getText()));
			tvCourseStudent.setItems(data);	
			
		});
		
		vbCourseStudentListsView.getChildren().addAll(hbTitleCon,vbCourseStudentListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbCourseStudentListsView, "white", 10, 0, 5);
		return vbCourseStudentListsView;
	}
}
