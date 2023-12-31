package View;
import Handler.SectionStudentHandler;
import Handler.DepartmentHandler;
import Handler.StaffHandler;
import List.SectionStudentLists;
import List.DepartmentLists;
import Table.SectionStudentTable;
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
public class SectionStudentListView {
	private static VBox vbSectionStudentListsView;
	private static TableView<SectionStudentLists> tvSectionStudent;
	private static TextField tStudentID;
	private static TextField tStudentName;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static ObservableList<SectionStudentLists> data;
	public static VBox vbSectionStudentListsView(int sectionid,int isfinish)
	{
		vbSectionStudentListsView = new VBox();
		
		if(isfinish == 0)
		{
			// simple
			MainView.lIndex1.setOnMouseClicked(e->{
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = SectionListsView.vbSectionListsView();
	            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				
			});
			
			MainView.lIndex2.setOnMouseClicked(e->{
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
				MainView.UpdateIndex(MainView.lIndex2, "Section Data");
				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = SectionDataView.vbSectionDataView(sectionid,isfinish);
	            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			});	
		}
		if(isfinish == 1)
		{
			// simple
			MainView.lIndex1.setOnMouseClicked(e->{
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
	            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = SectionListsView.vbSectionListsView();
	            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			});
			
			MainView.lIndex2.setOnMouseClicked(e->{
				MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
				MainView.UpdateIndex(MainView.lIndex2, "Section Data");
	            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
				MainView.vbWorkSpace = FinishedSectionListsView.vbSectionListsView();
	            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			});	
			MainView.lIndex3.setOnMouseClicked(e->{
				MainView.lHome.setTextFill(Color.GREY);
	            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
	            MainView.RemoveIndex();
				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
				MainView.UpdateIndex(MainView.lIndex2, "Finished Lists");
				MainView.UpdateIndex(MainView.lIndex3, "Finished Section Data");
				MainView.vbWorkSpace = SectionDataView.vbSectionDataView(sectionid,isfinish);
	            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
				
			});	
		}
		tStudentID = new TextField();
		tStudentID.setPromptText("Student ID");
		tStudentID.setPrefHeight(30);
		tStudentID.setFont(Font.font(15));

		tStudentName = new TextField();
		tStudentName.setPromptText("Student Name");
		tStudentName.setPrefHeight(30);
		tStudentName.setFont(Font.font(15));
		
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white;");

		hbFilterCon = new HBox();
		hbFilterCon.getChildren().addAll(tStudentID,tStudentName,btnRefresh);
		hbFilterCon.setSpacing(10);
	
		SectionStudentTable.tvSectionStudentLists(sectionid,isfinish);
		tvSectionStudent = SectionStudentTable.tvSectionStudentLists(sectionid,isfinish);
		data = FXCollections.observableArrayList(SectionStudentHandler.GetAllStudentBySection(sectionid));
		tvSectionStudent.setItems(data);
		
		
		vbSectionStudentListsView.getChildren().addAll(hbFilterCon,tvSectionStudent);
		vbSectionStudentListsView.setSpacing(5);
		vbSectionStudentListsView.setStyle("-fx-background-color:white");
		vbSectionStudentListsView.setPadding(new Insets(10,10,10,10));
		
		tStudentID.setOnKeyTyped(e->{
			tvSectionStudent.getItems().clear();
			data = FXCollections.observableArrayList(SectionStudentHandler.FilterSectionStudent(tStudentID.getText(),"",sectionid));
			tvSectionStudent.setItems(data);
		});
		
		tStudentName.setOnKeyTyped(e->{
			tvSectionStudent.getItems().clear();
			data = FXCollections.observableArrayList(SectionStudentHandler.FilterSectionStudent("",tStudentName.getText(),sectionid));
			tvSectionStudent.setItems(data);
		});
		
		btnRefresh.setOnAction(e->{
			tvSectionStudent.getItems().clear();
			data = FXCollections.observableArrayList(SectionStudentHandler.GetAllStudentBySection(sectionid));
			tvSectionStudent.setItems(data);
		});
		
		vbSectionStudentListsView.setPadding(new Insets(20,30,20,30));
		return vbSectionStudentListsView;
	}
}
