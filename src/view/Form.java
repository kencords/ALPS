package view;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public abstract class Form extends JDialog{
	
	protected JButton btnAdd;
	public JButton btnCancel;
	
	public Form(Frame owner, boolean modal) {
		super(owner, modal);
		
		btnAdd = new JButton("Add");
		btnCancel = new JButton("Cancel");
		
		setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * verify the inputs in the form if the inputs are correct. if the inputs are correct, the method will return true otherwise false
	 * @return
	 */
	public abstract boolean verifyInput();
}