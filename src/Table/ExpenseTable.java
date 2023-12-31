package Table;

import java.util.Date;

import List.ExpenseLists;
import View.AUDAdminView;
import View.AUDExpenseView;
import View.AUDSalaryPaymentView;
import View.MainView;
import View.AdminDataView;
import View.DesignationListsView;
import View.ExpenseDataView;
import View.ExpenseListsView;
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

public class ExpenseTable {

	private static TableColumn no,note,amount,expenseCategoryID,expenseCategoryName,adminID,adminName,addDate;
	private static TableView tvExpense;
	public static TableView tvExpenseLists(int choose)
	{
		// choose 1 normal list 
		// choose 2 report list
		tvExpense	= new TableView<ExpenseLists>();
		tvExpense.setMaxWidth(Region.USE_PREF_SIZE);
		tvExpense.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setPrefWidth(50);
		no.setResizable(false);
		
		note = new TableColumn("Note");
		note.setCellValueFactory(new PropertyValueFactory<>("Note"));
		note.setPrefWidth(221);
		note.setResizable(false);
		
		amount = new TableColumn("Amount");
		amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
		amount.setPrefWidth(120);
		amount.setResizable(false);
		
		expenseCategoryID = new TableColumn("Expense Category ID");
		expenseCategoryID.setCellValueFactory(new PropertyValueFactory<>("ExpenseCategoryID"));
//		expenseCategoryID.setPrefWidth(50);
		expenseCategoryID.setResizable(false);

		expenseCategoryName=new TableColumn("Expense Category Name");
		expenseCategoryName.setCellValueFactory(new PropertyValueFactory<>("ExpenseCategoryName"));
		expenseCategoryName.setPrefWidth(150);
        expenseCategoryName.setResizable(false);
        
        adminID=new TableColumn("Admin ID");
		adminID.setCellValueFactory(new PropertyValueFactory<>("AdminID"));
		adminID.setPrefWidth(120);
		adminID.setResizable(false);
		
		adminName=new TableColumn("Admin Name");
		adminName.setCellValueFactory(new PropertyValueFactory<>("AdminName"));
		adminName.setPrefWidth(120);
        adminName.setResizable(false);

        addDate=new TableColumn("Add Date");
		addDate.setCellValueFactory(new PropertyValueFactory<>("AddDate"));
        addDate.setPrefWidth(120);
        addDate.setResizable(false);

		TableColumn<ExpenseLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<ExpenseLists, Void>, TableCell<ExpenseLists, Void>> cellHB = new Callback<TableColumn<ExpenseLists, Void>, TableCell<ExpenseLists, Void>>() {
            @Override
            public TableCell<ExpenseLists, Void> call(final TableColumn<ExpenseLists, Void> param) {
                final TableCell<ExpenseLists, Void> cell = new TableCell<ExpenseLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");

                    	btnUpdate.setOnAction((ActionEvent event) -> {
                            ExpenseLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				
                            if(data.getExpenseCategoryID()!=0)
                            {
                            MainView.vbWorkSpace = AUDExpenseView.vbAddExpenseView(data.getExpenseID(), data.getNote(), data.getAmount()+"", data.getExpenseCategoryID(), data.getExpenseCategoryName(), data.getAdminID(), data.getAdminName(), 2);            				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                            }
                            else
                            {
                            	MainView.vbWorkSpace =AUDSalaryPaymentView.AddSalaryView("","", "","", data.getAmount()+"", 2, data.getExpenseID(),data.getNote(),2);
                            }
                            MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                            MainView.UpdateIndex(MainView.lIndex1, "Expense Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Update Expense");
            				});
                    	btnDelete.setOnAction((ActionEvent event) -> {
                            ExpenseLists data = getTableView().getItems().get(getIndex());
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                            if(al.getResult() == ButtonType.YES)
                            {
                            	Handler.ExpenseHandler.DeleteExpense(data.getExpenseID());
                            	MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                  				MainView.vbWorkSpace = ExpenseListsView.vbExpenseListsView();
                  				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                            }
                            
                        });
                    	btnView.setOnAction((ActionEvent event) -> {
                            ExpenseLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = ExpenseDataView.vbExpenseDataView(data.getExpenseID(), data.getNote(), data.getAmount(), data.getExpenseCategoryID(), data.getExpenseCategoryName(), data.getAdminID(), data.getAdminName(), data.getAddDate()+"");
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.UpdateIndex(MainView.lIndex1, "Expense Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Expense Data");
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
        	colActionBtn.setPrefWidth(114);
		tvExpense.getColumns().addAll(no,expenseCategoryName,note,amount,adminID,adminName,addDate,colActionBtn);
		tvExpense.setPrefSize(1017,558);

        }
        if(choose == 2)
        {
    		note.setPrefWidth(221);
        	tvExpense.getColumns().addAll(no,expenseCategoryName,note,amount,adminID,adminName,addDate);
    		tvExpense.setPrefSize(1017-114,300);
        }

		return tvExpense;
	}
}
