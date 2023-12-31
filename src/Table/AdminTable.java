package Table;

import java.util.Date;

import List.AdminLists;
import List.StaffLists;
import View.AUDAdminView;
import View.MainView;
import View.StaffListsView;
import View.AdminDataView;
import View.AdminListsView;
import View.Login;
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

public class AdminTable {

	private static TableColumn no,adminName,joinDate,email,dateofBirth,phoneNo,presentAddress,password;
	private static TableView tvadmin;
	public static TableView tvAdminLists(int status)
	{
		//status 0  current
		//status 2 suspend
		//status 1 delete
		tvadmin	= new TableView<AdminLists>();
		tvadmin.setMaxWidth(Region.USE_PREF_SIZE);
		tvadmin.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setPrefWidth(50);
		no.setResizable(false);

		adminName=new TableColumn("Admin Name");
		adminName.setCellValueFactory(new PropertyValueFactory<>("AdminName"));
		adminName.setPrefWidth(114);
        adminName.setResizable(false);

		joinDate=new TableColumn("Join Date");
		joinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
		joinDate.setPrefWidth(114);
        joinDate.setResizable(false);

        email=new TableColumn("Email");
		email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        email.setPrefWidth(125);
        email.setResizable(false);
        
        dateofBirth=new TableColumn("Date of Birth");
        dateofBirth.setCellValueFactory(new PropertyValueFactory<>("DateofBirth"));
        dateofBirth.setPrefWidth(113);
        dateofBirth.setResizable(false);

		phoneNo=new TableColumn("Phone No");
		phoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));
		phoneNo.setPrefWidth(113);
		phoneNo.setResizable(false);
		
		password=new TableColumn("Password");
		password.setCellValueFactory(new PropertyValueFactory<>("Password"));
		password.setPrefWidth(124);
		password.setResizable(false);
		
		presentAddress=new TableColumn("Present Address");
		presentAddress.setCellValueFactory(new PropertyValueFactory<>("PresentAddress"));
		presentAddress.setPrefWidth(113);
		presentAddress.setResizable(false);

		TableColumn<AdminLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<AdminLists, Void>, TableCell<AdminLists, Void>> cellHB = new Callback<TableColumn<AdminLists, Void>, TableCell<AdminLists, Void>>() {
            @Override
            public TableCell<AdminLists, Void> call(final TableColumn<AdminLists, Void> param) {
                final TableCell<AdminLists, Void> cell = new TableCell<AdminLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final Button btnRemove = new Button("",new ImageView(new Image("Icon/block.png")));
                    private final Button btnRestore = new Button("",new ImageView(new Image("Icon/backup.png")));

                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");
                    	btnRemove.setStyle("-fx-background-color:white");
                    	btnRestore.setStyle("-fx-background-color:white");
                    	
                    	btnUpdate.setOnAction((ActionEvent event) -> {
                            AdminLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = AUDAdminView.vbAddAdminView(data.getEmail(),data.getAdminName(),data.getJoinDate()+"",data.getGender(),data.getDateofBirth()+"",data.getPhoneNo(),data.getPresentAddress(),data.getPassword(),data.getUserName(),2,data.getAdminID());
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace); 
                    	});
                    	
                    	btnDelete.setOnAction((ActionEvent event) -> {
                            AdminLists data = getTableView().getItems().get(getIndex());
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                            
                            if(al.getResult() == ButtonType.YES)
                            {
                            	if(data.getAdminID()!=1)
                            	{
                            		Handler.AdminHandler.DeleteAdmin(data.getAdminID()+"");
     	                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
     	            				MainView.vbWorkSpace = AdminListsView.vbAdminListsView();
     	            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                               	}
                            	else
                            	{
                            		Alert alerror = new Alert(AlertType.ERROR,"You can't delete owner admin data");
                            		alerror.showAndWait();
                            	}
                               }
                        });
                    	btnView.setOnAction((ActionEvent event) -> {
                            AdminLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = AdminDataView.vbAdminDataView(data.getEmail()+"",data.getAdminName(),data.getJoinDate()+"",data.getGender(),data.getDateofBirth()+"",data.getPhoneNo(),data.getPresentAddress(),data.getPassword(),data.getUserName(),true,0);
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();
            				MainView.UpdateIndex(MainView.lIndex1, "Admin Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Admin Data");
 
            				
                        });
                    	btnRemove.setOnAction((ActionEvent event) -> {
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to suspend account",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                             {
                                AdminLists data = getTableView().getItems().get(getIndex());
                    			if(data.getAdminID()!=1)
                            	{
                    				 data = getTableView().getItems().get(getIndex());
                                     Handler.AccountHandler.SuspendAdminAccount(data.getAdminID()+"",2);
                                     MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                     MainView.vbWorkSpace =AdminListsView.vbAdminListsView();
                                     MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                            	}
                    			else
                            	{
                            		Alert alerror = new Alert(AlertType.ERROR,"You can't suspend owner admin data");
                            		alerror.showAndWait();
                            	}
                    			
                               	                     	
                             }
                    		                          
                        });
                    	
                    	btnRestore.setOnAction((ActionEvent event) -> {
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to allow this account",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                             {
                                AdminLists data = getTableView().getItems().get(getIndex());
                                Handler.AccountHandler.SuspendAdminAccount(data.getAdminID()+"",0);
                                MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                MainView.vbWorkSpace =AdminListsView.vbAdminListsView();
                                MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                    			MainView.RemoveIndex();
                				MainView.UpdateIndex(MainView.lIndex1, "Admin Lists");                              	
                             }
                    		                          
                        });
                    	
                    	if(status == 0)
                    	{
                    		if(Login.userid.equals("1"))
                        	{
                            	hbBtnCon.getChildren().addAll(btnView,btnUpdate,btnDelete,btnRemove);
                        	}
                    		colActionBtn.setPrefWidth(142);
                    		presentAddress.setPrefWidth(120);

//                        	else
//                        	{
//                            	hbBtnCon.getChildren().addAll(btnView);
//                            	colActionBtn.setPrefWidth(38);
//                        		presentAddress.setPrefWidth(224);
//                        	}
                    	}
                    	else
                    	{
                    		hbBtnCon.getChildren().addAll(btnRestore);
                    		presentAddress.setPrefWidth(224);
                        	colActionBtn.setPrefWidth(38);
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
        if(status != 0)
        {
    		presentAddress.setPrefWidth(224);
        	colActionBtn.setPrefWidth(38);
        }
        colActionBtn.setResizable(false);

        
        if(Login.userid.equals("1"))
        {
    		tvadmin.getColumns().addAll(no,adminName,email,password,joinDate,dateofBirth,phoneNo,presentAddress,colActionBtn);
        }
        else
        {
    		tvadmin.getColumns().addAll(no,adminName,joinDate,email,dateofBirth,phoneNo,presentAddress,colActionBtn);
        }
		tvadmin.setPrefSize(1017,558);
		return tvadmin;
	}
}
