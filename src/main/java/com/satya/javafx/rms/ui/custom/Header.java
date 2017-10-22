package com.satya.javafx.rms.ui.custom;

import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * This is a header node that horizontally places a header image and header
 * title.
 * 
 * @author Satyendra Sharma
 *
 */
public class Header extends HBox {

	private ImageView headerImg;
	private Text headerText;
	private String title;

	public Header(String title) {
		super(10);
		this.title = title;
		configHeader();
	}

	private void configHeader() {

		Image image = new Image(getClass().getClassLoader().getResourceAsStream("img/macquarie-logo-small.jpg"), 60, 60,
				true, true);
		headerImg = new ImageView(image);
		headerImg.setId("header-img");

		// DropShadow ds = new DropShadow();
		// ds.setOffsetY(3.0f);
		// ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

		Reflection ref = new Reflection();
		ref.setFraction(0.5f);

		headerText = new Text();
		headerText.setId("header-text");
		headerText.setTextAlignment(TextAlignment.CENTER);
		headerText.setEffect(ref);
		headerText.setCache(true);
		headerText.setY(50.0f);
		headerText.setFill(Color.BURLYWOOD);
		headerText.setFontSmoothingType(FontSmoothingType.LCD);
		headerText.setText(this.title);
		headerText.setFont(Font.font("Candara", FontWeight.BOLD, 28));

		// Set the header components in Horizontal order.
		this.getChildren().addAll(headerImg, headerText);

	}

}
