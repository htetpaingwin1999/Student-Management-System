package Table;

import List.CourseLists;
import List.CourseLists;
import View.AUDCourseView;
import View.CourseDataView;
import View.CourseListsView;
import View.Login;
import View.MainView;
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

public class CourseTable {
	private static ObservableList<CourseLists> dataCourse = null;
	private static TableColumn no,courseName,courseFee,courseUpdateDate,adminID,adminName;
	private static TableView tvCourse;
	public static TableView tvCourseLists(int choose)
	{
		// choose 1 = admin, choose 2 = staff, choose 3 = history 
		tvCourse	= new TableView<CourseLists>();
		tvCourse.setMaxWidth(Region.USE_PREF_SIZE);
		tvCourse.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setMinWidth(150);
		no.getStyleClass().add("Times New Roman,20");

		courseName=new TableColumn("Course Name");
		courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
		courseName.setMinWidth(152);
        courseName.getStyleClass().add("Times New Roman,20");

		courseFee=new TableColumn("courseFee");
		courseFee.setCellValueFactory(new PropertyValueFactory<>("CourseFee"));
		courseFee.setMinWidth(150);
        courseFee.getStyleClass().add("Times New Roman,20");

        courseUpdateDate=new TableColumn("Date");
		courseUpdateDate.setCellValueFactory(new PropertyValueFactory<>("DefinedDate"));
        courseUpdateDate.setMinWidth(150);
        courseUpdateDate.getStyleClass().add("Times New Roman,20");

		adminID=new TableColumn("Admin ID");
		adminID.setCellValueFactory(new PropertyValueFactory<>("AdminID"));
		adminID.setMinWidth(150);
        adminID.getStyleClass().add("Times New Roman,20");

		adminName=new TableColumn("Admin Name");
		adminName.setCellValueFactory(new PropertyValueFactory<>("AdminName"));
		adminName.setMinWidth(150);
        adminName.getStyleClass().add("Times New Roman,20");

        TableColumn<CourseLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<CourseLists, Void>, TableCell<CourseLists, Void>> cellHB = new Callback<TableColumn<CourseLists, Void>, TableCell<CourseLists, Void>>() {
            @Override
            public TableCell<CourseLists, Void> call(final TableColumn<CourseLists, Void> param) {
                final TableCell<CourseLists, Void> cell = new TableCell<CourseLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");

                    	btnUpdate.setOnAction((ActionEvent event) -> {
                            CourseLists data = getTableView().getItems().get(getIndex());
            				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                            MainView.vbWorkSpace = AUDCourseView.vbAddCourseView(data.getCourseID(),data.getCourseName(),data.getCourseFee()+"",2);
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                        });
                    	btnDelete.setOnAction((ActionEvent event) -> {
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
            				{
                    			 CourseLists data = getTableView().getItems().get(getIndex()); 
                                 Handler.CourseHandler.DeleteCourse(data.getCourseID());
                                 MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                 MainView.vbWorkSpace =CourseListsView.vbCourseListsView(Login.userid,Login.userpos);
                 				 MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace); 
            				}                   
                        });
                    	btnView.setOnAction((ActionEvent event) -> {
                            CourseLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = CourseDataView.vbCourseDataView(data.getCourseID(), data.getCourseName(), data.getCourseFee(), data.getAdminID(), data.getAdminName(), data.getDefinedDate()+"");
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                        });
                    	hbBtnCon.getChildren().addAll(btnView,btnUpdate,btnDelete);
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
        
        if(choose == 1)
        { 
        	tvCourse.getColumns().addAll(no,courseName,courseFee,adminID,adminName,courseUpdateDate,colActionBtn);
        	tvCourse.setPrefSize(1026,558);
        }
        
        if(choose == 2)
        { 
    		no.setMinWidth(256);
    		courseFee.setMinWidth(254);
    		courseName.setMinWidth(257);
    		courseUpdateDate.setMinWidth(251);
        	tvCourse.getColumns().addAll(no,courseName,courseFee,courseUpdateDate);
        	tvCourse.setPrefSize(1020,558);
        }
		return tvCourse;
	}
}
