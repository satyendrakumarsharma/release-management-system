package com.satya.javafx.rms.ui.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.satya.javafx.rms.ui.custom.Footer;
import com.satya.javafx.rms.ui.custom.Header;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * @author Satyendra Sharma
 *
 */
public class MainCentralViewScreen extends Scene implements MainCentralView {

	private BorderPane root;

	private Header header = new Header("Release Management System");
	private Footer footer = new Footer("Ready");

	private List<RadioButton> envBtns = Collections.emptyList();

	public MainCentralViewScreen(BorderPane root, double width, double height) {
		super(root, width, height);
		this.root = root;
	}

	@Override
	public void buildScreen(String[] enviroments) {
		root.setPadding(new Insets(10));
		root.setId("main-central-view");

		ToggleGroup envGrp = new ToggleGroup();
		List<String> envList = Arrays.asList(enviroments);
		envBtns = envList.stream().map(e -> {
			RadioButton rBtn = new RadioButton(e);
			rBtn.setToggleGroup(envGrp);
			return rBtn;
		}).collect(Collectors.toList());

		HBox form = new HBox(5);
		Label envLabel = new Label("Select Environment: ");
		form.getChildren().add(envLabel);
		envBtns.forEach(b -> form.getChildren().add(b));

		// place the nodes in layout.
		root.setTop(header);
		root.setBottom(footer);
		root.setCenter(form);
	}

}
