package view;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class UserProfile_Form extends Form {
	public JLabel lblUsername;

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
	}
	
	@Override
	public void verifyInput() {

	}
}
