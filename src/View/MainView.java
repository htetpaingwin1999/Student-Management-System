package View;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import List.AdminLists;
import List.StaffLists;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class MainView {
	private static Label lWelcomeText;
	private static ImageView imgUser;
	private static BorderPane bpRightHeader;
	
	public static Label lUsername;
	private static HBox hbUser;
	
	private static Menu menuAction;
	private static MenuItem menuItemLogOut;
	private static MenuItem menuItemSwitchAccount;
	private static MenuItem menuItemChangePassword;
	private static MenuItem menuItemChangeUsername;
	private static MenuBar menuBar;
	
	private static Button btnAboutUs;
	private static Button btnHelp;
	
	private static VBox vbMainView;
	private static BorderPane bp;
	private static VBox vbLeft;
	private static VBox vbRight;
	private static HBox hbHeader;
	private static HBox hbFooter;
	
	private static Label lClassName;
	private static VBox vbClassNameCon;
	private static ImageView imgIcon;
	private static HBox hbImgIconCon;
	
	private static Button btnDashboard;

	private static Button btnCourseMain;
	private static Button btnCourseExpand;
	private static Button btnCourseLists;
	private static Button btnAddCourse;
	private static HBox hbCourseCon;
	private static VBox vbCourseCon;
	private static Boolean btnIsCourseExpand = false;
	
	private static Button btnStaffMain;
	private static Button btnStaffExpand;
	private static Button btnStaffLists;
	private static Button btnAddStaff;
	private static Button btnSalaryLists;
	private static Button btnDesignationLists;
	private static Button btnAddDesignation;
	private static Button btnDepartmentLists; // hlyar htar thi for next version
	private static Button btnAddDepartment;
	
	
	private static Button btnFineCategoryLists; // hlayr
	private static Button btnAddFineCategory; // hlyar
	private static Button btnFineLists; // hlyar
	
	private static HBox hbStaffCon;
	private static VBox vbStaffCon;
	private static Boolean btnIsStaffExpand = false;
	
	private static Button btnSectionMain;
	private static Button btnSectionExpand;
	private static Button btnSectionLists;
	private static Button btnAddSection;
	private static HBox hbSectionCon;
	private static VBox vbSectionCon;
	private static Boolean btnIsSectionExpand = false;
	
	private static Button btnStudentMain;
	private static Button btnStudentExpand;
	private static Button btnStudentLists;
	private static Button btnAddStudent;
	private static Button btnJoinedCourses;
	private static Button btnFeepayments;
	private static HBox hbStudentCon;
	private static VBox vbStudentCon;
	private static Boolean btnIsStudentExpand = false;
	
	private static Button btnExpenseMain;
	private static Button btnExpenseExpand;
	private static Button btnExpenseLists;
	private static Button btnAddExpense;
	private static Button btnExpenseCategoryLists;
	private static Button btnAddExpenseCategory;
	private static HBox hbExpenseCon;
	private static VBox vbExpenseCon;
	private static Boolean btnIsExpenseExpand = false;
	
	private static Button btnAdminMain;
	private static Button btnAdminExpand;
	private static Button btnAdminLists;
	private static Button btnAddAdmin;
	private static HBox hbAdminCon;
	private static VBox vbAdminCon;
	private static Boolean btnIsAdminExpand = false;
	
	private static Button btnReportMain;
	
	public static VBox vbWorkSpaceCon;
	public static VBox vbWorkSpace;
	
	public static Label lHome;
	public static Label lIndex1;
	public static HBox hbIndexCon;
	public static Label lIndex2;
	public static Label lIndex3;
	public static Label lIndex4;
	private static String username = "";
	
	
	public static VBox vbMainView(String id)
	{
		vbMainView = new VBox();
			
		bp = new BorderPane();
		bp.setPrefSize(1366, 750);
		
		vbLeft = new VBox();
		vbLeft.setPrefSize(266, 750);
		vbLeft.setStyle("-fx-background-color:#454545");
		
		lClassName = new Label("");
		Style.LabelFillColorAndSize(lClassName, "white", 30);
		
		vbClassNameCon = new VBox();
		vbClassNameCon.setPrefHeight(72);
		vbClassNameCon.getChildren().addAll(lClassName);
		Style.VBoxFillColorAndSizeAndPadding(vbClassNameCon, "orange", 21, 10, 3);
		
		btnDashboard = new Button("  Dashboard",new ImageView(new Image("Icon/Home.png")));
		ButtonColorFillAndDefineSize(btnDashboard,30,200,"454545");
		
		btnCourseMain = new Button("    Course",new ImageView(new Image("Icon/Course.png")));
		ButtonColorFillAndDefineSize(btnCourseMain,30,200,"454545");

		btnCourseExpand = new Button("",new ImageView(new Image("Icon/Expand.png")));
		ButtonExpand(btnCourseExpand);
		
		btnCourseLists = new Button("    Course Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnCourseLists,50,266,"454545");
	
		btnAddCourse = new Button("    Add New Course",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddCourse,50,266,"454545");
		
		hbCourseCon = new HBox();
		hbCourseCon.getChildren().addAll(btnCourseMain,btnCourseExpand);
		hbCourseCon.setSpacing(0);
		
		vbCourseCon = new VBox();
		vbCourseCon.getChildren().add(hbCourseCon);
		vbCourseCon.setSpacing(5);
		
		btnStaffMain = new Button("    Staff",new ImageView(new Image("Icon/Teacher.png")));
		ButtonColorFillAndDefineSize(btnStaffMain,30,200,"454545");

		btnStaffExpand = new Button("",new ImageView(new Image("Icon/Expand.png")));
		ButtonExpand(btnStaffExpand);
	
		btnStaffLists = new Button("    Staff Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnStaffLists,50,266,"454545");
		
		btnAddStaff = new Button("    Add New Staff",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddStaff,50,266,"454545");
	
		btnSalaryLists = new Button("    Salary Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnSalaryLists,50,266,"454545");

		btnDesignationLists = new Button("    Designation Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnDesignationLists,50,266,"454545");
	
		btnAddDesignation = new Button("    Add New Designation",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddDesignation,50,266,"454545");
				
		hbStaffCon = new HBox();
		hbStaffCon.getChildren().addAll(btnStaffMain,btnStaffExpand);
		hbStaffCon.setSpacing(0);
		
		vbStaffCon = new VBox();
		vbStaffCon.getChildren().add(hbStaffCon);
		vbStaffCon.setSpacing(5);
		
		btnSectionMain = new Button("    Section",new ImageView(new Image("Icon/Time.png")));
		ButtonColorFillAndDefineSize(btnSectionMain,30,200,"454545");
	
		btnSectionExpand = new Button("",new ImageView(new Image("Icon/Expand.png")));
		ButtonExpand(btnSectionExpand);
		
		btnSectionLists = new Button("    Section Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnSectionLists,50,266,"454545");
		
		btnAddSection = new Button("    Add New Section",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddSection,50,266,"454545");
	
		hbSectionCon = new HBox();
		hbSectionCon.getChildren().addAll(btnSectionMain,btnSectionExpand);
		hbSectionCon.setSpacing(0);
		
		vbSectionCon = new VBox();
		vbSectionCon.getChildren().add(hbSectionCon);
		vbSectionCon.setSpacing(5);
		
		btnStudentMain = new Button("    Students",new ImageView(new Image("Icon/Student.png")));
		ButtonColorFillAndDefineSize(btnStudentMain,30,200,"454545");
		
		btnStudentExpand = new Button("",new ImageView(new Image("Icon/Expand.png")));
		ButtonExpand(btnStudentExpand);
		
		btnStudentLists = new Button("    Student Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnStudentLists,50,266,"454545");
		
		btnAddStudent = new Button("    Add New Students",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddStudent,50,266,"454545");
		
		btnJoinedCourses = new Button("    Join Courses",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnJoinedCourses,50,266,"454545");
		
		btnFeepayments = new Button("    Payments",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnFeepayments,50,266,"454545");
			
		hbStudentCon = new HBox();
		hbStudentCon.getChildren().addAll(btnStudentMain,btnStudentExpand);
		
		vbStudentCon = new VBox();
		vbStudentCon.getChildren().add(hbStudentCon);
		vbStudentCon.setSpacing(5);
		
		btnExpenseMain = new Button("    Expense",new ImageView(new Image("Icon/Expense.png")));
		ButtonColorFillAndDefineSize(btnExpenseMain,30,200,"454545");

		btnExpenseExpand = new Button("",new ImageView(new Image("Icon/Expand.png")));
		btnExpenseExpand.setStyle("-fx-background-color:#454545");
		btnExpenseExpand.setPrefWidth(66);
	
		btnExpenseLists = new Button("    Expense Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnExpenseLists,50,266,"454545");
		
		btnAddExpense = new Button("    Add New Expense",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddExpense,50,266,"454545");
		
		btnExpenseCategoryLists = new Button("    Expense Category Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnExpenseCategoryLists,50,266,"454545");
		
		btnAddExpenseCategory = new Button("    Add New Category",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddExpenseCategory,50,266,"454545");
	
		hbExpenseCon = new HBox();
		hbExpenseCon.getChildren().addAll(btnExpenseMain,btnExpenseExpand);
		hbExpenseCon.setSpacing(0);
		
		vbExpenseCon = new VBox();
		vbExpenseCon.getChildren().add(hbExpenseCon);
		vbExpenseCon.setSpacing(5);

		btnAdminMain = new Button("    Admin",new ImageView(new Image("Icon/Teacher.png")));
		ButtonColorFillAndDefineSize(btnAdminMain,30,200,"454545");

		btnAdminExpand = new Button("",new ImageView(new Image("Icon/Expand.png")));
		ButtonExpand(btnAdminExpand);
	
		btnAdminLists = new Button("    Admin Lists",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAdminLists,50,266,"454545");
		
		btnAddAdmin = new Button("    Add New Admin",new ImageView(new Image("Icon/CO.png")));
		ButtonColorFillAndDefineSize(btnAddAdmin,50,266,"454545");
		
		hbAdminCon = new HBox();
		hbAdminCon.getChildren().addAll(btnAdminMain,btnAdminExpand);
		hbAdminCon.setSpacing(0);
		
		vbAdminCon = new VBox();
		vbAdminCon.getChildren().add(hbAdminCon);
		vbAdminCon.setSpacing(5);
		
		btnReportMain = new Button("  Report",new ImageView(new Image("Icon/Report.png")));
		ButtonColorFillAndDefineSize(btnReportMain,30,200,"454545");
		
		vbLeft.setSpacing(5);
		
		vbRight = new VBox();
		vbRight.setPrefSize(1100, 750);
		
		lWelcomeText = new Label("Welcome To Brilliant Developers Group");
		Style.LabelFillColorAndSize(lWelcomeText, "blue", 20);
		
		imgUser = new ImageView(new Image("Icon/User24.png"));
		
		lUsername = new Label(Handler.AccountHandler.AdminUsername(Login.userid));
		
		Style.LabelFillColorAndSize(lUsername, "grey", 15);
		lUsername.setPadding(new Insets(7,0,0,0));
		
		if(Integer.parseInt(Login.userpos) == 1)
		{
			if(Login.userid.equals("1"))
			{
				vbLeft.getChildren().addAll(vbClassNameCon,btnDashboard,vbCourseCon,vbStaffCon,vbAdminCon,vbSectionCon,vbStudentCon,vbExpenseCon,btnReportMain);
			}
			
			else
			{
				vbLeft.getChildren().addAll(vbClassNameCon,btnDashboard,vbCourseCon,vbStaffCon,vbSectionCon,vbStudentCon,vbExpenseCon,btnReportMain);
			}
		}
		else
		{
			btnSectionLists = new Button("    Section Lists",new ImageView(new Image("Icon/Time.png")));
			ButtonColorFillAndDefineSize(btnSectionLists,30,200,"454545");

			btnCourseLists = new Button("    Course",new ImageView(new Image("Icon/Course.png")));
			ButtonColorFillAndDefineSize(btnCourseLists,30,200,"454545");

			vbLeft.getChildren().addAll(vbClassNameCon,btnDashboard,btnCourseLists,btnSectionLists,vbStudentCon);
		}
		
		lUsername.setText(Login.username);
		vbWorkSpace = DashboardView.vbDashboardView();
		
		vbWorkSpace.setPrefSize(1080,638);
		
		
		menuAction = new Menu("Account Settings");
		menuAction.setStyle("-fx-font-family: 'Times New Roman';-fx-font-size:15px;");
		menuItemLogOut = new MenuItem("Log Out");

		menuItemChangePassword = new MenuItem("Change Password");
		menuItemChangeUsername = new MenuItem("Change Username");
		menuItemLogOut = new MenuItem("Log Out");

		menuAction.getItems().add(menuItemLogOut);
		menuAction.getItems().add(menuItemChangePassword);
		menuAction.getItems().add(menuItemChangeUsername);

		menuBar = new MenuBar();
		menuBar.getMenus().add(menuAction);
		menuBar.setStyle("-fx-background-color:white");
		
		btnAboutUs = new Button("About Us");
		ButtonColorFillAndDefineSize(btnAboutUs,30,100,"ffffff");
		btnAboutUs.setTextFill(Color.BLACK);
		
		btnHelp = new Button("Help");
		ButtonColorFillAndDefineSize(btnHelp,30,100,"ffffff");
		btnHelp.setTextFill(Color.BLACK);

		hbUser = new HBox();
		hbUser.getChildren().addAll(imgUser,lUsername,btnAboutUs,btnHelp,menuBar);
		hbUser.setSpacing(5);
		
		bpRightHeader = new BorderPane();
		bpRightHeader.setRight(hbUser);
		bpRightHeader.setLeft(lWelcomeText);
		bpRightHeader.setPadding(new Insets(26,0,26,20));
		bpRightHeader.setStyle("-fx-background-color:white");
		bpRightHeader.setPrefHeight(72);
		
		vbWorkSpaceCon = new VBox();
		vbWorkSpaceCon.setPrefSize(1100,678);
		
		btnHelp.setOnAction(e->{
			ShowHelpPDF();
		});
		
		btnAboutUs.setOnAction(e->{
		   ShowAboutUsWebsite(); 
			
		});

		lHome = new Label("Home");
		lHome.setFont(Font.font("Times New Roman", 15));

		lIndex1 = new Label("");
		lIndex1.setFont(Font.font("Times New Roman", 15));
		
		lIndex2 = new Label("");
		lIndex2.setFont(Font.font("Times New Roman", 15));
		
		lIndex3 = new Label("");
		lIndex3.setFont(Font.font("Times New Roman", 15));
		
		lIndex4 = new Label("");
		lIndex4.setFont(Font.font("Times New Roman", 15));
		
		hbIndexCon = new HBox();
		hbIndexCon.getChildren().addAll(lHome,lIndex1,lIndex2,lIndex3,lIndex4);
		hbIndexCon.setPrefSize(1100, 40);	
		hbIndexCon.setPadding(new Insets(12.5,0,12.5,20));
		hbIndexCon.setSpacing(10);
		
		vbWorkSpace = DashboardView.vbDashboardView();
		
		vbWorkSpace.setPrefSize(1080,638);
		
		vbWorkSpaceCon.getChildren().addAll(hbIndexCon,vbWorkSpace);
		vbWorkSpaceCon.setPadding(new Insets(10,20,10,20));
		vbWorkSpaceCon.setSpacing(5);
		
		vbRight.getChildren().addAll(bpRightHeader,vbWorkSpaceCon);
		
		bp.setLeft(vbLeft);
		bp.setRight(vbRight);
		
		menuItemChangePassword.setOnAction(e->{
			MainView.RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Change Password");
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = ChangePasswordView.vbChangePasswordView();
			MainView.SetButtonExpandCloseAndRemoveContent();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
		});
		
		menuItemChangeUsername.setOnAction(e->{
			MainView.RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Change Username");
			MainView.SetButtonExpandCloseAndRemoveContent();
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = ChangeUserName.vbChangePasswordView(username, Login.userid);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
		});
		
		
		menuItemLogOut.setOnAction(e->{
			Login.myStage.setScene(new Scene(Login.BpLogin(),850,500));
			Login.myStage.centerOnScreen();
			Login.myStage.show();
			Login.myStage.setResizable(false);
			
		});
		btnDashboard.setOnAction(e->{
			MainView.RemoveIndex();
			MainView.SetButtonExpandCloseAndRemoveContent();
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = DashboardView.vbDashboardView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
		});
		btnCourseExpand.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();

			if(btnIsCourseExpand == false)
			{
				if(Integer.parseInt(Login.userpos) == 1)
				{
					vbCourseCon.getChildren().addAll(btnCourseLists,btnAddCourse);
				}
				else
				{
					vbCourseCon.getChildren().addAll(btnCourseLists);
				}
			}	
			btnIsCourseExpand = !btnIsCourseExpand;
			btnIsStaffExpand = false;
			btnIsSectionExpand = false;
			btnIsStudentExpand = false;
			btnIsExpenseExpand = false;
			btnIsAdminExpand = false;
		});
		btnStaffExpand.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			if(btnIsStaffExpand == false)
			{
				vbStaffCon.getChildren().addAll(btnStaffLists,btnAddStaff,btnSalaryLists,btnDesignationLists,btnAddDesignation);
			}
			btnIsStaffExpand = !btnIsStaffExpand;
			btnIsCourseExpand = false;
			btnIsSectionExpand = false;
			btnIsStudentExpand = false;
			btnIsExpenseExpand = false;
			btnIsAdminExpand = false;
		});
		btnAdminExpand.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			if(btnIsAdminExpand == false)
			{
				if(Login.userid.equals("1"))
				{
					vbAdminCon.getChildren().addAll(btnAdminLists,btnAddAdmin);
				}
				else
				{
					vbAdminCon.getChildren().addAll(btnAddAdmin);
				}
			}
			
			btnIsAdminExpand = !btnIsAdminExpand;
			btnIsCourseExpand = false;
			btnIsStaffExpand = false;
			btnIsSectionExpand = false;
			btnIsStudentExpand = false;
			btnIsExpenseExpand = false;
		});
		btnSectionExpand.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();

			if(btnIsSectionExpand == false)
			{
				if(Integer.parseInt(Login.userpos) ==1 )
				{
					vbSectionCon.getChildren().addAll(btnSectionLists,btnAddSection);
				}
				else
				{
					vbSectionCon.getChildren().addAll(btnSectionLists);
				}
			}
			btnIsSectionExpand = !btnIsSectionExpand;
			btnIsCourseExpand = false;
			btnIsStaffExpand = false;
			btnIsStudentExpand = false;
			btnIsExpenseExpand = false;
			btnIsAdminExpand = false;
		});
		btnStudentExpand.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			if(btnIsStudentExpand == false)
			{
				if(Integer.parseInt(Login.userpos) == 1 )
				{
					vbStudentCon.getChildren().addAll(btnStudentLists,btnJoinedCourses,btnFeepayments);
				}
				else
				{
					vbStudentCon.getChildren().addAll(btnStudentLists,btnAddStudent,btnFeepayments);
				}
			}
			btnIsStudentExpand = !btnIsStudentExpand;
			btnIsCourseExpand = false;
			btnIsStaffExpand = false;
			btnIsSectionExpand = false;
			btnIsExpenseExpand = false;
			btnIsAdminExpand = false;
		});
		btnExpenseExpand.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			if(btnIsExpenseExpand == false)
			{
				vbExpenseCon.getChildren().addAll(btnExpenseLists,btnAddExpense,btnExpenseCategoryLists,btnAddExpenseCategory);
			}
			btnIsExpenseExpand = !btnIsExpenseExpand;
			btnIsCourseExpand = false;
			btnIsStaffExpand = false;
			btnIsSectionExpand = false;
			btnIsStudentExpand = false;
			btnIsAdminExpand = false;
		});
		btnReportMain.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			MainView.RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Report View");
		});
		
		lUsername.setOnMouseClicked(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			if(Login.userpos.equals("1"))
			{
				vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
				AdminLists ad = Handler.AdminHandler.GetAdminData(Integer.parseInt(Login.userid));
				String gender = "Male";
				if(ad.getGender().equals("0"))
				{
					gender = "Male";
				}
				else
				{
					gender = "Female";
				}
				vbWorkSpace = AdminDataView.vbAdminDataView(ad.getEmail()+"", ad.getAdminName()+"", ad.getJoinDate()+"",gender,ad.getDateofBirth()+"", ad.getPhoneNo(),ad.getPresentAddress(), ad.getPassword(), ad.getUserName(), true,1);
				vbWorkSpaceCon.getChildren().add(vbWorkSpace);
				
			}
			else
			{
				vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
				StaffLists st = Handler.StaffHandler.GetStaffData(Integer.parseInt(Login.userid));
				String gender = "Male";
				vbWorkSpace = StaffDataView.vbStaffDataView(st.getStaffID()+"", st.getStaffName(), st.getJoinDate()+"", st.getGender(), st.getDateofBirth()+"", st.getPhoneNo(), st.getPresentAddress(), st.getPassword(), st.getDesignation(), st.getSalary()+"",st.getUserName(),st.getEmail(),1); 
				vbWorkSpaceCon.getChildren().add(vbWorkSpace);
				
			}
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Your Information");
		});
		
		btnCourseLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = CourseListsView.vbCourseListsView(id, Integer.parseInt(Login.userpos)+"");
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Course Lists");
		});
		btnAddCourse.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDCourseView.vbAddCourseView(0, "","", 1);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add New Course");
		});

		btnStaffLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = StaffListsView.vbStaffListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Staff Lists");
		});
		btnAddStaff.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDStaffView.vbAddStaffView("", "", "", "Female", "", "", "", "BSDS!123a11", "", "","",1,0);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add New Staff");
		});
		
		btnSalaryLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = SalaryListsOrPaymentListsView.vbSalaryPaymentListsView(1);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Salary Lists");
		});
		
		btnDesignationLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = DesignationListsView.vbDesignationListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Designation Lists");
		});
		btnAddDesignation.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDDesignationView.vbAddDesignationView(0, "", 40000, 30000, 1);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add Designation");
		});
		
		btnAdminLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AdminListsView.vbAdminListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Admin Lists");
		});
		btnAddAdmin.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDAdminView.vbAddAdminView("","","","Male","","","","","",1,0);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add New Admin");
		});
		btnSectionLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = SectionListsView.vbSectionListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Section Lists");
		});
		btnAddSection.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDSectionView.vbAddSectionView(0, "", "", "", "", "", "", "", "", 1,0);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add Section");
		});
		btnStudentLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = StudentListsView.vbStudentListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Student Lists");
		});
		btnAddStudent.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDStudentView.vbAddStudentView(0, "", "", "",1);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add New Student");
		});
		
		btnFeepayments.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = FeePaymentListsView.vbCourseStudentListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Fee Payment");
		});
		
		btnJoinedCourses.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = CourseStudentListsView.vbCourseStudentListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Joined Courses");
		});
		
		
		lHome.setOnMouseClicked(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = DashboardView.vbDashboardView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lHome,"Home");
		});
		btnExpenseLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = ExpenseListsView.vbExpenseListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Expense Lists");
		});
		btnAddExpense.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDExpenseView.vbAddExpenseView(0, "", "", 0, "", 1, "", 1);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add Expense");
		});
		btnExpenseCategoryLists.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = ExpenseCategoryListsView.vbExpenseCategoryListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Expense Category Lists");
		});
		btnAddExpenseCategory.setOnAction(e->{
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = AUDExpenseCategoryView.vbAddExpenseCategoryView(0, "", 1);
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Add Expense Category");
		});
		btnReportMain.setOnAction(e->{
			MainView.SetButtonExpandCloseAndRemoveContent();
			vbWorkSpaceCon.getChildren().remove(vbWorkSpace);
			vbWorkSpace = ReportView.vbReportListsView();
			vbWorkSpaceCon.getChildren().add(vbWorkSpace);
			 RemoveIndex();
			UpdateIndex(MainView.lIndex1,"Report");
		});
		vbMainView.getChildren().addAll(bp);
		return vbMainView;
	}
	public static void ChangeToUnactiveLink()
	{
		lHome.setTextFill(Color.GREY);
		lIndex1.setTextFill(Color.GREY);
		lIndex2.setTextFill(Color.GREY);
		lIndex3.setTextFill(Color.GREY);
		lIndex4.setTextFill(Color.GREY);
	}
	public static void UpdateIndex(Label l,String text) // choice means if you want to color black the selected index
	{	
		ChangeToUnactiveLink();
		l.setText(text);
		l.setTextFill(Color.BLACK);
	}
	public static void RemoveIndex()
	{
		lHome.setText("Home");
		lIndex1.setText("");
		lIndex2.setText("");
		lIndex3.setText("");
		lIndex4.setText("");
	}
	public static void ShowHelpPDF()
	{
		
		try {
			Desktop.getDesktop().open(new java.io.File("File/Help.pdf"));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void ShowAboutUsWebsite()
	{
		
		try {
			Desktop.getDesktop().open(new java.io.File("File/AboutMe.pdf"));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static void CloseExpand()
	{
		vbCourseCon.getChildren().clear();
		vbSectionCon.getChildren().clear();
		vbStaffCon.getChildren().clear();
		vbExpenseCon.getChildren().clear();
		vbAdminCon.getChildren().clear();
		vbStudentCon.getChildren().clear();
	}
	private static void ButtonColorFillAndDefineSize(Button btnInput,int right,int width,String color)
	{
		btnInput.setStyle("-fx-background-color:#"+color);
		btnInput.setPadding(new Insets(5,0,5,right));
		btnInput.setTextFill(Color.WHITE);
		btnInput.setFont(Font.font("Times New Roman", 15));
		btnInput.setPrefWidth(width);
		btnInput.setAlignment(Pos.CENTER_LEFT);
	}
	private static void ButtonExpand(Button btnExpand)
	{
		btnExpand.setStyle("-fx-background-color:#454545");
		btnExpand.setPrefWidth(66);
	}
	private static void SetButtonExpandCloseAndRemoveContent()
	{
		vbCourseCon.getChildren().clear();
		vbSectionCon.getChildren().clear();
		vbStaffCon.getChildren().clear();
		vbExpenseCon.getChildren().clear();
		vbAdminCon.getChildren().clear();
		vbStudentCon.getChildren().clear();
		
		vbCourseCon.getChildren().addAll(hbCourseCon);
		vbStaffCon.getChildren().addAll(hbStaffCon);
		vbSectionCon.getChildren().addAll(hbSectionCon);
		vbExpenseCon.getChildren().add(hbExpenseCon);
		vbAdminCon.getChildren().add(hbAdminCon);
		vbStudentCon.getChildren().add(hbStudentCon);
		
	}
}
