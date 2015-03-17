package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.SQLConnection;
import view.Database_Password;
import controller.Home_Controller;

public class Main {
	public static Home_Controller homeControl;
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		new Database_Password();
	}

	public static void start_Application(String dbPassword){
		SQLConnection.password = dbPassword;
		homeControl = new Home_Controller();
	}
}