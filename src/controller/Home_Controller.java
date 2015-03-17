package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.Home_Frame;
import view.Login_Form;
import model.SQLConnection;
import model.User;

public class Home_Controller implements ActionListener{
	Faculty_Controller facultyControl;
	Report_Controller reportControl;
	Comm_Controller commControl;
	Login_Form login;
	SQLConnection sqlConnect;
	User user;
	Home_Frame homeFrame;
	
	public Home_Controller(){
		init();
		sqlConnect.createDB();
		login.setVisible(true);
	}

	private void init() {
		initController();
		
		initView();
		addListener();
		
		sqlConnect = SQLConnection.getInstance();
	}


	private void addListener() {
		login.btnLogin.addActionListener(this);
		login.passwordPF.addActionListener(this);
		login.usernameTF.addActionListener(this);
	}

	private void initController() {
		facultyControl = new Faculty_Controller();
		reportControl = new Report_Controller();
		commControl = new Comm_Controller();
	}


	private void initView() {
		login = new Login_Form();
		
		homeFrame = new Home_Frame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login.usernameTF)
			transferFocusToPassword();
		else if(e.getSource() == login.passwordPF || e.getSource() == login.btnLogin)
			login();
	}
	
	private void transferFocusToPassword() {
		login.usernameTF.transferFocus();
	}

	private void login() {
		try {
			user = login.authenticate(sqlConnect);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Something went wrong when authenticating the user! The error message is: "+e.getMessage(), "Authentication Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
