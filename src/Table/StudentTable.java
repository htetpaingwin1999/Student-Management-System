package Table;

import java.util.Date;

import List.StudentLists;
import List.StudentLists;
import View.AUDCourseView;
import View.AUDStudentView;
import View.CourseDataView;
import View.Login;
import View.MainView;
import View.StudentDataView;
import View.StudentListsView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class StudentTable {
	private static ObservableList<StudentLists> dataStudent = null;
	
	/*
	 * private String no;
	private String studentName;
	private String phoneNo;
	private String email;
	private String address;
	private String staffID;
	private String staffName;
	private Date addDate;
	 */
	private static TableColumn no,studentName,joinDate,phoneNo,address,staffName;
	private static TableView tvStudent;
	public static TableView tvStudentLists()
	{
		tvStudent	= new TableView<StudentLists>();
		tvStudent.setMaxWidth(Region.USE_PREF_SIZE);
		tvStudent.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setMinWidth(150);
		no.getStyleClass().add("Times New Roman,20");

		studentName=new TableColumn("Student Name");
		studentName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
		studentName.setMinWidth(150);
        studentName.getStyleClass().add("Times New Roman,20");

		
        joinDate=new TableColumn("Join Date");
		joinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
        joinDate.setMinWidth(150);
        joinDate.getStyleClass().add("Times New Roman,20");

		phoneNo=new TableColumn("Phone No");
		phoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
		phoneNo.setMinWidth(150);
        phoneNo.getStyleClass().add("Times New Roman,20");

		address=new TableColumn("Address");
		address.setCellValueFactory(new PropertyValueFactory<>("PresentAddress"));
		address.setMinWidth(165);
        address.getStyleClass().add("Times New Roman,20");
        
        staffName=new TableColumn("Staff Name");
		staffName.setCellValueFactory(new PropertyValueFactory<>("StaffName"));
		staffName.setMinWidth(150);
        staffName.getStyleClass().add("Times New Roman,20");
        
        TableColumn<StudentLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<StudentLists, Void>, TableCell<StudentLists, Void>> cellHB = new Callback<TableColumn<StudentLists, Void>, TableCell<StudentLists, Void>>() {
            @Override
            public TableCell<StudentLists, Void> call(final TableColumn<StudentLists, Void> param) {
                final TableCell<StudentLists, Void> cell = new TableCell<StudentLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");

                    	btnUpdate.setOnAction((ActionEvent event) -> {
                            StudentLists data = getTableView().getItems().get(getIndex());
            				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = AUDStudentView.vbAddStudentView(data.getStudentID(), data.getStudentName(), data.getPhoneNo(),data.getPresentAddress(),2);
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.lHome.setTextFill(Color.GREY);
            				MainView.UpdateIndex(MainView.lIndex1, "Student Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Update Student");
  
                        });
                    	btnDelete.setOnAction((ActionEvent event) -> {
                           Alert al= new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                           al.showAndWait();
                           if(al.getResult().equals(ButtonType.YES))
                           {
                        	   StudentLists data = getTableView().getItems().get(getIndex());
                               Handler.StudentHandler.Delete(data.getStudentID()+"");
                           	MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
               				MainView.vbWorkSpace = StudentListsView.vbStudentListsView();
               				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
               				MainView.lHome.setTextFill(Color.GREY);
                           }
                        });
                    	btnView.setOnAction((ActionEvent event) -> {
                            StudentLists data = getTableView().getItems().get(getIndex());

                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace =StudentDataView.vbStudentDataView(data.getStudentID()+"", data.getStudentName(), data.getJoinDate()+"", data.getPhoneNo(), data.getPresentAddress());
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.lHome.setTextFill(Color.GREY);
            				MainView.UpdateIndex(MainView.lIndex1, "Student Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Student Data");
                        });
                    	
                    	if(Login.userpos.equals("1"))
                    	{
                    	hbBtnCon.getChildren().addAll(btnView,btnUpdate,btnDelete);
                    	hbBtnCon.setSpacing(5);
                    	}
                    	else
                    	{
                    		hbBtnCon.getChildren().addAll(btnView,btnUpdate);
                        	hbBtnCon.setSpacing(5);
                        	joinDate.setMinWidth(163);
                        	staffName.setMinWidth(175);
                    	}
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
    	if(Login.userpos.equals("1"))
    	{
    		colActionBtn.setPrefWidth(123);
    	}
    	else
    	{
    		joinDate.setMinWidth(163);
        	staffName.setMinWidth(175);
    		colActionBtn.setPrefWidth(80);
    	}
        
		tvStudent.getColumns().addAll(no,studentName,phoneNo,address,staffName,joinDate,colActionBtn);
		tvStudent.setPrefSize(1060,558);
		return tvStudent;
	}
}
