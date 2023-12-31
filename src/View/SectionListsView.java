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
public class SectionListsView {
	private static VBox vbSectionListsView;
	private static Label lTitle;
	private static HBox hbTitleCon;
	private static TableView tvSection;
	private static BorderPane bp;
	private static TextField tCourseName;
	private static Button btnRefresh;
	private static HBox hbFilterCon;
	private static Button btnAdd;
	private static Button btnFinishedSection;
	private static VBox vbSectionListsCon;
	private static ObservableList<SectionLists> data;
	public static VBox vbSectionListsView()
	{
		vbSectionListsView = new VBox();
		
		lTitle = new Label("Section Lists");
		lTitle.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		
		hbTitleCon = new HBox();
		hbTitleCon.setPrefSize(1080,50);
		hbTitleCon.getChildren().add(lTitle);
		Style.HBoxFillColorAndSizeAndPadding(hbTitleCon, "white", 15, 50, 0);
		
		bp = new BorderPane();
		
		tCourseName = new TextField();
		Style.TextFieldFill(tCourseName, "Course Name", 50, 18);
	
		btnRefresh = new Button("",new ImageView(new Image("Icon/Refresh.png")));
		btnRefresh.setStyle("-fx-background-color:white");

		btnAdd = new Button("Add New Section", new ImageView (new Image("Icon/Plus16.png")));
		Style.BtnAdd(btnAdd);
		
		btnFinishedSection = new Button("Fnished Section");
		Style.BtnAdd(btnFinishedSection);
		btnFinishedSection.setStyle("-fx-background-color:blue");
		btnFinishedSection.setPrefWidth(180);
		
		hbFilterCon = new HBox();
		if(Login.userpos.equals("1"))
		{
			hbFilterCon.getChildren().addAll(btnFinishedSection,tCourseName,btnRefresh,btnAdd);
		}
		else
		{
			hbFilterCon.getChildren().addAll(tCourseName,btnRefresh);
		}
		Style.HBoxFillColorAndSizeAndPadding(hbFilterCon, "white", 10, 10, 10);
		
		bp.setRight(hbFilterCon);
		bp.setStyle("-fx-background-color:white");
		
		SectionTable.tvSectionLists(0);
		tvSection = SectionTable.tvSectionLists(0);
		data = FXCollections.observableArrayList(SectionHandler.GetAllSection(0));
		tvSection.setItems(data);
		
		btnRefresh.setOnAction(e->{
			data = FXCollections.observableArrayList(SectionHandler.GetAllSection(0));
			tvSection.setItems(data);	
		});
		
		
		tCourseName.setOnKeyTyped(e->{
			tvSection.getItems().clear();
			data = FXCollections.observableArrayList(SectionHandler.FilterSection(tCourseName.getText(),0));
			tvSection.setItems(data);
			
		});
		
		btnFinishedSection.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = FinishedSectionListsView.vbSectionListsView();
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
			MainView.UpdateIndex(MainView.lIndex2, "Finished Section Lists");
		});
		
		vbSectionListsCon = new VBox();
		vbSectionListsCon.getChildren().addAll(bp,tvSection);
		Style.VBoxFillColorAndSizeAndPadding(vbSectionListsCon, "white", 10, 10, 10);
		
		btnAdd.setOnAction(e->{
			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
			MainView.vbWorkSpace = AUDSectionView.vbAddSectionView(0, "", "", "", "", "", "", "", "", 1,0);
			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
			MainView.RemoveIndex();
			MainView.UpdateIndex(MainView.lIndex1, "Add New Section");
		});
		
		vbSectionListsView.getChildren().addAll(hbTitleCon,vbSectionListsCon);
		Style.VBoxFillColorAndSizeAndPadding(vbSectionListsCon, "white", 10, 0, 5);

		return vbSectionListsView;
	}
}
