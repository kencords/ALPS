package view.comm;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import view.Form;

import java.awt.Font;

@SuppressWarnings("serial")
public class Comm_Form extends Form {

	public JTextField tfFilePath, tfSender, tfTitle;
	public JRadioButton rdbtnIncoming, rdbtnOutgoing;
	public JButton btnBrowse, add, cancel;
	
	JLabel lblTitle, lblSender, lblUpload;
	ButtonGroup grp;
	
	public Comm_Form() {
		super();
		initComponents();
		addComponents();
		
		setFormLayout();
	}
	
	private void setFormLayout() {
		setTitle("A.L.P.S - Add Communication");
		setSize(300, 220);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(false);
	}

	private void addComponents() {
		getContentPane().add(lblTitle);
		getContentPane().add(tfTitle);
		getContentPane().add(rdbtnIncoming);
		getContentPane().add(rdbtnOutgoing);
		
		grp.add(rdbtnIncoming);
		grp.add(rdbtnOutgoing);
		
		getContentPane().add(lblSender);
		getContentPane().add(tfSender);
		
		getContentPane().add(lblUpload);
		getContentPane().add(tfFilePath);
		getContentPane().add(btnBrowse);
		
		/*getContentPane().add(btnAdd);
		getContentPane().add(btnCancel);*/
		
		getContentPane().add(add);
		getContentPane().add(cancel);
	}

	private void initComponents() {
		lblTitle = new JLabel();
		lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblTitle.setText("Title:");
		lblTitle.setBounds(10, 13, 39, 23);
		tfTitle = new JTextField();
		tfTitle.setBounds(45, 13, 239, 24);
		
		rdbtnIncoming = new JRadioButton();
		rdbtnIncoming.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		rdbtnIncoming.setText("Incoming");
		rdbtnIncoming.setBounds(76, 44, 71, 23);
		rdbtnOutgoing = new JRadioButton();
		rdbtnOutgoing.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		rdbtnOutgoing.setText("Outgoing");
		rdbtnOutgoing.setBounds(170, 44, 83, 23);
		grp = new ButtonGroup();
		
		lblSender = new JLabel();
		lblSender.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblSender.setText("Sender/Receiver:");
		lblSender.setBounds(10, 72, 104, 23);
		tfSender = new JTextField();
		tfSender.setBounds(107, 74, 177, 24);
		

		lblUpload = new JLabel();
		lblUpload.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblUpload.setText("Upload File:");
		lblUpload.setBounds(10, 110, 71, 23);
		tfFilePath = new JTextField();
		tfFilePath.setBounds(83, 110, 128, 24);
		
		btnBrowse = new JButton();
		btnBrowse.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		btnBrowse.setText("Browse");
		btnBrowse.setBounds(213, 110, 71, 24);
		
		/*btnAdd.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		btnAdd.setText("ADD");
		btnAdd.setBounds(67, 156, 71, 26);
		
		btnCancel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		btnCancel.setText("CANCEL");
		btnCancel.setBounds(148, 156, 93, 26); */
		
		add=new JButton();
		add.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		add.setText("ADD");
		add.setBounds(67, 156, 71, 26);
		
		cancel=new JButton();
		cancel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		cancel.setText("CANCEL");
		cancel.setBounds(148, 156, 93, 26);
	}

	@Override
	public void verifyInput() {
		
	}
}