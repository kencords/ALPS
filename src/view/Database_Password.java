package view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import others.Util;
import main.Main;
import model.SQLConnection;

import java.awt.Font;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Database_Password extends JFrame implements ActionListener{
	public JLabel lblPleaseEnterThe;
	public JPasswordField passwordField;
	public JButton btnStart;
	public JLabel label;
	public JLabel label_1;

	public Database_Password(){
		
		initGUI();
	}
	private void initGUI() {
		setResizable(false);
		setTitle("Enter root Password");
		setSize(new Dimension(400, 140));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblPleaseEnterThe = new JLabel("Please enter the root password of the database:");
		lblPleaseEnterThe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		getContentPane().add(lblPleaseEnterThe);
		
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(160, 30));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setColumns(20);
		passwordField.addActionListener(this);
		
		label = new JLabel("");
		label.setPreferredSize(new Dimension(70, 1));
		getContentPane().add(label);
		
		getContentPane().add(passwordField);
		
		btnStart = new JButton("Start Application");
		btnStart.setPreferredSize(new Dimension(116, 30));
		btnStart.addActionListener(this);
		
		label_1 = new JLabel("");
		label_1.setPreferredSize(new Dimension(70, 1));
		getContentPane().add(label_1);
		
		getContentPane().add(btnStart);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String password = Util.toString(passwordField.getPassword());
		try {
			SQLConnection.checkConnection(password);
			JOptionPane.showMessageDialog(this, "Database connection established! Press ok to start the application.", "Connection Established", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			Main.start_Application(password);
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(this, "There was an error when accessing the JDBC driver! The erorr message is: "+e1.getMessage(), "Error in JDBC driver.", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, "Cannot connect to the database! Please make sure that you entered the correct root password. The erorr message is: "+e1.getMessage(), "Error in JDBC driver.", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
}
