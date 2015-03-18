package view;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;

@SuppressWarnings("serial")
public class UserProfile_Form extends Form {
	public JLabel lblUsername;
	private JTextField usernameTF;
	public JTextField currentPasswordPF;
	public JLabel lblCurrentPassword;
	public JPasswordField newPasswordField;
	public JLabel lblNewPassword;
	public JPasswordField passwordField;
	public JLabel lblConfirmNewPassword;

	public UserProfile_Form() {
		
		initGUI();
	}
	
	private void initGUI() {
		setResizable(false);
		setSize(new Dimension(300, 450));
		setTitle("Edit User Profile");
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblUsername.setBounds(12, 23, 276, 28);
		getContentPane().add(lblUsername);
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		usernameTF.setBounds(12, 60, 276, 30);
		getContentPane().add(usernameTF);
		
		currentPasswordPF = new JPasswordField();
		currentPasswordPF.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		currentPasswordPF.setBounds(12, 139, 276, 30);
		getContentPane().add(currentPasswordPF);
		
		lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblCurrentPassword.setBounds(12, 102, 276, 28);
		getContentPane().add(lblCurrentPassword);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		newPasswordField.setBounds(12, 218, 276, 30);
		getContentPane().add(newPasswordField);
		
		lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewPassword.setBounds(12, 181, 276, 28);
		getContentPane().add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		passwordField.setBounds(12, 297, 276, 30);
		getContentPane().add(passwordField);
		
		lblConfirmNewPassword = new JLabel("Confirm New Password:");
		lblConfirmNewPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblConfirmNewPassword.setBounds(12, 260, 276, 28);
		getContentPane().add(lblConfirmNewPassword);
	}
	
	@Override
	public void verifyInput() {

	}
}
