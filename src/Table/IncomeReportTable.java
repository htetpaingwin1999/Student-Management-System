package Table;

import List.IncomeReportLists;
import List.IncomeReportLists;
import View.AUDCourseView;
import View.CourseDataView;
import View.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class IncomeReportTable {
	private static TableColumn no,addDate,amount;
	public static TableColumn courseName;
	private static TableView tvReport;
	public static TableView tvReportLists()
	{
		tvReport	= new TableView<IncomeReportLists>();
		tvReport.setMaxWidth(Region.USE_PREF_SIZE);
		tvReport.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("ID");
		no.setCellValueFactory(new PropertyValueFactory<>("Id"));
		no.setMinWidth(200);
		no.setResizable(false);

		addDate=new TableColumn("Date");
		addDate.setCellValueFactory(new PropertyValueFactory<>("AddDate"));
		addDate.setMinWidth(200);
        addDate.setResizable(false);

		amount=new TableColumn("Amount");
		amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
		amount.setMinWidth(200);
        amount.setResizable(false);
        
        courseName=new TableColumn("Course Name");
		courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
		courseName.setMinWidth(200);
        courseName.setResizable(false);

		tvReport.getColumns().addAll(no,addDate,courseName,amount);
		tvReport.setPrefSize(802,300);
		
		return tvReport;
	}
}
