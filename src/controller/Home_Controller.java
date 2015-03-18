package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	UserProfile_Controller userControl;
	
	Login_Form login;
	public static SQLConnection sqlConnect;
	public static User user = new User();
	public static Home_Frame homeFrame;
	
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
		
		homeFrame.btnEdit.addActionListener(this);
		homeFrame.btnAbout.addActionListener(this);
		homeFrame.btnHelp.addActionListener(this);
		homeFrame.btnLogout.addActionListener(this);
		
		CloseApplicationListener closeListener = new CloseApplicationListener();
		homeFrame.addWindowListener(closeListener);
		login.addWindowListener(closeListener);
	}

	private void initController() {
		facultyControl = new Faculty_Controller();
		reportControl = new Report_Controller();
		commControl = new Comm_Controller();
		userControl = new UserProfile_Controller();
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
		else if(e.getSource() == homeFrame.btnEdit)
			editProfile();
		else if(e.getSource() == homeFrame.btnAbout)
			about();
		else if(e.getSource() == homeFrame.btnHelp)
			help();
		else if(e.getSource() == homeFrame.btnLogout)
			confirmLogout();
	}
	
	private void editProfile() {
		userControl.profile_Form.showUser_Form(user);
	}

	private void about() {
		
	}

	private void help() {
		
	}

	private void confirmLogout() {
		if(JOptionPane.showConfirmDialog(homeFrame, "Are you sure you want to logout?", "Logout?", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
			logout();
	}

	private void logout() {
		homeFrame.setVisible(false);
		login.showLogin();
	}

	private void transferFocusToPassword() {
		login.usernameTF.transferFocus();
	}

	private void login() {
		try {
			User user = login.authenticate(sqlConnect);
			if(user == null){
				JOptionPane.showMessageDialog(homeFrame, "Username and password does not match!", "Authentication Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Home_Controller.user.define(user.getId(), user.getUsername(), user.getPassword());
			login.setVisible(false);
			homeFrame.showFrame(user);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something went wrong when authenticating the user! The error message is: "+e.getMessage(), "Authentication Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	class CloseApplicationListener extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			if(JOptionPane.showConfirmDialog((Window)(e.getSource()), "Are you sure you want to exit?", "Confirm", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
				try {
					sqlConnect.closeConnection();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		}
		
	}
}
