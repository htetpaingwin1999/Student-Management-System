package Table;

import java.util.Date;

import List.CourseLists;
import List.SalaryLists;
import List.StaffLists;
import List.SalaryLists;
import View.AUDSalaryPaymentView;
import View.MainView;
import View.SalaryListsOrPaymentListsView;
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

public class SalaryTable {
	private static TableColumn no,staffName,payDate,salary,amount,note,adminID,adminName;
	private static TableView tvSalryPayment;
	public static TableView tvSalaryLists()
	{
		 //choose 1 for staff salary, choose 2 for salary history
		
		tvSalryPayment	= new TableView<SalaryLists>();
		tvSalryPayment.setMaxWidth(Region.USE_PREF_SIZE);
		tvSalryPayment.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setPrefWidth(50);
		no.setResizable(false);

		staffName=new TableColumn("Staff Name");
		staffName.setCellValueFactory(new PropertyValueFactory<>("StaffName"));
		staffName.setPrefWidth(128.5);
        staffName.setResizable(false);

		payDate=new TableColumn("Pay Date");
		payDate.setCellValueFactory(new PropertyValueFactory<>("PayDate"));
		payDate.setPrefWidth(128.5);
        payDate.setResizable(false);

        salary=new TableColumn("Salary");
		salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        salary.setPrefWidth(122);
        salary.setResizable(false);
        
        amount=new TableColumn("Amount");
        amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        amount.setPrefWidth(122);
        amount.setResizable(false);

		note=new TableColumn("Note");
		note.setCellValueFactory(new PropertyValueFactory<>("Note"));
		note.setPrefWidth(128.5);
		note.setResizable(false);

		adminName=new TableColumn("Admin Name");
		adminName.setCellValueFactory(new PropertyValueFactory<>("AdminName"));
		adminName.setPrefWidth(128.5);
		adminName.setResizable(false);
		
		adminID=new TableColumn("Admin ID");
		adminID.setCellValueFactory(new PropertyValueFactory<>("AdminID"));
		adminID.setPrefWidth(128.5);
		adminID.setResizable(false);
		
		TableColumn<SalaryLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<SalaryLists, Void>, TableCell<SalaryLists, Void>> cellHB = new Callback<TableColumn<SalaryLists, Void>, TableCell<SalaryLists, Void>>() {
            @Override
            public TableCell<SalaryLists, Void> call(final TableColumn<SalaryLists, Void> param) {
                final TableCell<SalaryLists, Void> cell = new TableCell<SalaryLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	
                    	btnUpdate.setOnAction((ActionEvent event) -> {
                    		SalaryLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                            System.out.print(data.getSalary());
                            
              				MainView.vbWorkSpace = AUDSalaryPaymentView.AddSalaryView("",data.getStaffEmail()+"", data.getStaffName(), data.getSalary()+"",data.getAmount()+"",2,data.getMeid(),data.getNote()+"",2);
              				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);  
              				MainView.RemoveIndex();
              				MainView.UpdateIndex(MainView.lIndex1, "Salary Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Update Salary Data");
                    	});

                    
                    	btnDelete.setOnAction(e->{
                    		SalaryLists st = getTableView().getItems().get(getIndex());
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delte",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
                    		{
		                		Handler.SalaryHandler.DeleteSalary(st.getMeid());
		                		MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
		         				MainView.vbWorkSpace = SalaryListsOrPaymentListsView.vbSalaryPaymentListsView(1);
		         				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                    		}
                    	});
               
                    	hbBtnCon.getChildren().addAll(btnUpdate,btnDelete);
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
        colActionBtn.setPrefWidth(76);
         
    	tvSalryPayment.getColumns().addAll(no,staffName,payDate,salary,amount,adminID,adminName,note,colActionBtn);
		tvSalryPayment.setPrefSize(1017,558);
       
		return tvSalryPayment;
	}
}
