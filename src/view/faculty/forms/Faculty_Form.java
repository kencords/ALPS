package view.faculty.forms;

import java.awt.Frame;

import view.Form;

@SuppressWarnings("serial")
public class Faculty_Form extends Form {

	public Faculty_Form(Frame owner) {
		super(owner, true);
	}

	@Override
	public boolean verifyInput() {
		return false;
	}

}
