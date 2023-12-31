package Table;

import java.util.Date;

import List.StaffLists;
import List.StaffLists;
import View.AUDSalaryPaymentView;
import View.AUDStaffView;
import View.CourseListsView;
import View.StaffDataView;
import View.StaffListsView;
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

public class StaffTable {
	private static ObservableList<StaffLists> datastaff = null;
	private static TableColumn no,staffName,joinDate,email,phoneNo,presentAddress,password,designation,department,salary,definedDate;
	private static TableView tvstaff;
	public static TableView tvStaffLists(int choose)
	{
		// choose 1 = admin , choose 2 = salary history and designation history // choose == 3 susepnd account list
		tvstaff	= new TableView<StaffLists>();
		tvstaff.setMaxWidth(Region.USE_PREF_SIZE);
		tvstaff.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setPrefWidth(50);
		no.getStyleClass().add("Times New Roman,20");
		no.setResizable(false);

		staffName=new TableColumn("Staff Name");
		staffName.setCellValueFactory(new PropertyValueFactory<>("StaffName"));
		staffName.setPrefWidth(127);
        staffName.getStyleClass().add("Times New Roman,20");
        staffName.setResizable(false);

		joinDate=new TableColumn("Join Date");
		joinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
		joinDate.setPrefWidth(146);
        joinDate.getStyleClass().add("Times New Roman,20");
        joinDate.setResizable(false);

        email=new TableColumn("Email");
		email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        email.setPrefWidth(127);
        email.getStyleClass().add("Times New Roman,20");
        email.setResizable(false);
   
		phoneNo=new TableColumn("Phone No");
		phoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
		phoneNo.setPrefWidth(127);
		phoneNo.getStyleClass().add("Times New Roman,20");
		phoneNo.setResizable(false);

		password=new TableColumn("Password");
		password.setCellValueFactory(new PropertyValueFactory<>("Password"));
		password.setPrefWidth(127);
		password.getStyleClass().add("Times New Roman,20");
		password.setResizable(false);

		presentAddress=new TableColumn("Present Address");
		presentAddress.setCellValueFactory(new PropertyValueFactory<>("PresentAddress"));
		presentAddress.setPrefWidth(127);
		presentAddress.getStyleClass().add("Times New Roman,20");
		presentAddress.setResizable(false);

		designation=new TableColumn("Designation");
		designation.setCellValueFactory(new PropertyValueFactory<>("Designation"));
		designation.setPrefWidth(127);
		designation.getStyleClass().add("Times New Roman,20");
		designation.setResizable(false);

		salary = new TableColumn("Salary");
		salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
		salary.setPrefWidth(146);
		salary.getStyleClass().add("Times New Roman,20");
		salary.setResizable(false);

		definedDate = new TableColumn("Date");
		definedDate.setCellValueFactory(new PropertyValueFactory<>("DefinedDate"));
		definedDate.setPrefWidth(146);
		definedDate.getStyleClass().add("Times New Roman,20");
		definedDate.setResizable(false);


		TableColumn<StaffLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<StaffLists, Void>, TableCell<StaffLists, Void>> cellHB = new Callback<TableColumn<StaffLists, Void>, TableCell<StaffLists, Void>>() {
            @Override
            public TableCell<StaffLists, Void> call(final TableColumn<StaffLists, Void> param) {
                final TableCell<StaffLists, Void> cell = new TableCell<StaffLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final Button btnPaid = new Button("",new ImageView(new Image("Icon/Paid.png")));
                    private final Button btnRemove = new Button("",new ImageView(new Image("Icon/block.png")));
                    private final Button btnRestore = new Button("",new ImageView(new Image("Icon/backup.png")));

                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");
                    	btnPaid.setStyle("-fx-background-color:white");
                    	btnRemove.setStyle("-fx-background-color:white");
                    	btnRestore.setStyle("-fx-background-color:white");

                    	btnUpdate.setOnAction((ActionEvent event) -> {
                            StaffLists st = getTableView().getItems().get(getIndex());
                            StaffLists data = Handler.StaffHandler.GetStaffData(st.getStaffID());
            				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = AUDStaffView.vbAddStaffView(data.getEmail(), data.getStaffName(), data.getJoinDate()+"", data.getGender(), data.getDateofBirth()+"", data.getPhoneNo(), data.getPresentAddress(), data.getPassword(), data.getSalary()+"",data.getDesignation(),data.getUserName(),2,st.getStaffID());
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();
            				MainView.UpdateIndex(MainView.lIndex1, "Staff Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Update Staff Data");

            				});
                    	btnPaid.setOnAction((ActionEvent event) -> {
                            StaffLists data = getTableView().getItems().get(getIndex()); 
                            if(Handler.SalaryHandler.isPaidThisMonth(data.getStaffID()+""))
                            {
                            	Alert al = new Alert(AlertType.INFORMATION,"This staff has been paid for this month");
                            	al.showAndWait();
                            }
                            else
                            {
	            				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
	            				MainView.vbWorkSpace = AUDSalaryPaymentView.AddSalaryView(data.getStaffID()+"",data.getEmail(), data.getStaffName(), data.getSalary()+"","",1,0,"",2);
	            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
	            				MainView.lHome.setTextFill(Color.GREY);
	            				MainView.RemoveIndex();
	            				MainView.UpdateIndex(MainView.lIndex1, "Salary Lists");
	            				MainView.UpdateIndex(MainView.lIndex2, "Add New Salary Payment");
                            }
            				});
                    	btnDelete.setOnAction((ActionEvent event) -> {
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                            if(al.getResult() == ButtonType.YES)
                            {
                                StaffLists data = getTableView().getItems().get(getIndex());
                            	Handler.StaffHandler.DeleteStaff(data.getStaffID());
                                MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                MainView.vbWorkSpace =StaffListsView.vbStaffListsView();
                   				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);  	
                            }
                        });
                    	btnView.setOnAction((ActionEvent event) -> {
                            StaffLists data = getTableView().getItems().get(getIndex());     
                            StaffLists st = Handler.StaffHandler.GetStaffData(data.getStaffID());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                            MainView.vbWorkSpace = StaffDataView.vbStaffDataView(st.getStaffID()+"", st.getStaffName(), st.getJoinDate()+"", st.getGender(), st.getDateofBirth()+"", st.getPhoneNo(), st.getPresentAddress(), st.getPassword(), st.getDesignation(), st.getSalary()+"",st.getUserName(),st.getEmail(),0); 
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();
            				MainView.UpdateIndex(MainView.lIndex1, "Staff Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Staff Data");
                       
                        });
                    	btnRemove.setOnAction((ActionEvent event) -> {
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to suspend account",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                             {
                    			StaffLists data = getTableView().getItems().get(getIndex());
                                Handler.AccountHandler.SuspendStaffAccount(data.getStaffID()+"",-1);
                                MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                MainView.vbWorkSpace =StaffListsView.vbStaffListsView();
                                MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);                            	
                             }
                    		                          
                        });
                    	
                    	btnRestore.setOnAction((ActionEvent event) -> {
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to allow this account",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                             {
                    			StaffLists data = getTableView().getItems().get(getIndex());
                                Handler.AccountHandler.SuspendStaffAccount(data.getStaffID()+"",0);
                                MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                MainView.vbWorkSpace =StaffListsView.vbStaffListsView();
                                MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                    			MainView.RemoveIndex();
                				MainView.UpdateIndex(MainView.lIndex2, "Staff Lists");                             
                			}
                                    
                        });
                    	
                    	if(choose == 1 )
                    	{
                        	hbBtnCon.getChildren().addAll(btnView,btnUpdate,btnPaid,btnDelete,btnRemove);
                            colActionBtn.setPrefWidth(190);
                    	}
                    	if(choose == 2)
                    	{
                        	hbBtnCon.getChildren().addAll(btnView);
                            colActionBtn.setPrefWidth(38);
                    	}
                    	
                    	if(choose == 3)
                    	{
                        	hbBtnCon.getChildren().addAll(btnRestore);
                            colActionBtn.setPrefWidth(38);
	
                    	}
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
            colActionBtn.setPrefWidth(190);
        }
        colActionBtn.setResizable(false);
        if(choose == 1)
        {
        	joinDate.setPrefWidth(70);
        	salary.setPrefWidth(70);
        	tvstaff.getColumns().addAll(no,staffName,joinDate,email,phoneNo,presentAddress,designation,salary,colActionBtn);
    		tvstaff.setPrefSize(1017,558);
        }
        if(choose == 3)
        {
            colActionBtn.setPrefWidth(38);
        	tvstaff.getColumns().addAll(no,staffName,joinDate,email,phoneNo,presentAddress,designation,salary,colActionBtn);
    		tvstaff.setPrefSize(1017,558);
        }
        if(choose == 2)
        {
            colActionBtn.setPrefWidth(38);
        	designation.setPrefWidth(339);
        	definedDate.setPrefWidth(337);
        	salary.setPrefWidth(339);
        	tvstaff.getColumns().addAll(designation,salary,definedDate);
    		tvstaff.setPrefSize(1017,228);
        }
		return tvstaff;
	}
}
