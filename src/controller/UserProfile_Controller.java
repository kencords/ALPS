package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import model.User;
import view.UserProfile_Form;

public class UserProfile_Controller implements ActionListener{

	public UserProfile_Form profile_Form;
	
	public UserProfile_Controller() {
		init();
		addListener();
	}

	private void addListener() {
		profile_Form.usernameTF.addActionListener(this);
		profile_Form.currentPasswordPF.addActionListener(this);
		profile_Form.newPasswordField.addActionListener(this);
		profile_Form.confirmPasswordField.addActionListener(this);
		profile_Form.btnSave.addActionListener(this);
		profile_Form.btnCancel.addActionListener(this);
	}

	private void init() {
		profile_Form = new UserProfile_Form(Home_Controller.homeFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == profile_Form.usernameTF || e.getSource() == profile_Form.newPasswordField)
			((JComponent)(e.getSource())).transferFocus();
		else if(e.getSource() == profile_Form.currentPasswordPF || e.getSource() == profile_Form.confirmPasswordField || e.getSource() == profile_Form.btnSave)
			save();
		else if(e.getSource() == profile_Form.btnCancel)
			profile_Form.setVisible(false);
	}

	private void save() {
		if(!profile_Form.verifyInput())
			return;
		User user = Home_Controller.user;
		try {
			user.define(user.getId(), user.getUsername(), user.getPassword());
			JOptionPane.showMessageDialog(profile_Form, "The account was successfully updated!", "Successful Update", JOptionPane.INFORMATION_MESSAGE);
			profile_Form.setVisible(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(profile_Form, "Oooopss... something went wrong when updating the user's information! The error message is: "+e.getMessage(), "Update Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
