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
	public JPanel userPanel;
	public Component verticalStrut;
	public JLabel lblNewLabel;
	public JLabel lblDnsmPersonnel;
	public JButton btnEdit;
	public Component horizontalStrut;
	public JButton btnLogout;
	public Component rigidArea;
	public Component rigidArea_1;
	public JSeparator separator;
	public JLabel lblJlabel;
	public JButton btnHelp;
	public JButton btnAbout;
	public JPanel panel;
	
	public Home_Frame(){
		super();
		initGUI();
	}
	private void initGUI() {
		setSize(new Dimension(800, 500));
		setLocationRelativeTo(null);
		setTitle("A.L.P.S.");
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 554, 425);
		getContentPane().add(tabbedPane);
		
		userPanel = new JPanel();
		userPanel.setBounds(567, 0, 202, 494);
		getContentPane().add(userPanel);
		
		verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(100, 40));
		userPanel.add(verticalStrut);
		
		lblNewLabel = new JLabel("Ate Lainee");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setPreferredSize(new Dimension(200, 25));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		userPanel.add(lblNewLabel);
		
		lblDnsmPersonnel = new JLabel("DNSM Personnel");
		lblDnsmPersonnel.setPreferredSize(new Dimension(200, 25));
		lblDnsmPersonnel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblDnsmPersonnel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDnsmPersonnel.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
		userPanel.add(lblDnsmPersonnel);
		
		rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(200, 15));
		userPanel.add(rigidArea);
		
		btnEdit = new JButton("edit");
		btnEdit.setPreferredSize(new Dimension(70, 50));
		userPanel.add(btnEdit);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(15, 0));
		userPanel.add(horizontalStrut);
		
		btnLogout = new JButton("logout");
		btnLogout.setPreferredSize(new Dimension(70, 50));
		userPanel.add(btnLogout);
		
		rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(200, 215));
		userPanel.add(rigidArea_1);
		
		lblJlabel = new JLabel("Copyright 2015");
		userPanel.add(lblJlabel);
		lblJlabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(180, 2));
		userPanel.add(separator);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 30));
		userPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAbout = new JButton("About");
		btnAbout.setOpaque(false);
		panel.add(btnAbout);
		
		btnHelp = new JButton("Help");
		btnHelp.setOpaque(false);
		panel.add(btnHelp);
	}
	
	/**
	 * show the home frame and set its values depending on the user
	 * @param user
	 */
	public void showFrame(User user) {
		setVisible(true);
	}
}
