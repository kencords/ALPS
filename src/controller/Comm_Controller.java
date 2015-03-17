package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.comm.Comm_Form;
import view.comm.Comm_Tab;
import model.comm.Comm_List;
import model.comm.Communication;

public class Comm_Controller implements ActionListener{
	
	Comm_List comm_list;
	Communication communication;
	Comm_Tab comm_tab;
	Comm_Form comm_form;
	
	public Comm_Controller() {
		comm_list = new Comm_List();
		communication = new Communication();
		comm_tab = new Comm_Tab();
		comm_form = new Comm_Form();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == comm_form.btnBrowse) {
			
		}
		
		else if(e.getSource() == comm_form.add) {
			
		}
		
		else if(e.getSource() == comm_form.cancel) {
			
		}
	}
}
