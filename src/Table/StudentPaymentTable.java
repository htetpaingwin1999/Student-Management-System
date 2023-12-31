package Table;

import java.util.Date;

import List.StudentPaymentLists;
import List.StudentPaymentLists;
import List.StudentPaymentLists;
import View.AUDCourseView;
import View.AUDSalaryPaymentView;
import View.AUDStaffView;
import View.CourseDataView;
import View.Login;
import View.MainView;
import View.StaffDataView;
import View.StudentPaymentListsView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class StudentPaymentTable {
	private static ObservableList<StudentPaymentLists> dataStudent = null;
	private static TableColumn studentID,studentName,addDate,courseName,paidAmount,staffID,courseFee,staffName;
	private static TableView tvStudentPayment;
	
	public static TableView tvStudentPaymentLists()
	{
		tvStudentPayment	= new TableView<StudentPaymentLists>();
		tvStudentPayment.setMaxWidth(Region.USE_PREF_SIZE);
		tvStudentPayment.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		studentID = new TableColumn("Student ID");
		studentID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
		studentID.setPrefWidth(120.8);
		studentID.setResizable(false);

		studentName=new TableColumn("Student Name");
		studentName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
		studentName.setPrefWidth(120.8);
        studentName.setResizable(false);

        addDate=new TableColumn("Add Date");
		addDate.setCellValueFactory(new PropertyValueFactory<>("AddDate"));
        addDate.setPrefWidth(120.8);
        addDate.setResizable(false);

		courseName=new TableColumn("Course Name");
		courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
		courseName.setPrefWidth(120.8);
        courseName.setResizable(false);
        
        courseFee=new TableColumn("Fee");
		courseFee.setCellValueFactory(new PropertyValueFactory<>("CourseFee"));
		courseFee.setPrefWidth(120.8);
        courseFee.setResizable(false);

		paidAmount=new TableColumn("Paid Amount");
		paidAmount.setCellValueFactory(new PropertyValueFactory<>("PaidAmount"));
		paidAmount.setPrefWidth(120.8);
        paidAmount.setResizable(false);
       
        staffID=new TableColumn("StaffID");
		staffID.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
		staffID.setPrefWidth(120.8);
        staffID.setResizable(false);
        
        staffName=new TableColumn("Staff Name");
        staffName.setCellValueFactory(new PropertyValueFactory<>("StaffName"));
        staffName.setMinWidth(121);
        staffName.setResizable(false);
        
        
        TableColumn<StudentPaymentLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<StudentPaymentLists, Void>, TableCell<StudentPaymentLists, Void>> cellHB = new Callback<TableColumn<StudentPaymentLists, Void>, TableCell<StudentPaymentLists, Void>>() {
            @Override
            public TableCell<StudentPaymentLists, Void> call(final TableColumn<StudentPaymentLists, Void> param) {
                final TableCell<StudentPaymentLists, Void> cell = new TableCell<StudentPaymentLists, Void>() {

                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnDelete.setStyle("-fx-background-color:white");

                    	btnDelete.setOnAction((ActionEvent event) -> {
                            StudentPaymentLists data = getTableView().getItems().get(getIndex());
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                            if(al.getResult() == ButtonType.YES)
                            {
                            	Handler.StudentPaymentHandler.DeleteStudentPaymentLists(data.getFpid());
                                MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                MainView.vbWorkSpace =StudentPaymentListsView.vbStudentPaymentListsView();
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
        
        if(Login.userpos.equals(1))
        {
	        tvStudentPayment.getColumns().addAll(studentID,studentName,courseName,courseFee,paidAmount,addDate,staffID,staffName,colActionBtn);
        }
        else
        {
    		courseName.setPrefWidth(150.8);
        	tvStudentPayment.getColumns().addAll(studentID,studentName,courseName,courseFee,paidAmount,addDate,staffID,staffName);
        }
        tvStudentPayment.setPrefWidth(1017);
        return tvStudentPayment;
	}
}
