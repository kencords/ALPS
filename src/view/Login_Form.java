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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(800, 500));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ate Lainee's Personal System");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(5, 91, 780, 26);
		getContentPane().add(lblNewLabel_1);
		
		Font font = new Font("Comic Sans MS", Font.BOLD, 15);
		
		usernameTF = new JTextField();
		usernameTF.setFont(font);
		usernameTF.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTF.setBounds(297, 172, 195, 30);
		getContentPane().add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(351, 209, 89, 23);
		getContentPane().add(lblNewLabel_2);
		
		passwordPF = new JPasswordField();
		passwordPF.setFont(font);
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
	
	/**
	 * check if the user exists in the database, if the user exists, the resultset is returned if not the null.
	 * @param sqlConnect
	 * @return the resultset of the user found
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User authenticate(SQLConnection sqlConnect) throws ClassNotFoundException, SQLException{
		String username = usernameTF.getText().trim();
		String password = Util.toString(passwordPF.getPassword());
		ResultSet rs = sqlConnect.query("select * from user where username = '"+SQLConnection.insertBackSlash(username)+"' and password = md5('"+SQLConnection.insertBackSlash(password)+"')");
		try{
			if(rs.next()){	// if there is no username found this statement will throw an exception
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(username);
				user.setPassword(password);
				return user;
			}
		}catch(Exception e){}
		return null;	// return null because no username was found
	}

	public void showLogin() {
		passwordPF.setText("");
		setVisible(true);
	}
}
