package com.satya.javafx.rms;

import com.satya.javafx.rms.properties.CommandProperty;
import com.satya.javafx.rms.properties.DatabaseProperty;
import com.satya.javafx.rms.properties.SecurityProperty;

/**
 * This is the starting point of the RMS application.
 * 
 * @author Satyendra Sharma
 *
 */
public class ReleaseManagementSystem {

	public static void main(String[] args) {
		// Setup Application Security Configurations.
		SecurityProperty.getInstance();

		// Setup Database Configurations.
		DatabaseProperty.getInstance();

		// Setup Command Configurations.
		CommandProperty.getInstance();

		// Setup Application Controller.
		AppController.start(args);

	}
}