package view;

import javax.swing.JFrame;

import view.comm.Comm_Tab;
import view.faculty.Faculty_Tab;
import view.report.Report_Tab;

import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;

import model.User;

import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class Home_Frame extends JFrame {
	Faculty_Tab facultyTab;
	Report_Tab reportTab;
	Comm_Tab commTab;
	
	public JTabbedPane tabbedPane;
	public JPanel accountsPanel;
	public Component verticalStrut;
	public JLabel lblNameLabel;
	public JLabel lblDivisionPersonnel;
	public JButton btnEdit;
	public Component horizontalStrut;
	public JButton btnLogout;
	public Component rigidArea;
	public Component rigidArea_1;
	public JSeparator separator;
	public JLabel lblCopyright;
	public JButton btnHelp;
	public JButton btnAbout;
	public JPanel panel;
	
	public Home_Frame(){
		super();
		initGUI();
	}
	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(800, 500));
		setLocationRelativeTo(null);
		setTitle("A.L.P.S.");
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 554, 425);
		getContentPane().add(tabbedPane);
		
		accountsPanel = new JPanel();
		accountsPanel.setBounds(567, 0, 202, 494);
		getContentPane().add(accountsPanel);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(100, 40));
		accountsPanel.add(verticalStrut);
		
		lblNameLabel = new JLabel("Ate Lainee");
		lblNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNameLabel.setPreferredSize(new Dimension(200, 25));
		lblNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		accountsPanel.add(lblNameLabel);
		
		lblDivisionPersonnel = new JLabel("DNSM Personnel");
		lblDivisionPersonnel.setPreferredSize(new Dimension(200, 25));
		lblDivisionPersonnel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDivisionPersonnel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDivisionPersonnel.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		accountsPanel.add(lblDivisionPersonnel);
		
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(200, 15));
		accountsPanel.add(rigidArea);
		
		btnEdit = new JButton("edit");
		btnEdit.setPreferredSize(new Dimension(70, 50));
		accountsPanel.add(btnEdit);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(15, 0));
		accountsPanel.add(horizontalStrut);
		
		btnLogout = new JButton("logout");
		btnLogout.setPreferredSize(new Dimension(70, 50));
		accountsPanel.add(btnLogout);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(200, 215));
		accountsPanel.add(rigidArea_1);
		
		lblCopyright = new JLabel("Copyright 2015");
		accountsPanel.add(lblCopyright);
		lblCopyright.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(180, 2));
		accountsPanel.add(separator);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 30));
		accountsPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAbout = new JButton("About");
		btnAbout.setOpaque(false);
		panel.add(btnAbout);
		
		btnHelp = new JButton("Help");
		btnHelp.setOpaque(false);
		panel.add(btnHelp);
		
		setUserInfo("Ate Lainee", "DNSM Personnel");
		
	}
	
	private void setUserInfo(String name, String divisionPersonnel) {
		lblNameLabel.setText(name);
		lblDivisionPersonnel.setText(divisionPersonnel);
	}
	/**
	 * show the home frame and set its values depending on the user
	 * @param user
	 */
	public void showFrame(User user) {
		setVisible(true);
	}
}
