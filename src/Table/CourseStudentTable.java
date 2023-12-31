package Table;

import List.CourseStudentLists;
import List.DepartmentLists;
import List.CourseStudentLists;
import List.CourseStudentLists;
import List.CourseStudentLists;
import List.CourseStudentLists;
import View.AUDCourseView;
import View.AUDSalaryPaymentView;
import View.AddPaymentView;
import View.CourseDataView;
import View.CourseStudentListsView;
import View.FeePaymentListsView;
import View.Login;
import View.MainView;
import View.SectionStudentListView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CourseStudentTable {
	private static ObservableList<CourseStudentLists> dataCourse = null;
	private static TableColumn no,courseName,courseFee,studentID,studentName,addDate,total,rest;
	private static TableView tvSectionStudent;
	public static int csid;
	public static int fee;
	public static TableView tvCourseStudent(int choose)
	{
		// choose 1 = delete , choose 2 = remove
		tvSectionStudent	= new TableView<CourseStudentLists>();
		tvSectionStudent.setMaxWidth(Region.USE_PREF_SIZE);
		tvSectionStudent.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setPrefWidth(140);
		no.getStyleClass().add("Times New Roman,20");

		courseFee=new TableColumn("Fee");
		courseFee.setCellValueFactory(new PropertyValueFactory<>("Fee"));
		courseFee.setPrefWidth(140);
		courseFee.getStyleClass().add("Times New Roman,20");

		courseName=new TableColumn("Course Name");
		courseName.setCellValueFactory(new PropertyValueFactory<>("Cname"));
		courseName.setPrefWidth(140);
		courseName.getStyleClass().add("Times New Roman,20");

		studentID=new TableColumn("Student ID");
		studentID.setCellValueFactory(new PropertyValueFactory<>("Stid"));
		studentID.setPrefWidth(140);
        studentID.getStyleClass().add("Times New Roman,20");

		studentName=new TableColumn("studentName");
		studentName.setCellValueFactory(new PropertyValueFactory<>("Stname"));
		studentName.setPrefWidth(140);
        studentName.getStyleClass().add("Times New Roman,20");
        
        total=new TableColumn("Total");
        total.setCellValueFactory(new PropertyValueFactory<>("Total"));
		total.setPrefWidth(140);
		total.getStyleClass().add("Times New Roman,20");
        
        rest=new TableColumn("Rest");
        rest.setCellValueFactory(new PropertyValueFactory<>("Rest"));
        rest.setPrefWidth(150);
        rest.getStyleClass().add("Times New Roman,20");

		addDate=new TableColumn("AddDate");
		addDate.setCellValueFactory(new PropertyValueFactory<>("AddDate"));
		addDate.setPrefWidth(148);
        addDate.getStyleClass().add("Times New Roman,20");
        
        TableColumn<CourseStudentLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<CourseStudentLists, Void>, TableCell<CourseStudentLists, Void>> cellHB = new Callback<TableColumn<CourseStudentLists, Void>, TableCell<CourseStudentLists, Void>>() {
            @Override
            public TableCell<CourseStudentLists, Void> call(final TableColumn<CourseStudentLists, Void> param) {
                final TableCell<CourseStudentLists, Void> cell = new TableCell<CourseStudentLists, Void>() {
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnRemove = new Button("",new ImageView(new Image("Icon/remove.png")));
                    private final Button btnPaid = new Button("",new ImageView(new Image("Icon/Paid.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnRemove.setStyle("-fx-background-color:white");
                    	btnPaid.setStyle("-fx-background-color:white");

                    	btnDelete.setOnAction(e->{
                    		CourseStudentLists st = getTableView().getItems().get(getIndex());
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                    		{
                         	   CourseStudentLists data = getTableView().getItems().get(getIndex());
                    			Handler.StudentPaymentHandler.DeleteStudentPaymentLists(data.getFpid());
                    			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
		         				MainView.vbWorkSpace = FeePaymentListsView.vbCourseStudentListsView();
		         				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                    		}
                    	});
                    	
                    	btnPaid.setOnAction(e->{
                    		CourseStudentLists st = getTableView().getItems().get(getIndex());
                    		AddPaymentView.vbShowRegisterView(st.getCsid(),st.getFee());                    		
                    	});
               
                    	btnRemove.setOnAction(e->{
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to remove from this course",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                    		{
                    			CourseStudentLists st = getTableView().getItems().get(getIndex());
                    			Handler.CourseStudentHandler.RemoveCourseStudent(st.getCsid());
                    			Handler.CourseStudentHandler.RemoveSection(st.getCfid(),st.getStid());
                    			Handler.StudentPaymentHandler.DeleEntirePayment(st.getCsid());
                    			MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
    	         				MainView.vbWorkSpace = CourseStudentListsView.vbCourseStudentListsView();
    	         				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                    		}
                    	});
               
                    	if(Login.userpos.equals("1"))
                    	{
                    		//choose == 1 for coursestudent (d) , choose == 2 for feepayment(d)
                    		if(choose == 1 )
                    		{
                        		hbBtnCon.getChildren().addAll(btnDelete);
                    		}
                    		else
                    		{
                        		hbBtnCon.getChildren().addAll(btnRemove);
                    		}
                        	tvSectionStudent.setPrefSize(1100,558);
                    		
                    	}
                    	else
                    	{
                		    hbBtnCon.getChildren().addAll(btnPaid);
                    		tvSectionStudent.setPrefSize(1080,558);
                    	}
                    	hbBtnCon.setSpacing(5);
                    	hbBtnCon.setPrefWidth(30);
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
       tvSectionStudent.getColumns().addAll(no,courseName,studentID,studentName,total,courseFee,addDate,colActionBtn);
        
		return tvSectionStudent;
	}
}
