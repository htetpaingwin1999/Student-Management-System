package View;
import Handler.SectionHandler;
import Handler.DepartmentHandler;
import List.SectionLists;
import List.DepartmentLists;
import Table.SectionTable;
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
public class FinishedSectionListsView {
	private static VBox vbSectionListsView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvSection;
	private static BorderPane bp;
	private static TextField tSectionID;
	private static TextField tCourseName;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static VBox vbSectionListsCon;
	private static ObservableList<SectionLists> data;
	public static VBox vbSectionListsView()
	{
		MainView.lIndex1.setOnMouseClicked(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = SectionListsView.vbSectionListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
		});
		
		vbSectionListsView = new VBox();
		
		lTitle = new Label("Finished Section Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 15, 50, 0);
		
		bp = new BorderPane();
		
		tSectionID = new TextField();
		tSectionID.setPromptText("Section ID");
		tSectionID.setPrefHeight(20);

		tCourseName = new TextField();
		tCourseName.setPromptText("Course Name");
		tCourseName.setPrefHeight(20);
		tCourseName.setFont(Font.font(15));
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");

		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tCourseName,btnRefresh);
		hbFilterCon.setSpacing(10);
		
		bp.setLeft(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		SectionTable.tvSectionLists(1);
		tvSection = SectionTable.tvSectionLists(1);
		data = FXCollections.observableArrayList(SectionHandler.GetAllSection(2));
		tvSection.setItems(data);
		
		btnRefresh.setOnAction(e->{
			data = FXCollections.observableArrayList(SectionHandler.GetAllSection(2));
			tvSection.setItems(data);	
		});
		
		tCourseName.setOnKeyTyped(e->{
			System.out.println(tCourseName.getText());
			tvSection.getItems().clear();
			data = FXCollections.observableArrayList(SectionHandler.FilterSection(tCourseName.getText(),2));
			tvSection.setItems(data);
		});
		
		vbSectionListsCon = new VBox();
		vbSectionListsCon.getChildren().addAll(bp,tvSection);
		Style.VBoxFillColorAndSizeAndPadding(vbSectionListsCon, "white", 10, 30, 10);
		
		vbSectionListsView.getChildren().addAll(hbTitleCon,vbSectionListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbSectionListsView, "#f2f2f2", 10, 10, 5);
		return vbSectionListsView;
	}
}
