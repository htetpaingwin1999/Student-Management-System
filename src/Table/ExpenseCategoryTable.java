package Table;

import java.util.Date;

import List.ExpenseCategoryLists;
import View.AUDAdminView;
import View.AUDExpenseCategoryView;
import View.MainView;
import View.AdminDataView;
import View.ExpenseCategoryDataView;
import View.ExpenseCategoryListsView;
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

public class ExpenseCategoryTable {

	private static TableColumn no,catName,adminID,adminName,addDate;
	private static TableView tvExpenseCategory;
	public static TableView tvExpenseCategoryLists()
	{
		tvExpenseCategory	= new TableView<ExpenseCategoryLists>();
		tvExpenseCategory.setMaxWidth(Region.USE_PREF_SIZE);
		tvExpenseCategory.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setPrefWidth(50);
		no.setResizable(false);

		catName=new TableColumn("Category Name");
		catName.setCellValueFactory(new PropertyValueFactory<>("ExpenseCategoryName"));
		catName.setPrefWidth(213.5);
        catName.setResizable(false);
        
        adminID=new TableColumn("Admin ID");
		adminID.setCellValueFactory(new PropertyValueFactory<>("AdminID"));
		adminID.setPrefWidth(213.5);
		adminID.setResizable(false);
		

		adminName=new TableColumn("Admin Name");
		adminName.setCellValueFactory(new PropertyValueFactory<>("AdminName"));
		adminName.setPrefWidth(208.5);
        adminName.setResizable(false);

        addDate=new TableColumn("Add Date");
		addDate.setCellValueFactory(new PropertyValueFactory<>("AddDate"));
        addDate.setPrefWidth(213.5);
        addDate.setResizable(false);

		TableColumn<ExpenseCategoryLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<ExpenseCategoryLists, Void>, TableCell<ExpenseCategoryLists, Void>> cellHB = new Callback<TableColumn<ExpenseCategoryLists, Void>, TableCell<ExpenseCategoryLists, Void>>() {
            @Override
            public TableCell<ExpenseCategoryLists, Void> call(final TableColumn<ExpenseCategoryLists, Void> param) {
                final TableCell<ExpenseCategoryLists, Void> cell = new TableCell<ExpenseCategoryLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");

                    	btnUpdate.setOnAction((ActionEvent event) -> {
                            ExpenseCategoryLists data = getTableView().getItems().get(getIndex());
                            
            				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                            MainView.vbWorkSpace = AUDExpenseCategoryView.vbAddExpenseCategoryView(data.getExpenseCategoryID(),data.getExpenseCategoryName(),2);
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();
            				MainView.UpdateIndex(MainView.lIndex1, "Expense Category Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Update Expense Category");
                        });
                    	btnDelete.setOnAction((ActionEvent event) -> {
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
            				{
                    			ExpenseCategoryLists data = getTableView().getItems().get(getIndex());
                                Handler.ExpenseCategoryHandler.DeleteExpenseCategory(data.getExpenseCategoryID());
                                MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                    			MainView.vbWorkSpace = ExpenseCategoryListsView.vbExpenseCategoryListsView();
                    			MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				}
                            
                        });
                    	btnView.setOnAction((ActionEvent event) -> {
                            ExpenseCategoryLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = ExpenseCategoryDataView.vbExpenseCategoryDataView(data.getExpenseCategoryID(),data.getExpenseCategoryName(),data.getAdminID(),data.getAdminName(),data.getAddDate()+"");
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.UpdateIndex(MainView.lIndex1, "Expense Category Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Expense Category Data");
                            
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
        colActionBtn.setPrefWidth(114);
        colActionBtn.setResizable(false);
      
        tvExpenseCategory.getColumns().addAll(no,catName,adminID,adminName,addDate,colActionBtn);
		tvExpenseCategory.setPrefSize(1017,558);
		return tvExpenseCategory;
	}
}
