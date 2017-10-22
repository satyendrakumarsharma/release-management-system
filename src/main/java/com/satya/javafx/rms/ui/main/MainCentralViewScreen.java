package com.satya.javafx.rms.ui.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.satya.javafx.rms.ui.custom.Footer;
import com.satya.javafx.rms.ui.custom.Header;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Satyendra Sharma
 *
 */
public class MainCentralViewScreen extends Scene implements MainCentralView {

	private BorderPane root;

	private Header header = new Header("Release Management System");
	private Footer footer = new Footer("Ready");

	private List<RadioButton> envBtns = Collections.emptyList();
	private TextField snapshotPath;
	private Button snapshotBrowse;

	public MainCentralViewScreen(BorderPane root, double width, double height) {
		super(root, width, height);
		this.root = root;
	}

	@Override
	public void buildScreen(String[] enviroments) {
		root.setPadding(new Insets(10));
		root.setId("main-central-view");
		// this.getStylesheets().add(getClass().getClassLoader().getResource("css/application.css").getPath());

		ToggleGroup envGrp = new ToggleGroup();
		List<String> envList = Arrays.asList(enviroments);
		envBtns = envList.stream().map(e -> {
			RadioButton rBtn = new RadioButton(e);
			rBtn.setToggleGroup(envGrp);
			rBtn.setUserData(e);
			return rBtn;
		}).collect(Collectors.toList());

		HBox envRadioBox = new HBox(5);
		Label envLabel = new Label("Select Environment: ");
		envRadioBox.getChildren().add(envLabel);
		envBtns.forEach(b -> envRadioBox.getChildren().add(b));

		HBox snapshotBox = new HBox(5);
		Label snapshotLabel = new Label("Select the path for snapshot");
		snapshotPath = new TextField();
		snapshotBrowse = new Button("Browse...");
		snapshotBox.getChildren().addAll(snapshotLabel, snapshotPath, snapshotBrowse);

		Image runImg = new Image(getClass().getClassLoader().getResourceAsStream("img/green-play.png"), 20, 20, true,
				true);
		Button runBtn = new Button("Run", new ImageView(runImg));
		runBtn.alignmentProperty().setValue(Pos.BOTTOM_CENTER);
		runBtn.setOnAction(e -> {
			footer.setMessage("In Progres...");
		});

		VBox centralForm = new VBox(5);
		centralForm.getChildren().addAll(envRadioBox, snapshotBox, runBtn);
		centralForm.setId("central-form");
		centralForm.setPadding(new Insets(30, 20, 20, 20));

		// place the nodes in layout.
		root.setTop(header);
		root.setBottom(footer);
		root.setCenter(centralForm);
	}

}
