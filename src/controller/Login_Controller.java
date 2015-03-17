package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Login_Form;

public class Login_Controller implements ActionListener{

	Login_Form login;
	
	public Login_Controller(){
		init();
	}

	private void init() {
		login = new Login_Form();
		login.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
