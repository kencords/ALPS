package controller;

import view.Home_Frame;
import view.Login_Form;
import model.SQLConnection;
import model.User;

public class Home_Controller {
	Login_Controller loginControl;
	Faculty_Controller facultyControl;
	Report_Controller reportControl;
	Comm_Controller commControl;
	SQLConnection sqlConnect;
	User user;
	Login_Form login;
	Home_Frame homeFrame;
	
	public Home_Controller(){
		init();
		sqlConnect.createDB();
		login.setVisible(true);
	}


	private void init() {
		initController();
		
		initView();
		
		sqlConnect = SQLConnection.getInstance();
	}


	private void initController() {
		loginControl = new Login_Controller();
		facultyControl = new Faculty_Controller();
		reportControl = new Report_Controller();
		commControl = new Comm_Controller();
	}


	private void initView() {
		homeFrame = new Home_Frame();
		
		login = new Login_Form();
	}
}
