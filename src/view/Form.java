package view;

import javax.swing.JButton;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public abstract class Form extends JDialog{
	
	protected JButton btnAdd, btnCancel;
	
	public Form() {
		
		btnAdd = new JButton();
		btnCancel = new JButton();
		
		setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public abstract void verifyInput();
}