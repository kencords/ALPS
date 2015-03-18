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
	public JLabel lblPassword;

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
		currentPasswordPF.setBounds(12, 148, 276, 30);
		getContentPane().add(currentPasswordPF);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPassword.setBounds(12, 111, 276, 28);
		getContentPane().add(lblPassword);
	}
	
	@Override
	public void verifyInput() {

	}
}
