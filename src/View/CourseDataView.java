package View;

import java.awt.Desktop;
import java.util.Date;

import Handler.CourseHandler;
import List.CourseLists;
import Table.CourseTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
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

public class CourseDataView {
	private static VBox vbAddCourseView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static Label lSubTitle;
	private static Label lCourseID;
	private static Label llCourseID;
	private static Label lCourseName;
	private static Label llCourseName;
	private static Label lCourseFee;
	private static Label llCourseFee;
	private static Label lAdminID;
	private static Label llAdminID;
	private static Label lAdminName;
	private static Label llAdminName;
	private static Label lAddDate;
	private static Label llAddDate;
	private static GridPane gp;
	private static HBox hbCourseDetailCon;
	private static ImageView imgCourse;
	private static BorderPane bpAboutCourseNBtnCon;
	private static Button btnEdit;
	private static Button btnPrint;
	private static Button btnDownload;
	private static HBox hbBtnCon;
	private static TableView tvCourseHistory;
 	private static ObservableList<CourseLists> data;

 	private static VBox vbCourseDataPart;
	private static HBox hbCourseTitlePart;
	private static Label  lCourseTitle;
	private static GridPane gpCourseDataPart;

	
	private static VBox vbAdminDataPart;
	private static HBox hbAdminTitlePart;
	private static Label  lAdminDataTitle;
	private static GridPane gpAdminDataPart;

 	
	public static VBox vbCourseDataView(int cid,String cname,int cfee,int adid,String adName,String addDate)
	{
		
		MainView.RemoveIndex();
		MainView.UpdateIndex(MainView.lIndex1, "Course Lists");
		MainView.UpdateIndex(MainView.lIndex2, "Course Data");
		
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Course Lists");
            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = CourseListsView.vbCourseListsView(Login.userid,Login.userpos);
            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
		});
		
		vbAddCourseView = new VBox();
			
		lTitle = new Label(cname+" Detail");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 20, 50, 0);
		
		lCourseID = new Label("Course ID:");
		Style.LabelFillColorAndSize(lCourseID, "black", 15);

		llCourseID = new Label();
		Style.LabelFillColorAndSize(llCourseID, "grey", 15);
		llCourseID.setText(cid+"");
		
		lCourseName = new Label("Course Name:");
		Style.LabelFillColorAndSize(lCourseName, "black", 15);
		
		llCourseName = new Label();
		llCourseName.setText(cname);
		Style.LabelFillColorAndSize(llCourseName, "grey", 15);
		
		lCourseFee = new Label("Course Fee:");
		Style.LabelFillColorAndSize(lCourseFee, "black", 15);
		
		llCourseFee = new Label();
		Style.LabelFillColorAndSize(llCourseFee, "grey", 15);
		llCourseFee.setText(cfee+"");
		
		lAdminID = new Label("Admin ID:");
		Style.LabelFillColorAndSize(lAdminID, "black", 15);
		
		llAdminID = new Label();
		llAdminID.setText(adid+"");
		Style.LabelFillColorAndSize(llAdminID, "grey", 15);

		lAdminName = new Label("Admin Name:");
		Style.LabelFillColorAndSize(lAdminName, "black", 15);
	
		llAdminName = new Label();
		Style.LabelFillColorAndSize(llAdminName, "black", 15);
		llAdminName.setText(adName);
		
		lAddDate = new Label("Defined Date:");
		Style.LabelFillColorAndSize(lAddDate, "black", 15);

		llAddDate = new Label();
		Style.LabelFillColorAndSize(llAddDate, "grey", 15);
		llAddDate.setText(addDate);
		
		vbCourseDataPart = new VBox();
		
		hbCourseTitlePart = new HBox();
		
		ImageView imgCourseIcon = new ImageView(new Image("Icon/ocicon.png"));
		
		lCourseTitle = new Label("Course Details");
		Style.LabelFillColorAndSizeBold(lCourseTitle, "black", 17);

		hbCourseTitlePart.getChildren().addAll(imgCourseIcon, lCourseTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbCourseTitlePart, "white", 10, 10, 5);
		
		gpCourseDataPart = new GridPane();
		gpCourseDataPart.add(lCourseID, 0, 0);
		gpCourseDataPart.add(llCourseID, 1, 0);
		gpCourseDataPart.add(lCourseName, 0, 1);
		gpCourseDataPart.add(llCourseName, 1, 1);
		gpCourseDataPart.add(lCourseFee, 0, 2);
		gpCourseDataPart.add(llCourseFee, 1, 2);
		gpCourseDataPart.add(lAddDate, 0, 3);
		gpCourseDataPart.add(llAddDate, 1, 3);
		Style.GpFillColorAndSizeAndPadding(gpCourseDataPart, 10, 10, 17, 17, "white");
		
		vbCourseDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbCourseDataPart, hbCourseTitlePart, gpCourseDataPart);

		vbAdminDataPart = new VBox();
		
		hbAdminTitlePart = new HBox();
		
		ImageView imgAdminIcon = new ImageView(new Image("Icon/adminicon.png"));
		
		lAdminDataTitle = new Label("Admin Details");
		Style.LabelFillColorAndSizeBold(lAdminDataTitle, "black", 17);
		
		hbAdminTitlePart.getChildren().addAll(imgAdminIcon, lAdminDataTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbAdminTitlePart, "white", 10, 10, 5);
		
		gpAdminDataPart = new GridPane();
		gpAdminDataPart.add(lAdminID, 0, 0);
		gpAdminDataPart.add(llAdminID, 1, 0);
		gpAdminDataPart.add(lAdminName, 0, 1);
		gpAdminDataPart.add(llAdminName, 1, 1);
		Style.GpFillColorAndSizeAndPadding(gpAdminDataPart, 10, 10, 17, 17, "white");
		
		vbAdminDataPart = new VBox();
		Style.ChildNodeAddToVBox(vbAdminDataPart, hbAdminTitlePart, gpAdminDataPart);
		
		tvCourseHistory = CourseTable.tvCourseLists(2);
		data = FXCollections.observableArrayList(Handler.CourseHandler.GetCourseHistory(cid));
		tvCourseHistory.setItems(data);
				
		vbAddCourseView.getChildren().addAll(hbTitleCon,vbCourseDataPart,vbAdminDataPart,tvCourseHistory);
		Style.VBoxFillColorAndSizeAndPadding(vbAddCourseView, "whie", 10, 10, 5);
		vbAddCourseView.setPrefHeight(700);
		return vbAddCourseView;
		}
}

