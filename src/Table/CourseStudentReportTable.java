package Table;

import List.IncomeReportLists;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

public class CourseStudentReportTable {
	private static TableColumn no,qty;
	public static TableColumn courseName;
	private static TableView tvReport;
	public static TableView tvReportLists()
	{
		tvReport	= new TableView<IncomeReportLists>();
		tvReport.setMaxWidth(Region.USE_PREF_SIZE);
		tvReport.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setMinWidth(200);
		no.setResizable(false);

		
		qty=new TableColumn("No of Student");
		qty.setCellValueFactory(new PropertyValueFactory<>("No"));
		qty.setMinWidth(200);
        qty.setResizable(false);
        
        courseName=new TableColumn("Course Name");
		courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
		courseName.setMinWidth(200);
        courseName.setResizable(false);

		tvReport.getColumns().addAll(no,courseName,qty);
		tvReport.setPrefSize(602,300);
		return tvReport;
	}
}
