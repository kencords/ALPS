package view.comm;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class Comm_Tab extends JPanel{
	
	JTextField tfSearch;
	JButton btnSearch, btnAdd;
	JTable tblSearch;

	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	
	public Comm_Tab() {
		super();
		
		initComponents();
		addComponents();
	       
		setPanelLayout();
	}

	private void setPanelLayout() {
		setLayout(null);
		setSize(650, 450);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 630, 386);
		add(scrollPane);
		
		tblSearch = new JTable();
		tblSearch.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Action", "Title", "Date", "Type", "Sender/Receiver", "File"
			}
		));
		tblSearch.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		TableCellRenderer rendererFromHeader = tblSearch.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		
		scrollPane.setViewportView(tblSearch);
		
		setVisible(false);
	}

	private void addComponents() {
		add(comboBox);
		add(tfSearch);
		add(btnSearch);
		add(btnAdd);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All"}));
		comboBox.setEditable(true);
		comboBox.setBounds(10, 11, 112, 30);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(132, 11, 327, 30);
		
		btnSearch = new JButton();
		btnSearch.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		btnSearch.setText("Search");
		btnSearch.setBounds(469, 11, 84, 30);
		
		btnAdd = new JButton();
		btnAdd.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		btnAdd.setText("Add");
		btnAdd.setBounds(563, 11, 77, 30);
	}
	
	public void show() {
		setVisible(true);
	}
}