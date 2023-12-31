package View;
import Handler.SectionHandler;
import Handler.StudentHandler;
import Handler.StudentPaymentHandler;
import List.CourseStudentLists;
import List.SectionLists;
import List.StudentPaymentLists;
import Table.StudentPaymentTable;
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
public class StudentPaymentListsView {
	private static VBox vbStudentPaymentListsView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvStudentPayment;
	private static BorderPane bp;
	private static TextField tStudentID;
	private static TextField tStudentName;
	private static TextField tCourseName;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static VBox vbStudentPaymentListsCon;
	private static ObservableList<CourseStudentLists> data;

	public static VBox vbStudentPaymentListsView()
	{
		vbStudentPaymentListsView = new VBox();
		
		lTitle = new Label("Payment Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 15, 50, 0);
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		
		bp = new BorderPane();
		
		tStudentID = new TextField();
		tStudentID.setPromptText("Student ID");
		tStudentID.setPrefHeight(30);
		tStudentID.setFont(Font.font(15));

		tStudentName = new TextField();
		tStudentName.setPromptText("Student Name");
		tStudentName.setPrefHeight(30);
		tStudentName.setFont(Font.font(15));

		tCourseName = new TextField();
		tCourseName.setPromptText("Course Name");
		tCourseName.setPrefHeight(30);
		tCourseName.setFont(Font.font(15));

		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");

		btnAdd = new Button("Add New StudentPayment", new ImageView (new Image("Icon/Plus16.png")));
		Style.BtnAdd(btnAdd);

		btnRefresh.setOnAction(e->{
			tvStudentPayment.getItems().clear();
			data = FXCollections.observableArrayList(StudentPaymentHandler.GetAllPayment());
			tvStudentPayment.setItems(data);
		});
		
		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tStudentID,tStudentName,tCourseName,btnRefresh,btnAdd);
		hbFilterCon.setSpacing(10);
		
		tStudentID.setOnKeyTyped(e->{
			System.out.println(tStudentID.getText());
			tvStudentPayment.getItems().clear();
			data = FXCollections.observableArrayList(StudentPaymentHandler.FilterPayment(tStudentID.getText(), tStudentName.getText(), tCourseName.getText()));
			tvStudentPayment.setItems(data);
		});
		
		tStudentName.setOnKeyTyped(e->{
			System.out.println(tStudentName.getText());
			tvStudentPayment.getItems().clear();
			data = FXCollections.observableArrayList(StudentPaymentHandler.FilterPayment(tStudentID.getText(), tStudentName.getText(), tCourseName.getText()));
			tvStudentPayment.setItems(data);
		});
		
		tCourseName.setOnKeyTyped(e->{
			System.out.println(tCourseName.getText());
			tvStudentPayment.getItems().clear();
			data = FXCollections.observableArrayList(StudentPaymentHandler.FilterPayment(tStudentID.getText(), tStudentName.getText(), tCourseName.getText()));
			tvStudentPayment.setItems(data);
		});
		
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		StudentPaymentTable.tvStudentPaymentLists();
		tvStudentPayment = StudentPaymentTable.tvStudentPaymentLists();
		data = FXCollections.observableArrayList(StudentPaymentHandler.GetAllPayment());
		tvStudentPayment.setItems(data);
		
		vbStudentPaymentListsCon = new VBox();
		vbStudentPaymentListsCon.getChildren().addAll(bp,tvStudentPayment);
		Style.VBoxFillColorAndSizeAndPadding(vbStudentPaymentListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
//			MainView.vbWorkSpace = AddPaymentView.vbShowRegisterView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Add New Fee payment");
		});
		
		vbStudentPaymentListsView.getChildren().addAll(hbTitleCon,vbStudentPaymentListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbStudentPaymentListsView, "#f2f2f2", 10, 20,5);		
		return vbStudentPaymentListsView;
	}
}
