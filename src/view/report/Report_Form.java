package view.report;

import java.awt.Frame;

import view.Form;

@SuppressWarnings("serial")
public class Report_Form extends Form {

	public Report_Form(Frame owner) {
		super(owner, true);
	}

	@Override
	public boolean verifyInput() {
		return false;
	}

}