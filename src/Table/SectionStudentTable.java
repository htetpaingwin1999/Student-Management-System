package Table;

import List.SectionStudentLists;
import List.SectionStudentLists;
import List.SectionStudentLists;
import List.SectionStudentLists;
import View.AUDCourseView;
import View.AUDSalaryPaymentView;
import View.CourseDataView;
import View.Login;
import View.MainView;
import View.SectionStudentListView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class SectionStudentTable {
	private static ObservableList<SectionStudentLists> dataCourse = null;
	private static TableColumn ssid,studentID,studentName,staffName,addDate,staffID;
	private static TableView tvSectionStudent;
	public static TableView tvSectionStudentLists(int id,int isfinish)
	{
		// choose 1 = admin, choose 2 = staff, choose 3 = history 
		tvSectionStudent	= new TableView<SectionStudentLists>();
		tvSectionStudent.setMaxWidth(Region.USE_PREF_SIZE);
		tvSectionStudent.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		ssid = new TableColumn("No");
		ssid.setCellValueFactory(new PropertyValueFactory<>("No"));
		ssid.setMinWidth(150);
		ssid.getStyleClass().add("Times New Roman,20");

		studentID=new TableColumn("Student ID");
		studentID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
		studentID.setMinWidth(150);
        studentID.getStyleClass().add("Times New Roman,20");

		studentName=new TableColumn("studentName");
		studentName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
		studentName.setMinWidth(155);
        studentName.getStyleClass().add("Times New Roman,20");

        staffName=new TableColumn("Staff Name");
		staffName.setCellValueFactory(new PropertyValueFactory<>("StaffName"));
        staffName.setMinWidth(170);
        staffName.getStyleClass().add("Times New Roman,20");

		addDate=new TableColumn("AddDate");
		addDate.setCellValueFactory(new PropertyValueFactory<>("AddDate"));
		addDate.setMinWidth(152);
        addDate.getStyleClass().add("Times New Roman,20");

		staffID=new TableColumn("Staff ID");
		staffID.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
		staffID.setMinWidth(161);
        staffID.getStyleClass().add("Times New Roman,20");
        
        TableColumn<SectionStudentLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<SectionStudentLists, Void>, TableCell<SectionStudentLists, Void>> cellHB = new Callback<TableColumn<SectionStudentLists, Void>, TableCell<SectionStudentLists, Void>>() {
            @Override
            public TableCell<SectionStudentLists, Void> call(final TableColumn<SectionStudentLists, Void> param) {
                final TableCell<SectionStudentLists, Void> cell = new TableCell<SectionStudentLists, Void>() {
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnDelete.setStyle("-fx-background-color:white");
                    	
                    	btnDelete.setOnAction(e->{
                    		SectionStudentLists st = getTableView().getItems().get(getIndex());
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delte",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                    		{
                    			Handler.SectionStudentHandler.Delete(st.getSsid());
                    			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
		         				MainView.vbWorkSpace = SectionStudentListView.vbSectionStudentListsView(id,isfinish);
		         				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                    		}
                    	});
               
                    	hbBtnCon.getChildren().addAll(btnDelete);
                    	hbBtnCon.setSpacing(5);
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(hbBtnCon);
                        }
                    }
                };
                return cell;
            }
        };
        colActionBtn.setCellFactory(cellHB);
        colActionBtn.setPrefWidth(50);
       if(Login.userpos.equals("1"))
       {
       tvSectionStudent.getColumns().addAll(ssid,studentID,studentName,addDate,staffID,staffName,colActionBtn);
	   tvSectionStudent.setPrefSize(990,558);
       }
       else
       {
    	   tvSectionStudent.getColumns().addAll(ssid,studentID,studentName,addDate,staffID,staffName);
    	   tvSectionStudent.setPrefSize(940,558);   
       }
		return tvSectionStudent;
	}
}
