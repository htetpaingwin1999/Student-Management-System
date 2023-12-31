package Table;
import List.CourseLists;
import List.SectionLists;
import List.SectionLists;
import View.AUDSectionView;
import View.CourseListsView;
import View.Login;
import View.MainView;
import View.RegisterSectionView;
import View.SectionDataView;
import View.SectionListsView;
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

public class SectionTable {
	private static ObservableList<SectionLists> dataSection = null;
	private static TableColumn no,courseName,courseFee,staffName,startDate,endDate,firstDay,firstTime,secondDay,secondTime,noOfStudent;
	private static TableView tvSection;
	public static TableView tvSectionLists(int finish)
	{
		tvSection	= new TableView<SectionLists>();
		tvSection.setMaxWidth(Region.USE_PREF_SIZE);
		tvSection.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		no=new TableColumn("No");
		no.setCellValueFactory(new PropertyValueFactory<>("No"));
		no.setMinWidth(44);
		no.setResizable(false);

		courseName=new TableColumn("Course Name");
		courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
		courseName.setMinWidth(93);
		courseName.setResizable(false);
		
		courseFee=new TableColumn("Fee");
		courseFee.setCellValueFactory(new PropertyValueFactory<>("CourseFee"));
		courseFee.setMinWidth(64);
		courseFee.setResizable(false);
		
		staffName=new TableColumn("Teacher");
		staffName.setCellValueFactory(new PropertyValueFactory<>("StaffName"));
		staffName.setMinWidth(93);
		staffName.setResizable(false);
		
		startDate=new TableColumn("Start Date");
		startDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
		startDate.setMinWidth(93);
		startDate.setResizable(false);
		
		endDate=new TableColumn("End Date");
		endDate.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
		endDate.setMinWidth(93);
		endDate.setResizable(false);
		
		firstDay=new TableColumn("First Day");
		firstDay.setCellValueFactory(new PropertyValueFactory<>("FirstDay"));
		firstDay.setMinWidth(70);
		firstDay.setResizable(false);
		
		firstTime=new TableColumn("First Time");
		firstTime.setCellValueFactory(new PropertyValueFactory<>("FirstTime"));
		firstTime.setMinWidth(100);
		firstTime.setResizable(false);
		
		secondDay=new TableColumn("secondDay");
		secondDay.setCellValueFactory(new PropertyValueFactory<>("SecondDay"));
		secondDay.setMinWidth(70);
		secondDay.setResizable(false);
		
		secondTime=new TableColumn("Second Time");
		secondTime.setCellValueFactory(new PropertyValueFactory<>("SecondTime"));
		secondTime.setMinWidth(93);
		secondTime.setResizable(false);
		
		noOfStudent=new TableColumn("No");
		noOfStudent.setCellValueFactory(new PropertyValueFactory<>("NoOfStudent"));
		noOfStudent.setMinWidth(93);
		noOfStudent.setResizable(false);
		
        TableColumn<SectionLists, Void> colActionBtn = new TableColumn("Action");

        Callback<TableColumn<SectionLists, Void>, TableCell<SectionLists, Void>> cellHB = new Callback<TableColumn<SectionLists, Void>, TableCell<SectionLists, Void>>() {
            @Override
            public TableCell<SectionLists, Void> call(final TableColumn<SectionLists, Void> param) {
                final TableCell<SectionLists, Void> cell = new TableCell<SectionLists, Void>() {

                    private final Button btnUpdate = new Button("",new ImageView(new Image("Icon/Edit.png")));
                    private final Button btnDelete = new Button("",new ImageView(new Image("Icon/Delete.png")));
                    private final Button btnView = new Button("",new ImageView(new Image("Icon/eye.png")));
                    private final Button btnJoin = new Button("",new ImageView(new Image("Icon/Link.png")));
                    private final Button btnFinish = new Button("",new ImageView(new Image("Icon/Flag.png")));
                    private final HBox hbBtnCon = new HBox();
                    {
                    	btnUpdate.setStyle("-fx-background-color:white");
                    	btnDelete.setStyle("-fx-background-color:white");
                    	btnView.setStyle("-fx-background-color:white");
                    	btnJoin.setStyle("-fx-background-color:white");
                    	btnFinish.setStyle("-fx-background-color:white");

                    	btnUpdate.setOnAction((ActionEvent event) -> {
                            SectionLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                            MainView.vbWorkSpace = AUDSectionView.vbAddSectionView(data.getSectionID(), data.getCourseName(), data.getStaffName(), data.getStartDate()+"", data.getEndDate()+"", data.getFirstDay(), data.getFirstTime(), data.getSecondDay(), data.getSecondTime(), 2,data.getCourseFee());
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();
            				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Update Section Data");
                        });
                    	btnDelete.setOnAction((ActionEvent event) -> {
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to delete",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
            				{
                    			SectionLists data = getTableView().getItems().get(getIndex());
                                Handler.SectionHandler.DeleteSection(data.getSectionID());
                                MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                MainView.vbWorkSpace =SectionListsView.vbSectionListsView(); 
                                MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				}
                            
                    	});
                    	
             			btnFinish.setOnAction((ActionEvent event) -> {
                    		Alert al = new Alert(AlertType.CONFIRMATION,"Are you sure to finish the section",ButtonType.YES,ButtonType.NO);
                    		al.showAndWait();
                    		if(al.getResult() == ButtonType.YES)
            				{
                                SectionLists data = getTableView().getItems().get(getIndex());
                                 Handler.SectionHandler.FinishSection(data.getSectionID());
                                 MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                                 MainView.vbWorkSpace =SectionListsView.vbSectionListsView();
                 				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace); 
            				}                   
                        });
                    	
                    	btnView.setOnAction((ActionEvent event) -> {
                            SectionLists data = getTableView().getItems().get(getIndex());
                            MainView.vbWorkSpaceCon.getChildren().remove(MainView.vbWorkSpace);
                			MainView.vbWorkSpace = SectionDataView.vbSectionDataView(data.getSectionID(),finish);	
            				MainView.vbWorkSpaceCon.getChildren().add(MainView.vbWorkSpace);
            				MainView.RemoveIndex();            				
            				
            				if(finish == 0 )
            				{
                				MainView.RemoveIndex();
                				MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
                				MainView.UpdateIndex(MainView.lIndex2, "Section Data");
            				}
            				else
            				{
            					MainView.RemoveIndex();
            					MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
                				MainView.UpdateIndex(MainView.lIndex2, "Finished Section Lists");
                				MainView.UpdateIndex(MainView.lIndex3, "Finished Section Data");
            				}
            			 });
                    	
                    	if(finish == 0)
                    	{
                    		if(Login.userpos.equals("1"))
                    		{
                    			hbBtnCon.getChildren().addAll(btnView,btnUpdate,btnFinish,btnDelete);
                    			tvSection.setPrefSize(1034,558);
                    		}
                    		else
                    		{

                    			hbBtnCon.getChildren().addAll(btnView,btnJoin);

                    			tvSection.setPrefSize(960,558);	
                    		}

        					MainView.RemoveIndex();
        					MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
            				}
                    	else
                    	{
                        	hbBtnCon.getChildren().addAll(btnView);
        					MainView.RemoveIndex();
        					MainView.UpdateIndex(MainView.lIndex1, "Section Lists");
            				MainView.UpdateIndex(MainView.lIndex2, "Finished Section Lists");
                    	}
                    	hbBtnCon.setSpacing(5);
                    	btnJoin.setOnAction(e->{
                            SectionLists data = getTableView().getItems().get(getIndex());
                            RegisterSectionView.ShowRegisterView(data.getCourseName(),data.getCourseFee(),data.getSectionID(),data.getCourseID(),data.getCfid());
                    	});
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
        if(finish == 0)
        {
        	colActionBtn.setPrefWidth(147);
        	if(Login.userpos.equals("2"))
        	{
            	colActionBtn.setPrefWidth(71);
        	}
        }
        else
        {
    		courseName.setMinWidth(114);
    		courseFee.setMinWidth(114);
        	colActionBtn.setPrefWidth(38);
        }
        
        tvSection.getColumns().addAll(no,courseName,courseFee,staffName,startDate,endDate,firstDay,firstTime,secondDay,secondTime,colActionBtn);
        tvSection.setPrefSize(1017,558);
		return tvSection;
	}
}
