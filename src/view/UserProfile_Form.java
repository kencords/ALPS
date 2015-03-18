package view;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import others.Util;
import controller.Home_Controller;
import model.SQLConnection;
import model.User;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class UserProfile_Form extends Form {
	public JLabel lblUsername;
	public JTextField usernameTF;
	public JPasswordField currentPasswordPF;
	public JLabel lblCurrentPassword;
	public JPasswordField newPasswordField;
	public JLabel lblNewPassword;
	public JPasswordField confirmPasswordField;
	public JLabel lblConfirmNewPassword;
	public JButton btnSave;

	public UserProfile_Form(Home_Frame home_Frame) {
		super(home_Frame, true);
		initGUI();
		setVisible(false);
	}
	
	private void initGUI() {
		setResizable(false);
		setSize(new Dimension(300, 400));
		setLocationRelativeTo(null);
		setTitle("Edit User Profile");
		
		Font textFont = new Font("Comic Sans MS", Font.PLAIN, 20);
		Font fieldFont = new Font("Comic Sans MS", Font.BOLD, 15);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(textFont);
		lblUsername.setBounds(12, 23, 276, 28);
		getContentPane().add(lblUsername);
		
		usernameTF = new JTextField();
		usernameTF.setFont(fieldFont);
		usernameTF.setBounds(12, 60, 276, 30);
		getContentPane().add(usernameTF);
		
		currentPasswordPF = new JPasswordField();
		currentPasswordPF.setFont(fieldFont);
		currentPasswordPF.setBounds(12, 139, 276, 30);
		getContentPane().add(currentPasswordPF);
		
		lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setFont(textFont);
		lblCurrentPassword.setBounds(12, 102, 276, 28);
		getContentPane().add(lblCurrentPassword);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(fieldFont);
		newPasswordField.setBounds(12, 218, 276, 30);
		getContentPane().add(newPasswordField);
		
		lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(textFont);
		lblNewPassword.setBounds(12, 181, 276, 28);
		getContentPane().add(lblNewPassword);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setFont(fieldFont);
		confirmPasswordField.setBounds(12, 297, 276, 30);
		getContentPane().add(confirmPasswordField);
		
		lblConfirmNewPassword = new JLabel("Confirm New Password:");
		lblConfirmNewPassword.setFont(textFont);
		lblConfirmNewPassword.setBounds(12, 260, 276, 28);
		getContentPane().add(lblConfirmNewPassword);
		
		Font btnFont = new Font("Comic Sans MS", Font.PLAIN, 20);
		
		btnSave = new JButton("Save");
		btnSave.setFont(btnFont);
		btnSave.setBounds(50, 339, 90, 40);
		getContentPane().add(btnSave);
		
		btnCancel.setFont(btnFont);
		btnCancel.setBounds(160, 339, 90, 40);
		getContentPane().add(btnCancel);
	}
	
	@Override
	public boolean verifyInput() {
		String username = usernameTF.getText().trim();
		String currentPassword = Util.toString(currentPasswordPF.getPassword());
		String newPassword = Util.toString(newPasswordField.getPassword());
		String confirmPassword = Util.toString(confirmPasswordField.getPassword());
		
		if(username.isEmpty() || currentPassword.isEmpty()){
			JOptionPane.showMessageDialog(this, "The username and current password should not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!currentPassword.equals(Home_Controller.user.getPassword())){
			JOptionPane.showMessageDialog(this, "The password you entered is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if((!newPassword.isEmpty() || !confirmPassword.isEmpty()) && !newPassword.equals(confirmPassword)){
			JOptionPane.showMessageDialog(this, "The new password does not match!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			if(!username.equalsIgnoreCase(Home_Controller.user.getUsername())){
				ResultSet rs = Home_Controller.sqlConnect.query("select * from user where username = '"+SQLConnection.insertBackSlash(username)+"'");
				try{
					if(rs.next()){
						JOptionPane.showMessageDialog(this, "The username already exists!!", "Username exists.", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}catch(Exception e1){}
			}
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(this, "Something went wrong when querying the username on the database! The error message is: "+e.getMessage(), "Query Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		Home_Controller.user.setUsername(username);
		if(!newPassword.isEmpty())
			Home_Controller.user.setPassword(newPassword);
		return true;
	}

	public void showUser_Form(User user) {
		usernameTF.setText(user.getUsername());
		currentPasswordPF.setText("");
		newPasswordField.setText("");
		confirmPasswordField.setText("");
		setVisible(true);
	}
}
