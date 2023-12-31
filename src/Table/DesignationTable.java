package Table;

import java.util.Date;

import List.DesignationLists;
import View.AUDAdminView;
import View.AUDDesignationView;
import View.MainView;
import View.AdminDataView;
import View.DesignationDataView;
import View.DesignationListsView;
import View.Login;
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

public class DesignationTable {

	private static TableColumn no,designationName,maxSalary,minSalary,adminID,adminName,addDate;
	private static TableView tvDesignation;
	public static TableView tvDesignationLists(int choose)
	{
		
		//choose 1 for list //choose 2 for history
		tvDesignation	= new TableView<DesignationLists>();
		tvDesignation.setMaxWidth(Region.USE_PREF_SIZE);
		tvDesignation.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		no = new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setPrefWidth(50);
		no.setResizable(false);

		designationName = new TableColumn("Designation Name");
		designationName.setCellValueFactory(new PropertyValueFactory<>("DesignationName"));
		designationName.setPrefWidth(150.5);
		designationName.setResizable(false);
		
		maxSalary = new TableColumn("Max Salary");
		maxSalary.setCellValueFactory(new PropertyValueFactory<>("MaxSalary"));
		maxSalary.setPrefWidth(122);
		maxSalary.setResizable(false);
		
		minSalary = new TableColumn("Min Salary");
		minSalary.setCellValueFactory(new PropertyValueFactory<>("MinSalary"));
		minSalary.setPrefWidth(121.5);
		minSalary.setResizable(false);
		 
        adminID=new TableColumn("Admin ID");
		adminID.setCellValueFactory(new PropertyValueFactory<>("AdminID"));
		adminID.setPrefWidth(150.5);
		adminID.setResizable(false);
		

		adminName=new TableColumn("Admin Name");
		adminName.setCellValueFactory(new PropertyValueFactory<>("AdminName"));
		adminName.setPrefWidth(150.5);
        adminName.setResizable(false);

        addDate=new TableColumn("Add Date");
		addDate.setCellValueFactory(new PropertyValueFactory<>("AddDate"));
        addDate.setPrefWidth(150.5);
        addDate.setResizable(false);

		TableColumn<DesignationLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<DesignationLists, Void>, TableCell<DesignationLists, Void>> cellHB = new Callback<TableColumn<DesignationLists, Void>, TableCell<DesignationLists, Void>>() {
            @Override
            public TableCell<DesignationLists, Void> call(final TableColumn<DesignationLists, Void> param) {
                final TableCell<DesignationLists, Void> cell = new TableCell<DesignationLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");

                    	btnUpdate.setOnAction((ActionEvent event) -> {
            				MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                    		DesignationLists data = getTableView().getItems().get(getIndex());
            				MainView.vbWorkSpace = AUDDesignationView.vbAddDesignationView(data.getDesignationID(), data.getDesignationName(), data.getMaxSalary(), data.getMinSalary(),2);
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();
            				MainView.UpdateIndex(MainView.lIndex1, "Designation Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Update Designation");
            			});
                    	btnDelete.setOnAction((ActionEvent event) -> {
                            DesignationLists data = getTableView().getItems().get(getIndex());
                            Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                            al.showAndWait();
                            if(al.getResult() == ButtonType.YES)
                            {
                            	Handler.DesignationHandler.DeleteDesgiantion(data.getDesignationID()+"");
                            	 MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                 				MainView.vbWorkSpace = DesignationListsView.vbDesignationListsView();
                 				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
                 			}
                    	});
                    	btnView.setOnAction((ActionEvent event) -> {
                            DesignationLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
            				MainView.vbWorkSpace = DesignationDataView.vbDesignationDataView(data.getDesignationID(), data.getDesignationName(), data.getMaxSalary(),data.getMinSalary(), data.getAdminID(), data.getAdminName(), data.getAddDate()+"");
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();
            				MainView.UpdateIndex(MainView.lIndex1, "Designation Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Designation Data");
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
        colActionBtn.setResizable(false);
		colActionBtn.setPrefWidth(117);

        if(choose ==1)
        {
        	tvDesignation.getColumns().addAll(no,designationName,maxSalary,minSalary,adminID,adminName,addDate,colActionBtn);
    		tvDesignation.setPrefSize(1017,558);
        }
        else
        {
    		
        	tvDesignation.getColumns().addAll(no,designationName,maxSalary,minSalary,adminID,adminName,addDate);
    		tvDesignation.setPrefSize(1017,558);	
        }
		return tvDesignation;
	}
}
