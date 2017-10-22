package com.satya.javafx.rms.ui.custom;

import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * 
 * This is a footer node that horizontally places the context information.
 * 
 * @author Satyendra Sharma
 *
 */
public class Footer extends HBox {

	private Text footerText;
	private Text versionText;
	private String message;

	public Footer(String message) {
		super(10);
		this.message = message;
		configFooter();
	}

	private void configFooter() {
		footerText = new Text();
		footerText.setId("footer-text");
		footerText.setTextAlignment(TextAlignment.LEFT);
		footerText.setCache(true);
		footerText.setText(this.message);
		footerText.setFont(Font.font("Calibri", FontWeight.LIGHT, 10));

		versionText = new Text();
		versionText.setId("footer-version-text");
		versionText.setTextAlignment(TextAlignment.RIGHT);
		versionText.setCache(true);
		versionText.setText("v1.0");
		versionText.setFont(Font.font("sans-serif", FontWeight.THIN, 8));

		// Set the footer components in Horizontal order.
		this.getChildren().addAll(footerText, versionText);
		this.setMinWidth(400);
	}

	public void setMessage(String message) {
		footerText.setText(message);
	}
}
