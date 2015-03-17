package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import others.Util;
import model.SQLConnection;
import model.User;

@SuppressWarnings("serial")
public class Login_Form extends JFrame{
	public JTextField usernameTF;
	public JPasswordField passwordPF;
	private JLabel lblPassword;
	public JButton btnLogin;

	public Login_Form() {
		setTitle("A.L.P.S.");
		
		initGUI();
	}

	private void initGUI() {
		setResizable(false);
		setSize(new Dimension(800, 500));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ate Lainee's Personal System");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(5, 91, 780, 26);
		getContentPane().add(lblNewLabel_1);
		
		usernameTF = new JTextField();
		usernameTF.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTF.setBounds(297, 172, 195, 26);
		getContentPane().add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(351, 209, 89, 23);
		getContentPane().add(lblNewLabel_2);
		
		passwordPF = new JPasswordField();
		passwordPF.setHorizontalAlignment(SwingConstants.CENTER);
		passwordPF.setBounds(297, 264, 195, 26);
		getContentPane().add(passwordPF);
		
		btnLogin = new JButton("login");
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		btnLogin.setBounds(339, 372, 114, 33);
		getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("A.L.P.S.");
		lblNewLabel.setBounds(5, 5, 780, 100);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(300, 100));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
		getContentPane().add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPassword.setBounds(351, 303, 89, 23);
		getContentPane().add(lblPassword);
		
		setLocationRelativeTo(null);
	}
	
	public User authenticate(SQLConnection sqlConnect) throws ClassNotFoundException, SQLException{
		String username = usernameTF.getText().trim();
		String password = Util.toString(passwordPF.getPassword());
		ResultSet rs = sqlConnect.query("select * from user where username = '"+username+"' and password = md5('"+password+"')");
		if(rs.next())
			return new User();
		return null;
	}
}
