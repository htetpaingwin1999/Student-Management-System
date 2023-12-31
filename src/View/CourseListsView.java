package View;
import Handler.CourseHandler;
import Handler.DepartmentHandler;
import Handler.StaffHandler;
import List.CourseLists;
import List.DepartmentLists;
import Table.CourseTable;
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
public class CourseListsView {
	private static VBox vbCourseListsView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvCourse;
	private static BorderPane bp;
//	private static TextField tCourseIDSearch;
	private static TextField tCourseNameSearch;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static VBox vbCourseListsCon;
	private static ObservableList<CourseLists> data;
	public static VBox vbCourseListsView(String id,String role)
	{
		vbCourseListsView = new VBox();
		
		lTitle = new Label("Course Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));

		hbTitleCon = new HBox();
		Style.HBoxWidthHeightSize(hbTitleCon, "white", 15, 50, 0,1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tCourseNameSearch = new TextField();
		Style.TextFieldFill(tCourseNameSearch, "Course Name", 50, 15);
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");

		btnAdd = new Button("Add New Course", new ImageView (new Image("Icon/Plus16.png")));
		Style.BtnAdd(btnAdd);
		
		hbFilterCon = new HBox();
		hbFilterCon.setSpacing(10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
//		bp.setPadding(new Insets(10,10,10,0));
		
		if(Login.userpos.equals("1"))
		{
			tvCourse = CourseTable.tvCourseLists(1);
			hbFilterCon.getChildren().addAll(tCourseNameSearch,btnRefresh,btnAdd);
		}
		else
		{
			tvCourse = CourseTable.tvCourseLists(2);
			hbFilterCon.getChildren().addAll(tCourseNameSearch,btnRefresh);
		}
		data = FXCollections.observableArrayList(CourseHandler.GetAllCourse());
		tvCourse.setItems(data);
		
		vbCourseListsCon = new VBox();
		vbCourseListsCon.getChildren().addAll(bp,tvCourse);
		Style.VBoxFillColorAndSizeAndPadding(vbCourseListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDCourseView.vbAddCourseView(0, "","", 1);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Add New Course");
		});
		
		vbCourseListsView.getChildren().addAll(hbTitleCon,vbCourseListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbCourseListsView, "#f2f2f2", 10, 0, 5);
		
//		tCourseIDSearch.setOnKeyTyped(e->{
//			tvCourse.getItems().clear();
//			data = FXCollections.observableArrayList(CourseHandler.FilterCourse(tCourseIDSearch.getText(),tCourseNameSearch.getText()));
//			tvCourse.setItems(data);
//		});
//		
		tCourseNameSearch.setOnKeyTyped(e->{
			tvCourse.getItems().clear();
			data = FXCollections.observableArrayList(CourseHandler.FilterCourse("",tCourseNameSearch.getText()));
			tvCourse.setItems(data);
		});
		
		btnRefresh.setOnAction(e->{
			tvCourse.getItems().clear();
			data = FXCollections.observableArrayList(CourseHandler.GetAllCourse());
			tvCourse.setItems(data);
		});
		return vbCourseListsView;
	}
}
